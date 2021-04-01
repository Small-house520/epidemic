package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	// public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private CampusService campusService;

	// 查询出入校园记录
	@RequestMapping("/campusaccess")
	public String campusAccess(CampusAccessRecords accessRecords, Model model) {
		List<CampusAccessRecords> list = this.campusService.campusAccess(accessRecords);
		model.addAttribute("accessRecords", list);
		return "campus/campus_access";
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

		return "redirect:/tohealthupload";
	}

	// 查看体温信息
	@RequestMapping("/health")
	public String temperature(TemperatureItinerary healthInfo, Integer flag, Model model) {
		List<TemperatureItinerary> list = this.campusService.temperature(healthInfo);
		model.addAttribute("healthInfo", list);
		if (flag == 1) {
			return "campus/temperature";
		}
		return "campus/travel";
	}
}
