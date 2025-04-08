package kr.co.sist.yj;

import java.io.IOException;
import java.sql.SQLException;

public class AdminLoginService {

	public AdminLoginVO searchMember(int num) {
		AdminLoginVO alVO = null;

		try {
			alVO = AdminLoginDAO.getInstance().selectAdminLogin(num);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end try catch

		return alVO;
	} // searchMember

} // class
