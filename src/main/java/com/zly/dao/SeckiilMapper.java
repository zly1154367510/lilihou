package com.zly.dao;

import com.zly.Utils.GetInsertId;
import com.zly.model.Seckiil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface SeckiilMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Seckiil record);

    int insertSelective(Seckiil record);

    Seckiil selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Seckiil record);

    int updateByPrimaryKey(Seckiil record);

    @Insert("insert into tb_seckiil(id,start_time,end_time,create_time) values (null,#{start},#{end},#{create})")
    @Options(useGeneratedKeys = true,keyProperty = "GetInsertId.id")
    int insert1(@Param("start") Date strat, @Param("end")Date end, @Param("create") Date create, @Param("GetInsertId")GetInsertId getInsertId);


    @Select("select id,start_time as startTime,end_time as endTime,create_time as createTime from tb_seckiil")
    List<Seckiil> selectAll();
}
