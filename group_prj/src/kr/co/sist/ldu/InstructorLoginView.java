package kr.co.sist.ldu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class InstructorLoginView {

	private JFrame frmBestCampus;
	private JTextField textField;
	private JPasswordField passwordField;

	
	/**
	 * Create the application.
	 */
	public InstructorLoginView() {
		initialize();
		System.out.println("1");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBestCampus = new JFrame();
		frmBestCampus.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\Screenshots\\스크린샷 2025-04-01 164802.png"));
		frmBestCampus.setFont(new Font("Arial", Font.BOLD, 12));
		frmBestCampus.setForeground(new Color(0, 0, 0));
		frmBestCampus.setTitle("Best Campus");
		frmBestCampus.getContentPane().setBackground(new Color(255, 255, 255));
		frmBestCampus.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(30, 196, 48, 21);
		frmBestCampus.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 227, 58, 21);
		frmBestCampus.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBounds(96, 196, 209, 21);
		frmBestCampus.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(96, 227, 209, 21);
		frmBestCampus.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(317, 196, 97, 53);
		frmBestCampus.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Screenshots\\스크린샷 2025-04-01 161817.png"));
		lblNewLabel.setBounds(57, 74, 326, 39);
		frmBestCampus.getContentPane().add(lblNewLabel);
		
		frmBestCampus.setBounds(100,100,450,300);
		frmBestCampus.setVisible(true);
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
	
}
