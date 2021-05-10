package cn.edu.dgut.epidemic.service;

import java.util.List;

import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;

public interface CampusEpidemicService {
	/**
	 * 查看校内确诊患者信息
	 * 
	 * @param epidemicDiagnosis
	 * @return
	 */
	List<EpidemicDiagnosis> getDiagnosis();

	/**
	 * 根据查询条件查询校内确诊患者信息
	 * 
	 * @param epidemicDiagnosis
	 * @param fullName
	 * @return
	 */
	List<EpidemicDiagnosis> findDiagnosis(EpidemicDiagnosis epidemicDiagnosis, String fullName);

	/**
	 * 查询校内密切接触者信息
	 * 
	 * @param epidemicContact
	 * @return
	 */
	List<EpidemicContact> getContact();

	/**
	 * 根据查询条件查询校内密切接触者信息
	 * 
	 * @param epidemicContact
	 * @param fullName
	 * @return
	 */
	List<EpidemicContact> findContact(EpidemicContact epidemicContact, String fullName);

	/**
	 * 查看校内治愈者信息或死亡者信息
	 * 
	 * @return
	 */
	List<EpidemicCureDeath> getCureDeath(Integer flag);

	/**
	 * 根据查询条件查询校内治愈者信息或死亡者信息
	 * 
	 * @param cureDeath
	 * @param fullName
	 * @param flag
	 * @return
	 */
	List<EpidemicCureDeath> findCureDeath(EpidemicCureDeath cureDeath, String fullName, Integer flag);

	/**
	 * 新增确诊患者信息
	 * 
	 * @param diagnosis
	 * @param flag
	 */
	void diagnosesAdd(EpidemicDiagnosis diagnosis, String flag);

	/**
	 * 新增密切接触者信息
	 * 
	 * @param epidemicContact
	 */
	void contactAdd(EpidemicContact epidemicContact);

	/**
	 * 新增治愈或死亡者信息
	 * 
	 * @param cureDeath
	 */
	void cureDeathAdd(EpidemicCureDeath cureDeath);

	/**
	 * 隔离完成
	 */
	void isolateFinish(String campusId);
}
