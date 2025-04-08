package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountInstructorAccountCreateService {

	/**
	 * 강사 계정 등록
	 * @param aaiacVO 등록할 강사 계정 정보가 담긴 VO
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addInstructorAccountMember(AdminAccountInstructorAccountCreateVO aaiacVO) {
		boolean flag = false;
		
		AdminAccountInstructorAccountCreateDAO aaiacDAO = AdminAccountInstructorAccountCreateDAO.getInstance();
		
		try {
			aaiacDAO.insertInstructorAccountMember(aaiacVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addInstructorAccountMember
	
} //class
