//package kr.co.sist.evt;
package kr.co.sist.yj;

import javax.swing.JLabel;

public class AdminMainEvt {

	private AdminMainView mainView;
	
	private JLabel adminAccountNameTextSet;
	
	@SuppressWarnings("null")
	public AdminMainEvt() {
		this.adminAccountNameTextSet=mainView.getAdminAccountNameTextSet();
		
		AdminLoginVO loginVO = null;
		adminAccountNameTextSet.setText(loginVO.getAdmName().toString());
	} //AdminMainEvt
	
} //class