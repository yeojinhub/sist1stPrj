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
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ShowStudScoretoInstructorView extends JDialog{
	
	private JTable jtaStudScore;
	private JButton jbtnClose;
	private InstructorAccountVO iaVO;
	private InstructorStudentVO isVO;
	
	public ShowStudScoretoInstructorView(InstructorAccountVO iaVO, InstructorStudentVO isVO) {
		setTitle("학생 성적");
		this.iaVO = iaVO;
		this.isVO = isVO;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ShowStudScoretoInstructorView.class.getResource("/kr/co/sist/ldu/images/logo.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 489, 381);
		getContentPane().setLayout(null);
		
		JLabel jlblLogo = new JLabel("New label");
		jlblLogo.setBounds(12, 10, 325, 37);
		jlblLogo.setIcon(new ImageIcon(ShowStudScoretoInstructorView.class.getResource("/kr/co/sist/ldu/images/icon.png")));
		getContentPane().add(jlblLogo);
		
		JLabel jlblInstName = new JLabel(iaVO.getInstName()+"강사님");
		jlblInstName.setBounds(361, 21, 100, 15);
		jlblInstName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		getContentPane().add(jlblInstName);
		
		JLabel jlblStud = new JLabel("학생");
		jlblStud.setBounds(12, 67, 57, 15);
		getContentPane().add(jlblStud);
		
		JLabel jlblStudName = new JLabel(isVO.getStudName());
		jlblStudName.setBounds(81, 67, 57, 15);
		getContentPane().add(jlblStudName);
		
		JLabel jlblTel = new JLabel("전화번호");
		jlblTel.setBounds(223, 67, 57, 15);
		getContentPane().add(jlblTel);
		
		JLabel jlblStudTel = new JLabel(isVO.getStudTel());
		jlblStudTel.setBounds(316, 67, 134, 15);
		getContentPane().add(jlblStudTel);
		
		JScrollPane jspStudScore = new JScrollPane();
		jspStudScore.setBounds(12, 92, 449, 207);
		jspStudScore.setBackground(new Color(255, 255, 255));
		getContentPane().add(jspStudScore);
		
		jtaStudScore = new JTable();
		jtaStudScore.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"과목명", "성적"
			}
		));
		jspStudScore.setViewportView(jtaStudScore);
		
		jbtnClose = new JButton("닫기");
		jbtnClose.setBounds(183, 309, 97, 23);
		getContentPane().add(jbtnClose);
		
		ShowStudScoretoInstructorViewEvt ssive = new ShowStudScoretoInstructorViewEvt(this);
		jbtnClose.addActionListener(ssive);
		
		setResizable(false);
	}


	

	public JTable getJtaStudScore() {
		return jtaStudScore;
	}

	public void setJtaStudScore(JTable jtaStudScore) {
		this.jtaStudScore = jtaStudScore;
	}

	public JButton getJbtnClose() {
		return jbtnClose;
	}


	public void setJbtnClose(JButton jbtnClose) {
		this.jbtnClose = jbtnClose;
	}


	public InstructorAccountVO getIaVO() {
		return iaVO;
	}


	public void setIaVO(InstructorAccountVO iaVO) {
		this.iaVO = iaVO;
	}


	public InstructorStudentVO getIsVO() {
		return isVO;
	}


	public void setIsVO(InstructorStudentVO isVO) {
		this.isVO = isVO;
	}
	
	
}
