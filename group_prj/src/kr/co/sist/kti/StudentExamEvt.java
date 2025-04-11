package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentGradeVO;

public class StudentExamEvt implements ActionListener {

	private StudentExamPanel sep;

	public StudentExamEvt(StudentExamPanel sep) {
		this.sep = sep;
	}// StudentExamEvt

	public void showExamScore() {
		new StudentExamScoreView(sep, (String) sep.getJcbSubjectSet().getSelectedItem(),
				sep.getJlblTeacherNameSet().getText());
	}// showExamScore

	public void startExam() {
		// 다회차 시험응시 방지 코드
		StudentExamService ses = new StudentExamService();
		StudentGradeVO sgVO = ses.searchStudentExamGrade(sep.getSaVO().getStuNum(),
				(String) sep.getJcbSubjectSet().getSelectedItem());

		if (!(sgVO.getStuNum() == null)) {
			JOptionPane.showMessageDialog(sep, "이미 치룬 시험입니다.");
			return;
		}// end if
		
		StudentExamDateVO sedVO = ses.searchExamDate((String) sep.getJcbSubjectSet().getSelectedItem());
		Date today = new Date(System.currentTimeMillis());
		
		if(sedVO.getExamDate().before(today)) {
			JOptionPane.showMessageDialog(sep, "일정이 지난 시험입니다.");
			return;
		}// end if
		
		new StudentExamTestView(sep, (String) sep.getJcbSubjectSet().getSelectedItem());
	}// startExam

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sep.getJbtnExamScore()) {
			showExamScore();
		} // 성적표 버튼

		if (e.getSource() == sep.getJbtnStartExam()) {
			startExam();
		} // 시험응시 버튼
	}// actionPerformed

}// class
