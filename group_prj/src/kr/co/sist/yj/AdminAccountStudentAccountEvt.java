//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import kr.co.sist.view.AdminAccountStudentAccountView;

public class AdminAccountStudentAccountEvt implements ActionListener{

	private AdminAccountStudentAccountView aasav;
	
	private JButton jbtnAdminAccountStudentAccountMenu;
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    
    public AdminAccountStudentAccountEvt(AdminAccountStudentAccountView aasav) {
        this.aasav = aasav;
        this.jbtnAdminAccountStudentAccountMenu=aasav.getJbtnAdminAccountStudentAccountMenu();
		this.jbtnAdminAccountStudentAccountCreate=aasav.getJbtnAdminAccountStudentAccountCreate();
		this.jbtnAdminAccountStudentAccountModify=aasav.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountDelete=aasav.getJbtnAdminAccountStudentAccountDelete();
	} //AdminAccountStudentAccountEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountMenu ) {
			System.out.println("메뉴 버튼 실행");
		} //end if
		
		if( source == jbtnAdminAccountStudentAccountCreate ) {
			System.out.println("생성 버튼 실행");
			    JDialog infoDialog = new JDialog((JFrame) null, "학생 계정 정보", true);
			    infoDialog.getContentPane().add(new AdminAccountStudentAccountInfoView());
			    infoDialog.setLocationRelativeTo(aasav);
			    infoDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
			JOptionPane.showMessageDialog(aasav, "테이블에 있는 학생 리스트를 선택하여 수정하세요.", "안내 메세지", JOptionPane.DEFAULT_OPTION);
		} //end if
		if( source == jbtnAdminAccountStudentAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			JOptionPane.showMessageDialog(aasav, "테이블에 있는 학생 리스트를 선택하여 삭제하세요.", "안내 메세지", JOptionPane.DEFAULT_OPTION);
		} //end if
	} //actionPerformed

} //class