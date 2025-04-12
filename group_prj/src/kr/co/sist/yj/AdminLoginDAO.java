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
		
		DBConnection dbCon = DBConnection.getInstance();
		try {
			con = dbCon.getConn();
			StringBuilder strselectAdminLogin = new StringBuilder();
			strselectAdminLogin
			.append("	select adm_num,adm_pass,adm_name,adm_birth,adm_tel,adm_add	")
			.append("	from	admin	")
			.append("	where	adm_num=?	")
			;
			//3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			pstmt=con.prepareStatement( strselectAdminLogin.toString() );
			
			//4. bind 변수에 값 할당
			pstmt.setInt(1, adm_num);
			
			//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			if( rs.next() ) {
				alVO = new AdminLoginVO();
				
				alVO.setAdm_num( rs.getInt("adm_num") );
				alVO.setAdm_pass( rs.getString("adm_pass") );
				alVO.setAdm_name( rs.getString("adm_name") );
				alVO.setAdm_birth( rs.getString("adm_birth") );
				alVO.setAdm_name( rs.getString("adm_name") );
				alVO.setAdm_tel( rs.getString("adm_tel") );
				alVO.setAdm_add( rs.getString("adm_add") );
				
			} //end if
		} finally {
			//6. 연결 끊기
			dbCon.closeDB(rs, pstmt, con);
		} //end try finally
		
		return alVO;
	} //selectAdminLogin

}
