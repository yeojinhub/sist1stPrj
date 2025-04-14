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

	private JButton instCreateViewButton;
	private JButton instModifyViewButton;

	private int selectedRow = -1;
	private String strInstNum;
	
	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView instView) {
		this.instView = instView;
		this.instCreateViewButton = instView.getInstCreateViewButton();
		this.instModifyViewButton = instView.getInstModifyViewButton();
	} // AdminAccountInstructorAccountEvt
	
	public void showCreateDialog() {
		
		JDialog instCreateDialog = new JDialog((JFrame) null, "강사 계정 생성", true);
		instCreateDialog.getContentPane().add(new AdminAccountInstructorAccountCreateView());
		instCreateDialog.pack();
		instCreateDialog.setLocationRelativeTo(instView);
		instCreateDialog.setVisible(true);
		instCreateDialog.setResizable(false);
		
	} //showCreateDialog
	
	public void showModifyDialog() {
		
		JDialog instModifyDialog = new JDialog((JFrame) null, "강사 계정 수정", true);
    	// 수정 다이얼로그에 추가할 ModifyView 인스턴스 생성
    	AdminAccountInstructorAccountModifyView modifyView = new AdminAccountInstructorAccountModifyView(strInstNum);
    	
    	instModifyDialog.getContentPane().add(modifyView);
    	instModifyDialog.pack();
    	instModifyDialog.setLocationRelativeTo(instView);
    	instModifyDialog.setVisible(true);
    	instModifyDialog.setResizable(false);
		
	} //showModifyDialog
	
	public void loadInstructorInfoTableList() {
		AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
		List<AdminAccountInstructorAccountInfoVO> instructorList = instService.searchAllInstructorAccountMember();
		
		DefaultTableModel instInfoTableModel = instView.getInstInfoTableModel();
		instInfoTableModel.setRowCount(0);
		
		//강사 VO 객체들을 테이블에 추가
		for(AdminAccountInstructorAccountInfoVO instVO : instructorList) {
			instInfoTableModel.addRow(new Object[] {
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

		if (source == instCreateViewButton) {
			System.out.println("생성 버튼 실행");
			showCreateDialog();
			loadInstructorInfoTableList();
		} // end if
		
		if (source == instModifyViewButton) {
			System.out.println("수정 버튼 실행");
			
			//null일때 예외처리
		    if(selectedRow == -1) {
		    	System.out.println("강사 계정에서 수정이 선택된 행의 수 : "+selectedRow);
		        JOptionPane.showMessageDialog(instView, "수정할 강사 계정을 선택해주세요.");
		        //early return
		        return;
		    } else {
		    	showModifyDialog();
		    	loadInstructorInfoTableList();
		    } //end if else
		} // end if

	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent me) {
		// JTable에서 선택된 행의 인덱스 및 사번 추출
	    selectedRow = instView.getInstInfoTable().getSelectedRow();
	    strInstNum = instView.getInstInfoTable()
	            .getValueAt(selectedRow, 0).toString();
	    System.out.println("선택된 강사 사번: " + strInstNum);
	    System.out.println("클릭한 행의 수 : " + selectedRow);
	} // mouseClicked

} // class
