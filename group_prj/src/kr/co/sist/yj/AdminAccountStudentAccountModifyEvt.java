package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountStudentAccountModifyEvt implements ActionListener {

	@SuppressWarnings("unused")
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
		} //end if
	} //actionPerformed
	
} //class
