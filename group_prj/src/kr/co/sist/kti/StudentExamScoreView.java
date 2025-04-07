package kr.co.sist.kti;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import kr.co.sist.kti.StudentAccountVO;
import kr.co.sist.kti.StudentGradeVO;
import kr.co.sist.kti.StudentMainVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentExamScoreView extends JDialog {

	private JLabel jlblNameSet, jlblTeacherNameSet, jlblEndCourseSet, jlblMyAnswerSet;
	private JComboBox jcbSubjectSet;
	private JButton jbtnExit;

	private String selectedExamName;
	private String teacherName;

	private StudentAccountVO saVO;
	private StudentMainVO smVO;
	private StudentGradeVO sgVO;

	public StudentExamScoreView(StudentExamPanel sep, String selectedExamName, String teacherName) {
		this.saVO = sep.getSaVO();
		this.smVO = sep.getSmVO();
		this.selectedExamName = selectedExamName;
		this.teacherName = teacherName;
		setTitle("Best Campus - 성적표");

		// #. 백그라운드 색상 설정 및 수동배치 설정
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		// #. 컴포넌트 추가 및 설정
		JPanel jpMain = new JPanel();
		jpMain.setBackground(new Color(255, 255, 255));
		jpMain.setBounds(6, 76, 420, 370);
		jpMain.setBorder(new TitledBorder(""));
		getContentPane().add(jpMain);
		jpMain.setLayout(null);

		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBounds(6, 7, 420, 60);
		getContentPane().add(jpTitle);
		jpTitle.setBorder(new TitledBorder(""));
		jpTitle.setLayout(new BorderLayout(0, 0));

		JLabel jlblTitle = new JLabel("성적표");
		jpTitle.add(jlblTitle, BorderLayout.CENTER);
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblTitle.setBackground(Color.WHITE);

		JLabel jlblName = new JLabel("학생명");
		jlblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblName.setHorizontalAlignment(SwingConstants.CENTER);
		jlblName.setBounds(50, 50, 100, 25);
		jpMain.add(jlblName);

		JLabel jlblTeacher = new JLabel("담당강사");
		jlblTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacher.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblTeacher.setBounds(50, 90, 100, 25);
		jpMain.add(jlblTeacher);

		JLabel jlblEndCourse = new JLabel("교육종료");
		jlblEndCourse.setHorizontalAlignment(SwingConstants.CENTER);
		jlblEndCourse.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblEndCourse.setBounds(50, 130, 100, 25);
		jpMain.add(jlblEndCourse);

		JLabel jlblSubject = new JLabel("과목");
		jlblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		jlblSubject.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblSubject.setBounds(50, 170, 100, 25);
		jpMain.add(jlblSubject);

		JLabel jlblMyAnswer = new JLabel("정답수");
		jlblMyAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		jlblMyAnswer.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblMyAnswer.setBounds(50, 210, 100, 25);
		jpMain.add(jlblMyAnswer);

		jlblNameSet = new JLabel("");
		jlblNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblNameSet.setBounds(260, 50, 100, 25);
		jpMain.add(jlblNameSet);

		jlblTeacherNameSet = new JLabel("");
		jlblTeacherNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTeacherNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblTeacherNameSet.setBounds(260, 90, 100, 25);
		jpMain.add(jlblTeacherNameSet);

		jlblEndCourseSet = new JLabel("");
		jlblEndCourseSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblEndCourseSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblEndCourseSet.setBounds(260, 130, 100, 25);
		jpMain.add(jlblEndCourseSet);

		jlblMyAnswerSet = new JLabel("");
		jlblMyAnswerSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblMyAnswerSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblMyAnswerSet.setBounds(260, 210, 100, 25);
		jpMain.add(jlblMyAnswerSet);

		jcbSubjectSet = new JComboBox();
		jcbSubjectSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jcbSubjectSet.setBounds(270, 170, 80, 25);
		jpMain.add(jcbSubjectSet);

		jbtnExit = new JButton("닫기");
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFocusPainted(false);
		jbtnExit.setBounds(165, 456, 100, 45);
		getContentPane().add(jbtnExit);

		// #. 이벤트 설정
		// #-1. 이벤트 객체 생성
		StudentExamScoreEvt sese = new StudentExamScoreEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnExit.addActionListener(sese);
		jcbSubjectSet.addActionListener(sese);
		addWindowListener(sese);

		// #. 모달 설정
		setModal(true);

		// #. 위치 및 사이즈 설
		setBounds(new Point(sep.getLocationOnScreen()).x + 55, new Point(sep.getLocationOnScreen()).y - 100, 450, 550);

		// #. 가시화
		setVisible(true);

		// #. 사이즈 조정 불가
		setResizable(false);

		// #. 종료 설정
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}// StudentExamScoreView

	// Getter Method
	public JLabel getJlblNameSet() {
		return jlblNameSet;
	}

	public StudentAccountVO getSaVO() {
		return saVO;
	}

	public JLabel getJlblTeacherNameSet() {
		return jlblTeacherNameSet;
	}

	public JLabel getJlblEndCourseSet() {
		return jlblEndCourseSet;
	}

	public JLabel getJlblMyAnswerSet() {
		return jlblMyAnswerSet;
	}

	public JComboBox getJcbSubjectSet() {
		return jcbSubjectSet;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}

	public String getSelectedExamName() {
		return selectedExamName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public StudentMainVO getSmVO() {
		return smVO;
	}

	public StudentGradeVO getSgVO() {
		return sgVO;
	}

	public void setSgVO(StudentGradeVO sgVO) {
		this.sgVO = sgVO;
	}

}// class
