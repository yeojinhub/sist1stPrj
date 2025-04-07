package kr.co.sist.kti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.DBConnection;
import kr.co.sist.kti.StudentBoardVO;
import kr.co.sist.kti.StudentExamVO;

public class StudentExamDAO {

	public List<StudentExamVO> selectLoginedStudentExam(String examName) throws SQLException {
		List<StudentExamVO> list = new ArrayList<StudentExamVO>();

		// jdbc 객체 null 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Singleton 객체 생성
		DBConnection dbCon = DBConnection.getInstance();

		// 학생 테이블을 전체 조회할 쿼리문 생성
		String selectExamOptionQeury = "SELECT * FROM EXAM_QUESTION WHERE EXAM_NUM = (SELECT EXAM_NUM	"
				+ "FROM EXAM	"
				+ "WHERE EXAM_NAME = ?)";

		try {
			// 생성한 jdbc 객체 생성
			con = dbCon.getConn();
			pstmt = con.prepareStatement(selectExamOptionQeury);

			// 바인드 변수 설정
			pstmt.setString(1, examName);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 반복문으로 리스트에 VO 객체 넣기
			while(rs.next()) {
				StudentExamVO seVO = new StudentExamVO();
				seVO.setQuesNum(rs.getInt("QUES_NUM"));
				seVO.setQuesContent(rs.getString("QUES_CONTENT"));
				seVO.setQuesOption(rs.getString("QUES_OPTION"));
				seVO.setQuesOptionCorrect(rs.getInt("QUES_OPTION_CORRECT"));
				seVO.setExamNum(rs.getInt("EXAM_NUM"));
				list.add(seVO);
			}// end while

		} finally {
			// 연결 끊기
			dbCon.closeDB(con, pstmt, rs);
		} // end try-finally

		return list;
	}// selectLoginedStudentExam

}
