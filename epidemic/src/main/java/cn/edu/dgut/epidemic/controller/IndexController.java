package cn.edu.dgut.epidemic.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CustomUser;

@Controller
public class IndexController {

	// @Autowired
	// private UserService userService;

	// @RequestMapping("/index")
	// public String toIndex() {
	// return "index";
	// }

	// @RequestMapping("/login")
	// public String toLogin() {
	// return "login";
	// }

	// 用户登录
	// @RequestMapping("/loginCheck")
	// public String login(CampusUser campusUser, Model model, HttpSession session)
	// {
	// // 输出账号密码日志
	// // logger.debug("login()方法 account=" + userInfo.getAccount() + ",password:" +
	// // userInfo.getPassword());
	//
	// // 通过业务逻辑层的bean获取该账号对应的用户信息
	// CampusUser user = this.userService.findByCampusId(campusUser.getCampusId());
	// if (user == null) {
	// // 账号不正确
	// model.addAttribute("msg", "账号或密码不正确！");
	// return "login";
	// }
	// if (user.getUserPassword().equals(campusUser.getUserPassword())) {
	// // 登录成功
	// // 将当前用户的信息保存到Session中
	// session.setAttribute(Constants.GLOBLE_USER_SESSION, user);
	// // 重定向到后台首页
	// return "redirect:/home";
	// }
	// // 登录失败
	// model.addAttribute("msg", "账号或密码不正确！");
	// return "login";
	// }

	// 用户登录，使用Shiro编写用户认证逻辑
	@RequestMapping("/loginCheck")
	public String login(String campusId, String userPassword, Model model) {
		// 1、获取subject
		Subject subject = SecurityUtils.getSubject();
		// 2、封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(campusId, userPassword);
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		try {
			// 3、执行登录方法
			subject.login(token);
			System.out.println("认证通过");
			// 登录成功,跳转到主页
			return "redirect:/home";
		} catch (UnknownAccountException e) {
			// e.printStackTrace();
			// 登录失败,用户名不正确
			model.addAttribute("msg", "账号不正确");
			// 跳转到登录页面
			return "login";
		} catch (IncorrectCredentialsException e) {
			// 登录失败,密码错误
			model.addAttribute("msg", "密码错误");
			// 跳转到登录页面
			return "login";
		}
	}

	@RequestMapping("/home")
	public String toHome(Model model, HttpSession session) {
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		// CampusUser user = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		// user = this.userService.findByCampusId(user.getCampusId());
		model.addAttribute("user", customUser);
		return "home";
	}

	// 退出登录
	// @RequestMapping("/logout")
	// public String logout(HttpSession session) {
	// // 清理session
	// session.invalidate();
	// return "redirect:/index";
	// }
}
