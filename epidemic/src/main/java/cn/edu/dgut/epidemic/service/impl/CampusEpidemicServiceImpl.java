package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.CampusUserInfoMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicContactMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicCureDeathMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicDiagnosisMapper;
import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CampusUserInfoExample;
import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicContactExample;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeathExample;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisExample;
import cn.edu.dgut.epidemic.service.CampusEpidemicService;

@Service
@Transactional
public class CampusEpidemicServiceImpl implements CampusEpidemicService {
	@Autowired
	private EpidemicDiagnosisMapper diagnosisMapper;

	@Autowired
	private EpidemicContactMapper contactMapper;

	@Autowired
	private EpidemicCureDeathMapper cureDeathMapper;

	@Autowired
	private CampusUserInfoMapper userInfoMapper;

	// 查询校内确诊患者信息
	@Override
	public List<EpidemicDiagnosis> getDiagnosis() {
		List<EpidemicDiagnosis> list = new ArrayList<EpidemicDiagnosis>();
		EpidemicDiagnosisExample diagnosisExample = new EpidemicDiagnosisExample();
		EpidemicDiagnosisExample.Criteria criteria = diagnosisExample.createCriteria();
		criteria.andFlagEqualTo("1");
		list = this.diagnosisMapper.selectByExample(diagnosisExample);
		return list;
	}

	// 根据查询条件查询校内确诊患者信息
	@Override
	public List<EpidemicDiagnosis> findDiagnosis(EpidemicDiagnosis epidemicDiagnosis, String fullName) {
		List<EpidemicDiagnosis> list = new ArrayList<EpidemicDiagnosis>();
		// if ((epidemicDiagnosis == null
		// || ((epidemicDiagnosis.getCampusId() == null ||
		// "".equals(epidemicDiagnosis.getCampusId().trim()))
		// && (epidemicDiagnosis.getWhetherSevere() == null
		// || "".equals(epidemicDiagnosis.getWhetherSevere().trim()))
		// && (epidemicDiagnosis.getSourceOfInfection() == null
		// || "".equals(epidemicDiagnosis.getSourceOfInfection().trim())))
		// && (fullName == null || "".equals(fullName.trim())))) {
		// list = this.diagnosisMapper.selectByExample(null);
		// return list;
		// }

		EpidemicDiagnosisExample diagnosisExample = new EpidemicDiagnosisExample();
		EpidemicDiagnosisExample.Criteria dCriteria = diagnosisExample.createCriteria();
		List<String> ids = new ArrayList<String>();
		// 如果根据姓名查询，则先根据姓名查询出对应id，封装到list
		if (fullName != null && !"".equals(fullName.trim())) {
			CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
			CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
			criteria.andFullNameLike("%" + fullName.trim() + "%");
			List<CampusUserInfo> uList = this.userInfoMapper.selectByExample(userInfoExample);
			for (CampusUserInfo userInfo : uList) {
				ids.add(userInfo.getCampusId());
			}
			if (ids != null && ids.size() > 0) {
				dCriteria.andCampusIdIn(ids);
			} else {
				ids.add("n");
				dCriteria.andCampusIdIn(ids);
			}
		}
		if (epidemicDiagnosis.getCampusId() != null && !"".equals(epidemicDiagnosis.getCampusId().trim())) {
			dCriteria.andCampusIdEqualTo(epidemicDiagnosis.getCampusId());
		}
		if (epidemicDiagnosis.getWhetherSevere() != null && !"".equals(epidemicDiagnosis.getWhetherSevere().trim())) {
			dCriteria.andWhetherSevereEqualTo(epidemicDiagnosis.getWhetherSevere().trim());
		}
		dCriteria.andFlagEqualTo("1");

		list = this.diagnosisMapper.selectByExample(diagnosisExample);
		return list;
	}

