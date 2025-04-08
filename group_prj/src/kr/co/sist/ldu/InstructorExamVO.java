package kr.co.sist.ldu;

import java.sql.Date;

public class InstructorExamVO {
	private String examName;      // 시험명
	private Date examDate;        // 시험 날짜
	private String examStatus;    // 오픈 / 종료
	private String courCardinal;  // 과정 기수 (필터용)
	private int courNum;          // 과정 번호 (조인용)

	public InstructorExamVO() {
	}

	public InstructorExamVO(String examName, Date examDate, String examStatus, String courCardinal, int courNum) {
		this.examName = examName;
		this.examDate = examDate;
		this.examStatus = examStatus;
		this.courCardinal = courCardinal;
		this.courNum = courNum;
	}

	// Getter & Setter
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

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public String getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}

	public int getCourNum() {
		return courNum;
	}

	public void setCourNum(int courNum) {
		this.courNum = courNum;
	}
}

