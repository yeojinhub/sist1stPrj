package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.sist.kti.StudentBoardVO;

public class StudentBoardWriteEvt implements ActionListener {

	private StudentBoardWriteView sbwv;
	private StudentBoardPanel sbp;
	
	public StudentBoardWriteEvt(StudentBoardWriteView sbwv, StudentBoardPanel sbp) {
		this.sbwv = sbwv;
		this.sbp = sbp;
	}// actionPerformed

	public void writePost() {
		// Service 객체 생성
		StudentBoardService sbs = new StudentBoardService();
		
		// 보낼 VO 객체 생성 및 데이터 추가
		StudentBoardVO sbVO = new StudentBoardVO();
		sbVO.setBoardTitle(sbwv.getJtfTitleSet().getText());
		sbVO.setBoardContent(sbwv.getJtaBoardSet().getText());
		sbVO.setStuNum(sbwv.getSaVO().getStuNum());
		sbVO.setStuName(sbwv.getSaVO().getStuName());
		
		// 작성 실행.
		sbs.addBoardPost(sbVO);
		
		// 작성 후 작성창 종료
		sbwv.dispose();
		
		// 데이터 리로드
		new StudentBoardEvt(sbp).changeBoardPanelDataSet();
	}
	
	public void exitDialog() {
		sbwv.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sbwv.getJbtnExit()) {
			exitDialog();
		}// 닫기 버튼
		if(e.getSource() == sbwv.getJbtnWrite()) {
			writePost();
		}// 작성 버튼
	}// actionPerformed

}// class
