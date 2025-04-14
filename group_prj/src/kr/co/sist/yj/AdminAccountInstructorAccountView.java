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
public class AdminAccountInstructorAccountView extends JPanel {

	private DefaultTableModel instInfoTableModel;
	private JTable instInfoTable;
	
	private JButton instCreateViewButton;
	private JButton instModifyViewButton;

	public AdminAccountInstructorAccountView() {

		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font tableFont = new Font("맑은 고딕", Font.PLAIN, 14);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension panelSize = new Dimension(700, 45);
		Dimension scrollSize = new Dimension(703, 365);
		Dimension buttonSize = new Dimension(120, 40);

		// Table 타이틀 생성
		String instTableTitle[] = { "사번", "이름", "생년월일", "전화번호", "주소" };

		// Table Component 생성
		instInfoTableModel = new DefaultTableModel(instTableTitle, 0);
		instInfoTable = new JTable(instInfoTableModel);

		// Table 열 정렬 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Table 열 너비 설정
		TableColumnModel columnModel = instInfoTable.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			switch (i) {
			case 3:
				columnModel.getColumn(i).setPreferredWidth(110);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			case 4:
				columnModel.getColumn(i).setPreferredWidth(350);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			default:
				columnModel.getColumn(i).setPreferredWidth(80);
				columnModel.getColumn(i).setCellRenderer(centerRenderer);
				break;
			} // end switch
		} // end for

		// Table 디자인, 수정 불가능 설정
		instInfoTable.setDefaultEditor(Object.class, null);
		instInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		instInfoTable.setRowHeight(25);
		instInfoTable.setFont(tableFont);

		// Table Component 배치
		JScrollPane instViewScroll = new JScrollPane(instInfoTable);
		instViewScroll.getViewport().setBackground(white);
		instViewScroll.setPreferredSize(scrollSize);
		JPanel instViewTablePanel = new JPanel(new BorderLayout());
		instViewTablePanel.add(instViewScroll, BorderLayout.CENTER);
		instViewTablePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// Component 생성
		// Button 생성
		JPanel instViewButtonPanel = new JPanel();
		instViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		instViewButtonPanel.setBackground(white);
		instViewButtonPanel.setBorder(new TitledBorder(""));
		instViewButtonPanel.setPreferredSize(panelSize);
		instCreateViewButton = new JButton("생성");
		instCreateViewButton.setBackground(lightblue);
		instCreateViewButton.setSize(buttonSize);
		instCreateViewButton.setFont(buttonFont);
		instModifyViewButton = new JButton("수정");
		instModifyViewButton.setBackground(lightblue);
		instModifyViewButton.setSize(buttonSize);
		instModifyViewButton.setFont(buttonFont);

		// Component 배치
		instViewButtonPanel.add(instCreateViewButton);
		instViewButtonPanel.add(instModifyViewButton);

		// Panel 배치
		setLayout(new BorderLayout());
		add(instViewTablePanel, BorderLayout.CENTER);
		add(instViewButtonPanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminAccountInstructorAccountEvt instEvt = new AdminAccountInstructorAccountEvt(this);
		instCreateViewButton.addActionListener(instEvt);
		instModifyViewButton.addActionListener(instEvt);

		// Table 이벤트 생성
		instEvt.loadInstructorInfoTableList();
		
		// Mouse 이벤트 생성
		instInfoTable.addMouseListener(instEvt);
		
	} // AdminAccountInstructorAccountView

	// getter method
	public DefaultTableModel getInstInfoTableModel() {
		return instInfoTableModel;
	}
	
	public JTable getInstInfoTable() {
		return instInfoTable;
	}

	public JButton getInstCreateViewButton() {
		return instCreateViewButton;
	}

	public JButton getInstModifyViewButton() {
		return instModifyViewButton;
	}

} // class