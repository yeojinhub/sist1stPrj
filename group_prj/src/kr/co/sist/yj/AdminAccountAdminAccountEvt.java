package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdminAccountAdminAccountEvt implements ActionListener{
	
	private AdminAccountAdminAccountView aaaav;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
    private JButton jbtnAdminAccountAdminAccountModify;
    private JButton jbtnAdminAccountAdmintAccountDelete;
	
	public AdminAccountAdminAccountEvt(AdminAccountAdminAccountView aaaav) {
		this.aaaav=aaaav;
		this.jbtnAdminAccountAdminAccountCreate=aaaav.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountModify=aaaav.getJbtnAdminAccountAdminAccountModify();
		this.jbtnAdminAccountAdmintAccountDelete=aaaav.getJbtnAdminAccountAdmintAccountDelete();
	} //AdminAccountAdminAccountEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountCreate ) {
			System.out.println("생성 버튼 실행");
			JDialog jdAdminAccountCreateDialog = new JDialog((JFrame) null, "관리자 계정 생성", true);
			jdAdminAccountCreateDialog.getContentPane().add(new AdminAccountAdminAccountCreateView());
			jdAdminAccountCreateDialog.pack();
			jdAdminAccountCreateDialog.setLocationRelativeTo(aaaav);
			jdAdminAccountCreateDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminAccountAdminAccountModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdAdminAccountModifyDialog = new JDialog((JFrame) null, "관리자 계정 수정", true);
			jdAdminAccountModifyDialog.getContentPane().add(new AdminAccountAdminAccountModifyView());
			jdAdminAccountModifyDialog.pack();
			jdAdminAccountModifyDialog.setLocationRelativeTo(aaaav);
			jdAdminAccountModifyDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminAccountAdmintAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			JOptionPane.showMessageDialog(aaaav, "테이블에 있는 관리자 계정을 선택한 후 삭제하세요.", "안내 메세지", JOptionPane.DEFAULT_OPTION);
		} //end if
	} //actionPerformed
	

} //class
