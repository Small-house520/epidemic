package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicCureDeath {
    private Integer epidemicCureId;

    private String campusId;

    private String state;

    private Date timeOfCure;

    private Date timeOfDeath;

    private String remarks;

    public Integer getEpidemicCureId() {
        return epidemicCureId;
    }

    public void setEpidemicCureId(Integer epidemicCureId) {
        this.epidemicCureId = epidemicCureId;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId == null ? null : campusId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getTimeOfCure() {
        return timeOfCure;
    }

    public void setTimeOfCure(Date timeOfCure) {
        this.timeOfCure = timeOfCure;
    }

    public Date getTimeOfDeath() {
        return timeOfDeath;
    }

    public void setTimeOfDeath(Date timeOfDeath) {
        this.timeOfDeath = timeOfDeath;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}