package kr.co.sist.yj;

import java.sql.Date;

public class AdminAccountStudentAccountModifyVO {

	private String stu_num;
	private String stu_name;
	private String stu_pass;
	private Date stu_birth;
	private String stu_tel;
	private String stu_add;
//	private String cour_name;
//	private String inst_name;
//	private Date cour_startdate;
//	private Date cour_enddate;
	private String stu_status;
//	private String cour_cardinal;
	
	public AdminAccountStudentAccountModifyVO() {
		super();
	} //AdminAccountStudentAccountModifyVO

	public AdminAccountStudentAccountModifyVO(String stu_num, String stu_name, String stu_pass, Date stu_birth,
			String stu_tel, String stu_add, String stu_status) {
		super();
		this.stu_num = stu_num;
		this.stu_name = stu_name;
		this.stu_pass = stu_pass;
		this.stu_birth = stu_birth;
		this.stu_tel = stu_tel;
		this.stu_add = stu_add;
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

	public String getStu_pass() {
		return stu_pass;
	}

	public void setStu_pass(String stu_pass) {
		this.stu_pass = stu_pass;
	}

	public Date getStu_birth() {
		return stu_birth;
	}

	public void setStu_birth(Date stu_birth) {
		this.stu_birth = stu_birth;
	}

	public String getStu_tel() {
		return stu_tel;
	}

	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}

	public String getStu_add() {
		return stu_add;
	}

	public void setStu_add(String stu_add) {
		this.stu_add = stu_add;
	}

	public String getStu_status() {
		return stu_status;
	}

	public void setStu_status(String stu_status) {
		this.stu_status = stu_status;
	}

	@Override
	public String toString() {
		return "AdminAccountStudentAccountModifyVO [stu_num=" + stu_num + ", stu_name=" + stu_name + ", stu_pass="
				+ stu_pass + ", stu_birth=" + stu_birth + ", stu_tel=" + stu_tel + ", stu_add=" + stu_add
				+ ", stu_status=" + stu_status + "]";
	} //toString
	
} //class
