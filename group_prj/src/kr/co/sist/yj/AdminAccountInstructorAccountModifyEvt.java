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

public class AdminAccountInstructorAccountModifyEvt implements ActionListener {

	private AdminAccountInstructorAccountModifyView aaiamView;
	
	private JButton jbtnAdminAccountInstructorAccountModify;
	private JButton jbtnAdminAccountInstructorAccountDelete;
	private JButton jbtnAdminAccountInstructorAccountClose;
	
	private String selectedInstNum;
	
	public AdminAccountInstructorAccountModifyEvt(AdminAccountInstructorAccountModifyView aaiamView){
		this.aaiamView=aaiamView;
		this.jbtnAdminAccountInstructorAccountModify=aaiamView.getJbtnAdminAccountInstructorAccountModify();
		this.jbtnAdminAccountInstructorAccountDelete=aaiamView.getJbtnAdminAccountInstructorAccountDelete();
		this.jbtnAdminAccountInstructorAccountClose=aaiamView.getJbtnAdminAccountInstructorAccountClose();
		
		selectedInstNum = aaiamView.getStrInstNum();
		loadInstructorInfo(selectedInstNum);
	} //AdminAccountInstructorAccountModifyEvt
	
	private void loadInstructorInfo(String instNum) {
		AdminAccountInstructorAccountInfoService aaiaiService = new AdminAccountInstructorAccountInfoService();
		AdminAccountInstructorAccountInfoVO aaiaiVO = aaiaiService.searchOneInstructorAccountMember(instNum);
		
		//객체의 값이 null일 때 예외처리
		if( aaiaiVO!=null ) {
			aaiamView.getJtfAdminAccountInstructorAccountNameSet().setText(aaiaiVO.getInstName());
			aaiamView.getJtfAdminAccountInstructorAccountIDSet().setText(aaiaiVO.getInstNum());
			aaiamView.getJpfAdminAccountInstructorAccountPassSet().setText(aaiaiVO.getInstPass());
			
			Date birthDate = aaiaiVO.getInstBirth();
			// 원하는 포맷으로 문자열 변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strbirth = sdf.format(birthDate);
			// 텍스트 필드에 세팅
			aaiamView.getJtfAdminAccountInstructorAccountBirthSet().setText(strbirth);
			
			aaiamView.getJtfAdminAccountInstructorAccountTelSet().setText(aaiaiVO.getInstTel());
			aaiamView.getJtfAdminAccountInstructorAccountAddressSet().setText(aaiaiVO.getInstAdd());
		} else {
			JOptionPane.showMessageDialog(aaiamView, "강사 계정을 선택해주세요.");
		} //end if else
		
	} //loadInstructorInfo
	
	public void removeMember() {
		switch(JOptionPane.showConfirmDialog(aaiamView, "강사 계정을 삭제 하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION)) {
		case JOptionPane.OK_OPTION : {
			AdminAccountInstructorAccountInfoService aaiaiService = new AdminAccountInstructorAccountInfoService();
			boolean flag=aaiaiService.removeInstructorAccountMember(selectedInstNum);
			if(flag) {
				JOptionPane.showMessageDialog(aaiamView, "강사 계정이 삭제되었습니다.");
				closeModifyJDialog();
			} else {
				JOptionPane.showMessageDialog(aaiamView, "강사 계정 삭제에 실패하였습니다.");
			} //end if else
			break;
		} //end case
		} //end switch
	} //removeMember
	
	private void closeModifyJDialog() {
		
		Window adminAccountInstructorAccountModifyWindow = SwingUtilities.getWindowAncestor(aaiamView);
		if(adminAccountInstructorAccountModifyWindow instanceof JDialog) {
			((JDialog) adminAccountInstructorAccountModifyWindow).dispose();
		} //end if
		
	} //closeModifyJDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		boolean flag = false;
		
		if( source == jbtnAdminAccountInstructorAccountModify ) {
			System.out.println("수정 버튼 실행");
			
			//입력 field 값 변수에 저장
			String strInstNum = aaiamView.getJtfAdminAccountInstructorAccountNameSet().getText().trim();
			String strInstName = aaiamView.getJtfAdminAccountInstructorAccountNameSet().getText().trim();
			char[] instructorPassArray = aaiamView.getJpfAdminAccountInstructorAccountPassSet().getPassword();
			String strInstPass = new String(instructorPassArray).trim();
			String strInstBirth = aaiamView.getJtfAdminAccountInstructorAccountBirthSet().getText();
			Date instructorBirth = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 입력 포맷에 맞게 설정
				instructorBirth = (Date) sdf.parse(strInstBirth);
			} catch (Exception e) {
				e.printStackTrace();
			} //end try catch
			String strInstTel = aaiamView.getJtfAdminAccountInstructorAccountTelSet().getText().trim();
			String strInstAdd = aaiamView.getJtfAdminAccountInstructorAccountAddressSet().getText().trim();
			
			//선택된 강사 계정 VO 객체 생성 및 저장
			AdminAccountInstructorAccountInfoVO aaiaiVO = new AdminAccountInstructorAccountInfoVO();
			aaiaiVO.setInstNum(strInstNum);
			aaiaiVO.setInstName(strInstName);
			aaiaiVO.setInstPass(strInstPass);
			aaiaiVO.setInstBirth(instructorBirth);
			aaiaiVO.setInstTel(strInstTel);
			aaiaiVO.setInstAdd(strInstAdd);
			
			AdminAccountInstructorAccountInfoService aaiaiService = new AdminAccountInstructorAccountInfoService();
			flag=aaiaiService.modifyInstructorAccountMember(aaiaiVO);
			if(flag) {
				JOptionPane.showMessageDialog(aaiamView, "강사 계정이 수정되었습니다.");
				closeModifyJDialog();
			} else {
				JOptionPane.showMessageDialog(aaiamView, "강사 계정 수정에 실패하였습니다.");
			} //end if else
		} //end if
		
		if( source == jbtnAdminAccountInstructorAccountDelete ) {
			System.out.println("삭제 버튼 실행");
			removeMember();
		} //end if
		
		if( source == jbtnAdminAccountInstructorAccountClose ) {
			System.out.println("닫기 버튼 실행");
			closeModifyJDialog();
		} //end if
		
	} //actionPerformed

} //class
