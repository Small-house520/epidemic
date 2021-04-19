package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.VolunteerEnrollMapper;
import cn.edu.dgut.epidemic.mapper.VolunteerServiceMapper;
import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerEnrollExample;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.pojo.VolunteerServiceExample;
import cn.edu.dgut.epidemic.service.VolunteersService;

@Service
@Transactional
public class VolunteersServiceImpl implements VolunteersService {

	@Autowired
	private VolunteerServiceMapper volunteerMapper;
	@Autowired
	private VolunteerEnrollMapper enrollMapper;

	// 发起志愿活动，保存志愿活动相关信息
	@Override
	public void sponsor(VolunteerService volunteerInfo) {
		this.volunteerMapper.insertSelective(volunteerInfo);
	}

	// 根据查询条件查询志愿活动信息
	@Override
	public List<VolunteerService> getActivities(VolunteerService volunteerInfo) {
		List<VolunteerService> list = new ArrayList<VolunteerService>();
		if (volunteerInfo == null) {
			list = this.volunteerMapper.selectByExample(null);
			return list;
		}

		VolunteerServiceExample volunteerExample = new VolunteerServiceExample();
		VolunteerServiceExample.Criteria criteria = volunteerExample.createCriteria();
		if (volunteerInfo.getTitle() != null && !"".equals(volunteerInfo.getTitle())) {
			criteria.andTitleLike("%" + volunteerInfo.getTitle() + "%");
		}
		if (volunteerInfo.getStartTime() != null) {
			criteria.andStartTimeGreaterThanOrEqualTo(volunteerInfo.getStartTime());
		}
		if (volunteerInfo.getEndTime() != null) {
			criteria.andEndTimeLessThanOrEqualTo(volunteerInfo.getEndTime());
		}
		list = this.volunteerMapper.selectByExample(volunteerExample);
		return list;
	}

	// 根据志愿活动id查询该活动的报名情况
	@Override
	public List<VolunteerEnroll> findEnrollById(Integer volunteerServiceId) {
		VolunteerEnrollExample volunteerEnrollExample = new VolunteerEnrollExample();
		VolunteerEnrollExample.Criteria criteria = volunteerEnrollExample.createCriteria();
		criteria.andVolunteerServiceIdEqualTo(volunteerServiceId);
		return this.enrollMapper.selectByExample(volunteerEnrollExample);
	}

	// 根据条件查询志愿活动报名信息
	@Override
	public List<VolunteerEnroll> findEnrollDetails(VolunteerEnroll enrollInfo) {
		VolunteerEnrollExample volunteerEnrollExample = new VolunteerEnrollExample();
		VolunteerEnrollExample.Criteria criteria = volunteerEnrollExample.createCriteria();
		if (enrollInfo != null) {
			if (enrollInfo.getCampusId() != null && !"".equals(enrollInfo.getCampusId().trim())) {
				criteria.andCampusIdEqualTo(enrollInfo.getCampusId());
			}
			if (enrollInfo.getIsQualified() != null && !"".equals(enrollInfo.getIsQualified())) {
				criteria.andIsQualifiedEqualTo(enrollInfo.getIsQualified());
			}
			if (enrollInfo.getEnrollTime() != null) {
				criteria.andEnrollTimeGreaterThanOrEqualTo(enrollInfo.getEnrollTime());
			}
			if (enrollInfo.getVolunteerServiceId() != null && enrollInfo.getVolunteerServiceId() > 0) {
				criteria.andVolunteerServiceIdEqualTo(enrollInfo.getVolunteerServiceId());
			}
			return this.enrollMapper.selectByExample(volunteerEnrollExample);
		}

		return null;
	}

	// 根据志愿活动id查询志愿活动
	@Override
	public VolunteerService findActivityById(Integer volunteerServiceId) {
		return this.volunteerMapper.selectByPrimaryKey(volunteerServiceId);
	}

}
