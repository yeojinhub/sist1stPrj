package kr.co.sist.yj;

import java.awt.event.*;
import java.sql.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminBoardEvt implements ActionListener {

    private JTable jtaBoard;
    private AdminBoardService service;
    private AdminBoardView abv;

    public AdminBoardEvt(JTable jtaBoard, AdminBoardView abv) {
        this.jtaBoard = jtaBoard;
        this.abv = abv;
        this.service = new AdminBoardService();

        loadBoardList();
        addBoardClickEvent();
    }

    public void loadBoardList() {
        List<AdminBoardVO> list = service.getAllBoardList();

        DefaultTableModel model = new DefaultTableModel(
            new String[]{"번호", "제목", "작성자", "작성일", "상태"}, 0
        );

        for (AdminBoardVO vo : list) {
            model.addRow(new Object[] {
                vo.getBoardNum(),
                vo.getBoardTitle(),
                vo.getStuName(),
                vo.getBoardDate(),
                vo.getBoardStatus()
            });
        }

        jtaBoard.setModel(model);
    }

    private void addBoardClickEvent() {
        jtaBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = jtaBoard.getSelectedRow();
                    if (row == -1) return;
                    try {
                        int boardNum = Integer.parseInt(jtaBoard.getValueAt(row, 0).toString());
                        String status = jtaBoard.getValueAt(row, 4).toString();
                        System.out.println("선택된 게시글 번호: " + boardNum);
                        
                        AdminBoardVO vo = service.getBoardByNum(boardNum);
                        if (vo == null) {
                            JOptionPane.showMessageDialog(abv, "게시글 정보를 찾을 수 없습니다.");
                            return;
                        }

                        if ("답변대기".equals(status)) {
                            new AdminBoardCommentView(vo, AdminBoardEvt.this).setVisible(true);;
                            
                        } else {
                            new AdminBoardReadView(vo).setVisible(true);;
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(abv, "게시글 처리 중 오류 발생");
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdminBoardCommentView dialog = (AdminBoardCommentView) SwingUtilities.getWindowAncestor((JButton) e.getSource());

        String comment = dialog.getJtfCommSet().getText().trim();
        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "댓글 내용을 입력해주세요.");
            return;
        }

//        boolean result = new AdminBoardService().registerReply(
//            dialog.getSelectedBoardNum(),
//            comment,
//            new Date(System.currentTimeMillis())
//        );

//        if (result) {
//            JOptionPane.showMessageDialog(dialog, "댓글이 등록되었습니다.");
//            refreshBoardList();
//            dialog.dispose();
//        } else {
//            JOptionPane.showMessageDialog(dialog, "댓글 등록에 실패했습니다.");
//        }
    }

    public void refreshBoardList() {
        loadBoardList();
    }
}


