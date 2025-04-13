package kr.co.sist.kti;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

public class StudentBoardChangeView extends JDialog {

	private JTextField jtfTitleSet;
	private JTextArea jtaBoardSet;
	private JButton jbtnChange, jbtnExit;
	
	private int selectedBoardNum;

	public StudentBoardChangeView(StudentBoardPanel sbp, int selectedBoardNum, StudentBoardReadView sbrv) {
		this.selectedBoardNum = selectedBoardNum;
		setTitle("Best Campus - 1:1 문의 작성");
		
		// #. 백그라운드 색상 설정 및 수동배치 설정
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		// #. 컴포넌트 배치 및 설정
		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpTitle.setBounds(5, 5, 675, 45);
		getContentPane().add(jpTitle);
		jpTitle.setLayout(null);

		JLabel jlblTitle = new JLabel("제목");
		jlblTitle.setBounds(10, 10, 50, 25);
		jpTitle.add(jlblTitle);
		jlblTitle.setBackground(new Color(255, 255, 255));
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		jtfTitleSet = new JTextField();
		jtfTitleSet.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jtfTitleSet.setBounds(70, 10, 595, 25);
		jpTitle.add(jtfTitleSet);
		jtfTitleSet.setColumns(10);

		jtaBoardSet = new JTextArea();
		jtaBoardSet.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jtaBoardSet.setLineWrap(true);
		jtaBoardSet.setBorder(new TitledBorder(""));
		jtaBoardSet.setBounds(6, 55, 674, 405);
		getContentPane().add(jtaBoardSet);

		jbtnChange = new JButton("수정");
		jbtnChange.setBackground(new Color(235, 235, 255));
		jbtnChange.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnChange.setFocusPainted(false);
		jbtnChange.setBounds(200, 470, 100, 35);
		getContentPane().add(jbtnChange);

		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setFocusPainted(false);
		jbtnExit.setBounds(363, 470, 100, 35);
		getContentPane().add(jbtnExit);
		
		// #. 수정시 기존에 글에 제목과 내용을 셋팅해주면 수정하는 느낌이 더 살꺼야.
		jtfTitleSet.setText(sbrv.getJlblTitleSet().getText());
		jtaBoardSet.setText(sbrv.getJtaBoardSet().getText());

		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentBoardChangeEvt sbwe = new StudentBoardChangeEvt(this, sbp);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnExit.addActionListener(sbwe);
		jbtnChange.addActionListener(sbwe);

		// #. 모달 설정
		setModal(true);

		// #. 위치 및 사이즈 조정
		setBounds(new Point(sbp.getLocationOnScreen()).x-70, new Point(sbp.getLocationOnScreen()).y-100, 700, 560);

		// #. 가시화 설정
		setVisible(true);

		// #. 종료 처리
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}// StudentBoardOneView

	// Getter Method
	public JTextField getJtfTitleSet() {
		return jtfTitleSet;
	}

	public int getSelectedBoardNum() {
		return selectedBoardNum;
	}

	public JTextArea getJtaBoardSet() {
		return jtaBoardSet;
	}

	public JButton getJbtnChange() {
		return jbtnChange;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}

}// class
