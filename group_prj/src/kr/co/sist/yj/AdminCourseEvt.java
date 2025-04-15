//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

//import kr.co.sist.view.AdminCourseView;

public class AdminCourseEvt extends MouseAdapter implements ActionListener {

	private AdminMainView amView;
	private AdminCourseView acView;

	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;

	public AdminCourseEvt(AdminMainView amView, AdminCourseView acView) {
		this.amView = amView;
		this.acView = acView;
		this.jbtnAdminCourseCreate = acView.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseModify = acView.getJbtnAdminCourseModify();
	} // AdminCourseEvt
	
	public AdminCourseVO selectedCourse(int num) {
		AdminCourseVO acvo = new AdminCourseVO();
		
		// 여기서는 JTable에서 선택한 행의 데이터들을 VO객체에 담는 작업을 한다.
//		for(AdminCourseVO vo : amView.getCourseList()) {
//			if (vo.getCourNum() == num) {
//				acvo.setCourNum(vo.getCourNum());
//				acvo.setCourCardinal(vo.getCourCardinal());
//				acvo.setCourName(vo.getCourName());
//				acvo.setCourStatus(vo.getCourStatus());
//				acvo.setCourStartdate(vo.getCourStartdate());
//				acvo.setCourEnddate(vo.getCourEnddate());
//				acvo.setInstNum(vo.getInstNum());
//				acvo.setInstName(vo.getInstName());
//			}// end if
//		}// end for
		
		return acvo;
	}// selectedCourse
	
	public void showCreateDialog() {
		JDialog jdCourseCreateDialog = new JDialog((JFrame) null, "과정 등록", true);
//		jdCourseCreateDialog.getContentPane().add(new AdminCourseCreateView(amView.getCourseList(), jdCourseCreateDialog, amView, acView));
		jdCourseCreateDialog.pack();
		jdCourseCreateDialog.setLocationRelativeTo(amView);
		jdCourseCreateDialog.setVisible(true);
	} //showCreateDialog
	
	public void showModifyDialog() {
		JDialog jdCourseModifyDialog = new JDialog((JFrame) null, "과정 수정", true);
		jdCourseModifyDialog.getContentPane().add(new AdminCourseModifyView(amView, acView));
		jdCourseModifyDialog.pack();
		jdCourseModifyDialog.setLocationRelativeTo(amView);
		jdCourseModifyDialog.setVisible(true);
	} //showModifyDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminCourseCreate) {
			System.out.println("등록 버튼 실행");
			showCreateDialog();
		} // end if

		if (source == jbtnAdminCourseModify) {
			System.out.println("수정 버튼 실행");
			showModifyDialog();
		} // end if

	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedCourNum = (int) acView.getJtAdminCourseTable().getValueAt(acView.getJtAdminCourseTable().getSelectedRow(), 0);
		
		// AdminCourseView 전역에서 사용할 수 있게 class field에 VO객체를 생성하고 Getter method로 활용할 계획이다.
		acView.setSelectedCourInfo(selectedCourse(selectedCourNum));
		
		
	}// mouseClicked
	

} // class
