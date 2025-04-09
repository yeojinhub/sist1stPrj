//package kr.co.sist.evt;
package kr.co.sist.jtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

//import kr.co.sist.view.AdminCourseView;

public class AdminCourseEvt implements ActionListener{
	
	private AdminMainView amv;
	@SuppressWarnings("unused")
	private AdminCourseView acv;
	
	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	
	public AdminCourseEvt(AdminMainView amv, AdminCourseView acv) {
		this.amv=amv;
		this.acv=acv;
		this.jbtnAdminCourseCreate=acv.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseModify=acv.getJbtnAdminCourseModify();
		this.jbtnAdminCourseDelete=acv.getJbtnAdminCourseDelete();
	} //AdminCourseEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == jbtnAdminCourseCreate ) {
			System.out.println("등록 버튼 실행");
			JDialog jdCourseCreateDialog = new JDialog((JFrame)null, "과정 등록", true);
			jdCourseCreateDialog.getContentPane().add(new AdminCourseCreateView());
			jdCourseCreateDialog.pack();
			jdCourseCreateDialog.setLocationRelativeTo(amv);
			jdCourseCreateDialog.setVisible(true);
		} //end if
		if( ae.getSource() == jbtnAdminCourseModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdCourseModifyDialog = new JDialog((JFrame)null, "과정 수정", true);
			jdCourseModifyDialog.getContentPane().add(new AdminCourseModifyView());
			jdCourseModifyDialog.pack();
			jdCourseModifyDialog.setLocationRelativeTo(amv);
			jdCourseModifyDialog.setVisible(true);
		} //end if
		if( ae.getSource() == jbtnAdminCourseDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
	} //actionPerformed

} //class
