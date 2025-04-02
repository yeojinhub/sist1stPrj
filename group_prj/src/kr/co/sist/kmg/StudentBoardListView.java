package kr.co.sist.kmg;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class StudentBoardListView extends JDialog {

    private JPanel contentPanel = new JPanel();
    
    public static void main(String[] args) {
        new StudentBoardListView();
    }

    /**
     * 다이얼로그 생성자
     */
    public StudentBoardListView() {
        setTitle("학생 게시판");
        setBounds(100, 100, 900, 700); // 다이얼로그 크기 설정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // 다이얼로그 닫기 설정
        
        // contentPanel 설정
        contentPanel.setBackground(new Color(255, 255, 255)); // 배경 색상 설정
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // 외부 여백 설정
        contentPanel.setLayout(null); // 레이아웃을 null로 설정 (위치 직접 지정)
        setContentPane(contentPanel); // contentPanel을 다이얼로그의 내용물로 설정

        // 제목 레이블
        JLabel jlbStudentBoardWriteListTile = new JLabel("시험성적문의");
        jlbStudentBoardWriteListTile.setFont(new Font("Dialog", Font.BOLD, 30));
        jlbStudentBoardWriteListTile.setBounds(50, 70, 683, 30); // 위치 및 크기 설정
        contentPanel.add(jlbStudentBoardWriteListTile);

        // 이름 레이블
        JLabel jlbStudentBoardWriteName = new JLabel("도도도");
        jlbStudentBoardWriteName.setBounds(50, 123, 400, 30); // 위치 및 크기 설정
        contentPanel.add(jlbStudentBoardWriteName);
        jlbStudentBoardWriteName.setFont(new Font("Dialog", Font.BOLD, 25)); // 글자 크기 및 스타일 설정

     // 텍스트 영역 (내용 입력)
        JTextArea jtaStudentBoardListContentArea = new JTextArea();
        jtaStudentBoardListContentArea.setText("그냥 써봤어요"); // 기본 텍스트 설정
        jtaStudentBoardListContentArea.setBackground(new Color(243, 243, 243)); // 배경 색상 설정
        jtaStudentBoardListContentArea.setBorder(new LineBorder(Color.GRAY)); // 테두리 설정
        jtaStudentBoardListContentArea.setFont(new Font("Dialog", Font.PLAIN, 25)); // 폰트 설정

        // JTextArea의 세로 높이를 줄이기 위해 줄 수 설정
        jtaStudentBoardListContentArea.setRows(5); // 5줄 높이 설정

        // 스크롤 가능한 텍스트 영역
        JScrollPane scrollPane = new JScrollPane(jtaStudentBoardListContentArea);
        scrollPane.setBounds(50, 180, 780, 250); // scrollPane 크기 설정
        contentPanel.add(scrollPane);
        
        // 닫기 버튼 추가
        JButton JbtnStudentCloseButton = new JButton("닫기");
        JbtnStudentCloseButton.setBounds(628, 590, 200, 50); // 버튼 위치 및 크기 설정
        contentPanel.add(JbtnStudentCloseButton);
        
        JButton jbtnStudentBoardListDelete = new JButton("삭제");
        jbtnStudentBoardListDelete.setBounds(730, 123, 100, 30);
        contentPanel.add(jbtnStudentBoardListDelete);
        
        JButton jbtnStudentBoardListModify = new JButton("수정");
        jbtnStudentBoardListModify.setBounds(618, 123, 100, 30);
        contentPanel.add(jbtnStudentBoardListModify);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(50, 483, 780, 75);
        layeredPane.setBorder(new LineBorder(Color.GRAY,1));
        contentPanel.add(layeredPane);
        
        JLabel jlbStudentBoardWriteInstructorREply = new JLabel("김교수");
        jlbStudentBoardWriteInstructorREply.setFont(new Font("Dialog", Font.BOLD, 20));
        jlbStudentBoardWriteInstructorREply.setBounds(12, 22, 120, 30);
        layeredPane.add(jlbStudentBoardWriteInstructorREply);
        
        JLabel lblNewLabel = new JLabel("확인함");
        lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel.setBounds(144, 22, 600, 30);
        layeredPane.add(lblNewLabel);
        
        
        setVisible(true); // 다이얼로그를 화면에 표시
    }
}
