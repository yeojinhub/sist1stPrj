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
	
	private JLabel adminAccountNameTextSet;
	
	public AdminMainView() {
		super("관리자 메인");
		
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
		//로고 생성
		JLabel jlblProgramTitle = new JLabel("Best Campus");
		jlblProgramTitle.setBackground(white);
		jlblProgramTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblProgramTitle.setFont(new Font("Consolas", Font.BOLD, 28));
		jlblProgramTitle.setBounds(90, 30, 170, 30);
		
		//관리자명 생성
		JLabel jlblAdminAccountAdminAccountNameTitle = new JLabel("관리자명 : ");
		jlblAdminAccountAdminAccountNameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAdminAccountAdminAccountNameTitle.setFont(logoFont);
		jlblAdminAccountAdminAccountNameTitle.setBounds(320, 30, 100, 20);
		
		adminAccountNameTextSet = new JLabel(" ");
		adminAccountNameTextSet.setHorizontalAlignment(SwingConstants.CENTER);
		adminAccountNameTextSet.setFont(logoFont);
		adminAccountNameTextSet.setBounds(460, 30, 70, 20);
		
		JLabel jlblTitleImage = new JLabel("");
		jlblTitleImage.setBounds(10, 10, 70, 70);
		adminMainViewLogoPanel.add(jlblTitleImage);

		// #. 로고이미지 URL로 가져다쓰기
		try {
			URL imageURL = new URL("https://raw.githubusercontent.com/yeojinhub/sistFstPjr/refs/heads/main/group_prj/src/kr/co/sist/kti/logo.png");
			jlblTitleImage.setIcon(new ImageIcon(imageURL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}// end try-catch

		//Component 배치
		//로고 배치
		adminMainViewLogoPanel.add(jlblProgramTitle);
		adminMainViewLogoPanel.add(jlblAdminAccountAdminAccountNameTitle);
		adminMainViewLogoPanel.add(adminAccountNameTextSet);
		
		//JTabbedPane 생성
		JTabbedPane jtpAdminMainViewTab = new JTabbedPane();
		jtpAdminMainViewTab.setBackground(white);
		
		JPanel jpAdminAccountViewWindow = new JPanel();
		AdminAccountView aav = new AdminAccountView();
		jpAdminAccountViewWindow.add(aav.getContentPane());
		jpAdminAccountViewWindow.setBackground(white);
		
		JPanel jpAdminCourseViewWindow = new JPanel();
		AdminCourseView acv = new AdminCourseView(this);
		jpAdminCourseViewWindow.add(acv.getContentPane());
		jpAdminCourseViewWindow.setBackground(white);
		
		JPanel jpAdminExamViewWindow = new JPanel();
		AdminExamView aev = new AdminExamView(this);
		jpAdminExamViewWindow.add(aev.getContentPane());
		jpAdminExamViewWindow.setBackground(white);
		
		JPanel jpAdminGradeViewWindow = new JPanel();
		AdminGradeView agv = new AdminGradeView();
		jpAdminGradeViewWindow.add(agv.getContentPane());
		jpAdminGradeViewWindow.setBackground(white);
		
		JPanel jpAdminBoardViewWindow = new JPanel();
		AdminBoardView abv = new AdminBoardView();
		jpAdminBoardViewWindow.add(abv.getContentPane());
		jpAdminBoardViewWindow.setBackground(white);
		
		//JTabbedPane 배치
		jtpAdminMainViewTab.addTab("계정 관리", jpAdminAccountViewWindow);
		jtpAdminMainViewTab.addTab("과정 관리", jpAdminCourseViewWindow);
		jtpAdminMainViewTab.addTab("시험지 관리", jpAdminExamViewWindow);
		jtpAdminMainViewTab.addTab("성적 조회", jpAdminGradeViewWindow);
		jtpAdminMainViewTab.addTab("1:1 문의", jpAdminBoardViewWindow);
		
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
	public JLabel getAdminAccountNameTextSet() {
		return adminAccountNameTextSet;
	}
	
} //class