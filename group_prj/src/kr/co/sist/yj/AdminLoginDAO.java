package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {
	
	private static AdminLoginDAO alVO;
	
	private AdminLoginDAO() {
		
	} //AdminLoginDAO
	
	//Singleton 생성
	public static AdminLoginDAO getInstance() {
		if( alVO == null ) {
			alVO = new AdminLoginDAO();
		} //end if
		
		return alVO;
	} //getInstance
	
	public AdminLoginVO selectAdminLogin(int adm_num) throws SQLException, IOException {
		AdminLoginVO alVO = null;
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		DbConnection dbCon = DbConnection.getInstance();
		
		return alVO;
	}

}
