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
	
	private JTextField jtfAdminLoginID;
	private JPasswordField jpfAdminLoginPass;
	private JButton jbtnAdminLogin;
	
	 public AdminLoginView () {
		super("관리자 로그인");
		
		//JPanel 생성
		JPanel jpAdminLoginViewNorth = new JPanel();
		jpAdminLoginViewNorth.setLayout(new GridLayout(0,1));
		
		JLabel jlbAdminLoginTitle = new JLabel("베스트 캠퍼스", JLabel.CENTER);
		jpAdminLoginViewNorth.add(jlbAdminLoginTitle);
		
		JPanel jpAdminLoginViewSouth = new JPanel();
		jpAdminLoginViewSouth.setLayout(new GridLayout(3, 2));
		
		//Component 생성
		JLabel jlbAdminLoginIDTitle = new JLabel("아이디");
		jtfAdminLoginID = new JTextField(20);
		
		JLabel jlbAdminLoginPassTitle = new JLabel("비밀번호");
		jpfAdminLoginPass = new JPasswordField(20);
		
		jbtnAdminLogin = new JButton("로그인");
		
		//Component 배치
		jpAdminLoginViewSouth.add(jlbAdminLoginIDTitle);
		jpAdminLoginViewSouth.add(jtfAdminLoginID);
		jpAdminLoginViewSouth.add(jlbAdminLoginPassTitle);
		jpAdminLoginViewSouth.add(jpfAdminLoginPass);
		jpAdminLoginViewSouth.add(new JLabel(""));
		jpAdminLoginViewSouth.add(jbtnAdminLogin);

		//Layout 크기 설정
		jpAdminLoginViewNorth.setBorder(new EmptyBorder(20, 0, 10, 0));
		jpAdminLoginViewSouth.setBorder(new EmptyBorder(0, 20, 20, 20));
		
		add(jpAdminLoginViewNorth, BorderLayout.NORTH);
		add(jpAdminLoginViewSouth, BorderLayout.SOUTH );
		
		//Button 이벤트 생성
		AdminLoginEvt ale=new AdminLoginEvt(this);
		jbtnAdminLogin.addActionListener(ale);
		
		//Window 크기 설정
		setBounds(100,100,400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} //AdminLoginView

	//getter method
	public JTextField getJtfAdminLoginID() {
		return jtfAdminLoginID;
	} //getJtfAdminLoginID

	public JPasswordField getJpfAdminLoginPass() {
		return jpfAdminLoginPass;
	} //getJpfAdminLoginPass

	public JButton getJbtnAdminLogin() {
		return jbtnAdminLogin;
	} //getJbtnAdminLogin
	
} //class
