package kr.co.sist.kti;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class StudentInfoChangePassView extends JDialog {
	
	private JPasswordField jpfChangePass, jpfPassCheck, jpfNowPass;
	private JButton jbtnChange, jbtnExit;

	public StudentInfoChangePassView() {
		setTitle("Best Campus - 비밀번호 변경");
		
		// #. 컴포넌트 생성 및 설정
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(7, 8, 370, 64);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
				
		JLabel jlblTitle = new JLabel("비밀번호 변경");
		panel.add(jlblTitle);
		jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		jlblTitle.setBackground(Color.WHITE);

		JLabel jlblNowPass = new JLabel("현재 비밀번호");
		jlblNowPass.setHorizontalAlignment(SwingConstants.CENTER);
		jlblNowPass.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblNowPass.setBackground(Color.WHITE);
		jlblNowPass.setBounds(20, 90, 110, 25);
		getContentPane().add(jlblNowPass);
		
		JLabel jlblChangePass = new JLabel("새로운 비밀번호");
		jlblChangePass.setHorizontalAlignment(SwingConstants.CENTER);
		jlblChangePass.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblChangePass.setBackground(Color.WHITE);
		jlblChangePass.setBounds(20, 140, 110, 25);
		getContentPane().add(jlblChangePass);
		
		JLabel jlblPassCheck = new JLabel("비밀번호 확인");
		jlblPassCheck.setHorizontalAlignment(SwingConstants.CENTER);
		jlblPassCheck.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblPassCheck.setBackground(Color.WHITE);
		jlblPassCheck.setBounds(20, 190, 110, 25);
		getContentPane().add(jlblPassCheck);
		
		jpfNowPass = new JPasswordField();
		jpfNowPass.setBounds(160, 90, 200, 25);
		getContentPane().add(jpfNowPass);
		
		jpfChangePass = new JPasswordField();
		jpfChangePass.setBounds(160, 140, 200, 25);
		getContentPane().add(jpfChangePass);
		
		jpfPassCheck = new JPasswordField();
		jpfPassCheck.setBounds(160, 190, 200, 25);
		getContentPane().add(jpfPassCheck);
		
		jbtnChange = new JButton("변경");
		jbtnChange.setBackground(new Color(235, 235, 255));
		jbtnChange.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnChange.setBounds(70, 240, 100, 35);
		getContentPane().add(jbtnChange);
		
		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setBounds(210, 240, 100, 35);
		getContentPane().add(jbtnExit);
		
		// #. 이벤트 추가
		// #-1. 이벤트 객체 생성
		StudentInfoChangePassEvt sicpe = new StudentInfoChangePassEvt(this);
		// #-2. 컴포넌트에 이벤트 추가
		jbtnChange.addActionListener(sicpe);
		jbtnExit.addActionListener(sicpe);
		
		// #. 모달 설정
		setModal(true);
		
		// #. 위치 및 사이즈 설정
		setBounds(100, 100, 400, 330);
		
		// #. 창 닫기 설정
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// #. 가시화
		setVisible(true);
		
	}// StudentInfoChangePassView

	// Getter Method
	public JPasswordField getJpfChangePass() {
		return jpfChangePass;
	}

	public JPasswordField getJpfPassCheck() {
		return jpfPassCheck;
	}

	public JPasswordField getJpfNowPass() {
		return jpfNowPass;
	}

	public JButton getJbtnChange() {
		return jbtnChange;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}
	
}// class
