//package kr.co.sist.evt;
package kr.co.sist.yj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminMainEvt {

	@SuppressWarnings("unused")
	private AdminMainView mainView;
	private AdminLoginVO loginVO;
	
	private JLabel adminAccountNameTextSet;
	
	public AdminMainEvt(AdminMainView mainView) {
		this.mainView=mainView;
		this.adminAccountNameTextSet=mainView.getAdminAccountNameTextSet();
		this.loginVO=mainView.getLoginVO();
		
		String admName = loginVO.getAdmName();
		
		// null 예외처리
		if(admName == null) {
			JOptionPane.showMessageDialog(mainView, "관리자명이 없습니다.");
		} else {
			adminAccountNameTextSet.setText(admName);
		} //end if else
		
	} //AdminMainEvt
	
} //class