package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class VolunteerEnroll {
    private Long campusId;

    private Date enrollTime;

    private String employOrNot;

    private String remarks;

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public String getEmployOrNot() {
        return employOrNot;
    }

    public void setEmployOrNot(String employOrNot) {
        this.employOrNot = employOrNot == null ? null : employOrNot.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}