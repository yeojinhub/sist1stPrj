package kr.co.sist.yj;

public class AdminAccountStudentAccountVO {
	
	private String stu_num;
	private String stu_name;
	private String stu_tel;
	private String cour_cardinal;
	private String cour_name;
	private String stu_status;
	
	public AdminAccountStudentAccountVO() {
		super();
	}

	public AdminAccountStudentAccountVO(String stu_num, String stu_name, String stu_tel, String cour_cardinal,
			String cour_name, String stu_status) {
		super();
		this.stu_num = stu_num;
		this.stu_name = stu_name;
		this.stu_tel = stu_tel;
		this.cour_cardinal = cour_cardinal;
		this.cour_name = cour_name;
		this.stu_status = stu_status;
	}

	public String getStu_num() {
		return stu_num;
	}



	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}



	public String getStu_name() {
		return stu_name;
	}


	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}


	public String getStu_tel() {
		return stu_tel;
	}


	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}


	public String getCour_cardinal() {
		return cour_cardinal;
	}


	public void setCour_cardinal(String cour_cardinal) {
		this.cour_cardinal = cour_cardinal;
	}


	public String getCour_name() {
		return cour_name;
	}


	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}


	public String getStu_status() {
		return stu_status;
	}


	public void setStu_status(String stu_status) {
		this.stu_status = stu_status;
	}

	@Override
	public String toString() {
		return "AdminAccountStudentAccountVO [stu_num=" + stu_num + ", stu_name=" + stu_name + ", stu_tel=" + stu_tel
				+ ", cour_cardinal=" + cour_cardinal + ", cour_name=" + cour_name + ", stu_status=" + stu_status + "]";
	}

} //class
