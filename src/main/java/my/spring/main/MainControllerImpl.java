package my.spring.main;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainControllerImpl implements MainController {

	@Resource(name = "MainService")
	MainService mService;

	public MainControllerImpl() {
	}

	@RequestMapping(value = "test.do", method = RequestMethod.GET)
	public String test() {
		ArrayList<MainVO> aList = mService.test();

		System.out.println("부서번호");

		for (MainVO list : aList) {
			System.out.println(list.getEmpId());
		}
		return "redirect:/";
	}

}
