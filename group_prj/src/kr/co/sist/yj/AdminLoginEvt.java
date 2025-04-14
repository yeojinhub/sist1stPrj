//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

//import kr.co.sist.view.AdminLoginView;
//import kr.co.sist.view.AdminMainView;

public class AdminLoginEvt extends WindowAdapter implements ActionListener {

	private AdminLoginView loginView;
	private JButton loginButton;

	public AdminLoginEvt(AdminLoginView loginView) {
		this.loginView = loginView;
		this.loginButton = loginView.getLoginButton();
	} // AdminLoginEvt

	public void lookUpAdminAccountForLogin() {
		// Service 객체 생성
		AdminLoginService loginService = new AdminLoginService();
		
		// ID와 비밀번호 입력창 확인. 
		if(loginView.getLoginIDTextSet().getText().isEmpty()) {
			JOptionPane.showMessageDialog(loginView, "아이디를 입력해주세요.");
			loginView.getLoginIDTextSet().requestFocus();
			return;
		}// end if
		if(new String(loginView.getLoginPassTextSet().getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(loginView, "비밀번호를 입력해주세요.");
			loginView.getLoginPassTextSet().requestFocus();
			//early return
			return;
		}// end if
		// 아이디 비밀번호 입력 확인되면 Info 라벨 Empty 설정
		boolean flag = false;
		
		// 모든 학생계정 데이터를 조회하는 for문.
		// 해당 for문에서 입력한 ID와 PASSWORD를 조회하고 일치하면 로그인 성공 및 해당 학생 계정의 데이터 저장.
		for(AdminLoginVO loginVO : loginService.searchAllAdminAccountLogin()) {
			if(loginView.getLoginIDTextSet().getText().equals(loginVO.getAdmID()) && new String(loginView.getLoginPassTextSet().getPassword()).equals(loginVO.getAdmPass())) {
				flag = true;
				
				// 메인화면에 VO 객체 보내버리기.
				loginView.dispose();
				break;
			}// end if
		}// end for
		
		if(flag) {
			new AdminMainView();
			return;
		}// end if
		JOptionPane.showMessageDialog(loginView, "아이디나 비밀번호가 일치하지 않습니다.");
		
	}// lookUpStudentAccountForLogin
	
	@Override
	public void windowClosing(WindowEvent we) {
		loginView.dispose();
	} // windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if (source == loginButton) {
			System.out.println("로그인 버튼 실행");
			lookUpAdminAccountForLogin();
		} // end if
	} // actionPerformed

} // class