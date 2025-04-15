package kr.co.sist.yj;

public class AdminCourseInstVO {
	
	private String instNum;
	private String instName;
	
	public AdminCourseInstVO() {
		super();
	}

	public AdminCourseInstVO(String instNum, String instName) {
		super();
		this.instNum = instNum;
		this.instName = instName;
	}
	
	public String getInstNum() {
		return instNum;
	}
	
	public void setInstNum(String instNum) {
		this.instNum = instNum;
	}
	
	public String getInstName() {
		return instName;
	}
	
	public void setInstName(String instName) {
		this.instName = instName;
	}

	@Override
	public String toString() {
		return "AdminCourseInstVO [instNum=" + instNum + ", instName=" + instName + "]";
	} //toString

} //class
