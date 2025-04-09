package kr.co.sist.jtg;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminExamModifyEvt extends WindowAdapter implements ActionListener {
	
	private AdminExamModifyView aemv;
	
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamClose;
	
	public AdminExamModifyEvt(AdminExamModifyView aemv) {
		this.aemv=aemv;
		this.jbtnAdminExamModify=aemv.getJbtnAdminExamModify();
		this.jbtnAdminExamClose=aemv.getJbtnAdminExamClose();
	} //AdminCourseModifyEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminExamModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminExamClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminExamModifyWindow = SwingUtilities.getWindowAncestor(aemv);
            if(adminExamModifyWindow instanceof JDialog) {
                ((JDialog) adminExamModifyWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	@Override
	public void windowOpened(WindowEvent e) {
		// Service 객체 생성
		
	}// windowOpened
	
} //class
