package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentBoardWriteEvt implements ActionListener {

	private StudentBoardWriteView sbwv;
	
	public StudentBoardWriteEvt(StudentBoardWriteView sbwv) {
		this.sbwv = sbwv;
	}// actionPerformed

	public void writePost() {
		JOptionPane.showMessageDialog(sbwv, "아직 미구현 기능입니다.");
	}
	
	public void exitDialog() {
		sbwv.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sbwv.getJbtnExit()) {
			exitDialog();
		}// 닫기 버튼
		if(e.getSource() == sbwv.getJbtnWrite()) {
			writePost();
		}// 작성 버튼
	}// actionPerformed

}// class
