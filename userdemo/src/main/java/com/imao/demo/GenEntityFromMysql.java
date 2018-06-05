package com.imao.demo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
/**
 * 数据库生成实体类工具类
 */
public class GenEntityFromMysql {
	public static void main(String[] args) {  
        new GenEntityFromMysql();  
    }  

    private String packageOutPath = "com.imao";//指定实体生成所在包的路径  
    private String authorName = "lmw";//作者名字 
    private String entityPath = "D:\\entity";//实体类保存路径
    private boolean f_util = false; // 是否需要导入包java.util.*  
    private boolean f_sql = false; // 是否需要导入包java.sql.*  
    //数据库连接  
    private static final String URL ="jdbc:mysql://172.16.0.244:3306/test1taojinjia";  
    private static final String NAME = "test1taojinjia";  
    private static final String PASS = "123456";  
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    /* 
     * 构造函数 
     */  
    public GenEntityFromMysql(){  
        //创建连接  
        Connection con = null;    
        try {  
        	Class.forName(DRIVER); 
            con = (Connection) DriverManager.getConnection(URL,NAME,PASS); 
            DatabaseMetaData dbmd=(DatabaseMetaData) con.getMetaData();
            //获取数据库所有表
            ResultSet crs = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
            f_util = false;
            f_sql = false;
            while(crs.next()){
            	String tableName=crs.getString("TABLE_NAME");
            	System.out.println("数据库表："+tableName);
            	//表的所有字段
            	ResultSet rs = dbmd.getColumns(null, "%", tableName, "%"); //表字段
            	List<String> colnames = new ArrayList<>();
            	List<String> colTypes = new ArrayList<>();
            	List<String> colRemarks = new ArrayList<>();
            	while(rs.next()){
            		String name = rs.getString("COLUMN_NAME");
            		String type = rs.getString("TYPE_NAME");
            		String remarks = rs.getString("REMARKS");
            		
            		colnames.add(name);
            		colTypes.add(type);
            		colRemarks.add(remarks);
            		
            		if(type.equalsIgnoreCase("datetime")){  
                         f_util = true;  
                    }  
                    if(type.equalsIgnoreCase("image") || type.equalsIgnoreCase("text")){  
                         f_sql = true;  
                    }  
                    String content = parse(colnames,colTypes,colRemarks, tableName);  
                	//输出路径
                    String outputPath = entityPath + tableName+".java";  
                    FileWriter fw = new FileWriter(outputPath);  
                    PrintWriter pw = new PrintWriter(fw);  
                    pw.println(content);  
                    pw.flush();  
                    pw.close();  
            	}
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
          try {  
              con.close();  
          } catch (SQLException e) {   
              e.printStackTrace();  
          }  
        }  
    }  
    /**
     * 功能：生成实体类主体代码 
     * @param colnames
     * @param colTypes
     * @param colRemarks
     * @param tablename
     * @return
     */
    private String parse(List<String> colnames, List<String> colTypes,List<String> colRemarks, String tablename) {  
        StringBuffer sb = new StringBuffer();  
        //判断是否导入工具包  
        if(f_util){  
            sb.append("import java.util.Date;\r\n");  
        }  
        if(f_sql){  
            sb.append("import java.sql.*;\r\n");  
        }  
        sb.append("package " + this.packageOutPath + ";\r\n");  
        sb.append("\r\n");  
        //实体头部注释部分  
        sb.append("/**\r\n");  
        sb.append("* "+tablename+" 实体类\r\n");  
        sb.append("* "+this.authorName+"\r\n");  
        sb.append("*/ \r\n");  
        //实体部分  
        sb.append("public class " + initcap(tablename) + "{\r\n");  
        
        processAllAttrs(colnames, colTypes, colRemarks, sb);//属性  
        
        processAllMethod(colnames, colTypes,sb);//get set方法  
        
        sb.append("}\r\n");  
        return sb.toString();  
    }  
    /**
     * 功能：生成所有属性   
     * @param colnames
     * @param colTypes
     * @param colRemarks
     * @param sb
     */
    private void processAllAttrs(List<String> colnames, List<String> colTypes,List<String> colRemarks,StringBuffer sb) {  
        for (int i = 0; i < colnames.size(); i++) {  
            sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + colnames.get(i) + "; //"+colRemarks.get(i)+"\r\n");  
        }  
        sb.append("\r\n");
    }  
    /** 
     * 功能：生成get,set所有方法 
     * @param colnames
     * @param colTypes
     * @param sb
     */
    private void processAllMethod(List<String> colnames, List<String> colTypes,StringBuffer sb) {  
        for (int i = 0; i < colnames.size(); i++) {  
            sb.append("\tpublic void set" + initcap(colnames.get(i)) + "(" + sqlType2JavaType(colTypes.get(i)) + " " +   
                    colnames.get(i) + "){\r\n");  
            sb.append("\t\tthis." + colnames.get(i) + "=" + colnames.get(i) + ";\r\n");  
            sb.append("\t}\r\n");  
            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i)) + " get" + initcap(colnames.get(i)) + "(){\r\n");  
            sb.append("\t\treturn " + colnames.get(i) + ";\r\n");  
            sb.append("\t}\r\n");  
        }  
    }  
    /** 
     * 功能：将输入字符串的首字母改成大写 
     * @param str 
     * @return 
     */  
    private String initcap(String str) {  
        char[] ch = str.toCharArray();  
        if(ch[0] >= 'a' && ch[0] <= 'z'){  
            ch[0] = (char)(ch[0] - 32);  
        }  
        return new String(ch);  
    }  
    /** 
     * 功能：获得列的数据类型 
     * @param sqlType 
     * @return 
     */  
    private String sqlType2JavaType(String sqlType) {  
          
        if(sqlType.equalsIgnoreCase("bit")){  
            return "boolean";  
        }else if(sqlType.equalsIgnoreCase("tinyint")){  
            return "byte";  
        }else if(sqlType.equalsIgnoreCase("smallint")){  
            return "short";  
        }else if(sqlType.equalsIgnoreCase("int")){  
            return "Integer";  
        }else if(sqlType.equalsIgnoreCase("bigint")){  
            return "long";  
        }else if(sqlType.equalsIgnoreCase("float")){  
            return "float";  
        }else if(sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")   
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")   
                || sqlType.equalsIgnoreCase("smallmoney")){  
            return "double";  
        }else if(sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")   
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")   
                || sqlType.equalsIgnoreCase("text")){  
            return "String";  
        }else if(sqlType.equalsIgnoreCase("datetime")){  
            return "Date";  
        }else if(sqlType.equalsIgnoreCase("image")){  
            return "Blod";  
        }  
        return null;  
    }  
}
