package kr.co.sist.ldu;

public class InstructorScoreVO {
	private String courCardinal;  // 기수
	private String courName;      // 과정명
	private String examName;      // 과목명(시험명)
	private String studName;      // 학생명
	private int score;            // 점수

	public InstructorScoreVO() {}

	public InstructorScoreVO(String courCardinal, String courName, String examName, String studName, int score) {
		this.courCardinal = courCardinal;
		this.courName = courName;
		this.examName = examName;
		this.studName = studName;
		this.score = score;
	}

	public String getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
