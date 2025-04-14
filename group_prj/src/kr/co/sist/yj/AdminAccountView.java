//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

//import kr.co.sist.evt.AdminAccountEvt;

@SuppressWarnings("serial")
public class AdminAccountView extends JFrame {

	private JPanel jpAdminAccountViewCardPanel;
	private CardLayout clAdminAccountViewCard;

	private JButton studentAccountViewButton;
	private JButton instructorAccountViewButton;
	private JButton adminAccountViewButton;

	public AdminAccountView() {

		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension panelSize = new Dimension(700, 45);
		Dimension buttonSize = new Dimension(120, 40);
		Dimension cardSize = new Dimension(703, 455);

		// 최상위 Panel 생성
		JPanel contentPane = new JPanel();
		contentPane.setBackground(white);
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		// Component 생성
		// 제목 Panel 생성
		JPanel jpAdminAccountViewTitlePanel = new JPanel();
		jpAdminAccountViewTitlePanel.setBackground(white);
		jpAdminAccountViewTitlePanel.setPreferredSize(panelSize);
		jpAdminAccountViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminAccountViewTitlePanel.setLayout(new BorderLayout(0, 0));

		// 제목 타이틀 생성
		JLabel jlblAdminAccountTitle = new JLabel("계정 관리");
		jlblAdminAccountTitle.setBackground(white);
		jlblAdminAccountTitle.setFont(titleFont);
		jlblAdminAccountTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminAccountViewTitlePanel.add(jlblAdminAccountTitle, BorderLayout.CENTER);

		// Button 생성
		JPanel jpAdminAccountViewButtonPanel = new JPanel();
		jpAdminAccountViewButtonPanel.setBackground(white);
		jpAdminAccountViewButtonPanel.setBorder(new TitledBorder(""));
		jpAdminAccountViewButtonPanel.setPreferredSize(panelSize);
		studentAccountViewButton = new JButton("수강생\r\n계정관리");
		studentAccountViewButton.setBackground(lightblue);
		studentAccountViewButton.setSize(buttonSize);
		studentAccountViewButton.setFont(buttonFont);
		
		instructorAccountViewButton = new JButton("강사\r\n계정관리");
		instructorAccountViewButton.setBackground(lightblue);
		instructorAccountViewButton.setSize(buttonSize);
		instructorAccountViewButton.setFont(buttonFont);
		
		adminAccountViewButton = new JButton("관리자\r\n계정관리");
		adminAccountViewButton.setBackground(lightblue);
		adminAccountViewButton.setSize(buttonSize);
		adminAccountViewButton.setFont(buttonFont);

		// Button 배치
		jpAdminAccountViewButtonPanel.add(studentAccountViewButton);
		jpAdminAccountViewButtonPanel.add(instructorAccountViewButton);
		jpAdminAccountViewButtonPanel.add(adminAccountViewButton);

		jpAdminAccountViewCardPanel = new JPanel();
		clAdminAccountViewCard = new CardLayout();
		jpAdminAccountViewCardPanel.setLayout(clAdminAccountViewCard);

		jpAdminAccountViewCardPanel.add("StudentAccountView", new AdminAccountStudentAccountView());
		clAdminAccountViewCard.show(jpAdminAccountViewCardPanel, "StudentAccountView");
		jpAdminAccountViewCardPanel.add("StudentAccountInfoView", new AdminAccountStudentAccountCreateView());
		jpAdminAccountViewCardPanel.add("InstructorAccountView", new AdminAccountInstructorAccountView());
		jpAdminAccountViewCardPanel.add("AdminAccountView", new AdminAccountAdminAccountView());
		jpAdminAccountViewCardPanel.setPreferredSize(cardSize);

		// Panel 배치
		contentPane.add(jpAdminAccountViewTitlePanel, BorderLayout.NORTH);
		contentPane.add(jpAdminAccountViewButtonPanel, BorderLayout.CENTER);
		contentPane.add(jpAdminAccountViewCardPanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminAccountEvt aae = new AdminAccountEvt(this);
		studentAccountViewButton.addActionListener(aae);
		instructorAccountViewButton.addActionListener(aae);
		adminAccountViewButton.addActionListener(aae);

	} // AdminAccountView

	// getter method
	public JButton getStudentAccountViewButton() {
		return studentAccountViewButton;
	}

	public JButton getInstructorAccountViewButton() {
		return instructorAccountViewButton;
	}

	public JButton getAdminAccountViewButton() {
		return adminAccountViewButton;
	}

	public JPanel getJpAdminAccountViewCardPanel() {
		return jpAdminAccountViewCardPanel;
	} // getJpAdminAccountViewCardPanel

	public CardLayout getClAdminAccountViewCard() {
		return clAdminAccountViewCard;
	} // getClAdminAccountViewCard

} // class