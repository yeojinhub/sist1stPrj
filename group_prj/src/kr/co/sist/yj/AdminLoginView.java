//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import kr.co.sist.evt.AdminLoginEvt;

@SuppressWarnings("serial")
public class AdminLoginView extends JFrame{
	
	private JTextField loginIDTextSet;
	private JPasswordField loginPassTextSet;
	private JButton loginButton;
	
	 public AdminLoginView () {
		super("관리자 로그인");
		
		//JPanel 생성
		JPanel adminLoginViewNorthPanel = new JPanel();
		adminLoginViewNorthPanel.setLayout(new GridLayout(0,1));
		
		JLabel loginTitleLabel = new JLabel("베스트 캠퍼스", JLabel.CENTER);
		adminLoginViewNorthPanel.add(loginTitleLabel);
		
		JPanel jpAdminLoginViewSouth = new JPanel();
		jpAdminLoginViewSouth.setLayout(new GridLayout(3, 2));
		
		//Component 생성
		JLabel loginIDTitleLabel = new JLabel("아이디");
		loginIDTextSet = new JTextField(20);
		
		JLabel loginPassTitleLabel = new JLabel("비밀번호");
		loginPassTextSet = new JPasswordField(20);
		
		loginButton = new JButton("로그인");
		
		//Component 배치
		jpAdminLoginViewSouth.add(loginIDTitleLabel);
		jpAdminLoginViewSouth.add(loginIDTextSet);
		jpAdminLoginViewSouth.add(loginPassTitleLabel);
		jpAdminLoginViewSouth.add(loginPassTextSet);
		jpAdminLoginViewSouth.add(new JLabel(""));
		jpAdminLoginViewSouth.add(loginButton);

		//Layout 크기 설정
		adminLoginViewNorthPanel.setBorder(new EmptyBorder(20, 0, 10, 0));
		jpAdminLoginViewSouth.setBorder(new EmptyBorder(0, 20, 20, 20));
		
		add(adminLoginViewNorthPanel, BorderLayout.NORTH);
		add(jpAdminLoginViewSouth, BorderLayout.SOUTH );
		
		//Button 이벤트 생성
		AdminLoginEvt loginEvt = new AdminLoginEvt(this);
		loginButton.addActionListener(loginEvt);
		
		//Window 크기 설정
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} //AdminLoginView

	//getter method
	 public JTextField getLoginIDTextSet() {
		 return loginIDTextSet;
	 }

	public JPasswordField getLoginPassTextSet() {
		return loginPassTextSet;
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	
} //class