	// 新增确诊患者信息
	@Override
	public void diagnosesAdd(EpidemicDiagnosis diagnosis, String flag) {
		diagnosis.setFlag("1");
		this.diagnosisMapper.insertSelective(diagnosis);

		if (flag != null && "3".equals(flag)) {
			EpidemicContact epidemicContact = new EpidemicContact();
			EpidemicContactExample contactExample = new EpidemicContactExample();
			EpidemicContactExample.Criteria criteria = contactExample.createCriteria();
			criteria.andCampusIdEqualTo(diagnosis.getCampusId());
			epidemicContact.setFlag("3");

			this.contactMapper.updateByExampleSelective(epidemicContact, contactExample);
		}
	}

	// 查询校内密切接触者信息
	@Override
	public List<EpidemicContact> getContact() {
		List<EpidemicContact> list = new ArrayList<EpidemicContact>();
		EpidemicContactExample contactExample = new EpidemicContactExample();
		EpidemicContactExample.Criteria criteria = contactExample.createCriteria();
		criteria.andFlagEqualTo("1");
		list = this.contactMapper.selectByExample(contactExample);

		return list;
	}

	// 根据查询条件查询校内密切接触者信息
	@Override
	public List<EpidemicContact> findContact(EpidemicContact epidemicContact, String fullName) {
		List<EpidemicContact> list = new ArrayList<EpidemicContact>();
		// if (epidemicContact == null
		// || ((epidemicContact.getCampusId() == null ||
		// "".equals(epidemicContact.getCampusId().trim()))
		// && (epidemicContact.getContactSource() == null
		// || "".equals(epidemicContact.getContactSource().trim()))
		// && (epidemicContact.getIsolationTime() == null)
		// && (fullName == null || "".equals(fullName.trim())))) {
		// list = this.contactMapper.selectByExample(null);
		// return list;
		// }

		EpidemicContactExample contactExample = new EpidemicContactExample();
		EpidemicContactExample.Criteria cCriteria = contactExample.createCriteria();
		List<String> ids = new ArrayList<String>();
		// 如果根据姓名查询，则先根据姓名查询出对应id，封装到list
		if (fullName != null && !"".equals(fullName.trim())) {
			CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
			CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
			criteria.andFullNameLike("%" + fullName.trim() + "%");
			List<CampusUserInfo> uList = this.userInfoMapper.selectByExample(userInfoExample);
			if (uList != null && uList.size() > 0) {
				for (CampusUserInfo userInfo : uList) {
					ids.add(userInfo.getCampusId());
				}
			}
			if (ids.size() <= 0) {
				cCriteria.andCampusIdEqualTo("1");
			} else {
				cCriteria.andCampusIdIn(ids);
			}
		}
		if (epidemicContact.getCampusId() != null && !"".equals(epidemicContact.getCampusId().trim())) {
			cCriteria.andCampusIdEqualTo(epidemicContact.getCampusId());
		}
		if (epidemicContact.getIsolationTime() != null) {
			cCriteria.andIsolationTimeGreaterThanOrEqualTo(epidemicContact.getIsolationTime());
		}
		if (epidemicContact.getContactSource() != null && !"".equals(epidemicContact.getContactSource().trim())) {
			cCriteria.andContactSourceLike("%" + epidemicContact.getContactSource().trim() + "%");
		}
		cCriteria.andFlagEqualTo("1");

		list = this.contactMapper.selectByExample(contactExample);
		return list;
	}

	// 新增密切接触者信息
	@Override
	public void contactAdd(EpidemicContact epidemicContact) {
		epidemicContact.setFlag("1");
		this.contactMapper.insertSelective(epidemicContact);
	}

	// 查看校内治愈者信息或死亡者信息
	@Override
	public List<EpidemicCureDeath> getCureDeath(Integer flag) {
		EpidemicCureDeathExample cureDeathExample = new EpidemicCureDeathExample();
		EpidemicCureDeathExample.Criteria criteria = cureDeathExample.createCriteria();
		if (flag == 1) {
			criteria.andStateEqualTo("c");
		} else if (flag == 2) {
			criteria.andStateEqualTo("d");
		}
		return this.cureDeathMapper.selectByExample(cureDeathExample);
	}

