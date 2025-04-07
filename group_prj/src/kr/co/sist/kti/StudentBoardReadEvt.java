package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardReadEvt extends WindowAdapter implements ActionListener {

	private StudentBoardReadView sbrv;
	private StudentBoardPanel sbp;

	public StudentBoardReadEvt(StudentBoardReadView sbrv, StudentBoardPanel sbp) {
		this.sbrv = sbrv;
		this.sbp = sbp;
	}// StudentBoardReadEvt

	public void exitDialog() {
		sbrv.dispose();
	}// exitDialog

	public void changePost() {

		// 본인 작성 글인지 확인
		for (StudentBoardVO sbvo : sbp.getBoardList()) {
			if (sbvo.getBoardNum() == sbrv.getSelectedBoardNum()
					&& sbp.getSaVO().getStuNum().equals(sbvo.getStuNum())) {
				new StudentBoardChangeView(sbp, sbrv.getSelectedBoardNum());
				sbrv.dispose();
				return;
			}
		}

		JOptionPane.showMessageDialog(sbrv, "본인이 게시한 게시글만 수정이 가능합니다.");
	}// changePost

	public void deletePost() {
		// Service 객체 생성
		StudentBoardService sbs = new StudentBoardService();
		
		// 결과값 받을 Boolean 변수 생성
		boolean result = false;
		
		for (int i = sbp.getBoardList().size() - 1; i >= 0; i--) {
			if (sbp.getBoardList().get(i).getBoardNum() == sbrv.getSelectedBoardNum()
					&& sbp.getSaVO().getStuNum().equals(sbp.getBoardList().get(i).getStuNum())) {
				result = sbs.removeBoardPost(sbp.getBoardList().get(i).getBoardNum());
				
				sbp.getBoardList().remove(i);
				break;
			}// end if
		}
		
		if(!result) {
			JOptionPane.showMessageDialog(sbrv, "본인의 게시글만 삭제할 수 있습니다.");
			return;
		}
		JOptionPane.showMessageDialog(sbrv, "게시글을 삭제하였습니다.");
		new StudentBoardEvt(sbp).changeBoardPanelDataSet();
		sbrv.dispose();

	}// deletePost
	

	@Override
	public void windowOpened(WindowEvent e) {
		// 설명 안해도 알지?
		// Main화면 켜지면서 받아온 BoardList에 게시판에서 선택한 게시글의 번호랑
		// 매칭시켜 번호를 얻어오는거야. 딱 보면 몰라?
		for (StudentBoardVO sbvo : sbp.getBoardList()) {
			if (sbvo.getBoardNum() == sbrv.getSelectedBoardNum()) {
				// #. 좋아 하나씩 바꿔볼까?
				sbrv.getJlblTitleSet().setText(sbvo.getBoardTitle());
				sbrv.getJlblAuthorNameSet().setText(sbvo.getStuName());
				sbrv.getJlblWriteDateSet().setText(sbvo.getBoardDate().toString());
				sbrv.getJtaBoardSet().setText(sbvo.getBoardContent());
				sbrv.getJlblCommWriterTypeSet().setText(sbvo.getBoardType());
				// 답변완료일 경우에만 아래 세팅 진행.
				if(!sbvo.getBoardStatus().equals("답변완료")) {
					return;
				}// end if
				// BOARD_TYPE이 관리자라면 답글 작성자를 관리자로.
				if(sbvo.getBoardType().equals("관리자")) {
					sbrv.getJlblRespondentSet().setText("관리자");
				} else {
					sbrv.getJlblRespondentSet().setText(sbvo.getInstName());
				}// end if else
				sbrv.getJtaCourseNameSet().setText(sbvo.getBoardCommContent());
				sbrv.getJlblCommDateSet().setText(sbvo.getBoardCommDate().toString());
			} // end if
		} // end for
	}// windowOpened

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbrv.getJbtnExit()) {
			exitDialog();
		} // 닫기 버튼
		if (e.getSource() == sbrv.getJbtnChangePost()) {
			changePost();
		} // 수정 버튼
		if (e.getSource() == sbrv.getJbtnDeletePost()) {
			deletePost();
		} // 삭제 버튼
	}// actionPerformed

}// class
