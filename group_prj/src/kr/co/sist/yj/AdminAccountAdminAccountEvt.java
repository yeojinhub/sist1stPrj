package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class AdminAccountAdminAccountEvt implements ActionListener{
	
	private AdminAccountAdminAccountView aaaaView;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
    private JButton jbtnAdminAccountAdminAccountModify;
	
	public AdminAccountAdminAccountEvt(AdminAccountAdminAccountView aaaaView) {
		this.aaaaView=aaaaView;
		this.jbtnAdminAccountAdminAccountCreate=aaaaView.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountModify=aaaaView.getJbtnAdminAccountAdminAccountModify();
	} //AdminAccountAdminAccountEvt
	
	public void loadAdminInfoTableList() {
		AdminAccountAdminAccountInfoService aaaaiService = new AdminAccountAdminAccountInfoService();
		List<AdminAccountAdminAccountInfoVO> adminList = aaaaiService.searchAllAdminAccountAdminAccountMember();
		
		DefaultTableModel model = aaaaView.getDftmAdminTableModel();
		model.setRowCount(0);
		
		// 관리자 VO 객체들을 테이블에 추가
		for( AdminAccountAdminAccountInfoVO aaaaiVO : adminList ) {
			model.addRow(new Object[] {
					aaaaiVO.getAdmNum(),
					aaaaiVO.getAdmName(),
					aaaaiVO.getAdmBirth(),
					aaaaiVO.getAdmTel(),
					aaaaiVO.getAdmAdd()
			});
		} //end for
		
	} //loadAdminInfoTableList
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountCreate ) {
			System.out.println("생성 버튼 실행");
			JDialog jdAdminAccountCreateDialog = new JDialog((JFrame) null, "관리자 계정 생성", true);
			jdAdminAccountCreateDialog.getContentPane().add(new AdminAccountAdminAccountCreateView());
			jdAdminAccountCreateDialog.pack();
			jdAdminAccountCreateDialog.setLocationRelativeTo(aaaaView);
			jdAdminAccountCreateDialog.setVisible(true);
			
			loadAdminInfoTableList();
		} //end if
		
		if( source == jbtnAdminAccountAdminAccountModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdAdminAccountModifyDialog = new JDialog((JFrame) null, "관리자 계정 수정", true);
			jdAdminAccountModifyDialog.getContentPane().add(new AdminAccountAdminAccountModifyView());
			jdAdminAccountModifyDialog.pack();
			jdAdminAccountModifyDialog.setLocationRelativeTo(aaaaView);
			jdAdminAccountModifyDialog.setVisible(true);
			
			loadAdminInfoTableList();
		} //end if
		
	} //actionPerformed
	

} //class
