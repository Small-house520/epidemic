package cn.edu.dgut.epidemic.pojo;

public class RolePermission {
    private Short rolePermissionId;

    private Short roleId;

    private Short permissionId;

    private String remarks;

    public Short getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Short rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public Short getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Short permissionId) {
        this.permissionId = permissionId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}