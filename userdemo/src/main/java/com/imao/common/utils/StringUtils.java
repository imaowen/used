package com.imao.common.utils;

import java.util.regex.Pattern;

/**
 * 字符串处理类
 */
public class StringUtils {

	/*
	 * 验证字符串是否为空
	 */
	public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }
	
	/*
	 * 判断是否是正整数
	 */
	public static boolean isNum(String name){
		String regex = "[1-9]+";
		Pattern pattern = Pattern.compile(regex); 
		return pattern.matcher(name).matches();     
	}
	
	/*
     * 随机产生4位验证码字符
     */
    public static char[] generateCode(){
        //定义验证码的字符表
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++){
            int rand = (int) (Math.random() * chars.length());
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }
    
    /*
     * 四舍五入
     */
    public static String round(double number, int point){
    	String result = String.format("%."+point+"f", number);

    	return result;
    }
}
