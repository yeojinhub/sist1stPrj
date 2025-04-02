//package kr.co.sist.view;
package kr.co.sist.yj;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AdminCourseView extends JDialog{

	public AdminCourseView() {
		JPanel jpAdminCourseView = new JPanel();
		
		JLabel jlblTest = new JLabel("테스트");
		
		jpAdminCourseView.add(jlblTest);
		
		add(jpAdminCourseView);
	} //AdminCourseView
} //class