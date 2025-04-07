package kr.co.sist.kti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.DBConnection;

public class StudentInfoDAO {

	public boolean updateChangePassword(String password, String stuNum) throws SQLException {
		boolean result = false;

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 비밀번호 변경 쿼리문 생성
		String updateQuery = "UPDATE STUDENT SET STU_PASS = ? WHERE STU_NUM = ?";

		try {
			// jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(updateQuery);

			// 바인드 변수 값 할당
			pstmt.setString(1, password);
			pstmt.setString(2, stuNum);

			// 쿼리 실행
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, null);
		} // end try-finally

		return result;
	}// updateChangePassword

	public boolean updateChangeInfo(String tel, String address, String stuNum) throws SQLException {
		boolean result = false;

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 정보 변경 쿼리문 생성
		String updateQuery = "UPDATE STUDENT SET STU_TEL = ?, STU_ADD = ? WHERE STU_NUM = ?";

		try {
			// jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(updateQuery);

			// 바인드 변수 값 할당
			pstmt.setString(1, tel);
			pstmt.setString(2, address);
			pstmt.setString(3, stuNum);

			// 쿼리 실행
			result = pstmt.executeUpdate() != 0 ? true : false;

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, null);
		} // end try-finally

		return result;
	}// updateChangeInfo

}// class
