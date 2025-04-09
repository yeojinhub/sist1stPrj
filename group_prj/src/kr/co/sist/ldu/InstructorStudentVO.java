package kr.co.sist.ldu;

public class InstructorStudentVO {
	private String courCardinal;
    private String studName;
    private String courName;
    private String stuStatus;
    
	public InstructorStudentVO() {
	}
	
	
	public InstructorStudentVO(String courCardinal, String studName, String courName, String stuStatus) {
		this.courCardinal = courCardinal;
		this.studName = studName;
		this.courName = courName;
		this.stuStatus = stuStatus;
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
	public String getCourStatus() {
		return stuStatus;
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
	public void setCourStatus(String courStatus) {
		this.stuStatus = courStatus;
	}
	
}


