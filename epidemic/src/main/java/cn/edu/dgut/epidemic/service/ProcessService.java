package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerService;

public interface ProcessService {
	/**
	 * 保存志愿活动信息
	 * 
	 * @param volunteerService
	 */
	void saveActivity(VolunteerService volunteerService);

	/**
	 * 保存报名信息
	 * 
	 * @param volunteerEnroll
	 */
	void saveEnroll(VolunteerEnroll volunteerEnroll);

	/**
	 * 根据id删除活动信息或报名信息
	 * 
	 * @param id
	 * @param flag
	 */
	void deleteById(Integer id, Integer flag);

	/**
	 * 根据campusId查询出活动信息
	 * 
	 * @param campusId
	 * @return
	 */
	List<VolunteerService> getVolunteersService(Long campusId);

	/**
	 * 根据campusId查询出报名信息
	 * 
	 * @param campusId
	 * @return
	 */
	List<VolunteerEnroll> getVolunteerEnroll(Long campusId);

	/**
	 * 根据活动ID，查询活动信息对象
	 * 
	 * @param id
	 * @return
	 */
	VolunteerService findActivityById(Integer id);

	/**
	 * 使用报名ID，查询报名对象
	 * 
	 * @param id
	 * @return
	 */
	VolunteerEnroll findEnrollById(Integer id);

	// List<BaoxiaoBill> findBaoxiaoBillListByUser(Long userid);

	// List<BaoxiaoBill> findLeaveBillListByUser(Long id);

}
