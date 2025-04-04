//package kr.co.sist.view;
package kr.co.sist.yj;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//import kr.co.sist.evt.AdminCourseEvt;

@SuppressWarnings("serial")
public class AdminCourseView extends JFrame{

	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	
	public AdminCourseView() {
		
		//Color 색깔 설정
		Color white = new Color(255, 255, 255);
		
		//Component 생성
		//제목 Title 생성
		JPanel jpAdminCourseViewTitlePanel = new JPanel();
		jpAdminCourseViewTitlePanel.setBackground(white);
		jpAdminCourseViewTitlePanel.setBounds(12, 10, 535, 45);
		jpAdminCourseViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminCourseViewTitlePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel jlblAdminCourseTitle = new JLabel("과정 조회");
		jlblAdminCourseTitle.setBackground(white);
		jlblAdminCourseTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
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
        
        //Table 수정 불가능
        jtAdminCourseTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminCourseTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(370); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminCourseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminCourseTable.setRowHeight(25);

        //Table Component 배치
        JScrollPane spAdminCourseViewScroll = new JScrollPane(jtAdminCourseTable);
        spAdminCourseViewScroll.setPreferredSize(new Dimension(770,500));
        JPanel jpAdminCourseViewTablePanel = new JPanel(new BorderLayout());
        jpAdminCourseViewTablePanel.add(spAdminCourseViewScroll, BorderLayout.CENTER);

        //Button 생성
        JPanel jpAdminCourseViewButtonPanel = new JPanel();
        jpAdminCourseViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminCourseCreate = new JButton("등록");
        jbtnAdminCourseModify = new JButton("수정");
        jbtnAdminCourseDelete = new JButton("삭제");
        
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseCreate);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseModify);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseDelete);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminCourseViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminCourseViewTablePanel, BorderLayout.CENTER);
        add(jpAdminCourseViewButtonPanel, BorderLayout.SOUTH);
        
        //Button 이벤트 생성
        AdminCourseEvt ace = new AdminCourseEvt(this);
        jbtnAdminCourseCreate.addActionListener(ace);;
        jbtnAdminCourseModify.addActionListener(ace);;
        jbtnAdminCourseDelete.addActionListener(ace);;
		
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