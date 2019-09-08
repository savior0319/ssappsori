package my.spring.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.spring.dao.MainDAO;
import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;

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

	@Override
	public ArrayList<BoardVO> selectBoardList() {
		return mdDao.selectBoardList(session);

	}

}
