package com.zly.dao;

import com.zly.Utils.GetInsertId;
import com.zly.model.Seckiil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

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
}