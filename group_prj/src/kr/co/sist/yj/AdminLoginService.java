package kr.co.sist.yj;

import java.sql.SQLException;
import java.util.List;

public class AdminLoginService {

	/**
	 * 전체 관리자 계정 조회
	 * @return loginList 전체 관리자 계정 VO 객체들의 리스트
	 */
	public List<AdminLoginVO> searchAllAdminAccountLogin() {
		List<AdminLoginVO> loginList= null;
		AdminLoginDAO loginDAO = AdminLoginDAO.getInstance();
		
		try {
			loginList = loginDAO.selectAllAdminAccountLogin();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return loginList;
	} // searchAllAdminAccountLogin

} // class
