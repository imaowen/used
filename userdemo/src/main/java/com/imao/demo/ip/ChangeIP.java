package com.imao.demo.ip;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * 拨号切换IP类
 * @author lmw
 *
 */
public class ChangeIP {

	private static Logger log = Logger.getLogger("宽带");

    /**
     * 连接ADSL
     */
    public static boolean connAdsl(String adslTitle, String adslName, String adslPass) throws Exception {
        log.info("正在建立连接.");
        String adslCmd = "rasdial " + adslTitle + " " + adslName + " "
                + adslPass;
        String tempCmd = executeCmd(adslCmd);
        // 判断是否连接成功
        if (tempCmd.indexOf("已连接") > 0) {
            log.info("已成功建立连接.");
            return true;
        } else {
            log.info("建立连接失败");
            return false;
        }
    }

    /**
     * 断开ADSL
     */
    public static boolean cutAdsl(String adslTitle) throws Exception {
        String cutAdsl = "rasdial " + adslTitle + " /disconnect";
        String result = executeCmd(cutAdsl);
       
        if (result.indexOf("没有连接")!=-1){
            log.info(adslTitle + "连接不存在!");
            return false;
        } else {
            log.info("连接已断开");
            return true;
        }
    }

    /**
     * 执行CMD命令,并返回String字符串
     */
    public static String executeCmd(String strCmd) throws Exception {
        Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
        StringBuilder sbCmd = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(p
                .getInputStream(),"GBK"));
        String line;
        while ((line = br.readLine()) != null) {
            sbCmd.append(line + "\n");
        }
        return sbCmd.toString();
    }
    
}