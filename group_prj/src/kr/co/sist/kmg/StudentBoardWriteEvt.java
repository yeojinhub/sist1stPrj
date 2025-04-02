package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentBoardWriteEvt extends WindowAdapter implements ActionListener{

	private StudentBoardWrite sbw;
	
	private JLabel jlblStudentBoardWriteTitle;
	private JTextField jtfStudentBoardWriteContentTitle;
	private JButton jbtnStudentBoardWriteModify;
	private JButton jbbtnStudentBoardWriteClose;
	
	public StudentBoardWriteEvt(StudentBoardWrite sbw) {
		this.sbw=sbw;
		this.jbtnStudentBoardWriteModify=sbw.getJbtnStudentBoardWriteModify();
		this.jbbtnStudentBoardWriteClose=sbw.getJbbtnStudentBoardWriteClose();
		
	}//StudentBoardWriteEvt
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnStudentBoardWriteModify) {
			
		}
		if(e.getSource()==jbbtnStudentBoardWriteClose) {
			sbw.dispose();
		}

	}//actionPerformed

}//class
