package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class AdminExamCreateView extends JPanel {

    private JButton jbtnAdminExamCreate;
    private JButton jbtnAdminExamClose;
    
    // 추가: exam_name 입력용 텍스트 필드와 과정명 선택용 콤보박스
    private JTextField jtfExamName;       
    private JComboBox<String> jcbCourseName; 

    private JTextArea jtaNo1TitleSet, jtaNo1OptionSet, jtaNo2TitleSet, jtaNo2OptionSet, 
                      jtaNo3TitleSet, jtaNo3OptionSet, jtaNo4TitleSet, jtaNo4OptionSet,
                      jtaNo5TitleSet, jtaNo5OptionSet;
    private JTextArea jtaNo1TitleInput, jtaNo2TitleInput, jtaNo3TitleInput, jtaNo4TitleInput, jtaNo5TitleInput;
    private JComboBox jcbNo1AnswerSet, jcbNo2AnswerSet, jcbNo3AnswerSet, jcbNo4AnswerSet, jcbNo5AnswerSet;
    private JScrollPane jspExam;
    
    public AdminExamCreateView() {
        setPreferredSize(new Dimension(550, 710));
        // Set background and layout for the panel
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        // Title Panel
        JPanel jpTitle = new JPanel();
        jpTitle.setBorder(new TitledBorder(""));
        jpTitle.setBackground(Color.WHITE);
        jpTitle.setBounds(10, 7, 526, 85);
        add(jpTitle);
        jpTitle.setLayout(null);

        JLabel jlblTitle = new JLabel("시험");
        jlblTitle.setBounds(2, 2, 522, 50);
        jlblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 28));
        jlblTitle.setBackground(Color.WHITE);
        jpTitle.add(jlblTitle);

        // "과목명 :" 라벨
        JLabel jlblSubjectName = new JLabel("과목명 : ");
        jlblSubjectName.setHorizontalAlignment(SwingConstants.CENTER);
        jlblSubjectName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblSubjectName.setBounds(20, 55, 80, 20);
        jpTitle.add(jlblSubjectName);

        // ====== 여기서부터 exam_name TextField & 과정명 선택 ComboBox 추가 ======
        // exam_name 텍스트필드
        jtfExamName = new JTextField();
        jtfExamName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        // 원하시는 위치/크기에 맞춰 조정하세요. (아래 예시는 예시 좌표)
        jtfExamName.setBounds(100, 55, 85, 20);
        jpTitle.add(jtfExamName);
        
        // "과정명 :" 라벨
        JLabel jlblCourseName = new JLabel("과정명 : ");
        jlblCourseName.setHorizontalAlignment(SwingConstants.CENTER);
        jlblCourseName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblCourseName.setBounds(190, 55, 80, 20);
        jpTitle.add(jlblCourseName);

        // 과정명 선택 콤보박스
     // 과정명 선택 콤보박스 
        jcbCourseName = new JComboBox<>();
        // 기존 고정값 대신 DAO를 통해 DB에서 과정명을 불러옴.
        AdminExamCreateDAO dao = new AdminExamCreateDAO();
        DefaultComboBoxModel<String> courseModel = dao.getCourseNames();
        jcbCourseName.setModel(courseModel);

        jcbCourseName.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        jcbCourseName.setBounds(260, 55, 240, 20);
        jpTitle.add(jcbCourseName);
        // ====== exam_name TextField & 과정명 선택 ComboBox 추가 끝 ======

        // Exam Board
        JPanel jpExamBoard = new JPanel();
        jpExamBoard.setBackground(new Color(255, 255, 255));
        jpExamBoard.setBorder(new TitledBorder(""));
        jpExamBoard.setLayout(null);
        jpExamBoard.setPreferredSize(new Dimension(525, 1460)); // This size is preserved if needed

        jspExam = new JScrollPane(jpExamBoard, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jspExam.setBounds(10, 100, 525, 540);
        jspExam.getVerticalScrollBar().setUnitIncrement(20);
        add(jspExam);

        // -#-1. 1번문제 컴포넌트들
        JPanel jpNo1Exam = new JPanel();
        jpNo1Exam.setBackground(new Color(255, 255, 255));
        jpNo1Exam.setBorder(new TitledBorder(""));
        jpNo1Exam.setBounds(10, 10, 485, 280);
        jpExamBoard.add(jpNo1Exam);
        jpNo1Exam.setLayout(null);

        JPanel jpNo1NumberTitle = new JPanel();
        jpNo1NumberTitle.setBackground(new Color(192, 192, 192));
        jpNo1NumberTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo1NumberTitle.setBounds(10, 10, 25, 25);
        jpNo1Exam.add(jpNo1NumberTitle);
        jpNo1NumberTitle.setLayout(new BorderLayout(0, 0));

        JLabel jlblNo1NumberTitle = new JLabel("1");
        jlblNo1NumberTitle.setBackground(new Color(255, 255, 255));
        jpNo1NumberTitle.add(jlblNo1NumberTitle);
        jlblNo1NumberTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo1NumberTitle.setHorizontalAlignment(SwingConstants.CENTER);

        jtaNo1TitleInput = new JTextArea();
        jtaNo1TitleInput.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo1TitleInput.setLineWrap(true);
        // 위치는 필요에 따라 조정하세요. 아래는 예시입니다.
        jtaNo1TitleInput.setBounds(40, 10, 300, 20);
        jpNo1Exam.add(jtaNo1TitleInput);
        
        jtaNo1TitleSet = new JTextArea();
        jtaNo1TitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo1TitleSet.setText("");
        jtaNo1TitleSet.setLineWrap(true);
        jtaNo1TitleSet.setBackground(new Color(255, 255, 255));
        jtaNo1TitleSet.setBounds(45, 5, 343, 50);
        jtaNo1TitleSet.setEditable(false);
        jtaNo1TitleSet.setHighlighter(null);
        jpNo1Exam.add(jtaNo1TitleSet);

        jtaNo1OptionSet = new JTextArea("");
        jtaNo1OptionSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo1OptionSet.setBounds(10, 65, 460, 200);
        jpNo1Exam.add(jtaNo1OptionSet);

        JPanel jpNo1AnswerPanel = new JPanel();
        jpNo1AnswerPanel.setBackground(new Color(255, 255, 255));
        jpNo1AnswerPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo1AnswerPanel.setBounds(398, 5, 82, 55);
        jpNo1Exam.add(jpNo1AnswerPanel);
        jpNo1AnswerPanel.setLayout(null);

        JLabel jlblNo1AnswerTitle = new JLabel("정답");
        jlblNo1AnswerTitle.setBounds(5, 0, 70, 20);
        jpNo1AnswerPanel.add(jlblNo1AnswerTitle);
        jlblNo1AnswerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo1AnswerTitle.setHorizontalAlignment(SwingConstants.CENTER);

        
        jcbNo1AnswerSet = new JComboBox();
        jcbNo1AnswerSet.setBounds(6, 30, 70, 20);
        jpNo1AnswerPanel.add(jcbNo1AnswerSet);
        jcbNo1AnswerSet.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));

        // -#-2. 2번문제 컴포넌트들
        JPanel jpNo2Exam = new JPanel();
        jpNo2Exam.setLayout(null);
        jpNo2Exam.setBorder(new TitledBorder(""));
        jpNo2Exam.setBackground(Color.WHITE);
        jpNo2Exam.setBounds(10, 300, 485, 280);
        jpExamBoard.add(jpNo2Exam);

        JPanel jpNo2NumberTitle = new JPanel();
        jpNo2NumberTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo2NumberTitle.setBackground(new Color(192, 192, 192));
        jpNo2NumberTitle.setBounds(10, 10, 25, 25);
        jpNo2Exam.add(jpNo2NumberTitle);
        jpNo2NumberTitle.setLayout(new BorderLayout(0, 0));

        JLabel jlblNo2NumberTitle = new JLabel("2");
        jlblNo2NumberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo2NumberTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo2NumberTitle.setBackground(new Color(255, 255, 255));
        jpNo2NumberTitle.add(jlblNo2NumberTitle, BorderLayout.CENTER);

        jtaNo2TitleInput = new JTextArea();
        jtaNo2TitleInput.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo2TitleInput.setLineWrap(true);
        // 위치는 필요에 따라 조정하세요. 아래는 예시입니다.
        jtaNo2TitleInput.setBounds(40, 10, 300, 20);
        jpNo2Exam.add(jtaNo2TitleInput);
        
        jtaNo2TitleSet = new JTextArea();
        jtaNo2TitleSet.setText("");
        jtaNo2TitleSet.setLineWrap(true);
        jtaNo2TitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo2TitleSet.setEditable(false);
        jtaNo2TitleSet.setBackground(Color.WHITE);
        jtaNo2TitleSet.setBounds(45, 5, 343, 50);
        jpNo2Exam.add(jtaNo2TitleSet);

        jtaNo2OptionSet = new JTextArea("");
        jtaNo2OptionSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo2OptionSet.setBounds(10, 65, 460, 200);
        jpNo2Exam.add(jtaNo2OptionSet);

        JPanel jpNo2AnswerPanel = new JPanel();
        jpNo2AnswerPanel.setLayout(null);
        jpNo2AnswerPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo2AnswerPanel.setBackground(Color.WHITE);
        jpNo2AnswerPanel.setBounds(398, 5, 82, 55);
        jpNo2Exam.add(jpNo2AnswerPanel);

        JLabel jlblNo2AnswerTitle = new JLabel("정답");
        jlblNo2AnswerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo2AnswerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo2AnswerTitle.setBounds(5, 0, 70, 20);
        jpNo2AnswerPanel.add(jlblNo2AnswerTitle);

        jcbNo2AnswerSet = new JComboBox();
        jcbNo2AnswerSet.setBounds(6, 30, 70, 20);
        jpNo2AnswerPanel.add(jcbNo2AnswerSet);
        jcbNo2AnswerSet.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));

        // -#-3. 3번문제 컴포넌트들
        JPanel jpNo3Exam = new JPanel();
        jpNo3Exam.setLayout(null);
        jpNo3Exam.setBorder(new TitledBorder(""));
        jpNo3Exam.setBackground(Color.WHITE);
        jpNo3Exam.setBounds(10, 590, 485, 280);
        jpExamBoard.add(jpNo3Exam);

        JPanel jpNo3NumberTitle = new JPanel();
        jpNo3NumberTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo3NumberTitle.setBackground(new Color(192, 192, 192));
        jpNo3NumberTitle.setBounds(10, 10, 25, 25);
        jpNo3Exam.add(jpNo3NumberTitle);
        jpNo3NumberTitle.setLayout(new BorderLayout(0, 0));

        JLabel jlblNo3NumberTitle = new JLabel("3");
        jlblNo3NumberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo3NumberTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo3NumberTitle.setBackground(Color.WHITE);
        jpNo3NumberTitle.add(jlblNo3NumberTitle, BorderLayout.CENTER);

        jtaNo3TitleInput = new JTextArea();
        jtaNo3TitleInput.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo3TitleInput.setLineWrap(true);
        // 위치는 필요에 따라 조정하세요. 아래는 예시입니다.
        jtaNo3TitleInput.setBounds(40, 10, 300, 20);
        jpNo3Exam.add(jtaNo3TitleInput);
        
        jtaNo3TitleSet = new JTextArea();
        jtaNo3TitleSet.setText("");
        jtaNo3TitleSet.setLineWrap(true);
        jtaNo3TitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo3TitleSet.setEditable(false);
        jtaNo3TitleSet.setBackground(Color.WHITE);
        jtaNo3TitleSet.setBounds(45, 5, 343, 50);
        jpNo3Exam.add(jtaNo3TitleSet);

        jtaNo3OptionSet = new JTextArea("");
        jtaNo3OptionSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo3OptionSet.setBounds(10, 65, 460, 200);
        jpNo3Exam.add(jtaNo3OptionSet);

        JPanel jpNo3AnswerPanel = new JPanel();
        jpNo3AnswerPanel.setLayout(null);
        jpNo3AnswerPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo3AnswerPanel.setBackground(Color.WHITE);
        jpNo3AnswerPanel.setBounds(398, 5, 82, 55);
        jpNo3Exam.add(jpNo3AnswerPanel);

        JLabel jlblNo3AnswerTitle = new JLabel("정답");
        jlblNo3AnswerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo3AnswerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo3AnswerTitle.setBounds(5, 0, 70, 20);
        jpNo3AnswerPanel.add(jlblNo3AnswerTitle);

        jcbNo3AnswerSet = new JComboBox();
        jcbNo3AnswerSet.setBounds(6, 30, 70, 20);
        jpNo3AnswerPanel.add(jcbNo3AnswerSet);
        jcbNo3AnswerSet.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));

        // -#-4. 4번문제 컴포넌트들
        JPanel jpNo4Exam = new JPanel();
        jpNo4Exam.setLayout(null);
        jpNo4Exam.setBorder(new TitledBorder(""));
        jpNo4Exam.setBackground(Color.WHITE);
        jpNo4Exam.setBounds(10, 880, 485, 280);
        jpExamBoard.add(jpNo4Exam);

        JPanel jpNo4NumberTitle = new JPanel();
        jpNo4NumberTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo4NumberTitle.setBackground(new Color(192, 192, 192));
        jpNo4NumberTitle.setBounds(10, 10, 25, 25);
        jpNo4Exam.add(jpNo4NumberTitle);
        jpNo4NumberTitle.setLayout(new BorderLayout(0, 0));

        JLabel jlblNo4NumberTitle = new JLabel("4");
        jlblNo4NumberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo4NumberTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo4NumberTitle.setBackground(new Color(255, 255, 255));
        jpNo4NumberTitle.add(jlblNo4NumberTitle, BorderLayout.CENTER);

        jtaNo4TitleInput = new JTextArea();
        jtaNo4TitleInput.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo4TitleInput.setLineWrap(true);
        // 위치는 필요에 따라 조정하세요. 아래는 예시입니다.
        jtaNo4TitleInput.setBounds(40, 10, 300, 20);
        jpNo4Exam.add(jtaNo4TitleInput);
        
        jtaNo4TitleSet = new JTextArea();
        jtaNo4TitleSet.setText("");
        jtaNo4TitleSet.setLineWrap(true);
        jtaNo4TitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo4TitleSet.setEditable(false);
        jtaNo4TitleSet.setBackground(Color.WHITE);
        jtaNo4TitleSet.setBounds(45, 5, 343, 50);
        jpNo4Exam.add(jtaNo4TitleSet);

        jtaNo4OptionSet = new JTextArea("");
        jtaNo4OptionSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo4OptionSet.setBounds(10, 65, 460, 200);
        jpNo4Exam.add(jtaNo4OptionSet);

        JPanel jpNo4AnswerPanel = new JPanel();
        jpNo4AnswerPanel.setLayout(null);
        jpNo4AnswerPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo4AnswerPanel.setBackground(Color.WHITE);
        jpNo4AnswerPanel.setBounds(398, 5, 82, 55);
        jpNo4Exam.add(jpNo4AnswerPanel);

        JLabel jlblNo4AnswerTitle = new JLabel("정답");
        jlblNo4AnswerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo4AnswerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo4AnswerTitle.setBounds(5, 0, 70, 20);
        jpNo4AnswerPanel.add(jlblNo4AnswerTitle);

        jcbNo4AnswerSet = new JComboBox();
        jcbNo4AnswerSet.setBounds(6, 30, 70, 20);
        jpNo4AnswerPanel.add(jcbNo4AnswerSet);
        jcbNo4AnswerSet.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));

        // -#-5. 5번문제 컴포넌트들
        JPanel jpNo5Exam = new JPanel();
        jpNo5Exam.setLayout(null);
        jpNo5Exam.setBorder(new TitledBorder(""));
        jpNo5Exam.setBackground(Color.WHITE);
        jpNo5Exam.setBounds(10, 1170, 485, 280);
        jpExamBoard.add(jpNo5Exam);

        JPanel jpNo5NumberTitle = new JPanel();
        jpNo5NumberTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo5NumberTitle.setBackground(new Color(192, 192, 192));
        jpNo5NumberTitle.setBounds(10, 10, 25, 25);
        jpNo5Exam.add(jpNo5NumberTitle);
        jpNo5NumberTitle.setLayout(new BorderLayout(0, 0));

        JLabel jlblNo5NumberTitle = new JLabel("5");
        jlblNo5NumberTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo5NumberTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo5NumberTitle.setBackground(Color.WHITE);
        jpNo5NumberTitle.add(jlblNo5NumberTitle, BorderLayout.CENTER);

        jtaNo5TitleInput = new JTextArea();
        jtaNo5TitleInput.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo5TitleInput.setLineWrap(true);
        // 위치는 필요에 따라 조정하세요. 아래는 예시입니다.
        jtaNo5TitleInput.setBounds(40, 10, 300, 20);
        jpNo5Exam.add(jtaNo5TitleInput);
        
        jtaNo5TitleSet = new JTextArea();
        jtaNo5TitleSet.setText("");
        jtaNo5TitleSet.setLineWrap(true);
        jtaNo5TitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo5TitleSet.setEditable(false);
        jtaNo5TitleSet.setBackground(Color.WHITE);
        jtaNo5TitleSet.setBounds(45, 5, 343, 50);
        jpNo5Exam.add(jtaNo5TitleSet);

        jtaNo5OptionSet = new JTextArea("");
        jtaNo5OptionSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jtaNo5OptionSet.setBounds(10, 65, 460, 200);
        jpNo5Exam.add(jtaNo5OptionSet);

        JPanel jpNo5AnswerPanel = new JPanel();
        jpNo5AnswerPanel.setLayout(null);
        jpNo5AnswerPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        jpNo5AnswerPanel.setBackground(Color.WHITE);
        jpNo5AnswerPanel.setBounds(398, 5, 82, 55);
        jpNo5Exam.add(jpNo5AnswerPanel);

        JLabel jlblNo5AnswerTitle = new JLabel("정답");
        jlblNo5AnswerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlblNo5AnswerTitle.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jlblNo5AnswerTitle.setBounds(5, 0, 70, 20);
        jpNo5AnswerPanel.add(jlblNo5AnswerTitle);

        jcbNo5AnswerSet = new JComboBox();
        jcbNo5AnswerSet.setBounds(6, 30, 70, 20);
        jpNo5AnswerPanel.add(jcbNo5AnswerSet);
        jcbNo5AnswerSet.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4" }));

        // Buttons Panel
        jbtnAdminExamCreate = new JButton("등록");
        jbtnAdminExamCreate.setBackground(new Color(235, 235, 255));
        jbtnAdminExamCreate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jbtnAdminExamCreate.setFocusPainted(false);
        jbtnAdminExamCreate.setBounds(135, 650, 100, 30);
        add(jbtnAdminExamCreate);

        jbtnAdminExamClose = new JButton("닫기");
        jbtnAdminExamClose.setBackground(new Color(235, 235, 255));
        jbtnAdminExamClose.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        jbtnAdminExamClose.setFocusPainted(false);
        jbtnAdminExamClose.setBounds(285, 652, 100, 30);
        add(jbtnAdminExamClose);

        // 이벤트 리스너
        AdminExamCreateEvt aece = new AdminExamCreateEvt(this);
        jbtnAdminExamCreate.addActionListener(aece);
        jbtnAdminExamClose.addActionListener(aece);
    }

    private void loadCourseNames() {
        AdminExamCreateDAO dao = new AdminExamCreateDAO();
        DefaultComboBoxModel<String> model = dao.getCourseNames();
        System.out.println(model.getSize());
        jcbCourseName.setModel(model);
    }
    
    
    // Getter methods
    public JButton getJbtnAdminExamCreate() {
        return jbtnAdminExamCreate;
    }

    public JButton getJbtnAdminExamClose() {
        return jbtnAdminExamClose;
    }

    // 기존 exam_name 및 과정명 관련 getter
    public JTextField getJtfExamName() {
        return jtfExamName;
    }

    public JComboBox<String> getJcbCourseName() {
        return jcbCourseName;
    }

    // 이미 존재하는 문제 제목(set) 관련 getter (필요 시 사용)
    public JTextArea getJtaNo1TitleSet() { return jtaNo1TitleSet; }
    public JTextArea getJtaNo2TitleSet() { return jtaNo2TitleSet; }
    public JTextArea getJtaNo3TitleSet() { return jtaNo3TitleSet; }
    public JTextArea getJtaNo4TitleSet() { return jtaNo4TitleSet; }
    public JTextArea getJtaNo5TitleSet() { return jtaNo5TitleSet; }

    // **추가**: 입력용 JTextArea에 대한 getter (없어서 NPE 발생)
    public JTextArea getJtaNo1TitleInput() {
        return jtaNo1TitleInput;
    }

    public JTextArea getJtaNo2TitleInput() {
        return jtaNo2TitleInput;
    }

    public JTextArea getJtaNo3TitleInput() {
        return jtaNo3TitleInput;
    }

    public JTextArea getJtaNo4TitleInput() {
        return jtaNo4TitleInput;
    }

    public JTextArea getJtaNo5TitleInput() {
        return jtaNo5TitleInput;
    }
    public JTextArea getJtaNo1OptionSet() {
        return jtaNo1OptionSet;
    }

    public JComboBox getJcbNo1AnswerSet() {
        return jcbNo1AnswerSet;
    }

    public JTextArea getJtaNo2OptionSet() {
        return jtaNo2OptionSet;
    }

    public JComboBox getJcbNo2AnswerSet() {
        return jcbNo2AnswerSet;
    }

    public JTextArea getJtaNo3OptionSet() {
        return jtaNo3OptionSet;
    }

    public JComboBox getJcbNo3AnswerSet() {
        return jcbNo3AnswerSet;
    }

    public JTextArea getJtaNo4OptionSet() {
        return jtaNo4OptionSet;
    }

    public JComboBox getJcbNo4AnswerSet() {
        return jcbNo4AnswerSet;
    }

    public JTextArea getJtaNo5OptionSet() {
        return jtaNo5OptionSet;
    }

    public JComboBox getJcbNo5AnswerSet() {
        return jcbNo5AnswerSet;
    }
    
}
