package com.zly.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zly11 on 2018/6/16.
 */
public class DateUtils {

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

}
