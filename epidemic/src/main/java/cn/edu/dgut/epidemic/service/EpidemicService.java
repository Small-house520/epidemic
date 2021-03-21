package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.CityEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemic;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicDetail;

public interface EpidemicService {
	/**
	 * 获取国内最新疫情数据
	 *
	 * @return
	 */
	DomesticEpidemic getDomesticEpidemic();
	
	/**
	 * 获取各省份疫情数据
	 * @return
	 */
	List<ProvinceEpidemicDetail> getProvinceEpidemicList();
	
	/**
	 * 获取各城市的疫情数据
	 * @return
	 */
	List<CityEpidemicDetail> getCityEpidemicList();
}
