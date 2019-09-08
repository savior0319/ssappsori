package my.spring.vo;

import java.sql.Timestamp;

public class BoardVO {

	private String subject, contents, deleteYn, insertId, modifyId;
	private int boardNo;
	private Timestamp insertDate, modifyDate;

	public BoardVO() {
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the contents
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return the deleteYn
	 */
	public String getDeleteYn() {
		return deleteYn;
	}

	/**
	 * @param deleteYn the deleteYn to set
	 */
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	/**
	 * @return the insertId
	 */
	public String getInsertId() {
		return insertId;
	}

	/**
	 * @param insertId the insertId to set
	 */
	public void setInsertId(String insertId) {
		this.insertId = insertId;
	}

	/**
	 * @return the modifyId
	 */
	public String getModifyId() {
		return modifyId;
	}

	/**
	 * @param modifyId the modifyId to set
	 */
	public void setModifyId(String modifyId) {
		this.modifyId = modifyId;
	}

	/**
	 * @return the boardNo
	 */
	public int getBoardNo() {
		return boardNo;
	}

	/**
	 * @param boardNo the boardNo to set
	 */
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	/**
	 * @return the insertDate
	 */
	public Timestamp getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate the insertDate to set
	 */
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return the modifyDate
	 */
	public Timestamp getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

}
