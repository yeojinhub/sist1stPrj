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
public class AdminAccountAdminAccountView extends JPanel {

	public AdminAccountAdminAccountView() {
		
		// ---------- 왼쪽 입력 패널 ----------
        JPanel jpAdminAccountAdminAccountViewInfoPanel = new JPanel(new GridBagLayout());
        jpAdminAccountAdminAccountViewInfoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        jpAdminAccountAdminAccountViewInfoPanel.setMinimumSize(new Dimension(350, 400));
        jpAdminAccountAdminAccountViewInfoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 4, 8, 4);
        gbc.anchor = GridBagConstraints.WEST;
		
		//JLabel, Field 사이즈 설정
		Dimension labelSize = new Dimension(100, 22);
        Dimension fieldSize = new Dimension(200, 22);
		
		//Component 생성
        //이름 Component 생성
		JLabel jlblAdminAccountAdminAccountNameTitle = new JLabel("이름");
		JTextField jtfAdminAccountAdminAccountNameText = new JTextField();
		jlblAdminAccountAdminAccountNameTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountNameText.setPreferredSize(fieldSize);
		
		//사번 Component 생성
		JLabel jlblAdminAccountAdminAccountIDTitle = new JLabel("사번");
		JTextField jtfAdminAccountAdminAccountIDText = new JTextField();
		jlblAdminAccountAdminAccountIDTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountIDText.setPreferredSize(fieldSize);
		
		//비밀번호 Component 생성
		JLabel jlblAdminAccountAdminAccountPassTitle = new JLabel("비밀번호");
		JPasswordField jpfAdminAccountAdminAccountPassText = new JPasswordField();
		jlblAdminAccountAdminAccountPassTitle.setPreferredSize(labelSize);
		jpfAdminAccountAdminAccountPassText.setPreferredSize(fieldSize);
		
		//생년월일 Component 생성
		JLabel jlblAdminAccountAdminAccountBirthTitle = new JLabel("생년월일");
		JTextField jtfAdminAccountAdminAccountBirthText = new JTextField();
		jlblAdminAccountAdminAccountBirthTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountBirthText.setPreferredSize(fieldSize);
		
		//전화번호 Component 생성
		JLabel jlblAdminAccountAdminAccountTelTitle = new JLabel("전화번호");
		JTextField jtfAdminAccountAdminAccountTelText = new JTextField();
		jlblAdminAccountAdminAccountTelTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountTelText.setPreferredSize(fieldSize);
		
		//주소 Component 생성
		JLabel jlblAdminAccountAdminAccountAddressTitle = new JLabel("주소");
		JTextField jtfAdminAccountAdminAccountAddressText = new JTextField();
		jlblAdminAccountAdminAccountAddressTitle.setPreferredSize(labelSize);
		jtfAdminAccountAdminAccountAddressText.setPreferredSize(fieldSize);
		
		//Button 생성
        JPanel jpAdminAccountAdminAccountViewButtonPanel = new JPanel();
        jpAdminAccountAdminAccountViewButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton jbtnAdminAccountAdminAccountCreate = new JButton("생성");
        JButton jbtnAdminAccountAdminAccountModify = new JButton("수정");
        JButton jbtnAdminAccountAdmintAccountDelete = new JButton("삭제");
        
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountCreate);
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdminAccountModify);
        jpAdminAccountAdminAccountViewButtonPanel.add(jbtnAdminAccountAdmintAccountDelete);
        
        //Component 배치
        //이름 Component 배치
        gbc.gridx = 0; gbc.gridy = 0;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountNameTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jtfAdminAccountAdminAccountNameText, gbc);
        
        //사번 Component 배치
        gbc.gridx = 0; gbc.gridy = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountIDTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jtfAdminAccountAdminAccountIDText, gbc);
        
        //비밀번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 2;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountPassTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jpfAdminAccountAdminAccountPassText, gbc);
        
        //생년월일 Component 배치
        gbc.gridx = 0; gbc.gridy = 3;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountBirthTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jtfAdminAccountAdminAccountBirthText, gbc);
        
        //전화번호 Component 배치
        gbc.gridx = 0; gbc.gridy = 4;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountTelTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jtfAdminAccountAdminAccountTelText, gbc);
        
        //주소 Component 배치
        gbc.gridx = 0; gbc.gridy = 5;
        jpAdminAccountAdminAccountViewInfoPanel.add(jlblAdminAccountAdminAccountAddressTitle, gbc);
        gbc.gridx = 1;
        jpAdminAccountAdminAccountViewInfoPanel.add(jtfAdminAccountAdminAccountAddressText, gbc);
        
        //버튼 Component 배치
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;  // 두 열을 합쳐서 버튼들을 가운데로 배치
        jpAdminAccountAdminAccountViewInfoPanel.add(jpAdminAccountAdminAccountViewButtonPanel, gbc);
		
		//Table 타이틀 생성
		String strAdminAccountAdminAccountTitle[] = {
				"사번", "이름", "생년월일", "전화번호", "주소"
		};
		
		//Table 가데이터 생성
		String strAdminAccountAdminAccountData[][] = {
				{ "20250001", "정난영", "1996-01-01", "010-1234-5678", "서울특별시 강동구 천호동" },
		};
		
		//Table Component 생성
		DefaultTableModel model= new DefaultTableModel(strAdminAccountAdminAccountData, strAdminAccountAdminAccountTitle);
		JTable jtAdminAccountAdminAccountTable = new JTable(model);
		
		//Table 수정 불가능
		jtAdminAccountAdminAccountTable.setDefaultEditor(Object.class, null);
		
		//Table 열 너비 설정
        TableColumnModel columnModel = jtAdminAccountAdminAccountTable.getColumnModel();
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
        jtAdminAccountAdminAccountTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		//Table Component 배치
		JScrollPane spAdminAccountAdminAccountViewScroll = new JScrollPane(jtAdminAccountAdminAccountTable);
		spAdminAccountAdminAccountViewScroll.setPreferredSize(new Dimension(773,500));
		JPanel jpAdminAccountAccountAccountViewTablePanel = new JPanel();
		jpAdminAccountAccountAccountViewTablePanel.add(spAdminAccountAdminAccountViewScroll, BorderLayout.CENTER);
		
		//Panel 배치
		setLayout(new BorderLayout());
		add(jpAdminAccountAdminAccountViewInfoPanel, BorderLayout.WEST);
		add(jpAdminAccountAccountAccountViewTablePanel, BorderLayout.CENTER);
		
	} //AdminAccountAdminAccountView
	
} //class
