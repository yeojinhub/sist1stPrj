package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

@SuppressWarnings("serial")
public class AdminExamView extends JFrame {
	
	private DefaultTableModel dftmAdminExamTableModel;
	private JTable jtAdminExamTable;
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamDelete;
	
	@SuppressWarnings("unused")
	private AdminMainView amv;
	
	public AdminExamView(AdminMainView amv) {
		this.amv = amv;
		
		setLocationRelativeTo(this);
		// 디자인(색깔, 글씨) 설정
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
		JPanel jpAdminExamViewTitlePanel = new JPanel();
		jpAdminExamViewTitlePanel.setBackground(white);
		jpAdminExamViewTitlePanel.setPreferredSize(panelSize);
		jpAdminExamViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminExamViewTitlePanel.setLayout(new BorderLayout(0, 0));
		
		// 제목 타이틀 생성
		JLabel jlblAdminExamTitle = new JLabel("시험지 관리");
		jlblAdminExamTitle.setBackground(white);
		jlblAdminExamTitle.setFont(titleFont);
		jlblAdminExamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminExamViewTitlePanel.add(jlblAdminExamTitle, BorderLayout.CENTER);
		
		// Table 타이틀 생성
        // 실제 컬럼명은 DB에서 가져온 데이터를 기준으로 합니다.
        String[] strAdminExamTableTitle = {
            "시험과목명", "과정명", "담당강사", "시험응시날짜"
        };
		
		// DB에서 실제 데이터를 불러와서 DefaultTableModel 생성
		dftmAdminExamTableModel = new DefaultTableModel(strAdminExamTableTitle, 0);
		
		// Table Component 생성
		jtAdminExamTable = new JTable(dftmAdminExamTableModel);
        
        // Table 열 정렬 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Table 열 너비 설정
        TableColumnModel columnModel = jtAdminExamTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(330);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 2:
        		columnModel.getColumn(i).setPreferredWidth(110);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(130);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	}
        }
        
        // Table 수정 불가능
        jtAdminExamTable.setDefaultEditor(Object.class, null);
        jtAdminExamTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminExamTable.setRowHeight(25);
        jtAdminExamTable.setFont(tableFont);
        
        // Table Component 배치
        JScrollPane spAdminExamViewScroll = new JScrollPane(jtAdminExamTable);
        spAdminExamViewScroll.getViewport().setBackground(white);
        spAdminExamViewScroll.setPreferredSize(scrollSize);
        JPanel jpAdminExamViewTablePanel = new JPanel(new BorderLayout());
        jpAdminExamViewTablePanel.add(spAdminExamViewScroll, BorderLayout.CENTER);
        
        // Button 생성
        JPanel jpAdminExamViewButtonPanel = new JPanel();
        jpAdminExamViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpAdminExamViewButtonPanel.setBackground(white);
        jpAdminExamViewButtonPanel.setBorder(new TitledBorder(""));
        jpAdminExamViewButtonPanel.setPreferredSize(panelSize);
        jbtnAdminExamCreate = new JButton("등록");
        jbtnAdminExamCreate.setBackground(lightblue);
        jbtnAdminExamCreate.setSize(buttonSize);
        jbtnAdminExamCreate.setFont(buttonFont);
        jbtnAdminExamModify = new JButton("수정");
        jbtnAdminExamModify.setBackground(lightblue);
        jbtnAdminExamModify.setSize(buttonSize);
        jbtnAdminExamModify.setFont(buttonFont);
        jbtnAdminExamDelete = new JButton("삭제");
        jbtnAdminExamDelete.setBackground(lightblue);
        jbtnAdminExamDelete.setSize(buttonSize);
        jbtnAdminExamDelete.setFont(buttonFont);
        
        jpAdminExamViewButtonPanel.add(jbtnAdminExamCreate);
        jpAdminExamViewButtonPanel.add(jbtnAdminExamModify);
        jpAdminExamViewButtonPanel.add(jbtnAdminExamDelete);
        
        // Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminExamViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminExamViewTablePanel, BorderLayout.CENTER);
        add(jpAdminExamViewButtonPanel, BorderLayout.SOUTH);
        
        // Button 이벤트 생성
        AdminExamEvt aee = new AdminExamEvt(amv, this);
        jbtnAdminExamCreate.addActionListener(aee);
        jbtnAdminExamModify.addActionListener(aee);
        jbtnAdminExamDelete.addActionListener(aee);
        
        // 테이블 이벤트 생성
        aee.loadExamData();
	}
	
	
	
	// getter methods
	public DefaultTableModel getDftmAdminExamTableModel() {
		return dftmAdminExamTableModel;
	}

	public JTable getJtAdminExamTable() {
		return jtAdminExamTable;
	}
	
	public JButton getJbtnAdminExamCreate() {
		return jbtnAdminExamCreate;
	}

	public JButton getJbtnAdminExamModify() {
		return jbtnAdminExamModify;
	}
	
	public JButton getJbtnAdminExamDelete() {
		return jbtnAdminExamDelete;
	}
	
}
