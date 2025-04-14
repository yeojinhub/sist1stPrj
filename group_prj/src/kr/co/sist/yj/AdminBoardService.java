package kr.co.sist.yj;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class AdminBoardService {

    private AdminBoardDAO dao;

    public AdminBoardService() {
        dao = new AdminBoardDAO();
    }

    // 게시글 전체 조회
    public List<AdminBoardVO> getAllBoardList() {
        List<AdminBoardVO> list = null;

        try {
            list = dao.selectAllBoardList();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 게시글 단일 조회
    public AdminBoardVO getBoardByNum(int boardNum) {
        AdminBoardVO vo = null;

        try {
            vo = dao.selectBoardByNum(boardNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vo;
    }

    // 댓글 등록 (답변)
    public boolean registerReply(int boardNum, String comment, Date commDate, String admId) {
        boolean result = false;

        try {
            result = dao.insertComment(boardNum, comment, commDate, admId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

