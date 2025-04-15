package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminCourseModifyEvt implements ActionListener {

	private AdminCourseModifyView acmv;

	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	private JButton jbtnAdminCourseClose;

	private AdminCourseView acv;

	public AdminCourseModifyEvt(AdminCourseModifyView acmv, AdminCourseView acv) {
		this.acmv = acmv;
		this.acv = acv;
		this.jbtnAdminCourseModify = acmv.getJbtnAdminCourseModify();
		this.jbtnAdminCourseDelete = acmv.getJbtnAdminCourseDelete();
		this.jbtnAdminCourseClose = acmv.getJbtnAdminCourseClose();
	} // AdminCourseModifyEvt

	public void removeCourse() {
		AdminCourseService acs = new AdminCourseService();

		boolean result = acs.removeCourse(acmv.getSelectedCourseInfo().getCourNum());
		if (!result) {
			JOptionPane.showMessageDialog(acmv, "과정에 엮인 다른 데이터가 있어 삭제하지 못하였습니다.");
			Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(acmv);
			if (adminCourseModifyWindow instanceof JDialog) {
				((JDialog) adminCourseModifyWindow).dispose();
			} // end if
			return;
		} // end if

		JOptionPane.showMessageDialog(acmv, "삭제하였습니다.");
		Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(acmv);
		if (adminCourseModifyWindow instanceof JDialog) {
			((JDialog) adminCourseModifyWindow).dispose();
		} // end if

		// 데이터 리로드~
		acv.getDftmAdminCourseTableModel().setRowCount(0);
		for (AdminCourseVO acvo : acs.searchAllCourseInfo()) {
			acv.getDftmAdminCourseTableModel()
					.addRow(new Object[] { acvo.getCourNum(), acvo.getCourCardinal(), acvo.getCourName(),
							acvo.getCourStatus(), acvo.getInstName(), acvo.getCourStartdate().toString(),
							acvo.getCourEnddate().toString() });
		} // end for

	}// removeCourse

	public void changeCourse() {
		// 입력 받은 모든것 이쁘게 표현하기 위한 변수 지정~ㅎㅎㅎㅎㅎ
		String changedCourseCardinal = acmv.getJtfAdminCourseCardinalSet().getText();
		String changedCourseName = acmv.getJtfAdminCourseNameSet().getText();
		String changedCourseStatus = acmv.getJtfAdminCourseStatusSet().getText();
		String changedCourseStartDate = acmv.getJtfAdminCourseStartdateSet().getText();
		String changedCourseEndDate = acmv.getJtfAdminCourseEnddateSet().getText();
		String changedInstNum = "";

		AdminCourseService acs = new AdminCourseService();
		
		
		
		for(AdminCourseInstVO acvo : acs.searchAllInstructorInfo()) {
			if(acvo.getInstName().equals(acmv.getJcbAdminCourseInstructorNameBox().getSelectedItem())) {
				changedInstNum = acvo.getInstNum();
			}// end if
		}// end for
		
		boolean result = acs.modifyCourse(changedCourseCardinal, changedCourseName, changedCourseStatus, changedCourseStartDate, changedCourseEndDate, changedInstNum, acmv.getSelectedCourseInfo().getCourNum());
		
		if(!result) {
			JOptionPane.showMessageDialog(acmv, "수정에 실패하였습니다.");
			return;
		}// end if
		
		JOptionPane.showMessageDialog(acmv, "수정에 성공하였습니다.");
		
		// 데이터 리로드
		acv.getDftmAdminCourseTableModel().setRowCount(0);
		for(AdminCourseVO acvo : acs.searchAllCourseInfo()) {
			acv.getDftmAdminCourseTableModel().addRow(new Object[] {acvo.getCourNum(),acvo.getCourCardinal(),acvo.getCourName(),acvo.getCourStatus(),acvo.getInstName(),acvo.getCourStartdate().toString(),acvo.getCourEnddate().toString()});;
		}// end for
		
	}// changeCourse
	
	public void closeModifyDialog() {
		Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(acmv);
		if (adminCourseModifyWindow instanceof JDialog) {
			((JDialog) adminCourseModifyWindow).dispose();
		}
	} //closeModifyDialog

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminCourseModify) {
			changeCourse();
		} // end if

		if (source == jbtnAdminCourseDelete) {
			removeCourse();
		} // end if

		if (source == jbtnAdminCourseClose) {
			System.out.println("닫기 버튼 실행");
			closeModifyDialog();
		} // end if

	} // actionPerformed

} // class

