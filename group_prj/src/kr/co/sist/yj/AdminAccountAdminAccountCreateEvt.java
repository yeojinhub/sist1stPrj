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

	private AdminAccountAdminAccountCreateView admCreateView;
	
	private JButton admCreateButton;
	private JButton admCloseButton;
	
	public AdminAccountAdminAccountCreateEvt(AdminAccountAdminAccountCreateView admCreateView) {
		this.admCreateView=admCreateView;
		this.admCreateButton=admCreateView.getAdmCreateButton();
		this.admCloseButton=admCreateView.getAdmCloseButton();
	} //AdminAccountAdminAccountCreateEvt
	
	private void inputFieldReset() {
		
		//입력 field 초기화
		admCreateView.getAdmNameTextSet().setText("");
		admCreateView.getAdmPassTextSet().setText("");
		admCreateView.getAdmBirthTextSet().setText("");
		admCreateView.getAdmTelTextSet().setText("");
		admCreateView.getAdmAddTextSet().setText("");
		
		//field focus
		admCreateView.getAdmNameTextSet().requestFocus();
		
	} //inputFieldReset
	
	private void addMember() {
		
		//VO에 입력 값 저장
		AdminAccountAdminAccountInfoVO admVO = new AdminAccountAdminAccountInfoVO();
		admVO.setAdmName( admCreateView.getAdmNameTextSet().getText().trim() );
		char[] adminPasswordArray = admCreateView.getAdmPassTextSet().getPassword();
		String strAdminPassword = new String(adminPasswordArray).trim();
		admVO.setAdmPass( strAdminPassword );
		String strAdminBirth = new String( admCreateView.getAdmBirthTextSet().getText().trim() );
		
		if( !strAdminBirth.isEmpty() ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate;
			try {
				parsedDate = sdf.parse(strAdminBirth);
				Date adminBirthDate = new Date(parsedDate.getTime());
				admVO.setAdmBirth( adminBirthDate );
			} catch (ParseException pe) {
				pe.printStackTrace();
			} //end try catch
		} else {
			admVO.setAdmBirth( null );
		} //end if else
		admVO.setAdmTel( admCreateView.getAdmTelTextSet().getText().trim() );
		admVO.setAdmAdd( admCreateView.getAdmAddTextSet().getText().trim() );
		
		String[] options = {"생성", "취소"};
	    int result = JOptionPane.showOptionDialog(
	    	admCreateView,
	        "관리자 계정을 생성 하시겠습니까?",
	        "생성 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminAccountAdminAccountInfoService admService = new AdminAccountAdminAccountInfoService();
			boolean flag = admService.addAdminAccountMember(admVO);
			if(flag) {
				// 생성 버튼을 눌렀을 때
				System.out.println("생성 버튼 실행");
				JOptionPane.showMessageDialog(admCreateView, "관리자 계정이 생성되었습니다.");
				// 입력 field 초기화
				inputFieldReset();
				closeCreateJDialog();
			} else {
				// 생성 오류가 났을 때
				JOptionPane.showMessageDialog(admCreateView, "관리자 계정 생성에 실패했습니다.");
				// 입력 field 초기화
				inputFieldReset();
			} //end if else
		}  else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("생성 취소 버튼 실행");
	        JOptionPane.showMessageDialog(admCreateView, "관리자 계정 생성을 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("생성 취소 창 닫기");
	        JOptionPane.showMessageDialog(admCreateView, "관리자 계정 생성 창을 닫았습니다.");
	    } //end if else
		
		//메세지 생성
		
	} //addMember
	
	private void closeCreateJDialog() {
		
		Window closeAdmCreateWindow = SwingUtilities.getWindowAncestor(admCreateView);
		if(closeAdmCreateWindow instanceof JDialog) {
			((JDialog) closeAdmCreateWindow).dispose();
		} //end if
		
	} //closeCreateJDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == admCreateButton ) {
			System.out.println("생성 버튼 실행");
			addMember();
		} //end if
		
		if( source == admCloseButton ) {
			System.out.println("닫기 버튼 실행");
			closeCreateJDialog();
		} //end if
		
	} //actionPerformed
	
} //class
