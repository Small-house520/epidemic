package cn.edu.dgut.epidemic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.dgut.epidemic.mapper.EpidemicContactMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicCureDeathMapper;
import cn.edu.dgut.epidemic.mapper.EpidemicDiagnosisMapper;
import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;
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

	// 根据查询条件查询校内确诊患者信息
	@Override
	public List<EpidemicDiagnosis> getDiagnosis(EpidemicDiagnosis epidemicDiagnosis) {
		List<EpidemicDiagnosis> list = new ArrayList<EpidemicDiagnosis>();
		if (epidemicDiagnosis == null) {
			list = this.epidemicDiagnosisMapper.selectByExample(null);
			return list;
		}

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
