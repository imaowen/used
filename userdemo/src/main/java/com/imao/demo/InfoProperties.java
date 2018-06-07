package com.imao.demo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 宽带信息类
 * @author lmw
 *
 */
public class InfoProperties {
	//宽带信息
	private static String kdusername;
    private static String kdpassword;
    //单号信息
  	private static String dhusername;
    private static String dhpassword;
    //打码信息
    private static String rkusername;
    private static String rkpassword;
    //操作相关
    private static Integer isrk;
    private static Integer usesign;
    private static Integer tasksecond;
    private static String tspassword;
    
	static {   
        Properties prop = new Properties();   
        InputStream in = InfoProperties.class.getClassLoader().getResourceAsStream("info.properties");   
        try {   
            prop.load(in);   
            kdusername = prop.getProperty("kdusername").trim();   
            kdpassword = prop.getProperty("kdpassword").trim();  
            
            dhusername = prop.getProperty("dhusername").trim();   
            dhpassword = prop.getProperty("dhpassword").trim();  
            
            rkusername = prop.getProperty("rkusername").trim();   
            rkpassword = prop.getProperty("rkpassword").trim();
            
            isrk = Integer.valueOf(prop.getProperty("isrk").trim());
            usesign = Integer.valueOf(prop.getProperty("usesign").trim());
            tasksecond = Integer.valueOf(prop.getProperty("tasksecond").trim());
            tspassword = prop.getProperty("tspassword").trim();
            
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
    
    private InfoProperties() {   
    }   
    
    public static String getRkusername() {   
        return rkusername;   
    }   
  
    public static String getRkpassword() {   
        return rkpassword;   
    } 

	public static Integer getIsrk() {
		return isrk;
	}

	public static Integer getUsesign() {
		return usesign;
	}

	public static String getDhusername() {
		return dhusername;
	}

	public static String getDhpassword() {
		return dhpassword;
	}

	public static Integer getTasksecond() {
		return tasksecond;
	}

	public static String getTspassword() {
		return tspassword;
	}

	public static String getKdusername() {
		return kdusername;
	}

	public static String getKdpassword() {
		return kdpassword;
	}

}
