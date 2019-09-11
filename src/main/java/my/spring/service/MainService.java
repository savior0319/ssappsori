package my.spring.service;

import java.util.ArrayList;

import my.spring.vo.BoardVO;
import my.spring.vo.MainVO;
import my.spring.vo.PageDataVO;

public interface MainService {

	public ArrayList<MainVO> test();

	public PageDataVO selectBoardList(int page);

	public BoardVO selectBoardContent(int index);

}
