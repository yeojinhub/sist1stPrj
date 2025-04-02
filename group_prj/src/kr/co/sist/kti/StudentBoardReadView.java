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
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentBoardReadView extends JDialog {

	private JLabel jlblTitleSet, jlblAuthorNameSet, jlblRespondentSet, jlblRePostSet;
	private JTextArea jtaBoardSet;
	private JButton jbtnExit, jbtnChangePost, jbtnDeletePost;

	public StudentBoardReadView() {
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

		jlblTitleSet = new JLabel("시험 성적 관련 문의");
		jpTitle.add(jlblTitleSet);
		jlblTitleSet.setHorizontalAlignment(SwingConstants.LEFT);
		jlblTitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblTitleSet.setBackground(new Color(255, 255, 255));

		JPanel jpAuthor = new JPanel();
		jpAuthor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpAuthor.setBackground(Color.WHITE);
		jpAuthor.setBounds(5, 45, 660, 30);
		getContentPane().add(jpAuthor);
		jpAuthor.setLayout(null);

		jlblAuthorNameSet = new JLabel("강태일");
		jlblAuthorNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblAuthorNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAuthorNameSet.setBounds(5, 7, 70, 15);
		jpAuthor.add(jlblAuthorNameSet);

		jbtnChangePost = new JButton("수정");
		jbtnChangePost.setBackground(new Color(235, 235, 255));
		jbtnChangePost.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		jbtnChangePost.setBounds(520, 5, 60, 20);
		jpAuthor.add(jbtnChangePost);

		jbtnDeletePost = new JButton("삭제");
		jbtnDeletePost.setBackground(new Color(235, 235, 255));
		jbtnDeletePost.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		jbtnDeletePost.setBounds(590, 5, 60, 20);
		jpAuthor.add(jbtnDeletePost);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(""));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(5, 78, 660, 373);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JTextArea jtaBoardSet = new JTextArea();
		jtaBoardSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jtaBoardSet.setText("이거 시험 성적 평소 제 점수보다 덜 나온거 같은데 문제있는지 확인 부탁 드립니다.");
		jtaBoardSet.setLineWrap(true);
		jtaBoardSet.setEditable(false);
		jtaBoardSet.setHighlighter(null);
		jtaBoardSet.setBounds(5, 5, 650, 305);
		panel_2.add(jtaBoardSet);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new TitledBorder(""));
		panel_3.setBounds(5, 312, 650, 57);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		jlblRespondentSet = new JLabel("곽우신");
		jlblRespondentSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblRespondentSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblRespondentSet.setBounds(15, 15, 80, 25);
		panel_3.add(jlblRespondentSet);

		jlblRePostSet = new JLabel("그 점수대가 맞으십니다.");
		jlblRePostSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblRePostSet.setBounds(120, 15, 515, 25);
		panel_3.add(jlblRePostSet);

		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setBounds(275, 461, 100, 25);
		getContentPane().add(jbtnExit);

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentBoardReadEvt sbre = new StudentBoardReadEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnChangePost.addActionListener(sbre);
		jbtnDeletePost.addActionListener(sbre);
		jbtnExit.addActionListener(sbre);

		// #. 모달 설정
		setModal(true);

		// #. 위치 및 사이즈 조정
		setBounds(100, 100, 690, 540);

		// #. 가시화 설정
		setVisible(true);

		// #. 종료 처리
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}// StudentBoardReadView

	// Getter Methods
	public JLabel getJlblTitleSet() {
		return jlblTitleSet;
	}

	public JLabel getJlblAuthorNameSet() {
		return jlblAuthorNameSet;
	}

	public JLabel getJlblRespondentSet() {
		return jlblRespondentSet;
	}

	public JLabel getJlblRePostSet() {
		return jlblRePostSet;
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

}// class
