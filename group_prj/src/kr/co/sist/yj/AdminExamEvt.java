package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
					examVO.getExamNum(),
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
		
		if( source == jbtnAdminExamDelete ) {
			System.out.println("삭제 버튼 실행");
			 int selectedRow = jtAdminExamTable.getSelectedRow();
		        if(selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "삭제할 시험을 먼저 선택하세요.");
		            return;
		        }
		        
		        // exam_num이 숨김 컬럼(예를 들어, 첫 번째 컬럼)에 포함되어 있다고 가정함.
		        // 만약 현재 모델에 exam_num이 포함되어 있지 않다면, 테이블 모델을 수정하여 추가하세요.
		        int examNum = (int) jtAdminExamTable.getModel().getValueAt(selectedRow, 0);
		        
		        int confirm = JOptionPane.showConfirmDialog(null, "정말 해당 시험을 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		        if(confirm == JOptionPane.YES_OPTION) {
		            AdminExamService service = new AdminExamService();
		            boolean success = service.deleteExam(examNum);
		            if(success) {
		                JOptionPane.showMessageDialog(null, "시험 삭제가 성공적으로 완료되었습니다.");
		                // 삭제 후 테이블 갱신
		                loadExamData();
		            } else {
		                JOptionPane.showMessageDialog(null, "시험 삭제에 실패했습니다.", "에러", JOptionPane.ERROR_MESSAGE);
		            }
		} //end if
		
	} //actionPerformed
	}
} //class
