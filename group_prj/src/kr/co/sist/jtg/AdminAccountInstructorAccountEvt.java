package kr.co.sist.jtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminAccountInstructorAccountEvt implements ActionListener {

	private AdminAccountInstructorAccountView aaiav;
	
	private JButton jbtnAdminAccountInstructorAccountCreate;
    private JButton jbtnAdminAccountInstructorAccountModify;
    private JButton jbtnAdminAccountInstructorAccountDelete;
	
	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView aaiav) {
		this.aaiav=aaiav;
		this.jbtnAdminAccountInstructorAccountCreate=aaiav.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountModify=aaiav.getJbtnAdminAccountInstructorAccountModify();
		this.jbtnAdminAccountInstructorAccountDelete=aaiav.getJbtnAdminAccountInstructorAccountDelete();
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
		if( source == jbtnAdminAccountInstructorAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			JOptionPane.showMessageDialog(aaiav, "테이블에 있는 강사 계정을 선택한 후 삭제하세요.", "안내 메세지", JOptionPane.DEFAULT_OPTION);
		} //end if
	} //actionPerformed
	
}  //class
