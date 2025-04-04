package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountAdminAccountModifyEvt implements ActionListener {
	
	@SuppressWarnings("unused")
	private AdminAccountAdminAccountModifyView aaaamv;
	
	private JButton jbtnAdminAccountAdminAccountModify;
	private JButton jbtnAdminAccountAdmintAccountClose;

	public AdminAccountAdminAccountModifyEvt(AdminAccountAdminAccountModifyView aaaamv){
		this.aaaamv=aaaamv;
		this.jbtnAdminAccountAdminAccountModify=aaaamv.getJbtnAdminAccountAdminAccountModify();
		this.jbtnAdminAccountAdmintAccountClose=aaaamv.getJbtnAdminAccountAdmintAccountClose();
	} //AdminAccountAdminAccountModifyEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountAdmintAccountClose ) {
			System.out.println("닫기 버튼 실행");
		} //end if
	} //actionPerformed

} //class
