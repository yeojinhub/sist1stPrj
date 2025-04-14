package kr.co.sist.yj;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class AdminBoardDAO {

    // 전체 게시글 조회
	public List<AdminBoardVO> selectAllBoardList() throws SQLException {
	    List<AdminBoardVO> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT B.BOARD_NUM, B.BOARD_TITLE, S.STU_NAME, B.BOARD_DATE, B.BOARD_STATUS " +
	                 "FROM BOARD B " +
	                 "JOIN STUDENT S ON B.STU_NUM = S.STU_NUM " +
	                 "ORDER BY B.BOARD_NUM DESC"; // 👈 조건 없음

	    try {
	        con = DBConnection.getInstance().getConn();
	        pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            AdminBoardVO vo = new AdminBoardVO();
	            vo.setBoardNum(rs.getInt("BOARD_NUM"));
	            vo.setBoardTitle(rs.getString("BOARD_TITLE"));
	            vo.setStuName(rs.getString("STU_NAME"));
	            vo.setBoardDate(rs.getDate("BOARD_DATE"));
	            vo.setBoardStatus(rs.getString("BOARD_STATUS"));
	            list.add(vo);
	        }
	    } finally {
	        DBConnection.getInstance().closeDB(rs, pstmt, con);
	    }

	    return list;
	}



    // 단일 게시글 조회
	public AdminBoardVO selectBoardByNum(int boardNum) throws SQLException {
	    AdminBoardVO vo = null;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT " +
	    	    "B.BOARD_NUM, B.BOARD_TITLE, B.BOARD_CONTENT, B.BOARD_DATE, B.BOARD_STATUS, " +
	    	    "B.BOARD_COMM_CONTENT, B.BOARD_COMM_DATE, B.BOARD_TYPE, B.STU_NUM, B.ADM_ID, " +
	    	    "S.STU_NAME " +
	    	    "FROM BOARD B " +
	    	    "JOIN STUDENT S ON B.STU_NUM = S.STU_NUM " + // ← LEFT JOIN으로 변경!
	    	    "WHERE B.BOARD_NUM = ?";
	    
	    try {
	        con = DBConnection.getInstance().getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, boardNum);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            vo = new AdminBoardVO();
	            vo.setBoardNum(rs.getInt("BOARD_NUM"));
	            vo.setBoardTitle(rs.getString("BOARD_TITLE"));
	            vo.setBoardContent(rs.getString("BOARD_CONTENT"));
	            vo.setBoardDate(rs.getDate("BOARD_DATE"));
	            vo.setBoardStatus(rs.getString("BOARD_STATUS"));
	            vo.setBoardCommContent(rs.getString("BOARD_COMM_CONTENT"));
	            vo.setBoardCommDate(rs.getDate("BOARD_COMM_DATE"));
	            vo.setBoardType(rs.getString("BOARD_TYPE"));
	            vo.setStuNum(rs.getString("STU_NUM"));
	            vo.setStuName(rs.getString("STU_NAME"));
	            vo.setAdmId(rs.getString("ADM_ID"));
	        }
	    } finally {
	        DBConnection.getInstance().closeDB(rs, pstmt, con);
	    }

	    return vo;
	}


    // 댓글 등록 (답변 등록)
    public boolean insertComment(int boardNum, String commContent, Date commDate, String admId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean result = false;

        String sql = "UPDATE BOARD SET BOARD_COMM_CONTENT = ?, BOARD_COMM_DATE = ?, "
        		+ "ADM_ID = ?, BOARD_TYPE = ?, BOARD_STATUS = '답변완료' " +
                "WHERE BOARD_NUM = ?";


        try {
            con = DBConnection.getInstance().getConn();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, commContent);
            pstmt.setDate(2, commDate);
            pstmt.setString(3, admId ); // 하드코딩된 admin_Id
            pstmt.setString(4, "관리자");
            pstmt.setInt(5, boardNum);

            int updated = pstmt.executeUpdate();
            result = updated == 1;
        } finally {
            DBConnection.getInstance().closeDB(null, pstmt, con);
        }

        return result;
    }
}
