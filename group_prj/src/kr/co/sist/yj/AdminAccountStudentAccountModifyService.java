package kr.co.sist.yj;

import java.sql.SQLException;

public class AdminAccountStudentAccountModifyService {

	public AdminAccountStudentAccountModifyService() {

	} // AdminAccountStudentAccountModifyService

	/**
	 * 학생 계정 수정
	 * 
	 * @param aasamVO 수정할 학생 계정 정보가 담긴 VO
	 * @return 수정 성공시 true, 실패시 false
	 */
	public boolean modifyStudentAccountMember(AdminAccountStudentAccountModifyVO aasamVO) {
		boolean flag = false;

		AdminAccountStudentAccountModifyDAO aasamDAO = AdminAccountStudentAccountModifyDAO.getInstance();
		try {
			aasamDAO.updateStudentAccountMember(aasamVO);
		} catch (SQLException se) {
			se.printStackTrace();
		} // end try catch

		return flag;
	} // modifyStudentAccountMember

	/**
	 * 학생 계정 삭제
	 * 
	 * @param num 삭제할 학생의 학번
	 * @return 삭제 성공시 true, 실패시 false
	 */
	public boolean removeStudentAccountMember(int num) {
		boolean flag = false;

		AdminAccountStudentAccountModifyDAO aasamDAO = AdminAccountStudentAccountModifyDAO.getInstance();

		try {
			flag = aasamDAO.deleteStudentAccountMember(num) == 1;
		} catch (SQLException se) {
			se.printStackTrace();
		} // end try catch

		return flag;
	} // removeStudentAccountMember

} // class
