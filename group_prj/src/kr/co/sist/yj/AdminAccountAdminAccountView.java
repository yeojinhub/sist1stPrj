//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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
public class AdminAccountAdminAccountView extends JPanel {

	private DefaultTableModel admTableModel;
	private JTable admInfoTable;
	
	private JButton admCreateViewButton;
	private JButton admModifyViewButton;

	public AdminAccountAdminAccountView() {

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
		String admTableTitle[] = { "사번", "이름", "생년월일", "전화번호", "주소" };

		// Table Component 생성
		admTableModel = new DefaultTableModel(admTableTitle, 0);
		admInfoTable = new JTable(admTableModel);

		// Table 열 정렬 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Table 열 너비 설정
		TableColumnModel columnModel = admInfoTable.getColumnModel();
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
		admInfoTable.setDefaultEditor(Object.class, null);
		admInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		admInfoTable.setRowHeight(25);
		admInfoTable.setFont(tableFont);

		// Table Component 배치
		JScrollPane admViewScroll = new JScrollPane(admInfoTable);
		admViewScroll.getViewport().setBackground(white);
		admViewScroll.setPreferredSize(scrollSize);
		JPanel admViewTablePanel = new JPanel(new BorderLayout());
		admViewTablePanel.add(admViewScroll, BorderLayout.CENTER);

		// Component 생성
		// Button 생성
		JPanel admViewButtonPanel = new JPanel();
		admViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		admViewButtonPanel.setBackground(white);
		admViewButtonPanel.setBorder(new TitledBorder(""));
		admViewButtonPanel.setPreferredSize(panelSize);
		admCreateViewButton = new JButton("생성");
		admCreateViewButton.setBackground(lightblue);
		admCreateViewButton.setSize(buttonSize);
		admCreateViewButton.setFont(buttonFont);
		admModifyViewButton = new JButton("수정");
		admModifyViewButton.setBackground(lightblue);
		admModifyViewButton.setSize(buttonSize);
		admModifyViewButton.setFont(buttonFont);

		// Component 배치
		admViewButtonPanel.add(admCreateViewButton);
		admViewButtonPanel.add(admModifyViewButton);

		// Panel 배치
		setLayout(new BorderLayout());
		add(admViewTablePanel, BorderLayout.CENTER);
		add(admViewButtonPanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminAccountAdminAccountEvt admEvt = new AdminAccountAdminAccountEvt(this);
		admCreateViewButton.addActionListener(admEvt);
		admModifyViewButton.addActionListener(admEvt);

		// Table 이벤트 생성
		admEvt.loadAdminInfoTableList();
		
		// Mouse 이벤트 생성
		admInfoTable.addMouseListener(admEvt);
		
	} // AdminAccountAdminAccountView

	// getter method
	public JTable getAdmInfoTable() {
		return admInfoTable;
	}

	public DefaultTableModel getAdmTableModel() {
		return admTableModel;
	}

	public JButton getAdmCreateViewButton() {
		return admCreateViewButton;
	}

	public JButton getAdmModifyViewButton() {
		return admModifyViewButton;
	}

} // class
