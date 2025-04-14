package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminAccountAdminAccountModifyEvt implements ActionListener {
	
	private AdminAccountAdminAccountModifyView admModifyView;
	
	private JButton admModifyButton;
    private JButton admDeleteButton;
	private JButton admCloseButton;
	
	private String selectedAdmNum;

	public AdminAccountAdminAccountModifyEvt(AdminAccountAdminAccountModifyView admModifyView){
		this.admModifyView=admModifyView;
		this.admModifyButton=admModifyView.getAdmModifyButton();
		this.admDeleteButton=admModifyView.getAdmDeleteButton();
		this.admCloseButton=admModifyView.getAdmCloseButton();
		
		selectedAdmNum = admModifyView.getStrAdmNum();
		loadAdminInfo(selectedAdmNum);
	} //AdminAccountAdminAccountModifyEvt
	
	private void loadAdminInfo(String admID) {
		
		AdminAccountAdminAccountInfoService admService = new AdminAccountAdminAccountInfoService();
		AdminAccountAdminAccountInfoVO admVO = admService.searchOneAdminAccountMember(admID);
		
		if( admVO!=null ) {
			// VO 객체의 값 설정
			admModifyView.getAdmNameTextSet().setText(admVO.getAdmName());
			admModifyView.getAdmIDTextSet().setText(admVO.getAdmID());
			admModifyView.getAdmPassTextSet().setText(admVO.getAdmPass());
			
			Date birthDate = admVO.getAdmBirth();
			// 원하는 포맷으로 문자열 변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strbirth = sdf.format(birthDate);
			// 텍스트 필드에 세팅
			admModifyView.getAdmBirthTextSet().setText(strbirth);
			
			admModifyView.getAdmTelTextSet().setText(admVO.getAdmTel());
			admModifyView.getAdmAddTextSet().setText(admVO.getAdmAdd());
		} else {
			// VO 객체의 값이 null일 때 예외처리
			JOptionPane.showMessageDialog(admModifyView, "관리자 계정을 선택해주세요.");
		} //end if else
		
	} //loadAdminInfo
	
	public void modifyMember() {
		//입력 field 값 변수에 저장
		String strAdmID = selectedAdmNum;
		System.out.println("수정할 강사 사번 : "+selectedAdmNum);
		String strAdmName = admModifyView.getAdmNameTextSet().getText().trim();
		char[] adminPassArray = admModifyView.getAdmPassTextSet().getPassword();
		String strAdmPass = new String(adminPassArray).trim();
		String strAdmBirth = admModifyView.getAdmBirthTextSet().getText();
		Date utilBirth = null;
		java.sql.Date sqlBirth = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    utilBirth = sdf.parse(strAdmBirth);  
		    // 2) utilDate → sql.Date 변환
		    sqlBirth = new java.sql.Date(utilBirth.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} //end try catch
		String strAdmTel = admModifyView.getAdmTelTextSet().getText().trim();
		String strAdmAdd = admModifyView.getAdmAddTextSet().getText().trim();
		
		//선택된 강사 계정 VO 객체 생성 및 저장
		AdminAccountAdminAccountInfoVO admVO = new AdminAccountAdminAccountInfoVO();
		admVO.setAdmID(strAdmID);
		admVO.setAdmName(strAdmName);
		admVO.setAdmPass(strAdmPass);
		admVO.setAdmBirth(sqlBirth);
		admVO.setAdmTel(strAdmTel);
		admVO.setAdmAdd(strAdmAdd);
		
		String[] options = {"수정", "취소"};
		int result = JOptionPane.showOptionDialog(
				admModifyView,
		        "관리자 계정을 수정 하시겠습니까?",
		        "수정 확인",
		        JOptionPane.DEFAULT_OPTION,
		        JOptionPane.WARNING_MESSAGE,
		        null,
		        options,
		        options[1]
		    );
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminAccountAdminAccountInfoService admService = new AdminAccountAdminAccountInfoService();
			boolean flag=admService.modifyAdminAccountMember(admVO);
			if(flag) {
				// 수정 버튼을 눌렀을 때
				System.out.println("수정 버튼 실행");
				JOptionPane.showMessageDialog(admModifyView, "관리자 계정이 수정되었습니다.");
				closeModifyJDialog();
			} else {
				// 수정 오류가 났을 때
				JOptionPane.showMessageDialog(admModifyView, "관리자 계정 수정에 실패했습니다.");
				closeModifyJDialog();
			} //end if else
		} else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("수정 취소 버튼 실행");
	        JOptionPane.showMessageDialog(admModifyView, "관리자 계정 수정을 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("수정 취소 창 닫기");
	        JOptionPane.showMessageDialog(admModifyView, "관리자 계정 수정 창을 닫았습니다.");
	    } //end if else
		
	} //modifyMember
	
	public void removeMember() {
		
		String[] options = {"삭제", "취소"};
		int result = JOptionPane.showOptionDialog(
				admModifyView,
				"관리자 계정을 삭제 하시겠습니까?",
				"삭제 확인",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[1]
				);
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminAccountAdminAccountInfoService admService = new AdminAccountAdminAccountInfoService();
			boolean flag = admService.removeAdminAccountMember(selectedAdmNum);
			
			if (flag) {
				// 삭제 버튼을 눌렀을 때
				System.out.println("삭제 버튼 실행");
				JOptionPane.showMessageDialog(admModifyView, "관리자 계정이 삭제되었습니다.");
				closeModifyJDialog();
			} else {
				// 삭제 오류가 났을 때
				JOptionPane.showMessageDialog(admModifyView, "관리자 계정 삭제에 실패했습니다.");
				closeModifyJDialog();
			} //end if else
		} else if (result == 1) {
			// 취소 버튼을 눌렀을 때
			System.out.println("삭제 취소 버튼 실행");
			JOptionPane.showMessageDialog(admModifyView, "관리자 계정 삭제를 취소하였습니다.");
		} else if (result == -1) {
			// 창 닫기 버튼을 눌렀을 때
			System.out.println("삭제 취소 창 닫기");
			JOptionPane.showMessageDialog(admModifyView, "관리자 계정 삭제 창을 닫았습니다.");
		} //end if else
	    
	} //removeMember
	
	private void closeModifyJDialog() {
		
		Window closeAdmModifyWindow = SwingUtilities.getWindowAncestor(admModifyView);
        if(closeAdmModifyWindow instanceof JDialog) {
            ((JDialog) closeAdmModifyWindow).dispose();
        } //end if
        
	} //closeModifyJDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == admModifyButton ) {
			System.out.println("수정 버튼 실행");
			modifyMember();
		} //end if
		
		if( source == admDeleteButton ) {
			System.out.println("삭제 버튼 실행");
			removeMember();
		} //end if
		
		if( source == admCloseButton ) {
			System.out.println("닫기 버튼 실행");
			closeModifyJDialog();
		} //end if
		
	} //actionPerformed

} //class
