package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CampusAccessRecords;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CustomUser;
import cn.edu.dgut.epidemic.pojo.TemperatureItinerary;
import cn.edu.dgut.epidemic.service.CampusService;
import cn.edu.dgut.epidemic.service.UserService;

@Controller
@RequestMapping("/campus")
public class CampusController {

	@Autowired
	private UserService userService;

	@Autowired
	private CampusService campusService;

	// 查看出入校园记录
	@RequestMapping("/campusAccess")
	public String campusAccess(Model model) {
		// 获取出入校园记录
		List<CampusAccessRecords> list = this.campusService.campusAccess(null);
		model.addAttribute("accessRecords", list);
		model.addAttribute("health", null);
		return "campus/campus_access";
	}

	// 查询出入校园记录
	// @RequestMapping("/findRecords")
	// @ResponseBody
	// public Map<String, Object> findRecords(CampusAccessRecords accessRecords) {
	// // 获取出入校园记录
	// List<CampusAccessRecords> list =
	// this.campusService.campusAccess(accessRecords);
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("accessRecords", list);
	// return map;
	// }
	@RequestMapping("/findRecords")
	public String findRecords(CampusAccessRecords accessRecords, Model model) {
		// 获取出入校园记录
		List<CampusAccessRecords> list = this.campusService.campusAccess(accessRecords);

		model.addAttribute("accessRecords", list);
		model.addAttribute("health", accessRecords);
		return "campus/campus_access";
	}

	// 跳转到填报体温行程信息页面
	@RequestMapping("/toHealthUpload")
	public String toHealthUpload(Model model, HttpSession session) {
		// 取出session中的账号信息
		// CampusUser campusUser = (CampusUser)
		// session.getAttribute(Constants.GLOBLE_USER_SESSION);
		CustomUser customUser = (CustomUser) SecurityUtils.getSubject().getPrincipal();
		CampusUserInfo userInfo = this.userService.getUserInfo(customUser.getCampusId());

		TemperatureItinerary healthInfo = this.campusService.getHealthInfo(customUser.getCampusId());

		model.addAttribute("userInfo", userInfo);
		if (healthInfo != null) {
			model.addAttribute("healthInfo", healthInfo);
		}

		return "campus/health_upload";
	}

	// 填报体温行程信息
	@RequestMapping("/healthUpload")
	public String healthUpload(TemperatureItinerary healthInfo) {

		this.campusService.healthUpload(healthInfo);

		return "redirect:/campus/toHealthUpload";
	}

	// 查看体温行程信息
	@RequestMapping("/health")
	public String health(Integer flag, Model model) {
		// 获取用户信息
		List<CampusUserInfo> userInfo = this.userService.userList(null);

		List<TemperatureItinerary> list = this.campusService.temperature(null);
		model.addAttribute("healthInfo", list);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("health", null);
		model.addAttribute("flag", flag);
		if (flag == 1) {
			return "campus/temperature";
		}
		return "campus/travel";
	}

	// 查询体温行程信息
	// @RequestMapping("/healthInfo")
	// @ResponseBody
	// public Map<String, Object> findHealthInfo(TemperatureItinerary healthInfo) {
	// // 获取用户信息
	// List<CampusUserInfo> userInfo = this.userService.userList(null);
	//
	// List<TemperatureItinerary> list = this.campusService.temperature(healthInfo);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("healthInfo", list);
	// map.put("userInfo", userInfo);
	// return map;
	// }

	// 查询体温行程信息
	@RequestMapping("/healthInfo")
	public String findHealthInfo(TemperatureItinerary healthInfo, Integer flag, Model model) {
		// 获取用户信息
		List<CampusUserInfo> userInfo = this.userService.userList(null);

		List<TemperatureItinerary> list = this.campusService.temperature(healthInfo);
		model.addAttribute("healthInfo", list);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("health", healthInfo);
		model.addAttribute("flag", flag);
		if (flag == 1) {
			return "campus/temperature";
		}
		return "campus/travel";
	}
}
