//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//import kr.co.sist.evt.AdminAccountStudentAccountEvt;


@SuppressWarnings("serial")
public class AdminAccountStudentAccountView extends JPanel {
	
	private JButton jbtnAdminAccountStudentAccountMenu;
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
	
    public AdminAccountStudentAccountView() {

        //Component 생성 
    	//메뉴 Button 생성
    	JPanel jpAdminAccountStudentAccountViewMenuPanel = new JPanel();
    	jpAdminAccountStudentAccountViewMenuPanel.setBackground(new Color(255, 255, 255));
    	jpAdminAccountStudentAccountViewMenuPanel.setLayout(null);
    	jbtnAdminAccountStudentAccountMenu = new JButton("메뉴 열기");
    	jpAdminAccountStudentAccountViewMenuPanel.add(jbtnAdminAccountStudentAccountMenu);
    	
        
        //Table 타이틀 생성
        String[] strAdminAccountStudentAccountTableTitle = {
            "학번", "이름", "전화번호", "기수", "교육과정", "교육기간", "진행상태"
        };

        //Table 가데이터 생성
        String[][] strAdminAccountStudentAccountTableData = {
            { "20250001", "강태일", "010-1234-5678", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250002", "김민경", "010-1111-1111", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250003", "이여진", "010-8241-8701", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250004", "이재준", "010-0000-0000", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "중도하차" },
        };

        //Table Component 생성
        DefaultTableModel dftmStudentTableModel = new DefaultTableModel(strAdminAccountStudentAccountTableData, strAdminAccountStudentAccountTableTitle);
        JTable jtAdminAccountStudentAccountTable = new JTable(dftmStudentTableModel);
        
        //Table 수정 불가능
        jtAdminAccountStudentAccountTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountStudentAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 2:
        		columnModel.getColumn(i).setPreferredWidth(100); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(200); break;
        	case 5:
        		columnModel.getColumn(i).setPreferredWidth(150); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminAccountStudentAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //Table Component 배치
        JScrollPane spAdminAccountStudentAccountViewScroll = new JScrollPane(jtAdminAccountStudentAccountTable);
        spAdminAccountStudentAccountViewScroll.setPreferredSize(new Dimension(773,500));
        JPanel jpAdminAccountStudentAccountViewTablePanel = new JPanel(new BorderLayout());
        jpAdminAccountStudentAccountViewTablePanel.add(spAdminAccountStudentAccountViewScroll, BorderLayout.CENTER);
        
        //Button 생성
        JPanel jpAdminAccountStudentAccountViewButtonPanel = new JPanel();
        jpAdminAccountStudentAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminAccountStudentAccountCreate = new JButton("생성");
        jbtnAdminAccountStudentAccountModify = new JButton("수정");
        jbtnAdminAccountStudentAccountDelete = new JButton("삭제");
        
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountCreate);
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountModify);
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountDelete);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminAccountStudentAccountViewTablePanel, BorderLayout.CENTER);
        add(jpAdminAccountStudentAccountViewButtonPanel, BorderLayout.SOUTH);
        
        //Button 이벤트 생성
        AdminAccountStudentAccountEvt aasae = new AdminAccountStudentAccountEvt(this); 
        jbtnAdminAccountStudentAccountCreate.addActionListener(aasae);
        jbtnAdminAccountStudentAccountModify.addActionListener(aasae);
        jbtnAdminAccountStudentAccountDelete.addActionListener(aasae);
        
    } //AdminAccountStudentAccountView

    //getter method
    
    public JButton getJbtnAdminAccountStudentAccountMenu() {
		return jbtnAdminAccountStudentAccountMenu;
	} //getJbtnAdminAccountStudentAccountMenu
    
	public JButton getJbtnAdminAccountStudentAccountCreate() {
		return jbtnAdminAccountStudentAccountCreate;
	} //getJbtnAdminAccountStudentAccountCreate

	public JButton getJbtnAdminAccountStudentAccountModify() {
		return jbtnAdminAccountStudentAccountModify;
	} //getJbtnAdminAccountStudentAccountModify

	public JButton getJbtnAdminAccountStudentAccountDelete() {
		return jbtnAdminAccountStudentAccountDelete;
	} //getJbtnAdminAccountStudentAccountDelete

} //class