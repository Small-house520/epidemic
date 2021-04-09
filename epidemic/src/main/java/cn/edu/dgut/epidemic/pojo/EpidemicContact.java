package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicContact {
    private Integer epidemicContactId;

    private String campusId;

    private String contactSource;

    private String isolationAddress;

    private Date isolationTime;

    private String remarks;

    public Integer getEpidemicContactId() {
        return epidemicContactId;
    }

    public void setEpidemicContactId(Integer epidemicContactId) {
        this.epidemicContactId = epidemicContactId;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId == null ? null : campusId.trim();
    }

    public String getContactSource() {
        return contactSource;
    }

    public void setContactSource(String contactSource) {
        this.contactSource = contactSource == null ? null : contactSource.trim();
    }

    public String getIsolationAddress() {
        return isolationAddress;
    }

    public void setIsolationAddress(String isolationAddress) {
        this.isolationAddress = isolationAddress == null ? null : isolationAddress.trim();
    }

    public Date getIsolationTime() {
        return isolationTime;
    }

    public void setIsolationTime(Date isolationTime) {
        this.isolationTime = isolationTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}