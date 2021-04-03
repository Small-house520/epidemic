package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.service.VolunteersService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
	// public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private VolunteersService volunteersService;

	// 跳转到发起志愿活动页面
	@RequestMapping("/tostart")
	public String toStart(Model model, HttpSession session) {
		// 取出session中的账号信息
		CampusUser campusUser = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);

		CampusUserInfo userInfo = this.userService.getUserInfo(campusUser.getCampusId());

		model.addAttribute("userInfo", userInfo);

		return "volunteer/start_activities";
	}

	// 发起志愿活动
	@RequestMapping("/sponsor")
	public String sponsor(VolunteerService volunteerInfo, Model model, HttpSession session) {

		this.volunteersService.sponsor(volunteerInfo);

		// model.addAttribute("", );

		return "redirect:/tostart";
	}

	// 查看志愿活动信息
	@RequestMapping("/activities")
	public String getActivities(VolunteerService volunteerInfo, Model model) {
		List<VolunteerService> list = this.volunteersService.getActivities(volunteerInfo);
		model.addAttribute("volunteerInfo", list);
		return "volunteer/volunteer_activities";
	}
}
