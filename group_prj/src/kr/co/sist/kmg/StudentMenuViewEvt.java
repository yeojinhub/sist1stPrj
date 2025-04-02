package kr.co.sist.kmg;
//package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class StudentMenuViewEvt extends WindowAdapter implements ActionListener  {

	private StudentMenuView mv;
	private JButton jbtnAccount;
	private JButton jbtnTest;
	private JButton jbtnBoarder;
	
	
	public StudentMenuViewEvt(StudentMenuView mv) {
		this.mv=mv;
		this.jbtnAccount=mv.getJbtnAccount();
		this.jbtnTest=mv.getJbtnTest();
		this.jbtnBoarder=mv.getJbtnBoarder();
	}//StudentMenuViewEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()==jbtnAccount) {
			new AccountView();
		}//end if
		if(ae.getSource()==jbtnTest) {
			
		}
		if(ae.getSource()==jbtnBoarder) {
//			new StudentBoarderView();
		}
		
	}//actionPerformed

}//class
