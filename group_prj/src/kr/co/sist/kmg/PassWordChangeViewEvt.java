package kr.co.sist.kmg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PassWordChangeViewEvt extends WindowAdapter implements ActionListener {

	private PassWordChangeView pcv;
	private JPasswordField jpfCurrentPasswordField;
	private JPasswordField jpfNewPasswordField;
	private JPasswordField jpfConfirmPasswordField;

	private JButton jbtnPassChangeViewClose;
	private JButton jbtnChangePass;

	public PassWordChangeViewEvt(PassWordChangeView pcv) {
		this.pcv = pcv;
		this.jbtnPassChangeViewClose = pcv.getJbtnPassChangeViewClose();
		this.jbtnChangePass = pcv.getJbtnChangePass();
		this.jpfCurrentPasswordField = pcv.getJpfCurrentPasswordField();
		this.jpfNewPasswordField = pcv.getJpfNewPasswordField();
		this.jpfConfirmPasswordField = pcv.getJpfConfirmPasswordField();
	}// PassWordChangeViewEvt

	@Override
	public void windowClosing(WindowEvent we) {
		pcv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent ae) {
//		닫기 버튼		
        if (ae.getSource() == pcv.getJbtnPassChangeViewClose()) {
            pcv.dispose();  // 창을 닫을 때
        }//end if
//		변경 버튼        
        if (ae.getSource() == pcv.getJbtnChangePass()) {
            String currentPassword = new String(jpfCurrentPasswordField.getPassword());
            String newPassword = new String(jpfNewPasswordField.getPassword());
            String confirmPassword = new String(jpfConfirmPasswordField.getPassword());

            if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(pcv, "모든 필드를 입력하세요.");
            } else if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(pcv, "새 비밀번호와 확인 비밀번호가 일치하지 않습니다.");
            } else {
                // If everything is valid, simulate the password change (in real apps, update the password in the database)
                System.out.println("비밀번호 변경됨!");
                JOptionPane.showMessageDialog(pcv, "비밀번호가 변경되었습니다.");

                // Optionally, clear the fields after successful change
                jpfCurrentPasswordField.setText("");
                jpfNewPasswordField.setText("");
                jpfConfirmPasswordField.setText("");

                // Close the dialog after success
                pcv.dispose();
            }// end if
        }//end if
    }//actionPerformed
}//class