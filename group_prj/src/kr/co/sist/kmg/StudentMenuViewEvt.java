//package MainLoginForm;
package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class StudentMenuViewEvt extends WindowAdapter implements ActionListener  {

	private StudentMenuView mv;
	private JButton jbtnAccount;
	
	
	public StudentMenuViewEvt(StudentMenuView mv) {
		this.mv=mv;
		this.jbtnAccount=mv.getJbtnAccount();
		
		this.jbtnAccount.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		if(ae.getSource()==jbtnAccount) {
			new AccountView();
		}//end if
	}//actionPerformed

}//class
