package com.wdcloud.personroom.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Umbrella on 2018/12/10.
 */

public class LongDate {
    private static String res;
    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String longToDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String fomat(String l) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
            Date parse = format.parse(l);
            return dateChange(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String dateChange(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();

        //获取系统的日期
        //年
        int year = calendar.get(Calendar.YEAR);
        //月
        int month = calendar.get(Calendar.MONTH) + 1;
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //分钟
        int minute = calendar.get(Calendar.MINUTE);
        //秒
        int second = calendar.get(Calendar.SECOND);
        return month+day+"";
    }
    public static Boolean isSameDay(Date date){
        Date currentdate = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        String currentFomat = sdf.format(currentdate);
        if(format.equals(currentFomat))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static String HealthstampToDate(String s) {
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        DateFormat strformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = null;
        try {
            parse = strformat.parse(s);
            res = format.format(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static String getCurrentDate()
    {
        Calendar c = Calendar.getInstance();//
        int mmoth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
        return mmoth+"."+mDay;
    }
    public static String getCensusCurrentDate()
    {
        Calendar c = Calendar.getInstance();//
        int mmoth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
        return mmoth+"月"+mDay+"日";
    }
    public static String censusDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        return sd.format(date);
    }
    public static String getDateMothDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String moth_day = sdf.format(date);
        return moth_day;
    }
    public static String censusToDate(Date date){
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String format = sd.format(date);
        return format;
    }
    public static String millis2String(final long millis) {
        return millis2String(millis, DEFAULT_FORMAT);
    }
    public static String millis2String(final long millis, final DateFormat format) {
        return format.format(new Date(millis));
    }
}
