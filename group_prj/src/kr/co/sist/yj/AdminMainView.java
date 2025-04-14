// package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminMainView extends JFrame{
	
	private AdminLoginVO loginVO;
	
	private JLabel adminAccountNameTextSet;
	
	public AdminMainView(AdminLoginVO loginVO) {
		this.loginVO=loginVO;
		
		//디자인(색깔,글씨) 설정
		Color white = new Color(255,255,255);
		Font logoFont = new Font("맑은 고딕", Font.PLAIN, 18);
		
		//최상위 Panel 생성
		JPanel adminMainViewPanel = new JPanel(new BorderLayout());
		adminMainViewPanel.setBackground(white);
	    setContentPane(adminMainViewPanel);
		
		//Main Panel 생성
		JPanel adminMainViewLogoPanel = new JPanel();
		adminMainViewLogoPanel.setBackground(white);
		adminMainViewLogoPanel.setLayout(null);
		adminMainViewLogoPanel.setPreferredSize(new Dimension(800, 80));
		
		//Component 생성
		//로고 이미지 생성
		JLabel jlblTitleImage = new JLabel("");
		jlblTitleImage.setBounds(10, 10, 70, 70);
		adminMainViewLogoPanel.add(jlblTitleImage);
		
		//로고 이미지 삽입
		try {
			URL imageURL = new URL("https://raw.githubusercontent.com/yeojinhub/sistFstPjr/refs/heads/main/group_prj/src/kr/co/sist/kti/logo.png");
			jlblTitleImage.setIcon(new ImageIcon(imageURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}// end try-catch
		
		//관리자명 타이틀 생성
		JLabel jlblAdminAccountAdminAccountNameTitle = new JLabel("관리자명 : ");
		jlblAdminAccountAdminAccountNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAdminAccountAdminAccountNameTitle.setFont(logoFont);
		jlblAdminAccountAdminAccountNameTitle.setBounds(320, 30, 100, 20);
		
		//관리자명 텍스트 생성
		adminAccountNameTextSet = new JLabel("");
		adminAccountNameTextSet.setHorizontalAlignment(SwingConstants.CENTER);
		adminAccountNameTextSet.setFont(logoFont);
		adminAccountNameTextSet.setBounds(460, 30, 70, 20);
		
		//관리자명 이벤트 생성
		new AdminMainEvt(this);
		
		//로고 타이틀 생성
		JLabel jlblProgramTitle = new JLabel("Best Campus");
		jlblProgramTitle.setBackground(white);
		jlblProgramTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblProgramTitle.setFont(new Font("Consolas", Font.BOLD, 28));
		jlblProgramTitle.setBounds(90, 30, 170, 30);

		//Component 배치
		//로고 배치
		adminMainViewLogoPanel.add(jlblProgramTitle);
		adminMainViewLogoPanel.add(jlblAdminAccountAdminAccountNameTitle);
		adminMainViewLogoPanel.add(adminAccountNameTextSet);
		
		//JTabbedPane 생성
		JTabbedPane jtpAdminMainViewTab = new JTabbedPane();
		jtpAdminMainViewTab.setBackground(white);
		
		//계정관리 View 추가
		JPanel accountViewPanel = new JPanel();
		AdminAccountView accountView = new AdminAccountView();
		accountViewPanel.add(accountView.getContentPane());
		accountViewPanel.setBackground(white);
		
		//과정조회 View 추가
		JPanel courseViewPanel = new JPanel();
		AdminCourseView courseView = new AdminCourseView(this);
		courseViewPanel.add(courseView.getContentPane());
		courseViewPanel.setBackground(white);
		
		//시험관리 View 추가
		JPanel examViewPanel = new JPanel();
		AdminExamView examView = new AdminExamView(this);
		examViewPanel.add(examView.getContentPane());
		examViewPanel.setBackground(white);
		
		//성적조회 View 추가
		JPanel gradeViewPanel = new JPanel();
		AdminGradeView gradeView = new AdminGradeView();
		gradeViewPanel.add(gradeView.getContentPane());
		gradeViewPanel.setBackground(white);
		
		//1:1문의 View 추기
		JPanel boardViewPanel = new JPanel();
		AdminBoardView boardView = new AdminBoardView(this);
		boardViewPanel.add(boardView.getContentPane());
		boardViewPanel.setBackground(white);
		
		//JTabbedPane 배치
		jtpAdminMainViewTab.addTab("계정 관리", accountViewPanel);
		jtpAdminMainViewTab.addTab("과정 관리", courseViewPanel);
		jtpAdminMainViewTab.addTab("시험 관리", examViewPanel);
		jtpAdminMainViewTab.addTab("성적 조회", gradeViewPanel);
		jtpAdminMainViewTab.addTab("1:1 문의", boardViewPanel);
		
		//Panel 배치
		adminMainViewPanel.add(adminMainViewLogoPanel, BorderLayout.NORTH);
		adminMainViewPanel.add(jtpAdminMainViewTab, BorderLayout.CENTER);
		
		//Window 크기 설정
		setSize(750,710);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} //AdminMainView

	//getter method
	public AdminLoginVO getLoginVO() {
		return loginVO;
	}
	
	public JLabel getAdminAccountNameTextSet() {
		return adminAccountNameTextSet;
	}
	
} //class