	// 根据查询条件查询校内治愈者信息或死亡者信息
	@Override
	public List<EpidemicCureDeath> findCureDeath(EpidemicCureDeath cureDeath, String fullName, Integer flag) {
		List<EpidemicCureDeath> list = new ArrayList<EpidemicCureDeath>();
		// if (cureDeath == null || ((cureDeath.getCampusId() == null ||
		// "".equals(cureDeath.getCampusId().trim()))
		// && (cureDeath.getTimeOfCure() == null) && (cureDeath.getTimeOfDeath() ==
		// null)
		// && (fullName == null || "".equals(fullName.trim())))) {
		// list = this.cureDeathMapper.selectByExample(null);
		// return list;
		// }
		if (flag == 1) {
			cureDeath.setState("c");
		} else if (flag == 2) {
			cureDeath.setState("d");
		}
		EpidemicCureDeathExample cureDeathExample = new EpidemicCureDeathExample();
		EpidemicCureDeathExample.Criteria cCriteria = cureDeathExample.createCriteria();
		List<String> ids = new ArrayList<String>();
		// 如果根据姓名查询，则先根据姓名查询出对应id，封装到list
		if (fullName != null && !"".equals(fullName.trim())) {
			CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
			CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
			criteria.andFullNameLike("%" + fullName.trim() + "%");
			List<CampusUserInfo> uList = this.userInfoMapper.selectByExample(userInfoExample);
			if (uList != null && uList.size() > 0) {
				for (CampusUserInfo userInfo : uList) {
					ids.add(userInfo.getCampusId());
				}
			}
			if (ids.size() <= 0) {
				cCriteria.andCampusIdEqualTo("1");
			} else {
				cCriteria.andCampusIdIn(ids);
			}
		}
		if (cureDeath.getCampusId() != null && !"".equals(cureDeath.getCampusId().trim())) {
			cCriteria.andCampusIdEqualTo(cureDeath.getCampusId());
		}
		if (cureDeath.getTimeOfCure() != null) {
			cCriteria.andTimeOfCureGreaterThanOrEqualTo(cureDeath.getTimeOfCure());
		}
		if (cureDeath.getTimeOfDeath() != null) {
			cCriteria.andTimeOfDeathGreaterThanOrEqualTo(cureDeath.getTimeOfDeath());
		}
		if (cureDeath.getState() != null && !"".equals(cureDeath.getState().trim())) {
			cCriteria.andStateEqualTo(cureDeath.getState());
		}

		list = this.cureDeathMapper.selectByExample(cureDeathExample);
		return list;
	}

	// 新增治愈或死亡者信息
	@Override
	public void cureDeathAdd(EpidemicCureDeath cureDeath) {
		if (cureDeath == null) {
			return;
		}
		if (cureDeath.getState() != null) {
			EpidemicDiagnosisExample cureDeathExample = new EpidemicDiagnosisExample();
			EpidemicDiagnosisExample.Criteria criteria = cureDeathExample.createCriteria();
			criteria.andCampusIdEqualTo(cureDeath.getCampusId());
			EpidemicDiagnosis diagnosis = new EpidemicDiagnosis();
			if (cureDeath.getState().equals("c")) {
				diagnosis.setFlag("2");
				cureDeath.setTimeOfCure(new Date());
			} else {
				diagnosis.setFlag("3");
				cureDeath.setTimeOfDeath(new Date());
			}
			this.diagnosisMapper.updateByExampleSelective(diagnosis, cureDeathExample);
		}
		this.cureDeathMapper.insertSelective(cureDeath);
	}

	// 隔离完成
	@Override
	public void isolateFinish(String campusId) {
		EpidemicContact epidemicContact = new EpidemicContact();
		EpidemicContactExample contactExample = new EpidemicContactExample();
		EpidemicContactExample.Criteria criteria = contactExample.createCriteria();
		criteria.andCampusIdEqualTo(campusId);
		epidemicContact.setFlag("2");

		this.contactMapper.updateByExampleSelective(epidemicContact, contactExample);
	}

}
