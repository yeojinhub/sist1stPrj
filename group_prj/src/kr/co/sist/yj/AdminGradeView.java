package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminGradeView extends JFrame {

	private JButton jbtnAdminGradeSearch;

	public AdminGradeView() {

		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension comboboxSize = new Dimension(200, 22);
		Dimension panelSize = new Dimension(700, 45);
		Dimension tableSize = new Dimension(703, 455);
		Dimension buttonSize = new Dimension(120, 40);

		// Component 생성
		// 제목 Panel 생성
		JPanel jpAdminGradeViewTitlePanel = new JPanel();
		jpAdminGradeViewTitlePanel.setBackground(white);
		jpAdminGradeViewTitlePanel.setPreferredSize(panelSize);
		jpAdminGradeViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminGradeViewTitlePanel.setLayout(new BorderLayout(0, 0));

		// 제목 타이틀 생성
		JLabel jlblAdminGradeTitle = new JLabel("성적 조회");
		jlblAdminGradeTitle.setBackground(white);
		jlblAdminGradeTitle.setFont(titleFont);
		jlblAdminGradeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminGradeViewTitlePanel.add(jlblAdminGradeTitle, BorderLayout.CENTER);

		// 기수 ComboBox 생성
		String[] strAdminGradeCourseCardinalTitle = { "기수 선택", "25-1", "25-2", "25-3", "25-4" };
		JComboBox<String> jcbAdminGradeCourseCardinalBox = new JComboBox<String>(strAdminGradeCourseCardinalTitle);
		jcbAdminGradeCourseCardinalBox.setPreferredSize(comboboxSize);

		// 과목명 ComboBox 생성
		String[] strAdminGradeExamNameTitle = { "과목 선택", "JAVA", "DBMS" };
		JComboBox<String> jcbAdminGradeExamNameBox = new JComboBox<String>(strAdminGradeExamNameTitle);
		jcbAdminGradeExamNameBox.setPreferredSize(comboboxSize);

		// 조회 Button 생성
		JPanel jpAdminGradeViewButtonPanel = new JPanel();
		jpAdminGradeViewButtonPanel.setBackground(white);
		jpAdminGradeViewButtonPanel.setPreferredSize(panelSize);
		jpAdminGradeViewButtonPanel.setBorder(new TitledBorder(""));
		jpAdminGradeViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jbtnAdminGradeSearch = new JButton("조회");
		jbtnAdminGradeSearch.setBackground(lightblue);
		jbtnAdminGradeSearch.setSize(buttonSize);
		jbtnAdminGradeSearch.setFont(buttonFont);

		// Component 배치
		// Button 배치
		jpAdminGradeViewButtonPanel.add(jcbAdminGradeCourseCardinalBox);
		jpAdminGradeViewButtonPanel.add(jcbAdminGradeExamNameBox);
		jpAdminGradeViewButtonPanel.add(jbtnAdminGradeSearch);

		// Table 타이틀 생성
		String[] strAdminGradeTableTitle = { "기수", "시험과목명", "학생이름", "성적", "시험응시날짜" };

		// Table 가데이터 생성
		String[][] strAdminGradeTableData = { { "25-1", "JAVA", "강태일", "4", "2025-01-20" },
				{ "25-2", "JAVA", "김민경", "5", "2025-02-17" }, { "25-3", "DBMS", "이여진", "2", "2025-03-24" },
				{ "25-4", "DBMS", "장태규", "3", "2025-04-21" }, };

		// Table Component 생성
		DefaultTableModel dftmAdminGradeTableModel = new DefaultTableModel(strAdminGradeTableData,
				strAdminGradeTableTitle);
		JTable jtAdminGradeTable = new JTable(dftmAdminGradeTableModel);

		// Table 열 정렬 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Table 열 너비 설정
		TableColumnModel columnModel = jtAdminGradeTable.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			switch (i) {
			case 0:
				columnModel.getColumn(i).setPreferredWidth(55);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			case 1:
				columnModel.getColumn(i).setPreferredWidth(315);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			default:
				columnModel.getColumn(i).setPreferredWidth(110);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			} // end switch
		} // end for

		// Table 디자인, 수정 불가능 설정
		jtAdminGradeTable.setDefaultEditor(Object.class, null);
		jtAdminGradeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtAdminGradeTable.setRowHeight(25);
		jtAdminGradeTable.setFont(tableFont);

		// Table Component 배치
		JScrollPane spAdminGradeViewScroll = new JScrollPane(jtAdminGradeTable);
		spAdminGradeViewScroll.getViewport().setBackground(white);
		spAdminGradeViewScroll.setPreferredSize(tableSize);
		JPanel jpAdminGradeViewTablePanel = new JPanel(new BorderLayout());
		jpAdminGradeViewTablePanel.setBackground(white);
		jpAdminGradeViewTablePanel.add(spAdminGradeViewScroll, BorderLayout.CENTER);

		// Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminGradeViewTitlePanel, BorderLayout.NORTH);
		add(jpAdminGradeViewButtonPanel, BorderLayout.CENTER);
		add(jpAdminGradeViewTablePanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminGradeEvt age = new AdminGradeEvt(this);
		jbtnAdminGradeSearch.addActionListener(age);

	} // AdminGradeView

	// getter method
	public JButton getJbtnAdminGradeSearch() {
		return jbtnAdminGradeSearch;
	} // getJbtnAdminGradeSearch

} // class
