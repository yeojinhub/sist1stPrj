package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminGradeDAO {

	public List<AdminGradeVO> selectGradeAllInfo() throws SQLException {
		List<AdminGradeVO> list = new ArrayList<AdminGradeVO>();
		// DB연결 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// insert Query문
		String selectAdminGradeInfoQuery = "SELECT * FROM ADMIN_SEARCH_GRADE";

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbCon.getConn();
			pstmt = con.prepareStatement(selectAdminGradeInfoQuery);

			// 쿼리문 실행
			rs = pstmt.executeQuery();

			// while 반복문으로 VO객체에 값 넣기
			while (rs.next()) {
				AdminGradeVO agvo = new AdminGradeVO();
				agvo.setExamName(rs.getString("EXAM_NAME"));
				agvo.setExamDate(rs.getString("EXAM_DATE"));
				agvo.setExamAnswCount(rs.getString("EXAM_ANSW_COUNT"));
				agvo.setCourCardinal(rs.getString("COUR_CARDINAL"));
				agvo.setStuName(rs.getString("STU_NAME"));
				list.add(agvo);
			} // end while
		} finally {
			dbCon.closeDB(null, pstmt, con);
		}

		return list;
	}// selectGradeAllInfo

	public AdminGradeConditionVO selectGradeSearchCondition() throws SQLException {
		AdminGradeConditionVO agcVO = new AdminGradeConditionVO();
		List<String> courCardinalList = new ArrayList<String>();
		List<String> examNameList = new ArrayList<String>();

		// DB연결 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton DBConnection 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// insert Query문
		String selectCourseCardinalQuery = "SELECT COUR_CARDINAL FROM COURSE";
		String selectExamNameQuery = "SELECT EXAM_NAME FROM EXAM";

		try {
			// 생성한 DB 객체에 값 삽입
			con = dbCon.getConn();
			pstmt = con.prepareStatement(selectCourseCardinalQuery);

			// 쿼리문 실행
			rs = pstmt.executeQuery();

			// while 반복문으로 VO객체에 값 넣기
			while (rs.next()) {
				courCardinalList.add(rs.getString("COUR_CARDINAL"));
				agcVO.setCourCardinal(courCardinalList);
			} // end while
			
			pstmt = con.prepareStatement(selectExamNameQuery);

			// 쿼리문 실행
			rs = pstmt.executeQuery();

			// while 반복문으로 VO객체에 값 넣기
			while (rs.next()) {
				examNameList.add(rs.getString("EXAM_NAME"));
				agcVO.setExamName(examNameList);
			} // end while
		} finally {
			dbCon.closeDB(null, pstmt, con);
		}

		return agcVO;
	}

}// class
