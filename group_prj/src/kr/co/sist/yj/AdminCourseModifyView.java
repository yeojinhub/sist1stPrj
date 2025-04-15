package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class AdminCourseModifyView extends JPanel {

	private JTextField jtfAdminCourseCardinalSet;
	private JTextField jtfAdminCourseNameSet;
	private JTextField jtfAdminCourseStatusSet;
	private JFormattedTextField jtfAdminCourseStartdateSet;
	private JFormattedTextField jtfAdminCourseEnddateSet;

	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	private JButton jbtnAdminCourseClose;
	
	private JComboBox<String> jcbAdminCourseInstructorNameBox;
	
	private AdminCourseVO selectedCourseInfo;

	public AdminCourseModifyView(AdminMainView amv, AdminCourseView acv) {
		this.selectedCourseInfo = acv.getSelectedCourInfo();
		// 디자인(색깔,글씨) 설정
		Color white = new Color(255, 255, 255);
		Color lightblue = new Color(235, 235, 255);
		Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);

		// Dimension 사이즈 설정
		Dimension buttonSize = new Dimension(120, 40);

		setLayout(new BorderLayout());

		// ---------- 왼쪽 입력 패널 ----------
		JPanel jpAdminCourseModifyViewPanel = new JPanel(new GridBagLayout());
		jpAdminCourseModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		jpAdminCourseModifyViewPanel.setMinimumSize(new Dimension(350, 400));
		jpAdminCourseModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
		jpAdminCourseModifyViewPanel.setBackground(white);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 4, 8, 4);
		gbc.anchor = GridBagConstraints.WEST;

		// JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
		Dimension fieldSize = new Dimension(200, 22);

		// Component 생성
		// 기수 Component 생성
		JLabel jlblAdminCourseCardinalTitle = new JLabel("기수");
		jlblAdminCourseCardinalTitle.setPreferredSize(labelSize);
		jtfAdminCourseCardinalSet = new JTextField();
		jtfAdminCourseCardinalSet.setPreferredSize(fieldSize);

		// 과정명 Component 생성
		JLabel jlblAdminCourseNameTitle = new JLabel("과정명");
		jlblAdminCourseNameTitle.setPreferredSize(labelSize);
		jtfAdminCourseNameSet = new JTextField();
		jtfAdminCourseNameSet.setPreferredSize(fieldSize);

		// 진행상태 Component 생성
		JLabel jlblAdminCourseStatusTitle = new JLabel("진행상태");
		jlblAdminCourseStatusTitle.setPreferredSize(labelSize);
		jtfAdminCourseStatusSet = new JTextField();
		jtfAdminCourseStatusSet.setPreferredSize(fieldSize);

		// 담당강사 Component 생성
		JLabel jlblAdminCourseInstructorNameTitle = new JLabel("담당강사");
		jcbAdminCourseInstructorNameBox = new JComboBox<String>();
		jlblAdminCourseInstructorNameTitle.setPreferredSize(labelSize);
		jcbAdminCourseInstructorNameBox.setPreferredSize(fieldSize);
		jcbAdminCourseInstructorNameBox.setBackground(new Color(255,255,255));

		// Foreach로 선생님 성함을 JComboBox에 담아보자~
