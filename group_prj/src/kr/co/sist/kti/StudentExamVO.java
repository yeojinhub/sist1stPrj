package kr.co.sist.kti;

import java.sql.Date;

public class StudentExamVO {

	private int quesNum;
	private String quesContent;
	private String quesOption;
	private int quesOptionCorrect;
	private int examNum;

	public StudentExamVO() {
	}

	public StudentExamVO(int quesNum, String quesContent, String quesOption, int quesOptionCorrect, int examNum) {
		this.quesNum = quesNum;
		this.quesContent = quesContent;
		this.quesOption = quesOption;
		this.quesOptionCorrect = quesOptionCorrect;
		this.examNum = examNum;
	}

	public int getQuesNum() {
		return quesNum;
	}

	public void setQuesNum(int quesNum) {
		this.quesNum = quesNum;
	}

	public String getQuesContent() {
		return quesContent;
	}

	public void setQuesContent(String quesContent) {
		this.quesContent = quesContent;
	}

	public String getQuesOption() {
		return quesOption;
	}

	public void setQuesOption(String quesOption) {
		this.quesOption = quesOption;
	}

	public int getQuesOptionCorrect() {
		return quesOptionCorrect;
	}

	public void setQuesOptionCorrect(int quesOptionCorrect) {
		this.quesOptionCorrect = quesOptionCorrect;
	}

	public int getExamNum() {
		return examNum;
	}

	public void setExamNum(int examNum) {
		this.examNum = examNum;
	}

	@Override
	public String toString() {
		return "StudentExamVO [quesNum=" + quesNum + ", quesContent=" + quesContent + ", quesOption=" + quesOption
				+ ", quesOptionCorrect=" + quesOptionCorrect + ", examNum=" + examNum + "]";
	}

}
