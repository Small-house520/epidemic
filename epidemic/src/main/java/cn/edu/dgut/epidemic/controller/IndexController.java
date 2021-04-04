package cn.edu.dgut.epidemic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/home")
public class IndexController {

	@Autowired
	private UserService userService;

	// @RequestMapping("/index")
	// public String toIndex() {
	// return "index";
	// }

	// @RequestMapping("/login")
	// public String toLogin() {
	// return "login";
	// }

	// 用户登录
	@RequestMapping("/loginCheck")
	public String login(CampusUser campusUser, Model model, HttpSession session) {
		// 输出账号密码日志
		// logger.debug("login()方法 account=" + userInfo.getAccount() + ",password:" +
		// userInfo.getPassword());

		// 通过业务逻辑层的bean获取该账号对应的用户信息
		CampusUser user = this.userService.findByCampusId(campusUser.getCampusId());
		if (user == null) {
			// 账号不正确
			model.addAttribute("msg", "账号或密码不正确！");
			return "login";
		}
		if (user.getUserPassword().equals(campusUser.getUserPassword())) {
			// 登录成功
			// 将当前用户的信息保存到Session中
			session.setAttribute(Constants.GLOBLE_USER_SESSION, user);
			// 重定向到后台首页
			return "redirect:/home/home";
		}
		// 登录失败
		model.addAttribute("msg", "账号或密码不正确！");
		return "login";
	}

	@RequestMapping("/home")
	public String toHome(Model model, HttpSession session) {
		CampusUser user = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);
		user = this.userService.findByCampusId(user.getCampusId());
		model.addAttribute("user", user);
		return "home";
	}

	// 退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 清理session
		session.invalidate();
		return "redirect:/home/index";
	}
}
