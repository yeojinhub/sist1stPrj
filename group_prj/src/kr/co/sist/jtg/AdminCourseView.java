//package kr.co.sist.view;
package kr.co.sist.jtg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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
public class AdminCourseView extends JFrame{

	@SuppressWarnings("unused")
	private AdminMainView amv;
	
	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	
	public AdminCourseView(AdminMainView amv) {
		this.amv=amv;
		
		//디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
		
		//Dimension 사이즈 설정
		Dimension panelSize = new Dimension(700, 45);
		Dimension scrollSize = new Dimension(703, 455);
		Dimension buttonSize = new Dimension(120, 40);
		
		//Component 생성
		//제목 Panel 생성
		JPanel jpAdminCourseViewTitlePanel = new JPanel();
		jpAdminCourseViewTitlePanel.setBackground(white);
		jpAdminCourseViewTitlePanel.setPreferredSize(panelSize);
		jpAdminCourseViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminCourseViewTitlePanel.setLayout(new BorderLayout(0, 0));
		
		//제목 타이틀 생성
		JLabel jlblAdminCourseTitle = new JLabel("과정 관리");
		jlblAdminCourseTitle.setBackground(white);
		jlblAdminCourseTitle.setFont(titleFont);
		jlblAdminCourseTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminCourseViewTitlePanel.add(jlblAdminCourseTitle, BorderLayout.CENTER);
        
        //Table 타이틀 생성
        String[] strAdminCourseTableTitle = {
            "기수", "과정명", "진행상태", "담당강사", "시작일", "종료일"
        };

        //Table 가데이터 생성
        String[][] strAdminCourseTableData = {
            { "25-1", "AWS와 Docker & Kubernetes", "진행중", "곽우신", "2025-01-13", "2025-07-25" },
            { "25-2", "AWS와 Docker & Kubernetes", "진행중", "곽우심", "2025-02-13", "2025-08-25" },
            { "25-3", "AWS와 Docker & Kubernetes", "진행중", "박우신", "2025-03-13", "2025-09-25" },
            { "25-4", "AWS와 Docker & Kubernetes", "진행중", "강우신", "2025-04-13", "2025-10-25" },
        };

        //Table Component 생성
        DefaultTableModel dftmAdminCourseTableModel = new DefaultTableModel(strAdminCourseTableData, strAdminCourseTableTitle);
        JTable jtAdminCourseTable = new JTable(dftmAdminCourseTableModel);
        
        //Table 열 정렬 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminCourseTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 0:
        		columnModel.getColumn(i).setPreferredWidth(45);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(295);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 2:
        	case 3:
        		columnModel.getColumn(i).setPreferredWidth(80);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(100);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	} //end switch
        } //end for
        
        //Table 디자인, 수정 불가능 설정
        jtAdminCourseTable.setDefaultEditor(Object.class, null);
        jtAdminCourseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminCourseTable.setRowHeight(25);
        jtAdminCourseTable.setFont(tableFont);

        //Table Component 배치
        JScrollPane spAdminCourseViewScroll = new JScrollPane(jtAdminCourseTable);
        spAdminCourseViewScroll.getViewport().setBackground(white);
        spAdminCourseViewScroll.setPreferredSize(scrollSize);
        JPanel jpAdminCourseViewTablePanel = new JPanel(new BorderLayout());
        jpAdminCourseViewTablePanel.add(spAdminCourseViewScroll, BorderLayout.CENTER);
        
        //Button 생성
        JPanel jpAdminCourseViewButtonPanel = new JPanel();
        jpAdminCourseViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpAdminCourseViewButtonPanel.setBackground(white);
        jpAdminCourseViewButtonPanel.setBorder(new TitledBorder(""));
        jpAdminCourseViewButtonPanel.setPreferredSize(panelSize);
        jbtnAdminCourseCreate = new JButton("등록");
        jbtnAdminCourseCreate.setBackground(lightblue);
        jbtnAdminCourseCreate.setSize(buttonSize);
        jbtnAdminCourseCreate.setFont(buttonFont);
        jbtnAdminCourseModify = new JButton("수정");
        jbtnAdminCourseModify.setBackground(lightblue);
        jbtnAdminCourseModify.setSize(buttonSize);
        jbtnAdminCourseModify.setFont(buttonFont);
        jbtnAdminCourseDelete = new JButton("삭제");
        jbtnAdminCourseDelete.setBackground(lightblue);
        jbtnAdminCourseDelete.setSize(buttonSize);
        jbtnAdminCourseDelete.setFont(buttonFont);
        
        //Button 배치
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseCreate);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseModify);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseDelete);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminCourseViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminCourseViewTablePanel, BorderLayout.CENTER);
        add(jpAdminCourseViewButtonPanel, BorderLayout.SOUTH);
        
        //Button 이벤트 생성
        AdminCourseEvt ace = new AdminCourseEvt(amv, this);
        jbtnAdminCourseCreate.addActionListener(ace);
        jbtnAdminCourseModify.addActionListener(ace);
        jbtnAdminCourseDelete.addActionListener(ace);
		
	} //AdminCourseView

	//getter method
	public JButton getJbtnAdminCourseCreate() {
		return jbtnAdminCourseCreate;
	} //getJbtnAdminCourseCreate

	public JButton getJbtnAdminCourseModify() {
		return jbtnAdminCourseModify;
	} //getJbtnAdminCourseModify

	public JButton getJbtnAdminCourseDelete() {
		return jbtnAdminCourseDelete;
	} //getJbtnAdminCourseDelete
	
} //class