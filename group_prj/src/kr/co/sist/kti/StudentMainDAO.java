package kr.co.sist.kti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.DBConnection;
import kr.co.sist.kti.StudentAccountVO;
import kr.co.sist.kti.StudentBoardVO;
import kr.co.sist.kti.StudentExamVO;
import kr.co.sist.kti.StudentMainVO;

public class StudentMainDAO {

	public StudentMainDAO() {

	}// StudentMainDAO

	public StudentMainVO selectMyCourseInfo(String stuNum) throws SQLException {
		StudentMainVO scVO = new StudentMainVO();

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String selectInfoQeury = "SELECT * FROM COURSEWITHINSTNAME WHERE COUR_NUM = (SELECT COUR_NUM FROM APPLY_STEPS WHERE STU_NUM = ?)";
		String selectExamQeury = "SELECT EXAM_NAME FROM EXAM WHERE COUR_NUM = ?";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(selectInfoQeury);

			// 바인드변수에 값 할당
			pstmt.setString(1, stuNum);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				scVO.setCourNum(rs.getInt("COUR_NUM"));
				scVO.setCourCardinal(rs.getString("COUR_CARDINAL"));
				scVO.setCourName(rs.getString("COUR_NAME"));
				scVO.setCourStatus(rs.getString("COUR_STATUS"));
				scVO.setCourStartDate(rs.getDate("COUR_STARTDATE"));
				scVO.setCourEndDate(rs.getDate("COUR_ENDDATE"));
				scVO.setInstNum(rs.getString("INST_NUM"));
				scVO.setInstName(rs.getString("INST_NAME"));
			} // end if

			// #-2. 과목명을 얻기 위한 쿼리문 진행
			pstmt = con.prepareStatement(selectExamQeury);

			// 바인드변수에 값 할당
			pstmt.setInt(1, scVO.getCourNum());

			// 쿼리 실행
			rs = pstmt.executeQuery();

			List<String> list = new ArrayList<String>();
			// while문으로 List에 값을 넣는다.
			while (rs.next()) {
				list.add(rs.getString("EXAM_NAME"));
			}
			scVO.setExamName(list);

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, rs);
		} // end try-finally

		return scVO;
	}// selectCourseInfo

	public List<StudentBoardVO> selectBoardInfo() throws SQLException{
		List<StudentBoardVO> boardList = new ArrayList<StudentBoardVO>();

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String selectBoardQeury = "SELECT * FROM TOTAL_BOARD_WITH_INST ORDER BY BOARD_NUM";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(selectBoardQeury);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// while문으로 List에 값을 넣는다.
			while (rs.next()) {
				StudentBoardVO sbvo = new StudentBoardVO();
				sbvo.setBoardNum(rs.getInt("BOARD_NUM"));
				sbvo.setBoardTitle(rs.getString("BOARD_TITLE"));
				sbvo.setBoardContent(rs.getString("BOARD_CONTENT"));
				sbvo.setBoardStatus(rs.getString("BOARD_STATUS"));
				sbvo.setBoardDate(rs.getDate("BOARD_DATE"));
				sbvo.setBoardType(rs.getString("BOARD_TYPE"));
				sbvo.setBoardCommContent(rs.getString("BOARD_COMM_CONTENT"));
				sbvo.setBoardCommDate(rs.getDate("BOARD_COMM_DATE"));
				sbvo.setStuNum(rs.getString("STU_NUM"));
				sbvo.setInstNum(rs.getString("INST_NUM"));
				sbvo.setAdmNum(rs.getInt("ADM_NUM"));
				sbvo.setStuName(rs.getString("STU_NAME"));
				sbvo.setInstName(rs.getString("INST_NAME"));
				boardList.add(sbvo);
			} // end while
			

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, rs);
		} // end try-finally

		return boardList;
	}// selectBoardInfo

}// class
