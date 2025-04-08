package kr.co.sist.jtg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminGradeEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminGradeView agv;
	
	private JButton jbtnAdminGradeSearch;
	
	public AdminGradeEvt(AdminGradeView agv) {
		this.agv=agv;
		this.jbtnAdminGradeSearch=agv.getJbtnAdminGradeSearch();
	} //AdminGradeEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminGradeSearch ) {
			System.out.println("조회 버튼 실행");
		} //end if
	} //actionPerformed

} //class
