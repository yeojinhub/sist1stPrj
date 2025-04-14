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

	private AdminExamDAO dao = AdminExamDAO.getInstance();
    
    public boolean deleteExam(int examNum) {
        boolean flag = false;
        try {
            flag = dao.deleteExam(examNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
	
	
	
} //class
