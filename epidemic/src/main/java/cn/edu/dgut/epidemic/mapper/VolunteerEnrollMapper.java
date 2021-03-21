package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.VolunteerEnroll;
import cn.edu.dgut.epidemic.pojo.VolunteerEnrollExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VolunteerEnrollMapper {
    int countByExample(VolunteerEnrollExample example);

    int deleteByExample(VolunteerEnrollExample example);

    int deleteByPrimaryKey(Long campusId);

    int insert(VolunteerEnroll record);

    int insertSelective(VolunteerEnroll record);

    List<VolunteerEnroll> selectByExample(VolunteerEnrollExample example);

    VolunteerEnroll selectByPrimaryKey(Long campusId);

    int updateByExampleSelective(@Param("record") VolunteerEnroll record, @Param("example") VolunteerEnrollExample example);

    int updateByExample(@Param("record") VolunteerEnroll record, @Param("example") VolunteerEnrollExample example);

    int updateByPrimaryKeySelective(VolunteerEnroll record);

    int updateByPrimaryKey(VolunteerEnroll record);
}