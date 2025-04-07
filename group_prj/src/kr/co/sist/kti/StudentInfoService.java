package kr.co.sist.kti;

import java.sql.SQLException;

public class StudentInfoService {

	public boolean changePassword(String password, String stuNum) {
		boolean result = false;

		// DAO 객체 생성
		StudentInfoDAO siDAO = new StudentInfoDAO();

		try {
			result = siDAO.updateChangePassword(password, stuNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}// changePassword

	public boolean changeInfo(String tel, String address, String stuNum) {
		boolean result = false;

		// DAO 객체 생성
		StudentInfoDAO siDAO = new StudentInfoDAO();

		try {
			result = siDAO.updateChangeInfo(tel, address, stuNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}// changeInfo

}// class
