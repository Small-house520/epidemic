package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class VolunteerEnroll {
    private Integer volunteerId;

    private Long campusId;

    private Integer volunteerServiceId;

    private String isQualified;

    private Date enrollTime;

    private String employOrNot;

    private String volunteerRemarks;

    private String sponsorRemarks;

    private String state;

    public Integer getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Integer volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public Integer getVolunteerServiceId() {
        return volunteerServiceId;
    }

    public void setVolunteerServiceId(Integer volunteerServiceId) {
        this.volunteerServiceId = volunteerServiceId;
    }

    public String getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(String isQualified) {
        this.isQualified = isQualified == null ? null : isQualified.trim();
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

    public String getVolunteerRemarks() {
        return volunteerRemarks;
    }

    public void setVolunteerRemarks(String volunteerRemarks) {
        this.volunteerRemarks = volunteerRemarks == null ? null : volunteerRemarks.trim();
    }

    public String getSponsorRemarks() {
        return sponsorRemarks;
    }

    public void setSponsorRemarks(String sponsorRemarks) {
        this.sponsorRemarks = sponsorRemarks == null ? null : sponsorRemarks.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}