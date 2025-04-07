package kr.co.sist.kti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentLoginView extends JFrame {

	private JTextField jtfIDSet;
	private JPasswordField jpfPassSet;
	private JButton jbtnLogin;
	private JLabel jlblInfoNow;

	public StudentLoginView() {
		super("Best Campus - 학생용");
		// #. 컴포넌트 추가 및 설정
		JLabel jlblID = new JLabel("ID");
		jlblID.setHorizontalAlignment(SwingConstants.CENTER);
		jlblID.setFont(new Font("Consolas", Font.BOLD, 18));
		jlblID.setBounds(30, 130, 100, 25);
		getContentPane().add(jlblID);

		JLabel jlblPassword = new JLabel("Password");
		jlblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlblPassword.setFont(new Font("Consolas", Font.BOLD, 18));
		jlblPassword.setBounds(30, 170, 100, 25);
		getContentPane().add(jlblPassword);

		JLabel jlblTitleImage = new JLabel("");
		jlblTitleImage.setIcon(new ImageIcon("C:/Users/user/git/sistFstPjr/group_prj/src/kr/co/sist/kti/logo.png"));
		jlblTitleImage.setBounds(90, 20, 70, 70);
		getContentPane().add(jlblTitleImage);

		JLabel jlblTitle = new JLabel("Best Campus");
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTitle.setFont(new Font("Consolas", Font.BOLD, 28));
		jlblTitle.setBackground(Color.WHITE);
		jlblTitle.setBounds(170, 45, 170, 30);
		getContentPane().add(jlblTitle);

		JLabel jlblAuthority = new JLabel("학생용");
		jlblAuthority.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jlblAuthority.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAuthority.setBounds(0, 0, 50, 20);
		getContentPane().add(jlblAuthority);

		jtfIDSet = new JTextField();
		jtfIDSet.setBounds(150, 125, 140, 25);
		getContentPane().add(jtfIDSet);
		jtfIDSet.setColumns(10);

		jpfPassSet = new JPasswordField();
		jpfPassSet.setBounds(150, 165, 140, 25);
		getContentPane().add(jpfPassSet);


		jbtnLogin = new JButton("로그인");
		jbtnLogin.setBackground(new Color(235, 235, 255));
		jbtnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnLogin.setFocusPainted(false);
		jbtnLogin.setBounds(310, 125, 100, 65);
		getContentPane().add(jbtnLogin);
		
		jlblInfoNow = new JLabel("");
		jlblInfoNow.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		jlblInfoNow.setBounds(150,195,200,25);
		getContentPane().add(jlblInfoNow);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentLoginEvt sle = new StudentLoginEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnLogin.addActionListener(sle);

		// #. 배경색 설정
		getContentPane().setBackground(new Color(255, 255, 255));

		// #. 수동배치 설정
		getContentPane().setLayout(null);

		// #. 크기 및 사이즈 설정
		setBounds(680, 200, 450, 270);
		
		// #. 사이즈 조정 불가
		setResizable(false);

		// #. 가시화
		setVisible(true);

		// #. 종료 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// StudentLoginView

	// Getter Method
	public JTextField getJtfIDSet() {
		return jtfIDSet;
	}

	public JPasswordField getJpfPassSet() {
		return jpfPassSet;
	}

	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public JLabel getJlblInfoNow() {
		return jlblInfoNow;
	}
	
}// class
