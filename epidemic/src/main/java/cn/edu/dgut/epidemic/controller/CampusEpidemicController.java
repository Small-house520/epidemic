package cn.edu.dgut.epidemic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;
import cn.edu.dgut.epidemic.service.CampusEpidemicService;
import cn.edu.dgut.epidemic.service.UserService;

@Controller
@RequestMapping("/campusEpidemic")
public class CampusEpidemicController {

	@Autowired
	private CampusEpidemicService campusEpidemicService;

	@Autowired
	private UserService userService;

	// 查看校内现有确诊患者信息
	@RequestMapping("/diagnosis")
	public String getDiagnosis(Model model) {
		// 获取确诊患者信息
		List<EpidemicDiagnosis> list = this.campusEpidemicService.getDiagnosis();
		// 根据id获取患者个人信息
		List<Long> ids = new ArrayList<Long>();
		for (EpidemicDiagnosis diagnosis : list) {
			ids.add(diagnosis.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("diagnoses", list);
		model.addAttribute("userInfo", userInfos);
		return "epidemic/diagnosis";
	}

	// 查询校内现有确诊患者信息
	@RequestMapping("/findDiagnosis")
	@ResponseBody
	public Map<String, Object> findDiagnosis(EpidemicDiagnosis epidemicDiagnosis, String fullName) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicDiagnosis> list = this.campusEpidemicService.findDiagnosis(epidemicDiagnosis, fullName);

		List<Long> ids = new ArrayList<Long>();
		for (EpidemicDiagnosis diagnosis : list) {
			ids.add(diagnosis.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("diagnoses", list);
		map.put("userInfo", userInfos);
		return map;
	}

	// 新增确诊患者信息
	@RequestMapping("/diagnosesAdd")
	public String diagnosesAdd(EpidemicDiagnosis diagnosis) {
		this.campusEpidemicService.diagnosesAdd(diagnosis);
		return "redirect:/campusEpidemic/diagnosis";
	}

	// 查看校内密切接触者信息
	@RequestMapping("/contact")
	public String getContact(Model model) {
		// 获取密切接触者信息
		List<EpidemicContact> list = this.campusEpidemicService.getContact();
		// 根据id获取密切接触者个人信息
		List<Long> ids = new ArrayList<Long>();
		for (EpidemicContact contact : list) {
			ids.add(contact.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("epidemicContact", list);
		model.addAttribute("userInfo", userInfos);
		return "epidemic/close_contact";
	}

	// 查询校内密切接触者信息
	@RequestMapping("/findContact")
	@ResponseBody
	public Map<String, Object> findContact(EpidemicContact epidemicContact, String fullName) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicContact> list = this.campusEpidemicService.findContact(epidemicContact, fullName);
		// 根据id获取密切接触者个人信息
		List<Long> ids = new ArrayList<Long>();
		for (EpidemicContact contact : list) {
			ids.add(contact.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("epidemicContact", list);
		map.put("userInfo", userInfos);
		return map;
	}

	// 新增密切接触者信息
	@RequestMapping("/contactAdd")
	public String contactAdd(EpidemicContact epidemicContact) {
		this.campusEpidemicService.contactAdd(epidemicContact);
		return "redirect:/campusEpidemic/contact";
	}

	// 查看校内治愈者信息或死亡者信息
	@RequestMapping("/cureOrDeath")
	public String getCureDeath(Integer flag, Model model) {
		List<EpidemicCureDeath> list = this.campusEpidemicService.getCureDeath(flag);
		// 根据id获取密切接触者个人信息
		List<Long> ids = new ArrayList<Long>();
		for (EpidemicCureDeath cureDeath : list) {
			ids.add(cureDeath.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);

		model.addAttribute("cureDeath", list);
		model.addAttribute("userInfo", userInfos);
		if (flag == 1) {
			return "epidemic/cure";
		}
		return "epidemic/death";
	}

	// 查询校内治愈者信息或死亡者信息
	@RequestMapping("/findCureDeath")
	@ResponseBody
	public Map<String, Object> findCureDeath(EpidemicCureDeath cureDeath, String fullName, Integer flag) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicCureDeath> list = this.campusEpidemicService.findCureDeath(cureDeath, fullName, flag);

		List<Long> ids = new ArrayList<Long>();
		for (EpidemicCureDeath cureDeath2 : list) {
			ids.add(cureDeath2.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cureDeath", list);
		map.put("userInfo", userInfos);
		return map;
	}

}
