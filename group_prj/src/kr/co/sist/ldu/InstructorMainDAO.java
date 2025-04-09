package kr.co.sist.ldu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	//기수만을 가져오는 메소드
	public List<String> selectCardinalsByInstructor(String instNum) throws SQLException {
	    List<String> cardinals = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT DISTINCT COUR_CARDINAL FROM COURSEWITHINSTNAME WHERE INST_NUM = ?";
	    DBConnection dbCon = DBConnection.getInstance();

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, instNum);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            cardinals.add(rs.getString("COUR_CARDINAL"));
	        }
	    } finally {
	        dbCon.closeDB(con, pstmt, rs);
	    }

	    return cardinals;
	}

	//강사 번호로 전체 학생 조회
	public List<InstructorStudentVO> selectStudentsByInstructor(String instNum) throws SQLException {
	    List<InstructorStudentVO> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    DBConnection dbCon = DBConnection.getInstance();

	    String sql = "SELECT C.COUR_CARDINAL, S.STU_NAME, C.COUR_NAME, S.STU_STATUS " +
	                 "FROM STUDENT S " +
	                 "JOIN APPLY_STEPS A ON S.STU_NUM = A.STU_NUM " +
	                 "JOIN COURSE C ON A.COUR_NUM = C.COUR_NUM " +
	                 "WHERE C.INST_NUM = ?";

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, instNum);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            InstructorStudentVO vo = new InstructorStudentVO();
	            vo.setCourCardinal(rs.getString("COUR_CARDINAL"));
	            vo.setStudName(rs.getString("STU_NAME"));
	            vo.setCourName(rs.getString("COUR_NAME"));
	            vo.setCourStatus(rs.getString("STU_STATUS"));
	            list.add(vo);
	        }
	    } finally {
	        dbCon.closeDB(con, pstmt, rs);
	    }

	    return list;
	}
	
	//강사번호와 기수로 학생 조회
	public List<InstructorStudentVO> selectStudentsByCardinal(String instNum, String courCardinal) throws SQLException {
	    List<InstructorStudentVO> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    DBConnection dbCon = DBConnection.getInstance();

	    String sql = "SELECT C.COUR_CARDINAL, S.STU_NAME, C.COUR_NAME, S.STU_STATUS " +
	                 "FROM STUDENT S " +
	                 "JOIN APPLY_STEPS A ON S.STU_NUM = A.STU_NUM " +
	                 "JOIN COURSE C ON A.COUR_NUM = C.COUR_NUM " +
	                 "WHERE C.INST_NUM = ? AND C.COUR_CARDINAL = ? ";

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, instNum);
	        pstmt.setString(2, courCardinal);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            InstructorStudentVO vo = new InstructorStudentVO();
	            vo.setCourCardinal(rs.getString("COUR_CARDINAL"));
	            vo.setStudName(rs.getString("STU_NAME"));
	            vo.setCourName(rs.getString("COUR_NAME"));
	            vo.setCourStatus(rs.getString("STU_STATUS"));
	            list.add(vo);
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
	
	//시험 이름만을 가져오는 메소드
	public List<String> selectExamNamesByCardinal(String courCardinal) throws SQLException {
	    List<String> examNames = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT DISTINCT E.EXAM_NAME " +
	                 "FROM EXAM E " +
	                 "JOIN COURSE C ON E.COUR_NUM = C.COUR_NUM " +
	                 "WHERE C.COUR_CARDINAL = ?";
	    DBConnection dbCon = DBConnection.getInstance();

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, courCardinal);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            examNames.add(rs.getString("EXAM_NAME"));
	        }
	    } finally {
	        dbCon.closeDB(con, pstmt, rs);
	    }

	    return examNames;
	}
	
	
	//기수와 과목으로 점수 조회
	public List<InstructorScoreVO> selectScores(String instNum, String courCardinal, String examName) throws SQLException {
	    List<InstructorScoreVO> scores = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT C.COUR_CARDINAL, C.COUR_NAME, E.EXAM_NAME, S.STU_NAME, G.EXAM_ANSW_COUNT ");
	    sql.append("FROM GRADE G ");
	    sql.append("JOIN STUDENT S ON G.STU_NUM = S.STU_NUM ");
	    sql.append("JOIN EXAM E ON G.EXAM_NUM = E.EXAM_NUM ");
	    sql.append("JOIN COURSE C ON E.COUR_NUM = C.COUR_NUM ");
	    sql.append("WHERE C.INST_NUM = ? ");

	    if (courCardinal != null && !"전체".equals(courCardinal)) {
	        sql.append("AND C.COUR_CARDINAL = ? ");
	    }
	    if (examName != null && !"전체".equals(examName)) {
	        sql.append("AND E.EXAM_NAME = ? ");
	    }

	    DBConnection dbCon = DBConnection.getInstance();

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, instNum);

	        int paramIndex = 2;
	        if (courCardinal != null && !"전체".equals(courCardinal)) {
	            pstmt.setString(paramIndex++, courCardinal);
	        }
	        if (examName != null && !"전체".equals(examName)) {
	            pstmt.setString(paramIndex++, examName);
	        }

	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            InstructorScoreVO vo = new InstructorScoreVO();
	            vo.setCourCardinal(rs.getString("COUR_CARDINAL"));
	            vo.setCourName(rs.getString("COUR_NAME"));
	            vo.setExamName(rs.getString("EXAM_NAME"));
	            vo.setStudName(rs.getString("STU_NAME"));
	            vo.setScore(rs.getInt("EXAM_ANSW_COUNT"));
	            scores.add(vo);
	        }
	    } finally {
	        dbCon.closeDB(con, pstmt, rs);
	    }

	    return scores;
	}


	
	
	//게시글 전체 조회
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
	 
	 //선택한 게시물에 대한 내용 조회
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

