package kr.co.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InstructorMainViewEvt implements ActionListener {
	//과정관리
	private JTable jtaCourse;
	private JComboBox jcbSelectStatement;
	//시험 관리
	private JTable jtaExam;
	private JComboBox jcbSelectExamCourse;
	
	private InstructorMainView imv;
	private InstructorMainService service;
	private InstructorAccountVO iaVO;
	//시험 전체 목록
	private List<InstructorExamVO> allExamList;
	
	private JTable jtaBoard;

	//과정 조회용 생성자 
	public InstructorMainViewEvt(JTable jtaCourse, JComboBox jcbSelectStatement, InstructorAccountVO iaVO) {
		this.jtaCourse = jtaCourse;
		this.jcbSelectStatement = jcbSelectStatement;
		this.iaVO = iaVO;
		loadCourses(); // 초기 로딩
	}
	
	//시험 관리용 생성자
	public InstructorMainViewEvt(JTable jtaCourse, JComboBox jcbSelectStatement,
			JTable jtaExam, JComboBox jcbSelectExamCourse, InstructorAccountVO iaVO) {
		this(jtaCourse, jcbSelectStatement, iaVO);
		this.jtaExam = jtaExam;
		this.jcbSelectExamCourse = jcbSelectExamCourse;
		
		this.service = new InstructorMainService();
		
		// 시험 관리 초기 세팅
		allExamList = service.getExamsByInstructor(iaVO.getInstNum());
		setExamComboBoxOptions();
		loadExamTable("전체");
	}
	
	public InstructorMainViewEvt(JTable jtaBoard, InstructorAccountVO iaVO, InstructorMainView imv) {
        this.jtaBoard = jtaBoard;
        this.iaVO = iaVO;
        this.imv = imv;
        this.service = new InstructorMainService();
        
        loadBoardList();
        addBoardClickEvent();
    }
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object src = e.getSource();
		
		if (src == jcbSelectStatement) {
			loadCourses();
		} else if (src == jcbSelectExamCourse) {
			String selectedCardinal = (String) jcbSelectExamCourse.getSelectedItem();
			loadExamTable(selectedCardinal);
		}
	}

	private void loadCourses() {
		InstructorMainService ims = new InstructorMainService();
		List<InstructorCourseVO> courseList = ims.getInstructorCourses(iaVO.getInstNum());

		String selectedStatus = (String) jcbSelectStatement.getSelectedItem();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "과정명", "기간", "상태" });
		for (InstructorCourseVO vo : courseList) {
			if (selectedStatus.equals("전체") || vo.getCourStatus().equals(selectedStatus)) {
				model.addRow(new Object[] {
					vo.getCourName(),
					vo.getCourStartDate() + " ~ " + vo.getCourEndDate(),
					vo.getCourStatus()
				});
			}
		}
		jtaCourse.setModel(model);
	}
	
	// 시험 관리 - 콤보박스 초기 세팅
	private void setExamComboBoxOptions() {
		Set<String> cardinalSet = new HashSet<>();
		for (InstructorExamVO vo : allExamList) {
			cardinalSet.add(vo.getCourCardinal());
		}

		jcbSelectExamCourse.removeAllItems();
		jcbSelectExamCourse.addItem("전체");

		for (String cardinal : cardinalSet) {
			jcbSelectExamCourse.addItem(cardinal);
		}
	}
	
	// 시험 관리 - 테이블 필터링
	private void loadExamTable(String selectedCardinal) {
		String[] columnNames = { "시험명", "날짜", "상태" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		for (InstructorExamVO vo : allExamList) {
			if (selectedCardinal.equals("전체") || vo.getCourCardinal().equals(selectedCardinal)) {
				model.addRow(new Object[] {
					vo.getExamName(),
					vo.getExamDate(),
					vo.getExamStatus()
				});
			}
		}
		jtaExam.setModel(model);
	}	
	
	
	// 게시글 목록을 테이블에 출력
	public void loadBoardList() {
	    List<InstructorBoardVO> list = service.getAllBoardList();

	    DefaultTableModel model = new DefaultTableModel(
	        new String[]{"번호", "제목", "작성자", "작성일", "상태"}, 0
	    );
	    int num =1;
	    for (InstructorBoardVO vo : list) {
	        model.addRow(new Object[]{
	            vo.getBoardNum(),
	            vo.getBoardTitle(),
	            vo.getStuName(),
	            vo.getBoardDate(),
	            vo.getBoardStatus()
	        });
	    }

	    jtaBoard.setModel(model);
	}
	
	
	// 게시글 더블클릭 시 상세 보기
	public void addBoardClickEvent() {
	    jtaBoard.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) { // 더블클릭 체크
	                int row = jtaBoard.getSelectedRow();
	                if (row == -1) {
	                    System.out.println("선택된 행 없음");
	                    return;
	                }

	                try {
	                    // 첫 번째 열(0)은 BOARD_NUM이라고 가정
	                    int boardNum = Integer.parseInt(jtaBoard.getValueAt(row, 0).toString());
	                    String boardStatus = jtaBoard.getValueAt(row, 4).toString(); // 상태 (답변대기 / 답변완료)

	                    // 게시글 정보 조회
	                    InstructorBoardVO vo = service.getBoardByNum(boardNum);
	                    if (vo == null) {
	                        System.out.println("게시글 정보 조회 실패");
	                        return;
	                    }

	                    // 창 띄우기
	                    if ("답변대기".equals(boardStatus)) {
	                        new InstructorBoardView(vo, iaVO, imv); // 댓글 작성용
	                    } else {
	                        new InstructorBoardReadView(vo); // 읽기 전용
	                    }

	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
	    });
	}



}

