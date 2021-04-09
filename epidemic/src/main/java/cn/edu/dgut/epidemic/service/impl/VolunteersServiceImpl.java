package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.VolunteerServiceMapper;
import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.pojo.VolunteerServiceExample;
import cn.edu.dgut.epidemic.service.VolunteersService;

@Service
@Transactional
public class VolunteersServiceImpl implements VolunteersService {

	@Autowired
	private VolunteerServiceMapper volunteerMapper;

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

}
