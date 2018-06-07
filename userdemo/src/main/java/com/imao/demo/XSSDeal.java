package com.imao.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 跨站脚本过滤
 */
public class XSSDeal {
	 	/** 
	     * 正则表达式过滤脚本威胁 
	     */    
        public static String replseJs(String html) {    
            try{    
                Pattern    replse1 = Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse2 = Pattern.compile("<[\\s]*?link[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?link[\\s]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse3 = Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse4 = Pattern.compile("<[\\s]*?iframe[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?iframe[\\s]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse5 = Pattern.compile("<(script|link|style|iframe)(.|\\n)*<\\/\\>\\s*");    
                Pattern       replse6 = Pattern.compile("javascript");    
                Pattern    replse7 = Pattern.compile("expression\\([^)]+\\)");    
                Pattern    replse8 = Pattern.compile("<[\\s]*?link[^>]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse9 = Pattern.compile("<[\\s]*?iframe[^>]*?>",Pattern.CASE_INSENSITIVE);    
                Pattern    replse10 = Pattern.compile("(?i)on[A-Za-z]*[\\s]*?=");  //匹配不区分大小写的on  + w(有无空格) + =  
                  
                Matcher    matcher1 = replse1.matcher(html);    
                html = matcher1.replaceAll("");     
         
                Matcher    matcher2 = replse2.matcher(html);    
                html = matcher2.replaceAll("");     
         
                Matcher    matcher3 = replse3.matcher(html);    
                html = matcher3.replaceAll("");     
         
                Matcher    matcher4 = replse4.matcher(html);    
                html = matcher4.replaceAll("");     
         
                Matcher matcher5 = replse5.matcher(html);    
                html=matcher5.replaceAll("");    
         
                Matcher matcher6 = replse6.matcher(html);    
                html=matcher6.replaceAll("");    
         
                Matcher matcher7 = replse7.matcher(html);    
                html=matcher7.replaceAll("");    
         
                Matcher matcher8 = replse8.matcher(html);    
                html=matcher8.replaceAll("");    
         
                Matcher matcher9 = replse9.matcher(html);    
                html=matcher9.replaceAll("");    
  
                Matcher matcher10 = replse10.matcher(html);    
                html=matcher10.replaceAll("");    
         
            }catch (Exception e) {    
                e.printStackTrace();    
            }    
            return html;    
        }    
         
        public static void main(String[] args) {    
            String str1="<script type=\"text/javascript\">alert(\"aaa\");</script>666";    
            String str2="11<link rel='stylesheet' href='/charts/Style.css' type='text/css' />111<link rel='stylesheet' href='/charts/Style.css' type='text/css'>222</link>";    
            String str3="<style>.padding:50px;</style>qqq";    
            String str4="qq<iframe src='/index/visitSum.do' name='visitingSum' style='display:none'>3333</iframe><iframe src='/index/visitSum.do' name='visitingSum' style='display:none'/>";    
            String str5="qqexpression(^\\ghhhhhhhhhhhhhhhhh)";    
            String str6="Onclick =qq";    
            String str7="alert(1)";    
            System.out.println("1:"+replseJs(str1));    
            System.out.println("2:"+replseJs(str2));    
            System.out.println("3:"+replseJs(str3));    
            System.out.println("4:"+replseJs(str4));    
            System.out.println("5:"+replseJs(str5));    
            System.out.println("6:"+replseJs(str6));    
            System.out.println("7:"+replseJs(str7));    
         
        }    
}
