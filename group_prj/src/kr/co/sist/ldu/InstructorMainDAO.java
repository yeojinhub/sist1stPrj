package kr.co.sist.ldu;

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
	
	 public List<InstructorBoardVO> selectAllBoardList() throws SQLException {
	        List<InstructorBoardVO> list = new ArrayList<>();
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        String sql = "SELECT B.BOARD_NUM, B.BOARD_TITLE, B.BOARD_CONTENT, "
	                   + "B.BOARD_STATUS, B.BOARD_DATE, B.BOARD_TYPE, "
	                   + "B.BOARD_COMM_CONTENT, B.BOARD_COMM_DATE, "
	                   + "B.STU_NUM, B.INST_NUM, B.ADM_NUM, "
	                   + "S.STU_NAME, I.INST_NAME "
	                   + "FROM BOARD B "
	                   + "JOIN STUDENT S ON B.STU_NUM = S.STU_NUM "
	                   + "LEFT JOIN INSTRUCTOR I ON B.INST_NUM = I.INST_NUM "
	                   + "ORDER BY B.BOARD_NUM DESC";

	        DBConnection dbCon = DBConnection.getInstance();

	        try {
	            con = dbCon.getConn();
	            pstmt = con.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            while (rs.next()) {
	                InstructorBoardVO vo = new InstructorBoardVO();
	                vo.setBoardNum(rs.getInt("BOARD_NUM"));
	                vo.setBoardTitle(rs.getString("BOARD_TITLE"));
	                vo.setBoardContent(rs.getString("BOARD_CONTENT"));
	                vo.setBoardStatus(rs.getString("BOARD_STATUS"));
	                vo.setBoardDate(rs.getDate("BOARD_DATE"));
	                vo.setBoardType(rs.getString("BOARD_TYPE"));
	                vo.setBoardCommContent(rs.getString("BOARD_COMM_CONTENT"));
	                vo.setBoardCommDate(rs.getDate("BOARD_COMM_DATE"));
	                vo.setStuNum(rs.getString("STU_NUM"));
	                vo.setInstNum(rs.getString("INST_NUM"));
	                vo.setAdmNum(rs.getInt("ADM_NUM"));
	                vo.setStuName(rs.getString("STU_NAME"));
	                vo.setInstName(rs.getString("INST_NAME"));
	                list.add(vo);
	            }

	        } finally {
	            dbCon.closeDB(con, pstmt, rs);
	        }

	        return list;
	    }
	 
	 public InstructorBoardVO selectBoardByNum(int boardNum) throws SQLException {
		 InstructorBoardVO vo = null;
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;

		 String sql = "SELECT B.BOARD_NUM, B.BOARD_TITLE, B.BOARD_CONTENT, "
		               + "B.BOARD_STATUS, B.BOARD_DATE, B.BOARD_TYPE, "
		               + "B.BOARD_COMM_CONTENT, B.BOARD_COMM_DATE, "
		               + "B.STU_NUM, B.INST_NUM, B.ADM_NUM, "
		               + "S.STU_NAME, I.INST_NAME "
		               + "FROM BOARD B "
		               + "JOIN STUDENT S ON B.STU_NUM = S.STU_NUM "
		               + "LEFT JOIN INSTRUCTOR I ON B.INST_NUM = I.INST_NUM "
		               + "WHERE B.BOARD_NUM = ?";

		 DBConnection dbCon = DBConnection.getInstance();

		    try {
		        con = dbCon.getConn();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setInt(1, boardNum);
		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            vo = new InstructorBoardVO();
		            vo.setBoardNum(rs.getInt("BOARD_NUM"));
		            vo.setBoardTitle(rs.getString("BOARD_TITLE"));
		            vo.setBoardContent(rs.getString("BOARD_CONTENT"));
		            vo.setBoardStatus(rs.getString("BOARD_STATUS"));
		            vo.setBoardDate(rs.getDate("BOARD_DATE"));
		            vo.setBoardType(rs.getString("BOARD_TYPE"));
		            vo.setBoardCommContent(rs.getString("BOARD_COMM_CONTENT"));
		            vo.setBoardCommDate(rs.getDate("BOARD_COMM_DATE"));
		            vo.setStuNum(rs.getString("STU_NUM"));
		            vo.setInstNum(rs.getString("INST_NUM"));
		            vo.setAdmNum(rs.getInt("ADM_NUM"));
		            vo.setStuName(rs.getString("STU_NAME"));
		            vo.setInstName(rs.getString("INST_NAME"));
		        }

		    } finally {
		        dbCon.closeDB(con, pstmt, rs);
		    }

		    return vo;
		}


}

