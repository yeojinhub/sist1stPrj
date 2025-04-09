package kr.co.sist.ldu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstructorMainService {
	
	private InstructorMainDAO dao = new InstructorMainDAO();
	
	//과정에 대한 정보 조회
	public List<InstructorCourseVO> getInstructorCourses(String instNum) {
		try {
			return dao.selectCourseByInstructor(instNum);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	//강사에 대한 과정 기수만 조희
	public List<String> getCardinalsByInstructor(String instNum) {
        try {
            return dao.selectCardinalsByInstructor(instNum);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	// 전체 학생 목록 조회
	public List<InstructorStudentVO> getAllStudentsByInstructor(String instNum) {
	    List<InstructorStudentVO> list = null;
	    InstructorMainDAO dao = new InstructorMainDAO();

	    try {
	        list = dao.selectStudentsByInstructor(instNum);
	    } catch (SQLException e) {
	        e.printStackTrace(); // 혹은 로깅
	    }

	    return list;
	}

	// 특정 기수 학생 목록 조회
	public List<InstructorStudentVO> getStudentsByCardinal(String instNum, String cardinal) {
	    List<InstructorStudentVO> list = null;
	    InstructorMainDAO dao = new InstructorMainDAO();

	    try {
	        list = dao.selectStudentsByCardinal(instNum, cardinal);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	//강사번호를 기준으로, 해당 강사의 모든 시험 목록을 가져온다.
	public List<InstructorExamVO> getExamsByInstructor(String instNum) {
		List<InstructorExamVO> totalExamList = new ArrayList<>();

		try {
			// 수정된 부분: InstructorCourseVO 사용
			List<InstructorCourseVO> courseList = dao.selectCourseByInstructor(instNum);

			for (InstructorCourseVO course : courseList) {
				int courNum = course.getCourNum();
				String courCardinal = course.getCourCardinal();

				List<InstructorExamVO> exams = dao.selectExamsByCourse(courNum, courCardinal);
				totalExamList.addAll(exams);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalExamList;
	}
	
	//해당 강사에 대한 시험 이름만을 가져오는 거야
	public List<String> getExamNamesByCardinal(String courCardinal) {
        try {
            return dao.selectExamNamesByCardinal(courCardinal);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
	
	//성적 조희
	 public List<InstructorScoreVO> getScores(String instNum, String courCardinal, String examName) {
	    try {
	        return dao.selectScores(instNum, courCardinal, examName);
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	 }
	
	// 모든 게시글 조회
    public List<InstructorBoardVO> getAllBoardList() {
        List<InstructorBoardVO> list = new ArrayList<>();
        try {
            list = dao.selectAllBoardList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 게시글 번호로 게시글 상세 조회
    public InstructorBoardVO getBoardByNum(int boardNum) {
        InstructorBoardVO vo = null;
        try {
            vo = dao.selectBoardByNum(boardNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vo;
    }
	
	

}
