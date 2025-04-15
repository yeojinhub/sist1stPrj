package kr.co.sist.yj;

public class AdminCourseVO {

	private int courNum;
	private String courCardinal;
	private String courName;
	private String courStatus;
	private String courStartdate;
	private String courEnddate;
	private String instNum;
	private String instName;

	public AdminCourseVO(int courNum, String courCardinal, String courName, String courStatus, String courStartdate,
			String courEnddate, String instNum, String instName) {
		super();
		this.courNum = courNum;
		this.courCardinal = courCardinal;
		this.courName = courName;
		this.courStatus = courStatus;
		this.courStartdate = courStartdate;
		this.courEnddate = courEnddate;
		this.instNum = instNum;
		this.instName = instName;
	}

	public AdminCourseVO() {
		super();
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

	public String getCourStartdate() {
		return courStartdate;
	}

	public void setCourStartdate(String courStartdate) {
		this.courStartdate = courStartdate;
	}

	public String getCourEnddate() {
		return courEnddate;
	}

	public void setCourEnddate(String courEnddate) {
		this.courEnddate = courEnddate;
	}

	public String getInstNum() {
		return instNum;
	}

	public void setInstNum(String instNum) {
		this.instNum = instNum;
	}

	@Override
	public String toString() {
		return "AdminCourseVO [courNum=" + courNum + ", courCardinal=" + courCardinal + ", courName=" + courName
				+ ", courStatus=" + courStatus + ", courStardate=" + courStartdate + ", courEnddate=" + courEnddate
				+ ", instNum=" + instNum + ", instName=" + instName + "]";
	}
	
}
