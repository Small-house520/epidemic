package cn.edu.dgut.epidemic.pojo;

public class GradeClass {
    private Integer classId;

    private String gradeClass;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(String gradeClass) {
        this.gradeClass = gradeClass == null ? null : gradeClass.trim();
    }
}