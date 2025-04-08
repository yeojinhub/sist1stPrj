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
	private InstructorAccountVO iaVO;

	public InstructorMainView(InstructorAccountVO iaVO) {
		super("Best Campus - 강사용");
		this.iaVO = iaVO;
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
		
		JLabel jlblInstName = new JLabel(iaVO.getInstName() + " 강사님");
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
		jcbSelectStatement.setModel(new DefaultComboBoxModel(new String[] {"전체", "강의중", "강의종료", "모집중"}));
		jcbSelectStatement.setBounds(404, 10, 93, 23);
		jpCourse.add(jcbSelectStatement);
		
		JScrollPane jspCourse = new JScrollPane();
		jspCourse.setBounds(12, 43, 487, 435);
		jpCourse.add(jspCourse);
		
		jtaCourse = new JTable();
		jspCourse.setViewportView(jtaCourse);
		jtaCourse.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"과정명", "기간"
			}
		));
		InstructorMainViewEvt imve = new InstructorMainViewEvt(jtaCourse, jcbSelectStatement, iaVO);
		jcbSelectStatement.addActionListener(imve);
		
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
				"기수", "학생이름", "과정명", "상태"
			}
		));
		jspStud.setViewportView(jtaStud);
		
		
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
				
			},
			new String[] {
				"시험명", "날짜", "상태"
			}
		));
		jspExam.setViewportView(jtaExam);
		
		JComboBox jcbSelectExamCourse = new JComboBox();
		jcbSelectExamCourse.setModel(new DefaultComboBoxModel(new String[] {"전체", "25-1", "25-2"}));
		jcbSelectExamCourse.setBounds(404, 10, 93, 23);
		jpExam.add(jcbSelectExamCourse);
		
		imve = new InstructorMainViewEvt(
			jtaCourse,
			jcbSelectStatement,
			jtaExam,
			jcbSelectExamCourse,
			iaVO
		);
		jcbSelectStatement.addActionListener(imve);
		jcbSelectExamCourse.addActionListener(imve);
		
		
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
				
			},
			new String[] {
				"기수", "과정명", "과목명", "학생 이름", "성적"
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
		jtaBoard.setDefaultEditor(Object.class, null);
		jtaBoard.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"번호", "제목", "작성자", "작성일", "상태"
			}
		));
		jspBoard.setViewportView(jtaBoard);
		
		JLabel jlblBoardTitle = new JLabel("1:1 문의 게시판");
		jlblBoardTitle.setBackground(new Color(255, 255, 255));
		jlblBoardTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblBoardTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblBoardTitle.setBounds(12, 10, 485, 39);
		jpBoard.add(jlblBoardTitle);
		
		imve = new InstructorMainViewEvt(jtaBoard, iaVO, this);
		
		
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JTable getJtaCourse() {
		return jtaCourse;
	}

	public void setJtaCourse(JTable jtaCourse) {
		this.jtaCourse = jtaCourse;
	}

	public JTable getJtaStud() {
		return jtaStud;
	}

	public void setJtaStud(JTable jtaStud) {
		this.jtaStud = jtaStud;
	}

	public JTable getJtaExam() {
		return jtaExam;
	}

	public void setJtaExam(JTable jtaExam) {
		this.jtaExam = jtaExam;
	}

	public JTable getJtaScore() {
		return jtaScore;
	}

	public void setJtaScore(JTable jtaScore) {
		this.jtaScore = jtaScore;
	}

	public JTable getJtaBoard() {
		return jtaBoard;
	}

	public void setJtaBoard(JTable jtaBoard) {
		this.jtaBoard = jtaBoard;
	}

	public InstructorAccountVO getIaVO() {
		return iaVO;
	}

	public void setIaVO(InstructorAccountVO iaVO) {
		this.iaVO = iaVO;
	}




	
	
	
}
