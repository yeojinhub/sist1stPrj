package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminCourseCreateEvt implements ActionListener {
	
	private AdminCourseCreateView accv;
	
	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseClose;
	
	public AdminCourseCreateEvt(AdminCourseCreateView accv) {
		this.accv=accv;
		this.jbtnAdminCourseCreate=accv.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseClose=accv.getJbtnAdminCourseClose();
	} //AdminCourseCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminCourseCreate ) {
			System.out.println("등록 버튼 실행");
		} //end if
		if( source == jbtnAdminCourseClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminCourseCreateWindow = SwingUtilities.getWindowAncestor(accv);
            if(adminCourseCreateWindow instanceof JDialog) {
                ((JDialog) adminCourseCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
} //class
