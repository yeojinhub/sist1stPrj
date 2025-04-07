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
public class AdminAccountAdminAccountModifyView extends JPanel{
	
	private JButton jbtnAdminAccountAdminAccountModify;
    private JButton jbtnAdminAccountAdmintAccountDelete;
	private JButton jbtnAdminAccountAdmintAccountClose;
	
	public AdminAccountAdminAccountModifyView() {
		
    	//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension buttonSize = new Dimension(120, 40);
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel jpAdminAccountAdminAccountModifyViewPanel = new JPanel(new GridBagLayout());
		jpAdminAccountAdminAccountModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		jpAdminAccountAdminAccountModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		jpAdminAccountAdminAccountModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
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
		jtfAdminAccountAdminAccountNameText.setEditable(false);
		
		//사번 Component 생성
		JLabel jlblAdminAccountAdminAccountIDTitle = new JLabel("사번");
		JTextField jtfAdminAccountAdminAccountIDText = new JTextField();
		jlblAdminAccountAdminAccountIDTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountIDText.setPreferredSize(fieldSize);
		jtfAdminAccountAdminAccountIDText.setEditable(false);
		
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
		jtfAdminAccountAdminAccountBirthText.setEditable(false);
		
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
		JPanel jpAdminAccountAdminAccountModifyViewButtonPanel = new JPanel();
		jpAdminAccountAdminAccountModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpAdminAccountAdminAccountModifyViewButtonPanel.setBackground(white);
		jbtnAdminAccountAdminAccountModify = new JButton("수정");
		jbtnAdminAccountAdminAccountModify.setBackground(lightblue);
		jbtnAdminAccountAdminAccountModify.setSize(buttonSize);
		jbtnAdminAccountAdminAccountModify.setFont(buttonFont);
        jbtnAdminAccountAdmintAccountDelete = new JButton("삭제");
        jbtnAdminAccountAdmintAccountDelete.setBackground(lightblue);
        jbtnAdminAccountAdmintAccountDelete.setSize(buttonSize);
        jbtnAdminAccountAdmintAccountDelete.setFont(buttonFont);
		jbtnAdminAccountAdmintAccountClose = new JButton("닫기");
		jbtnAdminAccountAdmintAccountClose.setBackground(lightblue);
		jbtnAdminAccountAdmintAccountClose.setSize(buttonSize);
		jbtnAdminAccountAdmintAccountClose.setFont(buttonFont);
		
		jpAdminAccountAdminAccountModifyViewButtonPanel.add(jbtnAdminAccountAdminAccountModify);
		jpAdminAccountAdminAccountModifyViewButtonPanel.add(jbtnAdminAccountAdmintAccountDelete);
		jpAdminAccountAdminAccountModifyViewButtonPanel.add(jbtnAdminAccountAdmintAccountClose);
		
		//Component 배치
		//이름 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jtfAdminAccountAdminAccountNameText, gbc);
		
		//사번 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountIDTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jtfAdminAccountAdminAccountIDText, gbc);
		
		//비밀번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountPassTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jpfAdminAccountAdminAccountPassText, gbc);
		
		//생년월일 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountBirthTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jtfAdminAccountAdminAccountBirthText, gbc);
		
		//전화번호 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountTelTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jtfAdminAccountAdminAccountTelText, gbc);
		
		//주소 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		jpAdminAccountAdminAccountModifyViewPanel.add(jlblAdminAccountAdminAccountAddressTitle, gbc);
		gbc.gridx = 1;
		jpAdminAccountAdminAccountModifyViewPanel.add(jtfAdminAccountAdminAccountAddressText, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 6;
		gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
		jpAdminAccountAdminAccountModifyViewPanel.add(jpAdminAccountAdminAccountModifyViewButtonPanel, gbc);
		
		//Panel 배치
		add(jpAdminAccountAdminAccountModifyViewPanel);
	
		//Button 이벤트 생성
		AdminAccountAdminAccountModifyEvt aaaamEvt = new AdminAccountAdminAccountModifyEvt(this);
		jbtnAdminAccountAdminAccountModify.addActionListener(aaaamEvt);
		jbtnAdminAccountAdmintAccountDelete.addActionListener(aaaamEvt);
		jbtnAdminAccountAdmintAccountClose.addActionListener(aaaamEvt);

	} //AdminAccountAdminAccountModifyView

	//getter method
	public JButton getJbtnAdminAccountAdminAccountModify() {
		return jbtnAdminAccountAdminAccountModify;
	} //getJbtnAdminAccountAdminAccountModify
	
	public JButton getJbtnAdminAccountAdmintAccountDelete() {
		return jbtnAdminAccountAdmintAccountDelete;
	}

	public JButton getJbtnAdminAccountAdmintAccountClose() {
		return jbtnAdminAccountAdmintAccountClose;
	} //getJbtnAdminAccountAdmintAccountClose

} //class
