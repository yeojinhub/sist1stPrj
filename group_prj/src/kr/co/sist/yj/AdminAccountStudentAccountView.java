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
import javax.swing.table.TableModel; 

//import kr.co.sist.evt.AdminAccountStudentAccountEvt;


@SuppressWarnings({ "serial", "unused" })
public class AdminAccountStudentAccountView extends JPanel {
	
	private DefaultTableModel dftmStudentTableModel;
	private JTable jtAdminAccountStudentAccountTable;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
	
    public AdminAccountStudentAccountView() {

    	//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
    	Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension panelSize = new Dimension(700, 45);
    	Dimension scrollSize = new Dimension(703, 365);
    	Dimension buttonSize = new Dimension(120, 40);
    	
        //Table 타이틀 생성
        String[] strAdminAccountStudentAccountTableTitle = {
            "학번", "이름", "전화번호", "기수", "교육과정", "진행상태"
        };

        //Table 가데이터 생성
        String[][] strAdminAccountStudentAccountTableData = {
            { "20250001", "강태일", "010-1234-5678", "25-3", "AWS와 Docker & Kubernetes 과정", "진행중" },
            { "20250002", "김민경", "010-1111-1111", "25-3", "AWS와 Docker & Kubernetes 과정", "진행중" },
            { "20250003", "이여진", "010-8241-8701", "25-3", "AWS와 Docker & Kubernetes 과정", "진행중" },
            { "20250004", "이재준", "010-0000-0000", "25-3", "AWS와 Docker & Kubernetes 과정", "중도하차" },
            { "20250005", "장태규", "010-9999-9999", "25-3", "AWS와 Docker & Kubernetes 과정", "진행중" },
        };

        //Table Component 생성
        dftmStudentTableModel = new DefaultTableModel(strAdminAccountStudentAccountTableData, strAdminAccountStudentAccountTableTitle);
        jtAdminAccountStudentAccountTable = new JTable(dftmStudentTableModel);

        //Table 열 정렬 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountStudentAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 2:
        		columnModel.getColumn(i).setPreferredWidth(110);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 3:
        		columnModel.getColumn(i).setPreferredWidth(45);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(335);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
//        	case 5:
//        		columnModel.getColumn(i).setPreferredWidth(150);
//        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(70);
        		columnModel.getColumn(i).setCellRenderer(centerRenderer); break;
        	} //end switch
        } //end for
        
        //Table 디자인, 수정 불가능 설정
        jtAdminAccountStudentAccountTable.setDefaultEditor(Object.class, null);
        jtAdminAccountStudentAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminAccountStudentAccountTable.setRowHeight(25);
        jtAdminAccountStudentAccountTable.setFont(tableFont);

        //Table Component 배치
        JScrollPane spAdminAccountStudentAccountViewScroll = new JScrollPane(jtAdminAccountStudentAccountTable);
        spAdminAccountStudentAccountViewScroll.getViewport().setBackground(white);
        spAdminAccountStudentAccountViewScroll.setPreferredSize(scrollSize);
        JPanel jpAdminAccountStudentAccountViewTablePanel = new JPanel(new BorderLayout());
        jpAdminAccountStudentAccountViewTablePanel.add(spAdminAccountStudentAccountViewScroll, BorderLayout.CENTER);
        jpAdminAccountStudentAccountViewTablePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        //Component 생성 
        //Button 생성
        JPanel jpAdminAccountStudentAccountViewButtonPanel = new JPanel();
        jpAdminAccountStudentAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpAdminAccountStudentAccountViewButtonPanel.setBackground(white);
        jpAdminAccountStudentAccountViewButtonPanel.setBorder(new TitledBorder(""));
        jpAdminAccountStudentAccountViewButtonPanel.setPreferredSize(panelSize);
        jbtnAdminAccountStudentAccountCreate = new JButton("생성");
        jbtnAdminAccountStudentAccountCreate.setBackground(lightblue);
        jbtnAdminAccountStudentAccountCreate.setSize(buttonSize);
        jbtnAdminAccountStudentAccountCreate.setFont(buttonFont);
        jbtnAdminAccountStudentAccountModify = new JButton("수정");
        jbtnAdminAccountStudentAccountModify.setBackground(lightblue);
        jbtnAdminAccountStudentAccountModify.setSize(buttonSize);
        jbtnAdminAccountStudentAccountModify.setFont(buttonFont);
        
        //Component 배치
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountCreate);
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountModify);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminAccountStudentAccountViewTablePanel, BorderLayout.CENTER);
        add(jpAdminAccountStudentAccountViewButtonPanel, BorderLayout.SOUTH);
        
        //Button 이벤트 생성
        AdminAccountStudentAccountEvt aasaEvt = new AdminAccountStudentAccountEvt(this); 
        jbtnAdminAccountStudentAccountCreate.addActionListener(aasaEvt);
        jbtnAdminAccountStudentAccountModify.addActionListener(aasaEvt);
        
        //Mouse 이벤트 생성
        jtAdminAccountStudentAccountTable.addMouseListener(aasaEvt);
        
    } //AdminAccountStudentAccountView

    //getter method
	public DefaultTableModel getDftmStudentTableModel() {
		return dftmStudentTableModel;
	}

	public JTable getJtAdminAccountStudentAccountTable() {
		return jtAdminAccountStudentAccountTable;
	}
	
	public JButton getJbtnAdminAccountStudentAccountCreate() {
		return jbtnAdminAccountStudentAccountCreate;
	} //getJbtnAdminAccountStudentAccountCreate

	public JButton getJbtnAdminAccountStudentAccountModify() {
		return jbtnAdminAccountStudentAccountModify;
	} //getJbtnAdminAccountStudentAccountModify

} //class