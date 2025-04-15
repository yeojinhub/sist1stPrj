package kr.co.sist.yj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminAccountStudentAccountInfoDAO {

	private static AdminAccountStudentAccountInfoDAO stuVO;
	
	private AdminAccountStudentAccountInfoDAO() {
		
	} //AdminAccountStudentAccountInfoDAO
	
	// SingleTon 생성
	public static AdminAccountStudentAccountInfoDAO getInstance() {
		if( stuVO == null ) {
			stuVO = new AdminAccountStudentAccountInfoDAO();
		} //end if
		
		return stuVO;
	} //getInstance
	
	/**
	 * 학생 계정 등록
	 * @param stuVO 등록할 학생 계정 저보가 담긴 VO
	 * @throws SQLException 예외처리
	 * @throws IOException 예외처리
	 */
	public void insertStudentAccountMember(AdminAccountStudentAccountInfoVO stuVO) throws SQLException, IOException{
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		
		DBConnection dbConn = DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strAddStudentAccountQuery = new StringBuilder();
			strAddStudentAccountQuery
			.append("	insert into	student	")
			.append("	(stu_num,stu_pass,stu_name,stu_birth,stu_tel,stu_add,stu_status)	")
			.append("	values	")
			.append("	TO_CHAR(SYSDATE,'YYYY_')||TRIM(TO_CHAR(SEQ_STU_NUM.NEXTVAL,'0000')),?,?,?,?,?,?)	")
			;
			pstmt = con.prepareStatement(strAddStudentAccountQuery.toString());
			
			// 4. bind 변수에 값 할당
			int bindInd = 0;
			
			pstmt.setString(++bindInd, stuVO.getStuPass());
			pstmt.setString(++bindInd, stuVO.getStuName());
			Date stuBirthDate = stuVO.getStuBirth();
			pstmt.setDate(++bindInd, stuBirthDate);
			pstmt.setString(++bindInd, stuVO.getStuTel());
			pstmt.setString(++bindInd, stuVO.getStuAdd());
			pstmt.setString(++bindInd, stuVO.getStuStatus());
			
			// 5. 쿼리문 수행 후 결과 얻기
			pstmt.executeQuery();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
	} //insertStudentAccountMember
	
	/**
	 * 학생 계정 수정
	 * @param stuVO 수정할 학생 계정 정보가 담긴 VO
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int updateStudentAccountMember(AdminAccountStudentAccountInfoVO stuVO) throws SQLException {
		int rowCnt=0;
		
		//1. Driver 로딩
		//2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strUpdateStudentAccountQuery = new StringBuilder();
			strUpdateStudentAccountQuery
			.append("	update	student	")
			.append("	set stu_tel=?,stu_add=?	")
			.append("	where stu_num?	")
			;
			pstmt=con.prepareStatement(strUpdateStudentAccountQuery.toString());
			
			// 4. bind 변수 값 설정
			pstmt.setString(1, stuVO.getStuTel());
			pstmt.setString(2, stuVO.getStuAdd());
			pstmt.setString(3, stuVO.getStuNum());
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //updateStudentAccountMember
	
	/**
	 * 학생 계정 삭제
	 * @param stuNum 삭제할 학생의 학번
	 * @return rowCnt
	 * @throws SQLException 예외처리
	 */
	public int deleteStudentAccountMember (String stuNum) throws SQLException {
		int rowCnt=0;
		
		//1. Driver 로딩
		//2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문을 넣어서 쿼리문 생성객체 얻기
			StringBuilder strDeleteStudentAccountQuery = new StringBuilder();
			strDeleteStudentAccountQuery
			.append("	delete from student	")
			.append("	where stu_num=?	")
			;
			pstmt = con.prepareStatement(strDeleteStudentAccountQuery.toString());
			
			// 4. bind 변수에 값 할당
			pstmt.setString(1, stuNum);
			
			// 5. 쿼리문 수행 후 결과 얻기
			rowCnt=pstmt.executeUpdate();
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(null, pstmt, con);
		} //end try finally
		
		return rowCnt;
	} //deleteStudentAccountMember
	
	/**
	 * 전체 학생 계정 조회
	 * @return studentList
	 * @throws SQLException 예외처리
	 */
	public List<AdminAccountStudentAccountInfoVO> selectAllStudentAccountMember() throws SQLException {
		List<AdminAccountStudentAccountInfoVO> studentList = new ArrayList<AdminAccountStudentAccountInfoVO>();
		
		//. Driver 로딩
		//2. Connection 얻기
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con = dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectAllStudentAccountQuery = new StringBuilder();
			strSelectAllStudentAccountQuery
			.append("	select stu.stu_num,stu.stu_name,stu.stu_tel,cour.cour_cardinal,cour.cour_name,stu.stu_status	")
			.append("	from student stu, apply_steps apply, course cour	")
			.append("	where stu.stu_num=apply.stu_num	")
			.append("	and (apply.cour_num=cour.cour_num)	")
			.append("	order by stu.stu_num	")
			;
			pstmt = con.prepareStatement(strSelectAllStudentAccountQuery.toString());
			
			// 4. bind 변수에 값 할당
			// 5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminAccountStudentAccountInfoVO stuVO = null;
			// 레코드 존재 여부 확인
			while( rs.next() ) {
				stuVO = new AdminAccountStudentAccountInfoVO();
				
				stuVO.setStuNum(rs.getString("stu_num"));
				stuVO.setStuName(rs.getString("stu_name"));
				stuVO.setStuTel(rs.getString("stu_tel"));
				stuVO.setCourCardinal(rs.getString("cour_cardinal"));
				stuVO.setCourName(rs.getString("cour_name"));
				stuVO.setStuStatus(rs.getString("stu_status"));
			
				studentList.add(stuVO);
			} //end while
			
		} finally {
			// 6. 연결 끊기
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return studentList;
	} //selectAllStudentAccountMember
	
	/**
	 * 한명의 학생 계정 조회
	 * @param stuNum 조회할 학생의 학번
	 * @return stuVO
	 * @throws SQLException 예외처리
	 */
	public AdminAccountStudentAccountInfoVO selectOneStudentAccountMember(String stuNum) throws SQLException {
		AdminAccountStudentAccountInfoVO stuVO = null;
		
		// 1. Driver 로딩
		// 2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			// 3. 쿼리문 객체 생성
			StringBuilder strSelectOne = new StringBuilder();
			strSelectOne
			.append("	select	")
			.append("	stu.stu_name, stu.stu_num, stu.stu_pass,	")
			.append("  stu.stu_tel, stu.stu_add, stu.stu_birth, ")
			.append("  cour.cour_name, cour.cour_cardinal, ")
			.append("  stu.stu_status	")
			.append("	from student stu ")
			.append("	join apply_steps aps ON stu.stu_num = aps.stu_nu	")
			.append("	join course cour    ON aps.cour_num = cour.cour_num ")
			.append("	where stu.stu_num = ?");      // 중복 WHERE, 콤마 오류 수정
			
			pstmt = con.prepareStatement(strSelectOne.toString());
			pstmt.setString(1, stuNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				stuVO = new AdminAccountStudentAccountInfoVO();
				stuVO.setStuName(      rs.getString("stu_name"));
				stuVO.setStuNum(       rs.getString("stu_num"));
				stuVO.setStuPass(      rs.getString("stu_pass"));
				stuVO.setStuBirth(       rs.getDate("stu_birth"));
				stuVO.setStuTel(       rs.getString("stu_tel"));
				stuVO.setStuAdd(       rs.getString("stu_add"));
				stuVO.setCourName(     rs.getString("cour_name"));
				stuVO.setCourCardinal( rs.getString("cour_cardinal"));
				stuVO.setStuStatus(    rs.getString("stu_status"));
			} //end if
			
		} finally {
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return stuVO;
	} //selectOneStudentAccountMember
	
} //class
