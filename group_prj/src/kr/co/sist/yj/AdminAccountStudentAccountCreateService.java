package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountStudentAccountCreateService {

	public boolean addStudentAccountMember(AdminAccountStudentAccountCreateVO aasacVO) {
		boolean flag = false;
		AdminAccountStudentAccountCreateDAO aasacDAO = AdminAccountStudentAccountCreateDAO.getInstance();
		
		try {
			aasacDAO.insertStudentAccountMember(aasacVO);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addMember
	
} //class
