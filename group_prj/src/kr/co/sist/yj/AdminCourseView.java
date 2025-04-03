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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//import kr.co.sist.evt.AdminCourseEvt;

@SuppressWarnings("serial")
public class AdminCourseView extends JFrame{

	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseModify;
	private JButton jbtnAdminCourseDelete;
	
	public AdminCourseView() {
		
		// ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminCourseViewInfoPanel = new JPanel(new GridBagLayout());
        jpAdminCourseViewInfoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminCourseViewInfoPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminCourseViewInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

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
        JPanel jpAdminCourseViewButtonPanel = new JPanel();
        jpAdminCourseViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminCourseCreate = new JButton("등록");
        jbtnAdminCourseModify = new JButton("수정");
        jbtnAdminCourseDelete = new JButton("삭제");
        
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseCreate);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseModify);
        jpAdminCourseViewButtonPanel.add(jbtnAdminCourseDelete);
        
        //Component 배치
        //과정명 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jtfAdminCourseNameText, gbc);
        
        //기수 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseCardinalTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jtfAdminCourseCardinalText, gbc);
        
        //진행상태 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseStatusTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jtfAdminCourseStatusText, gbc);
        
        //담당강사 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseInstructorNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jcbAdminCourseInstructorNameBox, gbc);
        
        //시작일 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseStartdateTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jtfAdminCourseStartdateText, gbc);
        
        //종료일 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminCourseViewInfoPanel.add(jlblAdminCourseEnddateTitle, gbc);
        gbc.gridx = 1;
        jpAdminCourseViewInfoPanel.add(jtfAdminCourseEnddateText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminCourseViewInfoPanel.add(jpAdminCourseViewButtonPanel, gbc);
        
        //Table 타이틀 생성
        String[] strAdminCourseTableTitle = {
            "기수", "과정명", "진행상태", "담당강사", "시작일", "종료일"
        };

        //Table 가데이터 생성
        String[][] strAdminCourseTableData = {
            { "25-1", "AWS와 Docker & Kubernetes", "진행중", "곽우신", "2025-01-13", "2025-07-25" },
            { "25-2", "AWS와 Docker & Kubernetes", "진행중", "곽우심", "2025-02-13", "2025-08-25" },
            { "25-3", "AWS와 Docker & Kubernetes", "진행중", "박우신", "2025-03-13", "2025-09-25" },
            { "25-4", "AWS와 Docker & Kubernetes", "진행중", "강우신", "2025-04-13", "2025-10-25" },
        };

        //Table Component 생성
        DefaultTableModel dftmAdminCourseTableModel = new DefaultTableModel(strAdminCourseTableData, strAdminCourseTableTitle);
        JTable jtAdminCourseTable = new JTable(dftmAdminCourseTableModel);
        
        //Table 수정 불가능
        jtAdminCourseTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminCourseTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(370); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminCourseTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        //Table Component 배치
        JScrollPane spAdminCourseViewScroll = new JScrollPane(jtAdminCourseTable);
        spAdminCourseViewScroll.setPreferredSize(new Dimension(773,500));
        JPanel jpAdminCourseViewTablePanel = new JPanel(new BorderLayout());
        jpAdminCourseViewTablePanel.add(spAdminCourseViewScroll, BorderLayout.CENTER);

        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminCourseViewInfoPanel, BorderLayout.WEST);
        add(jpAdminCourseViewTablePanel, BorderLayout.CENTER);
        
        //Button 이벤트 생성
        AdminCourseEvt ace = new AdminCourseEvt(this);
        jbtnAdminCourseCreate.addActionListener(ace);;
        jbtnAdminCourseModify.addActionListener(ace);;
        jbtnAdminCourseDelete.addActionListener(ace);;
		
	} //AdminCourseView

	//getter method
	public JButton getJbtnAdminCourseCreate() {
		return jbtnAdminCourseCreate;
	} //getJbtnAdminCourseCreate

	public JButton getJbtnAdminCourseModify() {
		return jbtnAdminCourseModify;
	} //getJbtnAdminCourseModify

	public JButton getJbtnAdminCourseDelete() {
		return jbtnAdminCourseDelete;
	} //getJbtnAdminCourseDelete
	
	
} //class