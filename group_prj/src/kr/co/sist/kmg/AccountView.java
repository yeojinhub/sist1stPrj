package kr.co.sist.kmg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AccountView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public AccountView() {
		super("도도도님 개인정보");
		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    // Set the content pane
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Add the logo label
        JLabel jlbLogoTitle = new JLabel("Best Campus");
        jlbLogoTitle.setFont(new Font("Consolas", Font.PLAIN, 30));
        jlbLogoTitle.setBounds(310, 801, 187, 50); // Adjusted position
        contentPane.add(jlbLogoTitle);
        
        JLabel lblNewLabel = new JLabel("개 인 정 보");
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        lblNewLabel.setBounds(322, 57, 149, 55);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("도도도");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
        lblNewLabel_1.setBounds(652, 21, 62, 40);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("님");
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(726, 34, 26, 15);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("ID");
        lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3.setBounds(83, 164, 130, 30);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("비밀번호");
        lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1.setBounds(83, 203, 130, 30);
        contentPane.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("학생명");
        lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1.setBounds(83, 242, 130, 30);
        contentPane.add(lblNewLabel_3_1_1);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("생년월일");
        lblNewLabel_3_1_1_1.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_1.setBounds(83, 282, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_1);
        
        JLabel lblNewLabel_3_1_1_2 = new JLabel("전화번호");
        lblNewLabel_3_1_1_2.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_2.setBounds(83, 322, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_2);
        
        JLabel lblNewLabel_3_1_1_3 = new JLabel("주소");
        lblNewLabel_3_1_1_3.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_3.setBounds(83, 362, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_3);
        
        JLabel lblNewLabel_3_1_1_5 = new JLabel("과정명");
        lblNewLabel_3_1_1_5.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_5.setBounds(83, 442, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_5);
        
        JLabel lblNewLabel_3_1_1_7 = new JLabel("담당강사");
        lblNewLabel_3_1_1_7.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_7.setBounds(83, 522, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_7);
        
        JLabel lblNewLabel_3_1_1_7_1 = new JLabel("교육기간");
        lblNewLabel_3_1_1_7_1.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel_3_1_1_7_1.setBounds(83, 562, 130, 30);
        contentPane.add(lblNewLabel_3_1_1_7_1);
        
        textField = new JTextField();
        textField.setBounds(291, 334, 420, 30);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JTextArea textArea = new JTextArea();
        textArea.setForeground(new Color(192, 192, 192));
        textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
        textArea.setBackground(new Color(192, 192, 192));
        textArea.setText("");
        textArea.setBounds(291, 372, 420, 70);
        contentPane.add(textArea);

        // Window settings
        setBounds(100, 100, 800, 900); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close operation
        setVisible(true);  // Make the window visible
    }
}