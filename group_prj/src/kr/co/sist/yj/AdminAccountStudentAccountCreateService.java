package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountStudentAccountCreateService {

	/**
	 * 학생 계정 등록
	 * @param aasacVO 등록할 학생 계정 정보가 담긴 VO
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addStudentAccountMember(AdminAccountStudentAccountCreateVO aasacVO) {
		boolean flag = false;
		AdminAccountStudentAccountCreateDAO aasacDAO = AdminAccountStudentAccountCreateDAO.getInstance();
		
		try {
			aasacDAO.insertStudentAccountMember(aasacVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addMember
	
} //class
