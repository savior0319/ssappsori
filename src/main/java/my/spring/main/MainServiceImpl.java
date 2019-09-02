package my.spring.main;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
