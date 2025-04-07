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
	
	private AdminAccountStudentAccountCreateView aasacv;
	
	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountClose;
    
    public AdminAccountStudentAccountCreateEvt(AdminAccountStudentAccountCreateView aasacv) {
    	this.aasacv=aasacv;
    	this.jbtnAdminAccountStudentAccountCreate=aasacv.getJbtnAdminAccountStudentAccountCreate();
    	this.jbtnAdminAccountStudentAccountClose=aasacv.getJbtnAdminAccountStudentAccountClose();
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
			Window adminAccountStudentAccountCreateWindow = SwingUtilities.getWindowAncestor(aasacv);
            if(adminAccountStudentAccountCreateWindow instanceof JDialog) {
                ((JDialog) adminAccountStudentAccountCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	public void addMember() {
		
		//VO에 입력 값 저장
		AdminAccountStudentAccountCreateVO aasacVO = new AdminAccountStudentAccountCreateVO();
		aasacVO.setStu_name( aasacv.getJtfAdminAccountStudentAccountNameSet().getText().trim() );
		char[] studentPasswordArray = aasacv.getJpfAdminAccountStudentAccountPassSet().getPassword();
		String strStudentPassword = new String(studentPasswordArray).trim();
		aasacVO.setStu_pass( strStudentPassword );
		String strStudentBirth = new String( aasacv.getJtfAdminAccountStudentAccountBirthSet().getText().trim() );

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
		aasacVO.setStu_tel( aasacv.getJtfAdminAccountStudentAccountTelSet().getText().trim() );
		aasacVO.setStu_add( aasacv.getJtfAdminAccountStudentAccountAddressSet().getText().trim() );
		aasacVO.setStu_status( aasacv.getJtfAdminAccountStudentAccountStatusSet().getText().trim() );
		
		//메세지 생성
		AdminAccountStudentAccountCreateService aasacService = new AdminAccountStudentAccountCreateService();
		String out_msg="학생 계정이 생성되지 않았습니다.";
		if( aasacService.addStudentAccountMember(aasacVO) ) {
			out_msg="학생 계정이 생성되었습니다.";
		} //end if
		
		//입력 field 초기화
		aasacv.getJtfAdminAccountStudentAccountNameSet().setText("");
		aasacv.getJpfAdminAccountStudentAccountPassSet().setText("");
		aasacv.getJtfAdminAccountStudentAccountBirthSet().setText("");
		aasacv.getJtfAdminAccountStudentAccountTelSet().setText("");
		aasacv.getJtfAdminAccountStudentAccountStatusSet().setText("");
		
		//메세지 출력
		JOptionPane.showMessageDialog(aasacv, out_msg);
		
	} //addMember

} //class
