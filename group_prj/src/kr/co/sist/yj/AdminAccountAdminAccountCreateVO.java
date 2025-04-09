package kr.co.sist.yj;

import java.sql.Date;

public class AdminAccountAdminAccountCreateVO {

	private int adm_num;
	private String adm_pass;
	private String adm_name;
	private Date adm_birth;
	private String adm_tel;
	private String adm_add;

	public AdminAccountAdminAccountCreateVO() {
		super();
	}

	public AdminAccountAdminAccountCreateVO(int adm_num, String adm_pass, String adm_name, Date adm_birth,
			String adm_tel, String adm_add) {
		super();
		this.adm_num = adm_num;
		this.adm_pass = adm_pass;
		this.adm_name = adm_name;
		this.adm_birth = adm_birth;
		this.adm_tel = adm_tel;
		this.adm_add = adm_add;
	}

	public int getAdm_num() {
		return adm_num;
	}

	public void setAdm_num(int adm_num) {
		this.adm_num = adm_num;
	}

	public String getAdm_pass() {
		return adm_pass;
	}

	public void setAdm_pass(String adm_pass) {
		this.adm_pass = adm_pass;
	}

	public String getAdm_name() {
		return adm_name;
	}

	public void setAdm_name(String adm_name) {
		this.adm_name = adm_name;
	}

	public Date getAdm_birth() {
		return adm_birth;
	}

	public void setAdm_birth(Date adm_birth) {
		this.adm_birth = adm_birth;
	}

	public String getAdm_tel() {
		return adm_tel;
	}

	public void setAdm_tel(String adm_tel) {
		this.adm_tel = adm_tel;
	}

	public String getAdm_add() {
		return adm_add;
	}

	public void setAdm_add(String adm_add) {
		this.adm_add = adm_add;
	}

	@Override
	public String toString() {
		return "AdminAccountAdminAccountCreateVO [adm_num=" + adm_num + ", adm_pass=" + adm_pass + ", adm_name="
				+ adm_name + ", adm_birth=" + adm_birth + ", adm_tel=" + adm_tel + ", adm_add=" + adm_add + "]";
	} // toString

} // class
