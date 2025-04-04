package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountAdminAccountCreateEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminAccountAdminAccountCreateView aaaacv;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
	private JButton jbtnAdminAccountAdminAccountClose;
	
	public AdminAccountAdminAccountCreateEvt(AdminAccountAdminAccountCreateView aaaacv) {
		this.aaaacv=aaaacv;
		this.jbtnAdminAccountAdminAccountCreate=aaaacv.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountClose=aaaacv.getJbtnAdminAccountAdminAccountClose();
	} //AdminAccountAdminAccountCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountCreate ) {
			System.out.println("생성 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountAdminAccountClose ) {
			System.out.println("닫기 버튼 실행");
		} //end if
	} //actionPerformed
	
} //class
