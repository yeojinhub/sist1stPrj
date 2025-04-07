package kr.cos.sist.ldu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorMainDAO {

	//강사번호로 과정 기수 조회
	public List<InstructorCourseVO> selectCourseByInstructor(String instNum) throws SQLException {
		List<InstructorCourseVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM COURSEWITHINSTNAME WHERE INST_NUM = ?";
		DBConnection dbCon = DBConnection.getInstance();

		try {
			con = dbCon.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, instNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				InstructorCourseVO imvo = new InstructorCourseVO();
				imvo.setCourNum(rs.getInt("COUR_NUM"));
				imvo.setCourCardinal(rs.getString("COUR_CARDINAL"));
				imvo.setCourName(rs.getString("COUR_NAME"));
				imvo.setCourStatus(rs.getString("COUR_STATUS"));
				imvo.setCourStartDate(rs.getDate("COUR_STARTDATE"));
				imvo.setCourEndDate(rs.getDate("COUR_ENDDATE"));
				imvo.setInstNum(rs.getString("INST_NUM"));
				imvo.setInstName(rs.getString("INST_NAME"));
				list.add(imvo);
			}
		} finally {
			dbCon.closeDB(con, pstmt, rs);
		}

		return list;
	}
	
	//과정 번호로 시험 조회
	public List<InstructorExamVO> selectExamsByCourse(int courNum, String courCardinal) throws SQLException {
		List<InstructorExamVO> examList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnection dbCon = DBConnection.getInstance();

		String sql = "SELECT EXAM_NAME, EXAM_DATE FROM EXAM WHERE COUR_NUM = ?";

		try {
			con = dbCon.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, courNum);
			rs = pstmt.executeQuery();

			Date today = new Date(System.currentTimeMillis());

			while (rs.next()) {
				String examName = rs.getString("EXAM_NAME");
				Date examDate = rs.getDate("EXAM_DATE");

				String examStatus = examDate.compareTo(today) >= 0 ? "오픈" : "종료";

				InstructorExamVO vo = new InstructorExamVO(
					examName,
					examDate,
					examStatus,
					courCardinal,
					courNum
				);

				examList.add(vo);
			}
		} finally {
			dbCon.closeDB(con, pstmt, rs);
		}

		return examList;
	}
}

