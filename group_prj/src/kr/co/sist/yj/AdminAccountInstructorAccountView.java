//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminAccountInstructorAccountView extends JPanel{

	private JButton jbtnAdminAccountInstructorAccountCreate;
    private JButton jbtnAdminAccountInstructorAccountModify;
    private JButton jbtnAdminAccountInstructorAccountDelete;
    
	public AdminAccountInstructorAccountView() {
        
		//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension panelSize = new Dimension(700, 45);
    	Dimension scrollSize = new Dimension(703, 365);
    	Dimension buttonSize = new Dimension(120, 40);
		
        //Table 타이틀 생성
		String strAdminAccountInstructorAccountTitle[] = {
				"사번", "이름", "생년월일", "전화번호", "주소"
		};
		
		//Table 가데이터 생성
		String strAdminAccountInstructorAccountData[][] = {
				{ "20250001", "곽우신", "1980-01-01", "010-1234-5678", "서울특별시 강남구 역삼동" },
		};
		
		//Table Component 생성
		DefaultTableModel dftmInstructorTableModel = new DefaultTableModel(strAdminAccountInstructorAccountData, strAdminAccountInstructorAccountTitle);
		JTable jtAdminAccountInstructorAccountTable = new JTable(dftmInstructorTableModel);
		
		//Table 열 정렬 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountInstructorAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 3:
        		columnModel.getColumn(i).setPreferredWidth(110);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(350);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	} //end switch
        } //end for
        
        //Table 디자인, 수정 불가능 설정
        jtAdminAccountInstructorAccountTable.setDefaultEditor(Object.class, null);
        jtAdminAccountInstructorAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminAccountInstructorAccountTable.setRowHeight(25);
        jtAdminAccountInstructorAccountTable.setFont(tableFont);
        
        //Table Component 배치
		JScrollPane spAdminAccountInstructorAccountViewScroll = new JScrollPane(jtAdminAccountInstructorAccountTable);
		spAdminAccountInstructorAccountViewScroll.getViewport().setBackground(white);
		spAdminAccountInstructorAccountViewScroll.setPreferredSize(scrollSize);
		JPanel jpAdminAccountInstructorAccountViewTablePanel = new JPanel(new BorderLayout());
		jpAdminAccountInstructorAccountViewTablePanel.add(spAdminAccountInstructorAccountViewScroll, BorderLayout.CENTER);
		jpAdminAccountInstructorAccountViewTablePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Component 생성
		//Button 생성
        JPanel jpAdminAccountInstructorAccountViewButtonPanel = new JPanel();
        jpAdminAccountInstructorAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpAdminAccountInstructorAccountViewButtonPanel.setBackground(white);
        jpAdminAccountInstructorAccountViewButtonPanel.setBorder(new TitledBorder(""));
        jpAdminAccountInstructorAccountViewButtonPanel.setPreferredSize(panelSize);
        jbtnAdminAccountInstructorAccountCreate = new JButton("생성");
        jbtnAdminAccountInstructorAccountCreate.setBackground(lightblue);
        jbtnAdminAccountInstructorAccountCreate.setSize(buttonSize);
        jbtnAdminAccountInstructorAccountCreate.setFont(buttonFont);
        jbtnAdminAccountInstructorAccountModify = new JButton("수정");
        jbtnAdminAccountInstructorAccountModify.setBackground(lightblue);
        jbtnAdminAccountInstructorAccountModify.setSize(buttonSize);
        jbtnAdminAccountInstructorAccountModify.setFont(buttonFont);
        jbtnAdminAccountInstructorAccountDelete = new JButton("삭제");
        jbtnAdminAccountInstructorAccountDelete.setBackground(lightblue);
        jbtnAdminAccountInstructorAccountDelete.setSize(buttonSize);
        jbtnAdminAccountInstructorAccountDelete.setFont(buttonFont);
        
        //Component 배치
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountCreate);
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountModify);
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountDelete);

		//Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminAccountInstructorAccountViewTablePanel, BorderLayout.CENTER);
		add(jpAdminAccountInstructorAccountViewButtonPanel, BorderLayout.SOUTH);
		
		//Button 이벤트 생성
		AdminAccountInstructorAccountEvt aaiae = new AdminAccountInstructorAccountEvt(this);
		jbtnAdminAccountInstructorAccountCreate.addActionListener(aaiae);
		jbtnAdminAccountInstructorAccountModify.addActionListener(aaiae);
		jbtnAdminAccountInstructorAccountDelete.addActionListener(aaiae);
		
	} //AdminAccountInstructorAccountView

	//getter method
	public JButton getJbtnAdminAccountInstructorAccountCreate() {
		return jbtnAdminAccountInstructorAccountCreate;
	} //getJbtnAdminAccountInstructorAccountCreate

	public JButton getJbtnAdminAccountInstructorAccountModify() {
		return jbtnAdminAccountInstructorAccountModify;
	} //getJbtnAdminAccountInstructorAccountModify

	public JButton getJbtnAdminAccountInstructorAccountDelete() {
		return jbtnAdminAccountInstructorAccountDelete;
	} //getJbtnAdminAccountInstructorAccountDelete
	
} //class