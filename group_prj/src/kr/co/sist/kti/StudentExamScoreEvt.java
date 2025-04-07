package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.kti.StudentGradeVO;

public class StudentExamScoreEvt extends WindowAdapter implements ActionListener {

	private StudentExamScoreView sesv;

	public StudentExamScoreEvt(StudentExamScoreView sesv) {
		this.sesv = sesv;
	}// StudentExamScoreEvt

	public void exitDialog() {
		sesv.dispose();
	}// exitDialog

	public void settingData() {
		// 학생명 라벨 셋팅
		sesv.getJlblNameSet().setText(sesv.getSaVO().getStuName());
		// 담당강사 라벨 셋팅
		sesv.getJlblTeacherNameSet().setText(sesv.getTeacherName());
		// 교육종료 라벨 셋팅
		sesv.getJlblEndCourseSet().setText(sesv.getSmVO().getCourEndDate().toString());
		// 과목 콤보박스 셋팅
		for (String str : sesv.getSmVO().getExamName()) {
			sesv.getJcbSubjectSet().addItem(str);
		} // end for
	}// settingData

	public void settingAnswerCount() {
		StudentExamService ses = new StudentExamService();

		StudentGradeVO sgVO = ses.searchStudentExamGrade(sesv.getSaVO().getStuNum(),
				(String) sesv.getJcbSubjectSet().getSelectedItem());
		// list가 null이라면 얼리리턴
		if (sgVO.getStuNum() == null) {
			sesv.getJlblMyAnswerSet().setText("미응시");
			return;
		} // end if

		// 성적표 라벨 셋팅
		sesv.getJlblMyAnswerSet().setText(sgVO.getExamAnswCount() + "/5");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sesv.getJbtnExit()) {
			exitDialog();
		}
		if (e.getSource() == sesv.getJcbSubjectSet()) {
			settingAnswerCount();
		}

	}// actionPerformed

	@Override
	public void windowOpened(WindowEvent e) {
		// Service 객체 생성
		StudentExamService ses = new StudentExamService();

		// VO 리스트에 데이터 담고
		sesv.setSgVO(ses.searchStudentExamGrade(sesv.getSaVO().getStuNum(), sesv.getSelectedExamName()));

		// 데이터 셋팅 메소드 호출!
		settingData();
	}// windowOpened

}// class
