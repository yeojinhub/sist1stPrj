package kr.co.sist.kti;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class StudentInfoPanel extends JPanel {

	private JLabel jlblIDSet, jlblNameSet, jlblBirthSet, jlblTeacherNameSet, jlblCourseEndDateSet;
	private JButton jbtnChangePass, jbtnChangeInfo;
	private JTextArea jtaAddress, jtaCourseNameSet;
	private JTextField jtfTel;

	public StudentInfoPanel() {
		// #. 컴포넌트 추가 및 설정
		JLabel jlblID = new JLabel("ID (학번)");
		jlblID.setHorizontalAlignment(SwingConstants.CENTER);
		jlblID.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblID.setBackground(new Color(255, 255, 255));
		jlblID.setBounds(40, 20, 100, 25);
		add(jlblID);

		JLabel jlblPassword = new JLabel("비밀번호");
		jlblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlblPassword.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblPassword.setBackground(Color.WHITE);
		jlblPassword.setBounds(40, 60, 100, 25);
		add(jlblPassword);

		JLabel jlblName = new JLabel("학생명");
		jlblName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblName.setBackground(Color.WHITE);
		jlblName.setBounds(40, 100, 100, 25);
		add(jlblName);

		JLabel jlblBirth = new JLabel("생년월일");
		jlblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		jlblBirth.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblBirth.setBackground(Color.WHITE);
		jlblBirth.setBounds(40, 140, 100, 25);
		add(jlblBirth);

		JLabel jlblTel = new JLabel("전화번호");
		jlblTel.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblTel.setBackground(Color.WHITE);
		jlblTel.setBounds(40, 180, 100, 25);
		add(jlblTel);

		JLabel jlblAddress = new JLabel("주소");
		jlblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAddress.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblAddress.setBackground(Color.WHITE);
		jlblAddress.setBounds(40, 220, 100, 25);
		add(jlblAddress);

		JLabel jlblCourseName = new JLabel("과정명");
		jlblCourseName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCourseName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblCourseName.setBackground(Color.WHITE);
		jlblCourseName.setBounds(40, 320, 100, 25);
		add(jlblCourseName);

		JLabel jlblTeacherName = new JLabel("담당강사");
		jlblTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblTeacherName.setBackground(Color.WHITE);
		jlblTeacherName.setBounds(40, 410, 100, 25);
		add(jlblTeacherName);

		JLabel jlblCourseEndDate = new JLabel("교육종료");
		jlblCourseEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCourseEndDate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblCourseEndDate.setBackground(Color.WHITE);
		jlblCourseEndDate.setBounds(40, 450, 100, 25);
		add(jlblCourseEndDate);

		jlblIDSet = new JLabel("2025_0001");
		jlblIDSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblIDSet.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblIDSet.setBackground(Color.WHITE);
		jlblIDSet.setBounds(350, 20, 100, 25);
		add(jlblIDSet);

		jlblNameSet = new JLabel("강태일");
		jlblNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblNameSet.setBackground(Color.WHITE);
		jlblNameSet.setBounds(350, 100, 100, 25);
		add(jlblNameSet);

		jlblBirthSet = new JLabel("1996-04-02");
		jlblBirthSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblBirthSet.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblBirthSet.setBackground(Color.WHITE);
		jlblBirthSet.setBounds(350, 140, 100, 25);
		add(jlblBirthSet);

		jtfTel = new JTextField();
		jtfTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jtfTel.setHorizontalAlignment(SwingConstants.CENTER);
		jtfTel.setText("010-5745-1853");
		jtfTel.setBounds(300, 180, 200, 25);
		add(jtfTel);
		jtfTel.setColumns(10);

		jbtnChangePass = new JButton("비밀번호 변경");
		jbtnChangePass.setBackground(new Color(235, 235, 255));
		jbtnChangePass.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnChangePass.setBounds(320, 60, 170, 25);
		add(jbtnChangePass);

		jtaAddress = new JTextArea();
		jtaAddress.setText("제주특별자치도 애월읍 하소로 18 킹스톤 A동");
		jtaAddress.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jtaAddress.setBounds(300, 220, 200, 75);
		jtaAddress.setBorder(new LineBorder(Color.BLACK));
		jtaAddress.setLineWrap(true);
		add(jtaAddress);

		jtaCourseNameSet = new JTextArea();
		jtaCourseNameSet.setText("AWS와 Docker&Kuberneter활용한 Java Full-Stack 개발자 양성과정");
		jtaCourseNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jtaCourseNameSet.setBounds(300, 320, 200, 60);
		jtaCourseNameSet.setLineWrap(true);
		jtaCourseNameSet.setEditable(false);
		jtaCourseNameSet.setHighlighter(null);
		add(jtaCourseNameSet);

		jlblTeacherNameSet = new JLabel("곽우신");
		jlblTeacherNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblTeacherNameSet.setBackground(Color.WHITE);
		jlblTeacherNameSet.setBounds(350, 410, 100, 25);
		add(jlblTeacherNameSet);

		jlblCourseEndDateSet = new JLabel("2025-07-25");
		jlblCourseEndDateSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCourseEndDateSet.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jlblCourseEndDateSet.setBackground(Color.WHITE);
		jlblCourseEndDateSet.setBounds(350, 450, 100, 25);
		add(jlblCourseEndDateSet);

		jbtnChangeInfo = new JButton("정보변경");
		jbtnChangeInfo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnChangeInfo.setBackground(new Color(235, 235, 255));
		jbtnChangeInfo.setBounds(225, 500, 100, 35);
		add(jbtnChangeInfo);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentInfoEvt sie = new StudentInfoEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnChangePass.addActionListener(sie);
		jbtnChangeInfo.addActionListener(sie);
		
		// #. 수동 배치 설정
		setLayout(null);

		// #. 사이즈
		setSize(555, 550);

		// #. 백그라운드 흰색
		setBackground(new Color(255, 255, 255));
	}// StudentInfoPanel

	// Getter Method

	public JLabel getJlblIDSet() {
		return jlblIDSet;
	}

	public JLabel getJlblNameSet() {
		return jlblNameSet;
	}

	public JLabel getJlblBirthSet() {
		return jlblBirthSet;
	}

	public JLabel getJlblTeacherNameSet() {
		return jlblTeacherNameSet;
	}

	public JLabel getJlblCourseEndDateSet() {
		return jlblCourseEndDateSet;
	}

	public JButton getJbtnChangePass() {
		return jbtnChangePass;
	}

	public JButton getJbtnChangeInfo() {
		return jbtnChangeInfo;
	}

	public JTextArea getJtaAddress() {
		return jtaAddress;
	}

	public JTextArea getJtaCourseNameSet() {
		return jtaCourseNameSet;
	}

	public JTextField getJtfTel() {
		return jtfTel;
	}

}// class
