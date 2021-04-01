package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.service.ProcessService;
import cn.edu.dgut.epidemic.util.Constants;

@Controller
@RequestMapping("/process")
public class ProcessController {

	@Autowired
	private ProcessService processService;

	// 根据id删除活动信息或报名信息
	@RequestMapping("/deletebyid")
	public String deleteById(Integer id, Integer flag, Model model) {
		this.processService.deleteById(id, flag);

		model.addAttribute("flag", flag);
		return "redirect:/myprocess";
	}

	// 查询活动信息或报名信息
	@RequestMapping("/myprocess")
	public String getProcesses(Integer flag, Model model, HttpSession session) {
		CampusUser user = (CampusUser) session.getAttribute(Constants.GLOBLE_USER_SESSION);
		if (flag == 1) {
			// 根据campusId查询出活动信息
			List<VolunteerService> list = this.processService.getVolunteersService(user.getCampusId());
			// 把查询出的数据设置到model
			model.addAttribute("activities", list);

			return "transaction/activity_list";
		}
		// 根据campusId查询出报名信息
		List<VolunteerEnroll> list = this.processService.getVolunteerEnroll(user.getCampusId());
		// 把查询出的数据设置到model
		model.addAttribute("leavebills", list);

		return "transaction/enroll_list";
	}

}
