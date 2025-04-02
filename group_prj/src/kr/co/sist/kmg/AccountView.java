package kr.co.sist.kmg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class AccountView extends JFrame {

	private JPanel contentPane;
	
	private JLabel jlblPersonal;
	private JLabel jlblUserName;
	private JTextArea jtaAdressText;
	
	private JButton jbtnPassChange;
	private JButton jbtnModification;
	private JButton jbtnAccountClose;
	private JTextField JtfTelText;
	
	public AccountView() {
		super("도도도님 개인정보");
		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jlbLogoTitle = new JLabel("Best Campus");
        jlbLogoTitle.setFont(new Font("Consolas", Font.PLAIN, 30));
        jlbLogoTitle.setBounds(300, 803, 200, 50); // Adjusted position
        contentPane.add(jlbLogoTitle);
        
        jlblPersonal = new JLabel("개 인 정 보");
        jlblPersonal.setFont(new Font("Dialog", Font.BOLD, 30));
        jlblPersonal.setBounds(322, 57, 149, 55);
        contentPane.add(jlblPersonal);
        
        jlblUserName = new JLabel("도도도");
        jlblUserName.setFont(new Font("굴림", Font.BOLD, 20));
        jlblUserName.setBounds(652, 21, 62, 40);
        contentPane.add(jlblUserName);
        
        JLabel jlblNim = new JLabel("님");
        jlblNim.setFont(new Font("Dialog", Font.PLAIN, 15));
        jlblNim.setBounds(726, 34, 26, 15);
        contentPane.add(jlblNim);
//		라벨        
        JLabel jlblID = new JLabel("ID");
        jlblID.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblID.setBounds(93, 139, 130, 30);
        contentPane.add(jlblID);
        
        JLabel jlblPassword = new JLabel("비밀번호");
        jlblPassword.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblPassword.setBounds(93, 194, 130, 30);
        contentPane.add(jlblPassword);
        
        JLabel jlblUserName = new JLabel("학생명");
        jlblUserName.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblUserName.setBounds(93, 249, 130, 30);
        contentPane.add(jlblUserName);
        
        JLabel lblBirth = new JLabel("생년월일");
        lblBirth.setFont(new Font("Dialog", Font.BOLD, 25));
        lblBirth.setBounds(93, 304, 130, 30);
        contentPane.add(lblBirth);
        
        JLabel jlblTel = new JLabel("전화번호");
        jlblTel.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblTel.setBounds(93, 359, 130, 30);
        contentPane.add(jlblTel);
        
        JLabel jlbladdress = new JLabel("주소");
        jlbladdress.setFont(new Font("Dialog", Font.BOLD, 25));
        jlbladdress.setBounds(93, 414, 130, 30);
        contentPane.add(jlbladdress);
        
        JLabel jlblCourse = new JLabel("과정명");
        jlblCourse.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblCourse.setBounds(93, 514, 130, 30);
        contentPane.add(jlblCourse);
        
        JLabel jlblInstructor = new JLabel("담당강사");
        jlblInstructor.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblInstructor.setBounds(93, 569, 130, 30);
        contentPane.add(jlblInstructor);
        
        JLabel jlblPeriod = new JLabel("교육기간");
        jlblPeriod.setFont(new Font("Dialog", Font.BOLD, 25));
        jlblPeriod.setBounds(93, 624, 130, 30);
        contentPane.add(jlblPeriod);
        
//		작성하는 곳        
        jtaAdressText = new JTextArea();
        jtaAdressText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jtaAdressText.setBackground(new Color(255, 255, 255));
        jtaAdressText.setBounds(294, 416, 420, 70);
        jtaAdressText.setBorder(new LineBorder(Color.GRAY));
        contentPane.add(jtaAdressText);
        
        JLabel jlbIDText = new JLabel("2025_0001");
        jlbIDText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlbIDText.setBounds(294, 139, 420, 35);
        contentPane.add(jlbIDText);
        
        JLabel jlbIStudentText = new JLabel("도도도");
        jlbIStudentText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlbIStudentText.setBounds(294, 249, 420, 35);
        contentPane.add(jlbIStudentText);
        
        JLabel jlblBirthText = new JLabel("2000-09-01");
        jlblBirthText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlblBirthText.setBounds(294, 304, 420, 35);
        contentPane.add(jlblBirthText);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(294, 514, 420, 35);
        contentPane.add(comboBox);
        
        JLabel jlblInstructorText=new JLabel("오감자");
        jlblInstructorText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlblInstructorText.setBounds(294, 569, 420, 35);
        contentPane.add(jlblInstructorText);
        
        JLabel jlblStartText = new JLabel("2025_0001");
        jlblStartText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlblStartText.setBounds(294, 624, 185, 35);
        contentPane.add(jlblStartText);
        
        jbtnPassChange = new JButton("비밀번호변경");
        jbtnPassChange.setBackground(new Color(135, 172, 241));
        jbtnPassChange.setFont(new Font("Dialog", Font.PLAIN, 25));
        jbtnPassChange.setBounds(284, 199, 420, 35);
        contentPane.add(jbtnPassChange);
        
        JLabel jlblEndText = new JLabel("2025_0001");
        jlblEndText.setForeground(new Color(0, 0, 0));
        jlblEndText.setFont(new Font("Dialog", Font.PLAIN, 30));
        jlblEndText.setBounds(514, 624, 185, 35);
        contentPane.add(jlblEndText);
        
        JLabel lblNewLabel = new JLabel("~");
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        lblNewLabel.setBounds(480, 624, 20, 35);
        contentPane.add(lblNewLabel);
        
        jbtnModification = new JButton("수정");
        jbtnModification.setFont(new Font("Dialog", Font.BOLD, 30));
        jbtnModification.setBounds(166, 731, 200, 50);
        jbtnModification.setBackground(new Color(255, 165, 0));
        contentPane.add(jbtnModification);
        
        jbtnAccountClose = new JButton("닫기");
        jbtnAccountClose.setFont(new Font("Dialog", Font.BOLD, 30));
        jbtnAccountClose.setBounds(407, 731, 200, 50);
        jbtnAccountClose.setBackground(new Color(211, 211, 211));
        contentPane.add(jbtnAccountClose);
        
        JtfTelText = new JTextField();
        JtfTelText.setBounds(294, 364, 420, 35);
        JtfTelText.setFont(new Font("Dialog", Font.PLAIN, 30));
        contentPane.add(JtfTelText);
        JtfTelText.setColumns(10);
        
//		이벤트 등록
        AccountViewEvt ave = new AccountViewEvt(this);
        jbtnAccountClose.addActionListener(ave);
        jbtnModification.addActionListener(ave);
        jbtnPassChange.addActionListener(ave);
        
        setBounds(100, 100, 800, 900); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);  
    }

	public JTextArea getJtaAdressText() {
		return jtaAdressText;
	}

	public JButton getJbtnPassChange() {
		return jbtnPassChange;
	}

	public JButton getJbtnModification() {
		return jbtnModification;
	}

	public JButton getJbtnAccountClose() {
		return jbtnAccountClose;
	}

	public JTextField getJtfTelText() {
		return JtfTelText;
	}
	
//	getter

	
}//class
 