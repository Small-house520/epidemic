package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosis;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicDiagnosisMapper {
    int countByExample(EpidemicDiagnosisExample example);

    int deleteByExample(EpidemicDiagnosisExample example);

    int deleteByPrimaryKey(Integer epidemicDiagnosisId);

    int insert(EpidemicDiagnosis record);

    int insertSelective(EpidemicDiagnosis record);

    List<EpidemicDiagnosis> selectByExample(EpidemicDiagnosisExample example);

    EpidemicDiagnosis selectByPrimaryKey(Integer epidemicDiagnosisId);

    int updateByExampleSelective(@Param("record") EpidemicDiagnosis record, @Param("example") EpidemicDiagnosisExample example);

    int updateByExample(@Param("record") EpidemicDiagnosis record, @Param("example") EpidemicDiagnosisExample example);

    int updateByPrimaryKeySelective(EpidemicDiagnosis record);

    int updateByPrimaryKey(EpidemicDiagnosis record);
}