package my.spring.vo;

import java.util.ArrayList;

public class PageDataVO {
	
	private String pageNavi;
	private int start, end;
	private ArrayList<BoardVO> arrayList;
	
	/**
	 * @return the arrayList
	 */
	public ArrayList<BoardVO> getArrayList() {
		return arrayList;
	}
	/**
	 * @param arrayList the arrayList to set
	 */
	public void setArrayList(ArrayList<BoardVO> arrayList) {
		this.arrayList = arrayList;
	}
	/**
	 * @return the pageNavi
	 */
	public String getPageNavi() {
		return pageNavi;
	}
	/**
	 * @param pageNavi the pageNavi to set
	 */
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

}
