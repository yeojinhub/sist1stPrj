package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AdminExamEvt implements ActionListener {

	private AdminMainView amv;
	@SuppressWarnings("unused")
	private AdminExamView aev;
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamDelete;
	
	public AdminExamEvt(AdminMainView amv,AdminExamView aev) {
		this.amv=amv;
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
			
			JDialog jdExamCreateDialog = new JDialog((JFrame)null, "시험 등록", true);
			jdExamCreateDialog.getContentPane().add(new AdminExamCreateView());
			jdExamCreateDialog.pack();
			jdExamCreateDialog.setLocationRelativeTo(amv);
			jdExamCreateDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminExamModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdExamModifyDialog = new JDialog((JFrame)null, "시험지 수정", true);
			jdExamModifyDialog.getContentPane().add(new AdminExamModifyView());
			jdExamModifyDialog.pack();
			jdExamModifyDialog.setLocationRelativeTo(amv);
			jdExamModifyDialog.setVisible(true);
		} //end if
		if( source == jbtnAdminExamDelete ) {
			System.out.println("삭제 버튼 실행");
		} //end if
		
	} //actionPerformed

} //class
