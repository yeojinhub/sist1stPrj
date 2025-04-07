package kr.co.sist.kti;

public class StudentGradeVO {

	private int gradeNum;
	private int examAnswCount;
	private String stuNum;
	private int examNum;
	private String examName;

	public StudentGradeVO(int gradeNum, int examAnswCount, String stuNum, int examNum, String examName) {
		super();
		this.gradeNum = gradeNum;
		this.examAnswCount = examAnswCount;
		this.stuNum = stuNum;
		this.examNum = examNum;
		this.examName = examName;
	}

	public StudentGradeVO() {
		super();
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public int getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}

	public int getExamAnswCount() {
		return examAnswCount;
	}

	public void setExamAnswCount(int examAnswCount) {
		this.examAnswCount = examAnswCount;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public int getExamNum() {
		return examNum;
	}

	public void setExamNum(int examNum) {
		this.examNum = examNum;
	}

	@Override
	public String toString() {
		return "StudentGradeVO [gradeNum=" + gradeNum + ", examAnswCount=" + examAnswCount + ", stuNum=" + stuNum
				+ ", examNum=" + examNum + ", examName=" + examName + "]";
	}

}
