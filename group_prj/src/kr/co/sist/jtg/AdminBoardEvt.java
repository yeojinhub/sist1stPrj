package kr.co.sist.jtg;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminBoardEvt implements MouseListener {
	
	@SuppressWarnings("unused")
	private AdminBoardView abv;
	
	public AdminBoardEvt(AdminBoardView abv) {
		this.abv=abv;
	} //AdminBoardEvt

	@Override
	public void mouseClicked(MouseEvent e) {
		new AdminBoardReadView();
	} //mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

} //class
