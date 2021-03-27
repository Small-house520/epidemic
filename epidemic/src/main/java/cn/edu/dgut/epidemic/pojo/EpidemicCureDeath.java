package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicCureDeath {
    private Integer epidemicCureId;

    private Long campusId;

    private String status;

    private Date timeOfDischarge;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTimeOfDischarge() {
        return timeOfDischarge;
    }

    public void setTimeOfDischarge(Date timeOfDischarge) {
        this.timeOfDischarge = timeOfDischarge;
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