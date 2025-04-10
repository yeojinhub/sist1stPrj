package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class AdminAccountInstructorAccountEvt implements ActionListener {

	private AdminAccountInstructorAccountView aaiaView;

	private JButton jbtnAdminAccountInstructorAccountCreate;
	private JButton jbtnAdminAccountInstructorAccountModify;

	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView aaiaView) {
		this.aaiaView = aaiaView;
		this.jbtnAdminAccountInstructorAccountCreate = aaiaView.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountModify = aaiaView.getJbtnAdminAccountInstructorAccountModify();
	} // AdminAccountInstructorAccountEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminAccountInstructorAccountCreate) {
			System.out.println("생성 버튼 실행");
			JDialog jdInstructorAccountCreateDialog = new JDialog((JFrame) null, "강사 계정 생성", true);
			jdInstructorAccountCreateDialog.getContentPane().add(new AdminAccountInstructorAccountCreateView());
			jdInstructorAccountCreateDialog.pack();
			jdInstructorAccountCreateDialog.setLocationRelativeTo(aaiaView);
			jdInstructorAccountCreateDialog.setVisible(true);

		} // end if
		if (source == jbtnAdminAccountInstructorAccountModify) {
			System.out.println("수정 버튼 실행");
			JDialog jdInstructorAccountModifyDialog = new JDialog((JFrame) null, "강사 계정 수정", true);
			jdInstructorAccountModifyDialog.getContentPane().add(new AdminAccountInstructorAccountModifyView());
			jdInstructorAccountModifyDialog.pack();
			jdInstructorAccountModifyDialog.setLocationRelativeTo(aaiaView);
			jdInstructorAccountModifyDialog.setVisible(true);
		} // end if

	} // actionPerformed
	
	public void loadInstructorInfoTableList() {
		AdminAccountInstructorAccountInfoService aaiaiService = new AdminAccountInstructorAccountInfoService();
		List<AdminAccountInstructorAccountInfoVO> instructorList = aaiaiService.searchAllInstructorAccountMember();
		
		DefaultTableModel model = aaiaView.getDftmInstructorTableModel();
		model.setRowCount(0);
		
		//강사 VO 객체들을 테이블에 추가
		for(AdminAccountInstructorAccountInfoVO aaiaiVO : instructorList) {
			model.addRow(new Object[] {
					aaiaiVO.getInstNum(),
					aaiaiVO.getInstName(),
					aaiaiVO.getInstBirth(),
					aaiaiVO.getInstTel(),
					aaiaiVO.getInstAdd()
			});
		} //end for
		
	} //loadInstructorInfoTableList

} // class
