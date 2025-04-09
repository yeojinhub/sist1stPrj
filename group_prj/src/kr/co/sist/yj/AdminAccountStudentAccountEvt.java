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
import javax.swing.table.DefaultTableModel;

//import kr.co.sist.view.AdminAccountStudentAccountCreateView;
//import kr.co.sist.view.AdminAccountStudentAccountModifyView;
//import kr.co.sist.view.AdminAccountStudentAccountView;

public class AdminAccountStudentAccountEvt implements MouseListener, ActionListener {

	private AdminAccountStudentAccountView aasaView;

	private JButton jbtnAdminAccountStudentAccountCreate;
	private JButton jbtnAdminAccountStudentAccountModify;

	private int selectedNum;

	public AdminAccountStudentAccountEvt(AdminAccountStudentAccountView aasaView) {
		selectedNum = -1;

		this.aasaView = aasaView;
		this.jbtnAdminAccountStudentAccountCreate = aasaView.getJbtnAdminAccountStudentAccountCreate();
		this.jbtnAdminAccountStudentAccountModify = aasaView.getJbtnAdminAccountStudentAccountModify();
	} // AdminAccountStudentAccountEvt

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("테이블 클릭");
//		boolean flag = false;
//		selectedNum=Integer.parseInt( aasaView.getJtAdminAccountStudentAccountTable().getSelectedColumn().split(",")[0] );
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

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminAccountStudentAccountCreate) {
			System.out.println("생성 버튼 실행");
			JDialog jdStudentAccountCreateDialog = new JDialog((JFrame) null, "학생 계정 생성", true);
			jdStudentAccountCreateDialog.getContentPane().add(new AdminAccountStudentAccountCreateView());
			jdStudentAccountCreateDialog.pack();
			jdStudentAccountCreateDialog.setLocationRelativeTo(aasaView);
			jdStudentAccountCreateDialog.setVisible(true);
		} // end if
		if (source == jbtnAdminAccountStudentAccountModify) {
			System.out.println("수정 버튼 실행");
			JDialog jdStudentAccountModifyDialog = new JDialog((JFrame) null, "학생 계정 수정", true);
			jdStudentAccountModifyDialog.getContentPane().add(new AdminAccountStudentAccountModifyView());
			jdStudentAccountModifyDialog.pack();
			jdStudentAccountModifyDialog.setLocationRelativeTo(aasaView);
			jdStudentAccountModifyDialog.setVisible(true);
		} // end if

	} // actionPerformed
	
	public void loadStudentInfo() {
	    AdminAccountStudentAccountService aasaService = new AdminAccountStudentAccountService();
	    List<AdminAccountStudentAccountVO> studentList = aasaService.searchAllStudentAccountMember();

	    DefaultTableModel model = aasaView.getDftmStudentTableModel();
	    model.setRowCount(0);

	    // 조회한 학생 데이터들을 테이블 모델에 추가합니다.
	    for (AdminAccountStudentAccountVO aasaVO : studentList) {
	        model.addRow(new Object[]{
	        		aasaVO.getStu_num(),
	        		aasaVO.getStu_name(),
	        		aasaVO.getStu_tel(),
	        		aasaVO.getCour_cardinal(),
	        		aasaVO.getCour_name(),
	        		aasaVO.getStu_status()
	        });
	    } //end for
	    
	} //loadStudentInfo

} // class