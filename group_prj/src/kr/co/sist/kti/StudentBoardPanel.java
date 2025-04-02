package kr.co.sist.kti;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class StudentBoardPanel extends JPanel {

	private JTable jtBoard;
	private DefaultTableModel dtm;
	private JButton jbtnWrite;

	public StudentBoardPanel() {

		// #. 컴포넌트 생성 및 설정
		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBounds(12, 10, 535, 45);
		jpTitle.setBorder(new TitledBorder(""));
		jpTitle.setLayout(new BorderLayout(0, 0));
		add(jpTitle);

		JLabel jlblTitle = new JLabel("1:1 문의 게시판");
		jlblTitle.setBackground(new Color(255, 255, 255));
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpTitle.add(jlblTitle, BorderLayout.CENTER);

		jbtnWrite = new JButton("작성");
		jbtnWrite.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		jbtnWrite.setBackground(new Color(235, 235, 255));
		jbtnWrite.setBounds(220, 495, 120, 40);
		add(jbtnWrite);

		// #. DefaultTableModel 추가 및 설정
		// #-1. 객체 생성
		dtm = new DefaultTableModel();

		// #-2. 가데이터 추가
		dtm.addColumn("번호");
		dtm.addColumn("제목");
		dtm.addColumn("작성자");
		dtm.addColumn("작성일");
		dtm.addColumn("상태");
		dtm.addRow(new Object[] { "1", "시험 관련 문의", "강태일", "2025-04-01", "진행 중" });
		dtm.addRow(new Object[] { "2", "수당 관련 문의", "강태일", "2025-02-25", "답변 완료" });

		// #-3. 값 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬

		// #. JTable 추가 및 설정
		jtBoard = new JTable(dtm);
		jtBoard.setDefaultEditor(Object.class, null); // 글 수정 불가하게 만들기.
		jtBoard.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jtBoard.setPreferredScrollableViewportSize(new Dimension(530, 450)); // 스크롤바 기능을 위한 테이블 사이즈 임의 지정
		jtBoard.setFillsViewportHeight(true);

		// #-1. 데이터 가운데 정렬
		for (int i = 0; i < jtBoard.getColumnCount(); i++) {
			jtBoard.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		} // 데이터 가운데 정렬

		// #-2. 컬럼 사이즈 조정
		jtBoard.getColumnModel().getColumn(0).setMinWidth(40); // 최소 너비
		jtBoard.getColumnModel().getColumn(0).setMaxWidth(40); // 최대 너비
		jtBoard.getColumnModel().getColumn(0).setPreferredWidth(40); // 기본 너비
		jtBoard.getColumnModel().getColumn(1).setMinWidth(250); // 최소 너비
		jtBoard.getColumnModel().getColumn(1).setMaxWidth(250); // 최대 너비
		jtBoard.getColumnModel().getColumn(1).setPreferredWidth(250); // 기본 너비
		jtBoard.getColumnModel().getColumn(2).setMinWidth(60); // 최소 너비
		jtBoard.getColumnModel().getColumn(2).setMaxWidth(60); // 최대 너비
		jtBoard.getColumnModel().getColumn(2).setPreferredWidth(60); // 기본 너비

		// #-3. 데이터 사이즈 조절
		jtBoard.setRowHeight(25);

		// #-4. 스크롤바 생성
		JScrollPane jspBoardScroll = new JScrollPane(jtBoard);
		jspBoardScroll.setBounds(12, 60, 535, 430);
		add(jspBoardScroll);
		
		// #. 이벤트 추가
		// #-1. 이벤트 객채 생성
		StudentBoardEvt sbe = new StudentBoardEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnWrite.addActionListener(sbe);
		jtBoard.addMouseListener(sbe);

		// #. 사이즈 설정
		setSize(555, 550);

		// #. 백그라운드 흰색
		setBackground(new Color(255, 255, 255));

		// #. 수동 설정
		setLayout(null);

	}// StudentBoardPanel

	// Getter Method
	public JTable getJtBoard() {
		return jtBoard;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JButton getJbtnWrite() {
		return jbtnWrite;
	}
	
}// class
