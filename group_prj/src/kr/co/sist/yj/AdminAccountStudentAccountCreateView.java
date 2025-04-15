//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminAccountStudentAccountCreateView extends JPanel {

	private JTextField stuNameTextSet;
	private JPasswordField stuPassTextSet;
	private JTextField stuBirthTextSet;
	private JTextField stuTelTextSet;
	private JTextField stuAddTextSet;
	private JTextField stuStatusTextSet;
	
	private JTextField instNameTextSet;
	
	private JTextField courseDateTextSet;
	private JTextField courCardinalTextSet;
	
	private JComboBox<String> courseNameBox;

	private JButton stuCreateButton;
	private JButton stuCloseButton;

	public AdminAccountStudentAccountCreateView() {
		setLayout(new BorderLayout());

		// ---------- 왼쪽 입력 패널 ----------
		JPanel stuCreateViewPanel = new JPanel(new GridBagLayout());
		stuCreateViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		stuCreateViewPanel.setMinimumSize(new Dimension(350, 400));
		stuCreateViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;

		// JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);

		// Component 생성
		// 이름 Component 생성
		JLabel stuNameTitleLabel = new JLabel("이름");
		stuNameTitleLabel.setPreferredSize(labelSize);
		stuNameTextSet = new JTextField();
		stuNameTextSet.setPreferredSize(fieldSize);

		// 비밀번호 Component 생성
		JLabel stuPassTitleLabel = new JLabel("비밀번호");
		stuPassTitleLabel.setPreferredSize(labelSize);
		stuPassTextSet = new JPasswordField();
		stuPassTextSet.setPreferredSize(fieldSize);

		// 생년월일 Component 생성
		JLabel stuBirthTitleLabel = new JLabel("생년월일");
		stuBirthTitleLabel.setPreferredSize(labelSize);
		stuBirthTextSet = new JTextField();
		stuBirthTextSet.setPreferredSize(fieldSize);

		// 전화번호 Component 생성
		JLabel stuTelTitleLabel = new JLabel("전화번호");
		stuTelTitleLabel.setPreferredSize(labelSize);
		stuTelTextSet = new JTextField();
		stuTelTextSet.setPreferredSize(fieldSize);

		// 주소 Component 생성
		JLabel stuAddTitleLabel = new JLabel("주소");
		stuAddTitleLabel.setPreferredSize(labelSize);
		stuAddTextSet = new JTextField();
		stuAddTextSet.setPreferredSize(fieldSize);

		// 과정명 Component 생성
		JLabel courseNameTitle = new JLabel("과정명");
		courseNameTitle.setPreferredSize(labelSize);
//		String[] strAdminAccountStudentAccountCourseNameTitle = { " AWS와 Docker & Kubernetes", "Flutter Framework" };
		courseNameBox = new JComboBox<String>();
		courseNameBox.setPreferredSize(fieldSize);

		// 강사 Component 생성
		JLabel instNameTitleLabel = new JLabel("담당 강사");
		instNameTextSet = new JTextField();
		instNameTitleLabel.setPreferredSize(labelSize);
		instNameTextSet.setPreferredSize(fieldSize);

		// 상태 Component 생성
		JLabel stuStatusTitleLabel = new JLabel("상태");
		stuStatusTitleLabel.setPreferredSize(labelSize);
		stuStatusTextSet = new JTextField();
		stuStatusTextSet.setPreferredSize(fieldSize);

		// 교육기간 Component 생성
		JLabel courDateTitleLabel = new JLabel("교육 기간");
		courDateTitleLabel.setPreferredSize(labelSize);
		courseDateTextSet = new JTextField();
		courseDateTextSet.setPreferredSize(fieldSize);

		// 기수 Component 생성
		JLabel courCardinalTitleLabel = new JLabel("기수");
		courCardinalTitleLabel.setPreferredSize(labelSize);
		courCardinalTextSet = new JTextField();
		courCardinalTextSet.setPreferredSize(fieldSize);

		// Button 생성
		JPanel stuCreateViewButtonPanel = new JPanel();
		stuCreateViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		stuCreateButton = new JButton("생성");
		stuCloseButton = new JButton("닫기");

		stuCreateViewButtonPanel.add(stuCreateButton);
		stuCreateViewButtonPanel.add(stuCloseButton);

		// Component 배치
		// 이름 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 0;
		stuCreateViewPanel.add(stuNameTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuNameTextSet, gbc);

		// 비밀번호 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 1;
		stuCreateViewPanel.add(stuPassTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuPassTextSet, gbc);

		// 생년월일 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 2;
		stuCreateViewPanel.add(stuBirthTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuBirthTextSet, gbc);

		// 전화번호 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 3;
		stuCreateViewPanel.add(stuTelTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuTelTextSet, gbc);

		// 주소 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 4;
		stuCreateViewPanel.add(stuAddTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuAddTextSet, gbc);

		// 과정명 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 5;
		stuCreateViewPanel.add(courseNameTitle, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(courseNameBox, gbc);

		// 담당강사 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 6;
		stuCreateViewPanel.add(instNameTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(instNameTextSet, gbc);

		// 교육기간 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 7;
		stuCreateViewPanel.add(courDateTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(courseDateTextSet, gbc);

		// 상태 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 8;
		stuCreateViewPanel.add(stuStatusTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(stuStatusTextSet, gbc);

		// 기수 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 9;
		stuCreateViewPanel.add(courCardinalTitleLabel, gbc);
		gbc.gridx = 1;
		stuCreateViewPanel.add(courCardinalTextSet, gbc);

		// 버튼 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.gridwidth = 2; // 두 열을 합쳐서 버튼들을 가운데로 배치
		gbc.anchor = GridBagConstraints.CENTER;
		stuCreateViewPanel.add(stuCreateViewButtonPanel, gbc);

		// Panel 배치
		add(stuCreateViewPanel);

		// Button 이벤트 생성
		AdminAccountStudentAccountCreateEvt aasace = new AdminAccountStudentAccountCreateEvt(this);
		stuCreateButton.addActionListener(aasace);
		stuCloseButton.addActionListener(aasace);

	} // AdminAccountStudentAccountView

	// getter method
	public JTextField getStuNameTextSet() {
		return stuNameTextSet;
	}

	public JPasswordField getStuPassTextSet() {
		return stuPassTextSet;
	}

	public JTextField getStuBirthTextSet() {
		return stuBirthTextSet;
	}

	public JTextField getStuTelTextSet() {
		return stuTelTextSet;
	}

	public JTextField getStuAddTextSet() {
		return stuAddTextSet;
	}

	public JTextField getStuStatusTextSet() {
		return stuStatusTextSet;
	}

	public JTextField getInstNameTextSet() {
		return instNameTextSet;
	}

	public JTextField getCourseDateTextSet() {
		return courseDateTextSet;
	}

	public JTextField getCourCardinalTextSet() {
		return courCardinalTextSet;
	}

	public JButton getStuCreateButton() {
		return stuCreateButton;
	}

	public JButton getStuCloseButton() {
		return stuCloseButton;
	}


} // class
