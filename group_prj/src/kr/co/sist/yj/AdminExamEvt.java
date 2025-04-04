package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminExamEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminExamView aev;
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamDelete;
	
	public AdminExamEvt(AdminExamView aev) {
		this.aev=aev;
		this.jbtnAdminExamCreate=aev.getJbtnAdminExamCreate();
		this.jbtnAdminExamModify=aev.getJbtnAdminExamModify();
		this.jbtnAdminExamDelete=aev.getJbtnAdminExamDelete();
	} //AdminExamEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == jbtnAdminExamCreate ) {
			System.out.println("등록 버튼 실행");
		} //end if
		if( source == jbtnAdminExamModify ) {
			System.out.println("수정 버튼 실행");
		} //end if
		if( source == jbtnAdminExamDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
		
	} //actionPerformed

} //class
