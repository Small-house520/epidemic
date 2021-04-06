package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
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
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisExample;
import cn.edu.dgut.epidemic.service.CampusEpidemicService;

@Service
@Transactional
public class CampusEpidemicServiceImpl implements CampusEpidemicService {
	@Autowired
	private EpidemicDiagnosisMapper epidemicDiagnosisMapper;

	@Autowired
	private EpidemicContactMapper epidemicContactMapper;

	@Autowired
	private EpidemicCureDeathMapper epidemicCureDeathMapper;

	@Autowired
	private CampusUserInfoMapper userInfoMapper;

	// 查询校内确诊患者信息
	@Override
	public List<EpidemicDiagnosis> getDiagnosis() {
		List<EpidemicDiagnosis> list = new ArrayList<EpidemicDiagnosis>();
		list = this.epidemicDiagnosisMapper.selectByExample(null);
		return list;
	}

	// 根据查询条件查询校内确诊患者信息
	@Override
	public List<EpidemicDiagnosis> findDiagnosis(EpidemicDiagnosis epidemicDiagnosis, String fullName) {
		List<EpidemicDiagnosis> list = new ArrayList<EpidemicDiagnosis>();
		if (epidemicDiagnosis == null && (fullName == null || "".equals(fullName))) {
			list = this.epidemicDiagnosisMapper.selectByExample(null);
			return list;
		}

		EpidemicDiagnosisExample diagnosisExample = new EpidemicDiagnosisExample();
		EpidemicDiagnosisExample.Criteria dCriteria = diagnosisExample.createCriteria();
		List<Long> ids = new ArrayList<Long>();
		// 如果根据姓名查询，则先根据姓名查询出对应id，封装到list
		if (fullName != null && !"".equals(fullName)) {
			CampusUserInfoExample userInfoExample = new CampusUserInfoExample();
			CampusUserInfoExample.Criteria criteria = userInfoExample.createCriteria();
			criteria.andFullNameLike("%" + fullName + "%");
			List<CampusUserInfo> uList = this.userInfoMapper.selectByExample(userInfoExample);
			for (CampusUserInfo userInfo : uList) {
				ids.add(userInfo.getCampusId());
			}
		}
		if (epidemicDiagnosis.getCampusId() != null) {
			dCriteria.andCampusIdEqualTo(epidemicDiagnosis.getCampusId());
		}
		if (epidemicDiagnosis.getWhetherSevere() != null && !"".equals(epidemicDiagnosis.getWhetherSevere())) {
			dCriteria.andWhetherSevereEqualTo(epidemicDiagnosis.getWhetherSevere());
		}
		if (epidemicDiagnosis.getSourceOfInfection() != null && !"".equals(epidemicDiagnosis.getSourceOfInfection())) {
			dCriteria.andSourceOfInfectionLike("%" + epidemicDiagnosis.getSourceOfInfection() + "%");
		}
		if (ids != null && ids.size() > 0) {
			dCriteria.andCampusIdIn(ids);
		}
		list = this.epidemicDiagnosisMapper.selectByExample(null);
		return list;
	}

	// 根据查询条件查询校内密切接触者信息
	@Override
	public List<EpidemicContact> getContact(EpidemicContact epidemicContact) {
		List<EpidemicContact> list = new ArrayList<EpidemicContact>();
		if (epidemicContact == null) {
			list = this.epidemicContactMapper.selectByExample(null);
			return list;
		}

		return list;
	}

	// 查询校内治愈者信息
	@Override
	public List<EpidemicCureDeath> getCure(EpidemicCureDeath epidemicCure) {
		List<EpidemicCureDeath> list = new ArrayList<EpidemicCureDeath>();
		if (epidemicCure == null) {
			list = this.epidemicCureDeathMapper.selectByExample(null);
			return list;
		}

		return list;
	}

	// 查询校内死亡者信息
	@Override
	public List<EpidemicCureDeath> getDeath(EpidemicCureDeath epidemicDeath) {
		List<EpidemicCureDeath> list = new ArrayList<EpidemicCureDeath>();
		if (epidemicDeath == null) {
			list = this.epidemicCureDeathMapper.selectByExample(null);
			return list;
		}

		return list;
	}
}
