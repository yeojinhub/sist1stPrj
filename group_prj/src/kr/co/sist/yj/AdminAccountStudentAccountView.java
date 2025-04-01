//package kr.co.sist.view;
package kr.co.sist.yj;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class AdminAccountStudentAccountView extends JFrame{

	public AdminAccountStudentAccountView() {
		
		//Student 계정 테이블 타이틀 생성
		String strAdminAccountViewStudentAccountTitle[] = { "학번", "이름", "전화번호", "기수", "교육과정", "교육기간", "진행상태" };
		String strAdminAccountViewStudentAccountData[][] = {
				{ "20250001", "강태일", "010-1234-5678", "25-3", "JAVA과정", "2025-01-13~2025-07-25", "진행중" },
				{ "20250002", "김민경", "010-1111-1111", "25-3", "JAVA과정", "2025-01-13~2025-07-25", "진행중" },
				{ "20250003", "이여진", "010-8241-8701", "25-3", "JAVA과정", "2025-01-13~2025-07-25", "진행중" },
				{ "20250004", "이재준", "010-0000-0000", "25-3", "JAVA과정", "2025-01-13~2025-07-25", "중도하차" },
		};
		
		//JTable 생성
		JTable jtAdminAccountViewStudentAccountTable = new JTable(strAdminAccountViewStudentAccountData, strAdminAccountViewStudentAccountTitle);
		JScrollPane spAdminAccountViewStudentAccountScroll = new JScrollPane(jtAdminAccountViewStudentAccountTable);
		
		//JTable 배치
		add(spAdminAccountViewStudentAccountScroll);
		
	} //AdminAccountStudentAccountView

} //class
