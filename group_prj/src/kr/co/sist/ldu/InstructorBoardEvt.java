package kr.co.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

public class InstructorBoardEvt implements ActionListener {

    private InstructorBoardVO vo;
    private InstructorAccountVO iaVO;
    private JTextField jtfCommSet;
    private JDialog dialog;
    private InstructorMainView imv;
    private InstructorMainViewEvt imve;
    private InstructorBoardView ibv;
    
    public InstructorBoardEvt(InstructorBoardVO vo, InstructorAccountVO iaVO,  JTextField jtfCommSet, 
    		JDialog dialog, InstructorMainView imv) {
        this.vo = vo;
        this.iaVO = iaVO;
        this.jtfCommSet = jtfCommSet;
        this.dialog = dialog;
        this.imv = imv;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
        String comment = jtfCommSet.getText().trim();
        if (comment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "댓글 내용을 입력해주세요.");
            return;
        }

        int boardNum = vo.getBoardNum();
        String instNum = iaVO.getInstNum();
        Date commDate = new Date(System.currentTimeMillis());
        String boardType = "강사";  // 필요 시 관리자 분기 추가 가능

        InstructorBoardService service = new InstructorBoardService();
        boolean success = service.registerReply(boardNum, comment, instNum, commDate, boardType);

        if (success) {
        	 	JOptionPane.showMessageDialog(null, "댓글이 등록되었습니다.");
        	    
        	    // 최신 상태로 DB에서 다시 불러오기
        	    InstructorBoardVO updatedVo = new InstructorMainService().getBoardByNum(boardNum);
        	    
        	    imve = new InstructorMainViewEvt(imv.getJtaBoard(), iaVO, imv);
        	    
        	    dialog.dispose(); // 현재 작성창 닫기
        	    
        } else {
            JOptionPane.showMessageDialog(null, "댓글 등록에 실패했습니다.");
        }
    }
}

	
