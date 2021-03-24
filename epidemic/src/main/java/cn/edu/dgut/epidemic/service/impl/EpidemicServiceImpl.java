package cn.edu.dgut.epidemic.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.dgut.epidemic.mapper.CityEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.CityMapper;
import cn.edu.dgut.epidemic.mapper.DomesticEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.ProvinceEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.ProvinceMapper;
import cn.edu.dgut.epidemic.pojo.City;
import cn.edu.dgut.epidemic.pojo.CityEpidemic;
import cn.edu.dgut.epidemic.pojo.CityEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.CityEpidemicExample;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemic;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemicExample;
import cn.edu.dgut.epidemic.pojo.Province;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemic;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicExample;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicExample.Criteria;
import cn.edu.dgut.epidemic.service.EpidemicService;

@Service
public class EpidemicServiceImpl implements EpidemicService {

	@Autowired
	private DomesticEpidemicMapper domesticEpidemicMapper;

	@Autowired
	private ProvinceMapper provinceMapper;

	@Autowired
	private ProvinceEpidemicMapper provinceEpidemicMapper;

	@Autowired
	private CityEpidemicMapper cityEpidemicMapper;

	@Autowired
	private CityMapper cityMapper;

	// 获取国内最新疫情数据
	@Override
	public DomesticEpidemic getDomesticEpidemic() {
		DomesticEpidemicExample domesticEpidemicExample = new DomesticEpidemicExample();
		// 获取疫情数据总条数
		short total = (short) domesticEpidemicMapper.countByExample(domesticEpidemicExample);
		// 根据最新的ID查询最新的疫情数据，总条数即为最新的疫情数据ID
		DomesticEpidemic domesticEpidemic = this.domesticEpidemicMapper.selectByPrimaryKey(total);
		return domesticEpidemic;
	}

	// 获取各省份疫情数据
	@Override
	public List<ProvinceEpidemicDetail> getProvinceEpidemicList() {
		// 创建SimpleDateFormat对象实例并定义好转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null, date2 = null;
		try {
			// 获取当前系统时间
			date1 = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 获取当前时间前一天的时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		try {
			date2 = sdf.parse(sdf.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 根据时间查询各省份当前最新的疫情数据
		ProvinceEpidemicExample provinceEpidemicExample = new ProvinceEpidemicExample();
		Criteria criteria = provinceEpidemicExample.createCriteria();
		criteria.andUpdateTimeBetween(date2, date1);
		List<ProvinceEpidemic> pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);

		// 查询出各省份信息
		List<Province> provinces = this.provinceMapper.selectByExample(null);

		// 定义一个省份疫情信息集合
		List<ProvinceEpidemicDetail> list = new ArrayList<ProvinceEpidemicDetail>();
		ProvinceEpidemicDetail provinceEpidemicDetail = new ProvinceEpidemicDetail();
		// 把查询出来的数据放到集合里
		for (int i = 0; i < provinces.size(); i++) {
			for (int j = 0; j < pList.size(); j++) {
				if (provinces.get(i).getProvinceId() == pList.get(j).getProvinceId()) {
					provinceEpidemicDetail.setProvinceName(provinces.get(i).getProvinceName());
					provinceEpidemicDetail.setProvinceEpidemic(pList.get(j));
					list.add(provinceEpidemicDetail);
					break;
				}
			}

		}

		return list;
	}

	// 获取各城市的疫情数据
	@Override
	public List<CityEpidemicDetail> getCityEpidemicList() {
		// 创建SimpleDateFormat对象实例并定义好转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null, date2 = null;
		try {
			// 获取当前系统时间
			date1 = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 获取当前时间前一天的时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		try {
			date2 = sdf.parse(sdf.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 根据时间查询各城市当前最新的疫情数据
		CityEpidemicExample cityEpidemicExample = new CityEpidemicExample();
		CityEpidemicExample.Criteria criteria = cityEpidemicExample.createCriteria();
		criteria.andUpdateTimeBetween(date2, date1);
		List<CityEpidemic> cList = this.cityEpidemicMapper.selectByExample(cityEpidemicExample);

		// 查询出各城市信息
		List<City> cities = this.cityMapper.selectByExample(null);

		// 定义一个城市疫情信息集合
		List<CityEpidemicDetail> list = new ArrayList<CityEpidemicDetail>();
		CityEpidemicDetail cityEpidemicDetail = new CityEpidemicDetail();
		// 把查询出来的数据放到集合里
		for (int i = 0; i < cities.size(); i++) {
			for (int j = 0; j < cList.size(); j++) {
				if (cities.get(i).getCityId() == cList.get(j).getCityId()) {
					cityEpidemicDetail.setCityName(cities.get(i).getCityName());
					cityEpidemicDetail.setCityEpidemic(cList.get(j));
					list.add(cityEpidemicDetail);
					break;
				}
			}

		}

		return list;
	}
}
