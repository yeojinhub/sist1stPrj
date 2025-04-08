package kr.co.sist.ldu;

import java.sql.Date;
import java.sql.SQLException;

public class InstructorBoardService {

	private InstructorBoardDAO dao = new InstructorBoardDAO();

	// 댓글 등록 + 상태 변경
	public boolean registerReply(int boardNum, String comment, String instNum, java.sql.Date commDate, String boardType) {
	    boolean result = false;

	    try {
	        int updated = dao.updateBoardComment(boardNum, comment, instNum, commDate, boardType);
	        result = updated == 1;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
}

