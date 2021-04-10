package cn.edu.dgut.epidemic.mapper;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.TreeMenu;

public interface PermissionCustomMapper {

	List<Permission> findMenuListByUserId(String id) throws Exception;

	List<Permission> findPermissionListByUserId(Integer id) throws Exception;

	List<TreeMenu> getMenuTree();

	List<Permission> getSubMenu(Integer id);

	Role findRoleAndPermissionListById(String id);

	List<Role> findRoleAndPermissionList();

	List<Permission> findMenuAndPermissionByUserId(String id);

	List<TreeMenu> getAllMenuAndPermision();

	List<Permission> findPermissionsByRoleId(Short roleId);
}
