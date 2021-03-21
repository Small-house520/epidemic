package cn.edu.dgut.epidemic.mapper;

import cn.edu.dgut.epidemic.pojo.ProvinceEpidemic;
import cn.edu.dgut.epidemic.pojo.ProvinceEpidemicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceEpidemicMapper {
    int countByExample(ProvinceEpidemicExample example);

    int deleteByExample(ProvinceEpidemicExample example);

    int deleteByPrimaryKey(Integer provinceEpidemicId);

    int insert(ProvinceEpidemic record);

    int insertSelective(ProvinceEpidemic record);

    List<ProvinceEpidemic> selectByExample(ProvinceEpidemicExample example);

    ProvinceEpidemic selectByPrimaryKey(Integer provinceEpidemicId);

    int updateByExampleSelective(@Param("record") ProvinceEpidemic record, @Param("example") ProvinceEpidemicExample example);

    int updateByExample(@Param("record") ProvinceEpidemic record, @Param("example") ProvinceEpidemicExample example);

    int updateByPrimaryKeySelective(ProvinceEpidemic record);

    int updateByPrimaryKey(ProvinceEpidemic record);
}