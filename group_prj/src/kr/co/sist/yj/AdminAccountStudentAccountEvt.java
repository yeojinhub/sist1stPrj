//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountStudentAccountEvt implements ActionListener{

	@SuppressWarnings("unused")
	private AdminAccountStudentAccountView aasav;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    
	public AdminAccountStudentAccountEvt(AdminAccountStudentAccountView aasav) {
		this.aasav=aasav;
		this.jbtnAdminAccountStudentAccountCreate=aasav.getJbtnAdminAccountStudentAccountCreate();
		this.jbtnAdminAccountStudentAccountModify=aasav.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountDelete=aasav.getJbtnAdminAccountStudentAccountDelete();
	} //AdminAccountStudentAccountEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == jbtnAdminAccountStudentAccountCreate ) {
			System.out.println("생성 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( ae.getSource() == jbtnAdminAccountStudentAccountDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
	} //actionPerformed

} //class