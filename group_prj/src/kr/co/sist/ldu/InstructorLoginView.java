package kr.co.sist.ldu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




@SuppressWarnings("serial")
public class InstructorLoginView extends JFrame {


	private JTextField textField;
	private JPasswordField passwordField;
	private JButton jbtnLogin;

	
	public InstructorLoginView() {
		new JFrame();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\Screenshots\\스크린샷 2025-04-01 164802.png"));
		setFont(new Font("Arial", Font.BOLD, 12));
		setForeground(new Color(0, 0, 0));
		setTitle("Best Campus");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 196, 48, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 227, 58, 21);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(96, 196, 209, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(96, 227, 209, 21);
		getContentPane().add(passwordField);
		
		jbtnLogin = new JButton("Login");
		
		jbtnLogin.setFont(new Font("Arial", Font.BOLD, 12));
		jbtnLogin.setBounds(317, 196, 97, 53);
		getContentPane().add(jbtnLogin);
		
		InstructorLoginEvent ile = new InstructorLoginEvent(this);
		jbtnLogin.addActionListener(ile);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Screenshots\\스크린샷 2025-04-01 161817.png"));
		lblNewLabel.setBounds(57, 74, 326, 39);
		getContentPane().add(lblNewLabel);
		
		setBounds(100,100,450,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public void setJbtnLogin(JButton jbLogin) {
		this.jbtnLogin = jbLogin;
	}

	
	
}
