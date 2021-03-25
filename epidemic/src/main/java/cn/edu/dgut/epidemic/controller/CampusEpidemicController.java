package cn.edu.dgut.epidemic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.dgut.epidemic.pojo.EpidemicCloseContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisSuspected;
import cn.edu.dgut.epidemic.service.CampusEpidemicService;

@Controller
@RequestMapping("/campusEpidemic")
public class CampusEpidemicController {
	// public static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private CampusEpidemicService campusEpidemicService;

	// 查询校内现有确诊患者信息
	@RequestMapping("/diagnosis")
	public String getDiagnosis(EpidemicDiagnosisSuspected epidemicDiagnosis, Model model, HttpSession session) {

		List<EpidemicDiagnosisSuspected> list = this.campusEpidemicService.getDiagnosis(epidemicDiagnosis);
		model.addAttribute("epidemicDiagnosis", list);
		return "diagnosis";
	}

	// 查询校内密切接触者信息
	@RequestMapping("/contact")
	public String getContact(EpidemicCloseContact epidemicContact, Model model, HttpSession session) {

		List<EpidemicCloseContact> list = this.campusEpidemicService.getContact(epidemicContact);
		model.addAttribute("epidemicContact", list);
		return "close_contact";
	}

	// 查询校内治愈者信息
	@RequestMapping("/cure")
	public String getCure(EpidemicCureDeath epidemicCure, Model model, HttpSession session) {

		List<EpidemicCureDeath> list = this.campusEpidemicService.getCure(epidemicCure);
		model.addAttribute("epidemicCure", list);
		return "cure";
	}

	// 查询校内死亡者信息
	@RequestMapping("/death")
	public String getDeath(EpidemicCureDeath epidemicDeath, Model model, HttpSession session) {

		List<EpidemicCureDeath> list = this.campusEpidemicService.getDeath(epidemicDeath);
		model.addAttribute("epidemicDeath", list);
		return "death";
	}
}
