package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 강사 계정 등록
	 * @param aaiaiVO 등록할 강사 계정 정보가 담긴 VO
	 * @throws SQLException 예외처리
	 * @throws IOException 예외처리
	 */
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
			.append("	('seq_inst_num',?,?,?,?,?)	")
			;
			
			pstmt=con.prepareStatement(strInstructorAccountMember.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, aaiaiVO.getInstPass());
			pstmt.setString(++bindInd, aaiaiVO.getInstName());
			Date birthDate = aaiaiVO.getInstBirth();
			pstmt.setDate(++bindInd, birthDate );
			pstmt.setString(++bindInd, aaiaiVO.getInstTel());
			pstmt.setString(++bindInd, aaiaiVO.getInstAdd());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		}
		
	} //insertInstructorAccountMember
	
	/**
	 * 강사 계정 수정
	 * @param aaiaiVO 수정할 강사 계정 정보가 담긴 VO
	 * @return
	 * @throws SQLException 예외처리
	 */
	public int updateInstructorAccountMember(AdminAccountInstructorAccountInfoVO aaiaiVO) throws SQLException {
		int rowCnt=0;
		
		// 1. Driver 로딩
		// 2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strUpdateInstructorAccountMember = new StringBuilder();
			strUpdateInstructorAccountMember
			.append("	update instructor	")
			.append("	set	inst_tel=?,inst_add=?	")
			.append("	where inst_num=?	")
			;
			pstmt=con.prepareStatement(strUpdateInstructorAccountMember.toString());
			
			// 4. bind 변수 값 설정
			pstmt.setString(1, aaiaiVO.getInstTel());
			pstmt.setString(2, aaiaiVO.getInstAdd());
			pstmt.setString(3, aaiaiVO.getInstNum());
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //updateInstructorAccountMember
	
	/**
	 * 강사 계정 삭제
	 * @param num 삭제할 강사의 사번
	 * @return 
	 * @throws SQLException 예외처리
	 */
	public int deleteInstructorAccountMember(String num) throws SQLException {
		int instNum=0;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn = DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteInstructorAccountMember = new StringBuilder();
			strDeleteInstructorAccountMember
			.append("	delete from	instructor	")
			.append("	where inst_num=?	")
			;
			pstmt = con.prepareStatement(strDeleteInstructorAccountMember.toString());
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, num);
			
			// 5. 쿼리문 수행 후 결과 얻기
			instNum=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return instNum;
	} //deleteInstructorAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return
	 * @throws SQLException 예외처리
	 */
	public List<AdminAccountInstructorAccountInfoVO> selectAllInstructorAccountMember() throws SQLException {
		List<AdminAccountInstructorAccountInfoVO> instructorList = new ArrayList<AdminAccountInstructorAccountInfoVO>();
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			//3. 쿼리문 객체 생성
			StringBuilder strSelectAllInstructorAccountMember = new StringBuilder();
			strSelectAllInstructorAccountMember
			.append("	select 	inst_num,inst_name,inst_birth,inst_tel,inst_add	")
			.append("	from	instructor	")
			.append("	order by	inst_num	")
			;
			pstmt=con.prepareStatement(strSelectAllInstructorAccountMember.toString());
			
			//4. bind 변수 값 할당
			//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountInstructorAccountInfoVO aaiaiVO = null;
			//레코드 존재여부 확인
			while( rs.next() ) {
				aaiaiVO = new AdminAccountInstructorAccountInfoVO();
				
				aaiaiVO.setInstName(rs.getString("inst_name"));
				aaiaiVO.setInstNum(rs.getString("inst_num"));
				aaiaiVO.setInstBirth(rs.getDate("inst_birth"));
				aaiaiVO.setInstTel(rs.getString("inst_tel"));
				aaiaiVO.setInstAdd(rs.getString("inst_add"));
				
				instructorList.add(aaiaiVO);
			} //end while
			
		} finally {
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
					
		return instructorList;
	} //selectAllInstructorAccountMember
	
	/**
	 * 한명의 강사 계정 조회
	 * @param num 조회할 강사의 사번
	 * @return
	 * @throws SQLException 예외처리
	 */
	public AdminAccountInstructorAccountInfoVO selectOneInstructorAccountMember(String num) throws SQLException {
		AdminAccountInstructorAccountInfoVO aaiaiVO = null;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectOneInstructorAccountMember = new StringBuilder();
			strSelectOneInstructorAccountMember
			.append("	select inst_name,inst_num,inst_pass,inst_birth,inst_tel,inst_add	")
			.append("	from instructor	")
			.append("	where inst_num=?	")
			;
			
			pstmt=con.prepareStatement(strSelectOneInstructorAccountMember.toString());
			
			// 4. bind 변수 값 할당
			pstmt.setString(1, num);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			// 레코드 존재여부 확인
			if( rs.next() ) {
				aaiaiVO = new AdminAccountInstructorAccountInfoVO();
				// 값을 VO 객체에 저장
				aaiaiVO.setInstName(rs.getString("inst_name"));
				aaiaiVO.setInstNum(rs.getString("inst_num"));
				aaiaiVO.setInstPass(rs.getString("inst_pass"));
				aaiaiVO.setInstBirth(rs.getDate("inst_birth"));
				aaiaiVO.setInstTel(rs.getString("inst_tel"));
				aaiaiVO.setInstAdd(rs.getString("inst_add"));
			} //end if
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return aaiaiVO;
		
	} //AdminAccountInstructorAccountInfoVO
	
} //class
