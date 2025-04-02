package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;

public class StudentBoardViewEvt extends WindowAdapter implements ActionListener {

	private StudentBoardView sbv;
	private JButton jbtnStudentBoardWrite;
	private JButton jbtnStudentBoardClose;
	
	public StudentBoardViewEvt(StudentBoardView sbv) {
		this.sbv=sbv;
		this.jbtnStudentBoardWrite =sbv.getJbtnStudentBoardWrite();
		this.jbtnStudentBoardClose =sbv.getJbtnStudentBoardClose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnStudentBoardWrite) {
			new StudentBoardWrite();
		}
		if(e.getSource()==jbtnStudentBoardClose) {
			sbv.dispose();
		}
		
	}


}
