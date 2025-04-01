//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminAccountView extends JDialog{
	
	private JButton jbtnAdminAccountViewStudentAccount;
	private JButton jbtnAdminAccountViewInstructorAccount;
	private JButton jbtnAdminAccountViewAdminAccount;
	
	public AdminAccountView() {
		
		JPanel jpAdminAccountViewNorth = new JPanel();
		
		jbtnAdminAccountViewStudentAccount= new JButton("수강생\r\n계정관리");
		jbtnAdminAccountViewInstructorAccount= new JButton("강사\r\n계정관리");
		jbtnAdminAccountViewAdminAccount= new JButton("관리자\r\n계정관리");
		
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewStudentAccount);
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewInstructorAccount);
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewAdminAccount);
		
		AdminAccountStudentAccountEvt aastac = new AdminAccountStudentAccountEvt();
		jbtnAdminAccountViewStudentAccount.addActionListener(aastac);
		
		//Layout 크기 설정
		jpAdminAccountViewNorth.setBorder(new EmptyBorder(20, 0, 10, 0));
		
		add(jpAdminAccountViewNorth, BorderLayout.NORTH );
		
	} //AdminAccountView

} //class
