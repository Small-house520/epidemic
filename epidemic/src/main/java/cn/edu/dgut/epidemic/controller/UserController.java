package cn.edu.dgut.epidemic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.GradeClass;
import cn.edu.dgut.epidemic.pojo.Role;
import cn.edu.dgut.epidemic.service.RoleService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/user")
public class UserController {
	// public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	// 添加账号（账号信息）
	@RequestMapping("/accountadd")
	public String accountAdd(CampusUser campusUser) {
		this.userService.accountAdd(campusUser);
		return "forward:/accountlist";
	}

	// 删除账号（账号信息）
	@RequestMapping("/accountdel")
	public String accountDel(String ids) {
		this.userService.accountDel(ids);
		return "forward:/accountlist";
	}

	// 获取个人账号信息
	@RequestMapping("/getaccount")
	public String accountEdit(Model model, HttpSession session) {
		// 取出session中的账号信息
		CampusUser campusUser = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);
		campusUser = this.userService.findByCampusId(campusUser.getCampusId());

		model.addAttribute("user", campusUser);

		return "user/account_edit";
	}

	// 编辑账号信息
	@RequestMapping("/accountedit")
	public String accountEdit(CampusUser campusUser, HttpSession session) {
		CampusUser user = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);
		// 更新账号信息
		this.userService.accountEdit(campusUser);
		if (user.getCampusId() == campusUser.getCampusId()) {
			return "redirect:/user/getaccount";
		}
		return "redirect:/user/accountlist";
	}

	// 查看账号信息
	@RequestMapping("/accountlist")
	public String accountList(Model model) {
		List<CampusUser> list = this.userService.accountList(null);
		List<Role> roles = this.roleService.findAllRoles();
		model.addAttribute("users", list);
		model.addAttribute("roles", roles);
		return "user/account_list";
	}

	// 查询账号信息
	@RequestMapping("/findAccount")
	@ResponseBody
	public Map<String, Object> findAccount(CampusUser user) {
		List<CampusUser> list = this.userService.accountList(user);
		List<Role> roles = this.roleService.findAllRoles();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", list);
		map.put("roles", roles);
		return map;
	}

	// 跳转到添加用户页面
	@RequestMapping("/touseradd")
	public String toUserAdd(Model model) {
		List<GradeClass> classes= this.userService.findClasses();
		model.addAttribute("classes", classes);
		return "user/user_add";
	}

	// 添加用户（包括账号信息和个人信息）
	@RequestMapping("/useradd")
	public String userAdd(CampusUser campusUser, CampusUserInfo campusUserInfo) {
		this.userService.userAdd(campusUser, campusUserInfo);
		return "user/user_list";
	}

	// 获取个人信息
	@RequestMapping("/getuser")
	public String getUserInfo(Model model, HttpSession session) {
		// 取出session中的账号信息
		CampusUser campusUser = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);

		// 根据编号获取用户信息
		CampusUserInfo userInfo = this.userService.getUserInfo(campusUser.getCampusId());

		model.addAttribute("userinfo", userInfo);

		return "user/user_edit";
	}

	// 编辑个人信息
	@RequestMapping("/useredit")
	public String userEdit(CampusUserInfo userInfo) {
		// 清理session
		this.userService.userEdit(userInfo);
		return "redirect:/getuser";
	}

	// 查看个人信息
	@RequestMapping("/userlist")
	public String userList(CampusUserInfo userInfo, Model model) {
		List<CampusUserInfo> list = this.userService.userList(userInfo);
		model.addAttribute("users", list);
		return "user/user_list";
	}

	@RequestMapping("/idCheack")
	@ResponseBody
	public String idCheack(Long campusId) {
		if (campusId != null && campusId > 0) {
			CampusUser user = this.userService.findByCampusId(campusId);
			if (user != null) {
				return "1";
			}
		}
		return "0";
	}

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
