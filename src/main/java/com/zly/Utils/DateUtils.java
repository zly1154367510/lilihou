package com.zly.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zly11 on 2018/6/16.
 */
public class DateUtils {

    /**
     * 格式化表单实现
     * @param format
     * @param date
     * @return
     */
    public static Date FormatDate(String format,String date){
        date = date.replace("T"," ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date1 = simpleDateFormat.parse(date);
            return date1;
        }catch (ParseException e){
            return null;

        }
    }

    public static String formtSystemDate(String format,String date){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(date);
        return dateString;
    }

}
