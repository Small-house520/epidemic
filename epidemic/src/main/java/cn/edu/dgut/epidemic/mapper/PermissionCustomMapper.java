package cn.edu.dgut.epidemic.mapper;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.TreeMenu;

public interface PermissionCustomMapper {

	List<Permission> findMenuListByUserId(String userid) throws Exception;

	List<Permission> findPermissionListByUserId(Integer userid) throws Exception;

	List<TreeMenu> getMenuTree();

	List<Permission> getSubMenu();

	Role findRoleAndPermissionListById(Long id);

	List<Role> findRoleAndPermissionList();

	List<Permission> findMenuAndPermissionByUserId(String userId);

	List<TreeMenu> getAllMenuAndPermision();

	List<Permission> findPermissionsByRoleId(Short roleId);
}
