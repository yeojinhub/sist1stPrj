package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminAccountStudentAccountCreateEvt implements ActionListener {
	
	@SuppressWarnings("unused")
	private AdminAccountStudentAccountCreateView aasacv;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountClose;
    
    public AdminAccountStudentAccountCreateEvt(AdminAccountStudentAccountCreateView aasacv) {
    	this.aasacv=aasacv;
    	this.jbtnAdminAccountStudentAccountCreate=aasacv.getJbtnAdminAccountStudentAccountCreate();
    	this.jbtnAdminAccountStudentAccountClose=aasacv.getJbtnAdminAccountStudentAccountClose();
    } //AdminAccountStudentAccountCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountCreate ) {
			System.out.println("생성 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountStudentAccountClose ) {
			System.out.println("닫기 버튼 실행");
		} //end if
		
	} //actionPerformed

} //class
