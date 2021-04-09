package cn.edu.dgut.epidemic.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义用户身份信息
 * 
 * 存入session 由于tomcat会将session序列化在本地硬盘上，所以使用Serializable接口
 */
public class CustomUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String campusId;

	private String userPassword;

	private String username;

	private Short roleId;

	private List<Permission> menus;// 菜单
	private List<Permission> permissions;// 权限
	private List<TreeMenu> treeMenus;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCampusId() {
		return campusId;
	}

	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public Short getRoleId() {
		return roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	public List<Permission> getMenus() {
		return menus;
	}

	public void setMenus(List<Permission> menus) {
		this.menus = menus;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<TreeMenu> getTreeMenus() {
		return treeMenus;
	}

	public void setTreeMenus(List<TreeMenu> treeMenus) {
		this.treeMenus = treeMenus;
	}

}