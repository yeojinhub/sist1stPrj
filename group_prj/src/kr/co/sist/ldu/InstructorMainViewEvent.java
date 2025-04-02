package kr.co.sist.ldu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InstructorMainViewEvent extends MouseAdapter {

    private InstructorMainView imv;

    public InstructorMainViewEvent(InstructorMainView imv) {
        this.imv = imv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        	
    		System.out.println("완료");
            ShowStudScoretoInstructorView ssiv = new ShowStudScoretoInstructorView(imv);
            ssiv.setVisible(true);
     
    }
}
