package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicPreventionControl;
import cn.edu.dgut.epidemic.pojo.EpidemicPreventionControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicPreventionControlMapper {
    int countByExample(EpidemicPreventionControlExample example);

    int deleteByExample(EpidemicPreventionControlExample example);

    int deleteByPrimaryKey(Short preventionControlId);

    int insert(EpidemicPreventionControl record);

    int insertSelective(EpidemicPreventionControl record);

    List<EpidemicPreventionControl> selectByExample(EpidemicPreventionControlExample example);

    EpidemicPreventionControl selectByPrimaryKey(Short preventionControlId);

    int updateByExampleSelective(@Param("record") EpidemicPreventionControl record, @Param("example") EpidemicPreventionControlExample example);

    int updateByExample(@Param("record") EpidemicPreventionControl record, @Param("example") EpidemicPreventionControlExample example);

    int updateByPrimaryKeySelective(EpidemicPreventionControl record);

    int updateByPrimaryKey(EpidemicPreventionControl record);
}