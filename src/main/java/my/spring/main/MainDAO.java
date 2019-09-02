package my.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "MainDAO")
@SuppressWarnings("all")
public class MainDAO {

	public MainDAO() {
	}

	public ArrayList<MainVO> test(SqlSessionTemplate session) {
		List<?> list = session.selectList("main.selectAll");
		return (ArrayList<MainVO>) list;
	}

}
