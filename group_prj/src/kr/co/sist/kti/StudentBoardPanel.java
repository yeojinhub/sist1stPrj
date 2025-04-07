package kr.co.sist.kti;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import kr.co.sist.kti.StudentAccountVO;
import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardPanel extends JPanel {

	private JTable jtBoard;
	private DefaultTableModel dtm;
	private JButton jbtnWrite;
	
	private List<StudentBoardVO> boardList;
	
	private StudentAccountVO saVO;

	public StudentBoardPanel(StudentAccountVO saVO) {
		this.saVO = saVO;
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
		jbtnWrite.setFocusPainted(false);
		jbtnWrite.setBounds(220, 495, 120, 40);
		add(jbtnWrite);

		// #. DefaultTableModel 추가 및 설정
		// #-1. 객체 생성
		dtm = new DefaultTableModel();

		// #-2. 가데이터 추가
		dtm.addColumn("BOARD_NUM");
		dtm.addColumn("번호");
		dtm.addColumn("제목");
		dtm.addColumn("작성자");
		dtm.addColumn("작성일");
		dtm.addColumn("상태");

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
		jtBoard.getColumnModel().getColumn(0).setMinWidth(0); // 최소 너비
		jtBoard.getColumnModel().getColumn(0).setMaxWidth(0); // 최대 너비
		jtBoard.getColumnModel().getColumn(0).setWidth(0); // 최대 너비
		jtBoard.getColumnModel().getColumn(1).setMinWidth(40); // 최소 너비
		jtBoard.getColumnModel().getColumn(1).setMaxWidth(40); // 최대 너비
		jtBoard.getColumnModel().getColumn(1).setPreferredWidth(40); // 기본 너비
		jtBoard.getColumnModel().getColumn(2).setMinWidth(250); // 최소 너비
		jtBoard.getColumnModel().getColumn(2).setMaxWidth(250); // 최대 너비
		jtBoard.getColumnModel().getColumn(2).setPreferredWidth(250); // 기본 너비
		jtBoard.getColumnModel().getColumn(3).setMinWidth(60); // 최소 너비
		jtBoard.getColumnModel().getColumn(3).setMaxWidth(60); // 최대 너비
		jtBoard.getColumnModel().getColumn(3).setPreferredWidth(60); // 기본 너비

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

	public StudentAccountVO getSaVO() {
		return saVO;
	}

	public List<StudentBoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<StudentBoardVO> boardList) {
		this.boardList = boardList;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public JButton getJbtnWrite() {
		return jbtnWrite;
	}
	
}// class
