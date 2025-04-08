package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
		
		//입력 field 값 변수에 저장
		int num = Integer.parseInt(aasamView.getJtfAdminAccountStudentAccountIDSet().getText().trim());
		String strStudentName = aasamView.getJtfAdminAccountStudentAccountNameSet().getText().trim();
		char[] studentPasswordArray = aasamView.getJpfAdminAccountStudentAccountPassSet().getPassword();
		String strStudentPassword = new String(studentPasswordArray).trim();
		String strStudentBirth = aasamView.getJtfAdminAccountStudentAccountBirthSet().getText();
		Date studentBirth = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 입력 포맷에 맞게 설정
		    studentBirth = (Date) sdf.parse(strStudentBirth);
		} catch (Exception e) {
		    e.printStackTrace();
		} //end try catch
		String strStudentTel = aasamView.getJtfAdminAccountStudentAccountTelSet().getText().trim();
		String strStudentAddress = aasamView.getJtfAdminAccountStudentAccountAddressSet().getText().trim();
		String strStudentStatus = aasamView.getJtfAdminAccountStudentAccountStatusSet().getText().trim();
		
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
			AdminAccountStudentAccountModifyVO aasamVO =
					new AdminAccountStudentAccountModifyVO(num, strStudentName, strStudentPassword, studentBirth, strStudentTel, strStudentAddress, strStudentStatus);
			modifyMember(aasamVO);
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
	
	public void modifyMember(AdminAccountStudentAccountModifyVO aasamVO) {
		
		if( numValidate() ) {
			//early return
			return;
		} //end if
		
		aasamVO.setStu_num(selectedNum);
		
		String out_msg = "학생 정보를 변경하지 못했습니다.";
		
		if( aasamService.modifyStudentAccountMember(aasamVO) ) {
			out_msg = "학생 정보가 변경되었습니다.";
		} //end if
		
		JOptionPane.showMessageDialog(aasamView, out_msg);
		
		selectedNum=-1;
		
	} //modifyMember
	
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
