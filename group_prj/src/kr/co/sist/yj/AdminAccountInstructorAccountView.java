//package kr.co.sist.view;
package kr.co.sist.yj;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class AdminAccountInstructorAccountView extends JFrame{

	public AdminAccountInstructorAccountView() {
		//Student 계정 테이블 타이틀 생성
		String strAdminAccountViewInstructorAccountTitle[] = { "사번", "이름", "전화번호" };
		String strAdminAccountViewInstructorAccountData[][] = {
				{ "20250001", "곽우신", "010-1234-5678" },
		};
		
		//JTable 생성
		JTable jtAdminAccountViewInstructorAccountTable = new JTable(strAdminAccountViewInstructorAccountData, strAdminAccountViewInstructorAccountTitle);
		JScrollPane spAdminAccountViewInstructorAccountScroll = new JScrollPane(jtAdminAccountViewInstructorAccountTable);
		
		//JTable 배치
		add(spAdminAccountViewInstructorAccountScroll);
		
	} //AdminAccountInstructorAccountView
	
} //class