//		for (String str : acv.getInstructorNameNotSame()) {
//			jcbAdminCourseInstructorNameBox.addItem(str);
//		} // end for
		

		// 시작일, 종료일 TextField를 ####-##-##로 고정
		MaskFormatter dateFormatter = null;
		try {
			dateFormatter = new MaskFormatter("####-##-##");
			dateFormatter.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 시작일 Component 생성
		JLabel jlblAdminCourseStartdateTitle = new JLabel("시작일");
		jlblAdminCourseStartdateTitle.setPreferredSize(labelSize);
		jtfAdminCourseStartdateSet = new JFormattedTextField(dateFormatter);
		jtfAdminCourseStartdateSet.setPreferredSize(fieldSize);

		// 종료일 Component 생성
		JLabel jlblAdminCourseEnddateTitle = new JLabel("종료일");
		jlblAdminCourseEnddateTitle.setPreferredSize(labelSize);
		jtfAdminCourseEnddateSet = new JFormattedTextField(dateFormatter);
		jtfAdminCourseEnddateSet.setPreferredSize(fieldSize);

		// Button 생성
		JPanel jpAdminCourseModifyViewButtonPanel = new JPanel();
		jpAdminCourseModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpAdminCourseModifyViewButtonPanel.setBackground(white);
		jbtnAdminCourseModify = new JButton("수정");
		jbtnAdminCourseModify.setBackground(lightblue);
		jbtnAdminCourseModify.setSize(buttonSize);
		jbtnAdminCourseModify.setFont(buttonFont);
		jbtnAdminCourseDelete = new JButton("삭제");
		jbtnAdminCourseDelete.setBackground(lightblue);
		jbtnAdminCourseDelete.setSize(buttonSize);
		jbtnAdminCourseDelete.setFont(buttonFont);
		jbtnAdminCourseClose = new JButton("닫기");
		jbtnAdminCourseClose.setBackground(lightblue);
		jbtnAdminCourseClose.setSize(buttonSize);
		jbtnAdminCourseClose.setFont(buttonFont);

		jpAdminCourseModifyViewButtonPanel.add(jbtnAdminCourseModify);
		jpAdminCourseModifyViewButtonPanel.add(jbtnAdminCourseDelete);
		jpAdminCourseModifyViewButtonPanel.add(jbtnAdminCourseClose);

		// Component 배치
		// 과정명 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 0;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseNameSet, gbc);

		// 기수 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 1;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseCardinalTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseCardinalSet, gbc);

		// 진행상태 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 2;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseStatusTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseStatusSet, gbc);

		// 담당강사 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 3;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseInstructorNameTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jcbAdminCourseInstructorNameBox, gbc);

		// 시작일 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 4;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseStartdateTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseStartdateSet, gbc);

		// 종료일 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 5;
		jpAdminCourseModifyViewPanel.add(jlblAdminCourseEnddateTitle, gbc);
		gbc.gridx = 1;
		jpAdminCourseModifyViewPanel.add(jtfAdminCourseEnddateSet, gbc);

		// 버튼 Component 배치
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2; // 두 열을 합쳐서 버튼들을 가운데로 배치
		jpAdminCourseModifyViewPanel.add(jpAdminCourseModifyViewButtonPanel, gbc);

		// Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminCourseModifyViewPanel, BorderLayout.WEST);
		
		// 아 몰라, View에서 데이터 셋팅하자
		if(acv.getJtAdminCourseTable().getSelectedRow() != -1) {
			jtfAdminCourseCardinalSet.setText(acv.getSelectedCourInfo().getCourCardinal());
			jtfAdminCourseNameSet.setText(acv.getSelectedCourInfo().getCourName());
			jtfAdminCourseStatusSet.setText(acv.getSelectedCourInfo().getCourStatus());
			jcbAdminCourseInstructorNameBox.setSelectedItem(acv.getSelectedCourInfo().getInstName());
			jtfAdminCourseStartdateSet.setText(acv.getSelectedCourInfo().getCourStartdate());
			jtfAdminCourseEnddateSet.setText(acv.getSelectedCourInfo().getCourEnddate());
		}// end if

		// Button 이벤트 생성
		AdminCourseModifyEvt acmEvt = new AdminCourseModifyEvt(this, acv);
		jbtnAdminCourseModify.addActionListener(acmEvt);
		jbtnAdminCourseDelete.addActionListener(acmEvt);
		jbtnAdminCourseClose.addActionListener(acmEvt);

	} // AdminCourseModifyView

	// getter method
	public JTextField getJtfAdminCourseCardinalSet() {
		return jtfAdminCourseCardinalSet;
	}

	public JTextField getJtfAdminCourseNameSet() {
		return jtfAdminCourseNameSet;
	}

	public JTextField getJtfAdminCourseStatusSet() {
		return jtfAdminCourseStatusSet;
	}

	public JFormattedTextField getJtfAdminCourseStartdateSet() {
		return jtfAdminCourseStartdateSet;
	}

	public JFormattedTextField getJtfAdminCourseEnddateSet() {
		return jtfAdminCourseEnddateSet;
	}

	public JButton getJbtnAdminCourseModify() {
		return jbtnAdminCourseModify;
	} // getJbtnAdminCourseModify

	public JButton getJbtnAdminCourseDelete() {
		return jbtnAdminCourseDelete;
	}

	public JButton getJbtnAdminCourseClose() {
		return jbtnAdminCourseClose;
	} // getJbtnAdminCourseClose

	public AdminCourseVO getSelectedCourseInfo() {
		return selectedCourseInfo;
	}

	public JComboBox<String> getJcbAdminCourseInstructorNameBox() {
		return jcbAdminCourseInstructorNameBox;
	}
	
	

} // class
