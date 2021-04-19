package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerService;

public interface VolunteersService {
	/**
	 * 发起志愿活动，保存志愿活动相关信息
	 * 
	 * @param volunteerInfo
	 */
	void sponsor(VolunteerService volunteerInfo);

	/**
	 * 根据查询条件查询志愿活动信息
	 * 
	 * @param volunteerInfo
	 * @return
	 */
	List<VolunteerService> getActivities(VolunteerService volunteerInfo);

	/**
	 * 根据志愿活动id查询该活动的报名情况
	 * 
	 * @param volunteerServiceId
	 * @return
	 */
	List<VolunteerEnroll> findEnrollById(Integer volunteerServiceId);

	/**
	 * 根据条件查询志愿活动报名信息
	 * 
	 * @param enrollInfo
	 * @return
	 */
	List<VolunteerEnroll> findEnrollDetails(VolunteerEnroll enrollInfo);

	/**
	 * 根据志愿活动id查询志愿活动
	 * 
	 * @param volunteerServiceId
	 * @return
	 */
	VolunteerService findActivityById(Integer volunteerServiceId);

}
