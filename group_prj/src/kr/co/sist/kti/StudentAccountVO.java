package kr.co.sist.kti;

import java.sql.Date;

public class StudentAccountVO {

	private String stuNum;
	private String stuPass;
	private String stuName;
	private Date stuBirth;
	private String stuTel;
	private String stuAdd;
	private String stuStatus;

	public StudentAccountVO(String stuNum, String stuPass, String stuName, Date stuBirth, String stuTel, String stuAdd, String stuStatus) {
		this.stuNum = stuNum;
		this.stuPass = stuPass;
		this.stuName = stuName;
		this.stuBirth = stuBirth;
		this.stuTel = stuTel;
		this.stuAdd = stuAdd;
		this.stuStatus = stuStatus;
	}// StudentAccountVO

	public StudentAccountVO() {
		super();
	}// StudentAccountVO

	
	// Getter, Setter Method
	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Date getStuBirth() {
		return stuBirth;
	}

	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuAdd() {
		return stuAdd;
	}

	public void setStuAdd(String stuAdd) {
		this.stuAdd = stuAdd;
	}

	public String getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	// toString Override
	@Override
	public String toString() {
		return "StudentAccountVO [stuNum=" + stuNum + ", stuPass=" + stuPass + ", stuName=" + stuName + ", stuBirth="
				+ stuBirth + ", stuTel=" + stuTel + ", stuAdd=" + stuAdd + ", stuStatus=" + stuStatus + "]";
	}// toString

}// class
