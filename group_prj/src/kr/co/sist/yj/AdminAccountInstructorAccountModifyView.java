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
	
	private JButton jbtnAdminAccountInstructorAccountModify;
    private JButton jbtnAdminAccountInstructorAccountDelete;
	private JButton jbtnAdminAccountInstructorAccountClose;
	
	public AdminAccountInstructorAccountModifyView() {
		
		//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension buttonSize = new Dimension(120, 40);
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel jpAdminAccountInstructorAccountModifyViewPanel = new JPanel(new GridBagLayout());
		jpAdminAccountInstructorAccountModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		jpAdminAccountInstructorAccountModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		jpAdminAccountInstructorAccountModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
		//이름 Component 생성
		JLabel jlblAdminAccountInstructorAccountNameTitle = new JLabel("이름");
		JTextField jtfAdminAccountInstructorAccountNameText = new JTextField();
		jlblAdminAccountInstructorAccountNameTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountNameText.setPreferredSize(fieldSize);
		jtfAdminAccountInstructorAccountNameText.setEditable(false);
		
		//사번 Component 생성
		JLabel jlblAdminAccountInstructorAccountIDTitle = new JLabel("사번");
		JTextField jtfAdminAccountInstructorAccountIDText = new JTextField();
		jlblAdminAccountInstructorAccountIDTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountIDText.setPreferredSize(fieldSize);
		jtfAdminAccountInstructorAccountIDText.setEditable(false);
		
		//비밀번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountPassTitle = new JLabel("비밀번호");
		JPasswordField jpfAdminAccountInstructorAccountPassText = new JPasswordField();
		jlblAdminAccountInstructorAccountPassTitle.setPreferredSize(labelSize);
		jpfAdminAccountInstructorAccountPassText.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel jlblAdminAccountInstructorAccountBirthTitle = new JLabel("생년월일");
		JTextField jtfAdminAccountInstructorAccountBirthText = new JTextField();
		jlblAdminAccountInstructorAccountBirthTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountBirthText.setPreferredSize(fieldSize);
		jtfAdminAccountInstructorAccountBirthText.setEditable(false);
		
		//전화번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountTelTitle = new JLabel("전화번호");
		JTextField jtfAdminAccountInstructorAccountTelText = new JTextField();
		jlblAdminAccountInstructorAccountTelTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountTelText.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel jlblAdminAccountInstructorAccountAddressTitle = new JLabel("주소");
		JTextField jtfAdminAccountInstructorAccountAddressText = new JTextField();
		jlblAdminAccountInstructorAccountAddressTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountAddressText.setPreferredSize(fieldSize);
		
		//Button 생성
		JPanel jpAdminAccountInstructorAccountModifyViewButtonPanel = new JPanel();
		jpAdminAccountInstructorAccountModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpAdminAccountInstructorAccountModifyViewButtonPanel.setBackground(white);
		jbtnAdminAccountInstructorAccountModify = new JButton("수정");
		jbtnAdminAccountInstructorAccountModify.setBackground(lightblue);
		jbtnAdminAccountInstructorAccountModify.setSize(buttonSize);
		jbtnAdminAccountInstructorAccountModify.setFont(buttonFont);
		jbtnAdminAccountInstructorAccountDelete = new JButton("삭제");
		jbtnAdminAccountInstructorAccountDelete.setBackground(lightblue);
		jbtnAdminAccountInstructorAccountDelete.setSize(buttonSize);
		jbtnAdminAccountInstructorAccountDelete.setFont(buttonFont);
		jbtnAdminAccountInstructorAccountClose = new JButton("닫기");
		jbtnAdminAccountInstructorAccountClose.setBackground(lightblue);
		jbtnAdminAccountInstructorAccountClose.setSize(buttonSize);
		jbtnAdminAccountInstructorAccountClose.setFont(buttonFont);
		
		jpAdminAccountInstructorAccountModifyViewButtonPanel.add(jbtnAdminAccountInstructorAccountModify);
		jpAdminAccountInstructorAccountModifyViewButtonPanel.add(jbtnAdminAccountInstructorAccountDelete);
		jpAdminAccountInstructorAccountModifyViewButtonPanel.add(jbtnAdminAccountInstructorAccountClose);
		
		//Component 배치
		//이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jtfAdminAccountInstructorAccountNameText, gbc);
		
		//사번 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountIDTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jtfAdminAccountInstructorAccountIDText, gbc);
		
		//비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountPassTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jpfAdminAccountInstructorAccountPassText, gbc);
		
		//생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountBirthTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jtfAdminAccountInstructorAccountBirthText, gbc);
		
		//전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountTelTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jtfAdminAccountInstructorAccountTelText, gbc);
		
		//주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jlblAdminAccountInstructorAccountAddressTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountInstructorAccountModifyViewPanel.add(jtfAdminAccountInstructorAccountAddressText, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 6;
		gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
		jpAdminAccountInstructorAccountModifyViewPanel.add(jpAdminAccountInstructorAccountModifyViewButtonPanel, gbc);
		
		//Panel 배치
		add(jpAdminAccountInstructorAccountModifyViewPanel);
		
		//Button 이벤트 생성
		AdminAccountInstructorAccountModifyEvt aaiame = new AdminAccountInstructorAccountModifyEvt(this);
		jbtnAdminAccountInstructorAccountModify.addActionListener(aaiame);
		jbtnAdminAccountInstructorAccountDelete.addActionListener(aaiame);
		jbtnAdminAccountInstructorAccountClose.addActionListener(aaiame);
		
	} //AdminAccountInstructorAccountModifyView

	//getter method
	public JButton getJbtnAdminAccountInstructorAccountModify() {
		return jbtnAdminAccountInstructorAccountModify;
	} //getJbtnAdminAccountInstructorAccountModify

	public JButton getJbtnAdminAccountInstructorAccountDelete() {
		return jbtnAdminAccountInstructorAccountDelete;
	}

	public JButton getJbtnAdminAccountInstructorAccountClose() {
		return jbtnAdminAccountInstructorAccountClose;
	} //getJbtnAdminAccountInstructorAccountClose
	
} //class
