package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLoginEvt implements ActionListener {

	private StudentLoginView slv;
	
	public StudentLoginEvt(StudentLoginView slv) {
		this.slv = slv;
	}// StudentLoginEvt

	@Override
	public void actionPerformed(ActionEvent e) {
		new StudentMainView();
		slv.dispose();
	}// actionPerformed

}// class
