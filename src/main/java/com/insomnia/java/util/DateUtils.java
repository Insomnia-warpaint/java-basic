package com.insomnia.java.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author insomnia
 * @date 2021/4/3 下午12:50
 * @effect 获取平年 闰年
 */
public class DateUtils {

    /**
     * 判断是平年还是润年
     * 普通年判断方法：能被4整除且不能被100整除的为闰年
     * 世纪年判断方法：能被400整除的是闰年
     */

    /**
     *
     * @param year 年
     * @return 平年返回 true
     */
    public static boolean normalYear(Integer year){
        boolean isNormalYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        return !isNormalYear;
    }

    /**
     *
     * @param year 年
     * @return 闰年反回 true
     */
    public static boolean leapYear(Integer year){
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        return isLeapYear;
    }


    public static void main(String[] args) {

    }
}
