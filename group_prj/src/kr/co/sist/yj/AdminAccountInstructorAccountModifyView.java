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
public class AdminAccountInstructorAccountModifyView extends JPanel{
	
	private JTextField instNameTextSet;
	private JTextField instNumTextSet;
	private JPasswordField instPassTextSet;
	private JTextField instBirthTextSet;
	private JTextField instTelTextSet;
	private JTextField instAddTextSet;
	
	private JButton instModifyButton;
    private JButton instDeleteButton;
	private JButton instCloseButton;
	
	private String strInstNum;
	
	public AdminAccountInstructorAccountModifyView(String strInstNum) {
		this.strInstNum=strInstNum;
		
		//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension buttonSize = new Dimension(120, 40);
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel instModifyViewPanel = new JPanel(new GridBagLayout());
		instModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		instModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		instModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
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
		instNameTextSet.setEditable(false);
		
		//사번 Component 생성
		JLabel instNumTitleLabel = new JLabel("사번");
		instNumTitleLabel.setPreferredSize(labelSize);
		instNumTextSet = new JTextField();
		instNumTextSet.setPreferredSize(fieldSize);
		instNumTextSet.setEditable(false);
		
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
		instBirthTextSet.setEditable(false);
		
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
		JPanel instModifyViewButtonPanel = new JPanel();
		instModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		instModifyViewButtonPanel.setBackground(white);
		instModifyButton = new JButton("수정");
		instModifyButton.setBackground(lightblue);
		instModifyButton.setSize(buttonSize);
		instModifyButton.setFont(buttonFont);
		instDeleteButton = new JButton("삭제");
		instDeleteButton.setBackground(lightblue);
		instDeleteButton.setSize(buttonSize);
		instDeleteButton.setFont(buttonFont);
		instCloseButton = new JButton("닫기");
		instCloseButton.setBackground(lightblue);
		instCloseButton.setSize(buttonSize);
		instCloseButton.setFont(buttonFont);
		
		instModifyViewButtonPanel.add(instModifyButton);
		instModifyViewButtonPanel.add(instDeleteButton);
		instModifyViewButtonPanel.add(instCloseButton);
		
		//Component 배치
		//이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		instModifyViewPanel.add(instNameTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instNameTextSet, gbc);
		
		//사번 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		instModifyViewPanel.add(instNumTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instNumTextSet, gbc);
		
		//비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		instModifyViewPanel.add(instPassTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instPassTextSet, gbc);
		
		//생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		instModifyViewPanel.add(instBirthTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instBirthTextSet, gbc);
		
		//전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		instModifyViewPanel.add(instTelTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instTelTextSet, gbc);
		
		//주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		instModifyViewPanel.add(instAddTitleLabel, gbc);
		gbc.gridx = 1;
		instModifyViewPanel.add(instAddTextSet, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 6;
		gbc.gridwidth = 3;  // 세 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		instModifyViewPanel.add(instModifyViewButtonPanel, gbc);
		
		//Panel 배치
		add(instModifyViewPanel);
		
		//Button 이벤트 생성
		AdminAccountInstructorAccountModifyEvt instModifyEvt = new AdminAccountInstructorAccountModifyEvt(this);
		instModifyButton.addActionListener(instModifyEvt);
		instDeleteButton.addActionListener(instModifyEvt);
		instCloseButton.addActionListener(instModifyEvt);
		
	} //AdminAccountInstructorAccountModifyView

	//getter method
	public JTextField getInstNameTextSet() {
		return instNameTextSet;
	}
	
	public JTextField getInstNumTextSet() {
		return instNumTextSet;
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

	public JButton getInstModifyButton() {
		return instModifyButton;
	}

	public JButton getInstDeleteButton() {
		return instDeleteButton;
	}

	public JButton getInstCloseButton() {
		return instCloseButton;
	}

	public String getStrInstNum() {
		return strInstNum;
	}
	
} //class
