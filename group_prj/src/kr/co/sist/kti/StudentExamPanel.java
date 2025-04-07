package kr.co.sist.kti;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import kr.co.sist.kti.StudentAccountVO;

import java.awt.*;

public class StudentExamPanel extends JPanel {

	private JLabel jlblEndCourseSet, jlblTeacherNameSet, jlblNameSet;
	private JButton jbtnExamScore, jbtnStartExam;
	private JComboBox jcbSubjectSet;
	
	private StudentAccountVO saVO;

	public StudentExamPanel(StudentAccountVO saVO) {
		this.saVO = saVO;
		// #. 컴포넌트 추가 및 설정
		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBounds(12, 10, 535, 45);
		jpTitle.setBorder(new TitledBorder(""));
		jpTitle.setLayout(new BorderLayout(0, 0));
		add(jpTitle);
		
		JLabel jlblTitle = new JLabel("시험");
		jlblTitle.setBackground(new Color(255, 255, 255));
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpTitle.add(jlblTitle, BorderLayout.CENTER);
		
		JLabel jlblName = new JLabel("학생명");
		jlblName.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblName.setBounds(100, 100, 100, 25);
		add(jlblName);

		JLabel jlblSubject = new JLabel("과목");
		jlblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		jlblSubject.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblSubject.setBounds(100, 160, 100, 25);
		add(jlblSubject);

		JLabel jlblTeacherName = new JLabel("담당강사");
		jlblTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherName.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblTeacherName.setBounds(100, 220, 100, 25);
		add(jlblTeacherName);

		JLabel jlblEndCourse = new JLabel("교육종료");
		jlblEndCourse.setHorizontalAlignment(SwingConstants.CENTER);
		jlblEndCourse.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblEndCourse.setBounds(100, 280, 100, 25);
		add(jlblEndCourse);

		jlblNameSet = new JLabel("");
		jlblNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblNameSet.setBounds(330, 100, 100, 25);
		add(jlblNameSet);

		jlblTeacherNameSet = new JLabel("");
		jlblTeacherNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblTeacherNameSet.setBounds(330, 220, 100, 25);
		add(jlblTeacherNameSet);

		jlblEndCourseSet = new JLabel("");
		jlblEndCourseSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblEndCourseSet.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jlblEndCourseSet.setBounds(310, 280, 140, 25);
		add(jlblEndCourseSet);

		jcbSubjectSet = new JComboBox();
		jcbSubjectSet.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		jcbSubjectSet.setBackground(new Color(255, 255, 255));
//		jcbSubjectSet.setModel(new DefaultComboBoxModel(new String[] { "", "Java", "Oracle", "HTML" }));
		jcbSubjectSet.setBounds(310, 160, 140, 30);
		add(jcbSubjectSet);

		jbtnStartExam = new JButton("시험응시");
		jbtnStartExam.setBackground(new Color(235, 235, 255));
		jbtnStartExam.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jbtnStartExam.setFocusPainted(false);
		jbtnStartExam.setBounds(50, 360, 200, 70);
		add(jbtnStartExam);

		jbtnExamScore = new JButton("성적표");
		jbtnExamScore.setBackground(new Color(235, 235, 255));
		jbtnExamScore.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jbtnExamScore.setFocusPainted(false);
		jbtnExamScore.setBounds(310, 360, 200, 70);
		add(jbtnExamScore);

		JPanel jpInfo = new JPanel();
		jpInfo.setBackground(new Color(255, 255, 255));
		jpInfo.setBounds(50, 80, 460, 250);
		jpInfo.setBorder(new TitledBorder(""));
		add(jpInfo);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentExamEvt see = new StudentExamEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnExamScore.addActionListener(see);
		jbtnStartExam.addActionListener(see);
		
		// #. 컴포넌트 수동배치 설정
		setLayout(null);

		// #. 사이즈
		setSize(555, 550);

		// #. 백그라운드 흰색
		setBackground(new Color(255, 255, 255));

	}// StudentExamPanel

	// Getter Method
	public JLabel getJlblEndCourseSet() {
		return jlblEndCourseSet;
	}

	public StudentAccountVO getSaVO() {
		return saVO;
	}

	public JLabel getJlblTeacherNameSet() {
		return jlblTeacherNameSet;
	}

	public JLabel getJlblNameSet() {
		return jlblNameSet;
	}

	public JButton getJbtnExamScore() {
		return jbtnExamScore;
	}

	public JButton getJbtnStartExam() {
		return jbtnStartExam;
	}

	public JComboBox getJcbSubjectSet() {
		return jcbSubjectSet;
	}
	
	
}// class
