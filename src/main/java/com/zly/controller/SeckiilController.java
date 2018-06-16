package com.zly.controller;

import com.zly.model.Seckiil;
import com.zly.model.SeckiilItem;
import com.zly.model.SeckiilWhole;
import com.zly.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by zly11 on 2018/6/15.
 */
@Controller
public class SeckiilController {


    @Autowired
    private SeckillService seckillService;

    @RequestMapping("/addSeckiil")
    public ModelAndView addSeckiil(Model model){
        model.addAttribute("seckiil",new SeckiilWhole());
     //   model.addAttribute("",new SeckiilItem());
        return new ModelAndView("seckiil/addItem");
    }

    @RequestMapping("/saveSeckiil")
    public String saveItem(
            Model model,
            @RequestParam("startTime")String startTime,
            @RequestParam("endTime")String endTime,
            @RequestParam("newPrice")String price[],
            @RequestParam("num")String num[],
            @RequestParam("iId")int iId[]
    ){

//        System.out.println(startTime);
//        System.out.println(endTime);
//        System.out.println(price);
//        System.out.println(num);
//        System.out.println(iId);
//        System.out.println(seckiilItem);
        int res = seckillService.insert(startTime,endTime,iId,num,price);
        return "message";
    }
}
