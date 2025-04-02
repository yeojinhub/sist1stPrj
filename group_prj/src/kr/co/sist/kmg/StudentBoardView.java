package kr.co.sist.kmg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentBoardView extends JFrame {

	private JTable jtStudentBoardertable;

	private DefaultTableModel dtm;

	private JPanel contentPane;
	private JLabel jlblStudentBoardTitle;
	private JButton jbtnStudentBoardWrite;
	private JButton jbtnStudentBoardClose;

	public StudentBoardView() {
//		배경
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		getContentPane().setLayout(null);

//		테이블 넣을 곳
		dtm = new DefaultTableModel();
		String[] columnName = { "번호", "제목", "작성자", "작성일", "상태" };
		dtm = new DefaultTableModel(columnName, 0);

		String[][] data = { { "1", "자바 학습", "홍길동", "2025-04-01", "진행 중" },
				{ "2", "", "김철수", "2025-03-28", "완료" }, { "3", "디자인 패턴", "이영희", "2025-03-25", "진행 중" },
				{ "4", "데이터베이스", "박민수", "2025-03-22", "진행 중" }, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }
				, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }
				, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }
				, { "5", "알고리즘아아아아아아아아아아아아아아아아아아", "최지훈", "2025-03-20", "완료" }
				, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }
				, { "5", "알고리즘", "최지훈", "2025-03-20", "완료" }};

		// 각 레코드를 테이블에 추가
		for (String[] record : data) {
			dtm.addRow(record);
		}

		jtStudentBoardertable = new JTable(dtm);
		jtStudentBoardertable.setBackground(new Color(255, 255, 255));
		jtStudentBoardertable.setDefaultEditor(Object.class, null); // 1-1편집못하게 막은것

		// 열 크기 설정
		jtStudentBoardertable.getColumnModel().getColumn(0).setMinWidth(50); // 최소 너비
		jtStudentBoardertable.getColumnModel().getColumn(0).setMaxWidth(150); // 최대 너비
		jtStudentBoardertable.getColumnModel().getColumn(0).setPreferredWidth(50); // 기본 너비
		
		jtStudentBoardertable.getColumnModel().getColumn(1).setPreferredWidth(300); // 제목 열 너비
		jtStudentBoardertable.getColumnModel().getColumn(2).setPreferredWidth(200); // 작성자 열 너비
		jtStudentBoardertable.getColumnModel().getColumn(3).setPreferredWidth(200); // 작성일 열 너비
		jtStudentBoardertable.getColumnModel().getColumn(4).setPreferredWidth(150);

		// 행의 높이를 설정
		jtStudentBoardertable.setRowHeight(40);

		// 테이블의 전체 크기 설정
		jtStudentBoardertable.setPreferredScrollableViewportSize(new Dimension(700, 300)); // 테이블 크기를 (900, 300) 으로 설정
		
		JScrollPane jspSerchBoard = new JScrollPane(jtStudentBoardertable);
		jspSerchBoard.setBounds(50, 80, 800, 400);
		contentPane.add(jspSerchBoard);
		
// 		버튼
		jbtnStudentBoardWrite = new JButton("작성");
		jbtnStudentBoardWrite.setFont(new Font("Dialog", Font.BOLD, 30));
		jbtnStudentBoardWrite.setBounds(113, 511, 200, 50);
		jbtnStudentBoardWrite.setBackground(new Color(255, 165, 0));
        contentPane.add(jbtnStudentBoardWrite);
        
        jbtnStudentBoardClose = new JButton("닫기");
        jbtnStudentBoardClose.setFont(new Font("Dialog", Font.BOLD, 30));
        jbtnStudentBoardClose.setBackground(new Color(255, 165, 0));
        jbtnStudentBoardClose.setBounds(581, 511, 200, 50);
        contentPane.add(jbtnStudentBoardClose);
        
        jlblStudentBoardTitle = new JLabel("게  시  판");
        jlblStudentBoardTitle.setFont(new Font("Dialog", Font.BOLD, 30));
        jlblStudentBoardTitle.setBounds(400, 15, 122, 40);
        contentPane.add(jlblStudentBoardTitle);
		
//		이벤트 등록
        StudentBoardViewEvt sbve=new StudentBoardViewEvt(this);
        jbtnStudentBoardWrite.addActionListener(sbve);
        jbtnStudentBoardClose.addActionListener(sbve);
        
		setResizable(false);

//		window 크기 설정
		setBounds(100, 100, 900,700);
//		사용자에게 window 출력
		setVisible(true);
//		x로 창닫기
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}// StudentBoarderView
// getter

	public JTable getJtStudentBoardertable() {
		return jtStudentBoardertable;
	}

	public void setJtStudentBoardertable(JTable jtStudentBoardertable) {
		this.jtStudentBoardertable = jtStudentBoardertable;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JButton getJbtnStudentBoardWrite() {
		return jbtnStudentBoardWrite;
	}

	public void setJbtnStudentBoardWrite(JButton jbtnStudentBoardWrite) {
		this.jbtnStudentBoardWrite = jbtnStudentBoardWrite;
	}

	public JButton getJbtnStudentBoardClose() {
		return jbtnStudentBoardClose;
	}

	public void setJbtnStudentBoardClose(JButton jbtnStudentBoardClose) {
		this.jbtnStudentBoardClose = jbtnStudentBoardClose;
	}
	
	
	
	
}// class
