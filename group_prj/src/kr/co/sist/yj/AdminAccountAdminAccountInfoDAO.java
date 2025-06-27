package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminAccountAdminAccountInfoDAO {
	
	private static AdminAccountAdminAccountInfoDAO admVO;
	
	private AdminAccountAdminAccountInfoDAO() {
		
	} //AdminAccountAdminAccountInfoDAO
	
	//SingleTon 생성
	public static AdminAccountAdminAccountInfoDAO getInstance() {
		if( admVO == null ) {
			admVO = new AdminAccountAdminAccountInfoDAO();
		} //end if
		
		return admVO;
	} //getInstance
	
	/**
	 * 관리자 계정 등록
	 * @param admVO 등록할 관리자 계정 정보가 담긴 VO
	 * @throws SQLException 예외처리
	 * @throws IOException 예외처리
	 */
	public void insertAdminAccountMember(AdminAccountAdminAccountInfoVO admVO) throws SQLException, IOException {
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strInsertQuery = new StringBuilder();
			strInsertQuery
			.append("	insert into admin	")
			.append("	(adm_id,   adm_pass, adm_name, adm_birth,  adm_tel, adm_add)	")
			.append("	values(	")
			.append("	'admin'||lpad(seq_adm_id.nextval,2,'0'),	")
			.append("?,?,?,?,?) ")
			;
			
			pstmt=con.prepareStatement(strInsertQuery.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, admVO.getAdmPass());
			pstmt.setString(++bindInd, admVO.getAdmName());
			Date birthDate = admVO.getAdmBirth();
			pstmt.setDate(++bindInd, birthDate );
			pstmt.setString(++bindInd, admVO.getAdmTel());
			pstmt.setString(++bindInd, admVO.getAdmAdd());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertAdminAccountMember
	
	/**
	 * 관리자 계정 수정
	 * @param admVO 수정할 관리자 계정 정보가 담긴 VO
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int updateAdminAccountMember(AdminAccountAdminAccountInfoVO admVO) throws SQLException {
		int rowCnt=0;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strUpdateQuery = new StringBuilder();
			strUpdateQuery
			.append("	update admin	")
			.append("	set adm_tel=?,adm_add=?	")
			.append("	where adm_id=?	")
			;
			pstmt = con.prepareStatement(strUpdateQuery.toString());
			
			// 4. bind 변수 값 설정
			pstmt.setString(1, admVO.getAdmTel());
			pstmt.setString(2, admVO.getAdmAdd());
			pstmt.setString(3, admVO.getAdmID());
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //updateAdminAccountMember
	
	/**
	 * 관리자 계정 삭제
	 * @param admNum 삭제할 관리자의 사번
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int deleteAdminAccountMember(String admID) throws SQLException {
		int rowCnt=0;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 게시판 자식레코드 삭제
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteBoardQuery = new StringBuilder();
			strDeleteBoardQuery
			.append("	delete from board	")
			.append("	where adm_id IN(	")
			.append("	select a.adm_id	")
			.append("	from admin a	")
			.append("	join board b on b.adm_id = a.adm_id	")
			.append("	where b.adm_id=?)	")
			;
			pstmt = con.prepareStatement(strDeleteBoardQuery.toString());
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, admID);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();

			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteQuery = new StringBuilder();
			strDeleteQuery
			.append("	delete from	admin	")
			.append("	where adm_id=?	")
			;
			pstmt = con.prepareStatement(strDeleteQuery.toString());
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, admID);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //deleteAdminAccountMember
	
	/**
	 * 전체 관리자 계정 조회
	 * @return adminList
	 * @throws SQLException 예외처리
	 */
	public List<AdminAccountAdminAccountInfoVO> selectAllAdminAccountMember() throws SQLException {
		List<AdminAccountAdminAccountInfoVO> adminList = new ArrayList<AdminAccountAdminAccountInfoVO>();
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strSelectAllQuery = new StringBuilder();
			strSelectAllQuery
			.append("	select adm_id,adm_name,adm_birth,adm_tel,adm_add	")
			.append("	from	admin	")
			.append("	order by	adm_id")
			;
			pstmt=con.prepareStatement(strSelectAllQuery.toString());
			
			// 4. bind 변수 값 할당
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountAdminAccountInfoVO admVO = null;
			// 레코드 존재 여부 확인
			while( rs.next() ) {
				admVO = new AdminAccountAdminAccountInfoVO();
				
				admVO.setAdmID(rs.getString("adm_id"));
				admVO.setAdmName(rs.getString("adm_name"));
				admVO.setAdmBirth(rs.getDate("adm_birth"));
				admVO.setAdmTel(rs.getString("adm_tel"));
				admVO.setAdmAdd(rs.getString("adm_add"));
				
				adminList.add(admVO);
			} //end while
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return adminList;
	} //selectAllAdminAccountMember
	
	/**
	 * 단일 관리자 계정 조회
	 * @param admNum 조회할 관리자 사번
	 * @return admVO
	 * @throws SQLException 예외처리
	 */
	public AdminAccountAdminAccountInfoVO selectOneAdminAccountMember(String admID) throws SQLException {
		AdminAccountAdminAccountInfoVO admVO = null;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectOneQuery = new StringBuilder();
			strSelectOneQuery
			.append("	select adm_name,adm_id,adm_pass,adm_birth,adm_tel,adm_add	")
			.append("	from admin	")
			.append("	where adm_id=?	")
			;
			pstmt=con.prepareStatement(strSelectOneQuery.toString());
			
			// 4. bind 변수 값 할당
			pstmt.setString(1, admID);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			// 레코드 존재여부 확인
			if( rs.next() ) {
				admVO = new AdminAccountAdminAccountInfoVO();
				// 값을 VO 객체에 저장
				admVO.setAdmName(rs.getString("adm_name"));
				admVO.setAdmID(rs.getString("adm_id"));
				admVO.setAdmPass(rs.getString("adm_pass"));
				admVO.setAdmBirth(rs.getDate("adm_birth"));
				admVO.setAdmTel(rs.getString("adm_tel"));
				admVO.setAdmAdd(rs.getString("adm_add"));
			} //end if
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return admVO;
	} //selectOneAdminAccountMember

} //class
