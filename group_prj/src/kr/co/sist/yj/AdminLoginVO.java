//package kr.co.sist.vo;
package kr.co.sist.yj;

import java.time.LocalDate;

public class AdminLoginVO {

	private String adminIDSet;
	private String adminPassSet;
	private String adminNameSet;
	private LocalDate adminBirthSet;
	private String adminTelSet;
	private String adminAddressSet;
	
	public AdminLoginVO() {
		super();
	} //AdminLoginVO
	
	public AdminLoginVO(String adminIDSet, String adminPassSet, String adminNameSet, LocalDate adminBirthSet,
			String adminTelSet, String adminAddressSet) {
		super();
		this.adminIDSet = adminIDSet;
		this.adminPassSet = adminPassSet;
		this.adminNameSet = adminNameSet;
		this.adminBirthSet = adminBirthSet;
		this.adminTelSet = adminTelSet;
		this.adminAddressSet = adminAddressSet;
	} //AdminLoginVO
	
	public String getAdminIDSet() {
		return adminIDSet;
	} //getAdminIDSet
	
	public void setAdminIDSet(String adminIDSet) {
		this.adminIDSet = adminIDSet;
	} //setAdminIDSet
	
	public String getAdminPassSet() {
		return adminPassSet;
	} //getAdminPassSet
	
	public void setAdminPassSet(String adminPassSet) {
		this.adminPassSet = adminPassSet;
	} //setAdminPassSet
	
	public String getAdminNameSet() {
		return adminNameSet;
	} //getAdminNameSet
	
	public void setAdminNameSet(String adminNameSet) {
		this.adminNameSet = adminNameSet;
	} //setAdminNameSet
	
	public LocalDate getAdminBirthSet() {
		return adminBirthSet;
	} //getAdminBirthSet
	
	public void setAdminBirthSet(LocalDate adminBirthSet) {
		this.adminBirthSet = adminBirthSet;
	} //setAdminBirthSet
	
	public String getAdminTelSet() {
		return adminTelSet;
	} //getAdminTelSet
	
	public void setAdminTelSet(String adminTelSet) {
		this.adminTelSet = adminTelSet;
	} //setAdminTelSet
	
	public String getAdminAddressSet() {
		return adminAddressSet;
	} //getAdminAddressSet
	
	public void setAdminAddressSet(String adminAddressSet) {
		this.adminAddressSet = adminAddressSet;
	} //setAdminAddressSet
	
	@Override
	public String toString() {
		return "AdminLoginVO [adminIDSet=" + adminIDSet + ", adminPassSet=" + adminPassSet + ", adminNameSet="
				+ adminNameSet + ", adminBirthSet=" + adminBirthSet + ", adminTelSet=" + adminTelSet
				+ ", adminAddressSet=" + adminAddressSet + "]";
	} //toString
	
} //class
