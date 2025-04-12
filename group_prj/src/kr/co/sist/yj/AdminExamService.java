package kr.co.sist.yj;

import java.sql.SQLException;
import java.util.List;

public class AdminExamService {
	
	public List<AdminExamVO> searchAllExamMember() {
		List<AdminExamVO> examList = null;
		AdminExamDAO examDAO = AdminExamDAO.getInstance();
		
		try {
			examList = examDAO.selectAllExamMember();
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
		
		return examList;
	} //searchAllInstructorAccountMember

} //class
