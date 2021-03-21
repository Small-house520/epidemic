package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicInformation;
import cn.edu.dgut.epidemic.pojo.EpidemicInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicInformationMapper {
    int countByExample(EpidemicInformationExample example);

    int deleteByExample(EpidemicInformationExample example);

    int deleteByPrimaryKey(Short informationId);

    int insert(EpidemicInformation record);

    int insertSelective(EpidemicInformation record);

    List<EpidemicInformation> selectByExample(EpidemicInformationExample example);

    EpidemicInformation selectByPrimaryKey(Short informationId);

    int updateByExampleSelective(@Param("record") EpidemicInformation record, @Param("example") EpidemicInformationExample example);

    int updateByExample(@Param("record") EpidemicInformation record, @Param("example") EpidemicInformationExample example);

    int updateByPrimaryKeySelective(EpidemicInformation record);

    int updateByPrimaryKey(EpidemicInformation record);
}