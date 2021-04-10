package cn.edu.dgut.epidemic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.dgut.epidemic.mapper.VolunteerEnrollMapper;
import cn.edu.dgut.epidemic.mapper.VolunteerServiceMapper;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerEnrollExample;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.pojo.VolunteerServiceExample;
import cn.edu.dgut.epidemic.service.ProcessService;

@Service
public class ProcesslServiceImpl implements ProcessService {

	@Autowired
	private VolunteerServiceMapper volunteerServiceMapper;

	@Autowired
	private VolunteerEnrollMapper volunteerEnrollMapper;

	// 保存活动信息
	@Override
	public void saveActivity(VolunteerService volunteerService) {
		this.volunteerServiceMapper.insertSelective(volunteerService);
	}

	// 保存报名信息
	@Override
	public void saveEnroll(VolunteerEnroll volunteerEnroll) {
		this.volunteerEnrollMapper.insertSelective(volunteerEnroll);
	}

	// 根据id删除活动信息或报名信息
	@Override
	public void deleteById(Integer id, Integer flag) {
		if (flag == 1) {
			this.volunteerServiceMapper.deleteByPrimaryKey(id);
		}
		this.volunteerEnrollMapper.deleteByPrimaryKey(id);
	}

	// 根据campusId查询出活动信息
	@Override
	public List<VolunteerService> getVolunteersService(String campusId) {
		VolunteerServiceExample example = new VolunteerServiceExample();
		VolunteerServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCampusIdEqualTo(campusId);
		return this.volunteerServiceMapper.selectByExample(example);
	}

	// 根据campusId查询出报名信息
	@Override
	public List<VolunteerEnroll> getVolunteerEnroll(String campusId) {
		VolunteerEnrollExample example = new VolunteerEnrollExample();
		VolunteerEnrollExample.Criteria criteria = example.createCriteria();
		criteria.andCampusIdEqualTo(campusId);
		return this.volunteerEnrollMapper.selectByExample(example);
	}

	// 根据id查询活动信息
	@Override
	public VolunteerService findActivityById(Integer id) {
		return this.volunteerServiceMapper.selectByPrimaryKey(id);
	}

	// 根据id查询出报名信息
	@Override
	public VolunteerEnroll findEnrollById(Integer id) {
		return volunteerEnrollMapper.selectByPrimaryKey(id);
	}

	// 根据id查询志愿活动信息
	@Override
	public List<VolunteerService> findActivityByIds(List<Integer> ids) {
		VolunteerServiceExample volunteerServiceExample = new VolunteerServiceExample();
		VolunteerServiceExample.Criteria criteria = volunteerServiceExample.createCriteria();
		if (ids != null && ids.size() > 0) {
			criteria.andVolunteerServiceIdIn(ids);
			return this.volunteerServiceMapper.selectByExample(volunteerServiceExample);
		}

		return null;
	}

}
