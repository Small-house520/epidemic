package cn.edu.dgut.epidemic.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.Permission;
import cn.edu.dgut.epidemic.pojo.TreeMenu;
import cn.edu.dgut.epidemic.service.RoleService;
import cn.edu.dgut.epidemic.service.UserService;

/**
 * 自定义Realm，进行认证与授权
 */
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// System.out.println("正在认证用户.....");
		// 加这一步的目的是在post请求时会先进入认证然后再到请求。
		if (token.getPrincipal() == null) {
			return null;
		}
		// 从token获取用户输入的帐号
		String username = token.getPrincipal().toString();

		// 根据用户名到数据库查询用户信息
		CampusUser user = this.userService.findUserByName(username);
		// 如果用户不存在，直接返回null
		if (user == null) {
			return null; // UnknownAccountException
		}
		// 否则获取用户对应的菜单信息
		List<TreeMenu> treeMenus = this.roleService.loadTreeMenu();

		// 把用户的身份信息重新封装
		CustomUser customUser = new CustomUser();
		customUser.setUserId(user.getUserId());
		customUser.setCampusId(user.getCampusId());
		customUser.setUsername(user.getUsername());
		customUser.setUserPassword(user.getUserPassword());
		customUser.setRoleId(user.getRoleId());
		customUser.setTreeMenus(treeMenus);
		// 数据库中的密码,密文
		String password_db = user.getUserPassword();
		// System.out.println(password_db);
		// 数据库中的盐
		// String salt = user.getSalt();
		// System.out.println(salt);

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(customUser, password_db, "CustomRealm");
		return info;
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// 获取用户相关信息
		CustomUser customUser = (CustomUser) principal.getPrimaryPrincipal();
		// 查询数据库认证用户拥有的角色和权限
		List<Permission> permissions = null;
		try {
			permissions = this.roleService.findPermissionListByUserId(customUser.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 用String类型的list集合存放角色和权限信息
		List<String> permisionList = new ArrayList<>();
		for (Permission permission : permissions) {
			permisionList.add(permission.getPermissionCode());
		}

		// 返回授权信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permisionList);

		return info;
	}

}
