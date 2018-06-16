package com.zly.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zly.Utils.DateUtils;
import com.zly.Utils.GetInsertId;
import com.zly.dao.SeckiilItemMapper;
import com.zly.dao.SeckiilMapper;
import com.zly.model.Seckiil;
import com.zly.model.SeckiilItem;
import com.zly.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/6/15.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckiilMapper seckillMapper;

    @Autowired
    private SeckiilItemMapper seckiilItemMapper;

    @Transactional
    @Override
    public int insert(String startTime, String endTime, int[] iId, String[] nums, String[] prices) {
        String format = "yyyy-MM-dd HH:mm";
        Date start = DateUtils.FormatDate(format,startTime);
        Date end = DateUtils.FormatDate(format,endTime);
        GetInsertId getInsertId = new GetInsertId();
        int res = seckillMapper.insert1(start,end,new Date(),getInsertId);
        for(int i = 0;i<iId.length;i++){
            res = seckiilItemMapper.insert1(getInsertId.getId(),iId[i],nums[i],prices[i]);
        }
        return res;
    }

    @Override
    public List<Seckiil> selectAll(int page) {
        PageHelper.startPage(page,10);
        return seckillMapper.selectAll();
    }

    @Override
    public List<SeckiilItem> selectBySId(int sId) {
        return seckiilItemMapper.selectBysId(sId);
    }
}
