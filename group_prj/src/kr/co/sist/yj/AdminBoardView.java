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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminBoardView extends JFrame {

	private DefaultTableModel dftmAdminBoardTableModel;
	private JTable jtAdminBoardTable;
	
	public AdminBoardView() {
		
		//Color 색깔 설정
		Color white = new Color(255, 255, 255);
		
		//Component 생성
		//제목 Title 생성
		JPanel jpAdminBoardViewTitlePanel = new JPanel();
		jpAdminBoardViewTitlePanel.setBackground(white);
		jpAdminBoardViewTitlePanel.setBounds(12, 10, 535, 45);
		jpAdminBoardViewTitlePanel.setBorder(new TitledBorder(""));
		jpAdminBoardViewTitlePanel.setLayout(new BorderLayout(0, 0));
		add(jpAdminBoardViewTitlePanel);

		JLabel jlblAdminBoardTitle = new JLabel("1:1 문의 게시판");
		jlblAdminBoardTitle.setBackground(white);
		jlblAdminBoardTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblAdminBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jpAdminBoardViewTitlePanel.add(jlblAdminBoardTitle, BorderLayout.CENTER);
		
		//Table 타이틀 생성
        String[] strAdminBoardTableTitle = {
            "번호", "제목", "작성자", "작성일", "상태"
        };

        //Table 가데이터 생성
        String[][] strAdminBoardTableData = {
            { "1", "시험 관련 문의", "강태일", "2025-04-01", "진행중" },
            { "2", "수당 관련 문의", "강태일", "2025-02-25", "답변 완료" },
        };

        //Table Component 생성
        dftmAdminBoardTableModel = new DefaultTableModel(strAdminBoardTableData, strAdminBoardTableTitle);
        jtAdminBoardTable = new JTable(dftmAdminBoardTableModel);
        
        //Table 수정 불가능
        jtAdminBoardTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminBoardTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(370); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminBoardTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminBoardTable.setRowHeight(25);

        //Table Component 배치
        JScrollPane spAdminBoardViewScroll = new JScrollPane(jtAdminBoardTable);
        spAdminBoardViewScroll.setPreferredSize(new Dimension(770,500));
        JPanel jpAdminBoardViewTablePanel = new JPanel(new BorderLayout());
        jpAdminBoardViewTablePanel.add(spAdminBoardViewScroll, BorderLayout.CENTER);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminBoardViewTitlePanel, BorderLayout.NORTH);
        add(jpAdminBoardViewTablePanel, BorderLayout.CENTER);
        
        //Mouse 이벤트 생성
        AdminBoardEvt abe = new AdminBoardEvt(this);
        jtAdminBoardTable.addMouseListener(abe);
        
	} //AdminBoardView

	//getter method
	public DefaultTableModel getDftmAdminBoardTableModel() {
		return dftmAdminBoardTableModel;
	} //getDftmAdminBoardTableModel

	public JTable getJtAdminBoardTable() {
		return jtAdminBoardTable;
	} //getJtAdminBoardTable
	
} //class
