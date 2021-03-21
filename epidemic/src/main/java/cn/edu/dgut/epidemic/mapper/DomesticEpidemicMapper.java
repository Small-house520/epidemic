package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.DomesticEpidemic;
import cn.edu.dgut.epidemic.pojo.DomesticEpidemicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DomesticEpidemicMapper {
    int countByExample(DomesticEpidemicExample example);

    int deleteByExample(DomesticEpidemicExample example);

    int deleteByPrimaryKey(Short epidemicId);

    int insert(DomesticEpidemic record);

    int insertSelective(DomesticEpidemic record);

    List<DomesticEpidemic> selectByExample(DomesticEpidemicExample example);

    DomesticEpidemic selectByPrimaryKey(Short epidemicId);

    int updateByExampleSelective(@Param("record") DomesticEpidemic record, @Param("example") DomesticEpidemicExample example);

    int updateByExample(@Param("record") DomesticEpidemic record, @Param("example") DomesticEpidemicExample example);

    int updateByPrimaryKeySelective(DomesticEpidemic record);

    int updateByPrimaryKey(DomesticEpidemic record);
}