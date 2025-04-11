package kr.co.sist.yj;

import java.sql.Date;

public class AdminExamVO {
	
	private int examNum;
	private String examName;
	private Date examDate;
	
	private int courNum;
	private String courName;
	
	private String instName;

	
	public AdminExamVO() {
		super();
	}

	public AdminExamVO(int examNum, String examName, Date examDate, int courNum, String courName, String instName) {
		super();
		this.examNum = examNum;
		this.examName = examName;
		this.examDate = examDate;
		this.courNum = courNum;
		this.courName = courName;
		this.instName = instName;
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

	public int getCourNum() {
		return courNum;
	}

	public void setCourNum(int courNum) {
		this.courNum = courNum;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	@Override
	public String toString() {
		return "AdminExamVO [examNum=" + examNum + ", examName=" + examName + ", examDate=" + examDate + ", courNum="
				+ courNum + ", courName=" + courName + ", instName=" + instName + "]";
	}
	
	
	
}
