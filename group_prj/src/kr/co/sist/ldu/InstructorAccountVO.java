package kr.co.sist.ldu;

import java.sql.Date;

public class InstructorAccountVO {

	private String InstNum;
	private String InstPass;
	private String InstName;
	private Date InstBirth;
	private String InstTel;
	private String InstAdd;

	public InstructorAccountVO(String InstNum, String InstPass, String InstName, Date InstBirth, String InstTel, String InstAdd) {
		this.InstNum = InstNum;
		this.InstPass = InstPass;
		this.InstName = InstName;
		this.InstBirth = InstBirth;
		this.InstTel = InstTel;
		this.InstAdd = InstAdd;
	}// InstdentAccountVO

	public InstructorAccountVO() {
		super();
	}// InstdentAccountVO

	
	// Getter, Setter Method
	public String getInstNum() {
		return InstNum;
	}

	public void setInstNum(String InstNum) {
		this.InstNum = InstNum;
	}

	public String getInstPass() {
		return InstPass;
	}

	public void setInstPass(String InstPass) {
		this.InstPass = InstPass;
	}

	public String getInstName() {
		return InstName;
	}

	public void setInstName(String InstName) {
		this.InstName = InstName;
	}

	public Date getInstBirth() {
		return InstBirth;
	}

	public void setInstBirth(Date InstBirth) {
		this.InstBirth = InstBirth;
	}

	public String getInstTel() {
		return InstTel;
	}

	public void setInstTel(String InstTel) {
		this.InstTel = InstTel;
	}

	public String getInstAdd() {
		return InstAdd;
	}

	public void setInstAdd(String InstAdd) {
		this.InstAdd = InstAdd;
	}

	

	// toString Override
	@Override
	public String toString() {
		return "InstdentAccountVO [InstNum=" + InstNum + ", InstPass=" + InstPass + ", InstName=" + InstName + ", InstBirth="
				+ InstBirth + ", InstTel=" + InstTel + ", InstAdd=" + InstAdd + "]";
	}// toString

}// class
