package cn.edu.dgut.epidemic.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.CampusAccessRecordsMapper;
import cn.edu.dgut.epidemic.mapper.TemperatureItineraryMapper;
import cn.edu.dgut.epidemic.pojo.CampusAccessRecords;
import cn.edu.dgut.epidemic.pojo.CampusAccessRecordsExample;
import cn.edu.dgut.epidemic.pojo.TemperatureItinerary;
import cn.edu.dgut.epidemic.pojo.TemperatureItineraryExample;
import cn.edu.dgut.epidemic.service.CampusService;

@Service
@Transactional
public class CampusServiceImpl implements CampusService {
	@Autowired
	private CampusAccessRecordsMapper accessRecordsMapper;

	@Autowired
	private TemperatureItineraryMapper healthMapper;

	// 根据查询条件查询出入学校记录信息
	@Override
	public List<CampusAccessRecords> campusAccess(CampusAccessRecords accessRecords) {

		List<CampusAccessRecords> list = new ArrayList<CampusAccessRecords>();
		if (accessRecords == null) {
			list = this.accessRecordsMapper.selectByExample(null);
			return list;
		}

		CampusAccessRecordsExample accessRecordsExample = new CampusAccessRecordsExample();
		CampusAccessRecordsExample.Criteria criteria = accessRecordsExample.createCriteria();
		if (accessRecords.getFullName() != null && !"".equals(accessRecords.getFullName())) {
			criteria.andFullNameLike("%" + accessRecords.getFullName() + "%");
		}
		if (accessRecords.getState() != null && !"".equals(accessRecords.getState())) {
			criteria.andStateEqualTo(accessRecords.getState());
		}
		if (accessRecords.getRecordDate() != null) {
			criteria.andRecordDateGreaterThanOrEqualTo(accessRecords.getRecordDate());
		}
		list = this.accessRecordsMapper.selectByExample(accessRecordsExample);

		return list;
	}

	// 根据编号查询用户体温行程信息
	@Override
	public TemperatureItinerary getHealthInfo(Long campusId) {
		// 创建SimpleDateFormat对象实例并定义好转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TemperatureItineraryExample healthExample = new TemperatureItineraryExample();
		TemperatureItineraryExample.Criteria criteria = healthExample.createCriteria();
		criteria.andCampusIdEqualTo(campusId);
		// 获取当前时间前一天的时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		try {
			criteria.andUploadDateGreaterThan(sdf.parse(sdf.format(calendar.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<TemperatureItinerary> list = this.healthMapper.selectByExample(healthExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 保存填报上来的体温行程信息
	@Override
	public void healthUpload(TemperatureItinerary healthInfo) {
		healthInfo.setUploadDate(new Date());
		this.healthMapper.insertSelective(healthInfo);
	}

	// 根据查询条件查询体温行程信息
	@Override
	public List<TemperatureItinerary> temperature(TemperatureItinerary healthInfo) {

		List<TemperatureItinerary> list = new ArrayList<TemperatureItinerary>();
		if (healthInfo == null) {
			list = this.healthMapper.selectByExample(null);
			return list;
		}

		TemperatureItineraryExample healthInfoExample = new TemperatureItineraryExample();
		TemperatureItineraryExample.Criteria criteria = healthInfoExample.createCriteria();
		if (healthInfo.getCampusId() != null && healthInfo.getCampusId() > 0) {
			criteria.andCampusIdEqualTo(healthInfo.getCampusId());
		}
		if (healthInfo.getTemperature() != null) {
			criteria.andTemperatureGreaterThanOrEqualTo(healthInfo.getTemperature());
		}
		if (healthInfo.getUploadDate() != null) {
			criteria.andUploadDateGreaterThanOrEqualTo(healthInfo.getUploadDate());
		}
		if (healthInfo.getReturnedToSchool() != null && !"".equals(healthInfo.getReturnedToSchool())) {
			criteria.andReturnedToSchoolEqualTo(healthInfo.getReturnedToSchool());
		}
		list = this.healthMapper.selectByExample(healthInfoExample);
		return list;
	}
}
