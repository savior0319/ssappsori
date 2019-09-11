package my.spring.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.spring.dao.MainDAO;
import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;
import my.spring.vo.PageDataVO;

@Service(value = "MainService")
public class MainServiceImpl implements MainService {

	@Resource(name = "MainDAO")
	MainDAO mdDao;

	@Autowired
	SqlSessionTemplate session;

	public MainServiceImpl() {
	}

	@Override
	public ArrayList<MainVO> test() {
		return mdDao.test(session);
	}

	// 게시판 리스트
	@Override
	public PageDataVO selectBoardList(int page) {

		int recordCountPerPage = 25;

		int naviCountPerPage = 5;

		ArrayList<BoardVO> aList = mdDao.getPage(session, page, recordCountPerPage);

		String pageNavi = mdDao.getPageNavi(session, page, recordCountPerPage, naviCountPerPage);

		PageDataVO pd = null;

		if (!aList.isEmpty() && !pageNavi.isEmpty()) {
			pd = new PageDataVO();
			pd.setArrayList(aList);
			pd.setPageNavi(pageNavi);
		}
		return pd;

	}

	// 글 선택 보기
	@Override
	public BoardVO selectBoardContent(int index) {
		return mdDao.selectBoardContent(session, index);
	}

	// 게시판 글 저장
	@Override
	public int insertBoardContent(BoardVO bv) {
		return mdDao.insertBoardContent(session, bv);
	}

}
