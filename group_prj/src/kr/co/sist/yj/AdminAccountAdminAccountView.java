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

	private JButton jbtnAdminAccountAdminAccountCreate;
	private JButton jbtnAdminAccountAdminAccountModify;

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
		String strAdminAccountAdminAccountTitle[] = { "사번", "이름", "생년월일", "전화번호", "주소" };

		// Table 가데이터 생성
		String strAdminAccountAdminAccountData[][] = {
				{ "20250001", "정난영", "1996-01-01", "010-1234-5678", "서울특별시 강동구 천호동" }, };

		// Table Component 생성
		DefaultTableModel dftmAdminTableModel = new DefaultTableModel(strAdminAccountAdminAccountData,
				strAdminAccountAdminAccountTitle);
		JTable jtAdminAccountAdminAccountTable = new JTable(dftmAdminTableModel);

		// Table 열 정렬 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Table 열 너비 설정
		TableColumnModel columnModel = jtAdminAccountAdminAccountTable.getColumnModel();
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
		jtAdminAccountAdminAccountTable.setDefaultEditor(Object.class, null);
		jtAdminAccountAdminAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jtAdminAccountAdminAccountTable.setRowHeight(25);
		jtAdminAccountAdminAccountTable.setFont(tableFont);

		// Table Component 배치
		JScrollPane spAdminAccountAdminAccountViewScroll = new JScrollPane(jtAdminAccountAdminAccountTable);
		spAdminAccountAdminAccountViewScroll.getViewport().setBackground(white);
		spAdminAccountAdminAccountViewScroll.setPreferredSize(scrollSize);
		JPanel jpAdminAccountAdminAccountViewTablePanel = new JPanel(new BorderLayout());
		jpAdminAccountAdminAccountViewTablePanel.add(spAdminAccountAdminAccountViewScroll, BorderLayout.CENTER);

		// Component 생성
		// Button 생성
		JPanel jpAdminAccountAdminAccountViewButtonPanel = new JPanel();
		jpAdminAccountAdminAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpAdminAccountAdminAccountViewButtonPanel.setBackground(white);
		jpAdminAccountAdminAccountViewButtonPanel.setBorder(new TitledBorder(""));
		jpAdminAccountAdminAccountViewButtonPanel.setPreferredSize(panelSize);
		jbtnAdminAccountAdminAccountCreate = new JButton("생성");
		jbtnAdminAccountAdminAccountCreate.setBackground(lightblue);
		jbtnAdminAccountAdminAccountCreate.setSize(buttonSize);
		jbtnAdminAccountAdminAccountCreate.setFont(buttonFont);
		jbtnAdminAccountAdminAccountModify = new JButton("수정");
		jbtnAdminAccountAdminAccountModify.setBackground(lightblue);
		jbtnAdminAccountAdminAccountModify.setSize(buttonSize);
		jbtnAdminAccountAdminAccountModify.setFont(buttonFont);

		// Component 배치
		jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountCreate);
		jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountModify);

		// Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminAccountAdminAccountViewTablePanel, BorderLayout.CENTER);
		add(jpAdminAccountAdminAccountViewButtonPanel, BorderLayout.SOUTH);

		// Button 이벤트 생성
		AdminAccountAdminAccountEvt aaaae = new AdminAccountAdminAccountEvt(this);
		jbtnAdminAccountAdminAccountCreate.addActionListener(aaaae);
		jbtnAdminAccountAdminAccountModify.addActionListener(aaaae);
	} // AdminAccountAdminAccountView

	// getter method
	public JButton getJbtnAdminAccountAdminAccountCreate() {
		return jbtnAdminAccountAdminAccountCreate;
	} // getJbtnAdminAccountAdminAccountCreate

	public JButton getJbtnAdminAccountAdminAccountModify() {
		return jbtnAdminAccountAdminAccountModify;
	} // getJbtnAdminAccountAdminAccountModify

} // class
