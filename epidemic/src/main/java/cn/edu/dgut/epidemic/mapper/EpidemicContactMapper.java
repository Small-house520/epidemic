package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicContact;
import cn.edu.dgut.epidemic.pojo.EpidemicContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicContactMapper {
    int countByExample(EpidemicContactExample example);

    int deleteByExample(EpidemicContactExample example);

    int deleteByPrimaryKey(Integer epidemicContactId);

    int insert(EpidemicContact record);

    int insertSelective(EpidemicContact record);

    List<EpidemicContact> selectByExample(EpidemicContactExample example);

    EpidemicContact selectByPrimaryKey(Integer epidemicContactId);

    int updateByExampleSelective(@Param("record") EpidemicContact record, @Param("example") EpidemicContactExample example);

    int updateByExample(@Param("record") EpidemicContact record, @Param("example") EpidemicContactExample example);

    int updateByPrimaryKeySelective(EpidemicContact record);

    int updateByPrimaryKey(EpidemicContact record);
}