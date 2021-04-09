package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.CampusAccessRecords;
import cn.edu.dgut.epidemic.pojo.TemperatureItinerary;

public interface CampusService {
	/**
	 * 根据查询条件查询出入学校记录信息
	 * 
	 * @param accessRecords
	 * @return
	 */
	List<CampusAccessRecords> campusAccess(CampusAccessRecords accessRecords);

	/**
	 * 根据编号查询用户体温行程信息
	 * 
	 * @param campusId
	 * @return
	 */
	TemperatureItinerary getHealthInfo(String campusId);

	/**
	 * 保存填报上来的体温行程信息
	 * 
	 * @param healthInfo
	 */
	void healthUpload(TemperatureItinerary healthInfo);

	/**
	 * 根据查询条件查询体温信息
	 * 
	 * @param healthInfo
	 * @return
	 */
	List<TemperatureItinerary> temperature(TemperatureItinerary healthInfo);
}
