package kr.co.sist.yj;

import java.sql.Date;

public class AdminLoginVO {

	private String admNum;
	private String admID;
	private String admPass;
	private String admName;
	private Date admBirth;
	private String admTel ;
	private String admAdd;

	public AdminLoginVO() {
		super();
	} // AdminLoginVO

	public AdminLoginVO(String admNum, String admID, String admPass, String admName, Date admBirth, String admTel,
			String admAdd) {
		super();
		this.admNum = admNum;
		this.admID = admID;
		this.admPass = admPass;
		this.admName = admName;
		this.admBirth = admBirth;
		this.admTel = admTel;
		this.admAdd = admAdd;
	}

	public String getAdmNum() {
		return admNum;
	}

	public void setAdmNum(String admNum) {
		this.admNum = admNum;
	}

	public String getAdmID() {
		return admID;
	}

	public void setAdmID(String admID) {
		this.admID = admID;
	}

	public String getAdmPass() {
		return admPass;
	}

	public void setAdmPass(String admPass) {
		this.admPass = admPass;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public Date getAdmBirth() {
		return admBirth;
	}

	public void setAdmBirth(Date admBirth) {
		this.admBirth = admBirth;
	}

	public String getAdmTel() {
		return admTel;
	}

	public void setAdmTel(String admTel) {
		this.admTel = admTel;
	}

	public String getAdmAdd() {
		return admAdd;
	}

	public void setAdmAdd(String admAdd) {
		this.admAdd = admAdd;
	}

	@Override
	public String toString() {
		return "AdminLoginVO [admNum=" + admNum + ", admID=" + admID + ", admPass=" + admPass + ", admName=" + admName
				+ ", admBirth=" + admBirth + ", admTel=" + admTel + ", admAdd=" + admAdd + "]";
	} //toString

} // class
