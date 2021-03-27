package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;

public interface CampusEpidemicService {
	/**
	 * 根据查询条件查询校内确诊患者信息
	 * 
	 * @param epidemicDiagnosis
	 * @return
	 */
	List<EpidemicDiagnosis> getDiagnosis(EpidemicDiagnosis epidemicDiagnosis);

	/**
	 * 根据查询条件查询校内密切接触者信息
	 * 
	 * @param epidemicContact
	 * @return
	 */
	List<EpidemicContact> getContact(EpidemicContact epidemicContact);

	/**
	 * 查询校内治愈者信息
	 * 
	 * @param epidemicCure
	 * @return
	 */
	List<EpidemicCureDeath> getCure(EpidemicCureDeath epidemicCure);

	/**
	 * 查询校内死亡者信息
	 * 
	 * @param epidemicDeath
	 * @return
	 */
	List<EpidemicCureDeath> getDeath(EpidemicCureDeath epidemicDeath);
}
