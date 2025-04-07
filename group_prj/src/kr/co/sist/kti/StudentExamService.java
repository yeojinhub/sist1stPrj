package kr.co.sist.kti;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.kti.StudentExamVO;
import kr.co.sist.kti.StudentGradeVO;

public class StudentExamService {

	public List<StudentExamVO> searchExamQuestion(String examName) {
		List<StudentExamVO> list = null;

		// DAO 객체 생성
		StudentExamDAO seDAO = new StudentExamDAO();

		try {
			list = seDAO.selectLoginedStudentExam(examName);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return list;
	}// searchExamQuestion

	public void addExamGrade(String stuNum, int examNum, int score) {
		// DAO 객체 생성
		StudentExamDAO seDAO = new StudentExamDAO();

		try {
			seDAO.insertExamGrade(stuNum, examNum, score);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

	}// addExamGrade

	public StudentGradeVO searchStudentExamGrade(String stuNum, String examName) {
		StudentGradeVO sgVO = null;
		// DAO 객체 생성
		StudentExamDAO seDAO = new StudentExamDAO();

		try {
			sgVO = seDAO.selectStudentExamGrade(stuNum, examName);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return sgVO;
	}// searchStudentExamGrade

}// class
