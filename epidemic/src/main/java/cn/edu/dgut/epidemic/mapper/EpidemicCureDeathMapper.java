package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicCureDeath;
import cn.edu.dgut.epidemic.pojo.EpidemicCureDeathExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicCureDeathMapper {
    int countByExample(EpidemicCureDeathExample example);

    int deleteByExample(EpidemicCureDeathExample example);

    int deleteByPrimaryKey(Long campusId);

    int insert(EpidemicCureDeath record);

    int insertSelective(EpidemicCureDeath record);

    List<EpidemicCureDeath> selectByExample(EpidemicCureDeathExample example);

    EpidemicCureDeath selectByPrimaryKey(Long campusId);

    int updateByExampleSelective(@Param("record") EpidemicCureDeath record, @Param("example") EpidemicCureDeathExample example);

    int updateByExample(@Param("record") EpidemicCureDeath record, @Param("example") EpidemicCureDeathExample example);

    int updateByPrimaryKeySelective(EpidemicCureDeath record);

    int updateByPrimaryKey(EpidemicCureDeath record);
}