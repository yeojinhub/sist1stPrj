package kr.co.sist.kmg;
//package kr.co.sist.kmg;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StudentLoginForm extends JFrame {
	private JTextField jtfId;
	private JPasswordField jtfPass;
	private JButton jbtnLogin;
	
	private JLabel jlbErrorText;// 에러 텍스트 넣기

	public StudentLoginForm() {
		super("로그인");
	
// 		바탕 색 - 화이트
		getContentPane().setBackground(new Color(255, 255, 255));
//		바탕 패널 - 레이아웃 null
		getContentPane().setLayout(null);

// 		로고  
		JLabel jlbLogoTitle = new JLabel("Best Campus");
		jlbLogoTitle.setFont(new Font("Consolas", Font.BOLD, 50));
		jlbLogoTitle.setBounds(getX() +101,getY() + 121, 302, 50);
		getContentPane().add(jlbLogoTitle);

//		에러 출력
		
		
//		아이디		
		jtfId = new JTextField("ID");
		jtfId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(jtfId.getText().equals("ID")) {
					jtfId.setText(null);
					jtfId.requestFocus();
					//removePlaceholderStyle
					removePlaceholderStyle(jtfId);
				}//end if
			}//focusGained
			
			// 포커스가 없어지면
			@Override
			public void focusLost(FocusEvent e) {
				if(jtfId.getText().length()==0) {
					//addPlaceholderStyle
					addPlaceholderStyle(jtfId);
					jtfId.setText("ID");
				}//end if
			}//focusLost
		});
		
		jtfId.setBounds(getX() + 101, getY() + 283, 300, 60);
		jtfId.setColumns(10);
		getContentPane().add(jtfId);
		addPlaceholderStyle(jtfId);

//		비밀번호		
		jtfPass = new JPasswordField("Password");
		jtfPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(jtfPass.getText().equals("Password")) {
					jtfPass.setText(null);
					jtfPass.requestFocus();
					jtfPass.setEchoChar('*');
					//removePlaceholderStyle
					removePlaceholderStyle(jtfPass);
				}//end if
			}//focusGained
			
			@Override
			public void focusLost(FocusEvent e) {
				if(jtfPass.getText().length()==0) {
					//addPlaceholderStyle
					addPlaceholderStyle(jtfPass);
					jtfPass.setText("Password");
				}//end if
			}//focusLost
		});
		
		jtfPass.setForeground(new Color(128, 128, 128));
		jtfPass.setFont(new Font("Dialog", Font.ITALIC, 20));
		jtfPass.setBounds(getX() + 101, getY() + 365, 300, 60);
		jtfPass.setColumns(10);
		getContentPane().add(jtfPass);
		addPlaceholderStyle(jtfPass);

//	 	login버튼		
		jbtnLogin = new JButton("login");
		jbtnLogin.setBackground(new Color(255, 165, 0));
		jbtnLogin.setFont(new Font("Lucida Console", Font.PLAIN, 30));
		jbtnLogin.setBounds(getX() + 102, getY() + 478, 300, 60);
		getContentPane().add(jbtnLogin);

//		이벤트 등록
		StudentLoginFormEvt slfe = new StudentLoginFormEvt(this);
		jbtnLogin.addActionListener(slfe);
		
//		window 크기 설정
		setBounds(100, 100, 520, 700);
//		x로 창닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		사용자에게 window 출력
		setVisible(true);

	}// LoginForm

//	힌트
//	아이디, 비밀번호 글씨체		
	Font gainFont = new Font("Console", Font.PLAIN|Font.BOLD, 20);// 입력-기본
	Font lostFont = new Font("Console", Font.ITALIC, 20);// 힌트

	//힌트글씨( 넣기 )
	private void addPlaceholderStyle(JTextField textField) {
		textField.setFont(lostFont); // 기본 폰트 설정
		textField.setForeground(Color.GRAY); // 기본 색상 설정
	}
	//힌트글씨( 사라지기 )
	private void removePlaceholderStyle(JTextField textField) {
		textField.setFont(gainFont); // 기본 폰트 설정
		textField.setForeground(Color.black); // 기본 색상 설정
	}

//	getter	
	public JTextField getJtfId() {
		return jtfId;
	}
	public JPasswordField getJtfPass() {
		return jtfPass;
	}
	public JButton getJbtnLogin() {
		return jbtnLogin;
	}
	
	
}// class
