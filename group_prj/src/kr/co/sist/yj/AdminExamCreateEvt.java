package kr.co.sist.yj;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class AdminExamCreateEvt implements ActionListener {
    private AdminExamCreateView aecv;
    private AdminExamCreateService service = new AdminExamCreateService();

    public AdminExamCreateEvt(AdminExamCreateView aecv) {
        this.aecv = aecv;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == aecv.getJbtnAdminExamCreate()) {
            // VO에 값을 채운다.
            AdminExamCreateVO vo = new AdminExamCreateVO();
            // EXAM 기본정보
            vo.setExamName(aecv.getJtfExamName().getText().trim());
            vo.setCourseName(aecv.getJcbCourseName().getSelectedItem().toString());
            
            // 문제 1
            vo.setQ1Content(aecv.getJtaNo1TitleInput().getText().trim());
            vo.setQ1Option(aecv.getJtaNo1OptionSet().getText().trim());
            vo.setQ1Correct(parseAnswer(aecv.getJcbNo1AnswerSet()));
            
            // 문제 2
            vo.setQ2Content(aecv.getJtaNo2TitleInput().getText().trim());
            vo.setQ2Option(aecv.getJtaNo2OptionSet().getText().trim());
            vo.setQ2Correct(parseAnswer(aecv.getJcbNo2AnswerSet()));
            
            // 문제 3
            vo.setQ3Content(aecv.getJtaNo3TitleInput().getText().trim());
            vo.setQ3Option(aecv.getJtaNo3OptionSet().getText().trim());
            vo.setQ3Correct(parseAnswer(aecv.getJcbNo3AnswerSet()));
            
            // 문제 4
            vo.setQ4Content(aecv.getJtaNo4TitleInput().getText().trim());
            vo.setQ4Option(aecv.getJtaNo4OptionSet().getText().trim());
            vo.setQ4Correct(parseAnswer(aecv.getJcbNo4AnswerSet()));
            
            // 문제 5
            vo.setQ5Content(aecv.getJtaNo5TitleInput().getText().trim());
            vo.setQ5Option(aecv.getJtaNo5OptionSet().getText().trim());
            vo.setQ5Correct(parseAnswer(aecv.getJcbNo5AnswerSet()));
            
            // Service 호출: EXAM + EXAM_QUESTION 5건 등록
            boolean success = service.createExamQuestions(vo);
            if(success) {
                JOptionPane.showMessageDialog(aecv, "시험 및 문제 등록이 성공적으로 완료되었습니다.");
                closeDialog();
            } else {
                JOptionPane.showMessageDialog(aecv, "시험 등록에 실패했습니다.", "에러", JOptionPane.ERROR_MESSAGE);
            }
        } else if(source == aecv.getJbtnAdminExamClose()) {
            closeDialog();
        }
    }
    
    // ComboBox 선택값을 정수로 변환 (빈 값은 0 처리)
    private int parseAnswer(javax.swing.JComboBox cb) {
        String val = cb.getSelectedItem().toString().trim();
        if(val.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private void closeDialog() {
        Window window = SwingUtilities.getWindowAncestor(aecv);
        if(window instanceof JDialog) {
            ((JDialog)window).dispose();
        }
    }
}
