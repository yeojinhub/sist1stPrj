package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminAccountInstructorAccountEvt extends MouseAdapter implements ActionListener {

	private AdminAccountInstructorAccountView instView;

	private JButton jbtnAdminAccountInstructorAccountCreate;
	private JButton jbtnAdminAccountInstructorAccountModify;

	private int selectedRow;
	private String strInstNum;
	
	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView instView) {
		this.instView = instView;
		this.jbtnAdminAccountInstructorAccountCreate = instView.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountModify = instView.getJbtnAdminAccountInstructorAccountModify();
	} // AdminAccountInstructorAccountEvt
	
	public void loadInstructorInfoTableList() {
		AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
		List<AdminAccountInstructorAccountInfoVO> instructorList = instService.searchAllInstructorAccountMember();
		
		DefaultTableModel model = instView.getDftmInstructorTableModel();
		model.setRowCount(0);
		
		//강사 VO 객체들을 테이블에 추가
		for(AdminAccountInstructorAccountInfoVO instVO : instructorList) {
			model.addRow(new Object[] {
					instVO.getInstNum(),
					instVO.getInstName(),
					instVO.getInstBirth(),
					instVO.getInstTel(),
					instVO.getInstAdd()
			});
		} //end for
		
	} //loadInstructorInfoTableList

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminAccountInstructorAccountCreate) {
			System.out.println("생성 버튼 실행");
			JDialog instCreateDialog = new JDialog((JFrame) null, "강사 계정 생성", true);
			instCreateDialog.getContentPane().add(new AdminAccountInstructorAccountCreateView());
			instCreateDialog.pack();
			instCreateDialog.setLocationRelativeTo(instView);
			instCreateDialog.setVisible(true);
			instCreateDialog.setResizable(false);

			loadInstructorInfoTableList();
		} // end if
		
		if (source == jbtnAdminAccountInstructorAccountModify) {
			System.out.println("수정 버튼 실행");
		    if(selectedRow == -1) {
		        JOptionPane.showMessageDialog(instView, "수정할 강사 계정을 선택해주세요.");
		        //early return
		        return;
		    } //end if
			
			JDialog instModifyDialog = new JDialog((JFrame) null, "강사 계정 수정", true);
			 // 수정 다이얼로그에 추가할 ModifyView 인스턴스 생성
		    AdminAccountInstructorAccountModifyView modifyView = new AdminAccountInstructorAccountModifyView(strInstNum);
		    
		    instModifyDialog.getContentPane().add(modifyView);
		    instModifyDialog.pack();
		    instModifyDialog.setLocationRelativeTo(instView);
		    instModifyDialog.setVisible(true);
		    instModifyDialog.setResizable(false);
			
			loadInstructorInfoTableList();
		} // end if

	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		// JTable에서 선택된 행의 인덱스 및 사번 추출
	    selectedRow = instView.getJtAdminAccountInstructorAccountTable().getSelectedRow();
	    String strInstNum = instView.getJtAdminAccountInstructorAccountTable()
	            .getValueAt(selectedRow, 0).toString();
	    System.out.println("선택된 강사 사번: " + strInstNum);
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public String getStrInstNum() {
		return strInstNum;
	}

} // class
