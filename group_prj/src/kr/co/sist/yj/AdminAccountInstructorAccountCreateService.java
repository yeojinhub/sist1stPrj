package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountInstructorAccountCreateService {

	public boolean addInstructorAccountMember(AdminAccountInstructorAccountCreateVO aaiacVO) {
		boolean flag = false;
		
		AdminAccountInstructorAccountCreateDAO aaiacDAO = AdminAccountInstructorAccountCreateDAO.getInstance();
		
		try {
			aaiacDAO.insertInstructorAccountMember(aaiacVO);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addInstructorAccountMember
	
} //class
