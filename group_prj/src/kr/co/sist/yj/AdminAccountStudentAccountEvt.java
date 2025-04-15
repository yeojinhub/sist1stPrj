//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//import kr.co.sist.view.AdminAccountStudentAccountCreateView;
//import kr.co.sist.view.AdminAccountStudentAccountModifyView;
//import kr.co.sist.view.AdminAccountStudentAccountView;

public class AdminAccountStudentAccountEvt extends MouseAdapter implements ActionListener {

	private AdminAccountStudentAccountView stuView;

	private JButton stuCreateViewButton;
	private JButton stuModifyViewButton;

	private int selectedRow;
	private String strStuNum;

	public AdminAccountStudentAccountEvt(AdminAccountStudentAccountView stuView) {
		selectedRow = -1;

		this.stuView = stuView;
		this.stuCreateViewButton = stuView.getJbtnAdminAccountStudentAccountCreate();
		this.stuModifyViewButton = stuView.getJbtnAdminAccountStudentAccountModify();
		
		loadStudentInfo();
	} // AdminAccountStudentAccountEvt
	
	public void loadStudentInfo() {
	    AdminAccountStudentAccountInfoService stuService = new AdminAccountStudentAccountInfoService();
	    List<AdminAccountStudentAccountInfoVO> studentList = stuService.searchAllStudentAccountMember();

	    DefaultTableModel model = stuView.getDftmStudentTableModel();
	    model.setRowCount(0);

	    // 조회한 학생 데이터들을 테이블 모델에 추가합니다.
	    for (AdminAccountStudentAccountInfoVO stuVO : studentList) {
	        model.addRow(new Object[]{
	        		stuVO.getStuNum(),
	        		stuVO.getStuName(),
	        		stuVO.getStuTel(),
	        		stuVO.getCourCardinal(),
	        		stuVO.getCourName(),
	        		stuVO.getStuStatus()
	        });
	    } //end for
	    
	} //loadStudentInfo
	
	public void showCreateDialog() {
		JDialog stuCreateDialog = new JDialog((JFrame) null, "학생 계정 생성", true);
		stuCreateDialog.getContentPane().add(new AdminAccountStudentAccountCreateView());
		stuCreateDialog.pack();
		stuCreateDialog.setLocationRelativeTo(stuView);
		stuCreateDialog.setVisible(true);
		stuCreateDialog.setResizable(false);
	} //showCreateDialog
	
	public void showModifyDialog() {
		JDialog stuModifyDialog = new JDialog((JFrame) null, "학생 계정 수정", true);
		stuModifyDialog.getContentPane().add(new AdminAccountStudentAccountModifyView(strStuNum));
		stuModifyDialog.pack();
		stuModifyDialog.setLocationRelativeTo(stuView);
		stuModifyDialog.setVisible(true);
		stuModifyDialog.setResizable(false);
	} //showModifyDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if (source == stuCreateViewButton) {
			System.out.println("생성 버튼 실행");
			showCreateDialog();
			loadStudentInfo();
		} // end if
		
		if (source == stuModifyViewButton) {
			System.out.println("수정 버튼 실행");
			showModifyDialog();
			loadStudentInfo();
		} // end if
		
	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent me) {
		selectedRow = stuView.getStuInfoTable().getSelectedRow();
		strStuNum = stuView.getStuInfoTable()
				.getValueAt(selectedRow, 0).toString();
		System.out.println("선택된 학생 학번: " + strStuNum);
		System.out.println("클릭한 행의 수 : " + selectedRow);
	} //mouseClicked
	
} // class