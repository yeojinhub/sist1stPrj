package kr.co.sist.kti;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.co.sist.kti.StudentAccountVO;
import kr.co.sist.kti.StudentBoardPanel;
import kr.co.sist.kti.StudentExamPanel;
import kr.co.sist.kti.StudentInfoPanel;

import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class StudentMainView extends JFrame {

	private JLabel jlblNameSet;
	private JLabel jlblTeacherNameSet;
	private JButton jbtnMenuButton;

	// 로그인 후 학생 정보 VO객체
	private StudentAccountVO saVO;
	
	public StudentMainView(StudentAccountVO saVO) {
		super("Best Campus - 학생용");
		this.saVO = saVO;
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
		StudentInfoPanel sip = new StudentInfoPanel(saVO);
		StudentExamPanel sep = new StudentExamPanel(saVO);
		StudentBoardPanel sbp = new StudentBoardPanel(saVO);

		// #-2. Tab 버튼 폰트 설정 및 추가
		jtpTabPane.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		jtpTabPane.add("개인정보", sip);
		jtpTabPane.add("시험", sep);
		jtpTabPane.add("1:1문의", sbp);

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
		jlblTitleImage.setBounds(10, 10, 70, 70);
		contentPane.add(jlblTitleImage);

		// #. 로고이미지 URL로 가져다쓰기
		try {
			URL imageURL = new URL("https://raw.githubusercontent.com/yeojinhub/sistFstPjr/refs/heads/main/group_prj/src/kr/co/sist/kti/logo.png");
			jlblTitleImage.setIcon(new ImageIcon(imageURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}// end try-catch

		jlblNameSet = new JLabel("");
		jlblNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNameSet.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		jlblNameSet.setBounds(460, 30, 70, 20);
		contentPane.add(jlblNameSet);

		jlblTeacherNameSet = new JLabel("");
		jlblTeacherNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherNameSet.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		jlblTeacherNameSet.setBounds(460, 70, 70, 20);
		contentPane.add(jlblTeacherNameSet);

		jbtnMenuButton = new JButton("메뉴 닫기");
		jbtnMenuButton.setBackground(new Color(235, 235, 255));
		jbtnMenuButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnMenuButton.setFocusPainted(false);
		jbtnMenuButton.setBounds(10, 95, 100, 20);
		contentPane.add(jbtnMenuButton);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentMainEvt sme = new StudentMainEvt(this, sip, sep, sbp);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnMenuButton.addActionListener(sme);
		addWindowListener(sme);

		// #. 사이즈
		setBounds(650, 100, 600, 765);

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

	public JButton getJbtnMenuButton() {
		return jbtnMenuButton;
	}// getJbtnMenuButton

	public StudentAccountVO getSaVO() {
		return saVO;
	}// getSaVO

}// class
