package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AdminAccountAdminAccountEvt implements ActionListener{
	
	private AdminAccountAdminAccountView aaaaView;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
    private JButton jbtnAdminAccountAdminAccountModify;
	
	public AdminAccountAdminAccountEvt(AdminAccountAdminAccountView aaaaView) {
		this.aaaaView=aaaaView;
		this.jbtnAdminAccountAdminAccountCreate=aaaaView.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountModify=aaaaView.getJbtnAdminAccountAdminAccountModify();
	} //AdminAccountAdminAccountEvt
	
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
		} //end if
		
		if( source == jbtnAdminAccountAdminAccountModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdAdminAccountModifyDialog = new JDialog((JFrame) null, "관리자 계정 수정", true);
			jdAdminAccountModifyDialog.getContentPane().add(new AdminAccountAdminAccountModifyView());
			jdAdminAccountModifyDialog.pack();
			jdAdminAccountModifyDialog.setLocationRelativeTo(aaaaView);
			jdAdminAccountModifyDialog.setVisible(true);
		} //end if
		
	} //actionPerformed
	

} //class
