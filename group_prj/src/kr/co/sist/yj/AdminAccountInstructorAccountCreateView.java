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

	private JTextField instNameTextSet;
	private JPasswordField instPassTextSet;
	private JTextField instBirthTextSet;
	private JTextField instTelTextSet;
	private JTextField instAddTextSet;
	
	private JButton instCreateButton;
	private JButton instCloseButton;
	
	public AdminAccountInstructorAccountCreateView() {
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel instCreateViewPanel = new JPanel(new GridBagLayout());
		instCreateViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		instCreateViewPanel.setMinimumSize(new Dimension(350, 400));
		instCreateViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
		//이름 Component 생성
		JLabel instNameTitleLabel = new JLabel("이름");
		instNameTitleLabel.setPreferredSize(labelSize);
		instNameTextSet = new JTextField();
		instNameTextSet.setPreferredSize(fieldSize);
		
		//비밀번호 Component 생성
		JLabel instPassTitleLabel = new JLabel("비밀번호");
		instPassTitleLabel.setPreferredSize(labelSize);
		instPassTextSet = new JPasswordField();
		instPassTextSet.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel instBirthTitleLabel = new JLabel("생년월일");
		instBirthTitleLabel.setPreferredSize(labelSize);
		instBirthTextSet = new JTextField();
		instBirthTextSet.setPreferredSize(fieldSize);
		
		//전화번호 Component 생성
		JLabel instTelTitleLabel = new JLabel("전화번호");
		instTelTitleLabel.setPreferredSize(labelSize);
		instTelTextSet = new JTextField();
		instTelTextSet.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel instAddTitleLabel = new JLabel("주소");
		instAddTitleLabel.setPreferredSize(labelSize);
		instAddTextSet = new JTextField();
		instAddTextSet.setPreferredSize(fieldSize);
		
		//Button 생성
		JPanel instCreateViewButtonPanel = new JPanel();
		instCreateViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		instCreateButton = new JButton("생성");
		instCloseButton = new JButton("닫기");
		
		instCreateViewButtonPanel.add(instCreateButton);
		instCreateViewButtonPanel.add(instCloseButton);
		
		//Component 배치
		//이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		instCreateViewPanel.add(instNameTitleLabel, gbc);
		gbc.gridx = 1;
		instCreateViewPanel.add(instNameTextSet, gbc);
		
		//비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		instCreateViewPanel.add(instPassTitleLabel, gbc);
		gbc.gridx = 1;
		instCreateViewPanel.add(instPassTextSet, gbc);
		
		//생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		instCreateViewPanel.add(instBirthTitleLabel, gbc);
		gbc.gridx = 1;
		instCreateViewPanel.add(instBirthTextSet, gbc);
		
		//전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		instCreateViewPanel.add(instTelTitleLabel, gbc);
		gbc.gridx = 1;
		instCreateViewPanel.add(instTelTextSet, gbc);
		
		//주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		instCreateViewPanel.add(instAddTitleLabel, gbc);
		gbc.gridx = 1;
		instCreateViewPanel.add(instAddTextSet, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		instCreateViewPanel.add(instCreateViewButtonPanel, gbc);
		
		//Panel 배치
		add(instCreateViewPanel);
		
		//Button 이벤트 생성
		AdminAccountInstructorAccountCreateEvt instCreateEvt = new AdminAccountInstructorAccountCreateEvt(this);
		instCreateButton.addActionListener(instCreateEvt);
		instCloseButton.addActionListener(instCreateEvt);
		
	} //AdminAccountInstructorAccountCreateView

	//getter method
	public JTextField getInstNameTextSet() {
		return instNameTextSet;
	}

	public JPasswordField getInstPassTextSet() {
		return instPassTextSet;
	}

	public JTextField getInstBirthTextSet() {
		return instBirthTextSet;
	}

	public JTextField getInstTelTextSet() {
		return instTelTextSet;
	}

	public JTextField getInstAddTextSet() {
		return instAddTextSet;
	}

	public JButton getInstCreateButton() {
		return instCreateButton;
	}

	public JButton getInstCloseButton() {
		return instCloseButton;
	}
	
} //class
