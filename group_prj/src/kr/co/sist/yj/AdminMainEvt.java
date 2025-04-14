//package kr.co.sist.evt;
package kr.co.sist.yj;

import javax.swing.JLabel;

public class AdminMainEvt {

	@SuppressWarnings("unused")
	private AdminMainView mainView;
	
	private JLabel adminAccountNameTextSet;
	
	public AdminMainEvt(AdminMainView mainView) {
		this.mainView=mainView;
		this.adminAccountNameTextSet=mainView.getAdminAccountNameTextSet();
		
		AdminLoginVO loginVO = new AdminLoginVO();
		adminAccountNameTextSet.setText(loginVO.getAdmName().toString());
	} //AdminMainEvt
	
} //class