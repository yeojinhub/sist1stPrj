package kr.co.sist.kmg;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


public class PassWordChangeView extends JDialog {

    private JPanel contentPanel = new JPanel();
    private JPasswordField jpfCurrentPasswordField;
    private JPasswordField jpfNewPasswordField;
    private JPasswordField jpfConfirmPasswordField;
    
    private JButton jbtnPassChangeViewClose;
    private JButton jbtnChangePass;
    
    public PassWordChangeView() {

        setTitle("비밀번호 변경");
        
        contentPanel.setBackground(new Color(255, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel jlblCurrentPassword = new JLabel("현재 비밀번호");
        jlblCurrentPassword.setFont(new Font("Dialog", Font.BOLD, 16));
        jlblCurrentPassword.setBounds(38, 35, 130, 30);
        contentPanel.add(jlblCurrentPassword);
        
        jpfCurrentPasswordField = new JPasswordField();
        jpfCurrentPasswordField.setFont(new Font("Dialog", Font.PLAIN, 16));
        jpfCurrentPasswordField.setBounds(180, 35, 200, 30);
        contentPanel.add(jpfCurrentPasswordField);
        
        JLabel lblNewPassword = new JLabel("새 비밀번호");
        lblNewPassword.setFont(new Font("Dialog", Font.BOLD, 16));
        lblNewPassword.setBounds(38, 85, 130, 30);
        contentPanel.add(lblNewPassword);
        
        jpfNewPasswordField = new JPasswordField();
        jpfNewPasswordField.setFont(new Font("Dialog", Font.PLAIN, 16));
        jpfNewPasswordField.setBounds(180, 85, 200, 30);
        contentPanel.add(jpfNewPasswordField);
        
        JLabel lblConfirmPassword = new JLabel("비밀번호 확인");
        lblConfirmPassword.setFont(new Font("Dialog", Font.BOLD, 16));
        lblConfirmPassword.setBounds(38, 135, 130, 30);
        contentPanel.add(lblConfirmPassword);
        
        jpfConfirmPasswordField = new JPasswordField();
        jpfConfirmPasswordField.setFont(new Font("Dialog", Font.PLAIN, 16));
        jpfConfirmPasswordField.setBounds(180, 135, 200, 30);
        contentPanel.add(jpfConfirmPasswordField);
        
        // 변경 버튼
        jbtnChangePass= new JButton("변경");
        jbtnChangePass.setFont(new Font("Dialog", Font.PLAIN, 16));
        jbtnChangePass.setBounds(38, 185, 160, 40);
        contentPanel.add(jbtnChangePass);
        
        // 닫기 버튼
        jbtnPassChangeViewClose = new JButton("닫기");
        jbtnPassChangeViewClose.setFont(new Font("Dialog", Font.PLAIN, 16));
        jbtnPassChangeViewClose.setBounds(220, 185, 160, 40);
        contentPanel.add(jbtnPassChangeViewClose);
        
//		이벤트등록
        PassWordChangeViewEvt pcve=new PassWordChangeViewEvt(this);
        jbtnChangePass.addActionListener(pcve);
        jbtnPassChangeViewClose.addActionListener(pcve);
        
        setBounds(100, 100, 450, 300);
        setModal(true);  // 다른 창을 클릭할 수 없게 설정
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
    }//PassWordChangeView

//	getter
	public JPasswordField getJpfCurrentPasswordField() {
		return jpfCurrentPasswordField;
	}

	public JPasswordField getJpfNewPasswordField() {
		return jpfNewPasswordField;
	}

	public JPasswordField getJpfConfirmPasswordField() {
		return jpfConfirmPasswordField;
	}

	public JButton getJbtnPassChangeViewClose() {
		return jbtnPassChangeViewClose;
	}

	public JButton getJbtnChangePass() {
		return jbtnChangePass;
	} 
    
}//class
