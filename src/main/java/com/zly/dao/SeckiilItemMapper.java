package com.zly.dao;

import com.zly.model.SeckiilItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface SeckiilItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckiilItem record);

    int insertSelective(SeckiilItem record);

    SeckiilItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckiilItem record);

    int updateByPrimaryKey(SeckiilItem record);

    @Insert("insert into tb_seckiil_item (id,s_id,i_id,new_price,num) values(null,#{sId},#{iId},#{newPirce},#{num})")
    int insert1(@Param("sId")int sId,@Param("iId")int iId,@Param("newPirce")String newPrice,@Param("num")String num);
}