package kr.co.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ShowStudScoretoInstructorViewEvt implements ActionListener{

	private ShowStudScoretoInstructorView ssiv;
	private ShowStudScoretoInstructorService service;

	public ShowStudScoretoInstructorViewEvt(ShowStudScoretoInstructorView ssiv) {
		this.ssiv = ssiv;
		this.service = new ShowStudScoretoInstructorService();
		
		loadBoardTable();
	}

	//학생 성적 테이블 생성
	public void loadBoardTable() {
		List<InstructorScoreVO> scores = service.getScoresByStudent(ssiv.getIsVO().getStudNum());

		DefaultTableModel model = (DefaultTableModel) ssiv.getJtaStudScore().getModel();
		for (InstructorScoreVO vo : scores) {
		    model.addRow(new Object[] {
		        vo.getExamName(), vo.getScore()
		    });
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ssiv.getJbtnClose()) {
			ssiv.dispose();
		}
		
	}

}
