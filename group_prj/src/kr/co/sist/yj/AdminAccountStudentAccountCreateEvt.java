package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminAccountStudentAccountCreateEvt implements ActionListener {
	
	private AdminAccountStudentAccountCreateView aasacView;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountClose;
    
    public AdminAccountStudentAccountCreateEvt(AdminAccountStudentAccountCreateView aasacView) {
    	this.aasacView=aasacView;
    	this.jbtnAdminAccountStudentAccountCreate=aasacView.getJbtnAdminAccountStudentAccountCreate();
    	this.jbtnAdminAccountStudentAccountClose=aasacView.getJbtnAdminAccountStudentAccountClose();
    } //AdminAccountStudentAccountCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountCreate ) {
			System.out.println("생성 버튼 실행");
			addMember();
		} //end if
		
		if( source == jbtnAdminAccountStudentAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountStudentAccountCreateWindow = SwingUtilities.getWindowAncestor(aasacView);
            if(adminAccountStudentAccountCreateWindow instanceof JDialog) {
                ((JDialog) adminAccountStudentAccountCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	private void inputFieldReset() {
		
		//입력 field 초기화
		aasacView.getJtfAdminAccountStudentAccountNameSet().setText("");
		aasacView.getJpfAdminAccountStudentAccountPassSet().setText("");
		aasacView.getJtfAdminAccountStudentAccountBirthSet().setText("");
		aasacView.getJtfAdminAccountStudentAccountTelSet().setText("");
		aasacView.getJtfAdminAccountStudentAccountStatusSet().setText("");
		
		//field focus
		aasacView.getJtfAdminAccountStudentAccountNameSet().requestFocus();
		
	} //inputFieldReset
	
	public void addMember() {
		
		//VO에 입력 값 저장
		AdminAccountStudentAccountCreateVO aasacVO = new AdminAccountStudentAccountCreateVO();
		aasacVO.setStu_name( aasacView.getJtfAdminAccountStudentAccountNameSet().getText().trim() );
		char[] studentPasswordArray = aasacView.getJpfAdminAccountStudentAccountPassSet().getPassword();
		String strStudentPassword = new String(studentPasswordArray).trim();
		aasacVO.setStu_pass( strStudentPassword );
		String strStudentBirth = new String( aasacView.getJtfAdminAccountStudentAccountBirthSet().getText().trim() );

		if( !strStudentBirth.isEmpty() ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate;
			try {
				parsedDate = sdf.parse(strStudentBirth);
				Date studentBirthDate = new Date(parsedDate.getTime());
				aasacVO.setStu_birth(studentBirthDate);
			} catch (ParseException pe) {
				pe.printStackTrace();
			} //end try catch
		} else {
			aasacVO.setStu_birth( null );
		} //end if else
		aasacVO.setStu_tel( aasacView.getJtfAdminAccountStudentAccountTelSet().getText().trim() );
		aasacVO.setStu_add( aasacView.getJtfAdminAccountStudentAccountAddressSet().getText().trim() );
		aasacVO.setStu_status( aasacView.getJtfAdminAccountStudentAccountStatusSet().getText().trim() );
		
		//메세지 생성
		AdminAccountStudentAccountCreateService aasacService = new AdminAccountStudentAccountCreateService();
		String out_msg="학생 계정이 생성되지 않았습니다.";
		if( aasacService.addStudentAccountMember(aasacVO) ) {
			out_msg="학생 계정이 생성되었습니다.";
		} //end if
		
		//입력 field 초기화
		inputFieldReset();
		
		//메세지 출력
		JOptionPane.showMessageDialog(aasacView, out_msg);
		
	} //addMember

} //class
