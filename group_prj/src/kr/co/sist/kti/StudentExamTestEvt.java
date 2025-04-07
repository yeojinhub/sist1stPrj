package kr.co.sist.kti;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import kr.co.sist.kti.StudentExamVO;

public class StudentExamTestEvt extends WindowAdapter implements ActionListener {

	private StudentExamTestView setv;

	public StudentExamTestEvt(StudentExamTestView setv) {
		this.setv = setv;
	}// StudentExamTestEvt

	public void exitDialog() {
		setv.dispose();
	}// exitDialog
	
	public void submitExat(List<StudentExamVO> list) {
		int score = 0;
		
		// 1번 문제 확인
		if(setv.getJcbNo1AnswerSet().getSelectedItem().equals(String.valueOf(list.get(0).getQuesOptionCorrect()))) {
			score++;
		}
		// 2번 문제 확인
		if(setv.getJcbNo2AnswerSet().getSelectedItem().equals(String.valueOf(list.get(1).getQuesOptionCorrect()))) {
			score++;
		}
		// 3번 문제 확인
		if(setv.getJcbNo3AnswerSet().getSelectedItem().equals(String.valueOf(list.get(2).getQuesOptionCorrect()))) {
			score++;
		}
		// 4번 문제 확인
		if(setv.getJcbNo4AnswerSet().getSelectedItem().equals(String.valueOf(list.get(3).getQuesOptionCorrect()))) {
			score++;
		}
		// 5번 문제 확인
		if(setv.getJcbNo5AnswerSet().getSelectedItem().equals(String.valueOf(list.get(4).getQuesOptionCorrect()))) {
			score++;
		}
		
		// Grade 테이블에 데이터 추가를 위한 Service 객체 생성
		StudentExamService ses = new StudentExamService();
		
		// 테이블에 데이터 추가
		ses.addExamGrade(setv.getSaVO().getStuNum(), list.get(0).getExamNum(), score);
		
		String msg = setv.getSaVO().getStuName()+"학생, '"+setv.getSelectedExamName()+"'시험\n"+score+"개 맞추셨습니다.";
		JOptionPane.showMessageDialog(setv, msg);
		setv.dispose();
		
	}// submitExat
	
	public void examQuestionSetting(List<StudentExamVO> list) {
		// 과목명 라벨 셋팅
		setv.getJlblSubjectNameSet().setText(setv.getSelectedExamName());
		// 응시학생이름 라벨 셋팅
		setv.getJlblNameSet().setText(setv.getSaVO().getStuName());
		// 1번문제 셋팅
		setv.getJtaNo1TitleSet().setText(list.get(0).getQuesContent());
		setv.getJtaNo1OptionSet().setText(makeALookGoodQuestion(list.get(0).getQuesOption()).toString());
		// 2번문제 셋팅
		setv.getJtaNo2TitleSet().setText(list.get(1).getQuesContent());
		setv.getJtaNo2OptionSet().setText(makeALookGoodQuestion(list.get(1).getQuesOption()).toString());
		// 3번문제 셋팅
		setv.getJtaNo3TitleSet().setText(list.get(2).getQuesContent());
		setv.getJtaNo3OptionSet().setText(makeALookGoodQuestion(list.get(2).getQuesOption()).toString());
		// 4번문제 셋팅
		setv.getJtaNo4TitleSet().setText(list.get(3).getQuesContent());
		setv.getJtaNo4OptionSet().setText(makeALookGoodQuestion(list.get(3).getQuesOption()).toString());
		// 5번문제 셋팅
		setv.getJtaNo5TitleSet().setText(list.get(4).getQuesContent());
		setv.getJtaNo5OptionSet().setText(makeALookGoodQuestion(list.get(4).getQuesOption()).toString());
		
		// #. 스크롤 맨위에서 시작하게 만들기 (ChatGPT 도움)
		SwingUtilities.invokeLater(() -> {
		    setv.getJspExam().getViewport().setViewPosition(new Point(0, 0));
		}); // SwingUtilities
		
	}// examQuestionSetting
	
	public StringBuilder makeALookGoodQuestion(String quesOption) {
		StringBuilder sb = new StringBuilder();
		
		// 문제 보기 이쁘게 표현하는 method입니다.
		for(String str : quesOption.split(",")) {
			sb.append("\n");
			sb.append(str.trim()).append("\n");
		}// end for
		
		return sb;
	}// makeALookGoodQuestion
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setv.getJbtnExit()) {
			exitDialog();
		}// 닫기 버튼
		if (e.getSource() == setv.getJbtnSubmit()) {
			// Service 객체 생성
			StudentExamService ses = new StudentExamService();
			
			// VO List 보내서 점수 채점
			submitExat(ses.searchExamQuestion(setv.getSelectedExamName()));
		}// 제출 버튼
	}// actionPerformed

	@Override
	public void windowOpened(WindowEvent e) {
		// Service 객체 생성
		StudentExamService ses = new StudentExamService();
		
		// VO List 보내서 데이터 셋팅
		examQuestionSetting(ses.searchExamQuestion(setv.getSelectedExamName()));
	}// windowOpened
	
}// class
