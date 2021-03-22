package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class ProvinceEpidemic {
    private Integer provinceEpidemicId;

    private Short provinceId;

    private Integer newDiagnosis;

    private Integer existingDiagnosis;

    private Integer cumulativeDiagnosis;

    private Integer cumulativeCure;

    private Integer cumulativeDeath;

    private Date updateTime;

    public Integer getProvinceEpidemicId() {
        return provinceEpidemicId;
    }

    public void setProvinceEpidemicId(Integer provinceEpidemicId) {
        this.provinceEpidemicId = provinceEpidemicId;
    }

    public Short getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getNewDiagnosis() {
        return newDiagnosis;
    }

    public void setNewDiagnosis(Integer newDiagnosis) {
        this.newDiagnosis = newDiagnosis;
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