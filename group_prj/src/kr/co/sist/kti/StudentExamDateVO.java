package kr.co.sist.kti;

import java.util.Date;

public class StudentExamDateVO {

	private int examNum;
	private String examName;
	private Date examDate;

	public StudentExamDateVO(int examNum, String examName, Date examDate) {
		super();
		this.examNum = examNum;
		this.examName = examName;
		this.examDate = examDate;
	}

	public StudentExamDateVO() {
		super();
	}

	public int getExamNum() {
		return examNum;
	}

	public void setExamNum(int examNum) {
		this.examNum = examNum;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "StudentExamDateVO [examNum=" + examNum + ", examName=" + examName + ", examDate=" + examDate + "]";
	}

}
