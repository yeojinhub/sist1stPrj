//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminAccountAdminAccountView extends JPanel {

	private JButton jbtnAdminAccountAdminAccountCreate;
    private JButton jbtnAdminAccountAdminAccountModify;
    private JButton jbtnAdminAccountAdmintAccountDelete;
	
    public AdminAccountAdminAccountView() {
		
		//Table 타이틀 생성
		String strAdminAccountAdminAccountTitle[] = {
				"사번", "이름", "생년월일", "전화번호", "주소"
		};
		
		//Table 가데이터 생성
		String strAdminAccountAdminAccountData[][] = {
				{ "20250001", "정난영", "1996-01-01", "010-1234-5678", "서울특별시 강동구 천호동" },
		};
		
		//Table Component 생성
		DefaultTableModel dftmAdminTableModel= new DefaultTableModel(strAdminAccountAdminAccountData, strAdminAccountAdminAccountTitle);
		JTable jtAdminAccountAdminAccountTable = new JTable(dftmAdminTableModel);
		
		//Table 수정 불가능
		jtAdminAccountAdminAccountTable.setDefaultEditor(Object.class, null);
		
		//Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountAdminAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 3:
        		columnModel.getColumn(i).setPreferredWidth(100); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(430); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminAccountAdminAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminAccountAdminAccountTable.setRowHeight(25);
		
		//Table Component 배치
		JScrollPane spAdminAccountAdminAccountViewScroll = new JScrollPane(jtAdminAccountAdminAccountTable);
		spAdminAccountAdminAccountViewScroll.setPreferredSize(new Dimension(770,500));
		JPanel jpAdminAccountAdminAccountViewTablePanel = new JPanel();
		jpAdminAccountAdminAccountViewTablePanel.add(spAdminAccountAdminAccountViewScroll, BorderLayout.CENTER);
		
		//Component 생성
		//Button 생성
        JPanel jpAdminAccountAdminAccountViewButtonPanel = new JPanel();
        jpAdminAccountAdminAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminAccountAdminAccountCreate = new JButton("생성");
        jbtnAdminAccountAdminAccountModify = new JButton("수정");
        jbtnAdminAccountAdmintAccountDelete = new JButton("삭제");
        
        //Component 배치
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountCreate);
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountModify);
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdmintAccountDelete);
		
		//Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminAccountAdminAccountViewTablePanel, BorderLayout.CENTER);
		add(jpAdminAccountAdminAccountViewButtonPanel, BorderLayout.SOUTH);
		
		//Button 이벤트 생성
		AdminAccountAdminAccountEvt aaaae = new AdminAccountAdminAccountEvt(this);
		jbtnAdminAccountAdminAccountCreate.addActionListener(aaaae);
		jbtnAdminAccountAdminAccountModify.addActionListener(aaaae);
		jbtnAdminAccountAdmintAccountDelete.addActionListener(aaaae);
	} //AdminAccountAdminAccountView

    //getter method
	public JButton getJbtnAdminAccountAdminAccountCreate() {
		return jbtnAdminAccountAdminAccountCreate;
	} //getJbtnAdminAccountAdminAccountCreate

	public JButton getJbtnAdminAccountAdminAccountModify() {
		return jbtnAdminAccountAdminAccountModify;
	} //getJbtnAdminAccountAdminAccountModify

	public JButton getJbtnAdminAccountAdmintAccountDelete() {
		return jbtnAdminAccountAdmintAccountDelete;
	} //getJbtnAdminAccountAdmintAccountDelete
	
} //class
