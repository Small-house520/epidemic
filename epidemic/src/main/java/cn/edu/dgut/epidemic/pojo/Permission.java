package cn.edu.dgut.epidemic.pojo;

public class Permission {
    private Integer permissionId;

    private String permissionName;

    private String permissionType;

    private String accessUrl;

    private String permissionCode;

    private Integer parentId;

    private String parentIdList;

    private String menuSorting;

    private String remarks;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl == null ? null : accessUrl.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIdList() {
        return parentIdList;
    }

    public void setParentIdList(String parentIdList) {
        this.parentIdList = parentIdList == null ? null : parentIdList.trim();
    }

    public String getMenuSorting() {
        return menuSorting;
    }

    public void setMenuSorting(String menuSorting) {
        this.menuSorting = menuSorting == null ? null : menuSorting.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}