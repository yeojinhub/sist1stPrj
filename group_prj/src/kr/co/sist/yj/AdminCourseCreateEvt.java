package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminCourseCreateEvt implements ActionListener {

	private AdminCourseCreateView accv;

	private JButton jbtnAdminCourseCreate;
	private JButton jbtnAdminCourseClose;

	@SuppressWarnings("unused")
	private AdminCourseView acv;

	public AdminCourseCreateEvt(AdminCourseCreateView accv, AdminCourseView acv) {
		this.accv = accv;
		this.acv = acv;
		this.jbtnAdminCourseCreate = accv.getJbtnAdminCourseCreate();
		this.jbtnAdminCourseClose = accv.getJbtnAdminCourseClose();
	} // AdminCourseCreateEvt

	public void addCourse() {
		// TextField에 입력받은 값 변수에 저장.
		// #. 값을 전부 입력해주세요~
		boolean courCardinalIsEmpty = accv.getJtfAdminCourseCardinalSet().getText().isEmpty();
		boolean courNameIsEmpty = accv.getJtfAdminCourseNameSet().getText().isEmpty();
		boolean courStatusIsEmpty = accv.getJtfAdminCourseStatusSet().getText().isEmpty();
		if (courCardinalIsEmpty || courNameIsEmpty || courStatusIsEmpty) {
			JOptionPane.showMessageDialog(jbtnAdminCourseClose, "값을 전부 입력 바랍니다.");
			return;
		} // end if
		String courCardinal = accv.getJtfAdminCourseCardinalSet().getText();
		String courName = accv.getJtfAdminCourseNameSet().getText();
		String courStatus = accv.getJtfAdminCourseStatusSet().getText();

		// #. 시작일, 종료일 입력 유효성 검사
		// #-1 공란 검사
		if (accv.getJtfAdminCourseStartdateSet().getText().equals("____-__-__")) {
			JOptionPane.showMessageDialog(accv, "시작일을 전부 입력 해주세요.");
			return;
		} // end if
		if (accv.getJtfAdminCourseEnddateSet().getText().equals("____-__-__")) {
			JOptionPane.showMessageDialog(accv, "종료일을 전부 입력 해주세요.");
			return;
		} // end if
			// #-2. 시작일
		int startMonth = Integer.parseInt(accv.getJtfAdminCourseStartdateSet().getText().substring(5, 7));
		int startDay = Integer.parseInt(accv.getJtfAdminCourseStartdateSet().getText().substring(8));
		int endMonth = Integer.parseInt(accv.getJtfAdminCourseEnddateSet().getText().substring(5, 7));
		int endDay = Integer.parseInt(accv.getJtfAdminCourseEnddateSet().getText().substring(8));
		if (!(startMonth < 13 && startMonth > 0) || !(startDay < 32 && startDay > 0)) {
			JOptionPane.showMessageDialog(accv, "시작일 '월, 일' 입력을 다시 확인해주세요.");
			return;
		} // end if
		if (!(endMonth < 13 && endMonth > 0) || !(endDay < 32 && endDay > 0)) {
			JOptionPane.showMessageDialog(accv, "종료일 '월, 일' 입력을 다시 확인해주세요.");
			return;
		} // end if

		String courStartDate = accv.getJtfAdminCourseStartdateSet().getText();
		String courEndDate = accv.getJtfAdminCourseEnddateSet().getText();

		String instNum = "";
//		// JComboBox로 선택된 선생님의 강사번호를 얻기 위한 For문!
//		for (AdminCourseVO acVO : accv.getCourseList()) {
//			if (acVO.getInstName().equals((String) accv.getJcbAdminCourseInstructorNameBox().getSelectedItem())) {
//				instNum = acVO.getInstNum();
//			} // end if
//		} // end for

		AdminCourseService acs = new AdminCourseService();
		for (AdminCourseInstVO acivo : acs.searchAllInstructorInfo()) {
			if (acivo.getInstName().equals(accv.getJcbAdminCourseInstructorNameBox().getSelectedItem())) {
				instNum = acivo.getInstNum();
			}// end if
		}// end for

		// 다 얻었다! 이제 VO로 만들고 Service객체 만들어서 Insert 해보자~
		AdminCourseVO acVO = new AdminCourseVO();
		acVO.setCourCardinal(courCardinal);
		acVO.setCourName(courName);
		acVO.setCourStatus(courStatus);
		acVO.setCourStartdate(courStartDate);
		acVO.setCourEnddate(courEndDate);
		acVO.setInstNum(instNum);

		// # 유효성 검사
		// #-1. 중복되는 기수가 있다면 에러 처리
		for(AdminCourseVO acvo : acs.searchAllCourseInfo()) {
			if(acvo.getCourCardinal().equals(courCardinal)) {
				JOptionPane.showMessageDialog(accv, "'기수'가 중복되어서는 안됩니다.\n확인 부탁 드립니다.");
				return;
			}// end if
		}// end for
		
		// insert 고고~
		acs.addCourse(acVO);

		// 완료됬다고 말해주고 다이어로그창 끄기~
		JOptionPane.showMessageDialog(accv, "등록되었습니다.");
		accv.getJdCourseCreateDialog().dispose();

		// 데이터 리로드~
//		AdminMainEvt ame = new AdminMainEvt(accv.getAmv(), acv);
//		ame.loadCourseData(acs.searchAllCourseInfo());

	}// addCourse

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminCourseCreate) {
			addCourse();
		} // end if
		if (source == jbtnAdminCourseClose) {
			System.out.println("닫기 버튼 실행");
			Window adminCourseCreateWindow = SwingUtilities.getWindowAncestor(accv);
			if (adminCourseCreateWindow instanceof JDialog) {
				((JDialog) adminCourseCreateWindow).dispose();
			} // end if
		} // end if

	} // actionPerformed

} // class
