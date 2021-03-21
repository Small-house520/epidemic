package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.VolunteerService;
import cn.edu.dgut.epidemic.pojo.VolunteerServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VolunteerServiceMapper {
    int countByExample(VolunteerServiceExample example);

    int deleteByExample(VolunteerServiceExample example);

    int deleteByPrimaryKey(Short volunteerServiceId);

    int insert(VolunteerService record);

    int insertSelective(VolunteerService record);

    List<VolunteerService> selectByExample(VolunteerServiceExample example);

    VolunteerService selectByPrimaryKey(Short volunteerServiceId);

    int updateByExampleSelective(@Param("record") VolunteerService record, @Param("example") VolunteerServiceExample example);

    int updateByExample(@Param("record") VolunteerService record, @Param("example") VolunteerServiceExample example);

    int updateByPrimaryKeySelective(VolunteerService record);

    int updateByPrimaryKey(VolunteerService record);
}