package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAccountStudentAccountModifyDAO {

	private static AdminAccountStudentAccountModifyDAO aasamVO;
	
	private AdminAccountStudentAccountModifyDAO() {
		
	} //AdminAccountStudentAccountModifyDAO
	
	//SingleTon 생성
	public static AdminAccountStudentAccountModifyDAO getInstance() {
		if( aasamVO == null ) {
			aasamVO = new AdminAccountStudentAccountModifyDAO();
		} //end if
		
		return aasamVO;
	} //getInstance
	
	public int updateStudentAccountMember(AdminAccountStudentAccountModifyVO aasamVO) throws SQLException {
		int rowCnt=0;
		
		//1. Driver 로딩
		//2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		try {
			con = dbConn.getConn();
			
			//3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strUpdateStudentAccountMember = new StringBuilder();
			strUpdateStudentAccountMember
			.append("	update	student	")
			.append("	set	stu_tel=?,stu_add=?	")
			.append("	where stu_num=?	")
			;
			pstmt=con.prepareStatement( strUpdateStudentAccountMember.toString() );
			
			//4. bind 변수 값 설정
			pstmt.setString(1, aasamVO.getStu_tel());
			pstmt.setString(2, aasamVO.getStu_add());
			pstmt.setInt(3, aasamVO.getStu_num());
			
			//5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //updateStudentAccountMember
	
	public int deleteStudentAccountMember(int num) throws SQLException {
		int stu_num=0;
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn = DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			//3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteStudentAccountMember = new StringBuilder();
			strDeleteStudentAccountMember
			.append("	delete	from	student	")
			.append("	where	stu_num=?	")
			;
			pstmt = con.prepareStatement( strDeleteStudentAccountMember.toString() );
			
			//4. bind 변수에 값 할당
			pstmt.setInt(1, num);
			
			//5. 쿼리문 수행 후 결과 얻기
			stu_num=pstmt.executeUpdate();
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return stu_num;
	} //deleteStudentAccountMember
	
} //class
