package my.spring.service;

import java.util.ArrayList;

import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;

public interface MainService {

	public ArrayList<MainVO> test();

	public ArrayList<BoardVO> selectBoardList();

}
