package com.imao.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 */
public class DateUtils {
	
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 时间格式化
	 * @param date
	 * @param pattern
	 * @return
	 */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
