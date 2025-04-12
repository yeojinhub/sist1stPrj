package kr.co.sist.yj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.swing.DefaultComboBoxModel;

public class AdminExamCreateDAO {

    /**
     * EXAM 테이블에 시험 기본 정보(exam_name, course_name)를 등록하고,
     * 자동 생성된 exam_num 값을 반환한다.
     * 시퀀스: SEQ_EXAM_NUM.NEXTVAL 사용
     * 컬럼명은 EXAM 테이블에 실제 존재하는 exam_name, course_name이어야 함.
     */
	
	private int getCourseNumByName(String courseName) {
	    int courseNum = -1;
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    try {
	        con = DBConnection.getInstance().getConn();
	        String sql = "SELECT cour_num FROM course WHERE cour_name = ?";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, courseName);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            courseNum = rs.getInt("cour_num");
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            DBConnection.getInstance().closeDB(rs, ps, con);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return courseNum;
	}


	public int createExam(AdminExamCreateVO vo) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int examNum = -1;
	    try {
	        con = DBConnection.getInstance().getConn();
	        // INSERT문 (RETURNING 없이)
	        String sql = "INSERT INTO EXAM (exam_num, exam_name, cour_num, exam_date) " +
	                     "VALUES (SEQ_EXAM_NUM.NEXTVAL, ?, ?, TO_CHAR(sysdate, 'YYYY-MM-DD'))";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, vo.getExamName());
	        int courseNum = getCourseNumByName(vo.getCourseName());
	        ps.setInt(2, courseNum);
	        int result = ps.executeUpdate();
	        if(result > 0) {
	            // 기존 PreparedStatement 닫기
	            ps.close();
	            // 생성된 exam_num 조회 (CURRVAL은 동일 세션내에서 마지막으로 사용된 시퀀스 값을 반환)
	            sql = "SELECT SEQ_EXAM_NUM.CURRVAL FROM dual";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                examNum = rs.getInt(1);
	            }
	        }
	    } catch(SQLException se) {
	        se.printStackTrace();
	    } finally {
	        try {
	            DBConnection.getInstance().closeDB(rs, ps, con);
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return examNum;
	}


    
    /**
     * EXAM_QUESTION 테이블에 단일 문제를 등록한다.
     * 시퀀스: SEQ_QUES_NUM.NEXTVAL 사용
     * 테이블 컬럼: ques_num, ques_content, ques_option, ques_option_correct, exam_num
     */
    private boolean doInsertQuestion(String quesContent, String quesOption, int quesCorrect, int examNum) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getInstance().getConn();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO EXAM_QUESTION ");
            sb.append("(ques_num, ques_content, ques_option, ques_option_correct, exam_num) ");
            sb.append("VALUES (SEQ_QUES_NUM.NEXTVAL, ?, ?, ?, ?)");
            String sql = sb.toString();
            ps = con.prepareStatement(sql);
            ps.setString(1, quesContent);
            ps.setString(2, quesOption);
            ps.setInt(3, quesCorrect);
            ps.setInt(4, examNum);
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch(SQLException se) {
            se.printStackTrace();
            return false;
        } finally {
            try {
                DBConnection.getInstance().closeDB(null, ps, con);
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    /**
     * VO에 담긴 데이터를 이용해 EXAM 테이블과 EXAM_QUESTION 테이블에 등록한다.
     * 먼저 EXAM 테이블에 시험 정보를 INSERT한 후 생성된 exam_num을 얻고,
     * 그 exam_num을 이용해 5개의 문제를 EXAM_QUESTION 테이블에 등록한다.
     */
    public boolean createExamQuestions(AdminExamCreateVO vo) throws SQLException {
        int examNum = createExam(vo);
        if(examNum < 0) {
            System.out.println("EXAM 등록 실패");
            return false;
        }
        
        boolean q1 = doInsertQuestion(vo.getQ1Content(), vo.getQ1Option(), vo.getQ1Correct(), examNum);
        boolean q2 = doInsertQuestion(vo.getQ2Content(), vo.getQ2Option(), vo.getQ2Correct(), examNum);
        boolean q3 = doInsertQuestion(vo.getQ3Content(), vo.getQ3Option(), vo.getQ3Correct(), examNum);
        boolean q4 = doInsertQuestion(vo.getQ4Content(), vo.getQ4Option(), vo.getQ4Correct(), examNum);
        boolean q5 = doInsertQuestion(vo.getQ5Content(), vo.getQ5Option(), vo.getQ5Correct(), examNum);
        
        return q1 && q2 && q3 && q4 && q5;
    }
    
    /**
     * DAO에서 과정명 리스트를 조회하여 DefaultComboBoxModel에 담아 반환한다.
     */
    public DefaultComboBoxModel<String> getCourseNames() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getInstance().getConn();
            String sql = "SELECT cour_name FROM course";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String courseName = rs.getString("cour_name");
                model.addElement(courseName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBConnection.getInstance().closeDB(rs, stmt, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model;
    }
}
