package com.zly.dao;

import com.zly.model.SeckiilItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SeckiilItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckiilItem record);

    int insertSelective(SeckiilItem record);

    SeckiilItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckiilItem record);

    int updateByPrimaryKey(SeckiilItem record);

    @Insert("insert into tb_seckiil_item (id,s_id,i_id,new_price,num) values(null,#{sId},#{iId},#{newPirce},#{num})")
    int insert1(@Param("sId")int sId,@Param("iId")int iId,@Param("newPirce")String newPrice,@Param("num")String num);

    @Select("Select id,s_id as sId,i_id as iId,new_price as newPrice,num from tb_seckiil_item where s_id=#{sId}")
    @Results({
            @Result(
                    column = "iId",
                    property = "iId"
            ),
            @Result(
                    column = "iId",
                    property = "item",
                    one = @One(select = "com.zly.dao.ItemMapper.selectByPrimaryKey")
            )
    })
    List<SeckiilItem> selectBysId(int sId);
}