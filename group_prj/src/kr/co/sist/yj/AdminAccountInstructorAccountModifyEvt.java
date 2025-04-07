package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminAccountInstructorAccountModifyEvt implements ActionListener {

	private AdminAccountInstructorAccountModifyView aaiamView;
	
	private JButton jbtnAdminAccountInstructorAccountModify;
	private JButton jbtnAdminAccountInstructorAccountDelete;
	private JButton jbtnAdminAccountInstructorAccountClose;
	
	public AdminAccountInstructorAccountModifyEvt(AdminAccountInstructorAccountModifyView aaiamView){
		this.aaiamView=aaiamView;
		this.jbtnAdminAccountInstructorAccountModify=aaiamView.getJbtnAdminAccountInstructorAccountModify();
		this.jbtnAdminAccountInstructorAccountDelete=aaiamView.getJbtnAdminAccountInstructorAccountDelete();
		this.jbtnAdminAccountInstructorAccountClose=aaiamView.getJbtnAdminAccountInstructorAccountClose();
	} //AdminAccountInstructorAccountModifyEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountInstructorAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		
		if( source == jbtnAdminAccountInstructorAccountDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
		
		if( source == jbtnAdminAccountInstructorAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountInstructorAccountModifyWindow = SwingUtilities.getWindowAncestor(aaiamView);
            if(adminAccountInstructorAccountModifyWindow instanceof JDialog) {
                ((JDialog) adminAccountInstructorAccountModifyWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed

} //class
