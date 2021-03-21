package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicDiagnosisSuspected {
    private Long campusId;

    private String symptoms;

    private String hospital;

    private Date lengthOfStay;

    private String sourceOfInfection;

    private String whetherDiagnosed;

    private String whetherSevere;

    private String remarks;

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms == null ? null : symptoms.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public Date getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(Date lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }

    public String getSourceOfInfection() {
        return sourceOfInfection;
    }

    public void setSourceOfInfection(String sourceOfInfection) {
        this.sourceOfInfection = sourceOfInfection == null ? null : sourceOfInfection.trim();
    }

    public String getWhetherDiagnosed() {
        return whetherDiagnosed;
    }

    public void setWhetherDiagnosed(String whetherDiagnosed) {
        this.whetherDiagnosed = whetherDiagnosed == null ? null : whetherDiagnosed.trim();
    }

    public String getWhetherSevere() {
        return whetherSevere;
    }

    public void setWhetherSevere(String whetherSevere) {
        this.whetherSevere = whetherSevere == null ? null : whetherSevere.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}