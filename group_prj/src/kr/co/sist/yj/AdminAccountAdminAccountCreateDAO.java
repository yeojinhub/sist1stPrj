package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAccountAdminAccountCreateDAO {

	private static AdminAccountAdminAccountCreateDAO aaaacVO;
	
	private AdminAccountAdminAccountCreateDAO() {
		
	} //AdminAccountAdminAccountCreateDAO
	
	//SingleTon 생성
	public static AdminAccountAdminAccountCreateDAO getInstance() {
		if( aaaacVO == null ) {
			aaaacVO = new AdminAccountAdminAccountCreateDAO();
		} //end if
		
		return aaaacVO;
	} //getInstance
	
	public void insertAdminAccountMember(AdminAccountAdminAccountCreateVO aaaacVO) throws SQLException, IOException {
	
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn = DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			//3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strAddAdminAccountMember = new StringBuilder();
			strAddAdminAccountMember
			.append("	insert into admin	")
			.append("	(adm_num,adm_pass,adm_name,adm_birth,adm_tel,adm_add)	")
			.append("	values	")
			.append("	(seq_admin.nextval,?,?,?,?,?)	")
			;
			pstmt = con.prepareStatement( strAddAdminAccountMember.toString() );
			
			//4. bind 변수에 값 할당
			int bindInd=0;
			
			pstmt.setString( ++bindInd, aaaacVO.getAdm_pass() );
			pstmt.setString( ++bindInd, aaaacVO.getAdm_name() );
			Date birthDate = aaaacVO.getAdm_birth();
			pstmt.setDate( ++bindInd, birthDate );
			pstmt.setString( ++bindInd, aaaacVO.getAdm_tel() );
			pstmt.setString( ++bindInd, aaaacVO.getAdm_add() );
			
			//5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertAdminAccountMember
	
}  //class
