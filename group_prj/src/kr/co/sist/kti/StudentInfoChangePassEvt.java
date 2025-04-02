package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentInfoChangePassEvt implements ActionListener {

	private StudentInfoChangePassView sicpv;
	
	public StudentInfoChangePassEvt(StudentInfoChangePassView sicpv) {
		this.sicpv = sicpv;
	}// StudentInfoChangePassEvt

	public void exitDialog() {
		sicpv.dispose();
	}// exitDialog
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sicpv.getJbtnChange()) {
			JOptionPane.showMessageDialog(sicpv, "아직 미구현 기능입니다.");
		} // 변경 버튼
		if (e.getSource() == sicpv.getJbtnExit()) {
			exitDialog();
		} // 닫기 버튼
	}// actionPerformed

}// class
