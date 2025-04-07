package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentMainView;

public class StudentInfoEvt implements ActionListener{

	private StudentInfoPanel sip;
	
	public StudentInfoEvt(StudentInfoPanel sip) {
		this.sip = sip;
	}// StudentInfoEvt

	public void changePassword() {
		new StudentInfoChangePassView(sip);
	}// changePassword
	
	public void changeInfo() {
		// Service 객체 생성
		StudentInfoService sis = new StudentInfoService();
		
		boolean result = sis.changeInfo(sip.getJftfTel().getText(), sip.getJtaAddress().getText(), sip.getSaVO().getStuNum());
		
		if(!result) {
			JOptionPane.showMessageDialog(sip, "정보변경에 실패하였습니다.");
			return;
		}// end if
		JOptionPane.showMessageDialog(sip, "정보를 변경하였습니다.");
		
		// 로그인한 학생 VO 데이터 변경
		sip.getSaVO().setStuAdd(sip.getJtaAddress().getText());
		sip.getSaVO().setStuTel(sip.getJftfTel().getText());
		
		// 개인정보 Panel 데이터 리로드
		reloadDataSet();
		
	}// changeInfo
	
	public void reloadDataSet() {
		// 주소 데이터 리로드
		sip.getJtaAddress().setText(sip.getSaVO().getStuAdd());
		// 전화번호 데이터 리로드
		sip.getJftfTel().setText(sip.getSaVO().getStuTel());
	}// reloadDataSet
	
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
