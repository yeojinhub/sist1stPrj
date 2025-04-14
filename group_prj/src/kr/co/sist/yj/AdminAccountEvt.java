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
	private AdminAccountView accountView;

	private JPanel jpAdminAccountViewCardPanel;
	private CardLayout clAdminAccountCard;

	private JButton studentAccountViewButton;
	private JButton instructorAccountViewButton;
	private JButton adminAccountViewButton;

	public AdminAccountEvt(AdminAccountView accountView) {
		this.accountView = accountView;
		this.jpAdminAccountViewCardPanel = accountView.getJpAdminAccountViewCardPanel();
		this.clAdminAccountCard = accountView.getClAdminAccountViewCard();
		this.studentAccountViewButton = accountView.getStudentAccountViewButton();
		this.instructorAccountViewButton = accountView.getInstructorAccountViewButton();
		this.adminAccountViewButton = accountView.getAdminAccountViewButton();
	} // AdminAccountEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if (source == studentAccountViewButton) {
			clAdminAccountCard.show(jpAdminAccountViewCardPanel, "StudentAccountView");
			System.out.println("수강생계정관리 버튼 실행");
		} // end if
		
		if (source == instructorAccountViewButton) {
			clAdminAccountCard.show(jpAdminAccountViewCardPanel, "InstructorAccountView");
			System.out.println("강사계정관리 버튼 실행");
		} // end if
		
		if (source == adminAccountViewButton) {
			clAdminAccountCard.show(jpAdminAccountViewCardPanel, "AdminAccountView");
			System.out.println("관리자계정관리 버튼 실행");
		} // end if
		
	} // actionPerformed

} // class
