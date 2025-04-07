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
public class AdminCourseModifyView extends JPanel{
	
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	private JButton jbtnAdminCourseClose;
	
	public AdminCourseModifyView() {
		
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
        JTextField jtfAdminCourseCardinalText = new JTextField();
        jlblAdminCourseCardinalTitle.setPreferredSize(labelSize);
        jtfAdminCourseCardinalText.setPreferredSize(fieldSize);
        
        //과정명 Component 생성
        JLabel jlblAdminCourseNameTitle = new JLabel("과정명");
        JTextField jtfAdminCourseNameText = new JTextField();
        jlblAdminCourseNameTitle.setPreferredSize(labelSize);
        jtfAdminCourseNameText.setPreferredSize(fieldSize);
        
        //진행상태 Component 생성
        JLabel jlblAdminCourseStatusTitle = new JLabel("진행상태");
        JTextField jtfAdminCourseStatusText = new JTextField();
        jlblAdminCourseStatusTitle.setPreferredSize(labelSize);
        jtfAdminCourseStatusText.setPreferredSize(fieldSize);
        
        //담당강사 Component 생성
        JLabel jlblAdminCourseInstructorNameTitle = new JLabel("담당강사");
        String[] strAdminCourseInstructorNameTitle = {
        		"곽우신", "곽우심", "박우신", "강우신"
        };
        JComboBox<String> jcbAdminCourseInstructorNameBox = new JComboBox<String>(strAdminCourseInstructorNameTitle);
        jlblAdminCourseInstructorNameTitle.setPreferredSize(labelSize);
        jcbAdminCourseInstructorNameBox.setPreferredSize(fieldSize);
        
        //시작일 Component 생성
        JLabel jlblAdminCourseStartdateTitle = new JLabel("시작일");
        JTextField jtfAdminCourseStartdateText = new JTextField();
        jlblAdminCourseStartdateTitle.setPreferredSize(labelSize);
        jtfAdminCourseStartdateText.setPreferredSize(fieldSize);
        
        //종료일 Component 생성
        JLabel jlblAdminCourseEnddateTitle = new JLabel("종료일");
        JTextField jtfAdminCourseEnddateText = new JTextField();
        jlblAdminCourseEnddateTitle.setPreferredSize(labelSize);
        jtfAdminCourseEnddateText.setPreferredSize(fieldSize);
        
        //Button 생성
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
        
        //Component 배치
        //과정명 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jtfAdminCourseNameText, gbc);
        
        //기수 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseCardinalTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jtfAdminCourseCardinalText, gbc);
        
        //진행상태 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseStatusTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jtfAdminCourseStatusText, gbc);
        
        //담당강사 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseInstructorNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jcbAdminCourseInstructorNameBox, gbc);
        
        //시작일 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseStartdateTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jtfAdminCourseStartdateText, gbc);
        
        //종료일 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminCourseModifyViewPanel.add(jlblAdminCourseEnddateTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseModifyViewPanel.add(jtfAdminCourseEnddateText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminCourseModifyViewPanel.add(jpAdminCourseModifyViewButtonPanel, gbc);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminCourseModifyViewPanel, BorderLayout.WEST);
        
        //Button 이벤트 생성
        AdminCourseModifyEvt acmEvt = new AdminCourseModifyEvt(this);
        jbtnAdminCourseModify.addActionListener(acmEvt);
        jbtnAdminCourseDelete.addActionListener(acmEvt);
        jbtnAdminCourseClose.addActionListener(acmEvt);
		
	} //AdminCourseModifyView

	//getter method
	public JButton getJbtnAdminCourseModify() {
		return jbtnAdminCourseModify;
	} //getJbtnAdminCourseModify
	
	public JButton getJbtnAdminCourseDelete() {
		return jbtnAdminCourseDelete;
	}

	public JButton getJbtnAdminCourseClose() {
		return jbtnAdminCourseClose;
	} //getJbtnAdminCourseClose

} //class
