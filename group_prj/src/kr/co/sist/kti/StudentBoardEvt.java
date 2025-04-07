package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import kr.co.sist.kti.StudentBoardVO;
import kr.co.sist.kti.StudentMainService;

public class StudentBoardEvt extends MouseAdapter implements ActionListener {

	private StudentBoardPanel sbp;

	public StudentBoardEvt(StudentBoardPanel sbp) {
		this.sbp = sbp;
	}// StudentBoardEvt

	public void changeBoardPanelDataSet() {
		// BOARD 테이블 데이터 받아오기 위해 Main Service 객체 생성.
		StudentMainService sms = new StudentMainService();

		// 데이터 받아오는 작업.
		List<StudentBoardVO> boardList = sms.searchBoardInfo();
		int index = 1;
		// 게시판 테이블 Row값 수정
		sbp.getDtm().setRowCount(0);
		for (StudentBoardVO sbvo : boardList) {
			sbp.getDtm().addRow(new Object[] { sbvo.getBoardNum(), index++, sbvo.getBoardTitle(), sbvo.getStuName(),
					sbvo.getBoardDate(), sbvo.getBoardStatus() });
		} // end for

		// BoardPanel에 StudentBoardVO List 데이터 보내기.
		sbp.setBoardList(boardList);
	}// changeBoardPanelDataSet

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbp.getJbtnWrite()) {
			new StudentBoardWriteView(sbp);
		} // 작성 버튼
	}// actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		if (sbp.getJtBoard().getSelectedRow() == -1) {
			return;
		} // end if
		new StudentBoardReadView(sbp, (int) sbp.getJtBoard().getModel()
				.getValueAt(sbp.getJtBoard().convertRowIndexToModel(sbp.getJtBoard().getSelectedRow()), 0));
	}// mouseClicked

}// class
