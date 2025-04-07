package kr.co.sist.yj;

import java.sql.SQLException;

public class AdminAccountStudentAccountModifyService {
	
	public AdminAccountStudentAccountModifyService() {
		
	} //AdminAccountStudentAccountModifyService
	
	public boolean removeStudentAccountMember(int num) {
		boolean flag=false;
		
		AdminAccountStudentAccountModifyDAO aasamDAO = AdminAccountStudentAccountModifyDAO.getInstance();
		
		try {
			flag = aasamDAO.deleteStudentAccountMember(num) == 1;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeStudentAccountMember
} //class
