//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//import kr.co.sist.view.AdminCourseView;

public class AdminCourseEvt implements ActionListener{
	
	@SuppressWarnings("unused")
	private AdminCourseView acv;
	
	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	
	public AdminCourseEvt(AdminCourseView acv) {
		this.acv=acv;
		this.jbtnAdminCourseCreate=acv.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseModify=acv.getJbtnAdminCourseModify();
		this.jbtnAdminCourseDelete=acv.getJbtnAdminCourseDelete();
	} //AdminCourseEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == jbtnAdminCourseCreate ) {
			System.out.println("등록 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminCourseModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminCourseDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
	} //actionPerformed

} //class
