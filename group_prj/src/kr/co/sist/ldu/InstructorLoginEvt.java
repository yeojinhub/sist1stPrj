package kr.co.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;



public class InstructorLoginEvt implements ActionListener {

	private InstructorLoginView ilv;
	
	public InstructorLoginEvt(InstructorLoginView ilv) {
		this.ilv = ilv;
	}// InstructorLoginEvt

	public void lookUpInstructorAccountForLogin() {
		// Service 객체 생성
		InstructorLoginService sls = new InstructorLoginService();
		
		// VO 데이터를 받을 객체 생성
		InstructorAccountVO myAccountData = null;
		
		// ID와 비밀번호 입력창 확인. 
		if(ilv.getJtId().getText().isEmpty()) {
			JOptionPane.showMessageDialog(ilv, "아이디를 입력하세요");
			ilv.getJtId().requestFocus();
			return;
		}// end if
		if(new String(ilv.getJpfPass().getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(ilv, "비밀번호를 입력하세요");
			ilv.getJpfPass().requestFocus();
			return;
		}// end if
		
		
		boolean flag = false;
		
		

		
		// 모든 학생계정 데이터를 조회하는 for문.
		// 해당 for문에서 입력한 ID와 PASSWORD를 조회하고 일치하면 로그인 성공 및 해당 학생 계정의 데이터 저장.
		for(InstructorAccountVO iavo : sls.searchAllInstructorAccount()) {
			if(ilv.getJtId().getText().equals(iavo.getInstNum()) && new String(ilv.getJpfPass().getPassword()).equals(iavo.getInstPass())) {
				flag = true;
				
				
				// 메인화면에 VO 객체 보내버리기.
				myAccountData = iavo;
				ilv.dispose();
				break;
			}// end if
		}// end for
		
		// 반복문 밖에서 JOptionPane 메세지 출력
		if(flag) {
			new InstructorMainView(myAccountData);
			return;
		}// end if
		

		JOptionPane.showMessageDialog(ilv, "아이디나 비밀번호가 일치하지 않습니다.");
		
	}// lookUpInstructorAccountForLogin
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 Method
		lookUpInstructorAccountForLogin();
	}// actionPerformed

}// class
