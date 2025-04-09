package kr.co.sist.ldu;

import java.sql.SQLException;
import java.util.List;

public class ShowStudScoretoInstructorService {
	
	//학생 성적 테이블 반환
	public List<InstructorScoreVO> getScoresByStudent(String stuNum) {
	    ShowStudScoretoInstructorDAO dao = new ShowStudScoretoInstructorDAO();
	    List<InstructorScoreVO> list = null;

	    try {
	        list = dao.selectScoresByStudent(stuNum);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	
}
