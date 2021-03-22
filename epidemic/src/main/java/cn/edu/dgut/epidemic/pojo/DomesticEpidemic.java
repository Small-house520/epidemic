package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class DomesticEpidemic {
    private Short epidemicId;

    private Integer existingDiagnosis;

    private Integer cumulativeDiagnosis;

    private Integer overseasInput;

    private Integer existingAsymptomatic;

    private Integer cumulativeCure;

    private Integer cumulativeDeath;

    private Date updateTime;

    public Short getEpidemicId() {
        return epidemicId;
    }

    public void setEpidemicId(Short epidemicId) {
        this.epidemicId = epidemicId;
    }

    public Integer getExistingDiagnosis() {
        return existingDiagnosis;
    }

    public void setExistingDiagnosis(Integer existingDiagnosis) {
        this.existingDiagnosis = existingDiagnosis;
    }

    public Integer getCumulativeDiagnosis() {
        return cumulativeDiagnosis;
    }

    public void setCumulativeDiagnosis(Integer cumulativeDiagnosis) {
        this.cumulativeDiagnosis = cumulativeDiagnosis;
    }

    public Integer getOverseasInput() {
        return overseasInput;
    }

    public void setOverseasInput(Integer overseasInput) {
        this.overseasInput = overseasInput;
    }

    public Integer getExistingAsymptomatic() {
        return existingAsymptomatic;
    }

    public void setExistingAsymptomatic(Integer existingAsymptomatic) {
        this.existingAsymptomatic = existingAsymptomatic;
    }

    public Integer getCumulativeCure() {
        return cumulativeCure;
    }

    public void setCumulativeCure(Integer cumulativeCure) {
        this.cumulativeCure = cumulativeCure;
    }

    public Integer getCumulativeDeath() {
        return cumulativeDeath;
    }

    public void setCumulativeDeath(Integer cumulativeDeath) {
        this.cumulativeDeath = cumulativeDeath;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}