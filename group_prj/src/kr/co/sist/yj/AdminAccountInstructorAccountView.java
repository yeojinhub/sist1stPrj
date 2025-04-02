//package kr.co.sist.view;
package kr.co.sist.yj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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
public class AdminAccountInstructorAccountView extends JPanel{

	public AdminAccountInstructorAccountView() {
		
		// ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminAccountInstructorAccountViewInfoPanel = new JPanel(new GridBagLayout());
        jpAdminAccountInstructorAccountViewInfoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminAccountInstructorAccountViewInfoPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminAccountInstructorAccountViewInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 4, 8, 4);
        gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
        Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
        //이름 Component 생성
		JLabel jlblAdminAccountInstructorAccountNameTitle = new JLabel("이름");
		JTextField jtfAdminAccountInstructorAccountNameText = new JTextField();
		jlblAdminAccountInstructorAccountNameTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountNameText.setPreferredSize(fieldSize);
		
		//사번 Component 생성
		JLabel jlblAdminAccountInstructorAccountIDTitle = new JLabel("사번");
		JTextField jtfAdminAccountInstructorAccountIDText = new JTextField();
		jlblAdminAccountInstructorAccountIDTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountIDText.setPreferredSize(fieldSize);
		
		//비밀번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountPassTitle = new JLabel("비밀번호");
		JPasswordField jpfAdminAccountInstructorAccountPassText = new JPasswordField();
		jlblAdminAccountInstructorAccountPassTitle.setPreferredSize(labelSize);
		jpfAdminAccountInstructorAccountPassText.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel jlblAdminAccountInstructorAccountBirthTitle = new JLabel("생년월일");
		JTextField jtfAdminAccountInstructorAccountBirthText = new JTextField();
		jlblAdminAccountInstructorAccountBirthTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountBirthText.setPreferredSize(fieldSize);
		
		//전화번호 Component 생성
		JLabel jlblAdminAccountInstructorAccountTelTitle = new JLabel("전화번호");
		JTextField jtfAdminAccountInstructorAccountTelText = new JTextField();
		jlblAdminAccountInstructorAccountTelTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountTelText.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel jlblAdminAccountInstructorAccountAddressTitle = new JLabel("주소");
		JTextField jtfAdminAccountInstructorAccountAddressText = new JTextField();
		jlblAdminAccountInstructorAccountAddressTitle.setPreferredSize(labelSize);
		jtfAdminAccountInstructorAccountAddressText.setPreferredSize(fieldSize);
		
		//Button 생성
        JPanel jpAdminAccountInstructorAccountViewButtonPanel = new JPanel();
        jpAdminAccountInstructorAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton jbtnAdminAccountInstructorAccountCreate = new JButton("생성");
        JButton jbtnAdminAccountInstructorAccountModify = new JButton("수정");
        JButton jbtnAdminAccountInstructorAccountDelete = new JButton("삭제");
        
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountCreate);
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountModify);
        jpAdminAccountInstructorAccountViewButtonPanel.add(jbtnAdminAccountInstructorAccountDelete);

        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jtfAdminAccountInstructorAccountNameText, gbc);
        
        //사번 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountIDTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jtfAdminAccountInstructorAccountIDText, gbc);
        
        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jpfAdminAccountInstructorAccountPassText, gbc);
        
        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jtfAdminAccountInstructorAccountBirthText, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jtfAdminAccountInstructorAccountTelText, gbc);
        
        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jlblAdminAccountInstructorAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountInstructorAccountViewInfoPanel.add(jtfAdminAccountInstructorAccountAddressText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 11;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminAccountInstructorAccountViewInfoPanel.add(jpAdminAccountInstructorAccountViewButtonPanel, gbc);
        
        //Table 타이틀 생성
		String strAdminAccountInstructorAccountTitle[] = {
				"사번", "이름", "생년월일", "전화번호", "주소"
		};
		
		//Table 가데이터 생성
		String strAdminAccountInstructorAccountData[][] = {
				{ "20250001", "곽우신", "1980-01-01", "010-1234-5678", "서울특별시 강남구 역삼동" },
		};
		
		//Table Component 생성
		DefaultTableModel model = new DefaultTableModel(strAdminAccountInstructorAccountData, strAdminAccountInstructorAccountTitle);
		JTable jtAdminAccountInstructorAccountTable = new JTable(model);
		
		//Table 수정 불가능
		jtAdminAccountInstructorAccountTable.setDefaultEditor(Object.class, null);
		
		//Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountInstructorAccountTable.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
        	switch(i) {
        	case 3:
        		columnModel.getColumn(i).setPreferredWidth(100); break;
        	case 4:
        		columnModel.getColumn(i).setPreferredWidth(430); break;
        	default:
        		columnModel.getColumn(i).setPreferredWidth(80); break;
        	} //end switch
        } //end for
        jtAdminAccountInstructorAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
        //Table Component 배치
		JScrollPane spAdminAccountInstructorAccountViewScroll = new JScrollPane(jtAdminAccountInstructorAccountTable);
		spAdminAccountInstructorAccountViewScroll.setPreferredSize(new Dimension(773,500));
		JPanel jpAdminAccountInstructorAccountViewTablePanel = new JPanel();
		jpAdminAccountInstructorAccountViewTablePanel.add(spAdminAccountInstructorAccountViewScroll, BorderLayout.CENTER);
		
		//Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminAccountInstructorAccountViewInfoPanel, BorderLayout.WEST);
		add(jpAdminAccountInstructorAccountViewTablePanel, BorderLayout.CENTER);
		
	} //AdminAccountInstructorAccountView
	
} //class