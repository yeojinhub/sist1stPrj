package kr.co.sist.jtg;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminAccountStudentAccountCreateEvt implements ActionListener {
	
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
			Window adminAccountStudentAccountCreateWindow = SwingUtilities.getWindowAncestor(aasacv);
            if(adminAccountStudentAccountCreateWindow instanceof JDialog) {
                ((JDialog) adminAccountStudentAccountCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed

} //class
