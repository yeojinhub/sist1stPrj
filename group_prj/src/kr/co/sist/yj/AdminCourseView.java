//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
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

//import kr.co.sist.evt.AdminCourseEvt;

@SuppressWarnings("serial")
public class AdminCourseView extends JFrame {

	@SuppressWarnings("unused")
	private AdminMainView mainView;

	private DefaultTableModel courseTableModel;
	private JTable courseInfoTable;

	private List<AdminCourseVO> courseList;

	private JButton courCreateViewButton;
	private JButton courModifyViewButton;

	public AdminCourseView(AdminMainView mainView) {
		this.mainView = mainView;

		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension panelSize = new Dimension(700, 45);
		Dimension scrollSize = new Dimension(703, 455);
		Dimension buttonSize = new Dimension(120, 40);

		// Component 생성
		// 제목 Panel 생성
		JPanel courseViewTitlePanel = new JPanel();
		courseViewTitlePanel.setBackground(white);
		courseViewTitlePanel.setPreferredSize(panelSize);
		courseViewTitlePanel.setBorder(new TitledBorder(""));
		courseViewTitlePanel.setLayout(new BorderLayout(0, 0));

		// 제목 타이틀 생성
		JLabel courseTitleLabel = new JLabel("과정 관리");
		courseTitleLabel.setBackground(white);
		courseTitleLabel.setFont(titleFont);
		courseTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		courseViewTitlePanel.add(courseTitleLabel, BorderLayout.CENTER);

		// Table 타이틀 생성
		String[] courseTableTitle = { "", "기수", "과정명", "진행상태", "담당강사", "시작일", "종료일" };

		// Table Component 생성
		courseTableModel = new DefaultTableModel(courseTableTitle, 0);
		courseInfoTable = new JTable(courseTableModel);

		// Table 열 정렬 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Table 열 너비 설정
		TableColumnModel columnModel = courseInfoTable.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			switch (i) {
			case 0:
				// 컬럼을 숨기기 위한 크기 설정
				columnModel.getColumn(i).setMinWidth(0);
				columnModel.getColumn(i).setMaxWidth(0);
				columnModel.getColumn(i).setWidth(0);
			case 1:
				columnModel.getColumn(i).setPreferredWidth(45);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			case 2:
				columnModel.getColumn(i).setPreferredWidth(295);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			case 3:
			case 4:
				columnModel.getColumn(i).setPreferredWidth(80);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			default:
				columnModel.getColumn(i).setPreferredWidth(100);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			} // end switch
		} // end for

		// Table 디자인, 수정 불가능 설정
		courseInfoTable.setDefaultEditor(Object.class, null);
		courseInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		courseInfoTable.setRowHeight(25);
		courseInfoTable.setFont(tableFont);

		// Table Component 배치
		JScrollPane courseViewScroll = new JScrollPane(courseInfoTable);
		courseViewScroll.getViewport().setBackground(white);
		courseViewScroll.setPreferredSize(scrollSize);
		JPanel courseViewTablePanel = new JPanel(new BorderLayout());
		courseViewTablePanel.add(courseViewScroll, BorderLayout.CENTER);

		// Button 생성
		JPanel courseViewButtonPanel = new JPanel();
		courseViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		courseViewButtonPanel.setBackground(white);
		courseViewButtonPanel.setBorder(new TitledBorder(""));
		courseViewButtonPanel.setPreferredSize(panelSize);
		
		courCreateViewButton = new JButton("등록");
		courCreateViewButton.setBackground(lightblue);
		courCreateViewButton.setSize(buttonSize);
		courCreateViewButton.setFont(buttonFont);
		
		courModifyViewButton = new JButton("수정");
		courModifyViewButton.setBackground(lightblue);
		courModifyViewButton.setSize(buttonSize);
		courModifyViewButton.setFont(buttonFont);

		// Button 배치
		courseViewButtonPanel.add(courCreateViewButton);
		courseViewButtonPanel.add(courModifyViewButton);

		// Panel 배치
		setLayout(new BorderLayout());
		add(courseViewTitlePanel, BorderLayout.NORTH);
		add(courseViewTablePanel, BorderLayout.CENTER);
		add(courseViewButtonPanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminCourseEvt courEvt = new AdminCourseEvt(mainView, this);
		courCreateViewButton.addActionListener(courEvt);
		courModifyViewButton.addActionListener(courEvt);
		
		// Mouse 이벤트 생성
		courseInfoTable.addMouseListener(courEvt);

	} // AdminCourseView

	// getter method
	public DefaultTableModel getCourseTableModel() {
		return courseTableModel;
	}
	
	public JTable getCourseInfoTable() {
		return courseInfoTable;
	}

	public List<AdminCourseVO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<AdminCourseVO> courseList) {
		this.courseList = courseList;
	}

	public JButton getCourCreateViewButton() {
		return courCreateViewButton;
	}

	public JButton getCourModifyViewButton() {
		return courModifyViewButton;
	}
	
} // class
