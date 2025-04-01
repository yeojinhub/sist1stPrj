//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//import kr.co.sist.view.AdminAccountView;
//import kr.co.sist.view.AdminMainView;

public class AdminMainEvt implements ActionListener{
	
	@SuppressWarnings("unused")
	private AdminMainView amv;
	private JButton jbtnAdminMainAccount;
	private JButton jbtnAdminMainCourse;
	private JButton jbtnAdminMainExam;
	private JButton jbtnAdminMainGrade;
	private JButton jbtnAdminMainBoard;
	
	public AdminMainEvt(AdminMainView amv) {
		this.amv=amv;
		this.jbtnAdminMainAccount=amv.getJbtnAdminMainAccount();
		this.jbtnAdminMainCourse=amv.getJbtnAdminMainCourse();
		this.jbtnAdminMainExam=amv.getJbtnAdminMainExam();
		this.jbtnAdminMainGrade=amv.getJbtnAdminMainGrade();
		this.jbtnAdminMainBoard=amv.getJbtnAdminMainBoard();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnAdminMainAccount) {
			System.out.println("계정관리 버튼 실행");
			new AdminAccountView();
		} //end if
		if(ae.getSource() == jbtnAdminMainCourse) {
			System.out.println("과정조회 버튼 실행");
		} //end if
		if(ae.getSource() == jbtnAdminMainExam) {
			System.out.println("시험관리 버튼 실행");
		} //end if
		if(ae.getSource() == jbtnAdminMainGrade) {
			System.out.println("성적조회 버튼 실행");
		} //end if
		if(ae.getSource() == jbtnAdminMainBoard) {
			System.out.println("1:1문의 버튼 실행");
		} //end if
	} //actionPerformed
	
} //class
