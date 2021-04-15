package cn.edu.dgut.epidemic.service.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.dgut.epidemic.mapper.CityEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.CityMapper;
import cn.edu.dgut.epidemic.mapper.DomesticEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicInformationMapper;
import cn.edu.dgut.epidemic.mapper.ProvinceEpidemicMapper;
import cn.edu.dgut.epidemic.mapper.ProvinceMapper;
import cn.edu.dgut.epidemic.pojo.City;
import cn.edu.dgut.epidemic.pojo.CityEpidemic;
import cn.edu.dgut.epidemic.pojo.CityEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.CityEpidemicExample;
import cn.edu.dgut.epidemic.pojo.CityExample;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemic;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemicExample;
import cn.edu.dgut.epidemic.pojo.EpidemicInformation;
import cn.edu.dgut.epidemic.pojo.EpidemicInformationExample;
import cn.edu.dgut.epidemic.pojo.Province;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemic;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicDetail;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicExample;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicExample.Criteria;
import cn.edu.dgut.epidemic.service.EpidemicService;
import cn.edu.dgut.epidemic.util.CrawlEpidemicData;

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

	@Autowired
	private EpidemicInformationMapper epidemicInfoMapper;

	// 获取国内最新疫情数据
	@Override
	public DomesticEpidemic getDomesticEpidemic() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		DomesticEpidemicExample domesticEpidemicExample = new DomesticEpidemicExample();
		// 获取疫情数据总条数
		short total = (short) domesticEpidemicMapper.countByExample(domesticEpidemicExample);
		// 根据最新的ID查询最新的疫情数据，总条数即为最新的疫情数据ID
		DomesticEpidemic domesticEpidemic = this.domesticEpidemicMapper.selectByPrimaryKey(total);

		Date time = null;
		Date updateTime = domesticEpidemic.getUpdateTime();
		Date now = new Date(), now2 = new Date();
		try {
			updateTime = sdfDate.parse(sdfDate.format(updateTime));
			now = sdfDate.parse(sdfDate.format(now));
			now2 = sdfTime.parse(sdfTime.format(now2));
			time = sdfTime.parse("09:00:00");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		// 判断是否更新疫情数据
		// 如果当前疫情数据的更新时间为前一天，且当前时间为早上9点之后，则更新数据
		if (updateTime.before(now) && now2.after(time)) {

			// 更新最新疫情信息数据
			String epidemic = "";
			String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
			String reg = "window.getStatisticsService = (.*?)\\}(?=catch)";
			try {
				epidemic = CrawlEpidemicData.getEpidemic(url, reg);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (epidemic != null && !"".equals(epidemic)) {
				JSONObject jsonObject = JSONObject.parseObject(epidemic);
				try {

					String modifyTime = jsonObject.getString("modifyTime"); // 疫情数据更新时间
					String currentConfirmedCount = jsonObject.getString("currentConfirmedCount");// 现存确诊
					String confirmedCount = jsonObject.getString("confirmedCount");// 累计确诊
					String suspectedCount = jsonObject.getString("suspectedCount");// 境外输入
					String curedCount = jsonObject.getString("curedCount");// 累计治愈
					String deadCount = jsonObject.getString("deadCount");// 累计死亡
					String seriousCount = jsonObject.getString("seriousCount");// 现存无症状

					// 把获取的最新疫情数据封装到DomesticEpidemic
					DomesticEpidemic domesticEpidemic2 = new DomesticEpidemic();
					domesticEpidemic2.setExistingDiagnosis(Integer.parseInt(currentConfirmedCount));
					domesticEpidemic2.setCumulativeDiagnosis(Integer.parseInt(confirmedCount));
					domesticEpidemic2.setOverseasInput(Integer.parseInt(suspectedCount));
					domesticEpidemic2.setExistingAsymptomatic(Integer.parseInt(seriousCount));
					domesticEpidemic2.setCumulativeCure(Integer.parseInt(curedCount));
					domesticEpidemic2.setCumulativeDeath(Integer.parseInt(deadCount));
					Date modifyDate = new Date(Long.valueOf(modifyTime));
					domesticEpidemic2.setUpdateTime(modifyDate);

					// 把DomesticEpidemic同步到数据库
					this.domesticEpidemicMapper.insertSelective(domesticEpidemic2);
					domesticEpidemic = domesticEpidemic2;

					System.out.println("全国疫情数据统计时间：" + sdf.format(modifyDate));
					System.out.println("现存确诊：" + currentConfirmedCount + "，累计确诊：" + confirmedCount + "，境外输入："
							+ suspectedCount + "，累计治愈：" + curedCount + "，累计死亡：" + deadCount + "，现存无症状：" + seriousCount);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 获取最新疫情资讯
			url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
			reg = "window.getTimelineService1 = (.*?)\\}(?=catch)";
			try {
				epidemic = CrawlEpidemicData.getEpidemic(url, reg);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (epidemic != null && !"".equals(epidemic)) {
				JSONArray array = JSONArray.parseArray(epidemic);

				try {
					JSONObject jsonObject = new JSONObject();
					for (int i = 0; i < array.size(); i++) {
						jsonObject = array.getJSONObject(i);
						String pubDate = jsonObject.getString("pubDate"); // 发布时间
						String title = jsonObject.getString("title");// 疫情资讯标题
						String sourceUrl = jsonObject.getString("sourceUrl");// 资讯对应链接

						// 把获取的最新疫情资讯数据封装到EpidemicInformation
						EpidemicInformation epidemicInfo = new EpidemicInformation();
						epidemicInfo.setTitle(title);
						epidemicInfo.setCorrespondingLink(sourceUrl);
						Date modifyDate = new Date(Long.valueOf(pubDate));
						epidemicInfo.setReleaseTime(modifyDate);
						epidemicInfo.setInformationFlag("3");

						// 把DomesticEpidemic同步到数据库
						this.epidemicInfoMapper.insertSelective(epidemicInfo);

						System.out.println("标题：" + title + "，链接：" + sourceUrl + "，发布时间：" + sdf.format(modifyDate));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 获取最新防疫资讯
			url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
			reg = "window.getWikiList  = (.*?)\\}(?=catch)";
			try {
				epidemic = CrawlEpidemicData.getEpidemic(url, reg);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (epidemic != null && !"".equals(epidemic)) {
				JSONObject jsonEpidemic = JSONObject.parseObject(epidemic);
				String result = jsonEpidemic.getString("result");// 疫情资讯
				JSONArray array = JSONArray.parseArray(result);

				try {
					JSONObject jsonObject = new JSONObject();
					for (int i = 0; i < array.size(); i++) {
						jsonObject = array.getJSONObject(i);
						String title = jsonObject.getString("title");// 疫情资讯标题
						String description = jsonObject.getString("description");// 疫情资讯描述
						String linkUrl = jsonObject.getString("linkUrl");// 资讯对应链接

						// 把获取的最新疫情资讯数据封装到EpidemicInformation
						EpidemicInformation epidemicInfo = new EpidemicInformation();
						epidemicInfo.setTitle(title);
						epidemicInfo.setDescription(description);
						epidemicInfo.setCorrespondingLink(linkUrl);
						epidemicInfo.setInformationFlag("2");

						// 把DomesticEpidemic同步到数据库
						this.epidemicInfoMapper.insertSelective(epidemicInfo);

						System.out.println("标题：" + title + "，描述：" + description + "，链接：" + linkUrl);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return domesticEpidemic;
	}

	// 获取一段时间内全国疫情数据
	@Override
	public List<DomesticEpidemic> findDomesticEpidemic() {
		DomesticEpidemicExample domesticEpidemicExample = new DomesticEpidemicExample();
		DomesticEpidemicExample.Criteria criteria = domesticEpidemicExample.createCriteria();
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前日期的前一个月
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date date = new Date();
		try {
			date = sdfDate.parse(sdfDate.format(calendar.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		criteria.andUpdateTimeGreaterThanOrEqualTo(date);
		return this.domesticEpidemicMapper.selectByExample(domesticEpidemicExample);
	}

	// 获取各省份疫情数据
	@Override
	public List<ProvinceEpidemicDetail> getProvinceEpidemicList() {

		// 创建SimpleDateFormat对象实例并定义好转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

		// 获取当前系统时间
		Date date = new Date(), now = new Date(), now2 = new Date();
		// 获取当前时间前一天的时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date time = null;

		try {
			date = sdfDate.parse(sdf.format(calendar.getTime()));
			now = sdfDate.parse(sdfDate.format(now));
			now2 = sdfTime.parse(sdfTime.format(now2));
			time = sdfTime.parse("08:40:40");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 根据时间查询各省份当前最新的疫情数据
		ProvinceEpidemicExample provinceEpidemicExample = new ProvinceEpidemicExample();
		Criteria criteria = provinceEpidemicExample.createCriteria();
		criteria.andUpdateTimeGreaterThanOrEqualTo(now);
		List<ProvinceEpidemic> pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);

		// 查询出各省份信息
		List<Province> provinces = this.provinceMapper.selectByExample(null);
		// 查询出各城市信息
		List<City> cities = this.cityMapper.selectByExample(null);

		// 定义一个省份疫情信息集合
		List<ProvinceEpidemicDetail> list = new ArrayList<ProvinceEpidemicDetail>();

		if (pList == null || pList.size() <= 0) {

			// 判断是否更新疫情数据
			// 如果当前时间为早上9点之后，则更新数据
			if (now2.after(time)) {

				// 更新最新省份及城市疫情信息数据
				String epidemic = "";
				String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
				String reg = "window.getAreaStat = (.*?)\\}(?=catch)";
				try {
					epidemic = CrawlEpidemicData.getEpidemic(url, reg);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (epidemic != null && !"".equals(epidemic)) {
					JSONArray array = JSONArray.parseArray(epidemic);

					try {
						for (int i = 0; i < array.size(); i++) {
							ProvinceEpidemic provinceEpidemic = new ProvinceEpidemic();
							JSONObject jsonObject = array.getJSONObject(i);
							String provinceName = jsonObject.getString("provinceName");// 省份名字

							String current = jsonObject.getString("currentConfirmedCount");// 现有确诊
							String confirmed = jsonObject.getString("confirmedCount");// 累计确诊
							String cured = jsonObject.getString("curedCount");// 累计治愈
							String dead = jsonObject.getString("deadCount");// 累计死亡
							System.out.println(provinceName + "：现存确诊-" + current + "，累计确诊-" + confirmed + "，累计治愈-"
									+ cured + "，累计死亡-" + dead);

							for (int j = 0; j < provinces.size(); j++) {
								if (provinceName.contains(provinces.get(j).getProvinceName())) {
									provinceEpidemic.setProvinceId(provinces.get(j).getProvinceId());
									break;
								}
							}
							provinceEpidemic.setExistingDiagnosis(Integer.parseInt(current));
							provinceEpidemic.setCumulativeDiagnosis(Integer.parseInt(confirmed));
							provinceEpidemic.setCumulativeCure(Integer.parseInt(cured));
							provinceEpidemic.setCumulativeDeath(Integer.parseInt(dead));
							provinceEpidemic.setUpdateTime(new Date());

							this.provinceEpidemicMapper.insertSelective(provinceEpidemic);

							CityEpidemic cityEpidemic = new CityEpidemic();
							JSONArray array2 = jsonObject.getJSONArray("cities");
							for (int j = 0; j < array2.size(); j++) {
								JSONObject jsonObject2 = array2.getJSONObject(j);
								String cityname = jsonObject2.getString("cityName");// 城市名称
								String current2 = jsonObject2.getString("currentConfirmedCount");// 现存确诊
								String confirmed2 = jsonObject2.getString("confirmedCount");// 累计确诊
								String cured2 = jsonObject2.getString("curedCount");// 累计治愈
								String dead2 = jsonObject2.getString("deadCount");// 累计死亡

								for (int k = 0; k < cities.size(); k++) {
									if (cityname.contains(cities.get(k).getCityName())) {
										cityEpidemic.setCityId(cities.get(k).getCityId());
										break;
									}
								}
								cityEpidemic.setExistingDiagnosis(Integer.parseInt(current2));
								cityEpidemic.setCumulativeDiagnosis(Integer.parseInt(confirmed2));
								cityEpidemic.setCumulativeCure(Integer.parseInt(cured2));
								cityEpidemic.setCumulativeDeath(Integer.parseInt(dead2));
								cityEpidemic.setUpdateTime(new Date());

								this.cityEpidemicMapper.insertSelective(cityEpidemic);

								System.out.println(cityname + "：现存确诊-" + current2 + "，累计确诊-" + confirmed2 + "，累计治愈-"
										+ cured2 + "，累计死亡-" + dead2);

							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);
			} else {
				criteria.andUpdateTimeGreaterThanOrEqualTo(date);
				pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);
			}
		}

		// 把查询出来的数据放到集合里
		for (int i = 0; i < provinces.size(); i++) {
			// 要把new ProvinceEpidemicDetail()放到循环里面，ArrayList存储的是对象的引用
			ProvinceEpidemicDetail provinceEpidemicDetail = new ProvinceEpidemicDetail();
			for (int j = 0; j < pList.size(); j++) {
				if (provinces.get(i).getProvinceId() == pList.get(j).getProvinceId()) {
					provinceEpidemicDetail.setProvince(provinces.get(i));
					provinceEpidemicDetail.setProvinceEpidemic(pList.get(j));
					list.add(provinceEpidemicDetail);
					break;
				}
			}

		}

		return list;
	}

	// 根据条件查询各省份疫情数据
	@Override
	public List<ProvinceEpidemicDetail> findProvinceEpidemic() {
		// 创建SimpleDateFormat对象实例并定义好转换格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");

		// 获取当前系统时间
		Date date = new Date(), now = new Date();
		// 获取当前时间前一天的时间
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);

		try {
			date = sdfDate.parse(sdf.format(calendar.getTime()));
			now = sdfDate.parse(sdfDate.format(now));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 根据时间查询各省份当前最新的疫情数据
		ProvinceEpidemicExample provinceEpidemicExample = new ProvinceEpidemicExample();
		Criteria criteria = provinceEpidemicExample.createCriteria();
		criteria.andUpdateTimeGreaterThanOrEqualTo(now);
		List<ProvinceEpidemic> pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);

		// 查询出各省份信息
		List<Province> provinces = this.provinceMapper.selectByExample(null);

		// 定义一个省份疫情信息集合
		List<ProvinceEpidemicDetail> list = new ArrayList<ProvinceEpidemicDetail>();

		if (pList == null || pList.size() <= 0) {
			criteria.andUpdateTimeGreaterThanOrEqualTo(date);
			pList = this.provinceEpidemicMapper.selectByExample(provinceEpidemicExample);
		}
		List<ProvinceEpidemic> pEpidemics = new ArrayList<ProvinceEpidemic>();
		// 遍历出现存确诊最多的10个省份
		for (int i = 0; i < pList.size() - 1; i++) {
			int max = i;
			for (int j = i + 1; j < pList.size(); j++) {
				if (pList.get(max).getExistingDiagnosis() < pList.get(j).getExistingDiagnosis()) {
					max = j;
				}
			}
			pEpidemics.add(pList.get(max));
			if (i == 9) {
				break;
			}
		}
		// 把查询出来的数据放到集合里
		for (int i = 0; i < pEpidemics.size(); i++) {
			// 要把new ProvinceEpidemicDetail()放到循环里面，ArrayList存储的是对象的引用
			ProvinceEpidemicDetail provinceEpidemicDetail = new ProvinceEpidemicDetail();
			for (int j = 0; j < provinces.size(); j++) {
				if (provinces.get(j).getProvinceId() == pEpidemics.get(i).getProvinceId()) {
					provinceEpidemicDetail.setProvince(provinces.get(j));
					provinceEpidemicDetail.setProvinceEpidemic(pEpidemics.get(i));
					list.add(provinceEpidemicDetail);
					break;
				}
			}

		}
		return list;
	}

	// 获取各城市的疫情数据
	@Override
	public List<CityEpidemicDetail> getCityEpidemicList(Short provinceId, Date updateTime) {
		// 创建SimpleDateFormat对象实例并定义好转换格式
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 查询出各城市信息
		CityExample cityExample = new CityExample();
		CityExample.Criteria criteria = cityExample.createCriteria();
		criteria.andProvinceIdEqualTo(provinceId);
		List<City> cities = this.cityMapper.selectByExample(cityExample);
		List<Short> cityIds = new ArrayList<>();
		if (cities != null && cities.size() > 0) {
			for (City city : cities) {
				cityIds.add(city.getCityId());
			}
		}

		if (cityIds != null && cityIds.size() > 0) {
			// 根据时间查询各城市当前最新的疫情数据
			CityEpidemicExample cityEpidemicExample = new CityEpidemicExample();
			CityEpidemicExample.Criteria criteria2 = cityEpidemicExample.createCriteria();
			criteria2.andCityIdIn(cityIds);
			criteria2.andUpdateTimeEqualTo(updateTime);
			List<CityEpidemic> cList = this.cityEpidemicMapper.selectByExample(cityEpidemicExample);

			// 定义一个城市疫情信息集合
			List<CityEpidemicDetail> list = new ArrayList<CityEpidemicDetail>();

			// 把查询出来的数据放到集合里
			for (int i = 0; i < cities.size(); i++) {
				CityEpidemicDetail cityEpidemicDetail = new CityEpidemicDetail();
				for (int j = 0; j < cList.size(); j++) {
					if (cities.get(i).getCityId() == cList.get(j).getCityId()) {
						cityEpidemicDetail.setCity(cities.get(i));
						cityEpidemicDetail.setCityEpidemic(cList.get(j));
						list.add(cityEpidemicDetail);
						break;
					}
				}

			}

			return list;
		}
		return null;
	}

	// 获取相关资讯
	@Override
	public List<EpidemicInformation> getEpidemicInformation(String flag) {
		EpidemicInformationExample informationExample = new EpidemicInformationExample();
		EpidemicInformationExample.Criteria criteria = informationExample.createCriteria();
		criteria.andInformationFlagEqualTo(flag);
		return this.epidemicInfoMapper.selectByExample(informationExample);
	}

}
