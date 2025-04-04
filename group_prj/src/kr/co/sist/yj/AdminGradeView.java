package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class AdminGradeView extends JFrame {
	
	private JButton jbtnAdminGradeSearch;
	
	public AdminGradeView () {
		
        //JLabel, Field 사이즈 설정
        Dimension comboboxSize = new Dimension(200, 22);
		
        //Component 생성
        //기수 Component 생성
        String[] strAdminGradeCourseCardinalTitle = {
        		"기수 선택", "25-1", "25-2", "25-3", "25-4"
        };
        JComboBox<String> jcbAdminGradeCourseCardinalBox = new JComboBox<String>(strAdminGradeCourseCardinalTitle);
        jcbAdminGradeCourseCardinalBox.setPreferredSize(comboboxSize);
        
        //과목명 Component 생성
        String[] strAdminGradeExamNameTitle = {
        		"JAVA", "DBMS"
        };
        JComboBox<String> jcbAdminGradeExamNameBox = new JComboBox<String>(strAdminGradeExamNameTitle);
        jcbAdminGradeExamNameBox.setPreferredSize(comboboxSize);
		
        //Button 생성
        JPanel jpAdminGradeViewButtonPanel = new JPanel();
        jpAdminGradeViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jbtnAdminGradeSearch = new JButton("조회");
        
        //Component 배치
        //Button 배치
        jpAdminGradeViewButtonPanel.add(jcbAdminGradeCourseCardinalBox);
        jpAdminGradeViewButtonPanel.add(jcbAdminGradeExamNameBox);
        jpAdminGradeViewButtonPanel.add(jbtnAdminGradeSearch);
		
		//Table 타이틀 생성
        String[] strAdminGradeTableTitle = {
            "기수", "시험과목명", "학생이름", "성적"
        };

        //Table 가데이터 생성
        String[][] strAdminGradeTableData = {
            { "25-1", "JAVA", "강태일", "4" },
            { "25-2", "JAVA", "김민경", "5" },
            { "25-3", "DBMS", "이여진", "2" },
            { "25-4", "DBMS", "장태규", "3" },
        };

        //Table Component 생성
        DefaultTableModel dftmAdminGradeTableModel = new DefaultTableModel(strAdminGradeTableData, strAdminGradeTableTitle);
        JTable jtAdminGradeTable = new JTable(dftmAdminGradeTableModel);
        
        //Table 수정 불가능
        jtAdminGradeTable.setDefaultEditor(Object.class, null);

        //Table 열 너비 설정
        TableColumnModel columnModel = jtAdminGradeTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 1:
        		columnModel.getColumn(i).setPreferredWidth(370); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminGradeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtAdminGradeTable.setRowHeight(25);

        //Table Component 배치
        JScrollPane spAdminGradeViewScroll = new JScrollPane(jtAdminGradeTable);
        spAdminGradeViewScroll.setPreferredSize(new Dimension(770,500));
        JPanel jpAdminGradeViewTablePanel = new JPanel(new BorderLayout());
        jpAdminGradeViewTablePanel.add(spAdminGradeViewScroll, BorderLayout.CENTER);
        
        //Panel 배치
        setLayout(new BorderLayout());
        add(jpAdminGradeViewButtonPanel, BorderLayout.NORTH);
        add(jpAdminGradeViewTablePanel, BorderLayout.CENTER);
        
        //Button 이벤트 생성
        AdminGradeEvt age = new AdminGradeEvt(this);
        jbtnAdminGradeSearch.addActionListener(age);
        
	} //AdminGradeView

	//getter method
	public JButton getJbtnAdminGradeSearch() {
		return jbtnAdminGradeSearch;
	} //getJbtnAdminGradeSearch

} //class
