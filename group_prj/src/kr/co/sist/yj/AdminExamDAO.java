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
			sql.append("SELECT e.exam_name, ");
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
	
//    /**
//     * DB에서 시험 데이터를 조회하여 DefaultTableModel로 반환한다.
//     * 컬럼: 시험과목명, 과정명, 담당강사, 시험응시날짜
//     */
//    public DefaultTableModel getExamData() {
//        // 실제 DB 조회 결과에 맞는 컬럼명 (ERD 기준)
//        String[] columnNames = {"시험과목명", "과정명", "담당강사", "시험응시날짜"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            // DB 연결 (DbConnection은 별도로 구현된 DB 연결 유틸리티)
//            con = DbConnection.getInstance().getConn();
//            // ERD 기준 쿼리: exam 테이블 -> course 테이블 -> instructor 테이블로 조인한다.
//            String sql = "SELECT e.exam_name, " +
//                         "       c.cour_name, " +
//                         "       i.inst_name, " +
//                         "       TO_CHAR(e.exam_date, 'YYYY-MM-DD') AS exam_date " +
//                         "  FROM exam e " +
//                         "  JOIN course c ON e.cour_num = c.cour_num " +
//                         "  JOIN instructor i ON c.inst_num = i.inst_num";
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(sql);
//            
//            while(rs.next()){
//                String examName = rs.getString("exam_name");      // 시험과목명
//                String courseName = rs.getString("cour_name");       // 과정명
//                String instName   = rs.getString("inst_name");       // 담당 강사 이름
//                String examDate   = rs.getString("exam_date");       // 시험 응시 날짜
//                
//                // 한 행(row)을 모델에 추가
//                model.addRow(new Object[]{examName, courseName, instName, examDate});
//            }
//        } catch(SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                DbConnection.getInstance().closeDB(rs, stmt, con);
//            } catch(SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return model;
//    }
}
