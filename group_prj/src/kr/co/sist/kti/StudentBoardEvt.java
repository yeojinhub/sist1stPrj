package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentBoardEvt extends MouseAdapter implements ActionListener {

	private StudentBoardPanel sbp;
	
	public StudentBoardEvt(StudentBoardPanel sbp) {
		this.sbp = sbp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sbp.getJbtnWrite()) {
			new StudentBoardWriteView();
		}// 작성 버튼
	}// actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		// # 기능 미구현
		new StudentBoardReadView();
	}// mouseClicked

}// class
