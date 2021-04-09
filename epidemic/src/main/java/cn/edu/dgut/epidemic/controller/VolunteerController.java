package cn.edu.dgut.epidemic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.service.VolunteersService;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {

	@Autowired
	private UserService userService;

	@Autowired
	private VolunteersService volunteersService;

	// 跳转到发起志愿活动页面
	@RequestMapping("/tostart")
	public String toStart(Model model, HttpSession session) {
		// 取出session中的账号信息
		// CampusUser campusUser = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();

		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		model.addAttribute("userInfo", userInfo);

		return "volunteer/start_activities";
	}

	// 发起志愿活动
	@RequestMapping("/sponsor")
	public String sponsor(VolunteerService volunteerInfo) {

		this.volunteersService.sponsor(volunteerInfo);

		return "redirect:/tostart";
	}

	// 查看志愿活动信息
	@RequestMapping("/activities")
	public String getActivities(Model model) {
		List<VolunteerService> list = this.volunteersService.getActivities(null);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		for (VolunteerService volunteerService : list) {
			ids.add(volunteerService.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("volunteerInfo", list);
		return "volunteer/volunteer_activities";
	}

	// 根据条件查询志愿活动信息
	@RequestMapping("/findActivities")
	@ResponseBody
	public Map<String, Object> findActivities(VolunteerService volunteerInfo) {
		List<VolunteerService> list = this.volunteersService.getActivities(volunteerInfo);
		// 根据id获取活动发起者个人信息
		List<String> ids = new ArrayList<String>();
		for (VolunteerService volunteerService : list) {
			ids.add(volunteerService.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfo", userInfos);
		map.put("volunteerInfo", list);
		return map;
	}
}
