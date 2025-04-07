package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountAdminAccountCreateService {

	public boolean addAdminAccountMember(AdminAccountAdminAccountCreateVO aaaacVO) {
		boolean flag = false;
		
		AdminAccountAdminAccountCreateDAO aaaacDAO = AdminAccountAdminAccountCreateDAO.getInstance();
		
		try {
			aaaacDAO.insertAdminAccountMember(aaaacVO);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addAdminAccountMember
	
} //class
