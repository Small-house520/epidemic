package cn.edu.dgut.epidemic.service;

import java.util.Date;
import java.util.List;

import cn.edu.dgut.epidemic.pojo.CityEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemic;
import cn.edu.dgut.epidemic.pojo.EpidemicInformation;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicDetail;

public interface EpidemicService {
	/**
	 * 获取国内最新疫情数据
	 *
	 * @return
	 */
	DomesticEpidemic getDomesticEpidemic();

	/**
	 * 获取一段时间内全国疫情数据
	 * 
	 * @return
	 */
	List<DomesticEpidemic> findDomesticEpidemic();

	/**
	 * 获取各省份疫情数据
	 * 
	 * @return
	 */
	List<ProvinceEpidemicDetail> getProvinceEpidemicList();

	/**
	 * 根据条件查询省份疫情数据
	 * 
	 * @return
	 */
	List<ProvinceEpidemicDetail> findProvinceEpidemic();

	/**
	 * 获取各城市的疫情数据
	 * 
	 * @param provinceId
	 * @param updateTime
	 * @return
	 */
	List<CityEpidemicDetail> getCityEpidemicList(Short provinceId, Date updateTime);

	/**
	 * 获取疫情相关资讯
	 * 
	 * @param flag
	 * @return
	 */
	List<EpidemicInformation> getEpidemicInformation(String flag);

}
