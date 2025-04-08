package kr.co.sist.jtg;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminExamCreateEvt extends WindowAdapter implements ActionListener {
	
	private AdminExamCreateView aecv;
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamClose;
	
	public AdminExamCreateEvt(AdminExamCreateView aecv) {
		this.aecv=aecv;
		this.jbtnAdminExamCreate=aecv.getJbtnAdminExamCreate();
		this.jbtnAdminExamClose=aecv.getJbtnAdminExamClose();
	} //AdminCourseCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminExamCreate ) {
			System.out.println("등록 버튼 실행");
		} //end if
		if( source == jbtnAdminExamClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminExamCreateWindow = SwingUtilities.getWindowAncestor(aecv);
            if(adminExamCreateWindow instanceof JDialog) {
                ((JDialog) adminExamCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	@Override
	public void windowOpened(WindowEvent e) {
		// Service 객체 생성
		
	}// windowOpened
	
} //class
