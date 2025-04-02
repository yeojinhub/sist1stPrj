package kr.co.sist.kmg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class StudentBoardWrite extends JDialog {

	private JPanel contentPane;
	private JLabel jlblStudentBoardWriteTitle;
	private JTextField jtfStudentBoardWriteContentTitle;
	private JButton jbtnStudentBoardWriteModify;
	private JButton jbbtnStudentBoardWriteClose;

 
	public StudentBoardWrite() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
//		여기서부터 나오기
        JLabel jlbStudentBoardWriteContentTitleLabel = new JLabel("제목");
        jlbStudentBoardWriteContentTitleLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        jlbStudentBoardWriteContentTitleLabel.setBounds(50, 110,50, 50);
        contentPane.add(jlbStudentBoardWriteContentTitleLabel);
        
        jlblStudentBoardWriteTitle = new JLabel("글  작  성");
        jlblStudentBoardWriteTitle.setFont(new Font("Dialog", Font.BOLD, 30));
        jlblStudentBoardWriteTitle.setBounds(400, 15, 122, 40);
        contentPane.add(jlblStudentBoardWriteTitle);
        
        jtfStudentBoardWriteContentTitle = new JTextField();
        jtfStudentBoardWriteContentTitle.setBounds(147, 118, 683, 30);
        contentPane.add(jtfStudentBoardWriteContentTitle);
        jtfStudentBoardWriteContentTitle.setColumns(10);
        jtfStudentBoardWriteContentTitle.setFont(new Font("Dialog", Font.BOLD, 25));
        
        
        JTextArea jtaStudentBoardContentArea = new JTextArea();
        jtaStudentBoardContentArea.setBorder(new LineBorder(Color.GRAY));
        jtaStudentBoardContentArea.setFont(new Font("Dialog", Font.BOLD, 25));
        
        JScrollPane scrollPane = new JScrollPane(jtaStudentBoardContentArea);
        scrollPane.setBounds(50, 180, 780, 400); // scrollPane에 크기 설정
        contentPane.add(scrollPane);
        
        jbtnStudentBoardWriteModify = new JButton("등록");
        jbtnStudentBoardWriteModify.setBounds(60, 597, 200, 50);
        contentPane.add(jbtnStudentBoardWriteModify);
        jbtnStudentBoardWriteModify.setFont(new Font("Dialog", Font.BOLD, 30));
        jbtnStudentBoardWriteModify.setBackground(new Color(255, 165, 0));
        
        jbbtnStudentBoardWriteClose = new JButton("닫기");
        jbbtnStudentBoardWriteClose.setBounds(630, 590, 200, 50);
        contentPane.add(jbbtnStudentBoardWriteClose);
        jbbtnStudentBoardWriteClose.setFont(new Font("Dialog", Font.BOLD, 30));
        jbbtnStudentBoardWriteClose.setBackground(new Color(255, 165, 0));
   
//		이벤트 등록
        
        StudentBoardWriteEvt sbwe=new StudentBoardWriteEvt(this);
        jbtnStudentBoardWriteModify.addActionListener(sbwe);
        jbbtnStudentBoardWriteClose.addActionListener(sbwe);
        
//		윈도우 크기         
        setBounds(100, 100, 900,700); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setVisible(true);
	}//StudentBoardWrite

	// getter
	
	public JLabel getJlblStudentBoardWriteTitle() {
		return jlblStudentBoardWriteTitle;
	}


	public JTextField getJtfStudentBoardWriteContentTitle() {
		return jtfStudentBoardWriteContentTitle;
	}


	public JButton getJbtnStudentBoardWriteModify() {
		return jbtnStudentBoardWriteModify;
	}


	public JButton getJbbtnStudentBoardWriteClose() {
		return jbbtnStudentBoardWriteClose;
	}
	
}//class
