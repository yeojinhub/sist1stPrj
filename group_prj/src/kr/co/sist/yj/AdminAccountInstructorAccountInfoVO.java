package kr.co.sist.yj;

import java.sql.Date;

public class AdminAccountInstructorAccountInfoVO {
	private String inst_num;
	private String inst_pass;
	private String inst_name;
	private Date inst_birth;
	private String inst_tel;
	private String inst_add;
	
	public AdminAccountInstructorAccountInfoVO() {
		super();
	}

	public AdminAccountInstructorAccountInfoVO(String inst_num, String inst_pass, String inst_name, Date inst_birth,
			String inst_tel, String inst_add) {
		super();
		this.inst_num = inst_num;
		this.inst_pass = inst_pass;
		this.inst_name = inst_name;
		this.inst_birth = inst_birth;
		this.inst_tel = inst_tel;
		this.inst_add = inst_add;
	}

	public String getInst_num() {
		return inst_num;
	}

	public void setInst_num(String inst_num) {
		this.inst_num = inst_num;
	}

	public String getInst_pass() {
		return inst_pass;
	}

	public void setInst_pass(String inst_pass) {
		this.inst_pass = inst_pass;
	}

	public String getInst_name() {
		return inst_name;
	}

	public void setInst_name(String inst_name) {
		this.inst_name = inst_name;
	}

	public Date getInst_birth() {
		return inst_birth;
	}

	public void setInst_birth(Date inst_birth) {
		this.inst_birth = inst_birth;
	}

	public String getInst_tel() {
		return inst_tel;
	}

	public void setInst_tel(String inst_tel) {
		this.inst_tel = inst_tel;
	}

	public String getInst_add() {
		return inst_add;
	}

	public void setInst_add(String inst_add) {
		this.inst_add = inst_add;
	}

	@Override
	public String toString() {
		return "AdminAccountInstructorAccountInfoVO [inst_num=" + inst_num + ", inst_pass=" + inst_pass + ", inst_name="
				+ inst_name + ", inst_birth=" + inst_birth + ", inst_tel=" + inst_tel + ", inst_add=" + inst_add + "]";
	}
	  
} //class
