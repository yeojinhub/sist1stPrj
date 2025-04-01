// package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//import kr.co.sist.evt.AdminMainEvt;

@SuppressWarnings("serial")
public class AdminMainView extends JFrame{
	
	private JButton jbtnAdminMainAccount;
	private JButton jbtnAdminMainCourse;
	private JButton jbtnAdminMainExam;
	private JButton jbtnAdminMainGrade;
	private JButton jbtnAdminMainBoard;
	
	public AdminMainView() {
		super("관리자 메인");
		
//		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
//
//		JPanel one= new JPanel();
//		j1 = new JTable1();
//
//		one.add(j1);
//
//		tab.addTab("기본 데이터", one);
		
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
		
//		jpWrapper.add(aav.getContentPane());  // JFrame의 ContentPane을 추가

		
		
		
//		JLabel jlbAdminViewTitle = new JLabel("베스트 캠퍼스");
//		jlbAdminViewTitle.setHorizontalAlignment(JLabel.CENTER);
//		jpAdminMainViewNorth.add(jlbAdminViewTitle);
//		
//		JLabel jlbAdminViewNameTitle = new JLabel("관리자님");
//		jlbAdminViewNameTitle.setHorizontalAlignment(JLabel.CENTER);
//		jpAdminMainViewNorth.add(jlbAdminViewNameTitle);
//		
//		JPanel jpAdminMainViewSouth = new JPanel();
//		jpAdminMainViewSouth.setLayout(new GridLayout(3, 2));
//		
//		//Component 생성
//		jbtnAdminMainAccount = new JButton("계정 관리");
//		jbtnAdminMainCourse = new JButton("과정 조회");
//		jbtnAdminMainExam = new JButton("시험 관리");
//		jbtnAdminMainGrade = new JButton("성적 조회");
//		jbtnAdminMainBoard = new JButton("1:1 문의");
//		
//		//Component 배치
//		jpAdminMainViewSouth.add(jbtnAdminMainAccount);
//		jpAdminMainViewSouth.add(jbtnAdminMainCourse);
//		jpAdminMainViewSouth.add(jbtnAdminMainExam);
//		jpAdminMainViewSouth.add(jbtnAdminMainGrade);
//		jpAdminMainViewSouth.add(jbtnAdminMainBoard);
//		jpAdminMainViewSouth.add(new JLabel(""));
//
//		//Layout 크기 설정
//		jpAdminMainViewNorth.setBorder(new EmptyBorder(20, 0, 10, 0));
//		jpAdminMainViewSouth.setBorder(new EmptyBorder(0, 20, 20, 20));
//		
//		add(jpAdminMainViewNorth, BorderLayout.NORTH );
//		add(jpAdminMainViewSouth, BorderLayout.SOUTH );
//		
//		AdminMainEvt ame=new AdminMainEvt(this);
//		jbtnAdminMainAccount.addActionListener(ame);
//		jbtnAdminMainCourse.addActionListener(ame);
//		jbtnAdminMainExam.addActionListener(ame);
//		jbtnAdminMainGrade.addActionListener(ame);
//		jbtnAdminMainBoard.addActionListener(ame);
		
//		add("North", jlbAdminViewTitle);
		
		//Window 크기 설정
		getContentPane().add(jtpAdminMainViewTab, BorderLayout.CENTER);
		setSize(500,200);
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
