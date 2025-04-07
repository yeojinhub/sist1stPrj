package kr.co.sist.kti;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.kti.StudentExamVO;

public class StudentExamService {

	public List<StudentExamVO> searchExamQuestion(String examName) {
		List<StudentExamVO> list = null;
		
		// DAO 객체 생성
		StudentExamDAO seDAO = new StudentExamDAO();
		
		try {
			list = seDAO.selectLoginedStudentExam(examName);
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
		
		return list;
	}
	
}
