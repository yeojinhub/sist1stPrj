package kr.co.sist.yj;

import java.sql.SQLException;
import java.util.List;

public class AdminCourseService {
	
	/**
	 * 과정 등록
	 * @param courVO 등록할 과정 정보가 담긴 VO
	 * @return flag 등록 성공시 true, 실패시 false
	 */
	public boolean addCourse(AdminCourseVO courVO) {
		boolean flag=false;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			courDAO.insertCourse(courVO);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //addCourse
	
	/**
	 * 과정 수정
	 * @param courCardinal 과정기수
	 * @param courName 과정이름
	 * @param courStatus 과정진행상태
	 * @param courStartdate 과정시작날짜
	 * @param courEnddate 과정종료날짜
	 * @param instNum 강사사번
	 * @param courNum 과정번호
	 * @return flag 수정 성공시 true, 실패시 false
	 */
	public boolean modifyCourse(String courCardinal, String courName, String courStatus, String courStartdate, String courEnddate, String instNum, int courNum) {
		boolean flag = false;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			courDAO.updateCourse(courCardinal, courName, courStatus, courStartdate, courEnddate, instNum, courNum);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //modifyCourse
	
	/**
	 * 과정 삭제
	 * @param courNum 삭제할 과정 번호
	 * @return flag 삭제 성공시 true, 실패시 false
	 */
	public boolean removeCourse(int courNum) {
		boolean flag = false;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			courDAO.deleteCourse(courNum);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return flag;
	} //removeCourse
	
	/**
	 * 전체 강사 계정 조회
	 * @return instList 전체 강사(사번,이름) 리스트
	 */
	public List<AdminCourseInstVO> searchAllInstructorInfo(){
		List<AdminCourseInstVO> instList = null;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			instList = courDAO.selectAllInstructorInfo();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return instList;
	} //searchAllInstructorInfo
	
	/**
	 * 전체 과정 조회
	 * @return courseList 전체 과정 리스트
	 */
	public List<AdminCourseVO> searchAllCourseInfo(){
		List<AdminCourseVO> courseList = null;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			courseList = courDAO.selectAllCourseInfo();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return courseList;
	} //searchAllInstructorInfo
	
	/**
	 * 단일 과정 조회
	 * @param courNum 조회할 과정 번호
	 * @return courVO 조회한 과정 VO 객체(없으면 null 반환)
	 */
	public AdminCourseVO searchOneCourse(int courNum) {
		AdminCourseVO courVO = null;
		AdminCourseDAO courDAO = new AdminCourseDAO();
		
		try {
			courVO = courDAO.selectOneCourse(courNum);
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return courVO;
	} //searchOneCourse
	
} //class
