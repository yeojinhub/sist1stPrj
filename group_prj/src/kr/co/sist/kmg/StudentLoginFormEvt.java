//package MainLoginForm;
package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentLoginFormEvt extends WindowAdapter implements ActionListener {

	private StudentLoginForm sf;

	private String id;
	private JTextField userId;

	private String pass;
	private JTextField userPass;

	private JButton jbtnLogin;

	public StudentLoginFormEvt(StudentLoginForm sf) {
		this.sf = sf;
		this.jbtnLogin = sf.getJbtnLogin();
	}// LoginFormEvt


	public void windowClosing() {
		sf.dispose();
	}
//	윈도우 닫힘
	@Override
	public void windowClosing(WindowEvent we) {
		sf.dispose(); //dispose메소드를 사용할 수 있다.
	}//windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {

//		"로그인" 버튼이 선택되었을때 호출
		if (ae.getSource() == jbtnLogin) {
			System.out.println("로그인 버튼 실행");
            new StudentMenuView();  // Open the MenuView window
            sf.dispose();

		} // if

	}// actionPerformed
}// class
