package com.zly.controller;

import com.zly.Utils.JsonResult;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        if(res != 0){
            model.addAttribute("message","成功添加秒杀活动");
            return "message/success";
        }
        model.addAttribute("message","添加秒杀活动失败");
        return "message/success";
    }

    @RequestMapping("/seckiil")
    public String seckiil(Model model,@RequestParam(value = "page", required = false, defaultValue = "1")int page){
        model.addAttribute("list",seckillService.selectAll(page));
        model.addAttribute("page",page);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        return "seckiil/item";
    }

    @ResponseBody
    @RequestMapping("/seckiilItem")
    public JsonResult seckiilItem(@RequestParam("id")Integer sId){
        return JsonResult.ok(seckillService.selectBySId(sId));
    }
}
