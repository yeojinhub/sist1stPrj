package kr.co.sist.kti;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.DBConnection;
import kr.co.sist.kti.StudentAccountVO;

public class StudentLoginDAO {

	public StudentLoginDAO() {

	}

	public List<StudentAccountVO> selectAllStudentAccount() throws SQLException {
		// 반환할 List 객체 생성
		List<StudentAccountVO> list = new ArrayList<StudentAccountVO>();

		// jdbc 객체 null 생성
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String selectQeury = "SELECT * FROM STUDENT";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQeury);

			// while문으로 List에 값을 넣는다.
			while (rs.next()) {
				StudentAccountVO saVO = new StudentAccountVO();
				saVO.setStuNum(rs.getString("STU_NUM"));
				saVO.setStuPass(rs.getString("STU_PASS"));
				saVO.setStuName(rs.getString("STU_NAME"));
				saVO.setStuBirth(rs.getDate("STU_BIRTH"));
				saVO.setStuTel(rs.getString("STU_TEL"));
				saVO.setStuAdd(rs.getString("STU_ADD"));
				saVO.setStuStatus(rs.getString("STU_STATUS"));
				list.add(saVO);
			} // end while
		} finally {
			// 연결 끊기
			dbCon.closeDB(con, stmt, rs);
		} // end try-finally

		return list;
	}// selectAllStudentAccount
	
}// class
