//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import kr.co.sist.view.AdminAccountStudentAccountCreateView;
//import kr.co.sist.view.AdminAccountStudentAccountModifyView;
//import kr.co.sist.view.AdminAccountStudentAccountView;

public class AdminAccountStudentAccountEvt implements ActionListener{

	private AdminAccountStudentAccountView aasav;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    
    public AdminAccountStudentAccountEvt(AdminAccountStudentAccountView aasav) {
        this.aasav = aasav;
		this.jbtnAdminAccountStudentAccountCreate=aasav.getJbtnAdminAccountStudentAccountCreate();
		this.jbtnAdminAccountStudentAccountModify=aasav.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountDelete=aasav.getJbtnAdminAccountStudentAccountDelete();
	} //AdminAccountStudentAccountEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountCreate ) {
			System.out.println("생성 버튼 실행");
			JDialog jdStudentAccountCreateDialog = new JDialog((JFrame) null, "학생 계정 생성", true);
			jdStudentAccountCreateDialog.getContentPane().add(new AdminAccountStudentAccountCreateView());
			jdStudentAccountCreateDialog.pack();
			jdStudentAccountCreateDialog.setLocationRelativeTo(aasav);
			jdStudentAccountCreateDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdStudentAccountModifyDialog = new JDialog((JFrame) null, "학생 계정 수정", true);
			jdStudentAccountModifyDialog.getContentPane().add(new AdminAccountStudentAccountModifyView());
			jdStudentAccountModifyDialog.pack();
			jdStudentAccountModifyDialog.setLocationRelativeTo(aasav);
			jdStudentAccountModifyDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminAccountStudentAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			JOptionPane.showMessageDialog(aasav, "테이블에 있는 학생 계정을 선택한 후 삭제하세요.", "안내 메세지", JOptionPane.DEFAULT_OPTION);
		} //end if
	} //actionPerformed

} //class