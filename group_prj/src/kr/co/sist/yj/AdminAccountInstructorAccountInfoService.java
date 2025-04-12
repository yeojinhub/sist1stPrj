package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminAccountInstructorAccountInfoService {

	/**
	 * 강사 계정 등록
	 * @param instVO 등록할 강사 계정 정보가 담긴 VO
	 * @return flag 등록 성공시 true, 실패시 false
	 */
	public boolean addInstructorAccountMember(AdminAccountInstructorAccountInfoVO instVO) {
		boolean flag=false;
		AdminAccountInstructorAccountInfoDAO instDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instDAO.insertInstructorAccountMember(instVO);
			flag=true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addInstructorAccountMember
	
	/**
	 * 강사 계정 수정
	 * @param instVO 수정할 강사 계정 정보가 담긴 VO
	 * @return flag 수정 성공시 true, 실패시 false
	 */
	public boolean modifyInstructorAccountMember(AdminAccountInstructorAccountInfoVO instVO) {
		boolean flag = false;
		AdminAccountInstructorAccountInfoDAO instDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instDAO.updateInstructorAccountMember(instVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //modifyInstructorAccountMember
	
	/**
	 * 강사 계정 삭제
	 * @param instNum 삭제할 강사의 사번
	 * @return flag 삭제 성공시 true, 실패시 false
	 */
	public boolean removeInstructorAccountMember(String instNum) {
		boolean flag = false;
		AdminAccountInstructorAccountInfoDAO instDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instDAO.deleteInstructorAccountMember(instNum);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeInstructorAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return instructorList 전체 강사 계정 VO 객체들의 리스트
	 */
	public List<AdminAccountInstructorAccountInfoVO> searchAllInstructorAccountMember() {
		List<AdminAccountInstructorAccountInfoVO> instructorList = null;
		AdminAccountInstructorAccountInfoDAO instDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instructorList = instDAO.selectAllInstructorAccountMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return instructorList;
	} //searchAllInstructorAccountMember
	
	/**
	 * 단일 강사 계정 조회
	 * @param instNum 조회할 강사의 사번
	 * @return instVO 조회한 강사 계정 VO 객체(없으면 null 반환)
	 */
	public AdminAccountInstructorAccountInfoVO searchOneInstructorAccountMember(String instNum) {
		AdminAccountInstructorAccountInfoVO instVO = null;
		AdminAccountInstructorAccountInfoDAO instDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instVO = instDAO.selectOneInstructorAccountMember(instNum);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return instVO;
	} //searchOneInstructorAccountMember
	
} //class
