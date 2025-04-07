package kr.co.sist.kti;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.kti.StudentAccountVO;

public class StudentLoginService {

	public StudentLoginService() {

	}// StudentLoginService
	
	public List<StudentAccountVO> searchAllStudentAccount() {
		// DAO 객체 생성.
		StudentLoginDAO slDAO = new StudentLoginDAO();
		
		// 반환할 List 객체 null로 생성.
		List<StudentAccountVO> list = null;
		
		try {
			// list에 DAO 메소드로 반환.
			list = slDAO.selectAllStudentAccount();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
		
		return list;
	}// searchAllStudentAccount
	
}
