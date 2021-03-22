package cn.edu.dgut.epidemic.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TemperatureItinerary {
    private Integer healthId;

    private Long campusId;

    private String physicalCondition;

    private String itineraryRecords;

    private String returnedToSchool;

    private String currentAddress;

    private BigDecimal temperature;

    private Date uploadDate;

    private String remarks;

    public Integer getHealthId() {
        return healthId;
    }

    public void setHealthId(Integer healthId) {
        this.healthId = healthId;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public String getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(String physicalCondition) {
        this.physicalCondition = physicalCondition == null ? null : physicalCondition.trim();
    }

    public String getItineraryRecords() {
        return itineraryRecords;
    }

    public void setItineraryRecords(String itineraryRecords) {
        this.itineraryRecords = itineraryRecords == null ? null : itineraryRecords.trim();
    }

    public String getReturnedToSchool() {
        return returnedToSchool;
    }

    public void setReturnedToSchool(String returnedToSchool) {
        this.returnedToSchool = returnedToSchool == null ? null : returnedToSchool.trim();
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress == null ? null : currentAddress.trim();
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}