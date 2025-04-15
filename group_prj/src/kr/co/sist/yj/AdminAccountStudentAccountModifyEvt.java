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

	private AdminAccountStudentAccountModifyView stuModifyView;
	
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    private JButton jbtnAdminAccountStudentAccountClose;
    
    private String selectedNum;
	
	public AdminAccountStudentAccountModifyEvt(AdminAccountStudentAccountModifyView stuModifyView) {
		this.stuModifyView=stuModifyView;
		this.jbtnAdminAccountStudentAccountModify=stuModifyView.getJbtnAdminAccountStudentAccountModify();
		this.jbtnAdminAccountStudentAccountDelete=stuModifyView.getJbtnAdminAccountStudentAccountDelete();
		this.jbtnAdminAccountStudentAccountClose=stuModifyView.getJbtnAdminAccountStudentAccountClose();
		
		selectedNum=stuModifyView.getStuNum();
		loadStuInfo(selectedNum);
	} //AdminAccountStudentAccountModifyEvt

	private void loadStuInfo(String stuNum) {
		AdminAccountStudentAccountInfoService stuService = new AdminAccountStudentAccountInfoService();
		AdminAccountStudentAccountInfoVO stuVO = stuService.searchOneStudentAccountMember(stuNum);

	        if (stuVO == null) {
	            return;
	        }

	        // View의 텍스트필드/콤보박스에 세팅
	        stuModifyView.getJtfAdminAccountStudentAccountNameSet().setText(stuVO.getStuName());
	        stuModifyView.getJpfAdminAccountStudentAccountPassSet().setText(stuVO.getStuPass());
	        stuModifyView.getJtfAdminAccountStudentAccountBirthSet().setText(stuVO.getStuBirth().toString());
	        stuModifyView.getJtfAdminAccountStudentAccountTelSet().setText(stuVO.getStuTel());
	        stuModifyView.getJtfAdminAccountStudentAccountAddressSet().setText(stuVO.getStuAdd());
	        // 과정명 콤보박스는 VO의 courName 을 선택 상태로
	        stuModifyView.getCourNameBox().setSelectedItem(stuVO.getCourName());
	        stuModifyView.getCourCardinalTextSet().setText(stuVO.getCourCardinal());
	        stuModifyView.getStuStatusTextSet().setText(stuVO.getStuStatus());
	}
	
	public void modifyMember() {
//		입력 field 값 변수에 저장
		String num = stuModifyView.getJtfAdminAccountStudentAccountIDSet().getText().trim();
		String strStudentName = stuModifyView.getJtfAdminAccountStudentAccountNameSet().getText().trim();
		char[] studentPasswordArray = stuModifyView.getJpfAdminAccountStudentAccountPassSet().getPassword();
		String strStudentPassword = new String(studentPasswordArray).trim();
		String strStudentBirth = stuModifyView.getJtfAdminAccountStudentAccountBirthSet().getText();
		Date studentBirth = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 입력 포맷에 맞게 설정
			studentBirth = (Date) sdf.parse(strStudentBirth);
		} catch (Exception e) {
			e.printStackTrace();
		} //end try catch
		String strStudentTel = stuModifyView.getJtfAdminAccountStudentAccountTelSet().getText().trim();
		String strStudentAddress = stuModifyView.getJtfAdminAccountStudentAccountAddressSet().getText().trim();
		String strStudentStatus = stuModifyView.getStuStatusTextSet().getText().trim();
		AdminAccountStudentAccountInfoVO stuVO = new AdminAccountStudentAccountInfoVO();
		
		String[] options = {"삭제", "취소"};
	    int result = JOptionPane.showOptionDialog(
	    	stuModifyView,
	        "학생 계정을 삭제 하시겠습니까?",
	        "삭제 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );

	    // JOptionPane 메세지 생성
	    if (result == 0) {
	        AdminAccountStudentAccountInfoService stuService = new AdminAccountStudentAccountInfoService();
	        boolean flag = stuService.modifyStudentAccountMember(stuVO);

	        if (flag) {
	        	// 삭제 버튼을 눌렀을 때
	        	System.out.println("수정 버튼 실행");
	            JOptionPane.showMessageDialog(stuModifyView, "학생 계정이 수정되었습니다.");
	            closeModifyDialog();
	        } else {
	        	// 삭제 오류가 났을 때
	            JOptionPane.showMessageDialog(stuModifyView, "학생 계정 수정에 실패했습니다.");
	        } //end if else
	    } else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("수정 취소 버튼 실행");
	        JOptionPane.showMessageDialog(stuModifyView, "학생 수정 삭제를 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("수정 취소 창 닫기");
	        JOptionPane.showMessageDialog(stuModifyView, "학생 수정 삭제 창을 닫았습니다.");
	    } //end if else
	} //modifyMember
	
	public void removeMember() {
		String[] options = {"삭제", "취소"};
	    int result = JOptionPane.showOptionDialog(
	    	stuModifyView,
	        "학생 계정을 삭제 하시겠습니까?",
	        "삭제 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );

	    // JOptionPane 메세지 생성
	    if (result == 0) {
	        AdminAccountStudentAccountInfoService stuService = new AdminAccountStudentAccountInfoService();
	        boolean flag = stuService.removeStudentAccountMember(selectedNum);

	        if (flag) {
	        	// 삭제 버튼을 눌렀을 때
	        	System.out.println("삭제 버튼 실행");
	            JOptionPane.showMessageDialog(stuModifyView, "학생 계정이 삭제되었습니다.");
	            closeModifyDialog();
	        } else {
	        	// 삭제 오류가 났을 때
	            JOptionPane.showMessageDialog(stuModifyView, "학생 계정 삭제에 실패했습니다.");
	        } //end if else
	    } else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("삭제 취소 버튼 실행");
	        JOptionPane.showMessageDialog(stuModifyView, "학생 계정 삭제를 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("삭제 취소 창 닫기");
	        JOptionPane.showMessageDialog(stuModifyView, "학생 계정 삭제 창을 닫았습니다.");
	    } //end if else
	} //removeMember

	public void closeModifyDialog() {
		Window adminAccountStudentAccountModifyWindow = SwingUtilities.getWindowAncestor(stuModifyView);
        if(adminAccountStudentAccountModifyWindow instanceof JDialog) {
            ((JDialog) adminAccountStudentAccountModifyWindow).dispose();
        } //end if
	} //closeModifyDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source=ae.getSource();
		
		if( source == jbtnAdminAccountStudentAccountModify ) {
			System.out.println("수정 버튼 실행");
			modifyMember();
		} //end if
		
		if( source == jbtnAdminAccountStudentAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			removeMember();
		} //end if
		
		if( source == jbtnAdminAccountStudentAccountClose ) {
			System.out.println("닫기 버튼 실행");
			closeModifyDialog();
		} //end if
		
	} //actionPerformed

} //class
