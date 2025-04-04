package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountInstructorAccountCreateEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminAccountInstructorAccountCreateView aaiacv;
	
	private JButton jbtnAdminAccountInstructorAccountCreate;
	private JButton jbtnAdminAccountInstructorAccountClose;
	
	public AdminAccountInstructorAccountCreateEvt(AdminAccountInstructorAccountCreateView aaiacv) {
		this.aaiacv=aaiacv;
		this.jbtnAdminAccountInstructorAccountCreate=aaiacv.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountClose=aaiacv.getJbtnAdminAccountInstructorAccountClose();
	} //AdminAccountInstructorAccountCreateEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountInstructorAccountCreate ) {
			System.out.println("생성 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountInstructorAccountClose ) {
			System.out.println("닫기 버튼 실행");
		} //end if
		
	} //actionPerformed

} //class
