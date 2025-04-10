package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminAccountInstructorAccountInfoService {

	/**
	 * 강사 계정 등록
	 * @param aaiaiVO 등록할 강사 계정 정보가 담긴 VO
	 * @return 등록 성공시 true, 실패시 false
	 */
	public boolean addInstructorAccountMember(AdminAccountInstructorAccountInfoVO aaiaiVO) {
		boolean flag=false;
		AdminAccountInstructorAccountInfoDAO aaiaiDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			aaiaiDAO.insertInstructorAccountMember(aaiaiVO);
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
	 * @param aaiaiVO 수정할 강사 계정 정보가 담긴 VO
	 * @return 수정 성공시 true, 실패시 false
	 */
	public boolean modifyInstructorAccountMember(AdminAccountInstructorAccountInfoVO aaiaiVO) {
		boolean flag = false;
		
		AdminAccountInstructorAccountInfoDAO aaiaiDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		try {
			aaiaiDAO.updateInstructorAccountMember(aaiaiVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //modifyInstructorAccountMember
	
	/**
	 * 강사 계정 삭제
	 * @param num 삭제할 강사의 사번
	 * @return 삭제 성공시 true, 실패시 false
	 */
	public boolean removeInstructorAccountMember(String num) {
		boolean flag = false;
		
		AdminAccountInstructorAccountInfoDAO aaiaiDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			aaiaiDAO.deleteInstructorAccountMember(num);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeInstructorAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return 전체 강사 계정 VO 객체들의 리스트
	 */
	public List<AdminAccountInstructorAccountInfoVO> searchAllInstructorAccountMember() {
		List<AdminAccountInstructorAccountInfoVO> instructorList = null;
		AdminAccountInstructorAccountInfoDAO aaiaiDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			instructorList = aaiaiDAO.selectAllInstructorAccountMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return instructorList;
	} //searchAllInstructorAccountMember
	
	/**
	 * 한명의 강사 계정 조회
	 * @param num 조회할 강사의 사번
	 * @return 조회한 한명의 강사 계정 VO 객체들의 리스트
	 */
	public AdminAccountInstructorAccountInfoVO searchOneInstructorAccountMember(String num) {
		AdminAccountInstructorAccountInfoVO aaiaiVO = null;
		AdminAccountInstructorAccountInfoDAO aaiaiDAO = AdminAccountInstructorAccountInfoDAO.getInstance();
		
		try {
			aaiaiVO = aaiaiDAO.selectOneInstructorAccountMember(num);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return aaiaiVO;
	} //searchOneInstructorAccountMember
	
} //class
