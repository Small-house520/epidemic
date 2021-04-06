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

import cn.edu.dgut.epidemic.pojo.CampusAccessRecords;
import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.TemperatureItinerary;
import cn.edu.dgut.epidemic.service.CampusService;
import cn.edu.dgut.epidemic.service.UserService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/campus")
public class CampusController {

	@Autowired
	private UserService userService;

	@Autowired
	private CampusService campusService;

	// 查看出入校园记录
	@RequestMapping("/campusaccess")
	public String campusAccess(Model model) {
		// 获取出入校园记录
		List<CampusAccessRecords> list = this.campusService.campusAccess(null);
		model.addAttribute("accessRecords", list);
		return "campus/campus_access";
	}

	// 查询出入校园记录
	@RequestMapping("/findrecords")
	@ResponseBody
	public Map<String, Object> findRecords(CampusAccessRecords accessRecords, HttpSession session) {
		// 获取出入校园记录
		List<CampusAccessRecords> list = this.campusService.campusAccess(accessRecords);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accessRecords", list);
		return map;
	}

	// 跳转到填报体温行程信息页面
	@RequestMapping("/tohealthupload")
	public String toHealthUpload(Model model, HttpSession session) {
		// 取出session中的账号信息
		CampusUser campusUser = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);

		CampusUserInfo userInfo = this.userService.getUserInfo(campusUser.getCampusId());

		TemperatureItinerary healthInfo = this.campusService.getHealthInfo(campusUser.getCampusId());

		model.addAttribute("userInfo", userInfo);
		if (healthInfo != null) {
			model.addAttribute("healthInfo", healthInfo);
		}

		return "campus/health_upload";
	}

	// 填报体温行程信息
	@RequestMapping("/healthupload")
	public String healthUpload(TemperatureItinerary healthInfo, Model model, HttpSession session) {

		this.campusService.healthUpload(healthInfo);

		// model.addAttribute("", );

		return "redirect:/campus/tohealthupload";
	}

	// 查看体温行程信息
	@RequestMapping("/health")
	public String health(Integer flag, Model model) {
		// 获取用户信息
		List<CampusUserInfo> userInfo = this.userService.userList(null);

		List<TemperatureItinerary> list = this.campusService.temperature(null);
		model.addAttribute("healthInfo", list);
		model.addAttribute("userInfo", userInfo);
		if (flag == 1) {
			return "campus/temperature";
		}
		return "campus/travel";
	}

	// 查询体温行程信息
	@RequestMapping("/healthinfo")
	@ResponseBody
	public Map<String, Object> findHealthInfo(TemperatureItinerary healthInfo, HttpSession session) {
		// 获取用户信息
		List<CampusUserInfo> userInfo = this.userService.userList(null);

		List<TemperatureItinerary> list = this.campusService.temperature(healthInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("healthInfo", list);
		map.put("userInfo", userInfo);
		return map;
	}
}
