//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminAccountInstructorAccountView extends JPanel{

	private JButton jbtnAdminAccountInstructorAccountCreate;
    private JButton jbtnAdminAccountInstructorAccountModify;
    private JButton jbtnAdminAccountInstructorAccountDelete;
    
	public AdminAccountInstructorAccountView() {
        
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
		
		//Table 수정 불가능
		jtAdminAccountInstructorAccountTable.setDefaultEditor(Object.class, null);
		
		//Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountInstructorAccountTable.getColumnModel();
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
        jtAdminAccountInstructorAccountTable.setIntercellSpacing(new Dimension(0,0));
        jtAdminAccountInstructorAccountTable.setRowHeight(25);
        
        //Table Component 배치
		JScrollPane spAdminAccountInstructorAccountViewScroll = new JScrollPane(jtAdminAccountInstructorAccountTable);
		spAdminAccountInstructorAccountViewScroll.setPreferredSize(new Dimension(770,500));
		JPanel jpAdminAccountInstructorAccountViewTablePanel = new JPanel();
		jpAdminAccountInstructorAccountViewTablePanel.add(spAdminAccountInstructorAccountViewScroll, BorderLayout.CENTER);
		jpAdminAccountInstructorAccountViewTablePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		//Component 생성
		//Button 생성
        JPanel jpAdminAccountInstructorAccountViewButtonPanel = new JPanel();
        jpAdminAccountInstructorAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminAccountInstructorAccountCreate = new JButton("생성");
        jbtnAdminAccountInstructorAccountModify = new JButton("수정");
        jbtnAdminAccountInstructorAccountDelete = new JButton("삭제");
        
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