//package kr.co.sist.view;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AdminAccountStudentAccountModifyView extends JPanel{
	
	private JTextField jtfAdminAccountStudentAccountNameSet;
	private JTextField jtfAdminAccountStudentAccountIDSet;
	private JPasswordField jpfAdminAccountStudentAccountPassSet;
	private JTextField jtfAdminAccountStudentAccountBirthSet;
	private JTextField jtfAdminAccountStudentAccountTelSet;
	private JTextField jtfAdminAccountStudentAccountAddressSet;
	private JTextField jtfAdminAccountStudentAccountStatusSet;
	
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
    private JButton jbtnAdminAccountStudentAccountClose;
	
    public AdminAccountStudentAccountModifyView() {
    	setLayout(new BorderLayout());

    	//디자인(색깔,글씨) 설정
    	Color white = new Color(255, 255, 255);
    	Color lightblue = new Color(235, 235, 255);
    	Font buttonFont = new Font("맑은 고딕", Font.BOLD, 18);
    	
    	//Dimension 사이즈 설정
    	Dimension buttonSize = new Dimension(120, 40);
    	
        // ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminAccountStudentAccountModifyViewPanel = new JPanel(new GridBagLayout());
        jpAdminAccountStudentAccountModifyViewPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminAccountStudentAccountModifyViewPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminAccountStudentAccountModifyViewPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 4, 8, 4);
        gbc.anchor = GridBagConstraints.WEST;

        //JLabel, Field 사이즈 설정
        Dimension labelSize = new Dimension(100, 22);
        Dimension fieldSize = new Dimension(200, 22);

        //Component 생성
        //이름 Component 생성
        JLabel jlblAdminAccountStudentAccountNameTitle = new JLabel("이름");
        jlblAdminAccountStudentAccountNameTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountNameSet = new JTextField();
        jtfAdminAccountStudentAccountNameSet.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountNameSet.setEditable(false);
        
        //학번 Component 생성
        JLabel jlblAdminAccountStudentAccountIDTitle = new JLabel("학번");
        jlblAdminAccountStudentAccountIDTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountIDSet = new JTextField();
        jtfAdminAccountStudentAccountIDSet.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountIDSet.setEditable(false);

        //비밀번호 Component 생성
        JLabel jlblAdminAccountStudentAccountPassTitle = new JLabel("비밀번호");
        jlblAdminAccountStudentAccountPassTitle.setPreferredSize(labelSize);
        jpfAdminAccountStudentAccountPassSet = new JPasswordField();
        jpfAdminAccountStudentAccountPassSet.setPreferredSize(fieldSize);

        //생년월일 Component 생성
        JLabel jlblAdminAccountStudentAccountBirthTitle = new JLabel("생년월일");
        jtfAdminAccountStudentAccountBirthSet = new JTextField();
        jlblAdminAccountStudentAccountBirthTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountBirthSet.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountBirthSet.setEditable(false);
        
        //전화번호 Component 생성
        JLabel jlblAdminAccountStudentAccountTelTitle = new JLabel("전화번호");
        jlblAdminAccountStudentAccountTelTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountTelSet = new JTextField();
        jtfAdminAccountStudentAccountTelSet.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountTelSet.requestFocus();

        //주소 Component 생성
        JLabel jlblAdminAccountStudentAccountAddressTitle = new JLabel("주소");
        jlblAdminAccountStudentAccountAddressTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountAddressSet = new JTextField();
        jtfAdminAccountStudentAccountAddressSet.setPreferredSize(fieldSize);
        
        //과정명 Component 생성
        JLabel jlblAdminAccountStudentAccountCourseNameTitle = new JLabel("과정명");
        jlblAdminAccountStudentAccountCourseNameTitle.setPreferredSize(labelSize);
        String[] strAdminAccountStudentAccountCourseNameTitle = {" AWS와 Docker & Kubernetes", "Flutter Framework"};
        JComboBox<String> jcbAdminAccountStudentAccountCourseNameBox = new JComboBox<String>(strAdminAccountStudentAccountCourseNameTitle);
        jcbAdminAccountStudentAccountCourseNameBox.setPreferredSize(fieldSize);
        
        //강사 Component 생성
        JLabel jlblAdminAccountStudentAccountInstructorNameTitle = new JLabel("담당 강사");
        JTextField jtfAdminAccountStudentAccountInstructorNameText = new JTextField();
        jlblAdminAccountStudentAccountInstructorNameTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountInstructorNameText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountInstructorNameText.setEditable(false);
        
        //상태 Component 생성
        JLabel jlblAdminAccountStudentAccountStatusTitle = new JLabel("상태");
        jlblAdminAccountStudentAccountStatusTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountStatusSet = new JTextField();
        jtfAdminAccountStudentAccountStatusSet.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountStatusSet.setEditable(false);
        
        //교육기간 Component 생성
        JLabel jlblAdminAccountStudentAccountCourseDateTitle = new JLabel("교육 기간");
        JTextField jtfAdminAccountStudentAccountCourseDateText = new JTextField();
        jlblAdminAccountStudentAccountCourseDateTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountCourseDateText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountCourseDateText.setEditable(false);
        
        //기수 Component 생성
        JLabel jlblAdminAccountStudentAccountCardinalTitle = new JLabel("기수");
        JTextField jtfAdminAccountStudentAccountCardinalText = new JTextField();
        jlblAdminAccountStudentAccountCardinalTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountCardinalText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountCardinalText.setEditable(false);
        
        //Button 생성
        JPanel jpAdminAccountStudentAccountModifyViewButtonPanel = new JPanel();
        jpAdminAccountStudentAccountModifyViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jpAdminAccountStudentAccountModifyViewButtonPanel.setBackground(white);
        jbtnAdminAccountStudentAccountModify = new JButton("수정");
        jbtnAdminAccountStudentAccountModify.setBackground(lightblue);
        jbtnAdminAccountStudentAccountModify.setSize(buttonSize);
        jbtnAdminAccountStudentAccountModify.setFont(buttonFont);
        jbtnAdminAccountStudentAccountDelete = new JButton("삭제");
        jbtnAdminAccountStudentAccountDelete.setBackground(lightblue);
        jbtnAdminAccountStudentAccountDelete.setSize(buttonSize);
        jbtnAdminAccountStudentAccountDelete.setFont(buttonFont);
        jbtnAdminAccountStudentAccountClose = new JButton("닫기");
        jbtnAdminAccountStudentAccountClose.setBackground(lightblue);
        jbtnAdminAccountStudentAccountClose.setSize(buttonSize);
        jbtnAdminAccountStudentAccountClose.setFont(buttonFont);
        
        jpAdminAccountStudentAccountModifyViewButtonPanel.add(jbtnAdminAccountStudentAccountModify);
        jpAdminAccountStudentAccountModifyViewButtonPanel.add(jbtnAdminAccountStudentAccountDelete);
        jpAdminAccountStudentAccountModifyViewButtonPanel.add(jbtnAdminAccountStudentAccountClose);
        
        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountNameSet, gbc);
        
        //학번 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountIDTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountIDSet, gbc);

        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jpfAdminAccountStudentAccountPassSet, gbc);

        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountBirthSet, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountTelSet, gbc);

        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountAddressSet, gbc);
        
        //과정명 Component 배치
        gbc.gridx = 0; gbc.gridy = 6;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountCourseNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jcbAdminAccountStudentAccountCourseNameBox, gbc);
        
        //담당강사 Component 배치
        gbc.gridx = 0; gbc.gridy = 7;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountInstructorNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountInstructorNameText, gbc);
        
        //교육기간 Component 배치
        gbc.gridx = 0; gbc.gridy = 8;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountCourseDateTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountCourseDateText, gbc);
        
        //상태 Component 배치
        gbc.gridx = 0; gbc.gridy = 9;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountStatusTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountStatusSet, gbc);
        
        //기수 Component 배치
        gbc.gridx = 0; gbc.gridy = 10;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountCardinalTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountCardinalText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 3;  // 세 열을 합쳐서 버튼들을 가운데로 배치
        gbc.anchor = GridBagConstraints.CENTER;
        jpAdminAccountStudentAccountModifyViewPanel.add(jpAdminAccountStudentAccountModifyViewButtonPanel, gbc);

        //Panel 배치
        add(jpAdminAccountStudentAccountModifyViewPanel);
        
        //Button 이벤트 생성
        AdminAccountStudentAccountModifyEvt aasame = new AdminAccountStudentAccountModifyEvt(this); 
        jbtnAdminAccountStudentAccountModify.addActionListener(aasame);
        jbtnAdminAccountStudentAccountDelete.addActionListener(aasame);
        jbtnAdminAccountStudentAccountClose.addActionListener(aasame);
        
    } //AdminAccountStudentAccountView

    //getter method
	public JTextField getJtfAdminAccountStudentAccountNameSet() {
		return jtfAdminAccountStudentAccountNameSet;
	}

	public JTextField getJtfAdminAccountStudentAccountIDSet() {
		return jtfAdminAccountStudentAccountIDSet;
	}

	public JPasswordField getJpfAdminAccountStudentAccountPassSet() {
		return jpfAdminAccountStudentAccountPassSet;
	}

	public JTextField getJtfAdminAccountStudentAccountBirthSet() {
		return jtfAdminAccountStudentAccountBirthSet;
	}

	public JTextField getJtfAdminAccountStudentAccountTelSet() {
		return jtfAdminAccountStudentAccountTelSet;
	}

	public JTextField getJtfAdminAccountStudentAccountAddressSet() {
		return jtfAdminAccountStudentAccountAddressSet;
	}

	public JTextField getJtfAdminAccountStudentAccountStatusSet() {
		return jtfAdminAccountStudentAccountStatusSet;
	}

	public JButton getJbtnAdminAccountStudentAccountModify() {
		return jbtnAdminAccountStudentAccountModify;
	} //getJbtnAdminAccountStudentAccountModify
	
	public JButton getJbtnAdminAccountStudentAccountDelete() {
		return jbtnAdminAccountStudentAccountDelete;
	} //getJbtnAdminAccountStudentAccountDelete

	public JButton getJbtnAdminAccountStudentAccountClose() {
		return jbtnAdminAccountStudentAccountClose;
	} //getJbtnAdminAccountStudentAccountClose

} //class
