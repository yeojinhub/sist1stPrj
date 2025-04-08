package kr.co.sist.yj;

import java.sql.SQLException;
import java.util.List;

/**
 * Business Logic을 구현하기 위한 클래스.
 * 학생 계정과 관련된 기능(등록, 수정, 삭제, 조회)을 DAO와 연동하여 처리합니다.
 */
public class AdminAccountStudentAccountService {

    public AdminAccountStudentAccountService() {
        // 기본 생성자
    } // AdminAccountStudentService

    /**
     * 전체 학생 계정 개수
     * @return 학생 계정의 총 건수
     */
    public int searchCntStudentAccountMember() {
        int cnt = 0;
        
        AdminAccountStudentAccountDAO aasaDAO = AdminAccountStudentAccountDAO.getInstance();
        try {
            // DAO의 selectStudentAccountCount 메서드 호출 (전체 건수를 반환)
            cnt = aasaDAO.searchCntStudentAccountMember();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return cnt;
    } // searchAllCount

    /**
     * 전체 학생 계정 조회
     * @return 학생 계정 VO 객체들의 리스트
     */
    public List<AdminAccountStudentAccountVO> searchAllStudentAccountMember() {
        List<AdminAccountStudentAccountVO> studentList = null;
        AdminAccountStudentAccountDAO aasaDAO = AdminAccountStudentAccountDAO.getInstance();
        
        try {
        	studentList = aasaDAO.selectAllStudentAccountMember();
        } catch (SQLException se) {
            se.printStackTrace();
        } //end try catch
        
        return studentList;
    } // searchAllStudentAccountMember

//    /**
//     * 단일 학생 계정 정보를 조회합니다.
//     * @param stuNum 조회할 학생의 학번
//     * @return 해당 학생 계정 VO 객체 (없으면 null)
//     */
//    public AdminAccountStudentAccountVO searchOneStudentAccount(int stuNum) {
//        AdminAccountStudentAccountVO studentVO = null;
//        AdminAccountStudentAccountDAO studentDAO = AdminAccountStudentAccountDAO.getInstance();
//        try {
//            // DAO의 selectOneStudentAccount 메서드 호출 (해당 학번의 학생 계정 정보 반환)
//            studentVO = studentDAO.selectOneStudentAccount(stuNum);
//        } catch (SQLException se) {
//            se.printStackTrace();
//        }
//        return studentVO;
//    } // searchOneStudentAccount

} // class
