package kr.co.sist.kti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.DBConnection;
import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardDAO {

	public boolean updateChangeBoardPost(String boardTitle, String boardContent, int boardNum) throws SQLException {
		boolean result = false;

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String updateChangeQeury = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_NUM = ?";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(updateChangeQeury);

			// 바인드 변수 값 할당
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNum);

			// 쿼리 실행
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, null);
		} // end try-finally

		return result;
	}// updateChangeBoardPost

	public boolean deleteBoardPost(int boardNum) throws SQLException {
		boolean result = false;

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String updateChangeQeury = "DELETE BOARD WHERE BOARD_NUM = ?";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(updateChangeQeury);

			// 바인드 변수 값 할당
			pstmt.setInt(1, boardNum);

			// 쿼리 실행
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, null);
		} // end try-finally

		return result;
	}

	public void insertWriteBoardPost(StudentBoardVO sbvo) throws SQLException{
		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String insertWriteQeury = "INSERT INTO BOARD (BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, STU_NUM) VALUES (SEQ_BOARD_NUM.NEXTVAL, ?, ?, ?)";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(insertWriteQeury);

			// 바인드 변수 값 할당
			pstmt.setString(1, sbvo.getBoardTitle());
			pstmt.setString(2, sbvo.getBoardContent());
			pstmt.setString(3, sbvo.getStuNum());

			// 쿼리 실행
			pstmt.executeUpdate();

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, rs);
		} // end try-finally
	}// insertWriteBoardPost

}// class
