package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.CampusAccessRecords;
import cn.edu.dgut.epidemic.pojo.CampusAccessRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CampusAccessRecordsMapper {
    int countByExample(CampusAccessRecordsExample example);

    int deleteByExample(CampusAccessRecordsExample example);

    int deleteByPrimaryKey(Integer recordId);

    int insert(CampusAccessRecords record);

    int insertSelective(CampusAccessRecords record);

    List<CampusAccessRecords> selectByExample(CampusAccessRecordsExample example);

    CampusAccessRecords selectByPrimaryKey(Integer recordId);

    int updateByExampleSelective(@Param("record") CampusAccessRecords record, @Param("example") CampusAccessRecordsExample example);

    int updateByExample(@Param("record") CampusAccessRecords record, @Param("example") CampusAccessRecordsExample example);

    int updateByPrimaryKeySelective(CampusAccessRecords record);

    int updateByPrimaryKey(CampusAccessRecords record);
}