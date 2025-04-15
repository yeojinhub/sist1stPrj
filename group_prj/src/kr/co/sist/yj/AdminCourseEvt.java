//package kr.co.sist.evt;
package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//import kr.co.sist.view.AdminCourseView;

public class AdminCourseEvt extends MouseAdapter implements ActionListener {

	private AdminMainView mainView;
	private AdminCourseView courView;

	private JButton courCreateViewButton;
	private JButton courModifyViewButton;
	
	private int selectedRow = -1;
    private int courNum;

	public AdminCourseEvt(AdminMainView mainView, AdminCourseView courView) {
		this.mainView=mainView;
		this.courView=courView;
		this.courCreateViewButton = courView.getCourCreateViewButton();
		this.courModifyViewButton = courView.getCourModifyViewButton();
		
		loadCourseInfoTableList();
	} // AdminCourseEvt
	
	public void loadCourseInfoTableList() {
		AdminCourseService courService = new AdminCourseService();
		List<AdminCourseVO> courList = courService.searchAllCourseInfo();
		
		DefaultTableModel courTableModel = courView.getCourseTableModel();
		courTableModel.setRowCount(0);
		
		// 여기서는 JTable에서 선택한 행의 데이터들을 VO객체에 담는 작업을 한다.
		for(AdminCourseVO courVO : courList ) {
			courTableModel.addRow(new Object[] {
					courVO.getCourNum(),
					courVO.getCourCardinal(),
					courVO.getCourName(),
					courVO.getCourStatus(),
					courVO.getInstName(),
					courVO.getCourStartdate(),
					courVO.getCourEnddate(),
					
			});
		}// end for
		
	}// loadCourseInfoTableList
	
	public void showCreateDialog() {
		JDialog jdCourseCreateDialog = new JDialog((JFrame) null, "과정 등록", true);
		jdCourseCreateDialog.getContentPane().add(new AdminCourseCreateView(mainView, courView));
		jdCourseCreateDialog.pack();
		jdCourseCreateDialog.setLocationRelativeTo(mainView);
		jdCourseCreateDialog.setVisible(true);
		jdCourseCreateDialog.setResizable(false);
	} //showCreateDialog
	
	public void showModifyDialog() {
		JDialog jdCourseModifyDialog = new JDialog((JFrame) null, "과정 수정", true);
		jdCourseModifyDialog.getContentPane().add(new AdminCourseModifyView(this, courNum));
		jdCourseModifyDialog.pack();
		jdCourseModifyDialog.setLocationRelativeTo(mainView);
		jdCourseModifyDialog.setVisible(true);
		jdCourseModifyDialog.setResizable(false);
	} //showModifyDialog
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source == courCreateViewButton) {
			System.out.println("등록 버튼 실행");
			showCreateDialog();
			loadCourseInfoTableList();
		} // end if

		if (source == courModifyViewButton) {
			System.out.println("수정 버튼 실행");
			showModifyDialog();
			loadCourseInfoTableList();
		} // end if

	} // actionPerformed

	@Override
	public void mouseClicked(MouseEvent e) {
		// JTable에서 선택된 행의 인덱스 및 사번 추출
		selectedRow = courView.getCourseInfoTable().getSelectedRow();
		// 형변환(Object->String->Int)
		Object ob = courView.getCourseInfoTable().getValueAt(selectedRow, 0);
		String str = ob.toString();
		courNum = Integer.parseInt(str);
		System.out.println("선택된 과정 번호 : " + courNum);
		System.out.println("클릭한 행의 수 : " + selectedRow);
	}// mouseClicked
	

} // class
