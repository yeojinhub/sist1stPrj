package kr.co.sist.kmg;
//package kr.co.sist.kmg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMenuView extends JFrame {
	private JPanel contentPane;

	private JLabel jlbManagerName;
	
	private JButton jbtnAccount;
	private JButton jbtnTest;
	private JButton jbtnBoarder;
	
	public StudentMenuView() {
		super("관리자 메뉴");
// 		폰트
		Font menuFont = new Font("Console", Font.PLAIN|Font.BOLD, 20);// 입력-기본
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		jlbManagerName = new JLabel("도도도");
		jlbManagerName.setFont(new Font("Dialog", Font.BOLD, 30));
		jlbManagerName.setBounds(323, 382, 100, 69);
		
		contentPane.add(jlbManagerName);
		
		JLabel jlblManager = new JLabel("님");
		jlblManager.setBounds(435, 395, 36, 50);
		jlblManager.setFont(menuFont);
		contentPane.add(jlblManager);
		
		jbtnAccount = new JButton("개인정보");
		jbtnAccount.setBounds(68, 546, 206, 89);
		jbtnAccount.setFont(menuFont);
		jbtnAccount.setBackground(new Color(255, 165, 0));
		contentPane.add(jbtnAccount);
		
		jbtnTest = new JButton("시험");
		jbtnTest.setFont(menuFont);
		jbtnTest.setBackground(Color.LIGHT_GRAY);
		jbtnTest.setBounds(286, 546, 206, 89);
		contentPane.add(jbtnTest);
		
		jbtnBoarder = new JButton("게시판");
		jbtnBoarder.setFont(menuFont);
		jbtnBoarder.setBackground(Color.LIGHT_GRAY);
		jbtnBoarder.setBounds(504, 546, 206, 89);
		contentPane.add(jbtnBoarder);
		
		StudentMenuViewEvt mve= new StudentMenuViewEvt(this);
		jbtnAccount.addActionListener(mve);
		jbtnTest.addActionListener(mve);
		jbtnBoarder.addActionListener(mve);
		
		JLabel jlbLogoTitle = new JLabel("Best Campus");
		jlbLogoTitle.setFont(new Font("Consolas", Font.BOLD, 45));
		jlbLogoTitle.setBounds(getX()+250, getY()+760, 300, 50);
		getContentPane().add(jlbLogoTitle);
		
//		window 크기 설정
		setBounds(100, 100, 800, 900);
//		사용자에게 window 출력
		setVisible(true);
//		x로 창닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//MenuView

//	getter	
	public JLabel getJlbManagerName() {
		return jlbManagerName;
	}

	public JButton getJbtnAccount() {
		return jbtnAccount;
	}

	public JButton getJbtnTest() {
		return jbtnTest;
	}


	public JButton getJbtnBoarder() {
		return jbtnBoarder;
	}
	
	
}//class
