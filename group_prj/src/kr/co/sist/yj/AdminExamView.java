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

@SuppressWarnings("serial")
public class AdminExamView extends JFrame {
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamDelete;
	
	public AdminExamView() {
		
		//Color 색깔 설정
		Color white = new Color(255, 255, 255);
		
		//Component 생성
		//제목 Title 생성
		JPanel jpAdminExamViewTitlePanel = new JPanel();
		jpAdminExamViewTitlePanel.setBackground(white);
		jpAdminExamViewTitlePanel.setBounds(12, 10, 535, 45);
		jpAdminExamViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminExamViewTitlePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel jlblAdminExamTitle = new JLabel("시험지 관리");
		jlblAdminExamTitle.setBackground(white);
		jlblAdminExamTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblAdminExamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminExamViewTitlePanel.add(jlblAdminExamTitle, BorderLayout.CENTER);
		
		//Table 타이틀 생성
        String[] strAdminExamTableTitle = {
            "시험과목명", "과정명", "담당강사"
        };

        //Table 가데이터 생성
        String[][] strAdminExamTableData = {
            { "JAVA", "AWS와 Docker & Kubernetes", "곽우신" },
            { "JAVA", "AWS와 Docker & Kubernetes", "곽우심" },
            { "DBMS", "AWS와 Docker & Kubernetes", "박우신" },
            { "DBMS", "AWS와 Docker & Kubernetes", "강우신" },
        };

        //Table Component 생성
        DefaultTableModel dftmAdminExamTableModel = new DefaultTableModel(strAdminExamTableData, strAdminExamTableTitle);
        JTable jtAdminExamTable = new JTable(dftmAdminExamTableModel);
        
        //Table 수정 불가능
        jtAdminExamTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminExamTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(370); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminExamTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminExamTable.setRowHeight(25);

        //Table Component 배치
        JScrollPane spAdminExamViewScroll = new JScrollPane(jtAdminExamTable);
        spAdminExamViewScroll.setPreferredSize(new Dimension(770,500));
        JPanel jpAdminExamViewTablePanel = new JPanel(new BorderLayout());
        jpAdminExamViewTablePanel.add(spAdminExamViewScroll, BorderLayout.CENTER);

        //Button 생성
        JPanel jpAdminExamViewButtonPanel = new JPanel();
        jpAdminExamViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminExamCreate = new JButton("등록");
        jbtnAdminExamModify = new JButton("수정");
        jbtnAdminExamDelete = new JButton("삭제");
        
        jpAdminExamViewButtonPanel.add(jbtnAdminExamCreate);
        jpAdminExamViewButtonPanel.add(jbtnAdminExamModify);
        jpAdminExamViewButtonPanel.add(jbtnAdminExamDelete);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminExamViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminExamViewTablePanel, BorderLayout.CENTER);
        add(jpAdminExamViewButtonPanel, BorderLayout.SOUTH);
        
        //Button 이벤트 생성
        AdminExamEvt aee = new AdminExamEvt(this);
        jbtnAdminExamCreate.addActionListener(aee);
        jbtnAdminExamModify.addActionListener(aee);
        jbtnAdminExamDelete.addActionListener(aee);
        
	} //AdminExamView

	//getter method
	public JButton getJbtnAdminExamCreate() {
		return jbtnAdminExamCreate;
	} //getJbtnAdminExamCreate

	public JButton getJbtnAdminExamModify() {
		return jbtnAdminExamModify;
	} //getJbtnAdminExamModify

	public JButton getJbtnAdminExamDelete() {
		return jbtnAdminExamDelete;
	} //getJbtnAdminExamDelete

} //class
