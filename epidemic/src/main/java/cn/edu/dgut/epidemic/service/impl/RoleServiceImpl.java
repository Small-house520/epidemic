package cn.edu.dgut.epidemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.dgut.epidemic.mapper.PermissionCustomMapper;
import cn.edu.dgut.epidemic.mapper.PermissionMapper;
import cn.edu.dgut.epidemic.mapper.RoleMapper;
import cn.edu.dgut.epidemic.mapper.RolePermissionMapper;
import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.PermissionExample;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.RolePermission;
import cn.edu.dgut.epidemic.pojo.RolePermissionExample;
import cn.edu.dgut.epidemic.pojo.TreeMenu;
import cn.edu.dgut.epidemic.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private PermissionCustomMapper permissionCustomMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	// @Autowired
	// private CampusUserMapper campusUserMapper;

	// 获取树形菜单
	@Override
	public List<TreeMenu> loadTreeMenu() {
		return this.permissionCustomMapper.getMenuTree();
	}

	// 获取菜单
	@Override
	public List<Permission> findAllMenus() {
		PermissionExample example = new PermissionExample();
		PermissionExample.Criteria criteria = example.createCriteria();
		// criteria.andTypeLike("%menu%");
		criteria.andPermissionTypeEqualTo("menu");
		return this.permissionMapper.selectByExample(example);
	}

	// 查询所有角色和其权限列表
	@Override
	public List<Role> findRolesAndPermissions() {
		return this.permissionCustomMapper.findRoleAndPermissionList();
	}

	// 查询出最后一条记录的id
	@Override
	public Short findLastId() {
		return this.roleMapper.selectLastId();
	}

	// 添加角色和角色权限关系
	@Override
	public void addRoleAndPermissions(Role role, short[] permissionIds) {
		// 添加角色
		this.roleMapper.insert(role);
		// 添加角色和权限关系表
		if (permissionIds != null) {
			for (int i = 0; i < permissionIds.length; i++) {
				RolePermission rolePermission = new RolePermission();
				// 16进制随机码
				// String uuid = UUID.randomUUID().toString();
				rolePermission.setRoleId(role.getRoleId());
				rolePermission.setPermissionId(permissionIds[i]);
				this.rolePermissionMapper.insertSelective(rolePermission);
			}
		}

	}

	// 添加权限
	@Override
	public void addPermission(Permission permission) {
		this.permissionMapper.insert(permission);
	}

	// 查询出所有角色信息
	@Override
	public List<Role> findAllRoles() {
		return this.roleMapper.selectByExample(null);
	}

	// 查询所有菜单和权限信息
	@Override
	public List<TreeMenu> getAllMenuAndPermision() {
		return this.permissionCustomMapper.getAllMenuAndPermision();
	}

	// 根据角色id查询权限信息
	@Override
	public List<Permission> findPermissionsByRoleId(Short roleId) {
		return this.permissionCustomMapper.findPermissionsByRoleId(roleId);
	}

	// 更新角色和权限关系
	@Override
	public void updateRoleAndPermissions(Short roleId, short[] permissionIds) {
		// 先删除角色权限关系表中角色的权限关系
		RolePermissionExample example = new RolePermissionExample();
		RolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		this.rolePermissionMapper.deleteByExample(example);
		// 重新创建角色权限关系
		for (short pid : permissionIds) {
			RolePermission rolePermission = new RolePermission();
			// String uuid = UUID.randomUUID().toString();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(pid);

			this.rolePermissionMapper.insert(rolePermission);
		}
	}

	// 根据用户帐号，查询所有角色和其权限列表
	@Override
	public Role findRolesAndPermissionsByUserName(String userName) {
		return this.permissionCustomMapper.findRoleAndPermissionListByUserId(userName);
	}

	// 根据id删除角色
	@Override
	public void deleteRole(Short id) {
		this.roleMapper.deleteByPrimaryKey(id);
	}

	// 查询菜单列表
	@Override
	public List<Permission> findMenuListByUserId(String userid) throws Exception {
		return this.permissionCustomMapper.findMenuListByUserId(userid);
	}

	// 查询权限列表
	@Override
	public List<Permission> findPermissionListByUserId(String userid) throws Exception {
		return this.permissionCustomMapper.findPermissionListByUserId(userid);
	}

	// 查询菜单和权限信息
	@Override
	public List<Permission> findMenuAndPermissionByUserId(String userId) {
		return this.permissionCustomMapper.findMenuAndPermissionByUserId(userId);
	}

	@Override
	public Role findRoleById(Short roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
