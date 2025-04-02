//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//import kr.co.sist.view.AdminAccountView;

public class AdminAccountEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminAccountView aav;
	
	private JPanel jpAdminAccountCardPanel;
	private CardLayout clAdminAccountCard;
	
	private JButton jbtnAdminAccountViewStudentAccount;
	private JButton jbtnAdminAccountViewInstructorAccount;
	private JButton jbtnAdminAccountViewAdminAccount;
	
	public AdminAccountEvt(AdminAccountView aav) {
		this.aav=aav;
		this.jpAdminAccountCardPanel=aav.getJpAdminAccountCardPanel();
		this.clAdminAccountCard=aav.getClAdminAccountCard();
		this.jbtnAdminAccountViewStudentAccount=aav.getJbtnAdminAccountViewStudentAccount();
		this.jbtnAdminAccountViewInstructorAccount=aav.getJbtnAdminAccountViewInstructorAccount();
		this.jbtnAdminAccountViewAdminAccount=aav.getJbtnAdminAccountViewAdminAccount();
	} //AdminAccountEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == jbtnAdminAccountViewStudentAccount ) {
			clAdminAccountCard.show(jpAdminAccountCardPanel, "StudentAccountView" );
			System.out.println("수강생계정관리 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminAccountViewInstructorAccount ) {
			clAdminAccountCard.show(jpAdminAccountCardPanel, "InstructorAccountView" );
			System.out.println("강사계정관리 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminAccountViewAdminAccount ) {
			clAdminAccountCard.show(jpAdminAccountCardPanel, "AdminAccountView" );
			System.out.println("관리자계정관리 버튼 실행");
		} //end if
	} //actionPerformed

} //class
