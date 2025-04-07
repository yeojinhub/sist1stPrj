package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminAccountAdminAccountModifyEvt implements ActionListener {
	
	private AdminAccountAdminAccountModifyView aaaamView;
	
	private JButton jbtnAdminAccountAdminAccountModify;
    private JButton jbtnAdminAccountAdmintAccountDelete;
	private JButton jbtnAdminAccountAdmintAccountClose;

	public AdminAccountAdminAccountModifyEvt(AdminAccountAdminAccountModifyView aaaamView){
		this.aaaamView=aaaamView;
		this.jbtnAdminAccountAdminAccountModify=aaaamView.getJbtnAdminAccountAdminAccountModify();
		this.jbtnAdminAccountAdmintAccountDelete=aaaamView.getJbtnAdminAccountAdmintAccountDelete();
		this.jbtnAdminAccountAdmintAccountClose=aaaamView.getJbtnAdminAccountAdmintAccountClose();
	} //AdminAccountAdminAccountModifyEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		
		if( source == jbtnAdminAccountAdmintAccountDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
		
		if( source == jbtnAdminAccountAdmintAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountAdminAccountModifyWindow = SwingUtilities.getWindowAncestor(aaaamView);
            if(adminAccountAdminAccountModifyWindow instanceof JDialog) {
                ((JDialog) adminAccountAdminAccountModifyWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed

} //class
