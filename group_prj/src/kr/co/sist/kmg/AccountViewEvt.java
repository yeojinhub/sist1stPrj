package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class AccountViewEvt extends WindowAdapter implements ActionListener {

	private AccountView av;
	private JButton jbtnAccountClose;
	private JButton jbtnModification;
	private JButton jbtnPassChange;

	public AccountViewEvt(AccountView av) {
		this.av = av;
		this.jbtnPassChange=av.getJbtnPassChange();
		this.jbtnAccountClose=av.getJbtnAccountClose();
		this.jbtnModification = av.getJbtnModification();
	}// AccountViewEvt
	
// 윈도우 종료
	@Override
	public void windowClosing(WindowEvent we) {
		av.dispose();
	}
//	액션리슨
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbtnAccountClose) {
			av.dispose();
		} //end if
		if (ae.getSource() == jbtnModification) {
			String address = av.getJtaAdressText().getText();
			String phoneNumber = av.getJtfTelText().getText();
			
            System.out.println("주소: " + address);
            System.out.println("전화번호: " + phoneNumber);

			av.getJtaAdressText().setText(address);
			av.getJtfTelText().setText(phoneNumber);  
			
			System.out.println("정보가 저장되었습니다.");
		}//end if
		
		if(ae.getSource() == jbtnPassChange) {
			System.out.println("비밀번호변경 버튼이 눌림");
			new PassWordChangeView().setVisible(true);
		}

	}//actionPerformed

}//class
 