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
	
	private static AdminAccountAdminAccountInfoDAO aaaaiVO;
	
	private AdminAccountAdminAccountInfoDAO() {
		
	} //AdminAccountAdminAccountInfoDAO
	
	//SingleTon 생성
	public static AdminAccountAdminAccountInfoDAO getInstance() {
		if( aaaaiVO == null ) {
			aaaaiVO = new AdminAccountAdminAccountInfoDAO();
		} //end if
		
		return aaaaiVO;
	} //getInstance
	
	/**
	 * 관리자 계정 등록
	 * @param aaaaiVO 등록할 관리자 계정 정보가 담긴 VO
	 * @throws SQLException 예외처리
	 * @throws IOException 예외처리
	 */
	public void insertAdminAccountMember(AdminAccountAdminAccountInfoVO aaaaiVO) throws SQLException, IOException {
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strAdminAccountMember = new StringBuilder();
			strAdminAccountMember
			.append("	insert into admin	")
			.append("	(adm_num,adm_pass,adm_name,adm_birth,adm_tel,adm_add)	")
			.append("	values	")
			.append("	('seq_adm_num',?,?,?,?,?)	")
			;
			
			pstmt=con.prepareStatement(strAdminAccountMember.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, aaaaiVO.getAdmPass());
			pstmt.setString(++bindInd, aaaaiVO.getAdmName());
			Date birthDate = aaaaiVO.getAdmBirth();
			pstmt.setDate(++bindInd, birthDate );
			pstmt.setString(++bindInd, aaaaiVO.getAdmTel());
			pstmt.setString(++bindInd, aaaaiVO.getAdmAdd());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertAdminAccountMember
	
	/**
	 * 전체 관리자 계정 조회
	 * @return
	 * @throws SQLException 예외처리
	 */
	public List<AdminAccountAdminAccountInfoVO> selectAllAdminAccountMember() throws SQLException {
		List<AdminAccountAdminAccountInfoVO> adminList = new ArrayList<AdminAccountAdminAccountInfoVO>();
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConnection dbConn=DbConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strSelectAllAdminAccountMember = new StringBuilder();
			strSelectAllAdminAccountMember
			.append("	select adm_num,adm_name,adm_birth,adm_tel,adm_add	")
			.append("	from	admin	")
			.append("	order by	adm_num")
			;
			pstmt=con.prepareStatement(strSelectAllAdminAccountMember.toString());
			
			// 4. bind 변수 값 할당
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountAdminAccountInfoVO aaaaiVO = null;
			// 레코드 존재 여부 확인
			while( rs.next() ) {
				aaaaiVO = new AdminAccountAdminAccountInfoVO();
				
				aaaaiVO.setAdmNum(rs.getString("adm_num"));
				aaaaiVO.setAdmName(rs.getString("adm_name"));
				aaaaiVO.setAdmBirth(rs.getDate("adm_birth"));
				aaaaiVO.setAdmTel(rs.getString("adm_tel"));
				aaaaiVO.setAdmAdd(rs.getString("adm_add"));
				
				adminList.add(aaaaiVO);
			} //end while
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return adminList;
	} //selectAllAdminAccountMember

} //class
