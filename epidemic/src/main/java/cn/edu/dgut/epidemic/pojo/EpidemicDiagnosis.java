package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicDiagnosis {
    private Integer epidemicDiagnosisId;

    private Long campusId;

    private String symptoms;

    private String hospital;

    private Date diagnosisTime;

    private String sourceOfInfection;

    private String whetherSevere;

    private String remarks;

    public Integer getEpidemicDiagnosisId() {
        return epidemicDiagnosisId;
    }

    public void setEpidemicDiagnosisId(Integer epidemicDiagnosisId) {
        this.epidemicDiagnosisId = epidemicDiagnosisId;
    }

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

    public Date getDiagnosisTime() {
        return diagnosisTime;
    }

    public void setDiagnosisTime(Date diagnosisTime) {
        this.diagnosisTime = diagnosisTime;
    }

    public String getSourceOfInfection() {
        return sourceOfInfection;
    }

    public void setSourceOfInfection(String sourceOfInfection) {
        this.sourceOfInfection = sourceOfInfection == null ? null : sourceOfInfection.trim();
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