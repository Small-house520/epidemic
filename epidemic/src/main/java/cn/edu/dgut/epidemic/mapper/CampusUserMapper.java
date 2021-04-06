package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.CampusUser;
import cn.edu.dgut.epidemic.pojo.CampusUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampusUserMapper {
    int countByExample(CampusUserExample example);

    int deleteByExample(CampusUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(CampusUser record);

    int insertSelective(CampusUser record);

    List<CampusUser> selectByExample(CampusUserExample example);

    CampusUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") CampusUser record, @Param("example") CampusUserExample example);

    int updateByExample(@Param("record") CampusUser record, @Param("example") CampusUserExample example);

    int updateByPrimaryKeySelective(CampusUser record);

    int updateByPrimaryKey(CampusUser record);
}