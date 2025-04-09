package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class AdminCourseModifyEvt implements ActionListener {

	private AdminCourseModifyView acmView;

	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	private JButton jbtnAdminCourseClose;

	public AdminCourseModifyEvt(AdminCourseModifyView acmView) {
		this.acmView = acmView;
		this.jbtnAdminCourseModify = acmView.getJbtnAdminCourseModify();
		this.jbtnAdminCourseDelete = acmView.getJbtnAdminCourseDelete();
		this.jbtnAdminCourseClose = acmView.getJbtnAdminCourseClose();
	} // AdminCourseModifyEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminCourseModify) {
			System.out.println("수정 버튼 실행");
		} // end if

		if (source == jbtnAdminCourseDelete) {
			System.out.println("삭제 버튼 실행");
		} // end if

		if (source == jbtnAdminCourseClose) {
			System.out.println("닫기 버튼 실행");
			Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(acmView);
			if (adminCourseModifyWindow instanceof JDialog) {
				((JDialog) adminCourseModifyWindow).dispose();
			} // end if
		} // end if

	} // actionPerformed

} // class
