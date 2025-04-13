package kr.co.sist.yj;

public enum GradeSearchSelectedEnum {
    SELECT_NOTHING(0),
    SELECT_ONE_CARDINAL(1),
    SELECT_ONE_EXAM_NAME(2),
    SELECT_TWO(3);

    private final int index;

    GradeSearchSelectedEnum(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(index);
    }
    
}
