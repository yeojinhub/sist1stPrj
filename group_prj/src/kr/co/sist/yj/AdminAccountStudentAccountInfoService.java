package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminAccountStudentAccountInfoService {

	/**
	 * 학생 계정 등록
	 * @param stuVO 등록할 학생 계정 정보가 담긴 VO
	 * @return flag 등록 성공시 true, 실패시 false
	 */
	public boolean addStudentAccountMember(AdminAccountStudentAccountInfoVO stuVO) {
		boolean flag = false;
		AdminAccountStudentAccountInfoDAO stuDAO = AdminAccountStudentAccountInfoDAO.getInstance();
		
		try {
			stuDAO.insertStudentAccountMember(stuVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} //end try catch
		
		return flag;
	} //addStudentAccountMember
	
	/**
	 * 학생 계정 수정
	 * @param stuVO 수정할 학생 계정 정보가 담긴 VO
	 * @return flag 수정 성공시 true, 실패시 false
	 */
	public boolean modifyStudentAccountMember(AdminAccountStudentAccountInfoVO stuVO) {
		boolean flag = false;
		AdminAccountStudentAccountInfoDAO stuDAO = AdminAccountStudentAccountInfoDAO.getInstance();
		
		try {
			stuDAO.updateStudentAccountMember(stuVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //modifyStudentAccountMember
	
	/**
	 * 학생 계정 삭제
	 * @param stuNum 삭제할 학생의 학번
	 * @return flag 삭제 성공시 true, 실패시 false
	 */
	public boolean removeStudentAccountMember(String stuNum) {
		boolean flag = false;
		AdminAccountStudentAccountInfoDAO stuDAO = AdminAccountStudentAccountInfoDAO.getInstance();
		
		try {
			stuDAO.deleteStudentAccountMember(stuNum);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeStudentAccountMember
	
	/**
	 * 전체 학생 계정 조회
	 * @return studentList 전체 학생 계정 VO 객체들의 리스트
	 */
	public List<AdminAccountStudentAccountInfoVO> searchAllStudentAccountMember(){
		List<AdminAccountStudentAccountInfoVO> studentList = null;
		AdminAccountStudentAccountInfoDAO stuDAO = AdminAccountStudentAccountInfoDAO.getInstance();
		
		try {
			studentList = stuDAO.selectAllStudentAccountMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return studentList;
	} //searchAllStudentAccountMember
	
	/**
	 * 단일 학생 계정 조회
	 * @param stuNum 조회할 학생의 학번
	 * @return stuVO 조회한 학생 계정 VO 객체(없으면 null 반환)
	 */
	public AdminAccountStudentAccountInfoVO searchOneStudentAccountMember(String stuNum) {
		AdminAccountStudentAccountInfoVO stuVO = null;
		AdminAccountStudentAccountInfoDAO stuDAO = AdminAccountStudentAccountInfoDAO.getInstance();
		
		try {
			stuVO=stuDAO.selectOneStudentAccountMember(stuNum);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return stuVO;
	} //searchOneStudentAccountMember
	
} //class
