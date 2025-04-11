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
 
	private static AdminAccountInstructorAccountInfoDAO instVO;
	
	private AdminAccountInstructorAccountInfoDAO() {
		
	} //AdminAccountInstructorAccountInfoDAO
	
	//SingleTon 생성
	public static AdminAccountInstructorAccountInfoDAO getInstance() {
		if( instVO == null ) {
			instVO = new AdminAccountInstructorAccountInfoDAO();
		} //end if
		
		return instVO;
	} //getInstance
	
	/**
	 * 강사 계정 등록
	 * @param instVO 등록할 강사 계정 정보가 담긴 VO
	 * @throws SQLException 예외처리
	 * @throws IOException 예외처리
	 */
	public void insertInstructorAccountMember(AdminAccountInstructorAccountInfoVO instVO) throws SQLException, IOException {
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn = DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strInsertInstructorAccountQuery = new StringBuilder();
			strInsertInstructorAccountQuery
			.append("	insert into instructor	")
			.append("	(inst_num,inst_pass,inst_name,inst_birth,inst_tel,inst_add)	")
			.append("	values	")
			.append("	(to_char(sysdate,'yyyy_')||trim(to_char(seq_inst_num.nextval,'0000')),?,?,?,?,?)	")
			;
			
			pstmt=con.prepareStatement(strInsertInstructorAccountQuery.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, instVO.getInstPass());
			pstmt.setString(++bindInd, instVO.getInstName());
			Date birthDate = instVO.getInstBirth();
			pstmt.setDate(++bindInd, birthDate );
			pstmt.setString(++bindInd, instVO.getInstTel());
			pstmt.setString(++bindInd, instVO.getInstAdd());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
		
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertInstructorAccountMember
	
	/**
	 * 강사 계정 수정
	 * @param instVO 수정할 강사 계정 정보가 담긴 VO
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int updateInstructorAccountMember(AdminAccountInstructorAccountInfoVO instVO) throws SQLException {
		int rowCnt=0;
		
		// 1. Driver 로딩
		// 2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strUpdateInstructorAccountQuery = new StringBuilder();
			strUpdateInstructorAccountQuery
			.append("	update instructor	")
			.append("	set	inst_tel=?,inst_add=?	")
			.append("	where inst_num=?	")
			;
			pstmt=con.prepareStatement(strUpdateInstructorAccountQuery.toString());
			
			// 4. bind 변수 값 설정
			pstmt.setString(1, instVO.getInstTel());
			pstmt.setString(2, instVO.getInstAdd());
			pstmt.setString(3, instVO.getInstNum());
			
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
	 * @param instNum 삭제할 강사의 사번
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int deleteInstructorAccountMember(String instNum) throws SQLException {
		int rowCnt=0;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn = DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteInstructorAccountQuery = new StringBuilder();
			strDeleteInstructorAccountQuery
			.append("	delete from	instructor	")
			.append("	where inst_num=?	")
			;
			pstmt = con.prepareStatement(strDeleteInstructorAccountQuery.toString());
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, instNum);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //deleteInstructorAccountMember
	
	/**
	 * 전체 강사 계정 조회
	 * @return instructorList
	 * @throws SQLException 예외처리
	 */
	public List<AdminAccountInstructorAccountInfoVO> selectAllInstructorAccountMember() throws SQLException {
		List<AdminAccountInstructorAccountInfoVO> instructorList = new ArrayList<AdminAccountInstructorAccountInfoVO>();
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectAllInstructorAccountQuery = new StringBuilder();
			strSelectAllInstructorAccountQuery
			.append("	select 	inst_num,inst_name,inst_birth,inst_tel,inst_add	")
			.append("	from	instructor	")
			.append("	order by	inst_num	")
			;
			pstmt=con.prepareStatement(strSelectAllInstructorAccountQuery.toString());
			
			// 4. bind 변수 값 할당
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountInstructorAccountInfoVO instVO = null;
			// 레코드 존재여부 확인
			while( rs.next() ) {
				instVO = new AdminAccountInstructorAccountInfoVO();
				
				instVO.setInstNum(rs.getString("inst_num"));
				instVO.setInstName(rs.getString("inst_name"));
				instVO.setInstBirth(rs.getDate("inst_birth"));
				instVO.setInstTel(rs.getString("inst_tel"));
				instVO.setInstAdd(rs.getString("inst_add"));
				
				instructorList.add(instVO);
			} //end while
			
		} finally {
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
					
		return instructorList;
	} //selectAllInstructorAccountMember
	
	/**
	 * 단일 강사 계정 조회
	 * @param instNum 조회할 강사의 사번
	 * @return instVO
	 * @throws SQLException 예외처리
	 */
	public AdminAccountInstructorAccountInfoVO selectOneInstructorAccountMember(String instNum) throws SQLException {
		AdminAccountInstructorAccountInfoVO instVO = null;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectOneInstructorAccountQuery = new StringBuilder();
			strSelectOneInstructorAccountQuery
			.append("	select inst_name,inst_num,inst_pass,inst_birth,inst_tel,inst_add	")
			.append("	from instructor	")
			.append("	where inst_num=?	")
			;
			
			pstmt=con.prepareStatement(strSelectOneInstructorAccountQuery.toString());
			
			// 4. bind 변수 값 할당
			pstmt.setString(1, instNum);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			// 레코드 존재여부 확인
			if( rs.next() ) {
				instVO = new AdminAccountInstructorAccountInfoVO();
				// 값을 VO 객체에 저장
				instVO.setInstName(rs.getString("inst_name"));
				instVO.setInstNum(rs.getString("inst_num"));
				instVO.setInstPass(rs.getString("inst_pass"));
				instVO.setInstBirth(rs.getDate("inst_birth"));
				instVO.setInstTel(rs.getString("inst_tel"));
				instVO.setInstAdd(rs.getString("inst_add"));
			} //end if
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return instVO;
	} //selectOneInstructorAccountMember
	
} //class
