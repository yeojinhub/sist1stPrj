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
public class AdminAccountAdminAccountCreateView extends JPanel {

	private JTextField admNameTextSet;
	private JPasswordField admPassTextSet;
	private JTextField admBirthTextSet;
	private JTextField admTelTextSet;
	private JTextField admAddTextSet;

	private JButton admCreateButton;
	private JButton admCloseButton;

	public AdminAccountAdminAccountCreateView() {
		setLayout(new BorderLayout());

		// ---------- 왼쪽 입력 패널 ----------
		JPanel admCreateViewPanel = new JPanel(new GridBagLayout());
		admCreateViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		admCreateViewPanel.setMinimumSize(new Dimension(350, 400));
		admCreateViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

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

		// 비밀번호 Component 생성
		JLabel admPassTitleLabel = new JLabel("비밀번호");
		admPassTitleLabel.setPreferredSize(labelSize);
		admPassTextSet = new JPasswordField();
		admPassTextSet.setPreferredSize(fieldSize);

		// 생년월일 Component 생성
		JLabel admBirthTitleLabel = new JLabel("생년월일");
		admBirthTitleLabel.setPreferredSize(labelSize);
		admBirthTextSet = new JTextField();
		admBirthTextSet.setPreferredSize(fieldSize);

		// 전화번호 Component 생성
		JLabel admTelTitleLabel = new JLabel("전화번호");
		admTelTitleLabel.setPreferredSize(labelSize);
		admTelTextSet = new JTextField();
		admTelTextSet.setPreferredSize(fieldSize);

		// 주소 Component 생성
		JLabel admAddTitleLabel = new JLabel("주소");
		admAddTitleLabel.setPreferredSize(labelSize);
		admAddTextSet = new JTextField();
		admAddTextSet.setPreferredSize(fieldSize);

		// Button 생성
		JPanel admCreateViewButtonPanel = new JPanel();
		admCreateViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		admCreateButton = new JButton("생성");
		admCloseButton = new JButton("닫기");

		admCreateViewButtonPanel.add(admCreateButton);
		admCreateViewButtonPanel.add(admCloseButton);

		// Component 배치
		// 이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		admCreateViewPanel.add(admNameTitleLabel, gbc);
		gbc.gridx = 1;
		admCreateViewPanel.add(admNameTextSet, gbc);

		// 비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		admCreateViewPanel.add(admPassTitleLabel, gbc);
		gbc.gridx = 1;
		admCreateViewPanel.add(admPassTextSet, gbc);

		// 생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		admCreateViewPanel.add(admBirthTitleLabel, gbc);
		gbc.gridx = 1;
		admCreateViewPanel.add(admBirthTextSet, gbc);

		// 전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		admCreateViewPanel.add(admTelTitleLabel, gbc);
		gbc.gridx = 1;
		admCreateViewPanel.add(admTelTextSet, gbc);

		// 주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		admCreateViewPanel.add(admAddTitleLabel, gbc);
		gbc.gridx = 1;
		admCreateViewPanel.add(admAddTextSet, gbc);

		// 버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		gbc.gridwidth = 2; // 두 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		admCreateViewPanel.add(admCreateViewButtonPanel, gbc);

		// Panel 배치
		add(admCreateViewPanel);

		// Button 이벤트 생성
		AdminAccountAdminAccountCreateEvt admCreateEvt = new AdminAccountAdminAccountCreateEvt(this);
		admCreateButton.addActionListener(admCreateEvt);
		admCloseButton.addActionListener(admCreateEvt);

	} // AdminAccountAdminAccountCreateView

	// getter method
	public JTextField getAdmNameTextSet() {
		return admNameTextSet;
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

	public JButton getAdmCreateButton() {
		return admCreateButton;
	}

	public JButton getAdmCloseButton() {
		return admCloseButton;
	}

} // class
