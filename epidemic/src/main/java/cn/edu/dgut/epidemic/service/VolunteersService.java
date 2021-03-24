package cn.edu.dgut.epidemic.service;

import java.util.List;

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

}
