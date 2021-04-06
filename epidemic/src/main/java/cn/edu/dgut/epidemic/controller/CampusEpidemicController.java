package cn.edu.dgut.epidemic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

	// 查询校内密切接触者信息
	@RequestMapping("/contact")
	public String getContact(EpidemicContact epidemicContact, Model model, HttpSession session) {

		List<EpidemicContact> list = this.campusEpidemicService.getContact(epidemicContact);
		model.addAttribute("epidemicContact", list);
		return "epidemic/close_contact";
	}

	// 查询校内治愈者信息
	@RequestMapping("/cure")
	public String getCure(EpidemicCureDeath epidemicCure, Model model, HttpSession session) {

		List<EpidemicCureDeath> list = this.campusEpidemicService.getCure(epidemicCure);
		model.addAttribute("epidemicCure", list);
		return "epidemic/cure";
	}

	// 查询校内死亡者信息
	@RequestMapping("/death")
	public String getDeath(EpidemicCureDeath epidemicDeath, Model model, HttpSession session) {

		List<EpidemicCureDeath> list = this.campusEpidemicService.getDeath(epidemicDeath);
		model.addAttribute("epidemicDeath", list);
		return "epidemic/death";
	}
}
