package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminLoginDAO {
	
	private static AdminLoginDAO loginVO;
	
	private AdminLoginDAO() {
		
	} //AdminLoginDAO
	
	/**
	 * SingleTon 생성
	 * @return loginVO AdminLoginDAO 클래스의 유일한 인스턴스를 반환
	 */
	public static AdminLoginDAO getInstance() {
		if( loginVO == null ) {
			loginVO = new AdminLoginDAO();
		} //end if
		
		return loginVO;
	} //getInstance
	
	/**
	 * 전체 관리자 계정 조회
	 * @return adminList 전체 관리자 계정 리스트
	 * @throws SQLException 예외처리
	 */
	public List<AdminLoginVO> selectAllAdminAccountLogin() throws SQLException {
		List<AdminLoginVO> adminList = new ArrayList<AdminLoginVO>();
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectAllQuery = new StringBuilder();
			strSelectAllQuery
			.append("	select	*	")
			.append("	from	admin	")
			;
			pstmt=con.prepareStatement(strSelectAllQuery.toString());
			
			// 4. bind 변수 값 할당
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminLoginVO loginVO = null;
			// 레코드 존재여부 확인
			while( rs.next() ) {
				loginVO = new AdminLoginVO();
				
				loginVO.setAdmID(rs.getString("adm_id"));
				loginVO.setAdmPass(rs.getString("adm_pass"));
				loginVO.setAdmName(rs.getString("adm_name"));
				loginVO.setAdmBirth(rs.getDate("adm_birth"));
				loginVO.setAdmTel(rs.getString("adm_tel"));
				loginVO.setAdmAdd(rs.getString("adm_add"));
				
				adminList.add(loginVO);
			} //end while
			
		} finally {
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
					
		return adminList;
	} //selectAllAdminAccountLogin

} //class
