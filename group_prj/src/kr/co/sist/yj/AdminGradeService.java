package kr.co.sist.yj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminGradeService {

	public List<AdminGradeVO> searchAllGradeInfo() {
		List<AdminGradeVO> list = new ArrayList<AdminGradeVO>();
		
		// DAO객체 생성
		AdminGradeDAO agDAO = new AdminGradeDAO();
		
		try {
			list = agDAO.selectGradeAllInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
		
		return list;
	}// searchAllGradeInfo
	
	public AdminGradeConditionVO searchGradeSearchCondition() {
		AdminGradeConditionVO agcVO = new AdminGradeConditionVO();
		
		// DAO객체 생성
		AdminGradeDAO agDAO = new AdminGradeDAO();
		
		try {
			agcVO = agDAO.selectGradeSearchCondition();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end try-catch
		
		return agcVO;
	}// searchAllGradeInfo
	
}// class
