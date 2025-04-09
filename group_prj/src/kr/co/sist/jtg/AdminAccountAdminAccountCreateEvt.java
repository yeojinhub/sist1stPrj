package kr.co.sist.jtg;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminAccountAdminAccountCreateEvt implements ActionListener {

	private AdminAccountAdminAccountCreateView aaaacv;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
	private JButton jbtnAdminAccountAdminAccountClose;
	
	public AdminAccountAdminAccountCreateEvt(AdminAccountAdminAccountCreateView aaaacv) {
		this.aaaacv=aaaacv;
		this.jbtnAdminAccountAdminAccountCreate=aaaacv.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountClose=aaaacv.getJbtnAdminAccountAdminAccountClose();
	} //AdminAccountAdminAccountCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountCreate ) {
			System.out.println("생성 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountAdminAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountAdminAccountCreateWindow = SwingUtilities.getWindowAncestor(aaaacv);
            if(adminAccountAdminAccountCreateWindow instanceof JDialog) {
                ((JDialog) adminAccountAdminAccountCreateWindow).dispose();
            } //end if
		} //end if
	} //actionPerformed
	
} //class
