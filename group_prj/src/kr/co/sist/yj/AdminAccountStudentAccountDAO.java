package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminAccountStudentAccountDAO {

	private static AdminAccountStudentAccountDAO aasaDAO;
	
	private AdminAccountStudentAccountDAO() {
		
	} //AdminAccountStudentAccountDAO
	
	//SingleTon 생성
	public static AdminAccountStudentAccountDAO getInstance() {
		if( aasaDAO == null ) {
			aasaDAO = new AdminAccountStudentAccountDAO();
		} //end if
		
		return aasaDAO;
	} //getInstance
	
	public int searchCntStudentAccountMember() throws SQLException {
		int cnt=0;
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			//3. 쿼리문 객체 생성
			StringBuilder strSearchCntStudentAccountMember = new StringBuilder();
			strSearchCntStudentAccountMember
			.append("	select count(stu_num) as cnt	")
			.append("	from student stu, course cour	")
			.append("	where stu.stu_num=cour.stu_num	")
			;
			
			pstmt=con.prepareStatement(strSearchCntStudentAccountMember.toString());
			
			//4. bind 변수 값 할당
			//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			//레코드 존재여부 확인
			if( rs.next() ) {
				cnt=rs.getInt("cnt");
			} //end if
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return cnt;
	} //searchCntStudentAccountMember
	
	public List<AdminAccountStudentAccountVO> selectAllStudentAccountMember() throws SQLException {
		List<AdminAccountStudentAccountVO> studentList = new ArrayList<AdminAccountStudentAccountVO>();
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			//3. 쿼리문 객체 생성
			StringBuilder strSelectAllStudentAccountMember = new StringBuilder();
			strSelectAllStudentAccountMember
			.append("	select stu.stu_num,stu.stu_name,stu.stu_tel,cour.cour_cardinal,cour.cour_name,stu.stu_status	")
			.append("	from student stu, apply_steps apply, course cour	")
			.append("	where stu.stu_num=apply.stu_num	")
			.append("	and (apply.cour_num=cour.cour_num)	")
			.append("	order by stu.stu_num	")
			;
			pstmt=con.prepareStatement(strSelectAllStudentAccountMember.toString());
			
			//4. bind 변수 값 할당
			//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountStudentAccountVO aasaVO=null;
			//레코드 존재여부 확인
			while( rs.next() ) {
				aasaVO = new AdminAccountStudentAccountVO();
				
				aasaVO.setStu_num(rs.getString("stu_num"));
				aasaVO.setStu_name(rs.getString("stu_name"));
				aasaVO.setStu_tel(rs.getString("stu_tel"));
				aasaVO.setCour_cardinal(rs.getString("cour_cardinal"));
				aasaVO.setCour_name(rs.getString("cour_name"));
				aasaVO.setStu_status(rs.getString("stu_status"));
			
				studentList.add(aasaVO);
			} //end while
			
		} finally {
			//6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return studentList;
	} // selectAllStudentAccountMember
	
} //class
