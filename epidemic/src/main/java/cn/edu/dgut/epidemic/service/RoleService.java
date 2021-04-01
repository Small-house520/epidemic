package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.TreeMenu;

public interface RoleService {

	/**
	 * 获取树形菜单
	 * 
	 * @return
	 */
	List<TreeMenu> loadTreeMenu();

	/**
	 * 查询所有menu类permission
	 * 
	 * @return
	 */
	List<Permission> findAllMenus();

	/**
	 * 获取角色和权限关系
	 * 
	 * @return
	 */
	List<Role> findRolesAndPermissions();

	/**
	 * 查询出最后一条记录的id
	 * 
	 * @return
	 */
	Short findLastId();

	/**
	 * 添加角色和角色权限关系
	 * 
	 * @param role
	 * @param permissionIds
	 */
	void addRoleAndPermissions(Role role, short[] permissionIds);

	/**
	 * 添加权限
	 * 
	 * @param permission
	 */
	void addPermission(Permission permission);

	/**
	 * 查询出所有角色信息
	 * 
	 * @return
	 */
	List<Role> findAllRoles();

	/**
	 * 查询所有菜单和权限信息
	 * 
	 * @return
	 */
	List<TreeMenu> getAllMenuAndPermision();

	/**
	 * 根据角色ID查询权限
	 * 
	 * @param roleId
	 * @return
	 */
	List<Permission> findPermissionsByRoleId(Short roleId);

	/**
	 * 更新角色和权限关系
	 * 
	 * @param roleId
	 * @param permissionIds
	 */
	void updateRoleAndPermissions(Short roleId, short[] permissionIds);

	/**
	 * 根据用户名查询角色和权限关系
	 * 
	 * @param userId
	 * @return
	 */
	Role findRolesAndPermissionsByUserName(String userName);

	/**
	 * 删除角色
	 * 
	 * @param id
	 */
	void deleteRole(Short id);

	// 根据用户id查询权限范围的菜单
	List<Permission> findMenuListByUserId(String userid) throws Exception;

	// 根据用户id查询权限范围的url
	List<Permission> findPermissionListByUserId(String userid) throws Exception;

	// 根据用户ID查询其所有的菜单和权限
	List<Permission> findMenuAndPermissionByUserId(String userId);

	Role findRoleById(Short roleId);
}
