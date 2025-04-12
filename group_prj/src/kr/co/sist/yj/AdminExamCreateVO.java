package kr.co.sist.yj;

public class AdminExamCreateVO {
    // EXAM 테이블 등록 정보
    private String examName;    // 과목명
    private String courseName;  // 과정명

    // 1번 문제
    private String q1Content;
    private String q1Option;
    private int q1Correct;
    
    // 2번 문제
    private String q2Content;
    private String q2Option;
    private int q2Correct;
    
    // 3번 문제
    private String q3Content;
    private String q3Option;
    private int q3Correct;
    
    // 4번 문제
    private String q4Content;
    private String q4Option;
    private int q4Correct;
    
    // 5번 문제
    private String q5Content;
    private String q5Option;
    private int q5Correct;
    
    public AdminExamCreateVO() {}
    
    // Getter & Setter
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getQ1Content() {
        return q1Content;
    }
    public void setQ1Content(String q1Content) {
        this.q1Content = q1Content;
    }
    public String getQ1Option() {
        return q1Option;
    }
    public void setQ1Option(String q1Option) {
        this.q1Option = q1Option;
    }
    public int getQ1Correct() {
        return q1Correct;
    }
    public void setQ1Correct(int q1Correct) {
        this.q1Correct = q1Correct;
    }
    public String getQ2Content() {
        return q2Content;
    }
    public void setQ2Content(String q2Content) {
        this.q2Content = q2Content;
    }
    public String getQ2Option() {
        return q2Option;
    }
    public void setQ2Option(String q2Option) {
        this.q2Option = q2Option;
    }
    public int getQ2Correct() {
        return q2Correct;
    }
    public void setQ2Correct(int q2Correct) {
        this.q2Correct = q2Correct;
    }
    public String getQ3Content() {
        return q3Content;
    }
    public void setQ3Content(String q3Content) {
        this.q3Content = q3Content;
    }
    public String getQ3Option() {
        return q3Option;
    }
    public void setQ3Option(String q3Option) {
        this.q3Option = q3Option;
    }
    public int getQ3Correct() {
        return q3Correct;
    }
    public void setQ3Correct(int q3Correct) {
        this.q3Correct = q3Correct;
    }
    public String getQ4Content() {
        return q4Content;
    }
    public void setQ4Content(String q4Content) {
        this.q4Content = q4Content;
    }
    public String getQ4Option() {
        return q4Option;
    }
    public void setQ4Option(String q4Option) {
        this.q4Option = q4Option;
    }
    public int getQ4Correct() {
        return q4Correct;
    }
    public void setQ4Correct(int q4Correct) {
        this.q4Correct = q4Correct;
    }
    public String getQ5Content() {
        return q5Content;
    }
    public void setQ5Content(String q5Content) {
        this.q5Content = q5Content;
    }
    public String getQ5Option() {
        return q5Option;
    }
    public void setQ5Option(String q5Option) {
        this.q5Option = q5Option;
    }
    public int getQ5Correct() {
        return q5Correct;
    }
    public void setQ5Correct(int q5Correct) {
        this.q5Correct = q5Correct;
    }
    
    @Override
    public String toString() {
        return "AdminExamCreateVO [examName=" + examName + ", courseName=" + courseName 
            + ", q1Content=" + q1Content + ", q1Option=" + q1Option + ", q1Correct=" + q1Correct
            + ", q2Content=" + q2Content + ", q2Option=" + q2Option + ", q2Correct=" + q2Correct
            + ", q3Content=" + q3Content + ", q3Option=" + q3Option + ", q3Correct=" + q3Correct
            + ", q4Content=" + q4Content + ", q4Option=" + q4Option + ", q4Correct=" + q4Correct
            + ", q5Content=" + q5Content + ", q5Option=" + q5Option + ", q5Correct=" + q5Correct + "]";
    }
}
