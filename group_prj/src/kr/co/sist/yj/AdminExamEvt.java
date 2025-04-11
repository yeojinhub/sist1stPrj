package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class AdminExamEvt implements ActionListener {

	private AdminMainView amv;
	@SuppressWarnings("unused")
	private AdminExamView aev;
	
	private DefaultTableModel dftmAdminExamTableModel;
	private JTable jtAdminExamTable;
	
	private JButton jbtnAdminExamCreate;
	private JButton jbtnAdminExamModify;
	private JButton jbtnAdminExamDelete;
	
	public AdminExamEvt(AdminMainView amv,AdminExamView aev) {
		this.amv=amv;
		this.aev=aev;
		this.dftmAdminExamTableModel=aev.getDftmAdminExamTableModel();
		this.jtAdminExamTable=aev.getJtAdminExamTable();
		this.jbtnAdminExamCreate=aev.getJbtnAdminExamCreate();
		this.jbtnAdminExamModify=aev.getJbtnAdminExamModify();
		this.jbtnAdminExamDelete=aev.getJbtnAdminExamDelete();
	} //AdminExamEvt
	
	/**
	 * 실제 DB에서 exam 데이터를 조회하여 DefaultTableModel로 반환하는 메서드  
	 * DB 테이블과 컬럼명은 실제 환경에 맞게 수정해야 합니다.
	 */
	public void loadExamData() {
		
//		AdminExamDAO dao = new AdminExamDAO();
//		return dao.getExamData();
		
		AdminExamService examService = new AdminExamService();
		List<AdminExamVO> examList = examService.searchAllExamMember();
		
		DefaultTableModel model = aev.getDftmAdminExamTableModel();
		model.setRowCount(0);
		
		//강사 VO 객체들을 테이블에 추가
		for(AdminExamVO examVO : examList) {
			model.addRow(new Object[] {
					examVO.getExamName(),
					examVO.getCourName(),
					examVO.getInstName(),
					examVO.getExamDate()
			});
		} //end for
	}

	   
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
			
			loadExamData();
		} //end if
		if( source == jbtnAdminExamModify ) {
			System.out.println("수정 버튼 실행");
			JDialog jdExamModifyDialog = new JDialog((JFrame)null, "시험지 수정", true);
			jdExamModifyDialog.getContentPane().add(new AdminExamModifyView());
			jdExamModifyDialog.pack();
			jdExamModifyDialog.setLocationRelativeTo(amv);
			jdExamModifyDialog.setVisible(true);
			
			loadExamData();
		} //end if
		if( source == jbtnAdminExamDelete ) {
			System.out.println("삭제 버튼 실행");
			
			loadExamData();
		} //end if
		
	} //actionPerformed

} //class
