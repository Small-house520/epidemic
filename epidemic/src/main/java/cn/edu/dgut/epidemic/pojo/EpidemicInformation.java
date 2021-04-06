package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicInformation {
    private Integer informationId;

    private String title;

    private String correspondingLink;

    private Date releaseTime;

    private String informationFlag;

    private String remarks;

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCorrespondingLink() {
        return correspondingLink;
    }

    public void setCorrespondingLink(String correspondingLink) {
        this.correspondingLink = correspondingLink == null ? null : correspondingLink.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getInformationFlag() {
        return informationFlag;
    }

    public void setInformationFlag(String informationFlag) {
        this.informationFlag = informationFlag == null ? null : informationFlag.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}