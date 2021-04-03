package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/user")
public class UserController {
	// public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// 添加用户（包括账号信息和个人信息）
	@RequestMapping("/useradd")
	public String userAdd(CampusUser campusUser, CampusUserInfo campusUserInfo) {
		this.userService.userAdd(campusUser, campusUserInfo);
		return "user/user_list";
	}

	// 获取个人账号信息
	@RequestMapping("/getaccount")
	public String accountEdit(Model model, HttpSession session) {
		// 取出session中的账号信息
		CampusUser campusUser = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);

		model.addAttribute("user", campusUser);

		return "user/account_edit";
	}

	// 编辑账号信息
	@RequestMapping("/accountedit")
	public String accountEdit(CampusUser campusUser) {
		// 清理session
		this.userService.accountEdit(campusUser);
		return "redirect:/getaccount";
	}

	// 查看账号信息
	@RequestMapping("/accountlist")
	public String accountList(CampusUser user, Model model) {
		List<CampusUser> list = this.userService.accountList(user);
		model.addAttribute("users", list);
		return "user/account_list";
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
}
