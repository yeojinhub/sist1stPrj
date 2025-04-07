package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminAccountStudentAccountModifyEvt implements ActionListener {

	private AdminAccountStudentAccountModifyView aasamView;
	
	private AdminAccountStudentAccountModifyService aasamService;
	
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    private JButton jbtnAdminAccountStudentAccountClose;
    
    private int selectedNum;
	
	public AdminAccountStudentAccountModifyEvt(AdminAccountStudentAccountModifyView aasamView) {
		this.aasamView=aasamView;
		this.jbtnAdminAccountStudentAccountModify=aasamView.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountDelete=aasamView.getJbtnAdminAccountStudentAccountDelete();
		this.jbtnAdminAccountStudentAccountClose=aasamView.getJbtnAdminAccountStudentAccountClose();
	} //AdminAccountStudentAccountModifyEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminAccountStudentAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			removeMember();
		} //end if
		if( source == jbtnAdminAccountStudentAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountStudentAccountModifyWindow = SwingUtilities.getWindowAncestor(aasamView);
            if(adminAccountStudentAccountModifyWindow instanceof JDialog) {
                ((JDialog) adminAccountStudentAccountModifyWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	private boolean numValidate() {
		boolean flag=false;
		selectedNum = 1;
		if( flag=(selectedNum== -1) ) {
			JOptionPane.showMessageDialog(aasamView, "테이블에서 학생을 클릭해주세요.");
		} //end if
		
		return flag;
	} //numValidate
	
	public void removeMember() {
		if( numValidate() ) {
			//early return
			return;
		} //end if
		
		String msg = "학생 계정을 삭제하지 못했습니다.";
		
		if( aasamService.removeStudentAccountMember(selectedNum) ) {
			msg = "학생 계정을 삭제하였습니다.";
		} //end if
		
		JOptionPane.showMessageDialog(aasamView, msg);
		
	} //removeMember

} //class
