package kr.co.sist.yj;

import java.sql.Date;

public class AdminAccountStudentAccountInfoVO {
	
	private String stuNum;
	private String stuPass;
	private String stuName;
	private Date stuBirth;
	private String stuTel;
	private String stuAdd;
	private String stuStatus;
	
	private String courName;
	private String courCardinal;
	
	private String instName;

	public AdminAccountStudentAccountInfoVO() {
		super();
	}

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

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public String getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	@Override
	public String toString() {
		return "AdminAccountStudentAccountInfoVO [stuNum=" + stuNum + ", stuPass=" + stuPass + ", stuName=" + stuName
				+ ", stuBirth=" + stuBirth + ", stuTel=" + stuTel + ", stuAdd=" + stuAdd + ", stuStatus=" + stuStatus
				+ ", courName=" + courName + ", courCardinal=" + courCardinal + ", instName=" + instName + "]";
	}

} //class
