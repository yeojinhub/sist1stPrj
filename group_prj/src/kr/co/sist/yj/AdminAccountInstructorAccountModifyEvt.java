package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminAccountInstructorAccountModifyEvt implements ActionListener {

	private AdminAccountInstructorAccountModifyView instModifyView;
	
	private JButton instModifyButton;
	private JButton instDeleteButton;
	private JButton instCloseButton;
	
	private String selectedInstNum;
	
	public AdminAccountInstructorAccountModifyEvt(AdminAccountInstructorAccountModifyView instModifyView){
		this.instModifyView=instModifyView;
		this.instModifyButton=instModifyView.getInstModifyButton();
		this.instDeleteButton=instModifyView.getInstDeleteButton();
		this.instCloseButton=instModifyView.getInstCloseButton();
		
		selectedInstNum = instModifyView.getStrInstNum();
		loadInstructorInfo(selectedInstNum);
	} //AdminAccountInstructorAccountModifyEvt
	
	private void loadInstructorInfo(String instNum) {
		
		AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
		AdminAccountInstructorAccountInfoVO instVO = instService.searchOneInstructorAccountMember(instNum);
		
		//객체의 값이 null일 때 예외처리
		if( instVO!=null ) {
			instModifyView.getInstNameTextSet().setText(instVO.getInstName());
			instModifyView.getInstNumTextSet().setText(instVO.getInstNum());
			instModifyView.getInstPassTextSet().setText(instVO.getInstPass());
			
			Date birthDate = instVO.getInstBirth();
			// 원하는 포맷으로 문자열 변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strbirth = sdf.format(birthDate);
			// 텍스트 필드에 세팅
			instModifyView.getInstBirthTextSet().setText(strbirth);
			
			instModifyView.getInstTelTextSet().setText(instVO.getInstTel());
			instModifyView.getInstAddTextSet().setText(instVO.getInstAdd());
		} else {
			JOptionPane.showMessageDialog(instModifyView, "강사 계정을 선택해주세요.");
		} //end if else
		
	} //loadInstructorInfo
	
	public void modifyMember() {
		//입력 field 값 변수에 저장
		String strInstNum = selectedInstNum;
		System.out.println("수정할 강사 사번 : "+selectedInstNum);
		String strInstName = instModifyView.getInstNameTextSet().getText().trim();
		char[] instructorPassArray = instModifyView.getInstPassTextSet().getPassword();
		String strInstPass = new String(instructorPassArray).trim();
		String strInstBirth = instModifyView.getInstBirthTextSet().getText();
		Date utilBirth = null;
		java.sql.Date instructorBirth = null;
		try {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    utilBirth = sdf.parse(strInstBirth);  
		    // 2) utilDate → sql.Date 변환
		    instructorBirth = new java.sql.Date(utilBirth.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} //end try catch
		String strInstTel = instModifyView.getInstTelTextSet().getText().trim();
		String strInstAdd = instModifyView.getInstAddTextSet().getText().trim();
		
		//선택된 강사 계정 VO 객체 생성 및 저장
		AdminAccountInstructorAccountInfoVO instVO = new AdminAccountInstructorAccountInfoVO();
		instVO.setInstNum(strInstNum);
		instVO.setInstName(strInstName);
		instVO.setInstPass(strInstPass);
		instVO.setInstBirth(instructorBirth);
		instVO.setInstTel(strInstTel);
		instVO.setInstAdd(strInstAdd);
		
		String[] options = {"수정", "취소"};
		int result = JOptionPane.showOptionDialog(
		        instModifyView,
		        "강사 계정을 수정 하시겠습니까?",
		        "수정 확인",
		        JOptionPane.DEFAULT_OPTION,
		        JOptionPane.WARNING_MESSAGE,
		        null,
		        options,
		        options[1]
		    );
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
			boolean flag=instService.modifyInstructorAccountMember(instVO);
			if(flag) {
				// 수정 버튼을 눌렀을 때
				System.out.println("수정 버튼 실행");
				JOptionPane.showMessageDialog(instModifyView, "강사 계정이 수정되었습니다.");
				closeModifyJDialog();
			} else {
				// 수정 오류가 났을 때
				JOptionPane.showMessageDialog(instModifyView, "강사 계정 수정에 실패했습니다.");
				closeModifyJDialog();
			} //end if else
		} else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("수정 취소 버튼 실행");
	        JOptionPane.showMessageDialog(instModifyView, "강사 계정 수정을 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("수정 취소 창 닫기");
	        JOptionPane.showMessageDialog(instModifyView, "강사 계정 수정 창을 닫았습니다.");
	    } //end if else
		
	} //modifyMember
	
	public void removeMember() {
	    String[] options = {"삭제", "취소"};
	    int result = JOptionPane.showOptionDialog(
	        instModifyView,
	        "강사 계정을 삭제 하시겠습니까?",
	        "삭제 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );

	    // JOptionPane 메세지 생성
	    if (result == 0) {
	        AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
	        boolean flag = instService.removeInstructorAccountMember(selectedInstNum);

	        if (flag) {
	        	// 삭제 버튼을 눌렀을 때
	        	System.out.println("삭제 버튼 실행");
	            JOptionPane.showMessageDialog(instModifyView, "강사 계정이 삭제되었습니다.");
	            closeModifyJDialog();
	        } else {
	        	// 삭제 오류가 났을 때
	            JOptionPane.showMessageDialog(instModifyView, "강사 계정 삭제에 실패했습니다.");
	        } //end if else
	    } else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("삭제 취소 버튼 실행");
	        JOptionPane.showMessageDialog(instModifyView, "강사 계정 삭제를 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("삭제 취소 창 닫기");
	        JOptionPane.showMessageDialog(instModifyView, "강사 계정 삭제 창을 닫았습니다.");
	    } //end if else
	} //removeMember

	
	private void closeModifyJDialog() {
		
		Window closeInstModifyWindow = SwingUtilities.getWindowAncestor(instModifyView);
		if(closeInstModifyWindow instanceof JDialog) {
			((JDialog) closeInstModifyWindow).dispose();
		} //end if
		
	} //closeModifyJDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == instModifyButton ) {
			System.out.println("수정 버튼 실행");
			modifyMember();
		} //end if
		
		if( source == instDeleteButton ) {
			System.out.println("삭제 버튼 실행");
			removeMember();
		} //end if
		
		if( source == instCloseButton ) {
			System.out.println("닫기 버튼 실행");
			closeModifyJDialog();
		} //end if
		
	} //actionPerformed

} //class
