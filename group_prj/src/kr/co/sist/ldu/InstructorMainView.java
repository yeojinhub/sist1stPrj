package kr.co.sist.ldu;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class InstructorMainView extends JFrame {

	private JTable jtaCourse;
	private JTable jtaStud;
	private JTable jtaExam;
	private JTable jtaScore;
	private JTable jtaBoard;


	public InstructorMainView(InstructorLoginView ilv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InstructorMainView.class.getResource("/kr/co/sist/ldu/images/logo.png")));
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 554, 625);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel jlblLogo = new JLabel("New label");
		jlblLogo.setIcon(new ImageIcon(InstructorMainView.class.getResource("/kr/co/sist/ldu/images/icon.png")));
		jlblLogo.setBounds(12, 10, 326, 39);
		getContentPane().add(jlblLogo);
		
		JLabel jlblInstName = new JLabel("아무개 강사님");
		jlblInstName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblInstName.setBounds(397, 16, 92, 27);
		getContentPane().add(jlblInstName);
		
		JTabbedPane jtpMenu = new JTabbedPane(JTabbedPane.TOP);
		jtpMenu.setBackground(new Color(255, 255, 255));
		jtpMenu.setBounds(12, 59, 514, 517);
		getContentPane().add(jtpMenu);
		
		JPanel jpCourse = new JPanel();
		jpCourse.setBackground(new Color(255, 255, 255));
		jtpMenu.addTab("과정 조회", null, jpCourse, null);
		jpCourse.setLayout(null);
		
		JComboBox jcbSelectStatement = new JComboBox();
		jcbSelectStatement.setModel(new DefaultComboBoxModel(new String[] {"전체", "강의중", "강의종료", "강의예정"}));
		jcbSelectStatement.setBounds(404, 10, 93, 23);
		jpCourse.add(jcbSelectStatement);
		
		JScrollPane jspCourse = new JScrollPane();
		jspCourse.setBounds(10, 43, 487, 435);
		jpCourse.add(jspCourse);
		
		jtaCourse = new JTable();
		jspCourse.setViewportView(jtaCourse);
		jtaCourse.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uACFC\uC815\uBA85", "\uAE30\uAC04"
			}
		));
		
		JPanel jpStud = new JPanel();
		jpStud.setBackground(new Color(255, 255, 255));
		jtpMenu.addTab("학생 관리", null, jpStud, null);
		jpStud.setLayout(null);
		
		JComboBox jcbSelectStudCourse = new JComboBox();
		jcbSelectStudCourse.setModel(new DefaultComboBoxModel(new String[] {"전체", "25-1", "25-2"}));
		jcbSelectStudCourse.setBounds(404, 10, 93, 23);
		jpStud.add(jcbSelectStudCourse);
		
		JScrollPane jspStud = new JScrollPane();
		jspStud.setBounds(12, 43, 485, 435);
		jspStud.setBackground(new Color(255,255,255));
		jpStud.add(jspStud);
		
		jtaStud = new JTable();
		jtaStud.setModel(new DefaultTableModel(
			new Object[][] {
				{1, 2, 3, 4},
				
			},
			new String[] {
				"\uAE30\uC218", "\uD559\uC0DD \uC774\uB984", "\uACFC\uC815\uBA85", "\uC9C4\uD589 \uC0C1\uD0DC"
			}
		));
		jspStud.setViewportView(jtaStud);
		
		InstructorMainViewEvent sive = new InstructorMainViewEvent(this);
		jtaStud.addMouseListener(sive);
		
		JPanel jpExam = new JPanel();
		jpExam.setBackground(new Color(255, 255, 255));
		jtpMenu.addTab("시험 관리", null, jpExam, null);
		jpExam.setLayout(null);
		
		JScrollPane jspExam = new JScrollPane();
		jspExam.setBounds(12, 43, 485, 423);
		jpExam.add(jspExam);
		
		jtaExam = new JTable();
		jtaExam.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC2DC\uD5D8\uBA85", "\uB0A0\uC9DC", "\uC0C1\uD0DC"
			}
		));
		jspExam.setViewportView(jtaExam);
		
		JComboBox jcbSelectExamCourse = new JComboBox();
		jcbSelectExamCourse.setModel(new DefaultComboBoxModel(new String[] {"전체", "25-1", "25-2"}));
		jcbSelectExamCourse.setBounds(404, 10, 93, 23);
		jpExam.add(jcbSelectExamCourse);
		
		JPanel jpScore = new JPanel();
		jpScore.setBackground(new Color(255, 255, 255));
		jtpMenu.addTab("성적 조회", null, jpScore, null);
		jpScore.setLayout(null);
		
		JComboBox jcbSelectScoreExam = new JComboBox();
		jcbSelectScoreExam.setModel(new DefaultComboBoxModel(new String[] {"시험 과목명 선택", "Java", "Oracle"}));
		jcbSelectScoreExam.setBounds(295, 10, 93, 23);
		jpScore.add(jcbSelectScoreExam);
		
		JComboBox jcbSelectScoreCourse = new JComboBox();
		jcbSelectScoreCourse.setModel(new DefaultComboBoxModel(new String[] {"기수 선택", "25-1", "25-2"}));
		jcbSelectScoreCourse.setBounds(186, 10, 93, 23);
		jpScore.add(jcbSelectScoreCourse);
		
		JButton jbtnSearch = new JButton("조회");
		jbtnSearch.setBounds(400, 10, 97, 23);
		jpScore.add(jbtnSearch);
		
		JScrollPane jcpScore = new JScrollPane();
		jcpScore.setBounds(12, 44, 485, 434);
		jpScore.add(jcpScore);
		
		jtaScore = new JTable();
		jtaScore.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uAE30\uC218", "\uACFC\uC815\uBA85", "\uACFC\uBAA9\uBA85", "\uD559\uC0DD\uC774\uB984", "\uC131\uC801"
			}
		));
		jcpScore.setViewportView(jtaScore);
		
		JPanel jpBoard = new JPanel();
		jpBoard.setBackground(new Color(255, 255, 255));
		jtpMenu.addTab("1:1 문의", null, jpBoard, null);
		jpBoard.setLayout(null);
		
		JScrollPane jspBoard = new JScrollPane();
		jspBoard.setBounds(12, 58, 485, 420);
		jpBoard.add(jspBoard);
		
		jtaBoard = new JTable();
		jtaBoard.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uC791\uC131\uC77C", "\uC0C1\uD0DC"
			}
		));
		jspBoard.setViewportView(jtaBoard);
		
		JLabel jlblBoardTitle = new JLabel("1:1 문의 게시판");
		jlblBoardTitle.setBackground(new Color(255, 255, 255));
		jlblBoardTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblBoardTitle.setBounds(12, 10, 485, 39);
		jpBoard.add(jlblBoardTitle);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}




	public JTable getTable() {
		return jtaCourse;
	}




	public void setTable(JTable table) {
		this.jtaCourse = table;
	}




	public JTable getTable_1() {
		return jtaStud;
	}




	public void setTable_1(JTable table_1) {
		this.jtaStud = table_1;
	}




	public JTable getTable_2() {
		return jtaExam;
	}




	public void setTable_2(JTable table_2) {
		this.jtaExam = table_2;
	}




	public JTable getTable_3() {
		return jtaScore;
	}




	public void setTable_3(JTable table_3) {
		this.jtaScore = table_3;
	}




	public JTable getTable_4() {
		return jtaBoard;
	}




	public void setTable_4(JTable table_4) {
		this.jtaBoard = table_4;
	}
	
}
