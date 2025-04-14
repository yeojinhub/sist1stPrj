package kr.co.sist.yj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class AdminExamDAO {
	
	private static AdminExamDAO examVO;
	
	private AdminExamDAO() {
		
	} //AdminExamDAO
	
	public static AdminExamDAO getInstance() {
		if( examVO == null ) {
			examVO = new AdminExamDAO();
		} //end if
		
		return examVO;
	} //getInstance

	public List<AdminExamVO> selectAllExamMember() throws SQLException {
		List<AdminExamVO> examList = new ArrayList<AdminExamVO>();
		
		//1. Driver 로딩
		//2. Connection 연결
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DBConnection dbConn=DBConnection.getInstance();
		
		try {
			con=dbConn.getConn();
			
			//3. 쿼리문 객체 생성
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT e.exam_num, ");
			sql.append("	   e.exam_name, ");
			sql.append("       c.cour_name, ");
			sql.append("       i.inst_name, ");
			sql.append("       TO_CHAR(e.exam_date, 'YYYY-MM-DD') AS exam_date ");
			sql.append("  FROM exam e ");
			sql.append("  JOIN course c ON e.cour_num = c.cour_num ");
			sql.append("  JOIN instructor i ON c.inst_num = i.inst_num");

			pstmt=con.prepareStatement(sql.toString());
			
			//4. bind 변수 값 할당
			//5. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			AdminExamVO examVO = null;
			//레코드 존재여부 확인
			while( rs.next() ) {
				examVO = new AdminExamVO();
				
				examVO.setExamNum(rs.getInt("exam_num"));
				examVO.setExamName(rs.getString("exam_name"));
				examVO.setCourName(rs.getString("cour_name"));
				examVO.setInstName(rs.getString("inst_name"));
				examVO.setExamDate(rs.getDate("exam_date"));
				
				examList.add(examVO);
			} //end while
			
		} finally {
			dbConn.closeDB(rs, pstmt, con);
		} //end try finally
		
		return examList;
	} //selectAllExamMember
	
	
	//삭제 method
	// DAO에서 예시
	public boolean deleteExam(int examNum) throws SQLException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    boolean flag = false;
	    try {
	        con = DBConnection.getInstance().getConn();
	        // 먼저 자식 레코드 삭제
	        String sqlChild = "DELETE FROM EXAM_QUESTION WHERE exam_num = ?";
	        ps = con.prepareStatement(sqlChild);
	        ps.setInt(1, examNum);
	        ps.executeUpdate();
	        ps.close();
	        // 그 후, 부모 레코드 삭제
	        String sqlParent = "DELETE FROM EXAM WHERE exam_num = ?";
	        ps = con.prepareStatement(sqlParent);
	        ps.setInt(1, examNum);
	        int result = ps.executeUpdate();
	        flag = result > 0;
	    } finally {
	        DBConnection.getInstance().closeDB(null, ps, con);
	    }
	    return flag;
	}

}
	
