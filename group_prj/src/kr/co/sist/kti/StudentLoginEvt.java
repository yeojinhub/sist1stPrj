package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentAccountVO;
import kr.co.sist.kti.StudentMainView;

public class StudentLoginEvt implements ActionListener {

	private StudentLoginView slv;
	
	public StudentLoginEvt(StudentLoginView slv) {
		this.slv = slv;
	}// StudentLoginEvt

	public void lookUpStudentAccountForLogin() {
		// Service 객체 생성
		StudentLoginService sls = new StudentLoginService();
		
		// VO 데이터를 받을 객체 생성
		StudentAccountVO myAccountData = null;
		
		// ID와 비밀번호 입력창 확인. 
		if(slv.getJtfIDSet().getText().isEmpty()) {
			slv.getJlblInfoNow().setText("아이디를 입력해주세요.");
			slv.getJtfIDSet().requestFocus();
			return;
		}// end if
		if(new String(slv.getJpfPassSet().getPassword()).isEmpty()) {
			slv.getJlblInfoNow().setText("비밀번호를 입력해주세요.");
			slv.getJpfPassSet().requestFocus();
			return;
		}// end if
		// 아이디 비밀번호 입력 확인되면 Info 라벨 Empty 설정
		slv.getJlblInfoNow().setText("");
		
		boolean flag = false;
		
		// 모든 학생계정 데이터를 조회하는 for문.
		// 해당 for문에서 입력한 ID와 PASSWORD를 조회하고 일치하면 로그인 성공 및 해당 학생 계정의 데이터 저장.
		for(StudentAccountVO savo : sls.searchAllStudentAccount()) {
			if(slv.getJtfIDSet().getText().equals(savo.getStuNum()) && new String(slv.getJpfPassSet().getPassword()).equals(savo.getStuPass())) {
				flag = true;
				
				// 메인화면에 VO 객체 보내버리기.
				myAccountData = savo;
				slv.dispose();
				break;
			}// end if
		}// end for
		
		// 반복문 밖에서 JOptionPane 메세지 출력
		if(flag) {
			new StudentMainView(myAccountData);
			return;
		}// end if
		JOptionPane.showMessageDialog(slv, "아이디나 비밀번호가 일치하지 않습니다.");
		
	}// lookUpStudentAccountForLogin
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 Method
		lookUpStudentAccountForLogin();
	}// actionPerformed

}// class
