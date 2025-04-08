package kr.co.sist.ldu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstructorBoardDAO {
	public int updateBoardComment(int boardNum, String comment, String instNum, Date commDate, String boardType) throws SQLException {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    int rowCnt = 0;

	    String sql = "UPDATE BOARD "
	               + "SET BOARD_COMM_CONTENT = ?, "
	               + "    BOARD_COMM_DATE = ?, "
	               + "    INST_NUM = ?, "
	               + "    BOARD_STATUS = '답변완료', "
	               + "    BOARD_TYPE = ? "
	               + "WHERE BOARD_NUM = ?";

	    DBConnection dbCon = DBConnection.getInstance();

	    try {
	        con = dbCon.getConn();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, comment);
	        pstmt.setDate(2, commDate);
	        pstmt.setString(3, instNum);
	        pstmt.setString(4, boardType);   // ← 여기서 '강사' 또는 '관리자'
	        pstmt.setInt(5, boardNum);

	        rowCnt = pstmt.executeUpdate();
	    } finally {
	        dbCon.closeDB(con, pstmt, null);
	    }

	    return rowCnt;
	}

}
