package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class VolunteerService {
    private Integer volunteerServiceId;

    private String title;

    private String details;

    private String campusId;

    private String sponsorOrg;

    private Short expectedVolunteers;

    private String conditions;

    private Short participatedVolunteers;

    private String location;

    private Date initiateTime;

    private Date deadline;

    private Date startTime;

    private Date endTime;

    private String remarks;

    private String state;

    public Integer getVolunteerServiceId() {
        return volunteerServiceId;
    }

    public void setVolunteerServiceId(Integer volunteerServiceId) {
        this.volunteerServiceId = volunteerServiceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId == null ? null : campusId.trim();
    }

    public String getSponsorOrg() {
        return sponsorOrg;
    }

    public void setSponsorOrg(String sponsorOrg) {
        this.sponsorOrg = sponsorOrg == null ? null : sponsorOrg.trim();
    }

    public Short getExpectedVolunteers() {
        return expectedVolunteers;
    }

    public void setExpectedVolunteers(Short expectedVolunteers) {
        this.expectedVolunteers = expectedVolunteers;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions == null ? null : conditions.trim();
    }

    public Short getParticipatedVolunteers() {
        return participatedVolunteers;
    }

    public void setParticipatedVolunteers(Short participatedVolunteers) {
        this.participatedVolunteers = participatedVolunteers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}