//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import kr.co.sist.evt.AdminAccountEvt;

@SuppressWarnings("serial")
public class AdminAccountView extends JFrame{
	
	private JButton jbtnAdminAccountViewStudentAccount;
	private JButton jbtnAdminAccountViewInstructorAccount;
	private JButton jbtnAdminAccountViewAdminAccount;
	
	private JPanel jpAdminAccountCardPanel;
	private CardLayout clAdminAccountCard;
	
	public AdminAccountView() {
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout( new BorderLayout() );
		
		JPanel jpAdminAccountViewNorth = new JPanel();
		
		jbtnAdminAccountViewStudentAccount= new JButton("수강생\r\n계정관리");
		jbtnAdminAccountViewInstructorAccount= new JButton("강사\r\n계정관리");
		jbtnAdminAccountViewAdminAccount= new JButton("관리자\r\n계정관리");
		
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewStudentAccount);
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewInstructorAccount);
		jpAdminAccountViewNorth.add(jbtnAdminAccountViewAdminAccount);
		contentPane.add(jpAdminAccountViewNorth, BorderLayout.NORTH);
		
		jpAdminAccountCardPanel = new JPanel();
		clAdminAccountCard = new CardLayout();
		jpAdminAccountCardPanel.setLayout(clAdminAccountCard);
		
		jpAdminAccountCardPanel.add( "StudentAccountView", new AdminAccountStudentAccountView() );
		clAdminAccountCard.show(jpAdminAccountCardPanel, "StudentAccountView" );
		jpAdminAccountCardPanel.add( "StudentAccountInfoView", new AdminAccountStudentAccountInfoView() );
		jpAdminAccountCardPanel.add( "InstructorAccountView", new AdminAccountInstructorAccountView() );
		jpAdminAccountCardPanel.add( "AdminAccountView", new AdminAccountAdminAccountView() );
		
		AdminAccountEvt aae = new AdminAccountEvt(this);
		jbtnAdminAccountViewStudentAccount.addActionListener( aae );
		jbtnAdminAccountViewInstructorAccount.addActionListener( aae );
		jbtnAdminAccountViewAdminAccount.addActionListener( aae );
		
		contentPane.add(jpAdminAccountCardPanel, BorderLayout.CENTER);
		
	} //AdminAccountView
	
	public JButton getJbtnAdminAccountViewStudentAccount() {
		return jbtnAdminAccountViewStudentAccount;
	}

	public JButton getJbtnAdminAccountViewInstructorAccount() {
		return jbtnAdminAccountViewInstructorAccount;
	}

	public JButton getJbtnAdminAccountViewAdminAccount() {
		return jbtnAdminAccountViewAdminAccount;
	}

	public JPanel getJpAdminAccountCardPanel() {
		return jpAdminAccountCardPanel;
	}

	public CardLayout getClAdminAccountCard() {
		return clAdminAccountCard;
	}
	
} //class