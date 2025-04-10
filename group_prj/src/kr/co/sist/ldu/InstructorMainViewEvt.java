package kr.co.sist.ldu;

import java.awt.event.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InstructorMainViewEvt implements ActionListener, WindowListener {
	private InstructorMainView imv;
	private InstructorMainService service;
	private InstructorAccountVO iaVO;
	private List<InstructorExamVO> allExamList;

	public InstructorMainViewEvt(InstructorMainView imv) {
		this.imv = imv;
		this.iaVO = imv.getIaVO();
		this.service = new InstructorMainService();

		// 이벤트 리스너 등록
		addListeners();
		imv.addWindowListener(this); // WindowOpened 이벤트 연결
	}

	private void addListeners() {
		imv.getJcbSelectStatement().addActionListener(this);
		imv.getJcbSelectExamCourse().addActionListener(this);
		imv.getJcbSelectScoreCourse().addActionListener(this);
		imv.getJbtnSearch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == imv.getJcbSelectStatement()) {
			loadCourses();
		} else if (src == imv.getJcbSelectExamCourse()) {
			loadExamTable((String) imv.getJcbSelectExamCourse().getSelectedItem());
		} else if (src == imv.getJcbSelectScoreCourse()) {
			String selectedCardinal = (String) imv.getJcbSelectScoreCourse().getSelectedItem();
			loadScoreExamsByCardinal(selectedCardinal);
		} else if (src == imv.getJbtnSearch()) {
			String selectedCardinal = (String) imv.getJcbSelectScoreCourse().getSelectedItem();
			String selectedExam = (String) imv.getJcbSelectScoreExam().getSelectedItem();
			loadScoreTable(selectedCardinal, selectedExam);
		}  else if (src == imv.getJcbSelectStudCourse()) {
		    String selectedCardinal = (String) imv.getJcbSelectStudCourse().getSelectedItem();
		    loadStudentTable(selectedCardinal);
		}
	}

	// 초기화 로직을 WindowOpened로 이동
	@Override
	public void windowOpened(WindowEvent e) {
		this.allExamList = service.getExamsByInstructor(iaVO.getInstNum());
		setExamComboBoxOptions();
		loadExamTable("전체");
		loadCourses();
		loadScoreCardinals();
		loadScoreTable("전체", "전체");
		loadBoardList();
		addBoardClickEvent();
		loadStudentCardinals();
	    loadStudentTable("전체");
	    addStudentClickEvent();
	}

	// 불필요한 WindowListener 메서드 구현
	@Override public void windowClosing(WindowEvent e) {}
	@Override public void windowClosed(WindowEvent e) {}
	@Override public void windowIconified(WindowEvent e) {}
	@Override public void windowDeiconified(WindowEvent e) {}
	@Override public void windowActivated(WindowEvent e) {}
	@Override public void windowDeactivated(WindowEvent e) {}

	//과정 조회
	private void loadCourses() {
		List<InstructorCourseVO> courseList = service.getInstructorCourses(iaVO.getInstNum());
		String selectedStatus = (String) imv.getJcbSelectStatement().getSelectedItem();

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "과정명", "기간", "상태" });
		for (InstructorCourseVO vo : courseList) {
			if ("전체".equals(selectedStatus) || vo.getCourStatus().equals(selectedStatus)) {
				model.addRow(new Object[] {
					vo.getCourName(),
					vo.getCourStartDate() + " ~ " + vo.getCourEndDate(),
					vo.getCourStatus()
				});
			}
		}
		imv.getJtaCourse().setModel(model);
	}
	
	//전체 학생 목록 테이블
	private void loadStudentTable(String cardinal) {
	    List<InstructorStudentVO> list;
	    if ("전체".equals(cardinal)) {
	        list = service.getAllStudentsByInstructor(iaVO.getInstNum());
	    } else {
	        list = service.getStudentsByCardinal(iaVO.getInstNum(), cardinal);
	    }

	    DefaultTableModel model = new DefaultTableModel(new String[] {
	        "기수", "학생 이름", "과정명", "진행 상태","학생 번호"
	    }, 0);

	    for (InstructorStudentVO vo : list) {
	        model.addRow(new Object[] {
	            vo.getCourCardinal(),
	            vo.getStudName(),
	            vo.getCourName(),
	            vo.getStuStatus(),
	            vo.getStudNum()
	        });
	    }

	    imv.getJtaStud().setModel(model);
	    
	    imv.getJtaStud().getColumnModel().getColumn(4).setMinWidth(0);
	    imv.getJtaStud().getColumnModel().getColumn(4).setMaxWidth(0);
	    imv.getJtaStud().getColumnModel().getColumn(4).setWidth(0);
	}


	//학생 관리 콤보박스 세팅
	private void loadStudentCardinals() {
	    List<String> cardinals = service.getCardinalsByInstructor(iaVO.getInstNum());

	    JComboBox<String> cb = imv.getJcbSelectStudCourse();
	    cb.removeAllItems();
	    cb.addItem("전체");
	    for (String c : cardinals) {
	        cb.addItem(c);
	    }
	}

	
	//시험 관리 테이블 콤보 박스
	private void setExamComboBoxOptions() {
		Set<String> cardinalSet = new HashSet<>();
		for (InstructorExamVO vo : allExamList) {
			cardinalSet.add(vo.getCourCardinal());
		}
		JComboBox<String> cb = imv.getJcbSelectExamCourse();
		cb.removeAllItems();
		cb.addItem("전체");
		for (String c : cardinalSet) {
			cb.addItem(c);
		}
	}

	//시험 관리 테이블
	private void loadExamTable(String selectedCardinal) {
		String[] columnNames = { "시험명", "날짜", "상태" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		for (InstructorExamVO vo : allExamList) {
			if ("전체".equals(selectedCardinal) || vo.getCourCardinal().equals(selectedCardinal)) {
				model.addRow(new Object[] { vo.getExamName(), vo.getExamDate(), vo.getExamStatus() });
			}
		}
		imv.getJtaExam().setModel(model);
	}

	//성적 관리에서 과정 기수
	private void loadScoreCardinals() {
		List<String> cardinals = service.getCardinalsByInstructor(iaVO.getInstNum());
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("전체");
		for (String c : cardinals) {
			model.addElement(c);
		}
		imv.getJcbSelectScoreCourse().setModel(model);

		DefaultComboBoxModel<String> examModel = new DefaultComboBoxModel<>();
		examModel.addElement("전체");
		imv.getJcbSelectScoreExam().setModel(examModel);
	}

	//성적 관리에서 시험명
	private void loadScoreExamsByCardinal(String cardinal) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		model.addElement("전체");
		if (cardinal != null && !"전체".equals(cardinal)) {
			List<String> examNames = service.getExamNamesByCardinal(cardinal);
			for (String name : examNames) {
				model.addElement(name);
			}
		}
		imv.getJcbSelectScoreExam().setModel(model);
	}

	//성적 테이블
	private void loadScoreTable(String cardinal, String examName) {
		List<InstructorScoreVO> scores = service.getScores(iaVO.getInstNum(), cardinal, examName);
		String[] columns = { "기수", "과정명", "과목명", "학생이름", "정답 수" };
		DefaultTableModel model = new DefaultTableModel(columns, 0);
		for (InstructorScoreVO vo : scores) {
			model.addRow(new Object[] {
				vo.getCourCardinal(), vo.getCourName(), vo.getExamName(), vo.getStudName(), vo.getScore()
			});
		}
		imv.getJtaScore().setModel(model);
	}

	
	//게시글
	public void loadBoardList() {
		List<InstructorBoardVO> list = service.getAllBoardList();
		DefaultTableModel model = new DefaultTableModel(new String[] { "번호", "제목", "작성자", "작성일", "상태" }, 0);
		for (InstructorBoardVO vo : list) {
			model.addRow(new Object[] {
				vo.getBoardNum(), vo.getBoardTitle(), vo.getStuName(), vo.getBoardDate(), vo.getBoardStatus()
			});
		}
		imv.getJtaBoard().setModel(model);
	}

	//게시글 클릭 이벤트
	public void addBoardClickEvent() {

	    imv.getJtaBoard().addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                int row = imv.getJtaBoard().getSelectedRow();
	                if (row == -1) return;

	                try {
	                    int boardNum = Integer.parseInt(imv.getJtaBoard().getValueAt(row, 0).toString());
	                    String status = imv.getJtaBoard().getValueAt(row, 4).toString();
	                    InstructorBoardVO vo = service.getBoardByNum(boardNum);
	                    if (vo == null) return;

	                    if ("답변대기".equals(status)) {
	                        new InstructorBoardView(vo, iaVO, imv).setVisible(true);
	                    } else {
	                        new InstructorBoardReadView(vo).setVisible(true);
	                    }

	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
	    });

	}

	//학생 클릭 이벤트
	public void addStudentClickEvent() {
		imv.getJtaStud().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = imv.getJtaStud().getSelectedRow();
					if (row == -1) return;

					try {
						String courCardinal = imv.getJtaStud().getValueAt(row, 0).toString(); // 기수
						String stuNum = imv.getJtaStud().getValueAt(row, 4).toString(); // ✅ 학생 번호 (5번째 열)

						InstructorStudentVO studentVO = service.getStudentByNumAndCardinal(stuNum, courCardinal);
						if (studentVO == null) {
							JOptionPane.showMessageDialog(imv, "학생 정보를 찾을 수 없습니다.");
							return;
						}

						ShowStudScoretoInstructorView popup = new ShowStudScoretoInstructorView(iaVO, studentVO);
						popup.setModal(true);
						popup.setVisible(true);

					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(imv, "학생 정보 조회 중 오류 발생");
					}
				}
			}
		});
	}


	
}


