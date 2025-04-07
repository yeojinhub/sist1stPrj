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

public class AdminAccountAdminAccountCreateEvt implements ActionListener {

	private AdminAccountAdminAccountCreateView aaaacView;
	
	private JButton jbtnAdminAccountAdminAccountCreate;
	private JButton jbtnAdminAccountAdminAccountClose;
	
	public AdminAccountAdminAccountCreateEvt(AdminAccountAdminAccountCreateView aaaacView) {
		this.aaaacView=aaaacView;
		this.jbtnAdminAccountAdminAccountCreate=aaaacView.getJbtnAdminAccountAdminAccountCreate();
		this.jbtnAdminAccountAdminAccountClose=aaaacView.getJbtnAdminAccountAdminAccountClose();
	} //AdminAccountAdminAccountCreateEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminAccountAdminAccountCreate ) {
			System.out.println("생성 버튼 실행");
			addMember();
		} //end if
		
		if( source == jbtnAdminAccountAdminAccountClose ) {
			System.out.println("닫기 버튼 실행");
			Window adminAccountAdminAccountCreateWindow = SwingUtilities.getWindowAncestor(aaaacView);
            if(adminAccountAdminAccountCreateWindow instanceof JDialog) {
                ((JDialog) adminAccountAdminAccountCreateWindow).dispose();
            } //end if
		} //end if
		
	} //actionPerformed
	
	private void inputFieldReset() {
		
		//입력 field 초기화
		aaaacView.getJtfAdminAccountAdminAccountNameSet().setText("");
		aaaacView.getJpfAdminAccountAdminAccountPassSet().setText("");
		aaaacView.getJtfAdminAccountAdminAccountBirthSet().setText("");
		aaaacView.getJtfAdminAccountAdminAccountTelSet().setText("");
		aaaacView.getJtfAdminAccountAdminAccountAddressSet().setText("");
		
		//field focus
		aaaacView.getJtfAdminAccountAdminAccountNameSet().requestFocus();
		
	} //inputFieldReset
	
	public void addMember() {
		
		//VO에 입력 값 저장
		AdminAccountAdminAccountCreateVO aaaacVO = new AdminAccountAdminAccountCreateVO();
		aaaacVO.setAdm_name( aaaacView.getJtfAdminAccountAdminAccountNameSet().getText().trim() );
		char[] adminPasswordArray = aaaacView.getJpfAdminAccountAdminAccountPassSet().getPassword();
		String strAdminPassword = new String(adminPasswordArray).trim();
		aaaacVO.setAdm_pass( strAdminPassword );
		String strAdminBirth = new String( aaaacView.getJtfAdminAccountAdminAccountBirthSet().getText().trim() );
		
		if( !strAdminBirth.isEmpty() ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate;
			try {
				parsedDate = sdf.parse(strAdminBirth);
				Date adminBirthDate = new Date(parsedDate.getTime());
				aaaacVO.setAdm_birth( adminBirthDate );
			} catch (ParseException pe) {
				pe.printStackTrace();
			} //end try catch
		} else {
			aaaacVO.setAdm_birth( null );
		} //end if else
		aaaacVO.setAdm_tel( aaaacView.getJtfAdminAccountAdminAccountTelSet().getText().trim() );
		aaaacVO.setAdm_add( aaaacView.getJtfAdminAccountAdminAccountAddressSet().getText().trim() );
		
		//메세지 생성
		AdminAccountAdminAccountCreateService aaaacService = new AdminAccountAdminAccountCreateService();
		String out_msg="강사 계정이 생성되지 않았습니다.";
		if( aaaacService.addAdminAccountMember(aaaacVO) ) {
			out_msg="강사 계정이 생성되었습니다.";
		} //end if
		
		//입력 field 초기화
		inputFieldReset();
		
		//메세지 출력
		JOptionPane.showMessageDialog(aaaacView, out_msg);
		
	} //addMember
	
} //class
