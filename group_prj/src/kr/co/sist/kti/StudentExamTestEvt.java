package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentExamTestEvt implements ActionListener {

	private StudentExamTestView setv;

	public StudentExamTestEvt(StudentExamTestView setv) {
		this.setv = setv;
	}// StudentExamTestEvt

	public void exitDialog() {
		setv.dispose();
	}// exitDialog
	
	public void submitExat() {
		JOptionPane.showMessageDialog(setv, "아직 미구현 기능입니다.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setv.getJbtnExit()) {
			exitDialog();
		}// 닫기 버튼
		if (e.getSource() == setv.getJbtnSubmit()) {
			submitExat();
		}// 제출 버튼
	}// actionPerformed

}// class
