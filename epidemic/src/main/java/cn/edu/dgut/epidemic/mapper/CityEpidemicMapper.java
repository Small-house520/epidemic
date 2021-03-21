package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.CityEpidemic;
import cn.edu.dgut.epidemic.pojo.CityEpidemicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityEpidemicMapper {
    int countByExample(CityEpidemicExample example);

    int deleteByExample(CityEpidemicExample example);

    int deleteByPrimaryKey(Long cityEpidemicId);

    int insert(CityEpidemic record);

    int insertSelective(CityEpidemic record);

    List<CityEpidemic> selectByExample(CityEpidemicExample example);

    CityEpidemic selectByPrimaryKey(Long cityEpidemicId);

    int updateByExampleSelective(@Param("record") CityEpidemic record, @Param("example") CityEpidemicExample example);

    int updateByExample(@Param("record") CityEpidemic record, @Param("example") CityEpidemicExample example);

    int updateByPrimaryKeySelective(CityEpidemic record);

    int updateByPrimaryKey(CityEpidemic record);
}