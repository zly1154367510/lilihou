package com.zly.dao;

import com.zly.model.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select id,payment,create_time as created,u_id as uId,address,name,is_deliver as isDeliver from tb_order")
    List<Order> selectAll();

    @Select("select id,payment,create_time as createTime,u_id as uId,address,name from tb_order where u_id=#{uId}")
    List<Order> selectAllByUId(Long uId);

    @Select("select count(*) from tb_order")
    Long selectAllNum();

    @Select("select count(*) from tb_order where u_id=#{uId}")
    Long selectAllNumByUId(Long uId);

    @Update("update tb_order set is_deliver = '1' where id = #{id}")
    Integer updById(Integer id);

}