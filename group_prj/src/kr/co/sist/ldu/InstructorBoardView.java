package kr.co.sist.ldu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class InstructorBoardView extends JDialog {

	private JLabel jlblTitleSet, jlblAuthorNameSet, jlblWriteDateSet;
	private JTextArea jtaBoardSet;
	private JButton jbtnExit;
	private int selectedBoardNum;
	private JTextField jtfCommSet;
	private JButton jbtnApply;
	private InstructorAccountVO iaVO;
	private InstructorBoardVO vo;
	private InstructorMainView imv;

	public InstructorBoardView(InstructorBoardVO vo, InstructorAccountVO iaVO, InstructorMainView imv) {
		this.vo = vo;
		this.iaVO = iaVO;
		this.selectedBoardNum = vo.getBoardNum();

		setTitle("Best Campus - 1:1 문의");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JPanel jpTitle = new JPanel();
		jpTitle.setBackground(new Color(255, 255, 255));
		jpTitle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpTitle.setBounds(5, 5, 660, 40);
		getContentPane().add(jpTitle);
		jpTitle.setLayout(new BorderLayout(0, 0));

		jlblTitleSet = new JLabel(vo.getBoardTitle());
		jpTitle.add(jlblTitleSet);
		jlblTitleSet.setHorizontalAlignment(SwingConstants.LEFT);
		jlblTitleSet.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jlblTitleSet.setBackground(new Color(255, 255, 255));

		jlblWriteDateSet = new JLabel(vo.getBoardDate().toString());
		jlblWriteDateSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jlblWriteDateSet.setHorizontalAlignment(SwingConstants.LEFT);
		jpTitle.add(jlblWriteDateSet, BorderLayout.EAST);

		JPanel jpAuthor = new JPanel();
		jpAuthor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpAuthor.setBackground(Color.WHITE);
		jpAuthor.setBounds(5, 45, 660, 30);
		getContentPane().add(jpAuthor);
		jpAuthor.setLayout(null);

		jlblAuthorNameSet = new JLabel(vo.getStuName());
		jlblAuthorNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblAuthorNameSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblAuthorNameSet.setBounds(5, 7, 70, 15);
		jpAuthor.add(jlblAuthorNameSet);

		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder(""));
		jpNorth.setBackground(new Color(255, 255, 255));
		jpNorth.setBounds(5, 78, 660, 373);
		getContentPane().add(jpNorth);
		jpNorth.setLayout(null);

		jtaBoardSet = new JTextArea(vo.getBoardContent());
		jtaBoardSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jtaBoardSet.setLineWrap(true);
		jtaBoardSet.setEditable(false);
		jtaBoardSet.setHighlighter(null);
		jtaBoardSet.setBounds(5, 5, 650, 296);
		jpNorth.add(jtaBoardSet);

		JPanel jpSouth_1 = new JPanel();
		jpSouth_1.setBorder(new TitledBorder(""));
		jpSouth_1.setBackground(Color.WHITE);
		jpSouth_1.setBounds(5, 311, 650, 57);
		jpNorth.add(jpSouth_1);
		jpSouth_1.setLayout(null);

		jtfCommSet = new JTextField();
		jtfCommSet.setBounds(0, 0, 529, 57);
		jpSouth_1.add(jtfCommSet);
		jtfCommSet.setColumns(10);
		
		jbtnApply = new JButton("등록");
		jbtnApply.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnApply.setBounds(541, 10, 97, 37);
		jpSouth_1.add(jbtnApply);
		
		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setFocusPainted(false);
		jbtnExit.setBounds(275, 461, 100, 25);
		getContentPane().add(jbtnExit);
		
		InstructorBoardEvt ibe = new InstructorBoardEvt(vo, iaVO, jtfCommSet, this, imv);
		jbtnApply.addActionListener(ibe);
		jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


		setModal(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 540);
		setVisible(true);
	}

	public int getSelectedBoardNum() {
		return selectedBoardNum;
	}

	public JTextField getJtfCommSet() {
		return jtfCommSet;
	}

	public JButton getJbtnApply() {
		return jbtnApply;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}

	public InstructorAccountVO getIaVO() {
		return iaVO;
	}

	public InstructorBoardVO getVo() {
		return vo;
	}
}
