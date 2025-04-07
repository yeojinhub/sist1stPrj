package kr.co.sist.yj;

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
public class AdminAccountInstructorAccountCreateView extends JPanel{

	private JTextField jtfAdminAccountInstructorAccountNameSet;
	private JPasswordField jpfAdminAccountInstructorAccountPassSet;
	private JTextField jtfAdminAccountInstructorAccountBirthSet;
	private JTextField jtfAdminAccountInstructorAccountTelSet;
	private JTextField jtfAdminAccountInstructorAccountAddressSet;
	
	private JButton jbtnAdminAccountInstructorAccountCreate;
	private JButton jbtnAdminAccountInstructorAccountClose;
	
	public AdminAccountInstructorAccountCreateView() {
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel jpAdminAccountInstructorAccountCreateViewPanel = new JPanel(new GridBagLayout());
		jpAdminAccountInstructorAccountCreateViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		jpAdminAccountInstructorAccountCreateViewPanel.setMinimumSize(new Dimension(350, 400));
		jpAdminAccountInstructorAccountCreateViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
		//이름 Component 생성
		JLabel jlblAdminAccountInstructorAccountNameTitle = new JLabel("이름");
		jlblAdminAccountInstructorAccountNameTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountNameSet = new JTextField();
		jtfAdminAccountInstructorAccountNameSet.setPreferredSize(fieldSize);
		
		//비밀번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountPassTitle = new JLabel("비밀번호");
		jlblAdminAccountInstructorAccountPassTitle.setPreferredSize(labelSize);
		jpfAdminAccountInstructorAccountPassSet = new JPasswordField();
		jpfAdminAccountInstructorAccountPassSet.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel jlblAdminAccountInstructorAccountBirthTitle = new JLabel("생년월일");
		jlblAdminAccountInstructorAccountBirthTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountBirthSet = new JTextField();
		jtfAdminAccountInstructorAccountBirthSet.setPreferredSize(fieldSize);
		
		//전화번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountTelTitle = new JLabel("전화번호");
		jlblAdminAccountInstructorAccountTelTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountTelSet = new JTextField();
		jtfAdminAccountInstructorAccountTelSet.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel jlblAdminAccountInstructorAccountAddressTitle = new JLabel("주소");
		jlblAdminAccountInstructorAccountAddressTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountAddressSet = new JTextField();
		jtfAdminAccountInstructorAccountAddressSet.setPreferredSize(fieldSize);
		
		//Button 생성
		JPanel jpAdminAccountInstructorAccountCreateViewButtonPanel = new JPanel();
		jpAdminAccountInstructorAccountCreateViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jbtnAdminAccountInstructorAccountCreate = new JButton("생성");
		jbtnAdminAccountInstructorAccountClose = new JButton("닫기");
		
		jpAdminAccountInstructorAccountCreateViewButtonPanel.add(jbtnAdminAccountInstructorAccountCreate);
		jpAdminAccountInstructorAccountCreateViewButtonPanel.add(jbtnAdminAccountInstructorAccountClose);
		
		//Component 배치
		//이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jlblAdminAccountInstructorAccountNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jtfAdminAccountInstructorAccountNameSet, gbc);
		
		//비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jlblAdminAccountInstructorAccountPassTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jpfAdminAccountInstructorAccountPassSet, gbc);
		
		//생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jlblAdminAccountInstructorAccountBirthTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jtfAdminAccountInstructorAccountBirthSet, gbc);
		
		//전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jlblAdminAccountInstructorAccountTelTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jtfAdminAccountInstructorAccountTelSet, gbc);
		
		//주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jlblAdminAccountInstructorAccountAddressTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountCreateViewPanel.add(jtfAdminAccountInstructorAccountAddressSet, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
		jpAdminAccountInstructorAccountCreateViewPanel.add(jpAdminAccountInstructorAccountCreateViewButtonPanel, gbc);
		
		//Panel 배치
		add(jpAdminAccountInstructorAccountCreateViewPanel);
		
		//Button 이벤트 생성
		AdminAccountInstructorAccountCreateEvt aaiace = new AdminAccountInstructorAccountCreateEvt(this);
		jbtnAdminAccountInstructorAccountCreate.addActionListener(aaiace);
		jbtnAdminAccountInstructorAccountClose.addActionListener(aaiace);
		
	} //AdminAccountInstructorAccountCreateView

	//getter method
	public JTextField getJtfAdminAccountInstructorAccountNameSet() {
		return jtfAdminAccountInstructorAccountNameSet;
	}

	public JPasswordField getJpfAdminAccountInstructorAccountPassSet() {
		return jpfAdminAccountInstructorAccountPassSet;
	}

	public JTextField getJtfAdminAccountInstructorAccountBirthSet() {
		return jtfAdminAccountInstructorAccountBirthSet;
	}

	public JTextField getJtfAdminAccountInstructorAccountTelSet() {
		return jtfAdminAccountInstructorAccountTelSet;
	}

	public JTextField getJtfAdminAccountInstructorAccountAddressSet() {
		return jtfAdminAccountInstructorAccountAddressSet;
	}
	
	public JButton getJbtnAdminAccountInstructorAccountCreate() {
		return jbtnAdminAccountInstructorAccountCreate;
	} //getJbtnAdminAccountInstructorAccountCreate

	public JButton getJbtnAdminAccountInstructorAccountClose() {
		return jbtnAdminAccountInstructorAccountClose;
	} //getJbtnAdminAccountInstructorAccountClose
	
} //class
