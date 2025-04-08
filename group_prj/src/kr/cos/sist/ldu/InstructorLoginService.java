package kr.cos.sist.ldu;

import java.sql.SQLException;
import java.util.List;


public class InstructorLoginService {

	public InstructorLoginService() {

	}// InstructorLoginService
	
	public List<InstructorAccountVO> searchAllInstructorAccount() {
		// DAO 객체 생성.
		InstructorLoginDAO slDAO = new InstructorLoginDAO();
		
		// 반환할 List 객체 null로 생성.
		List<InstructorAccountVO> list = null;
		
		try {
			// list에 DAO 메소드로 반환.
			list = slDAO.selectAllInstructorAccount();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
		
		return list;
	}// searchAllInstructorAccount
	
}
