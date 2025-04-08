package kr.co.sist.jtg;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminAccountStudentAccountModifyEvt implements ActionListener {

	private AdminAccountStudentAccountModifyView aasamv;
	
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountClose;
	
	public AdminAccountStudentAccountModifyEvt(AdminAccountStudentAccountModifyView aasamv) {
		this.aasamv=aasamv;
		this.jbtnAdminAccountStudentAccountModify=aasamv.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountClose=aasamv.getJbtnAdminAccountStudentAccountClose();
	} //AdminAccountStudentAccountModifyEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountStudentAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountStudentAccountModifyWindow = SwingUtilities.getWindowAncestor(aasamv);
            if(adminAccountStudentAccountModifyWindow instanceof JDialog) {
                ((JDialog) adminAccountStudentAccountModifyWindow).dispose();
            } //end if
		} //end if
	} //actionPerformed
	
} //class
