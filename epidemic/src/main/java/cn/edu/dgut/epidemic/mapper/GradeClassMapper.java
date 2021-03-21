package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.GradeClass;
import cn.edu.dgut.epidemic.pojo.GradeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeClassMapper {
    int countByExample(GradeClassExample example);

    int deleteByExample(GradeClassExample example);

    int deleteByPrimaryKey(Integer classId);

    int insert(GradeClass record);

    int insertSelective(GradeClass record);

    List<GradeClass> selectByExample(GradeClassExample example);

    GradeClass selectByPrimaryKey(Integer classId);

    int updateByExampleSelective(@Param("record") GradeClass record, @Param("example") GradeClassExample example);

    int updateByExample(@Param("record") GradeClass record, @Param("example") GradeClassExample example);

    int updateByPrimaryKeySelective(GradeClass record);

    int updateByPrimaryKey(GradeClass record);
}