package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentBoardReadEvt implements ActionListener {

	private StudentBoardReadView sbrv;

	public StudentBoardReadEvt(StudentBoardReadView sbrv) {
		this.sbrv = sbrv;
	}// StudentBoardReadEvt

	public void exitDialog() {
		sbrv.dispose();
	}// exitDialog

	public void changePost() {
		JOptionPane.showMessageDialog(sbrv, "아직 미구현 기능입니다.");
	}// changePost

	public void deletePost() {
		JOptionPane.showMessageDialog(sbrv, "아직 미구현 기능입니다.");
	}// deletePost

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
