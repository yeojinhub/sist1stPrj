package kr.co.sist.jtg;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminAccountAdminAccountCreateView extends JPanel {

	private JButton jbtnAdminAccountAdminAccountCreate;
	private JButton jbtnAdminAccountAdminAccountClose;
	
	public AdminAccountAdminAccountCreateView(){
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminAccountAdminAccountCreateViewPanel = new JPanel(new GridBagLayout());
        jpAdminAccountAdminAccountCreateViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminAccountAdminAccountCreateViewPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminAccountAdminAccountCreateViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 4, 8, 4);
        gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
        Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
        //이름 Component 생성
		JLabel jlblAdminAccountAdminAccountNameTitle = new JLabel("이름");
		JTextField jtfAdminAccountAdminAccountNameText = new JTextField();
		jlblAdminAccountAdminAccountNameTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountNameText.setPreferredSize(fieldSize);
		
		//비밀번호 Component 생성
		JLabel jlblAdminAccountAdminAccountPassTitle = new JLabel("비밀번호");
		JPasswordField jpfAdminAccountAdminAccountPassText = new JPasswordField();
		jlblAdminAccountAdminAccountPassTitle.setPreferredSize(labelSize);
		jpfAdminAccountAdminAccountPassText.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel jlblAdminAccountAdminAccountBirthTitle = new JLabel("생년월일");
		JTextField jtfAdminAccountAdminAccountBirthText = new JTextField();
		jlblAdminAccountAdminAccountBirthTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountBirthText.setPreferredSize(fieldSize);
		
		//전화번호 Component 생성
		JLabel jlblAdminAccountAdminAccountTelTitle = new JLabel("전화번호");
		JTextField jtfAdminAccountAdminAccountTelText = new JTextField();
		jlblAdminAccountAdminAccountTelTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountTelText.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel jlblAdminAccountAdminAccountAddressTitle = new JLabel("주소");
		JTextField jtfAdminAccountAdminAccountAddressText = new JTextField();
		jlblAdminAccountAdminAccountAddressTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountAddressText.setPreferredSize(fieldSize);
		
		//Button 생성
        JPanel jpAdminAccountAdminAccountCreateViewButtonPanel = new JPanel();
        jpAdminAccountAdminAccountCreateViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminAccountAdminAccountCreate = new JButton("생성");
        jbtnAdminAccountAdminAccountClose = new JButton("닫기");
        
        jpAdminAccountAdminAccountCreateViewButtonPanel.add(jbtnAdminAccountAdminAccountCreate);
        jpAdminAccountAdminAccountCreateViewButtonPanel.add(jbtnAdminAccountAdminAccountClose);
        
        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountAdminAccountCreateViewPanel.add(jlblAdminAccountAdminAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jtfAdminAccountAdminAccountNameText, gbc);
        
        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jlblAdminAccountAdminAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jpfAdminAccountAdminAccountPassText, gbc);
        
        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountAdminAccountCreateViewPanel.add(jlblAdminAccountAdminAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jtfAdminAccountAdminAccountBirthText, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountAdminAccountCreateViewPanel.add(jlblAdminAccountAdminAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jtfAdminAccountAdminAccountTelText, gbc);
        
        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountAdminAccountCreateViewPanel.add(jlblAdminAccountAdminAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountCreateViewPanel.add(jtfAdminAccountAdminAccountAddressText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminAccountAdminAccountCreateViewPanel.add(jpAdminAccountAdminAccountCreateViewButtonPanel, gbc);
		
		//Panel 배치
		add(jpAdminAccountAdminAccountCreateViewPanel);
		
		//Button 이벤트 생성
		AdminAccountAdminAccountCreateEvt aaaace = new AdminAccountAdminAccountCreateEvt(this);
		jbtnAdminAccountAdminAccountCreate.addActionListener(aaaace);
		jbtnAdminAccountAdminAccountClose.addActionListener(aaaace);
		
	} //AdminAccountAdminAccountCreateView

	//getter method
	public JButton getJbtnAdminAccountAdminAccountCreate() {
		return jbtnAdminAccountAdminAccountCreate;
	} //getJbtnAdminAccountAdminAccountCreate

	public JButton getJbtnAdminAccountAdminAccountClose() {
		return jbtnAdminAccountAdminAccountClose;
	} //getJbtnAdminAccountAdminAccountClose
	
} //class
