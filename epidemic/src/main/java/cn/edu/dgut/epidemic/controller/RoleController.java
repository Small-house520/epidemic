package cn.edu.dgut.epidemic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.pojo.TreeMenu;
import cn.edu.dgut.epidemic.service.RoleService;
import cn.edu.dgut.epidemic.service.UserService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	// 跳转到添加角色页面
	@RequestMapping("/toAddRole")
	public ModelAndView toAddRole() {
		// 获取树形菜单
		List<TreeMenu> allPermissions = this.roleService.loadTreeMenu();
		// 获取菜单
		List<Permission> menus = this.roleService.findAllMenus();
		// 获取角色和权限关系
		// List<Role> permissionList = this.roleService.findRolesAndPermissions();

		ModelAndView mv = new ModelAndView();
		mv.addObject("allPermissions", allPermissions);
		mv.addObject("menuTypes", menus);
		// mv.addObject("roleAndPermissionsList", permissionList);
		mv.setViewName("permission/permission_add");

		return mv;
	}

	// 给角色分配权限
	@RequestMapping("/assignRole")
	@ResponseBody
	public Map<String, String> assignRole(String campusId, Short roleId) {
		Map<String, String> map = new HashMap<>();
		try {
			// 更新用户角色关系
			this.userService.updateUserRole(campusId, roleId);
			map.put("msg", "角色权限更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "角色权限更新失败");
		}
		return map;
	}

	// 添加角色和角色权限关系
	@RequestMapping("/saveRoleAndPermissions")
	public String saveRoleAndPermissions(Role role, int[] permissionIds) {
		short id = this.roleService.findLastId();
		// 设置role主键，查询出最后一条记录的id，然后加一
		id = (short) (id + 1);
		role.setRoleId(id);

		// // 设置role主键，使用uuid
		// String uuid = UUID.randomUUID().toString();
		// role.setId(uuid);

		// 添加角色和角色权限关系
		this.roleService.addRoleAndPermissions(role, permissionIds);

		return "redirect:/role/toAddRole";
	}

	// 添加权限
	@RequestMapping("/savePermission")
	public String savePermission(Permission permission) {
		this.roleService.addPermission(permission);
		return "redirect:/role/toAddRole";
	}

	// 查询所有角色及其权限关系
	@RequestMapping("/findRoles")
	public ModelAndView findRoles() {
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		// 查询出所有角色信息
		List<Role> roles = this.roleService.findAllRoles();
		// 查询所有菜单和权限信息
		List<TreeMenu> allMenuAndPermissions = this.roleService.getAllMenuAndPermision();

		ModelAndView mv = new ModelAndView();
		mv.addObject("allRoles", roles);
		mv.addObject("customUser", customUser);
		mv.addObject("allMenuAndPermissions", allMenuAndPermissions);

		mv.setViewName("permission/permission_list");
		return mv;
	}

	// 加载我的权限列表
	@RequestMapping("/loadMyPermissions")
	@ResponseBody
	public List<Permission> loadMyPermissions(Short roleId) {
		// 根据角色id查询权限信息
		List<Permission> list = this.roleService.findPermissionsByRoleId(roleId);

		return list;
	}

	// 更新角色和权限关系
	@RequestMapping("/updateRoleAndPermission")
	public String updateRoleAndPermission(Short roleId, int[] permissionIds) {
		this.roleService.updateRoleAndPermissions(roleId, permissionIds);
		return "redirect:/role/findRoles";
	}

	// 根据账号（编号）查询角色和权限关系
	@RequestMapping("/viewPermissionById")
	@ResponseBody
	public Role viewPermissionById(String id) {
		Role role = this.roleService.findRolesAndPermissionsById(id);

		return role;
	}

	// 删除角色
	@RequestMapping("/roledel")
	public String roledel(Short id) {
		this.roleService.deleteRole(id);
		return "redirect:/role/findRoles";
	}
}
