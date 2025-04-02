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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminAccountStudentAccountView extends JPanel {

	private JButton jbtnAdminAccountStudentAccountCreate;
    private JButton jbtnAdminAccountStudentAccountModify;
    private JButton jbtnAdminAccountStudentAccountDelete;
	
    public AdminAccountStudentAccountView() {

        // ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminAccountStudentAccountViewInfoPanel = new JPanel(new GridBagLayout());
        jpAdminAccountStudentAccountViewInfoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminAccountStudentAccountViewInfoPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminAccountStudentAccountViewInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

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
        
        //학번 Component 생성
        JLabel jlblAdminAccountStudentAccountIDTitle = new JLabel("학번");
        JTextField jtfAdminAccountStudentAccountIDText = new JTextField();
        jlblAdminAccountStudentAccountIDTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountIDText.setPreferredSize(fieldSize);

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
        
        //전화번호 Component 생성
        JLabel jlblAdminAccountStudentAccountTelTitle = new JLabel("전화번호");
        JTextField jtfAdminAccountStudentAccountTelText = new JTextField();
        jlblAdminAccountStudentAccountTelTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountTelText.setPreferredSize(fieldSize);

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
        
        //상태 Component 생성
        JLabel jlblAdminAccountStudentAccountStatusTitle = new JLabel("상태");
        JTextField jtfAdminAccountStudentAccountStatusText = new JTextField();
        jlblAdminAccountStudentAccountStatusTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountStatusText.setPreferredSize(fieldSize);
        
        //교육기간 Component 생성
        JLabel jlblAdminAccountStudentAccountCourseDateTitle = new JLabel("교육 기간");
        JTextField jtfAdminAccountStudentAccountCourseDateText = new JTextField();
        jlblAdminAccountStudentAccountCourseDateTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountCourseDateText.setPreferredSize(fieldSize);
        
        //기수 Component 생성
        JLabel jlblAdminAccountStudentAccountCardinalTitle = new JLabel("기수");
        JTextField jtfAdminAccountStudentAccountCardinalText = new JTextField();
        jlblAdminAccountStudentAccountCardinalTitle.setPreferredSize(labelSize);
        jtfAdminAccountStudentAccountCardinalText.setPreferredSize(fieldSize);
        
        //Button 생성
        JPanel jpAdminAccountStudentAccountViewButtonPanel = new JPanel();
        jpAdminAccountStudentAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminAccountStudentAccountCreate = new JButton("생성");
        jbtnAdminAccountStudentAccountModify = new JButton("수정");
        jbtnAdminAccountStudentAccountDelete = new JButton("삭제");
        
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountCreate);
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountModify);
        jpAdminAccountStudentAccountViewButtonPanel.add(jbtnAdminAccountStudentAccountDelete);
        
        
        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountNameText, gbc);
        
        //학번 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountIDTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountIDText, gbc);

        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jpfAdminAccountStudentAccountPassText, gbc);

        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountBirthText, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountTelText, gbc);

        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountAddressText, gbc);
        
        //과정명 Component 배치
        gbc.gridx = 0; gbc.gridy = 6;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountCourseNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jcbAdminAccountStudentAccountCourseNameBox, gbc);
        
        //담당강사 Component 배치
        gbc.gridx = 0; gbc.gridy = 7;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountInstructorNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountInstructorNameText, gbc);
        
        //교육기간 Component 배치
        gbc.gridx = 0; gbc.gridy = 8;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountCourseDateTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountCourseDateText, gbc);
        
        //상태 Component 배치
        gbc.gridx = 0; gbc.gridy = 9;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountStatusTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountStatusText, gbc);
        
        //기수 Component 배치
        gbc.gridx = 0; gbc.gridy = 10;
        jpAdminAccountStudentAccountViewInfoPanel.add(jlblAdminAccountStudentAccountCardinalTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountStudentAccountViewInfoPanel.add(jtfAdminAccountStudentAccountCardinalText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminAccountStudentAccountViewInfoPanel.add(jpAdminAccountStudentAccountViewButtonPanel, gbc);

        //Table 타이틀 생성
        String[] strAdminAccountStudentAccountViewTableTitle = {
            "학번", "이름", "전화번호", "기수", "교육과정", "교육기간", "진행상태"
        };

        //Table 가데이터 생성
        String[][] strAdminAccountStudentAccountViewTableData = {
            { "20250001", "강태일", "010-1234-5678", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250002", "김민경", "010-1111-1111", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250003", "이여진", "010-8241-8701", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "진행중" },
            { "20250004", "이재준", "010-0000-0000", "25-3", "AWS와 Docker & Kubernetes 과정", "2025-01-13~2025-07-25", "중도하차" },
        };

        //Table Component 생성
        DefaultTableModel dftmStudentTableModel = new DefaultTableModel(strAdminAccountStudentAccountViewTableData, strAdminAccountStudentAccountViewTableTitle);
        JTable jtAdminAccountStudentAccountTable = new JTable(dftmStudentTableModel);
        
        //Table 수정 불가능
        jtAdminAccountStudentAccountTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountStudentAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 2:
        		columnModel.getColumn(i).setPreferredWidth(100); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(200); break;
        	case 5:
        		columnModel.getColumn(i).setPreferredWidth(150); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminAccountStudentAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //Table Component 배치
        JScrollPane spAdminAccountStudentAccountViewScroll = new JScrollPane(jtAdminAccountStudentAccountTable);
        spAdminAccountStudentAccountViewScroll.setPreferredSize(new Dimension(773,500));
        JPanel jpAdminAccountStudentAccountViewTablePanel = new JPanel(new BorderLayout());
        jpAdminAccountStudentAccountViewTablePanel.add(spAdminAccountStudentAccountViewScroll, BorderLayout.CENTER);

        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminAccountStudentAccountViewInfoPanel, BorderLayout.WEST);
        add(jpAdminAccountStudentAccountViewTablePanel, BorderLayout.CENTER);
        
        //Button 이벤트 생성
        AdminAccountStudentAccountEvt aasae = new AdminAccountStudentAccountEvt(this); 
        jbtnAdminAccountStudentAccountCreate.addActionListener(aasae);
        jbtnAdminAccountStudentAccountModify.addActionListener(aasae);
        jbtnAdminAccountStudentAccountDelete.addActionListener(aasae);
        
    } //AdminAccountStudentAccountView

    //getter method
	public JButton getJbtnAdminAccountStudentAccountCreate() {
		return jbtnAdminAccountStudentAccountCreate;
	} //getJbtnAdminAccountStudentAccountCreate

	public JButton getJbtnAdminAccountStudentAccountModify() {
		return jbtnAdminAccountStudentAccountModify;
	} //getJbtnAdminAccountStudentAccountModify

	public JButton getJbtnAdminAccountStudentAccountDelete() {
		return jbtnAdminAccountStudentAccountDelete;
	} //getJbtnAdminAccountStudentAccountDelete

} //class