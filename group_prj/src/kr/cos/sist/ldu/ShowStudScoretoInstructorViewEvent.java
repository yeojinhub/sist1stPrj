package kr.cos.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStudScoretoInstructorViewEvent implements ActionListener{

	private ShowStudScoretoInstructorView ssiv;
	
	public ShowStudScoretoInstructorViewEvent(ShowStudScoretoInstructorView ssiv) {
		this.ssiv = ssiv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ssiv.getJbtnClose()) {
			ssiv.dispose();
		}
		
	}

}
