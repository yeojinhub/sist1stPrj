package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAccountStudentAccountCreateDAO {

	private static AdminAccountStudentAccountCreateDAO aasacVO;
	
	private AdminAccountStudentAccountCreateDAO() {
		
	} //AdminAccountStudentAccountCreateDAO
	
	//SingleTon 생성
	public static AdminAccountStudentAccountCreateDAO getInstance() {
		if ( aasacVO == null ) {
			aasacVO = new AdminAccountStudentAccountCreateDAO();
		} //end if
		
		return aasacVO;
	} //getInstance
	
	public void insertStudentAccountMember(AdminAccountStudentAccountCreateVO aasacVO) throws SQLException, IOException {
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn = DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			//3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strAddStudentAccountMember = new StringBuilder();
			strAddStudentAccountMember
			.append("	insert into student	")
			.append("	(stu_num,stu_pass,stu_name,stu_birth,stu_tel,stu_add,stu_status)	")
			.append("	values	")
			.append("	(seq_student.nextval,?,?,?,?,?,?)	")
			;
			pstmt = con.prepareStatement( strAddStudentAccountMember.toString() );
			
			//4. bind 변수에 값 할당
			int bindInd=0;
			
			pstmt.setString( ++bindInd, aasacVO.getStu_name() );
			pstmt.setString( ++bindInd, aasacVO.getStu_pass() );
			Date birthDate = aasacVO.getStu_birth();
			pstmt.setDate( ++bindInd, birthDate );
			pstmt.setString( ++bindInd, aasacVO.getStu_tel() );
			pstmt.setString( ++bindInd, aasacVO.getStu_add() );
			pstmt.setString( ++bindInd, aasacVO.getStu_status() );
			
			//5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertStudentAccountMember
	
} //class
