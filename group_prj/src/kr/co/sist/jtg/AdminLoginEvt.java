//package kr.co.sist.evt;
package kr.co.sist.jtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

//import kr.co.sist.view.AdminLoginView;
//import kr.co.sist.view.AdminMainView;

public class AdminLoginEvt extends WindowAdapter implements ActionListener {
	
	private AdminLoginView ale;
	private JButton jbtnAdminLogin;
	
	private String id;
	
	public AdminLoginEvt(AdminLoginView ale) {
		this.ale=ale;
		this.jbtnAdminLogin=ale.getJbtnAdminLogin();
	} //AdminLoginEvt

	@Override
	public void windowClosing(WindowEvent we) {
		ale.dispose();
	} //windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==jbtnAdminLogin) {
			System.out.println("로그인 버튼 실행");
			//아이디 입력되어있는지 확인하는 method
			adminIDChecked(id);
			//비밀번호 입력되어있는지 확인하는 method
			adminPassChecked();
		} //end if
	} //actionPerformed
	
	private void adminIDChecked(String id) {
//		boolean flag=false;
//		flag=!id.isEmpty();
		
	} //idChecked
	
	private void adminPassChecked() {
		ale.dispose();
		new AdminMainView();
	} //passChecked

} //class