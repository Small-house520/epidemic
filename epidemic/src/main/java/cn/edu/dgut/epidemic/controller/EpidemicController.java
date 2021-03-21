package cn.edu.dgut.epidemic.controller;

import cn.edu.dgut.epidemic.pojo.*;
import cn.edu.dgut.epidemic.service.EpidemicService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {
	// private Logger logger = Logger.getLogger(EpidemicController.class);

	@Autowired
	private EpidemicService epidemicService;

	// 调用getDomesticEpidemic()，查询国内最新的疫情数据
	@GetMapping("/ajax/domesticEpidemic")
	@ResponseBody
	public DomesticEpidemic getDomesticEpidemic() {
		DomesticEpidemic domesticEpidemic = this.epidemicService.getDomesticEpidemic();
		return domesticEpidemic;
	}

	// 调用getProvinceEpidemic()，查询各省份疫情数据
	@GetMapping("/ajax/provinceEpidemic")
	@ResponseBody
	public List<ProvinceEpidemicDetail> getProvinceEpidemicList() {
		List<ProvinceEpidemicDetail> list = this.epidemicService.getProvinceEpidemicList();
		return list;
	}

	// 调用getCityEpidemicList()，查询各城市的疫情数据
	@GetMapping("/ajax/cityEpidemic")
	@ResponseBody
	public List<CityEpidemicDetail> getCityEpidemicList() {
		List<CityEpidemicDetail> list = this.epidemicService.getCityEpidemicList();
		return list;
	}

}
