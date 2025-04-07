package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentBoardVO;
import kr.co.sist.kti.StudentMainVO;
import kr.co.sist.kti.StudentBoardPanel;
import kr.co.sist.kti.StudentExamPanel;
import kr.co.sist.kti.StudentInfoPanel;

public class StudentMainEvt extends WindowAdapter implements ActionListener {

	private StudentMainView smv;
	private StudentInfoPanel sip;
	private StudentExamPanel sep;
	private StudentBoardPanel sbp;

	boolean flag;

	public StudentMainEvt(StudentMainView smv, StudentInfoPanel sip, StudentExamPanel sep, StudentBoardPanel sbp) {
		this.smv = smv;
		this.sip = sip;
		this.sep = sep;
		this.sbp = sbp;
	}// StudentMainEvt

	public void infoPanelSetting(StudentMainVO smvo) {
		// ID(학번) 라벨 수정
		sip.getJlblIDSet().setText(smv.getSaVO().getStuNum());
		// 학생명 라벨 수정
		sip.getJlblNameSet().setText(smv.getSaVO().getStuName());
		// 생년월일 라벨 수정
		sip.getJlblBirthSet().setText(smv.getSaVO().getStuBirth().toString());
		// 전화번호 텍스트필드 수정
		sip.getJftfTel().setText(smv.getSaVO().getStuTel());
		// 주소 텍스트에어리어 수정
		sip.getJtaAddress().setText(smv.getSaVO().getStuAdd());
		// 과정명 텍스트에어리어 수정
		sip.getJtaCourseNameSet().setText(smvo.getCourName());
		// 담당강사 라벨 수정
		sip.getJlblTeacherNameSet().setText(smvo.getInstName());
		// 교육종료 라벨 수정
		sip.getJlblCourseEndDateSet().setText(smvo.getCourEndDate().toString());
	}// infoPanelSetting
	
	public void examPanelSetting(StudentMainVO smvo) {
		// 학생명 라벨 수정
		sep.getJlblNameSet().setText(smv.getSaVO().getStuName());
		// 과목 콤보박스 수정
		for(String item : smvo.getExamName()) {
			sep.getJcbSubjectSet().addItem(item);
		}
		// 담당강사 라벨 수정
		sep.getJlblTeacherNameSet().setText(smvo.getInstName());
		// 교육종료 라벨 수정
		sep.getJlblEndCourseSet().setText(smvo.getCourEndDate().toString());
	}// examPanelSetting

	public void mainViewSetting(StudentMainVO smvo) {
		// 학생이름 라벨 수정
		smv.getJlblNameSet().setText(smv.getSaVO().getStuName());
		// 담당강사 라벨 수정
		smv.getJlblTeacherNameSet().setText(smvo.getInstName());
	}// mainViewSetting
	
	int index = 1;
	public void boardViewSetting(List<StudentBoardVO> boardList) {
		// 게시판 테이블 Row값 수정
		for(StudentBoardVO sbvo : boardList) {
			sbp.getDtm().addRow(new Object[] {sbvo.getBoardNum(),index++,sbvo.getBoardTitle(),sbvo.getStuName(),sbvo.getBoardDate(),sbvo.getBoardStatus()});
		}// end for
		
		// BoardPanel에 StudentBoardVO List 데이터 보내기.
		sbp.setBoardList(boardList);
	}// boardViewSetting

	@Override
	public void actionPerformed(ActionEvent e) {
		// 메뉴 열고 닫기 버튼
		if (flag) {
			smv.setSize(600, 765);
			smv.getJbtnMenuButton().setText("메뉴 닫기");
			flag = false;
			return;
		} // end if
		smv.setSize(600, 165);
		smv.getJbtnMenuButton().setText("메뉴 열기");
		flag = true;
	}// actionPerformed

	@Override
	public void windowOpened(WindowEvent e) {
		// 로그인 완료 JOptionPane
		JOptionPane.showMessageDialog(smv, "로그인 되었습니다.");
		
		// Service 객체 생성
		StudentMainService sms = new StudentMainService();

		// #-1. 개인정보패널, 시험패널에 데이터를 셋팅하기 위한 VO객체 생성
		StudentMainVO smVO = sms.searchMyCourseInfo(smv.getSaVO().getStuNum());
		// #-2. 1:1문의패널에 데이터를 셋팅하기 위한 VO객체 생성
		List<StudentBoardVO> boardList = sms.searchBoardInfo();
		// #-1-1. 메인뷰 데이터를 셋팅
		mainViewSetting(smVO);
		// #-1-2. 개인정보패널 데이터를 셋팅
		infoPanelSetting(smVO);
		// #-1-3. 시험패널 데이터를 셋팅
		examPanelSetting(smVO);
		// #-2-1. 1:1문의패널 데이터를 셋팅
		boardViewSetting(boardList);
	}// windowOpened

}// class
