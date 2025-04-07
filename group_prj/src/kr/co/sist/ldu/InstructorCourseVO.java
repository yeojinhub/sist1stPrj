package kr.co.sist.ldu;

import java.sql.Date;
import java.util.List;

public class InstructorCourseVO {

	private int courNum;
	private String courCardinal;
	private String courName;
	private String courStatus;
	private Date courStartDate;
	private Date courEndDate;
	private String instNum;
	private String instName;
	private List<String> examName;

	public InstructorCourseVO(int courNum, String courCardinal, String courName, String courStatus, Date courStartDate,
			Date courEndDate, String instNum, String instName, List<String> examName) {
		this.courNum = courNum;
		this.courCardinal = courCardinal;
		this.courName = courName;
		this.courStatus = courStatus;
		this.courStartDate = courStartDate;
		this.courEndDate = courEndDate;
		this.instNum = instNum;
		this.instName = instName;
		this.examName = examName;
	}// StudentCourseVO

	// Getter, Setter Method
	public InstructorCourseVO() {
		super();
	}

	public List<String> getExamName() {
		return examName;
	}

	public void setExamName(List<String> examName) {
		this.examName = examName;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public int getCourNum() {
		return courNum;
	}

	public void setCourNum(int courNum) {
		this.courNum = courNum;
	}

	public String getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public String getCourStatus() {
		return courStatus;
	}

	public void setCourStatus(String courStatus) {
		this.courStatus = courStatus;
	}

	public Date getCourStartDate() {
		return courStartDate;
	}

	public void setCourStartDate(Date courStartDate) {
		this.courStartDate = courStartDate;
	}

	public Date getCourEndDate() {
		return courEndDate;
	}

	public void setCourEndDate(Date courEndDate) {
		this.courEndDate = courEndDate;
	}

	public String getInstNum() {
		return instNum;
	}

	public void setInstNum(String instNum) {
		this.instNum = instNum;
	}

	@Override
	public String toString() {
		return "StudentMainVO [courNum=" + courNum + ", courCardinal=" + courCardinal + ", courName=" + courName
				+ ", courStatus=" + courStatus + ", courStartDate=" + courStartDate + ", courEndDate=" + courEndDate
				+ ", instNum=" + instNum + ", instName=" + instName + ", examName=" + examName + "]";
	}

}// class
