package kr.co.sist.kti;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentBoardReadView extends JDialog {

	private JLabel jlblTitleSet, jlblAuthorNameSet, jlblRespondentSet, jlblCommDateSet, jlblWriteDateSet;
	private JTextArea jtaBoardSet;
	private JButton jbtnExit, jbtnChangePost, jbtnDeletePost;
	private JTextArea jtaCourseNameSet;
	private JLabel jlblCommWriterTypeSet;
	private JPanel jpCommWriterType;

	private int selectedBoardNum;

	public StudentBoardReadView(StudentBoardPanel sbp, int selectedBoardNum) {
		this.selectedBoardNum = selectedBoardNum;
		setTitle("Best Campus - 1:1 문의");

		// #. 백그라운드 색상 설정 및 수동배치 설정
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		// #. 컴포넌트 배치 및 수정
		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpTitle.setBounds(5, 5, 660, 40);
		getContentPane().add(jpTitle);
		jpTitle.setLayout(new BorderLayout(0, 0));

		jlblTitleSet = new JLabel("");
		jpTitle.add(jlblTitleSet);
		jlblTitleSet.setHorizontalAlignment(SwingConstants.LEFT);
		jlblTitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblTitleSet.setBackground(new Color(255, 255, 255));

		jlblWriteDateSet = new JLabel("");
		jlblWriteDateSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jlblWriteDateSet.setHorizontalAlignment(SwingConstants.LEFT);
		jpTitle.add(jlblWriteDateSet, BorderLayout.EAST);

		JPanel jpAuthor = new JPanel();
		jpAuthor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpAuthor.setBackground(Color.WHITE);
		jpAuthor.setBounds(5, 45, 660, 30);
		getContentPane().add(jpAuthor);
		jpAuthor.setLayout(null);

		jlblAuthorNameSet = new JLabel("");
		jlblAuthorNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblAuthorNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAuthorNameSet.setBounds(5, 7, 70, 15);
		jpAuthor.add(jlblAuthorNameSet);

		jbtnChangePost = new JButton("수정");
		jbtnChangePost.setBackground(new Color(235, 235, 255));
		jbtnChangePost.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		jbtnChangePost.setFocusPainted(false);
		jbtnChangePost.setBounds(520, 5, 60, 20);
		jpAuthor.add(jbtnChangePost);

		jbtnDeletePost = new JButton("삭제");
		jbtnDeletePost.setBackground(new Color(235, 235, 255));
		jbtnDeletePost.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		jbtnDeletePost.setFocusPainted(false);
		jbtnDeletePost.setBounds(590, 5, 60, 20);
		jpAuthor.add(jbtnDeletePost);

		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder(""));
		jpNorth.setBackground(new Color(255, 255, 255));
		jpNorth.setBounds(5, 78, 660, 373);
		getContentPane().add(jpNorth);
		jpNorth.setLayout(null);

		jtaBoardSet = new JTextArea();
		jtaBoardSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jtaBoardSet.setText("");
		jtaBoardSet.setLineWrap(true);
		jtaBoardSet.setEditable(false);
		jtaBoardSet.setHighlighter(null);
		jtaBoardSet.setBounds(5, 5, 650, 305);
		jpNorth.add(jtaBoardSet);

		JPanel jpSouth = new JPanel();
		jpSouth.setBackground(new Color(255, 255, 255));
		jpSouth.setBorder(new TitledBorder(""));
		jpSouth.setBounds(5, 312, 650, 57);
		jpNorth.add(jpSouth);
		jpSouth.setLayout(null);

		jlblRespondentSet = new JLabel("");
		jlblRespondentSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblRespondentSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblRespondentSet.setBounds(40, 15, 70, 25);
		jpSouth.add(jlblRespondentSet);

		jtaCourseNameSet = new JTextArea();
		jtaCourseNameSet.setText("");
		jtaCourseNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jtaCourseNameSet.setBounds(120, 5, 400, 45);
		jtaCourseNameSet.setLineWrap(true);
		jtaCourseNameSet.setEditable(false);
		jtaCourseNameSet.setHighlighter(null);
		jpSouth.add(jtaCourseNameSet);

		jlblCommDateSet = new JLabel("");
		jlblCommDateSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCommDateSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jlblCommDateSet.setBounds(530, 15, 100, 25);
		jpSouth.add(jlblCommDateSet);

		jpCommWriterType = new JPanel();
		jpCommWriterType.setBounds(10, 18, 35, 20);
		jpSouth.add(jpCommWriterType);
		jpCommWriterType.setBorder(new TitledBorder(""));
		jpCommWriterType.setLayout(null);

		jlblCommWriterTypeSet = new JLabel("");
		jlblCommWriterTypeSet.setBounds(0, 0, 35, 20);
		jpCommWriterType.add(jlblCommWriterTypeSet);
		jlblCommWriterTypeSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCommWriterTypeSet.setFont(new Font("맑은 고딕", Font.BOLD, 10));

		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setFocusPainted(false);
		jbtnExit.setBounds(275, 461, 100, 25);
		getContentPane().add(jbtnExit);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentBoardReadEvt sbre = new StudentBoardReadEvt(this, sbp);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnChangePost.addActionListener(sbre);
		jbtnDeletePost.addActionListener(sbre);
		jbtnExit.addActionListener(sbre);
		// #-3. 데이터 셋팅을 위한 윈도우리스너
		addWindowListener(sbre);

		// #. 모달 설정
		setModal(true);

		// #. 위치 및 사이즈 조정
		setBounds(new Point(sbp.getLocationOnScreen()).x - 70, new Point(sbp.getLocationOnScreen()).y - 100, 690, 540);

		// #. 가시화 설정
		setVisible(true);

		// #. 종료 처리
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}// StudentBoardReadView

	// Getter Methods
	public JLabel getJlblTitleSet() {
		return jlblTitleSet;
	}

	public JLabel getJlblCommDateSet() {
		return jlblCommDateSet;
	}

	public JLabel getJlblCommWriterTypeSet() {
		return jlblCommWriterTypeSet;
	}

	public JPanel getJpCommWriterType() {
		return jpCommWriterType;
	}

	public int getSelectedBoardNum() {
		return selectedBoardNum;
	}

	public JTextArea getJtaCourseNameSet() {
		return jtaCourseNameSet;
	}

	public JLabel getJlblAuthorNameSet() {
		return jlblAuthorNameSet;
	}

	public JLabel getJlblRespondentSet() {
		return jlblRespondentSet;
	}

	public JTextArea getJtaBoardSet() {
		return jtaBoardSet;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}

	public JButton getJbtnChangePost() {
		return jbtnChangePost;
	}

	public JButton getJbtnDeletePost() {
		return jbtnDeletePost;
	}

	public JLabel getJlblWriteDateSet() {
		return jlblWriteDateSet;
	}
	
}// class
