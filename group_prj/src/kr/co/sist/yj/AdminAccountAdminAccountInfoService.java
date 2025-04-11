package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminAccountAdminAccountInfoService {

	/**
	 * 관리자 계정 등록
	 * @param aaaaiVO 등록할 관리자 계정 정보가 담긴 VO
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addAdminAccountAdminAccountMember(AdminAccountAdminAccountInfoVO aaaaiVO) {
		boolean flag=false;
		AdminAccountAdminAccountInfoDAO aaaaiDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			aaaaiDAO.insertAdminAccountMember(aaaaiVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addAdminAccountAdminAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return 전체 강사 계정 VO 객체들의 리스트
	 */
	public List<AdminAccountAdminAccountInfoVO> searchAllAdminAccountAdminAccountMember() {
		List<AdminAccountAdminAccountInfoVO> adminList = null;
		AdminAccountAdminAccountInfoDAO aaaaiDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			adminList = aaaaiDAO.selectAllAdminAccountMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return adminList;
	} //searchAllAdminAccountAdminAccountMember
	
} //class
