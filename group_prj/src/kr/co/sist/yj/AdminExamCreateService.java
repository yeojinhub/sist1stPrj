package kr.co.sist.yj;

import java.sql.SQLException;

public class AdminExamCreateService {
    private AdminExamCreateDAO dao = new AdminExamCreateDAO();
    
    /**
     * VO에 담긴 데이터를 이용해 EXAM 및 EXAM_QUESTION 5건을 등록한다.
     */
    public boolean createExamQuestions(AdminExamCreateVO vo) {
    	boolean flag = false;
    	
    	try {
			dao.createExamQuestions(vo);
			flag = true;
		} catch (SQLException se) {
			se.printStackTrace();
		} //end try catch
    	
        return flag;
    }
}
