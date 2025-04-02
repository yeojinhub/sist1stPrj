// package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class AdminMainView extends JFrame{
	
	private JButton jbtnAdminMainAccount;
	private JButton jbtnAdminMainCourse;
	private JButton jbtnAdminMainExam;
	private JButton jbtnAdminMainGrade;
	private JButton jbtnAdminMainBoard;
	
	public AdminMainView() {
		super("관리자 메인");
		
		JTabbedPane jtpAdminMainViewTab = new JTabbedPane();
//		JTabbedPane jtpAdminMainViewWIndow = new JTabbedPane(JTabbedPane.TOP);
		
		//JPanel 생성
		JPanel jpAdminAccountViewWindow = new JPanel();
		AdminAccountView aav = new AdminAccountView();
		
		JPanel jpAdminCourseViewWindow = new JPanel();
		AdminCourseView acv = new AdminCourseView();
		
		jpAdminAccountViewWindow.add(aav.getContentPane());
		jpAdminCourseViewWindow.add(acv.getContentPane());
		
		jtpAdminMainViewTab.addTab("계정 관리", jpAdminAccountViewWindow);
		jtpAdminMainViewTab.addTab("과정 조회", jpAdminCourseViewWindow);
		
		//Window 크기 설정
		getContentPane().add(jtpAdminMainViewTab, BorderLayout.CENTER);
		setSize(1150,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} //AdminMainView

	public JButton getJbtnAdminMainAccount() {
		return jbtnAdminMainAccount;
	} //getJbtnAdminMainAccount

	public JButton getJbtnAdminMainCourse() {
		return jbtnAdminMainCourse;
	} //getJbtnAdminMainCourse

	public JButton getJbtnAdminMainExam() {
		return jbtnAdminMainExam;
	} //getJbtnAdminMainExam

	public JButton getJbtnAdminMainGrade() {
		return jbtnAdminMainGrade;
	} //getJbtnAdminMainGrade

	public JButton getJbtnAdminMainBoard() {
		return jbtnAdminMainBoard;
	} //getJbtnAdminMainBoard
	
	public static void main(String[] args) {
		new AdminMainView();
	}
	
} //class