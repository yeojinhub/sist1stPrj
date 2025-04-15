package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminCourseDAO {
	
	/**
	 * 과정 등록
	 * @param courVO 등록할 과정 정보가 담긴 VO
	 * @throws SQLException 예외처리
	 */
	public void insertCourse(AdminCourseVO courVO) throws SQLException {
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// Singleton DBConnection 객체 생성
		DBConnection dbConn = DBConnection.getInstance();
		
		try {
			// 생성한 DB 객체에 값 삽입
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			String insertQuery = "INSERT INTO COURSE VALUES (SEQ_COUR_NUM.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(insertQuery);
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, courVO.getCourCardinal());
			pstmt.setString(2, courVO.getCourName());
			pstmt.setString(3, courVO.getCourStatus());
			pstmt.setString(4, courVO.getCourStartdate().toString());
			pstmt.setString(5, courVO.getCourEnddate().toString());
			pstmt.setString(6, courVO.getInstNum());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally

	}// insertCourse
	
	/**
	 * 과정 수정
	 * @param courCardinal 과정기수
	 * @param courName 과정이름
	 * @param courStatus 과정진행상태
	 * @param courStartdate 과정시작날짜
	 * @param courEnddate 과정종료날짜
	 * @param instNum 강사사번
	 * @param courNum 과정번호
	 * @return result
	 * @throws SQLException 예외처리
	 */
	public boolean updateCourse(String courCardinal, String courName, String courStatus, String courStartdate, String courEnddate, String instNum, int courNum) throws SQLException{
		boolean result = false;

		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbConn = DBConnection.getInstance();

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			String updateCourseQuery = "UPDATE COURSE SET COUR_CARDINAL = ?, COUR_NAME = ?, COUR_STATUS = ?, COUR_STARTDATE = ?, COUR_ENDDATE = ?, INST_NUM = ? WHERE COUR_NUM = ?";
			pstmt = con.prepareStatement(updateCourseQuery);

			// 4. bind 변수 값 설정
			pstmt.setString(1, courCardinal);
			pstmt.setString(2, courName);
			pstmt.setString(3, courStatus);
			pstmt.setString(4, courStartdate);
			pstmt.setString(5, courEnddate);
			pstmt.setString(6, instNum);
			pstmt.setInt(7, courNum);

			// 5. 쿼리문 수행 후 결과 얻기
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} // end try-finally

		return result;
		
	}// updateCourse
	
	/**
	 * 과정 삭제
	 * @param courNum 과정번호
	 * @return result
	 * @throws SQLException 예외처리
	 */
	public boolean deleteCourse(int courNum) throws SQLException {
		boolean result = false;

		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbConn = DBConnection.getInstance();

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			String deleteCourseQuery = "DELETE COURSE WHERE COUR_NUM = ?";
			pstmt = con.prepareStatement(deleteCourseQuery);

			// 4. bind 변수 값 설정
			pstmt.setInt(1, courNum);

			// 5. 쿼리문 수행 후 결과 얻기
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} // end try-finally

		return result;
		
	} // deleteCourse
	
	/**
	 * 전체 강사 계정 조회
	 * @return instList 전체 강사(사번,이름) 리스트
	 * @throws SQLException 예외처리
	 */
	public List<AdminCourseInstVO> selectAllInstructorInfo() throws SQLException {
		List<AdminCourseInstVO> instList = new ArrayList<AdminCourseInstVO>();

		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbCon.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			String selectInstructorNotSameQuery = "SELECT INST_NUM, INST_NAME FROM INSTRUCTOR";
			pstmt = con.prepareStatement(selectInstructorNotSameQuery);
			
			// 4. bind 변수 값 설정
			// 5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			// 반복문으로 VO객체에 데이터 넣기
			while (rs.next()) {
				AdminCourseInstVO instVO = new AdminCourseInstVO();
				
				instVO.setInstName(rs.getString("INST_NAME"));
				instVO.setInstNum(rs.getString("INST_NUM"));
				
				instList.add(instVO);
			} // end while
			
		} finally {
			// 6. 연결 끊기
			dbCon.closeDB(rs, pstmt, con);
		} // end try-finally

		return instList;
	} // selectAllInstructorInfo
	
	/**
	 * 전체 과정 조회
	 * @return courselist 전체 과정 리스트
	 * @throws SQLException 예외처리
	 */
	public List<AdminCourseVO> selectAllCourseInfo() throws SQLException {
		List<AdminCourseVO> courselist = new ArrayList<AdminCourseVO>();

		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbCon.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			String selectInstructorInfoQuery = "SELECT COUR_NUM, COUR_CARDINAL, COUR_NAME, COUR_STATUS, TO_CHAR(COUR_STARTDATE,'YYYY-MM-DD') COUR_STARTDATE, TO_CHAR(COUR_ENDDATE,'YYYY-MM-DD') COUR_ENDDATE, C.INST_NUM, INST_NAME "
					+ "FROM COURSE C, INSTRUCTOR I " + "WHERE C.INST_NUM = I.INST_NUM " + "ORDER BY COUR_CARDINAL";
			pstmt = con.prepareStatement(selectInstructorInfoQuery);

			// 4. bind 변수 값 설정
			// 5. 쿼리문 수행 후 결과 얻기
			rs = pstmt.executeQuery();

			// 반복문으로 VO객체에 데이터 넣기
			while (rs.next()) {
				AdminCourseVO courVO = new AdminCourseVO();

				courVO.setCourNum(rs.getInt("COUR_NUM"));
				courVO.setCourCardinal(rs.getString("COUR_CARDINAL"));
				courVO.setCourName(rs.getString("COUR_NAME"));
				courVO.setCourStatus(rs.getString("COUR_STATUS"));
				courVO.setCourStartdate(rs.getString("COUR_STARTDATE"));
				courVO.setCourEnddate(rs.getString("COUR_ENDDATE"));
				courVO.setInstNum(rs.getString("INST_NUM"));
				
				courselist.add(courVO);
			} // end while
			
		} finally {
			dbCon.closeDB(rs, pstmt, con);
		} // end try-finally

		return courselist;
		
	} // selectAllCourseInfo
	
	/**
	 * 단일 과정 조회
	 * @param courNum 조회할 과정 번호
	 * @return courVO 조회한 과정 정보가 담긴 VO 객체
	 * @throws SQLException
	 */
	public AdminCourseVO selectOneCourse(int courNum) throws SQLException {
		AdminCourseVO courVO = null;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectOneQuery = new StringBuilder();
			strSelectOneQuery
			.append("	select *	")
			.append("	from course	")
			.append("	where cour_num=?	")
			;
			pstmt=con.prepareStatement(strSelectOneQuery.toString());
			
			// 4. bind 변수 값 할당
			pstmt.setInt(1, courNum);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			// 레코드 존재여부 확인
			if( rs.next() ) {
				courVO = new AdminCourseVO();
				// 값을 VO 객체에 저장
				courVO.setCourNum(rs.getInt("cour_num"));
				courVO.setCourCardinal(rs.getString("cour_cardinal"));
				courVO.setCourName(rs.getString("cour_name"));
				courVO.setCourStatus(rs.getString("cour_status"));
				courVO.setCourStartdate(rs.getString("cour_startdate"));
				courVO.setCourEnddate(rs.getString("cour_enddate"));
				courVO.setInstNum(rs.getString("inst_num"));
			} //end if
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return courVO;
	} //selectOneCourse
	
} //class

