package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class AdminAccountAdminAccountModifyView extends JPanel {

	private JTextField admNameTextSet;
	private JTextField admIDTextSet;
	private JPasswordField admPassTextSet;
	private JTextField admBirthTextSet;
	private JTextField admTelTextSet;
	private JTextField admAddTextSet;
	
	private JButton admModifyButton;
	private JButton admDeleteButton;
	private JButton admCloseButton;

	private String strAdmNum;
	
	public AdminAccountAdminAccountModifyView(String strAdmNum) {
		this.strAdmNum=strAdmNum;

		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension buttonSize = new Dimension(120, 40);

		setLayout(new BorderLayout());

		// ---------- 왼쪽 입력 패널 ----------
		JPanel admModifyViewPanel = new JPanel(new GridBagLayout());
		admModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		admModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		admModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;

		// JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);

		// Component 생성
		// 이름 Component 생성
		JLabel admNameTitleLabel = new JLabel("이름");
		admNameTitleLabel.setPreferredSize(labelSize);
		admNameTextSet = new JTextField();
		admNameTextSet.setPreferredSize(fieldSize);
		admNameTextSet.setEditable(false);

		// 사번 Component 생성
		JLabel admIDTitleLabel = new JLabel("아이디");
		admIDTitleLabel.setPreferredSize(labelSize);
		admIDTextSet = new JTextField();
		admIDTextSet.setPreferredSize(fieldSize);
		admIDTextSet.setEditable(false);

		// 비밀번호 Component 생성
		JLabel admiPassTitleLabel = new JLabel("비밀번호");
		admiPassTitleLabel.setPreferredSize(labelSize);
		admPassTextSet = new JPasswordField();
		admPassTextSet.setPreferredSize(fieldSize);

		// 생년월일 Component 생성
		JLabel admBirthTitleLabel = new JLabel("생년월일");
		admBirthTitleLabel.setPreferredSize(labelSize);
		admBirthTextSet = new JTextField();
		admBirthTextSet.setPreferredSize(fieldSize);
		admBirthTextSet.setEditable(false);

		// 전화번호 Component 생성
		JLabel adminTelTitleLabel = new JLabel("전화번호");
		adminTelTitleLabel.setPreferredSize(labelSize);
		admTelTextSet = new JTextField();
		admTelTextSet.setPreferredSize(fieldSize);

		// 주소 Component 생성
		JLabel adminAddTitleLabel = new JLabel("주소");
		adminAddTitleLabel.setPreferredSize(labelSize);
		admAddTextSet = new JTextField();
		admAddTextSet.setPreferredSize(fieldSize);

		// Button 생성
		JPanel admModifyViewButtonPanel = new JPanel();
		admModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		admModifyViewButtonPanel.setBackground(white);
		admModifyButton = new JButton("수정");
		admModifyButton.setBackground(lightblue);
		admModifyButton.setSize(buttonSize);
		admModifyButton.setFont(buttonFont);
		
		admDeleteButton = new JButton("삭제");
		admDeleteButton.setBackground(lightblue);
		admDeleteButton.setSize(buttonSize);
		admDeleteButton.setFont(buttonFont);
		
		admCloseButton = new JButton("닫기");
		admCloseButton.setBackground(lightblue);
		admCloseButton.setSize(buttonSize);
		admCloseButton.setFont(buttonFont);

		admModifyViewButtonPanel.add(admModifyButton);
		admModifyViewButtonPanel.add(admDeleteButton);
		admModifyViewButtonPanel.add(admCloseButton);

		// Component 배치
		// 이름 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 0;
		admModifyViewPanel.add(admNameTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admNameTextSet, gbc);

		// 사번 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 1;
		admModifyViewPanel.add(admIDTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admIDTextSet, gbc);

		// 비밀번호 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 2;
		admModifyViewPanel.add(admiPassTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admPassTextSet, gbc);

		// 생년월일 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 3;
		admModifyViewPanel.add(admBirthTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admBirthTextSet, gbc);

		// 전화번호 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 4;
		admModifyViewPanel.add(adminTelTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admTelTextSet, gbc);

		// 주소 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 5;
		admModifyViewPanel.add(adminAddTitleLabel, gbc);
		gbc.gridx = 1;
		admModifyViewPanel.add(admAddTextSet, gbc);

		// 버튼 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 3; // 세 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		admModifyViewPanel.add(admModifyViewButtonPanel, gbc);

		// Panel 배치
		add(admModifyViewPanel);

		// Button 이벤트 생성
		AdminAccountAdminAccountModifyEvt admModifyEvt = new AdminAccountAdminAccountModifyEvt(this);
		admModifyButton.addActionListener(admModifyEvt);
		admDeleteButton.addActionListener(admModifyEvt);
		admCloseButton.addActionListener(admModifyEvt);

	} // AdminAccountAdminAccountModifyView

	// getter method
	public JTextField getAdmNameTextSet() {
		return admNameTextSet;
	}

	public JTextField getAdmIDTextSet() {
		return admIDTextSet;
	}

	public JPasswordField getAdmPassTextSet() {
		return admPassTextSet;
	}

	public JTextField getAdmBirthTextSet() {
		return admBirthTextSet;
	}

	public JTextField getAdmTelTextSet() {
		return admTelTextSet;
	}

	public JTextField getAdmAddTextSet() {
		return admAddTextSet;
	}
	
	public JButton getAdmModifyButton() {
		return admModifyButton;
	}

	public JButton getAdmDeleteButton() {
		return admDeleteButton;
	}

	public JButton getAdmCloseButton() {
		return admCloseButton;
	}

	public String getStrAdmNum() {
		return strAdmNum;
	}
	
} // class
