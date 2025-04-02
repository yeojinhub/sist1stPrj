package kr.co.sist.kti;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentMainView extends JFrame {

	private JLabel jlblNameSet;
	private JLabel jlblTeacherNameSet;
	
	boolean flag = false;
	
	public StudentMainView() {
		super("Best Campus - 학생용");
		// #. Main Panel 생성 및 설정
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// #. JTabbedPane 생성 및 설정 [ Tab Panel 구성 ] 
		JTabbedPane jtpTabPane = new JTabbedPane(JTabbedPane.TOP);
		jtpTabPane.setBackground(new Color(255, 255, 255));
		jtpTabPane.setBounds(10, 135, 565, 580);
		contentPane.add(jtpTabPane);
		
		// #. TabPane 설정
		// #-1. 객체 생성 및 탭버튼 추가
		StudentInfoPanel sip = new StudentInfoPanel();
		StudentExamPanel sep = new StudentExamPanel();
		StudentBoardPanel sbp = new StudentBoardPanel();

		// #-2. Tab 버튼 폰트 설정 및 추가
		jtpTabPane.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		jtpTabPane.add("개인정보",sip);
		jtpTabPane.add("시험",sep);
		jtpTabPane.add("1:1문의",sbp);
		
		
		// #. 컴포넌트 객체 생성 및 설정
		JLabel jlblTitle = new JLabel("Best Campus");
		jlblTitle.setBackground(new Color(255, 255, 255));
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTitle.setFont(new Font("Consolas", Font.BOLD, 28));
		jlblTitle.setBounds(90, 30, 170, 30);
		contentPane.add(jlblTitle);
		
		JLabel jlblName = new JLabel("학생명 : ");
		jlblName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblName.setBounds(320, 30, 100, 20);
		contentPane.add(jlblName);
		
		JLabel jlblTeacherName = new JLabel("담당강사 : ");
		jlblTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblTeacherName.setBounds(320, 70, 100, 20);
		contentPane.add(jlblTeacherName);
		
		
		JLabel jlblTitleImage = new JLabel("");
		jlblTitleImage.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\image\\logo.png"));
		jlblTitleImage.setBounds(10, 10, 70, 70);
		contentPane.add(jlblTitleImage);
		
		jlblNameSet = new JLabel("강태일");
		jlblNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNameSet.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		jlblNameSet.setBounds(460, 30, 70, 20);
		contentPane.add(jlblNameSet);
		
		jlblTeacherNameSet = new JLabel("곽우신");
		jlblTeacherNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherNameSet.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		jlblTeacherNameSet.setBounds(460, 70, 70, 20);
		contentPane.add(jlblTeacherNameSet);
		
		JButton btnNewButton = new JButton("메뉴 열기");
		btnNewButton.setBackground(new Color(235, 235, 255));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					setSize(600, 165);
					btnNewButton.setText("메뉴 열기");
					flag = false;
				} else if(!flag) {
					setSize(600,765);
					btnNewButton.setText("메뉴 닫기");
					flag = true;
				}
				
			}
		});
		btnNewButton.setBounds(10, 95, 100, 20);
		contentPane.add(btnNewButton);
		
		// #. 사이즈
		setBounds(100, 100, 600, 165);
		
		// #. 가시화
		setVisible(true);
		
		// #. 윈도우 크기 변경 불가
		setResizable(false);
		
		// #. 종료 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// StudentMainView

	public JLabel getJlblNameSet() {
		return jlblNameSet;
	}// getJlblNameSet

	public JLabel getJlblTeacherNameSet() {
		return jlblTeacherNameSet;
	}// getJlblTeacherNameSet
}// class
