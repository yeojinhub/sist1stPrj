package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminCourseModifyEvt implements ActionListener {

	private AdminCourseModifyView acmv;
	
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseClose;
	
	public AdminCourseModifyEvt(AdminCourseModifyView acmv) {
		this.acmv=acmv;
		this.jbtnAdminCourseModify=acmv.getJbtnAdminCourseModify();
		this.jbtnAdminCourseClose=acmv.getJbtnAdminCourseClose();
	} //AdminCourseModifyEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminCourseModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminCourseClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(acmv);
            if(adminCourseModifyWindow instanceof JDialog) {
                ((JDialog) adminCourseModifyWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed

} //class
