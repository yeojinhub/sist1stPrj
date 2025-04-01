package kr.co.sist.ldu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class StudLoginView {

	private JFrame frmBestCampus;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudLoginView window = new StudLoginView();
					window.frmBestCampus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudLoginView() {
		initialize();
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
		textField.setForeground(new Color(192, 192, 192));
		textField.setBounds(96, 196, 209, 21);
		frmBestCampus.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.TRAILING);
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
	}
}
