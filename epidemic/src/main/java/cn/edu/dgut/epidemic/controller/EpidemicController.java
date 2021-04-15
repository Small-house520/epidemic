package cn.edu.dgut.epidemic.controller;

import cn.edu.dgut.epidemic.pojo.*;
import cn.edu.dgut.epidemic.service.EpidemicService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/epidemicData")
public class EpidemicController {

	@Autowired
	private EpidemicService epidemicService;

	// 调用getDomesticEpidemic()，查询国内最新的疫情数据
	@RequestMapping("/domesticEpidemic")
	@ResponseBody
	public DomesticEpidemic getDomesticEpidemic() {
		DomesticEpidemic domesticEpidemic = this.epidemicService.getDomesticEpidemic();
		return domesticEpidemic;
	}

	// 调用getProvinceEpidemic()，查询各省份疫情数据
	@RequestMapping("/provinceEpidemic")
	@ResponseBody
	public List<ProvinceEpidemicDetail> getProvinceEpidemicList() {
		List<ProvinceEpidemicDetail> list = this.epidemicService.getProvinceEpidemicList();
		return list;
	}

	// 调用getCityEpidemicList()，查询各城市的疫情数据
	@RequestMapping("/cityEpidemic")
	@ResponseBody
	public List<CityEpidemicDetail> getCityEpidemicList(Short provinceId, Date updateTime) {
		List<CityEpidemicDetail> list = this.epidemicService.getCityEpidemicList(provinceId, updateTime);
		return list;
	}

	// 调用getEpidemicInformation()，获取疫情相关资讯
	@RequestMapping("/epidemicInfo")
	@ResponseBody
	public List<EpidemicInformation> getEpidemicInformation(String flag) {
		List<EpidemicInformation> list = this.epidemicService.getEpidemicInformation(flag);
		return list;
	}

}
