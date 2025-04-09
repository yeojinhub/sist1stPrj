package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAccountInstructorAccountInfoDAO {
 
	private static AdminAccountInstructorAccountInfoDAO aaiaiVO;
	
	private AdminAccountInstructorAccountInfoDAO() {
		
	} //AdminAccountInstructorAccountInfoDAO
	
	//SingleTon 생성
	public static AdminAccountInstructorAccountInfoDAO getInstance() {
		if( aaiaiVO == null ) {
			aaiaiVO = new AdminAccountInstructorAccountInfoDAO();
		} //end if
		
		return aaiaiVO;
	} //getInstance
	
	public void insertInstructorAccountMember(AdminAccountInstructorAccountInfoVO aaiaiVO) throws SQLException, IOException {
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn = DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strInstructorAccountMember = new StringBuilder();
			strInstructorAccountMember
			.append("	insert into instructor	")
			.append("	(inst_num,inst_pass,inst_name,inst_birth,inst_tel,inst_add)	")
			.append("	values	")
			.append("	('2025_0102',?,?,?,?,?)	")
			;
			
			pstmt=con.prepareStatement(strInstructorAccountMember.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, aaiaiVO.getInst_pass());
			pstmt.setString(++bindInd, aaiaiVO.getInst_name());
			Date birthDate = aaiaiVO.getInst_birth();
			pstmt.setDate(++bindInd, birthDate );
			pstmt.setString(++bindInd, aaiaiVO.getInst_tel());
			pstmt.setString(++bindInd, aaiaiVO.getInst_add());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		}
		
	} //insertInstructorAccountMember
	
} //class
