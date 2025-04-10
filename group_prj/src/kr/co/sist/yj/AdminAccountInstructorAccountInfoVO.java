package kr.co.sist.yj;

import java.sql.Date;

public class AdminAccountInstructorAccountInfoVO {
	private String instNum;
	private String instPass;
	private String instName;
	private Date instBirth;
	private String instTel;
	private String instAdd;
	
	public AdminAccountInstructorAccountInfoVO() {
		super();
	}

	public AdminAccountInstructorAccountInfoVO(String instNum, String instPass, String instName, Date instBirth,
			String instTel, String instAdd) {
		super();
		this.instNum = instNum;
		this.instPass = instPass;
		this.instName = instName;
		this.instBirth = instBirth;
		this.instTel = instTel;
		this.instAdd = instAdd;
	}

	public String getInstNum() {
		return instNum;
	}

	public void setInstNum(String instNum) {
		this.instNum = instNum;
	}

	public String getInstPass() {
		return instPass;
	}

	public void setInstPass(String instPass) {
		this.instPass = instPass;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public Date getInstBirth() {
		return instBirth;
	}

	public void setInstBirth(Date instBirth) {
		this.instBirth = instBirth;
	}

	public String getInstTel() {
		return instTel;
	}

	public void setInstTel(String instTel) {
		this.instTel = instTel;
	}

	public String getInstAdd() {
		return instAdd;
	}

	public void setInstAdd(String instAdd) {
		this.instAdd = instAdd;
	}

	@Override
	public String toString() {
		return "AdminAccountInstructorAccountInfoVO [instNum=" + instNum + ", instPass=" + instPass + ", instName="
				+ instName + ", instBirth=" + instBirth + ", instTel=" + instTel + ", instAdd=" + instAdd + "]";
	}

} //class
