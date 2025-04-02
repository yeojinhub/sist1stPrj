package kr.co.sist.ldu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ShowStudScoretoInstructorView extends JDialog{
	
	private JTable table;
	private JButton jbtnClose;

	
	public ShowStudScoretoInstructorView(InstructorMainView imv) {
		super(imv,"학생 성적",true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 489, 381);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 10, 325, 37);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Screenshots\\스크린샷 2025-04-01 161817.png"));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아무개 강사님");
		lblNewLabel_1.setBounds(361, 21, 100, 15);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("학생");
		lblNewLabel_2.setBounds(12, 67, 57, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("홍길동");
		lblNewLabel_3.setBounds(81, 67, 57, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호");
		lblNewLabel_4.setBounds(223, 67, 57, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("010-1234-5678");
		lblNewLabel_5.setBounds(316, 67, 134, 15);
		getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 92, 449, 207);
		scrollPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"과목명", "성적"
			}
		));
		scrollPane.setViewportView(table);
		
		jbtnClose = new JButton("닫기");
		jbtnClose.setBounds(183, 309, 97, 23);
		getContentPane().add(jbtnClose);
		
		ShowStudScoretoInstructorViewEvent ssive = new ShowStudScoretoInstructorViewEvent(this);
		jbtnClose.addActionListener(ssive);
		
		
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JButton getJbtnClose() {
		return jbtnClose;
	}


	public void setJbtnClose(JButton jbtnClose) {
		this.jbtnClose = jbtnClose;
	}
	
	
}
