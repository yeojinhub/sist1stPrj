package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentExamEvt implements ActionListener {

	private StudentExamPanel sep;
	
	public StudentExamEvt(StudentExamPanel sep) {
		this.sep = sep;
	}// StudentExamEvt
	
	public void showExamScore() {
		new StudentExamScoreView(sep);
	}// showExamScore
	
	public void startExam() {
		new StudentExamTestView(sep, (String) sep.getJcbSubjectSet().getSelectedItem());
	}// startExam

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sep.getJbtnExamScore()) {
			showExamScore();
		}// 성적표 버튼
		
		if (e.getSource() == sep.getJbtnStartExam()) {
			startExam();
		}// 시험응시 버튼
	}// actionPerformed

}// class
