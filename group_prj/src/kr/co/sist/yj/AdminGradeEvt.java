package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AdminGradeEvt implements ActionListener {

	@SuppressWarnings("unused")
	private AdminGradeView agv;

	private JButton jbtnAdminGradeSearch;

	public AdminGradeEvt(AdminGradeView agv) {
		this.agv = agv;
		this.jbtnAdminGradeSearch = agv.getJbtnAdminGradeSearch();

		// 생성과 동시에 데이터 리로드
		loadAllGradeInfo();
	} // AdminGradeEvt

	public void loadAllGradeInfo() {
		AdminGradeService ags = new AdminGradeService();

		// View에 인스턴스 변수(VO 담은 리스트)에 저장! ><
		agv.setAgVO(ags.searchAllGradeInfo());

		// JTable 데이터 로드
		for (AdminGradeVO agvo : agv.getAgVO()) {
			agv.getDftmAdminGradeTableModel().addRow(new Object[] { agvo.getCourCardinal(), agvo.getExamName(),
					agvo.getStuName(), agvo.getExamAnswCount(), agvo.getExamDate() });
		} // end for

		// JComboBox 데이터 로드
		AdminGradeConditionVO agcVO = ags.searchGradeSearchCondition();
		for (String str : agcVO.getCourCardinal()) {
			agv.getJcbAdminGradeCourseCardinalBox().addItem(str);
		} // end for

		for (String str : agcVO.getExamName()) {
			agv.getJcbAdminGradeExamNameBox().addItem(str);
		} // end for

	}// loadAllGradeInfo

	public void searchGrade() {
		// JComboBox에서 선택한 것 String 변수에 넣기 ( 삼항연산자로 미선택시 Empty 반영 )
		String courCardinal = (String) agv.getJcbAdminGradeCourseCardinalBox().getSelectedItem();
		courCardinal = courCardinal.equals("기수 선택") ? "" : courCardinal;

		String examName = (String) agv.getJcbAdminGradeExamNameBox().getSelectedItem();
		examName = examName.equals("과목 선택") ? "" : examName;

		// #. if문으로 선택된 상황에 따른 flag 설정
		GradeSearchSelectedEnum flag = GradeSearchSelectedEnum.SELECT_NOTHING;

		// #-1. 기수 선택 X, 과목 선택 O
		if (courCardinal.isEmpty() && !examName.isEmpty()) {
			flag = GradeSearchSelectedEnum.SELECT_ONE_EXAM_NAME;
		}

		// #-2. 기수 선택 O, 과목 선택 X
		if (!courCardinal.isEmpty() && examName.isEmpty()) {
			flag = GradeSearchSelectedEnum.SELECT_ONE_CARDINAL;
		}

		// #-3. 둘 다 선택 O
		if (!courCardinal.isEmpty() && !examName.isEmpty()) {
			flag = GradeSearchSelectedEnum.SELECT_TWO;
		}

		// #-4. Switch Case로 상황마다 데이터 리로드 달리 하기. ><
		switch (flag) {
		case SELECT_NOTHING:
			// JTable 데이터 초기화
			agv.getDftmAdminGradeTableModel().setRowCount(0);

			// foreach로 데이터 로드
			for (AdminGradeVO agvo : agv.getAgVO()) {
				agv.getDftmAdminGradeTableModel().addRow(new Object[] { agvo.getCourCardinal(), agvo.getExamName(),
						agvo.getStuName(), agvo.getExamAnswCount(), agvo.getExamDate() });
			} // end for
			break;
		case SELECT_ONE_EXAM_NAME:
			// JTable 데이터 초기화
			agv.getDftmAdminGradeTableModel().setRowCount(0);

			// foreach로 데이터 로드
			for (AdminGradeVO agvo : agv.getAgVO()) {
				if (agvo.getExamName().equals(examName)) {
					agv.getDftmAdminGradeTableModel().addRow(new Object[] { agvo.getCourCardinal(), agvo.getExamName(),
							agvo.getStuName(), agvo.getExamAnswCount(), agvo.getExamDate() });
				} // end if
			} // end for
			break;

		case SELECT_ONE_CARDINAL:
			// JTable 데이터 초기화
			agv.getDftmAdminGradeTableModel().setRowCount(0);

			// foreach로 데이터 로드
			for (AdminGradeVO agvo : agv.getAgVO()) {
				if (agvo.getCourCardinal().equals(courCardinal)) {
					agv.getDftmAdminGradeTableModel().addRow(new Object[] { agvo.getCourCardinal(), agvo.getExamName(),
							agvo.getStuName(), agvo.getExamAnswCount(), agvo.getExamDate() });
				} // end if
			} // end for
			break;

		case SELECT_TWO:
			// JTable 데이터 초기화
			agv.getDftmAdminGradeTableModel().setRowCount(0);

			// foreach로 데이터 로드
			for (AdminGradeVO agvo : agv.getAgVO()) {
				if (agvo.getExamName().equals(examName) && agvo.getCourCardinal().equals(courCardinal)) {
					agv.getDftmAdminGradeTableModel().addRow(new Object[] { agvo.getCourCardinal(), agvo.getExamName(),
							agvo.getStuName(), agvo.getExamAnswCount(), agvo.getExamDate() });
				} // end if
			} // end for
			break;
		}// end switch

	}// searchGrade

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == jbtnAdminGradeSearch) {
			searchGrade();
		} // end if
	} // actionPerformed

} // class
