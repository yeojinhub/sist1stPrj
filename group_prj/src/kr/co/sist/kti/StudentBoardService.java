package kr.co.sist.kti;

import java.sql.SQLException;

import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardService {

	public boolean changeBoardPost(String boardTitle, String boardContent, int boardNum) {
		boolean result = false;

		// DAO 객체 생성
		StudentBoardDAO sbDAO = new StudentBoardDAO();

		try {
			result = sbDAO.updateChangeBoardPost(boardTitle, boardContent, boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return result;
	}

	public boolean removeBoardPost(int boardNum) {
		boolean result = false;

		// DAO 객체 생성
		StudentBoardDAO sbDAO = new StudentBoardDAO();

		try {
			result = sbDAO.deleteBoardPost(boardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try-catch

		return result;
	}// removeBoardPost

	public void addBoardPost(StudentBoardVO sbvo) {
		StudentBoardDAO sbDAO = new StudentBoardDAO();

		try {
			sbDAO.insertWriteBoardPost(sbvo);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try

	}// addBoardPost
}// class
