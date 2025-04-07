//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

//import kr.co.sist.view.AdminCourseView;

public class AdminCourseEvt implements ActionListener, MouseListener {
	
	private AdminMainView amView;
	@SuppressWarnings("unused")
	private AdminCourseView acView;
	
	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	
	private List<AdminCourseVO> courseList;
	
	public AdminCourseEvt(AdminMainView amView, AdminCourseView acView) {
		this.amView=amView;
		this.acView=acView;
		this.jbtnAdminCourseCreate=acView.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseModify=acView.getJbtnAdminCourseModify();
	} //AdminCourseEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminCourseCreate ) {
			System.out.println("등록 버튼 실행");
			JDialog jdCourseCreateDialog = new JDialog((JFrame)null, "과정 등록", true);
			jdCourseCreateDialog.getContentPane().add(new AdminCourseCreateView());
			jdCourseCreateDialog.pack();
			jdCourseCreateDialog.setLocationRelativeTo(amView);
			jdCourseCreateDialog.setVisible(true);
		} //end if
		
		if( source == jbtnAdminCourseModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdCourseModifyDialog = new JDialog((JFrame)null, "과정 수정", true);
			jdCourseModifyDialog.getContentPane().add(new AdminCourseModifyView());
			jdCourseModifyDialog.pack();
			jdCourseModifyDialog.setLocationRelativeTo(amView);
			jdCourseModifyDialog.setVisible(true);
		} //end if
		
	} //actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

} //class
