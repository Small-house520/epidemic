package cn.edu.dgut.epidemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		List<String> ids = new ArrayList<String>();
		for (EpidemicDiagnosis diagnosis : list) {
			ids.add(diagnosis.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("diagnoses", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("fullName", null);
		model.addAttribute("epidemicDiagnosis", null);
		return "epidemic/diagnosis";
	}

	// 查询校内现有确诊患者信息
	// @RequestMapping("/findDiagnosis")
	// @ResponseBody
	// public Map<String, Object> findDiagnosis(EpidemicDiagnosis epidemicDiagnosis,
	// String fullName) {
	// // 根据查询条件获取确诊患者信息
	// List<EpidemicDiagnosis> list =
	// this.campusEpidemicService.findDiagnosis(epidemicDiagnosis, fullName);
	//
	// List<String> ids = new ArrayList<String>();
	// for (EpidemicDiagnosis diagnosis : list) {
	// ids.add(diagnosis.getCampusId());
	// }
	// List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("diagnoses", list);
	// map.put("userInfo", userInfos);
	// return map;
	// }
	@RequestMapping("/findDiagnosis")
	public String findDiagnosis(EpidemicDiagnosis epidemicDiagnosis, String fullName, Model model) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicDiagnosis> list = this.campusEpidemicService.findDiagnosis(epidemicDiagnosis, fullName);

		List<String> ids = new ArrayList<String>();
		for (EpidemicDiagnosis diagnosis : list) {
			ids.add(diagnosis.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("diagnoses", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("fullName", fullName);
		model.addAttribute("epidemicDiagnosis", epidemicDiagnosis);
		return "epidemic/diagnosis";
	}

	// 新增确诊患者信息
	@RequestMapping("/diagnosesAdd")
	public String diagnosesAdd(EpidemicDiagnosis diagnosis, String flag) {
		this.campusEpidemicService.diagnosesAdd(diagnosis, flag);
		return "redirect:/campusEpidemic/diagnosis";
	}

	// 查看校内密切接触者信息
	@RequestMapping("/contact")
	public String getContact(Model model) {
		// 获取密切接触者信息
		List<EpidemicContact> list = this.campusEpidemicService.getContact();
		// 根据id获取密切接触者个人信息
		List<String> ids = new ArrayList<String>();
		for (EpidemicContact contact : list) {
			ids.add(contact.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("epidemicContact", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("contact", null);
		model.addAttribute("fullName", null);
		return "epidemic/close_contact";
	}

	// 查询校内密切接触者信息
	// @RequestMapping("/findContact")
	// @ResponseBody
	// public Map<String, Object> findContact(EpidemicContact epidemicContact,
	// String fullName) {
	// // 根据查询条件获取确诊患者信息
	// List<EpidemicContact> list =
	// this.campusEpidemicService.findContact(epidemicContact, fullName);
	// // 根据id获取密切接触者个人信息
	// List<String> ids = new ArrayList<String>();
	// for (EpidemicContact contact : list) {
	// ids.add(contact.getCampusId());
	// }
	// List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("epidemicContact", list);
	// map.put("userInfo", userInfos);
	// return map;
	// }
	@RequestMapping("/findContact")
	public String findContact(EpidemicContact epidemicContact, String fullName, Model model) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicContact> list = this.campusEpidemicService.findContact(epidemicContact, fullName);
		// 根据id获取密切接触者个人信息
		List<String> ids = new ArrayList<String>();
		for (EpidemicContact contact : list) {
			ids.add(contact.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("epidemicContact", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("contact", epidemicContact);
		model.addAttribute("fullName", fullName);
		return "epidemic/close_contact";
	}

	// 新增密切接触者信息
	@RequestMapping("/contactAdd")
	public String contactAdd(EpidemicContact epidemicContact) {
		this.campusEpidemicService.contactAdd(epidemicContact);
		return "redirect:/campusEpidemic/contact";
	}

	// 隔离完成
	@RequestMapping("/isolateFinish")
	public String isolateFinish(String campusId) {
		this.campusEpidemicService.isolateFinish(campusId);
		return "redirect:/campusEpidemic/contact";
	}

	// 新增治愈信息
	@RequestMapping("/cureAdd")
	public String cureAdd(EpidemicCureDeath cureDeath) {
		this.campusEpidemicService.cureDeathAdd(cureDeath);
		return "redirect:/campusEpidemic/cureOrDeath?flag=1";
	}

	// 新增死亡信息
	@RequestMapping("/deathAdd")
	public String deathAdd(EpidemicCureDeath cureDeath) {
		this.campusEpidemicService.cureDeathAdd(cureDeath);
		return "redirect:/campusEpidemic/cureOrDeath?flag=2";
	}

	// 查看校内治愈者信息或死亡者信息
	@RequestMapping("/cureOrDeath")
	public String getCureDeath(Integer flag, Model model) {
		List<EpidemicCureDeath> list = this.campusEpidemicService.getCureDeath(flag);
		// 根据id获取密切接触者个人信息
		List<String> ids = new ArrayList<String>();
		for (EpidemicCureDeath cureDeath : list) {
			ids.add(cureDeath.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);

		model.addAttribute("cureDeath", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("cureDeathInfo", null);
		model.addAttribute("fullName", null);
		if (flag == 1) {
			return "epidemic/cure";
		}
		return "epidemic/death";
	}

	// 查询校内治愈者信息或死亡者信息
	// @RequestMapping("/findCureDeath")
	// @ResponseBody
	// public Map<String, Object> findCureDeath(EpidemicCureDeath cureDeath, String
	// fullName, Integer flag) {
	// // 根据查询条件获取确诊患者信息
	// List<EpidemicCureDeath> list =
	// this.campusEpidemicService.findCureDeath(cureDeath, fullName, flag);
	//
	// List<String> ids = new ArrayList<String>();
	// for (EpidemicCureDeath cureDeath2 : list) {
	// ids.add(cureDeath2.getCampusId());
	// }
	// List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("cureDeath", list);
	// map.put("userInfo", userInfos);
	// return map;
	// }
	@RequestMapping("/findCureDeath")
	public String findCureDeath(EpidemicCureDeath cureDeath, String fullName, Integer flag, Model model) {
		// 根据查询条件获取确诊患者信息
		List<EpidemicCureDeath> list = this.campusEpidemicService.findCureDeath(cureDeath, fullName, flag);

		List<String> ids = new ArrayList<String>();
		for (EpidemicCureDeath cureDeath2 : list) {
			ids.add(cureDeath2.getCampusId());
		}
		List<CampusUserInfo> userInfos = this.userService.findUserByIds(ids);
		model.addAttribute("cureDeath", list);
		model.addAttribute("userInfo", userInfos);
		model.addAttribute("cureDeathInfo", cureDeath);
		model.addAttribute("fullName", fullName);
		if (flag == 1) {
			return "epidemic/cure";
		}
		return "epidemic/death";
	}

}
