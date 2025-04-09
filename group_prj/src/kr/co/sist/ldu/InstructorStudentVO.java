package kr.co.sist.ldu;

public class InstructorStudentVO {
	private String courCardinal;
    private String studName;
    private String courName;
    private String stuStatus;
    private String studTel;
    private String studNum;
    
	public InstructorStudentVO() {
	}
	
	
	public InstructorStudentVO(String courCardinal, String studName, String courName, String stuStatus, String studTel, String studNum) {
		this.courCardinal = courCardinal;
		this.studName = studName;
		this.courName = courName;
		this.stuStatus = stuStatus;
		this.studTel = studTel;
		this.studNum = studNum;
	}


	public String getCourCardinal() {
		return courCardinal;
	}
	public String getStudName() {
		return studName;
	}
	public String getCourName() {
		return courName;
	}
	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public void setCourName(String courName) {
		this.courName = courName;
	}
	public String getStudTel() {
		return studTel;
	}
	public void setStudTel(String studTel) {
		this.studTel = studTel;
	}


	public String getStuStatus() {
		return stuStatus;
	}


	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}


	public String getStudNum() {
		return studNum;
	}


	public void setStudNum(String studNum) {
		this.studNum = studNum;
	}
	
}


