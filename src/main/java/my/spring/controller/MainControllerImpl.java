package my.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import my.spring.service.MainService;
import my.spring.vo.BoardVO;
import my.spring.vo.PageDataVO;

@Controller
public class MainControllerImpl implements MainController {

	@Resource(name = "MainService")
	MainService mService;

	public MainControllerImpl() {
	}

	/* 게시판 이미지 업로드 */
	@Override
	@RequestMapping(value = "/fileupload.ssap", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile)
			throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		if (file != null) {
			if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if (file.getContentType().toLowerCase().startsWith("image/")) {
					try {

						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						String uploadPath = req.getSession().getServletContext().getRealPath("/img");
						File uploadFile = new File(uploadPath);
						if (!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						fileName = file.getOriginalFilename() + UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);

						printWriter = resp.getWriter();
						resp.setContentType("text/html");
						String fileUrl = req.getContextPath() + "/img/" + fileName;

						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);

						printWriter.println(json);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
						if (printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
		return null;
	}

	/* 게시판 글 목록 */
	@Override
	@RequestMapping(value = "/board.ssap", method = RequestMethod.GET)
	public ModelAndView board(HttpServletRequest request) {

		int page;
		ModelAndView mv = new ModelAndView();

		if (request.getParameter("page") == null) {
			page = 1;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
		}

		PageDataVO pd = mService.selectBoardList(page);

		mv.setViewName("board");
		mv.addObject("boardList", pd);
		return mv;
	}

	// 글 선택 보기
	@Override
	@RequestMapping(value = "/boardcontent.ssap")
	public ModelAndView boardContent(int index) {

		BoardVO bVo = mService.selectBoardContent(index);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardcontent");
		mv.addObject("boardContent", bVo);

		return mv;
	}

	// 글 저장
	@Override
	@RequestMapping(value = "/boardsave.ssap", method = RequestMethod.POST)
	public ModelAndView boardSave(@RequestParam Map<String, Object> paraMap) {

		ModelAndView mv = new ModelAndView();

		if (paraMap.get("pwd").toString().equals("starboy")) {

			BoardVO bv = new BoardVO();
			int result = 0;

			bv.setSubject(paraMap.get("subject").toString());
			bv.setInsertId(paraMap.get("insertId").toString());
			bv.setContents(paraMap.get("content").toString());

			result = mService.insertBoardContent(bv);

			System.out.println(result);

			if (result > 0) {
				mv.setViewName("success");
			} else {
				mv.setViewName("fail");
			}

			return mv;
		} else {
			mv.setViewName("passwordfail");
			return mv;
		}
	}

}
