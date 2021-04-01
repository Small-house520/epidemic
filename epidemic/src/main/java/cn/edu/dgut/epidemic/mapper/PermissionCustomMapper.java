package cn.edu.dgut.epidemic.mapper;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.TreeMenu;

public interface PermissionCustomMapper {

	public List<Permission> findMenuListByUserId(String userid) throws Exception;

	public List<Permission> findPermissionListByUserId(String userid) throws Exception;

	public List<TreeMenu> getMenuTree();

	public List<Permission> getSubMenu();

	public Role findRoleAndPermissionListByUserId(String userId);

	public List<Role> findRoleAndPermissionList();

	public List<Permission> findMenuAndPermissionByUserId(String userId);

	public List<TreeMenu> getAllMenuAndPermision();

	public List<Permission> findPermissionsByRoleId(Short roleId);
}
