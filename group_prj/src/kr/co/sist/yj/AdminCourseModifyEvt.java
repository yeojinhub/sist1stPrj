package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminCourseModifyEvt implements ActionListener {

	private AdminCourseModifyView courModifyView;

	private JButton courseModifyButton;
	private JButton courseDeleteButton;
	private JButton courseCloseButton;
	
	private JComboBox<String> instCombo;

	private int selectedCourNum;

	public AdminCourseModifyEvt(AdminCourseModifyView courModifyView) {
		this.courModifyView = courModifyView;
		this.courseModifyButton = courModifyView.getCourseModifyButton();
		this.courseDeleteButton = courModifyView.getJbtnAdminCourseDelete();
		this.courseCloseButton = courModifyView.getJbtnAdminCourseClose();
		this.instCombo=courModifyView.getCourseInstructorNameBox();
		
		this.selectedCourNum = courModifyView.getCourNum();
		loadAdminInfo(selectedCourNum);
	} // AdminCourseModifyEvt

	private void loadAdminInfo(int courNum) {
	    AdminCourseService courService = new AdminCourseService();

	    // 1) 콤보박스 초기화 및 강사 목록 세팅
	    instCombo = courModifyView.getCourseInstructorNameBox();
	    instCombo.removeAllItems();
	    List<AdminCourseInstVO> instList = courService.searchAllInstructorInfo();
	    for (AdminCourseInstVO instVO : instList) {
	        instCombo.addItem(instVO.getInstName());
	    }

	    // 2) 선택된 과정 한 건 조회
	    AdminCourseVO courVO = courService.searchOneCourse(courNum);

	    if (courVO != null) {
	        // 3) 텍스트필드에 값 세팅
	        courModifyView.getCourCardinalTextSet().setText(courVO.getCourCardinal());
	        courModifyView.getJtfAdminCourseNameSet().setText(courVO.getCourName());
	        courModifyView.getJtfAdminCourseStatusSet().setText(courVO.getCourStatus());
	        courModifyView.getJtfAdminCourseStartdateSet().setText(courVO.getCourStartdate());
	        courModifyView.getJtfAdminCourseEnddateSet().setText(courVO.getCourEnddate());

	        // 4) VO에 저장된 instNum으로 콤보박스 선택값 맞추기
	        String savedInstNum = courVO.getInstNum();
	        for (AdminCourseInstVO instVO : instList) {
	            if (instVO.getInstNum().equals(savedInstNum)) {
	                instCombo.setSelectedItem(instVO.getInstName());
	                break;
	            }
	        }
	    } else {
	        // 조회 실패 시 안내
	        JOptionPane.showMessageDialog(
	            courModifyView,
	            "조회할 과정을 선택해주세요.",
	            "조회 오류",
	            JOptionPane.WARNING_MESSAGE
	        );
	    }
	} //loadAdminInfo
	
	public void removeCourse() {
		String[] options = {"삭제", "취소"};
		int result = JOptionPane.showOptionDialog(
				courModifyView,
				"과정을 삭제 하시겠습니까?",
				"삭제 확인",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				options,
				options[1]
				);
		
		// JOptionPane 메세지 생성
		if (result == 0) {
			AdminCourseService courService = new AdminCourseService();
			boolean flag = courService.removeCourse(selectedCourNum);
			
			if (flag) {
				// 삭제 버튼을 눌렀을 때
				System.out.println("삭제 버튼 실행");
				JOptionPane.showMessageDialog(courModifyView, "과정이 삭제되었습니다.");
				closeModifyDialog();
			} else {
				// 삭제 오류가 났을 때
				JOptionPane.showMessageDialog(courModifyView, "과정 삭제에 실패했습니다.");
				closeModifyDialog();
			} //end if else
		} else if (result == 1) {
			// 취소 버튼을 눌렀을 때
			System.out.println("삭제 취소 버튼 실행");
			JOptionPane.showMessageDialog(courModifyView, "과정 삭제를 취소하였습니다.");
		} else if (result == -1) {
			// 창 닫기 버튼을 눌렀을 때
			System.out.println("삭제 취소 창 닫기");
			JOptionPane.showMessageDialog(courModifyView, "과정 삭제 창을 닫았습니다.");
		} //end if else
	} //removeMember

	public void modifyCourse() {
	    // 1) 입력 필드에서 값 읽기
	    String courCardinal   = courModifyView.getCourCardinalTextSet().getText();
	    String courName       = courModifyView.getJtfAdminCourseNameSet().getText();
	    String courStatus     = courModifyView.getJtfAdminCourseStatusSet().getText();
	    String courStartDate  = courModifyView.getJtfAdminCourseStartdateSet().getText();
	    String courEndDate    = courModifyView.getJtfAdminCourseEnddateSet().getText();
	    String selectedInst   = (String) courModifyView.getCourseInstructorNameBox().getSelectedItem();

	    // 2) VO 객체 생성 및 기본 필드 세팅
	    AdminCourseVO courVO = new AdminCourseVO();
	    courVO.setCourCardinal(courCardinal);
	    courVO.setCourName(courName);
	    courVO.setCourStatus(courStatus);
	    courVO.setCourStartdate(courStartDate);
	    courVO.setCourEnddate(courEndDate);

	    // 3) 선택된 강사 번호(instNum) 찾기
	    String instNum = "";
	    AdminCourseService courService = new AdminCourseService();
	    for (AdminCourseInstVO instVO : courService.searchAllInstructorInfo()) {
	        if (instVO.getInstName().equals(selectedInst)) {
	            instNum = instVO.getInstNum();
	            break;
	        }
	    }
	    courVO.setInstNum(instNum);

	    // 4) 사용자 확인 다이얼로그
	    String[] options = {"수정", "취소"};
	    int result = JOptionPane.showOptionDialog(
	        courModifyView,
	        "과정을 수정 하시겠습니까?",
	        "수정 확인",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.WARNING_MESSAGE,
	        null,
	        options,
	        options[1]
	    );

	    // 5) 확인 후 서비스 호출 및 결과 처리
	    if (result == 0) {
	        boolean flag = courService.modifyCourse(
	            courVO.getCourCardinal(),
	            courVO.getCourName(),
	            courVO.getCourStatus(),
	            courVO.getCourStartdate(),
	            courVO.getCourEnddate(),
	            courVO.getInstNum(),
	            selectedCourNum
	        );

	        if (flag) {
	            JOptionPane.showMessageDialog(courModifyView, "과정이 수정되었습니다.");
	        } else {
	            JOptionPane.showMessageDialog(courModifyView, "과정 수정에 실패했습니다.");
	        }
	        closeModifyDialog();

	    } else if (result == 1) {
	        JOptionPane.showMessageDialog(courModifyView, "과정 수정을 취소하였습니다.");
	    } else {
	        JOptionPane.showMessageDialog(courModifyView, "과정 수정 창을 닫았습니다.");
	    }
	}
	
	public void closeModifyDialog() {
		Window adminCourseModifyWindow = SwingUtilities.getWindowAncestor(courModifyView);
		if (adminCourseModifyWindow instanceof JDialog) {
			((JDialog) adminCourseModifyWindow).dispose();
		}
	} //closeModifyDialog

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == courseModifyButton) {
			modifyCourse();
		} // end if

		if (source == courseDeleteButton) {
			removeCourse();
		} // end if

		if (source == courseCloseButton) {
			System.out.println("닫기 버튼 실행");
			closeModifyDialog();
		} // end if

	} // actionPerformed

} // class

