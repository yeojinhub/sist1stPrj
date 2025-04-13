package kr.co.sist.yj;

public class AdminGradeVO {

	private String courCardinal;
	private String examName;
	private String stuName;
	private String examAnswCount;
	private String examDate;

	public AdminGradeVO(String courCardinal, String examName, String stuName, String examAnswCount, String examDate) {
		super();
		this.courCardinal = courCardinal;
		this.examName = examName;
		this.stuName = stuName;
		this.examAnswCount = examAnswCount;
		this.examDate = examDate;
	}

	public AdminGradeVO() {
		super();
	}

	public String getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(String courCardinal) {
		this.courCardinal = courCardinal;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getExamAnswCount() {
		return examAnswCount;
	}

	public void setExamAnswCount(String examAnswCount) {
		this.examAnswCount = examAnswCount;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "AdminGradeVO [courCardinal=" + courCardinal + ", examName=" + examName + ", stuName=" + stuName
				+ ", examAnswCount=" + examAnswCount + ", examDate=" + examDate + "]";
	}

}
