package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminAccountAdminAccountCreateService {

	/**
	 * 관리자 계정 등록
	 * @param aaaacVO 등록할 관리자 계정 정보가 담긴 VO
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addAdminAccountMember(AdminAccountAdminAccountCreateVO aaaacVO) {
		boolean flag = false;
		
		AdminAccountAdminAccountCreateDAO aaaacDAO = AdminAccountAdminAccountCreateDAO.getInstance();
		
		try {
			aaaacDAO.insertAdminAccountMember(aaaacVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addAdminAccountMember
	
} //class
