package my.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;
import my.spring.vo.PageDataVO;

@Repository(value = "MainDAO")
@SuppressWarnings("all")
public class MainDAO {

	public MainDAO() {
	}

	public ArrayList<MainVO> test(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectAll");
		return (ArrayList<MainVO>) list;
	}

	// 게시판 페이지
	public ArrayList<BoardVO> getPage(SqlSessionTemplate session, int page, int recordCountPerPage) {
		PageDataVO pDataVo = new PageDataVO();

		int start = page * recordCountPerPage - (recordCountPerPage - 1);
		int end = page * recordCountPerPage;

		pDataVo.setStart(start);
		pDataVo.setEnd(end);

		List<BoardVO> list = session.selectList("main.getPage", pDataVo);

		return (ArrayList<BoardVO>) list;
	}

	// 게시판 네비게이션
	public String getPageNavi(SqlSessionTemplate session, int page, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = 0;

		recordTotalCount = session.selectOne("main.count");

		int pageTotalCount = 0;

		if (recordTotalCount % recordCountPerPage != 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else
			pageTotalCount = recordTotalCount / recordCountPerPage;

		if (page < 1) {
			page = 1;
		} else if (page > pageTotalCount) {
			page = pageTotalCount;
		}

		int startNavi = ((page - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true, needNext = true;

		if (startNavi == 1) {
			needPrev = false;
		}

		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\'ui pagination menu\'>");

		if (needPrev) {
			sb.append("<a class='item' href='/board.ssap?page=" + (startNavi - 1) + "'> < </a>");
		}

		for (int i = startNavi; i <= endNavi; i++) {
			if (i == page) {
				sb.append(
						"<a class='active item' style='background: rgba(250, 40, 40); color:white;' href='/board.ssap?page="
								+ i + "'>  " + i + " </a>");
			} else {
				sb.append("<a class='item' href='/board.ssap?page=" + i + "'>" + i + " </a>");
			}
		}

		if (needNext) {
			sb.append("<a class='item' href='/board.ssap?page=" + (endNavi + 1) + "'> > </a>");
		}

		sb.append("</div>");

		return sb.toString();
	}

	// 글 선택 보기
	public BoardVO selectBoardContent(SqlSessionTemplate session, int index) {
		return session.selectOne("main.selectBoardContent", index);
	}

}
