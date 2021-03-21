package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisSuspected;
import cn.edu.dgut.epidemic.pojo.EpidemicDiagnosisSuspectedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicDiagnosisSuspectedMapper {
    int countByExample(EpidemicDiagnosisSuspectedExample example);

    int deleteByExample(EpidemicDiagnosisSuspectedExample example);

    int deleteByPrimaryKey(Long campusId);

    int insert(EpidemicDiagnosisSuspected record);

    int insertSelective(EpidemicDiagnosisSuspected record);

    List<EpidemicDiagnosisSuspected> selectByExample(EpidemicDiagnosisSuspectedExample example);

    EpidemicDiagnosisSuspected selectByPrimaryKey(Long campusId);

    int updateByExampleSelective(@Param("record") EpidemicDiagnosisSuspected record, @Param("example") EpidemicDiagnosisSuspectedExample example);

    int updateByExample(@Param("record") EpidemicDiagnosisSuspected record, @Param("example") EpidemicDiagnosisSuspectedExample example);

    int updateByPrimaryKeySelective(EpidemicDiagnosisSuspected record);

    int updateByPrimaryKey(EpidemicDiagnosisSuspected record);
}