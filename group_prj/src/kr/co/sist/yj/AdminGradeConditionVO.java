package kr.co.sist.yj;

import java.util.Arrays;
import java.util.List;

public class AdminGradeConditionVO {

	private List<String> courCardinal;
	private List<String> examName;

	public AdminGradeConditionVO(List<String> courCardinal, List<String> examName) {
		super();
		this.courCardinal = courCardinal;
		this.examName = examName;
	}

	public AdminGradeConditionVO() {
		super();
	}

	public List<String> getCourCardinal() {
		return courCardinal;
	}

	public void setCourCardinal(List<String> courCardinal) {
		this.courCardinal = courCardinal;
	}

	public List<String> getExamName() {
		return examName;
	}

	public void setExamName(List<String> examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "AdminGradeConditionVO [courCardinal=" + courCardinal + ", examName=" + examName + "]";
	}

}
