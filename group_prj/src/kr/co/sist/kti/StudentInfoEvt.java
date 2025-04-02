package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentInfoEvt implements ActionListener{

	private StudentInfoPanel sip;
	
	public StudentInfoEvt(StudentInfoPanel sip) {
		this.sip = sip;
	}// StudentInfoEvt

	public void changePassword() {
		new StudentInfoChangePassView();
	}// changePassword
	
	public void changeInfo() {
		JOptionPane.showMessageDialog(sip, "아직 미구현 기능입니다.");
	}// changeInfo
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sip.getJbtnChangePass()) {
			changePassword();
		}// 비밀번호 변경 버튼
		
		if (e.getSource() == sip.getJbtnChangeInfo()) {
			changeInfo();
		}// 정보변경 버튼
	}// actionPerformed

}// class
