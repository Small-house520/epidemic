package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicCureDeath {
    private Integer epidemicCureId;

    private Long campusId;

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

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
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