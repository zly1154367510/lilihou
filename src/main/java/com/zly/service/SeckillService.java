package com.zly.service;

import com.zly.model.Seckiil;
import com.zly.model.SeckiilItem;

import java.util.List;

/**
 * Created by zly11 on 2018/6/15.
 */
public interface SeckillService {

    int insert(String startTime,String endTime,int[] iId,String[] nums,String[] prices);

    List<Seckiil> selectAll(int page);

    List<SeckiilItem> selectBySId(int sId);



}
