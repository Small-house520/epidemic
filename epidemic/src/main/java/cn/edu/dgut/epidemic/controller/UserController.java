package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.GradeClass;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.service.RoleService;
import cn.edu.dgut.epidemic.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	// 添加账号（账号信息）
	@RequestMapping("/accountAdd")
	public String accountAdd(CampusUser campusUser) {
		this.userService.accountAdd(campusUser);
		return "forward:/accountList";
	}

	// 删除账号（账号信息）
	@RequestMapping("/accountDel")
	public String accountDel(String ids) {
		this.userService.accountDel(ids);
		return "forward:/accountList";
	}

	// 获取个人账号信息
	@RequestMapping("/getAccount")
	public String accountEdit(Model model, HttpSession session) {
		// 取出session中的账号信息
		// CampusUser campusUser = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		CampusUser campusUser = this.userService.findByCampusId(customUser.getCampusId());

		model.addAttribute("user", campusUser);

		return "user/account_edit";
	}

	// 编辑账号信息
	@RequestMapping("/accountEdit")
	public String accountEdit(CampusUser campusUser, HttpSession session) {
		// CampusUser user = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		// 更新账号信息
		this.userService.accountEdit(campusUser);
		if (customUser.getCampusId() == campusUser.getCampusId()) {
			return "redirect:/user/getAccount";
		}
		return "redirect:/user/accountList";
	}

	// 查看账号信息
	@RequestMapping("/accountList")
	public String accountList(Model model) {
		List<CampusUser> list = this.userService.accountList(null);
		List<Role> roles = this.roleService.findAllRoles();
		model.addAttribute("users", list);
		model.addAttribute("roles", roles);
		model.addAttribute("user", null);
		return "user/account_list";
	}

	// 查询账号信息
	// @RequestMapping("/findAccount")
	// @ResponseBody
	// public Map<String, Object> findAccount(CampusUser user) {
	// List<CampusUser> list = this.userService.accountList(user);
	// List<Role> roles = this.roleService.findAllRoles();
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("users", list);
	// map.put("roles", roles);
	// return map;
	// }
	// 查询账号信息
	@RequestMapping("/findAccount")
	public String findAccount(CampusUser user, Model model) {
		List<CampusUser> list = this.userService.accountList(user);
		List<Role> roles = this.roleService.findAllRoles();
		model.addAttribute("users", list);
		model.addAttribute("roles", roles);
		model.addAttribute("user", user);
		return "user/account_list";
	}

	// 跳转到添加用户页面
	@RequestMapping("/toUserAdd")
	public String toUserAdd(Model model) {
		List<GradeClass> classes = this.userService.findClasses();
		model.addAttribute("classes", classes);
		return "user/user_add";
	}

	// 添加用户（包括账号信息和个人信息）
	@RequestMapping("/userAdd")
	public String userAdd(CampusUser campusUser, CampusUserInfo campusUserInfo) {
		this.userService.userAdd(campusUser, campusUserInfo);
		return "user/user_list";
	}

	// 添加用户（用户个人信息）
	@RequestMapping("/userInfoAdd")
	public String userInfoAdd(CampusUserInfo userInfo) {
		this.userService.userInfoAdd(userInfo);
		return "redirect:/user/userList";
	}

	// 删除个人信息
	@RequestMapping("/userDel")
	public String userDel(String ids) {
		this.userService.userDel(ids);
		return "forward:/accountList";
	}

	// 获取个人信息
	@RequestMapping("/getUser")
	public String getUserInfo(Model model, HttpSession session) {
		// 取出session中的账号信息
		// CampusUser campusUser = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();

		// 根据编号获取用户信息
		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		List<GradeClass> classes = this.userService.findClasses();
		model.addAttribute("classes", classes);

		model.addAttribute("userinfo", userInfo);

		return "user/user_edit";
	}

	// 编辑个人信息
	@RequestMapping("/userEdit")
	public String userEdit(CampusUserInfo userInfo) {
		// 清理session
		this.userService.userEdit(userInfo);
		return "redirect:/user/userList";
	}

	// 查看个人信息
	@RequestMapping("/userList")
	public String userList(CampusUserInfo userInfo, Model model) {
		List<CampusUserInfo> list = this.userService.userList(userInfo);
		model.addAttribute("users", list);

		List<GradeClass> classes = this.userService.findClasses();
		model.addAttribute("classes", classes);
		model.addAttribute("userInfo", userInfo);
		return "user/user_list";
	}

	// 查询个人信息
	// @RequestMapping("/findUsers")
	// @ResponseBody
	// public Map<String, Object> findUsers(CampusUserInfo userInfo) {
	// List<CampusUserInfo> list = this.userService.userList(userInfo);
	// List<GradeClass> classes = this.userService.findClasses();
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("users", list);
	// map.put("classes", classes);
	// return map;
	// }
	// 查询个人信息
	@RequestMapping("/findUsers")
	public String findUsers(CampusUserInfo userInfo, Model model) {
		List<CampusUserInfo> list = this.userService.userList(userInfo);
		List<GradeClass> classes = this.userService.findClasses();
		model.addAttribute("users", list);
		model.addAttribute("classes", classes);
		model.addAttribute("userInfo", userInfo);
		return "user/user_list";
	}

	// 验证账号是否已存在
	@RequestMapping("/idCheack")
	@ResponseBody
	public String idCheack(String campusId) {
		if (campusId != null && !"".equals(campusId)) {
			CampusUser user = this.userService.findByCampusId(campusId);
			if (user != null) {
				return "1";
			}
		}
		return "0";
	}

	// 验证用户名是否已存在
	@RequestMapping("/nameCheack")
	@ResponseBody
	public String nameCheack(String username) {

		if (username != null && !"".equals(username)) {
			CampusUser user = this.userService.findUserByName(username);
			if (user != null) {
				return "2";
			}
		}
		return "0";
	}
}
