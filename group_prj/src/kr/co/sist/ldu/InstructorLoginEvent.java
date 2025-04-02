package kr.co.sist.ldu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class InstructorLoginEvent extends WindowAdapter implements ActionListener{

	private InstructorLoginView ilv;
	
	public InstructorLoginEvent(InstructorLoginView ilv) {
		this.ilv = ilv;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== ilv.getJbtnLogin()) {
			new InstructorMainView(ilv);
			ilv.dispose();
		}
		
	}


}
