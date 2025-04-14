package kr.co.sist.yj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminAccountAdminAccountEvt extends MouseAdapter implements ActionListener{
	
	private AdminAccountAdminAccountView admView;
	
	private JButton admCreateViewButton;
    private JButton admModifyViewButton;
    
    private int selectedRow = -1;
    private String strAdmID;
	
	public AdminAccountAdminAccountEvt(AdminAccountAdminAccountView admView) {
		this.admView=admView;
		this.admCreateViewButton=admView.getAdmCreateViewButton();
		this.admModifyViewButton=admView.getAdmModifyViewButton();
	} //AdminAccountAdminAccountEvt
	
	public void showCreateDialog() {
		
		JDialog admCreateDialog = new JDialog((JFrame) null, "관리자 계정 생성", true);
		admCreateDialog.getContentPane().add(new AdminAccountAdminAccountCreateView());
		admCreateDialog.pack();
		admCreateDialog.setLocationRelativeTo(admView);
		admCreateDialog.setVisible(true);
		admCreateDialog.setResizable(false);
		
	} //showCreateDialog
	
	public void showModifyDialog() {
		
		JDialog admModifyDialog = new JDialog((JFrame) null, "관리자 계정 수정", true);
		AdminAccountAdminAccountModifyView modifyView = new AdminAccountAdminAccountModifyView(strAdmID);
		
		admModifyDialog.getContentPane().add(modifyView);
		admModifyDialog.pack();
		admModifyDialog.setLocationRelativeTo(admView);
		admModifyDialog.setVisible(true);
		admModifyDialog.setResizable(false);
		
	} //showModifyDialog
	
	public void loadAdminInfoTableList() {
		AdminAccountAdminAccountInfoService admService = new AdminAccountAdminAccountInfoService();
		List<AdminAccountAdminAccountInfoVO> adminList = admService.searchAllAdminAccountMember();
		
		DefaultTableModel admTableModel = admView.getAdmTableModel();
		admTableModel.setRowCount(0);
		
		// 관리자 VO 객체들을 테이블에 추가
		for( AdminAccountAdminAccountInfoVO admVO : adminList ) {
			admTableModel.addRow(new Object[] {
					admVO.getAdmID(),
					admVO.getAdmName(),
					admVO.getAdmBirth(),
					admVO.getAdmTel(),
					admVO.getAdmAdd()
			});
		} //end for
		
	} //loadAdminInfoTableList
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		
		if( source == admCreateViewButton ) {
			System.out.println("생성 버튼 실행");
			showCreateDialog();
			loadAdminInfoTableList();
		} //end if
		
		if( source == admModifyViewButton ) {
			System.out.println("수정 버튼 실행");
			
			//null일때 예외처리
		    if(selectedRow == -1) {
		    	System.out.println("관리자 계정에서 수정이 선택된 행의 수 : "+selectedRow);
		        JOptionPane.showMessageDialog(admView, "수정할 관리자 계정을 선택해주세요.");
		        //early return
		        return;
		    } else {
		    	showModifyDialog();
		    	loadAdminInfoTableList();
		    } //end if else
		} //end if
		
	} //actionPerformed

	@Override
	public void mouseClicked(MouseEvent me) {
		// JTable에서 선택된 행의 인덱스 및 사번 추출
		selectedRow = admView.getAdmInfoTable().getSelectedRow();
		strAdmID = admView.getAdmInfoTable()
				.getValueAt(selectedRow, 0).toString();
		System.out.println("선택된 관리자 사번: " + strAdmID);
		System.out.println("클릭한 행의 수 : " + selectedRow);
	} //mouseClicked

} //class
