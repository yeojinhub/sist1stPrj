package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminAccountAdminAccountInfoService {

	/**
	 * 관리자 계정 등록
	 * @param admVO 등록할 관리자 계정 정보가 담긴 VO
	 * @return flag 등록 성공시 true, 실패시 false
	 */
	public boolean addAdminAccountMember(AdminAccountAdminAccountInfoVO admVO) {
		boolean flag=false;
		AdminAccountAdminAccountInfoDAO admDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			admDAO.insertAdminAccountMember(admVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addAdminAccountMember
	
	/**
	 * 관리자 계정 수정
	 * @param admVO 수정할 관리자 계정 정보가 담긴 VO
	 * @return flag 수정 성공시 true, 실패시 false
	 */
	public boolean modifyAdminAccountMember(AdminAccountAdminAccountInfoVO admVO) {
		boolean flag = false;
		AdminAccountAdminAccountInfoDAO admDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			admDAO.updateAdminAccountMember(admVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //modifyAdminAccountMember
	
	/**
	 * 관리자 계정 삭제
	 * @param admNum 삭제할 관리자의 사번
	 * @return flag 삭제 성공시 true, 실패시 false
	 */
	public boolean removeAdminAccountMember(String admNum) {
		boolean flag = false;
		AdminAccountAdminAccountInfoDAO admDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			admDAO.deleteAdminAccountMember(admNum);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeAdminAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return adminList 전체 강사 계정 VO 객체들의 리스트
	 */
	public List<AdminAccountAdminAccountInfoVO> searchAllAdminAccountMember() {
		List<AdminAccountAdminAccountInfoVO> adminList = null;
		AdminAccountAdminAccountInfoDAO admDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			adminList = admDAO.selectAllAdminAccountMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return adminList;
	} //searchAllAdminAccountMember
	
	/**
	 * 단일 관리자 계정 조회
	 * @param admNum 조회할 관리자 사번
	 * @return admVO 조회한 관리자 계정 VO 객체(없으면 null 반환)
	 */
	public AdminAccountAdminAccountInfoVO searchOneAdminAccountMember(String admNum) {
		AdminAccountAdminAccountInfoVO admVO = null;
		AdminAccountAdminAccountInfoDAO admDAO = AdminAccountAdminAccountInfoDAO.getInstance();
		
		try {
			admVO = admDAO.selectOneAdminAccountMember(admNum);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return admVO;
	} //searchOneAdminAccountMember
	
} //class
