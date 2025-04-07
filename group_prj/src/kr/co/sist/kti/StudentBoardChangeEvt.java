package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardChangeEvt implements ActionListener {

	private StudentBoardChangeView sbcv;
	private StudentBoardPanel sbp;

	public StudentBoardChangeEvt(StudentBoardChangeView sbcv, StudentBoardPanel sbp) {
		this.sbcv = sbcv;
		this.sbp = sbp;
	}// StudentBoardChangeEvt

	public void changePost() {
		StudentBoardService sbs = new StudentBoardService();

		boolean result = false;
		result = sbs.changeBoardPost(sbcv.getJtfTitleSet().getText(), sbcv.getJtaBoardSet().getText(),
				sbcv.getSelectedBoardNum());

		if (!result) {
			JOptionPane.showMessageDialog(sbcv, "수정에 실패하였습니다.");
			return;
		}// end if
		JOptionPane.showMessageDialog(sbcv, "수정에 성공하였습니다.");

		// 데이터를 리로드 합니다.
		new StudentBoardEvt(sbp).changeBoardPanelDataSet();
		
		// 수정 화면 종료.
		sbcv.dispose();
	}// changePost

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbcv.getJbtnChange()) {
			changePost();
		} // 수정 버튼
		if (e.getSource() == sbcv.getJbtnExit()) {
			sbcv.dispose();
		} // 닫기 버튼
	}// actionPerformed

}// class
