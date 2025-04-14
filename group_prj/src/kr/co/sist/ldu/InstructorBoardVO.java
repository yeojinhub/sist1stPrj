package kr.co.sist.ldu;

import java.sql.Date;

public class InstructorBoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardStatus;
	private Date boardDate;
	private String boardType;
	private String boardCommContent;
	private Date boardCommDate;
	private String stuNum;
	private String instNum;
	private String admId;
	private String stuName;
	private String instName;

	public InstructorBoardVO(int boardNum, String boardTitle, String boardContent, String boardStatus, Date boardDate,
			String boardType, String boardCommContent, Date boardCommDate, String stuNum, String instNum, String admId,
			String stuName, String instName) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardStatus = boardStatus;
		this.boardDate = boardDate;
		this.boardType = boardType;
		this.boardCommContent = boardCommContent;
		this.boardCommDate = boardCommDate;
		this.stuNum = stuNum;
		this.instNum = instNum;
		this.admId = admId;
		this.stuName = stuName;
		this.instName = instName;
	}

	public InstructorBoardVO() {
		super();
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardCommContent() {
		return boardCommContent;
	}

	public void setBoardCommContent(String boardCommContent) {
		this.boardCommContent = boardCommContent;
	}

	public Date getBoardCommDate() {
		return boardCommDate;
	}

	public void setBoardCommDate(Date boardCommDate) {
		this.boardCommDate = boardCommDate;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getInstNum() {
		return instNum;
	}

	public void setInstNum(String instNum) {
		this.instNum = instNum;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	@Override
	public String toString() {
		return "StudentBoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardStatus=" + boardStatus + ", boardDate=" + boardDate + ", boardType=" + boardType
				+ ", boardCommContent=" + boardCommContent + ", boardCommDate=" + boardCommDate + ", stuNum=" + stuNum
				+ ", instNum=" + instNum + ", admId=" + admId + ", stuName=" + stuName + ", instName=" + instName
				+ "]";
	}

}
