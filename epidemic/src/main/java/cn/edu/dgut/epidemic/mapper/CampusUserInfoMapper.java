package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.CampusUserInfo;
import cn.edu.dgut.epidemic.pojo.CampusUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampusUserInfoMapper {
    int countByExample(CampusUserInfoExample example);

    int deleteByExample(CampusUserInfoExample example);

    int deleteByPrimaryKey(String campusId);

    int insert(CampusUserInfo record);

    int insertSelective(CampusUserInfo record);

    List<CampusUserInfo> selectByExample(CampusUserInfoExample example);

    CampusUserInfo selectByPrimaryKey(String campusId);

    int updateByExampleSelective(@Param("record") CampusUserInfo record, @Param("example") CampusUserInfoExample example);

    int updateByExample(@Param("record") CampusUserInfo record, @Param("example") CampusUserInfoExample example);

    int updateByPrimaryKeySelective(CampusUserInfo record);

    int updateByPrimaryKey(CampusUserInfo record);
}