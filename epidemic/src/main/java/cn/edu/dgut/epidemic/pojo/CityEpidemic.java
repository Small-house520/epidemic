package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class CityEpidemic {
    private Long cityEpidemicId;

    private Short cityId;

    private Integer newDiagnosis;

    private Integer existingDiagnosis;

    private Integer cumulativeDiagnosis;

    private Integer cumulativeCure;

    private Integer cumulativeDeath;

    private Date updateTime;

    public Long getCityEpidemicId() {
        return cityEpidemicId;
    }

    public void setCityEpidemicId(Long cityEpidemicId) {
        this.cityEpidemicId = cityEpidemicId;
    }

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
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