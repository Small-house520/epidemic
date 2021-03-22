package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.TemperatureItinerary;
import cn.edu.dgut.epidemic.pojo.TemperatureItineraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemperatureItineraryMapper {
    int countByExample(TemperatureItineraryExample example);

    int deleteByExample(TemperatureItineraryExample example);

    int deleteByPrimaryKey(Integer healthId);

    int insert(TemperatureItinerary record);

    int insertSelective(TemperatureItinerary record);

    List<TemperatureItinerary> selectByExample(TemperatureItineraryExample example);

    TemperatureItinerary selectByPrimaryKey(Integer healthId);

    int updateByExampleSelective(@Param("record") TemperatureItinerary record, @Param("example") TemperatureItineraryExample example);

    int updateByExample(@Param("record") TemperatureItinerary record, @Param("example") TemperatureItineraryExample example);

    int updateByPrimaryKeySelective(TemperatureItinerary record);

    int updateByPrimaryKey(TemperatureItinerary record);
}