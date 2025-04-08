package kr.co.sist.ldu;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class InstructorLoginDAO {

	public InstructorLoginDAO() {

	}

	public List<InstructorAccountVO> selectAllInstructorAccount() throws SQLException {
		// 반환할 List 객체 생성
		List<InstructorAccountVO> list = new ArrayList<InstructorAccountVO>();

		// jdbc 객체 null 생성
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String selectQeury = "SELECT * FROM Instructor";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectQeury);

			// while문으로 List에 값을 넣는다.
			while (rs.next()) {
				InstructorAccountVO saVO = new InstructorAccountVO();
				saVO.setInstNum(rs.getString("Inst_NUM"));
				saVO.setInstPass(rs.getString("Inst_PASS"));
				saVO.setInstName(rs.getString("Inst_NAME"));
				saVO.setInstBirth(rs.getDate("Inst_BIRTH"));
				saVO.setInstTel(rs.getString("Inst_TEL"));
				saVO.setInstAdd(rs.getString("Inst_ADD"));
				list.add(saVO);
			} // end while
		} finally {
			// 연결 끊기
			dbCon.closeDB(con, stmt, rs);
		} // end try-finally

		return list;
	}// selectAllInstructorAccount
	
}// class
