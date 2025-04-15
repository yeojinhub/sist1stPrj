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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminCourseModifyView extends JPanel {

	@SuppressWarnings("unused")
	private AdminCourseEvt courEvt;
	
	private JTextField courCardinalTextSet;
	private JTextField jtfAdminCourseNameSet;
	private JTextField jtfAdminCourseStatusSet;
	private JTextField jtfAdminCourseStartdateSet;
	private JTextField jtfAdminCourseEnddateSet;

	private JButton courseModifyButton;
	private JButton jbtnAdminCourseDelete;
	private JButton jbtnAdminCourseClose;
	
	private JComboBox<String> courseInstructorNameBox;
	
	private int courNum;

	public AdminCourseModifyView(AdminCourseEvt courEvt, int courNum) {
		this.courEvt=courEvt;
		this.courNum=courNum;
		
		//디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
		
		//Dimension 사이즈 설정
		Dimension buttonSize = new Dimension(120, 40);
		
		setLayout(new BorderLayout());
		
		// ---------- 왼쪽 입력 패널 ----------
		JPanel jpAdminCourseModifyViewPanel = new JPanel(new GridBagLayout());
		jpAdminCourseModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		jpAdminCourseModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		jpAdminCourseModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
		//기수 Component 생성
		JLabel jlblAdminCourseCardinalTitle = new JLabel("기수");
		jlblAdminCourseCardinalTitle.setPreferredSize(labelSize);
		courCardinalTextSet = new JTextField();
		courCardinalTextSet.setPreferredSize(fieldSize);
		
		//과정명 Component 생성
		JLabel jlblAdminCourseNameTitle = new JLabel("과정명");
		jlblAdminCourseNameTitle.setPreferredSize(labelSize);
		jtfAdminCourseNameSet = new JTextField();
		jtfAdminCourseNameSet.setPreferredSize(fieldSize);
		
		//진행상태 Component 생성
		JLabel jlblAdminCourseStatusTitle = new JLabel("진행상태");
		jlblAdminCourseStatusTitle.setPreferredSize(labelSize);
		jtfAdminCourseStatusSet = new JTextField();
		jtfAdminCourseStatusSet.setPreferredSize(fieldSize);
		
		//담당강사 Component 생성
		JLabel jlblAdminCourseInstructorNameTitle = new JLabel("담당강사");
		jlblAdminCourseInstructorNameTitle.setPreferredSize(labelSize);
		courseInstructorNameBox = new JComboBox<String>();
		courseInstructorNameBox.setPreferredSize(fieldSize);
		
		//시작일 Component 생성
		JLabel jlblAdminCourseStartdateTitle = new JLabel("시작일");
		jlblAdminCourseStartdateTitle.setPreferredSize(labelSize);
		jtfAdminCourseStartdateSet = new JTextField();
		jtfAdminCourseStartdateSet.setPreferredSize(fieldSize);
		
		//종료일 Component 생성
		JLabel courEnddateTitleLabel = new JLabel("종료일");
		courEnddateTitleLabel.setPreferredSize(labelSize);
		jtfAdminCourseEnddateSet = new JTextField();
		jtfAdminCourseEnddateSet.setPreferredSize(fieldSize);
		
		//Button 생성
		JPanel courModifyViewButtonPanel = new JPanel();
		courModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		courModifyViewButtonPanel.setBackground(white);
		
		courseModifyButton = new JButton("수정");
		courseModifyButton.setBackground(lightblue);
		courseModifyButton.setSize(buttonSize);
		courseModifyButton.setFont(buttonFont);
		
		jbtnAdminCourseDelete = new JButton("삭제");
		jbtnAdminCourseDelete.setBackground(lightblue);
		jbtnAdminCourseDelete.setSize(buttonSize);
		jbtnAdminCourseDelete.setFont(buttonFont);
		jbtnAdminCourseClose = new JButton("닫기");
		jbtnAdminCourseClose.setBackground(lightblue);
		jbtnAdminCourseClose.setSize(buttonSize);
		jbtnAdminCourseClose.setFont(buttonFont);
		
		courModifyViewButtonPanel.add(courseModifyButton);
		courModifyViewButtonPanel.add(jbtnAdminCourseDelete);
		courModifyViewButtonPanel.add(jbtnAdminCourseClose);
		
		//Component 배치
		//과정명 Component 배치
		gbc.gridx = 0; gbc.gridy = 0;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseNameSet, gbc);
		
		//기수 Component 배치
		gbc.gridx = 0; gbc.gridy = 1;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseCardinalTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(courCardinalTextSet, gbc);
		
		//진행상태 Component 배치
		gbc.gridx = 0; gbc.gridy = 2;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseStatusTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseStatusSet, gbc);
		
		//담당강사 Component 배치
		gbc.gridx = 0; gbc.gridy = 3;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseInstructorNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(courseInstructorNameBox, gbc);
		
		//시작일 Component 배치
		gbc.gridx = 0; gbc.gridy = 4;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseStartdateTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseStartdateSet, gbc);
		
		//종료일 Component 배치
		gbc.gridx = 0; gbc.gridy = 5;
		jpAdminCourseModifyViewPanel.add(courEnddateTitleLabel, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseEnddateSet, gbc);
		
		//버튼 Component 배치
		gbc.gridx = 0; gbc.gridy = 6;
		gbc.gridwidth = 3;  // 세 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		jpAdminCourseModifyViewPanel.add(courModifyViewButtonPanel, gbc);
		
		//Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminCourseModifyViewPanel, BorderLayout.WEST);
		
		//Button 이벤트 생성
		AdminCourseModifyEvt courModifyEvt = new AdminCourseModifyEvt(this);
		courseModifyButton.addActionListener(courModifyEvt);
		jbtnAdminCourseDelete.addActionListener(courModifyEvt);
		jbtnAdminCourseClose.addActionListener(courModifyEvt);
		
	} //AdminCourseModifyView

	public JTextField getCourCardinalTextSet() {
		return courCardinalTextSet;
	}

	public JTextField getJtfAdminCourseNameSet() {
		return jtfAdminCourseNameSet;
	}

	public JTextField getJtfAdminCourseStatusSet() {
		return jtfAdminCourseStatusSet;
	}

	public JTextField getJtfAdminCourseStartdateSet() {
		return jtfAdminCourseStartdateSet;
	}

	public JTextField getJtfAdminCourseEnddateSet() {
		return jtfAdminCourseEnddateSet;
	}

	public JButton getCourseModifyButton() {
		return courseModifyButton;
	}

	public JButton getJbtnAdminCourseDelete() {
		return jbtnAdminCourseDelete;
	}

	public JButton getJbtnAdminCourseClose() {
		return jbtnAdminCourseClose;
	}

	public JComboBox<String> getCourseInstructorNameBox() {
		return courseInstructorNameBox;
	}

	public int getCourNum() {
		return courNum;
	}

} // class
