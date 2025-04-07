package kr.co.sist.kti;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.StudentBoardVO;
import kr.co.sist.kti.StudentMainVO;

public class StudentMainService {

	public StudentMainService() {

	}// StudentMainService

	public StudentMainVO searchMyCourseInfo(String stuNum) {
		StudentMainVO scVO = null;
		// DAO 객체 생성
		StudentMainDAO smDAO = new StudentMainDAO();

		try {
			// VO객체에 반환값 넣기
			scVO = smDAO.selectMyCourseInfo(stuNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return scVO;
	}// searchMyCourseInfo

	public List<StudentBoardVO> searchBoardInfo() {
		List<StudentBoardVO> boardList = null;

		// DAO 객체 생성
		StudentMainDAO smDAO = new StudentMainDAO();

		try {
			boardList = smDAO.selectBoardInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return boardList;
	}// searchBoardInfo

}// class
