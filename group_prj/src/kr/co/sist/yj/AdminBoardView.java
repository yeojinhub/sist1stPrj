package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
public class AdminBoardView extends JFrame {

	private DefaultTableModel dftmAdminBoardTableModel;
	private JTable jtAdminBoardTable;
	private AdminMainView amv;
	
	public AdminBoardView(AdminMainView amv) {
		this.amv = amv;
		
		//디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Font titleFont = new Font("맑은 고딕", Font.BOLD, 28);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		
		//Dimension 사이즈 설정
		Dimension panelSize = new Dimension(700, 45);
		Dimension scrollSize = new Dimension(703, 500);
		
		//Component 생성
		//제목 Panel 생성
		JPanel jpAdminBoardViewTitlePanel = new JPanel();
		jpAdminBoardViewTitlePanel.setBackground(white);
		jpAdminBoardViewTitlePanel.setPreferredSize(panelSize);
		jpAdminBoardViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminBoardViewTitlePanel.setLayout(new BorderLayout(0, 0));

		//제목 타이틀 생성
		JLabel jlblAdminBoardTitle = new JLabel("1:1 문의 게시판");
		jlblAdminBoardTitle.setBackground(white);
		jlblAdminBoardTitle.setFont(titleFont);
		jlblAdminBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminBoardViewTitlePanel.add(jlblAdminBoardTitle, BorderLayout.CENTER);
        
		jtAdminBoardTable = new JTable();
		
        //Table 디자인, 수정 불가능 설정
        jtAdminBoardTable.setDefaultEditor(Object.class, null);
        jtAdminBoardTable.setRowHeight(25);
        jtAdminBoardTable.setFont(tableFont);

        //Table Component 배치
        JScrollPane spAdminBoardViewScroll = new JScrollPane(jtAdminBoardTable);
        spAdminBoardViewScroll.getViewport().setBackground(white);
        spAdminBoardViewScroll.setPreferredSize(scrollSize);
        JPanel jpAdminBoardViewTablePanel = new JPanel(new BorderLayout());
        jpAdminBoardViewTablePanel.add(spAdminBoardViewScroll, BorderLayout.CENTER);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminBoardViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminBoardViewTablePanel, BorderLayout.CENTER);
        
        //Mouse 이벤트 생성
        AdminBoardEvt abe = new AdminBoardEvt(jtAdminBoardTable, this);
        abe.loadBoardList();
	} //AdminBoardView

	//getter method
	public DefaultTableModel getDftmAdminBoardTableModel() {
		return dftmAdminBoardTableModel;
	} //getDftmAdminBoardTableModel

	public JTable getJtAdminBoardTable() {
		return jtAdminBoardTable;
	} //getJtAdminBoardTable

	public AdminMainView getAmv() {
		return amv;
	}
	
	
} //class
