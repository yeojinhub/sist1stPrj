package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminAccountInstructorAccountEvt extends MouseAdapter implements ActionListener {

	private AdminAccountInstructorAccountView aaiaView;

	private JButton jbtnAdminAccountInstructorAccountCreate;
	private JButton jbtnAdminAccountInstructorAccountModify;
	
	public AdminAccountInstructorAccountEvt(AdminAccountInstructorAccountView aaiaView) {
		this.aaiaView = aaiaView;
		this.jbtnAdminAccountInstructorAccountCreate = aaiaView.getJbtnAdminAccountInstructorAccountCreate();
		this.jbtnAdminAccountInstructorAccountModify = aaiaView.getJbtnAdminAccountInstructorAccountModify();
	} // AdminAccountInstructorAccountEvt
	
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
			jdInstructorAccountCreateDialog.setResizable(false);

			loadInstructorInfoTableList();
		} // end if
		
		if (source == jbtnAdminAccountInstructorAccountModify) {
			System.out.println("수정 버튼 실행");
			
			 // JTable에서 선택된 행의 인덱스 및 사번 추출
		    int selectedRow = aaiaView.getJtAdminAccountInstructorAccountTable().getSelectedRow();
		    if(selectedRow == -1) {
		        JOptionPane.showMessageDialog(aaiaView, "수정할 강사 계정을 선택해주세요.");
		        //early return
		        return;
		    } //end if
		    String strInstNum = aaiaView.getJtAdminAccountInstructorAccountTable()
		            .getValueAt(selectedRow, 0).toString();
		    System.out.println("선택된 강사 사번: " + strInstNum);
		    
			JDialog jdInstructorAccountModifyDialog = new JDialog((JFrame) null, "강사 계정 수정", true);
			 // 수정 다이얼로그에 추가할 ModifyView 인스턴스 생성
		    AdminAccountInstructorAccountModifyView modifyView = new AdminAccountInstructorAccountModifyView(strInstNum);
		    
			jdInstructorAccountModifyDialog.getContentPane().add(modifyView);
			jdInstructorAccountModifyDialog.pack();
			jdInstructorAccountModifyDialog.setLocationRelativeTo(aaiaView);
			jdInstructorAccountModifyDialog.setVisible(true);
			jdInstructorAccountModifyDialog.setResizable(false);
			
			loadInstructorInfoTableList();
		} // end if

	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(aaiaView.getJtAdminAccountInstructorAccountTable().getValueAt(aaiaView.getJtAdminAccountInstructorAccountTable().getSelectedRow(), 0));
	}
	
	

} // class
