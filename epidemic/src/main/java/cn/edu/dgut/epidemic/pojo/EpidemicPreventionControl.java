package cn.edu.dgut.epidemic.pojo;

import java.util.Date;

public class EpidemicPreventionControl {
    private Short preventionControlId;

    private String title;

    private String correspondingLink;

    private Date releaseTime;

    private String remarks;

    public Short getPreventionControlId() {
        return preventionControlId;
    }

    public void setPreventionControlId(Short preventionControlId) {
        this.preventionControlId = preventionControlId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}