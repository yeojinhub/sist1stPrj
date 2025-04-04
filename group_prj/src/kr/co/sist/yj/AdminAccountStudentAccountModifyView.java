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
public class AdminAccountStudentAccountModifyView extends JPanel{
	
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountClose;
	
    public AdminAccountStudentAccountModifyView() {
    	setLayout(new BorderLayout());

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
        JTextField jtfAdminAccountStudentAccountNameText = new JTextField();
        jlblAdminAccountStudentAccountNameTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountNameText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountNameText.setEditable(false);
        
        //학번 Component 생성
        JLabel jlblAdminAccountStudentAccountIDTitle = new JLabel("학번");
        JTextField jtfAdminAccountStudentAccountIDText = new JTextField();
        jlblAdminAccountStudentAccountIDTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountIDText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountIDText.setEditable(false);

        //비밀번호 Component 생성
        JLabel jlblAdminAccountStudentAccountPassTitle = new JLabel("비밀번호");
        JPasswordField jpfAdminAccountStudentAccountPassText = new JPasswordField();
        jlblAdminAccountStudentAccountPassTitle.setPreferredSize(labelSize);
        jpfAdminAccountStudentAccountPassText.setPreferredSize(fieldSize);

        //생년월일 Component 생성
        JLabel jlblAdminAccountStudentAccountBirthTitle = new JLabel("생년월일");
        JTextField jtfAdminAccountStudentAccountBirthText = new JTextField();
        jlblAdminAccountStudentAccountBirthTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountBirthText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountBirthText.setEditable(false);
        
        //전화번호 Component 생성
        JLabel jlblAdminAccountStudentAccountTelTitle = new JLabel("전화번호");
        JTextField jtfAdminAccountStudentAccountTelText = new JTextField();
        jlblAdminAccountStudentAccountTelTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountTelText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountTelText.requestFocus();

        //주소 Component 생성
        JLabel jlblAdminAccountStudentAccountAddressTitle = new JLabel("주소");
        JTextField jtfAdminAccountStudentAccountAddressText = new JTextField();
        jlblAdminAccountStudentAccountAddressTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountAddressText.setPreferredSize(fieldSize);
        
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
        JTextField jtfAdminAccountStudentAccountStatusText = new JTextField();
        jlblAdminAccountStudentAccountStatusTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountStatusText.setPreferredSize(fieldSize);
        jtfAdminAccountStudentAccountStatusText.setEditable(false);
        
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
        jbtnAdminAccountStudentAccountModify = new JButton("수정");
        jbtnAdminAccountStudentAccountClose = new JButton("닫기");
        
        jpAdminAccountStudentAccountModifyViewButtonPanel.add(jbtnAdminAccountStudentAccountModify);
        jpAdminAccountStudentAccountModifyViewButtonPanel.add(jbtnAdminAccountStudentAccountClose);
        
        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountNameText, gbc);
        
        //학번 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountIDTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountIDText, gbc);

        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jpfAdminAccountStudentAccountPassText, gbc);

        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountBirthText, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountTelText, gbc);

        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountAddressText, gbc);
        
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
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountStatusText, gbc);
        
        //기수 Component 배치
        gbc.gridx = 0; gbc.gridy = 10;
        jpAdminAccountStudentAccountModifyViewPanel.add(jlblAdminAccountStudentAccountCardinalTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountModifyViewPanel.add(jtfAdminAccountStudentAccountCardinalText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminAccountStudentAccountModifyViewPanel.add(jpAdminAccountStudentAccountModifyViewButtonPanel, gbc);

        //Panel 배치
        add(jpAdminAccountStudentAccountModifyViewPanel);
        
        //Button 이벤트 생성
        AdminAccountStudentAccountModifyEvt aasame = new AdminAccountStudentAccountModifyEvt(this); 
        jbtnAdminAccountStudentAccountModify.addActionListener(aasame);
        jbtnAdminAccountStudentAccountClose.addActionListener(aasame);
        
    } //AdminAccountStudentAccountView

    //getter method
	public JButton getJbtnAdminAccountStudentAccountModify() {
		return jbtnAdminAccountStudentAccountModify;
	} //getJbtnAdminAccountStudentAccountModify

	public JButton getJbtnAdminAccountStudentAccountClose() {
		return jbtnAdminAccountStudentAccountClose;
	} //getJbtnAdminAccountStudentAccountClose

} //class
