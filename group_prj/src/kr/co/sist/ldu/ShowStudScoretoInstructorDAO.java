package kr.co.sist.ldu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowStudScoretoInstructorDAO {

	//학생의 성적 테이블 출력을 위해 조회
	public List<InstructorScoreVO> selectScoresByStudent(String stuNum) throws SQLException {
	    List<InstructorScoreVO> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    DBConnection dbCon = DBConnection.getInstance();

	    String sql = "SELECT E.EXAM_NAME, G.EXAM_ANSW_COUNT, G.STU_NUM " +
	                 "FROM GRADE G " +
	                 "JOIN EXAM E ON G.EXAM_NUM = E.EXAM_NUM " +
	                 "WHERE G.STU_NUM = ?";

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, stuNum);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	        	InstructorScoreVO vo = new InstructorScoreVO();
	            vo.setExamName(rs.getString("EXAM_NAME"));
	            vo.setScore(rs.getInt("EXAM_ANSW_COUNT"));
	            list.add(vo);
	        }
	    } finally {
	        dbCon.closeDB(con, pstmt, rs);
	    }

	    return list;
	}

	
}
