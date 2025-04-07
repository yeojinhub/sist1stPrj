package kr.co.sist.kti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StudentInfoChangePassEvt implements ActionListener {

	private StudentInfoChangePassView sicpv;

	public StudentInfoChangePassEvt(StudentInfoChangePassView sicpv) {
		this.sicpv = sicpv;
	}// StudentInfoChangePassEvt

	public void exitDialog() {
		sicpv.dispose();
	}// exitDialog

	public void changePassword() {
		// 자주 쓰는 변수 미리 생성
		// Password 받을 변수들
		String nowPass = new String(sicpv.getJpfNowPass().getPassword());
		String changePass = new String(sicpv.getJpfChangePass().getPassword());
		String passCheck = new String(sicpv.getJpfPassCheck().getPassword());

		// #. 예외 처리
		// #-1. 입력창 미입력시(isEmpty) 라벨 수정
		if (sicpv.getJpfNowPass().getPassword().length == 0) {
			sicpv.getJlblInfo().setText("현재 비밀번호를 입력해주세요.");
			sicpv.getJpfNowPass().requestFocus();
			return;
		} // end if
		if (sicpv.getJpfChangePass().getPassword().length == 0) {
			sicpv.getJlblInfo().setText("새로운 비밀번호를 입력해주세요.");
			sicpv.getJpfChangePass().requestFocus();
			return;
		} // end if
		if (sicpv.getJpfPassCheck().getPassword().length == 0) {
			sicpv.getJlblInfo().setText("비밀번호 확인을 입력해주세요.");
			sicpv.getJpfPassCheck().requestFocus();
			return;
		} // end if
			// #-2. 현재 비밀번호칸에 입력한 비밀번호가 다를 경우.
		if (!nowPass.equals(sicpv.getSaVO().getStuPass())) {
			sicpv.getJlblInfo().setText("현재 비밀번호를 확인해주세요.");
			sicpv.getJpfNowPass().requestFocus();
			return;
		} // end if
			// #-3. 새로운 비밀번호와 비밀번호 확인칸에 입력한 비밀번호가 다를 경우.
		if (!changePass.equals(passCheck)) {
			sicpv.getJlblInfo().setText("변경할 비밀번호가 일치하지 않습니다.");
			sicpv.getJpfChangePass().requestFocus();
			return;
		} // end if
			// #-4. 변경할 비밀번호는 최소 6자 최대 12자
		if (changePass.length() < 6 || changePass.length() > 12) {
			sicpv.getJlblInfo().setText("비밀번호는 최소 6자, 최대 12자 입니다.");
			return;
		} // end if

		// 예외 통과 후 비밀번호 변경.
		StudentInfoService sis = new StudentInfoService();

		boolean result = sis.changePassword(changePass, sicpv.getSaVO().getStuNum());
		if (!result) {
			JOptionPane.showMessageDialog(sicpv, "비밀번호 변경에 실패했습니다.\n다시 한번 확인해주세요.");
			return;
		} // end if
		JOptionPane.showMessageDialog(sicpv, "비밀번호를 변경하였습니다.\n변경된 비밀번호는 다음 로그인부터 적용됩니다.");
		sicpv.dispose();

	}// changePassword

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sicpv.getJbtnChange()) {
			changePassword();
		} // 변경 버튼
		if (e.getSource() == sicpv.getJbtnExit()) {
			exitDialog();
		} // 닫기 버튼
	}// actionPerformed

}// class
