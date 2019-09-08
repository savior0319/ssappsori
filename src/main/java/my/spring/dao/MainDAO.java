package my.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;

@Repository(value = "MainDAO")
@SuppressWarnings("all")
public class MainDAO {

	public MainDAO() {
	}

	public ArrayList<MainVO> test(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectAll");
		return (ArrayList<MainVO>) list;
	}

	public ArrayList<BoardVO> selectBoardList(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectBoardList");
		return (ArrayList<BoardVO>) list;
	}

}
