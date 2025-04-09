package kr.co.sist.ldu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class InstructorBoardReadView extends JDialog {

	private JLabel jlblTitleSet, jlblAuthorNameSet, jlblRespondentSet, jlblCommDateSet, jlblWriteDateSet;
	private JTextArea jtaBoardSet;
	private JButton jbtnExit;
	private JTextArea jtaCourseNameSet;
	private JLabel jlblCommWriterTypeSet;
	private JPanel jpCommWriterType;

	private int selectedBoardNum;
	private InstructorBoardVO vo;

	public InstructorBoardReadView(InstructorBoardVO vo) {
		this.vo = vo;
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
		jtaBoardSet.setBounds(5, 5, 650, 301);
		jpNorth.add(jtaBoardSet);

		JPanel jpSouth = new JPanel();
		jpSouth.setBackground(new Color(255, 255, 255));
		jpSouth.setBorder(new TitledBorder(""));
		jpSouth.setBounds(5, 306, 650, 57);
		jpNorth.add(jpSouth);
		jpSouth.setLayout(null);

		jlblRespondentSet = new JLabel("강사".equals(vo.getBoardType()) ? vo.getInstName() : "관리자");
		jlblRespondentSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblRespondentSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jlblRespondentSet.setBounds(40, 15, 70, 25);
		jpSouth.add(jlblRespondentSet);

		jtaCourseNameSet = new JTextArea(vo.getBoardCommContent());
		jtaCourseNameSet.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jtaCourseNameSet.setBounds(120, 5, 400, 45);
		jtaCourseNameSet.setLineWrap(true);
		jtaCourseNameSet.setEditable(false);
		jtaCourseNameSet.setHighlighter(null);
		jpSouth.add(jtaCourseNameSet);

		jlblCommDateSet = new JLabel(vo.getBoardCommDate() != null ? vo.getBoardCommDate().toString() : "");
		jlblCommDateSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCommDateSet.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jlblCommDateSet.setBounds(530, 15, 100, 25);
		jpSouth.add(jlblCommDateSet);

		jpCommWriterType = new JPanel();
		jpCommWriterType.setBounds(10, 18, 35, 20);
		jpSouth.add(jpCommWriterType);
		jpCommWriterType.setBorder(new TitledBorder(""));
		jpCommWriterType.setLayout(null);

		jlblCommWriterTypeSet = new JLabel(vo.getBoardType());
		jlblCommWriterTypeSet.setBounds(0, 0, 35, 20);
		jpCommWriterType.add(jlblCommWriterTypeSet);
		jlblCommWriterTypeSet.setHorizontalAlignment(SwingConstants.CENTER);
		jlblCommWriterTypeSet.setFont(new Font("맑은 고딕", Font.BOLD, 10));

		jbtnExit = new JButton("닫기");
		jbtnExit.setBackground(new Color(235, 235, 255));
		jbtnExit.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		jbtnExit.setFocusPainted(false);
		jbtnExit.setBounds(275, 461, 100, 25);
		getContentPane().add(jbtnExit);

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
		
	}

	// Getter Methods
	public JLabel getJlblTitleSet() {
		return jlblTitleSet;
	}

	public JLabel getJlblCommDateSet() {
		return jlblCommDateSet;
	}

	public JLabel getJlblCommWriterTypeSet() {
		return jlblCommWriterTypeSet;
	}

	public JPanel getJpCommWriterType() {
		return jpCommWriterType;
	}

	public int getSelectedBoardNum() {
		return selectedBoardNum;
	}

	public JTextArea getJtaCourseNameSet() {
		return jtaCourseNameSet;
	}

	public JLabel getJlblAuthorNameSet() {
		return jlblAuthorNameSet;
	}

	public JLabel getJlblRespondentSet() {
		return jlblRespondentSet;
	}

	public JTextArea getJtaBoardSet() {
		return jtaBoardSet;
	}

	public JButton getJbtnExit() {
		return jbtnExit;
	}

	public JLabel getJlblWriteDateSet() {
		return jlblWriteDateSet;
	}
} // class
