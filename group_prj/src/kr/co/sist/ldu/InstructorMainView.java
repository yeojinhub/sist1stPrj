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

	private JTable jtaCourse, jtaStud, jtaExam, jtaScore, jtaBoard;
	private JComboBox<String> jcbSelectStatement, jcbSelectStudCourse, jcbSelectExamCourse, jcbSelectScoreCourse, jcbSelectScoreExam;
	private JButton jbtnSearch;
	private InstructorAccountVO iaVO;
	private InstructorMainViewEvt evt;

	public InstructorMainView(InstructorAccountVO iaVO) {
		super("Best Campus - 강사용");
		this.iaVO = iaVO;
		setIconImage(Toolkit.getDefaultToolkit().getImage(InstructorMainView.class.getResource("/kr/co/sist/ldu/images/logo.png")));
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 554, 625);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel jlblLogo = new JLabel("New label");
		jlblLogo.setIcon(new ImageIcon(InstructorMainView.class.getResource("/kr/co/sist/ldu/images/icon.png")));
		jlblLogo.setBounds(12, 10, 326, 39);
		getContentPane().add(jlblLogo);

		JLabel jlblInstName = new JLabel(iaVO.getInstName() + " 강사님");
		jlblInstName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblInstName.setBounds(397, 16, 130, 27);
		getContentPane().add(jlblInstName);

		JTabbedPane jtpMenu = new JTabbedPane(JTabbedPane.TOP);
		jtpMenu.setBackground(Color.WHITE);
		jtpMenu.setBounds(12, 59, 514, 517);
		getContentPane().add(jtpMenu);

		// 과정 조회 패널
		JPanel jpCourse = new JPanel(null);
		jpCourse.setBackground(Color.WHITE);
		jtpMenu.addTab("과정 조회", null, jpCourse, null);

		jcbSelectStatement = new JComboBox<>(new String[] {"전체", "강의중", "강의종료", "모집중"});
		jcbSelectStatement.setBounds(404, 10, 93, 23);
		jpCourse.add(jcbSelectStatement);

		JScrollPane jspCourse = new JScrollPane();
		jspCourse.setBounds(12, 43, 487, 435);
		jpCourse.add(jspCourse);

		jtaCourse = new JTable();
		jtaCourse.setDefaultEditor(Object.class, null);
		jspCourse.setViewportView(jtaCourse);

		// 학생 관리
		JPanel jpStud = new JPanel(null);
		jpStud.setBackground(Color.WHITE);
		jtpMenu.addTab("학생 관리", null, jpStud, null);

		jcbSelectStudCourse = new JComboBox<>(new String[] {"전체"});
		jcbSelectStudCourse.setBounds(404, 10, 93, 23);
		jpStud.add(jcbSelectStudCourse);

		JScrollPane jspStud = new JScrollPane();
		jspStud.setBounds(12, 43, 485, 435);
		jpStud.add(jspStud);

		jtaStud = new JTable();
		jtaStud.setDefaultEditor(Object.class, null);
		jspStud.setViewportView(jtaStud);

		// 시험 관리
		JPanel jpExam = new JPanel(null);
		jpExam.setBackground(Color.WHITE);
		jtpMenu.addTab("시험 관리", null, jpExam, null);

		jcbSelectExamCourse = new JComboBox<>();
		jcbSelectExamCourse.setBounds(404, 10, 93, 23);
		jpExam.add(jcbSelectExamCourse);

		JScrollPane jspExam = new JScrollPane();
		jspExam.setBounds(12, 43, 485, 423);
		jpExam.add(jspExam);

		jtaExam = new JTable();
		jtaExam.setDefaultEditor(Object.class, null);
		jspExam.setViewportView(jtaExam);

		// 성적 조회
		JPanel jpScore = new JPanel(null);
		jpScore.setBackground(Color.WHITE);
		jtpMenu.addTab("성적 조회", null, jpScore, null);

		jcbSelectScoreCourse = new JComboBox<>();
		jcbSelectScoreCourse.setBounds(186, 10, 93, 23);
		jpScore.add(jcbSelectScoreCourse);

		jcbSelectScoreExam = new JComboBox<>();
		jcbSelectScoreExam.setBounds(295, 10, 93, 23);
		jpScore.add(jcbSelectScoreExam);

		jbtnSearch = new JButton("조회");
		jbtnSearch.setBounds(400, 10, 97, 23);
		jpScore.add(jbtnSearch);

		JScrollPane jcpScore = new JScrollPane();
		jcpScore.setBounds(12, 44, 485, 434);
		jpScore.add(jcpScore);

		jtaScore = new JTable();
		jcpScore.setViewportView(jtaScore);

		// 1:1 문의
		JPanel jpBoard = new JPanel(null);
		jpBoard.setBackground(Color.WHITE);
		jtpMenu.addTab("1:1 문의", null, jpBoard, null);

		JScrollPane jspBoard = new JScrollPane();
		jspBoard.setBounds(12, 58, 485, 420);
		jpBoard.add(jspBoard);

		jtaBoard = new JTable();
		jtaBoard.setDefaultEditor(Object.class, null);
		jspBoard.setViewportView(jtaBoard);

		JLabel jlblBoardTitle = new JLabel("1:1 문의 게시판", SwingConstants.CENTER);
		jlblBoardTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblBoardTitle.setBounds(12, 10, 485, 39);
		jpBoard.add(jlblBoardTitle);
		
		InstructorMainViewEvt evt = new InstructorMainViewEvt(this);
		this.setEvt(evt);
		jcbSelectStatement.addActionListener(evt);
		jcbSelectExamCourse.addActionListener(evt);
		jcbSelectScoreCourse.addActionListener(evt);
		jbtnSearch.addActionListener(evt);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
}

	public JTable getJtaCourse() {
		return jtaCourse;
	}

	public JTable getJtaStud() {
		return jtaStud;
	}

	public JTable getJtaExam() {
		return jtaExam;
	}

	public JTable getJtaScore() {
		return jtaScore;
	}

	public JTable getJtaBoard() {
		return jtaBoard;
	}

	public JComboBox<String> getJcbSelectStatement() {
		return jcbSelectStatement;
	}

	public JComboBox<String> getJcbSelectStudCourse() {
		return jcbSelectStudCourse;
	}

	public JComboBox<String> getJcbSelectExamCourse() {
		return jcbSelectExamCourse;
	}

	public JComboBox<String> getJcbSelectScoreCourse() {
		return jcbSelectScoreCourse;
	}

	public JComboBox<String> getJcbSelectScoreExam() {
		return jcbSelectScoreExam;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}

	public InstructorAccountVO getIaVO() {
		return iaVO;
	}

	public InstructorMainViewEvt getEvt() { return evt; }
	public void setEvt(InstructorMainViewEvt evt) { this.evt = evt; }
	




	
	
	
}
