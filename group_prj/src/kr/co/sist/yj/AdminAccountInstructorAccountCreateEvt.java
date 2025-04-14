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

public class AdminAccountInstructorAccountCreateEvt implements ActionListener {

	private AdminAccountInstructorAccountCreateView instCreateView;
	
	private JButton instCreateButton;
	private JButton instCloseButton;
	
	public AdminAccountInstructorAccountCreateEvt(AdminAccountInstructorAccountCreateView instCreateView) {
		this.instCreateView=instCreateView;
		this.instCreateButton=instCreateView.getInstCreateButton();
		this.instCloseButton=instCreateView.getInstCloseButton();
	} //AdminAccountInstructorAccountCreateEvt
	
	private void inputFieldReset() {
		
		//입력 field 초기화
		instCreateView.getInstNameTextSet().setText("");
		instCreateView.getInstPassTextSet().setText("");
		instCreateView.getInstBirthTextSet().setText("");
		instCreateView.getInstTelTextSet().setText("");
		instCreateView.getInstAddTextSet().setText("");
		
		//field focus
		instCreateView.getInstNameTextSet().requestFocus();
		
	} //inputFieldReset
	
	private void addMember() {
		
		//VO에 입력 값 저장
		AdminAccountInstructorAccountInfoVO instVO = new AdminAccountInstructorAccountInfoVO();
		instVO.setInstName( instCreateView.getInstNameTextSet().getText().trim() );
		char[] instructorPasswordArray = instCreateView.getInstPassTextSet().getPassword();
		String strStudentPassword = new String(instructorPasswordArray).trim();
		instVO.setInstPass( strStudentPassword );
		String strInstructorBirth = new String( instCreateView.getInstBirthTextSet().getText().trim() );

		if( !strInstructorBirth.isEmpty() ) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parsedDate;
			try {
				parsedDate = sdf.parse(strInstructorBirth);
				Date instructorBirthDate = new Date(parsedDate.getTime());
				instVO.setInstBirth(instructorBirthDate);
			} catch (ParseException pe) {
				pe.printStackTrace();
			} //end try catch
		} else {
			instVO.setInstBirth( null );
		} //end if else
		instVO.setInstTel( instCreateView.getInstTelTextSet().getText().trim() );
		instVO.setInstAdd( instCreateView.getInstAddTextSet().getText().trim() );
		
		String[] options = {"생성", "취소"};
	    int result = JOptionPane.showOptionDialog(
	    	instCreateView,
	        "강사 계정을 생성 하시겠습니까?",
	        "생성 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminAccountInstructorAccountInfoService instService = new AdminAccountInstructorAccountInfoService();
			boolean flag = instService.addInstructorAccountMember(instVO);
			if(flag) {
				// 생성 버튼을 눌렀을 때
				System.out.println("생성 버튼 실행");
				JOptionPane.showMessageDialog(instCreateView, "강사 계정이 생성되었습니다.");
				// 입력 field 초기화
				inputFieldReset();
				closeCreateJDialog();
			} else {
				// 생성 오류가 났을 때
				JOptionPane.showMessageDialog(instCreateView, "강사 계정 생성에 실패했습니다.");
				// 입력 field 초기화
				inputFieldReset();
			} //end if else
		}  else if (result == 1) {
	    	// 취소 버튼을 눌렀을 때
	    	System.out.println("생성 취소 버튼 실행");
	        JOptionPane.showMessageDialog(instCreateView, "강사 계정 생성을 취소하였습니다.");
	    } else if (result == -1) {
	    	// 창 닫기 버튼을 눌렀을 때
	    	System.out.println("생성 취소 창 닫기");
	        JOptionPane.showMessageDialog(instCreateView, "강사 계정 생성 창을 닫았습니다.");
	    } //end if else
		
		
	} //addMember
	
	private void closeCreateJDialog() {
		
		Window closeInstCreateWindow = SwingUtilities.getWindowAncestor(instCreateView);
		if(closeInstCreateWindow instanceof JDialog) {
			((JDialog) closeInstCreateWindow).dispose();
		} //end if
		
	} //closeModifyJDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == instCreateButton ) {
			System.out.println("생성 버튼 실행");
			addMember();
		} //end if
		
		if( source == instCloseButton ) {
			System.out.println("닫기 버튼 실행");
			closeCreateJDialog();
		} //end if
		
	} //actionPerformed

} //class
