package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class AdminAccountInstructorAccountEvt implements ActionListener {

	private AdminAccountInstructorAccountView aaiav;
	
	private JButton jbtnAdminAccountInstructorAccountCreate;
    private JButton jbtnAdminAccountInstructorAccountModify;
	
	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView aaiav) {
		this.aaiav=aaiav;
		this.jbtnAdminAccountInstructorAccountCreate=aaiav.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountModify=aaiav.getJbtnAdminAccountInstructorAccountModify();
	} //AdminAccountInstructorAccountEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountInstructorAccountCreate ) {
			System.out.println("생성 버튼 실행");
			JDialog jdInstructorAccountCreateDialog = new JDialog((JFrame) null, "강사 계정 생성", true);
			jdInstructorAccountCreateDialog.getContentPane().add(new AdminAccountInstructorAccountCreateView());
			jdInstructorAccountCreateDialog.pack();
			jdInstructorAccountCreateDialog.setLocationRelativeTo(aaiav);
			jdInstructorAccountCreateDialog.setVisible(true);
			
		} //end if
		if( source == jbtnAdminAccountInstructorAccountModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdInstructorAccountModifyDialog = new JDialog((JFrame) null, "강사 계정 수정", true);
			jdInstructorAccountModifyDialog.getContentPane().add(new AdminAccountInstructorAccountModifyView());
			jdInstructorAccountModifyDialog.pack();
			jdInstructorAccountModifyDialog.setLocationRelativeTo(aaiav);
			jdInstructorAccountModifyDialog.setVisible(true);
		} //end if
		
	} //actionPerformed
	
}  //class
