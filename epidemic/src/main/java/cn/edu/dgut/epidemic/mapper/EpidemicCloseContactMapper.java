package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.EpidemicCloseContact;
import cn.edu.dgut.epidemic.pojo.EpidemicCloseContactExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicCloseContactMapper {
    int countByExample(EpidemicCloseContactExample example);

    int deleteByExample(EpidemicCloseContactExample example);

    int deleteByPrimaryKey(Long campusId);

    int insert(EpidemicCloseContact record);

    int insertSelective(EpidemicCloseContact record);

    List<EpidemicCloseContact> selectByExample(EpidemicCloseContactExample example);

    EpidemicCloseContact selectByPrimaryKey(Long campusId);

    int updateByExampleSelective(@Param("record") EpidemicCloseContact record, @Param("example") EpidemicCloseContactExample example);

    int updateByExample(@Param("record") EpidemicCloseContact record, @Param("example") EpidemicCloseContactExample example);

    int updateByPrimaryKeySelective(EpidemicCloseContact record);

    int updateByPrimaryKey(EpidemicCloseContact record);
}