package kcl.qutong.plagiarism.dao.pojo;

import org.hibernate.cfg.Configuration;  
import org.hibernate.tool.hbm2ddl.SchemaExport;  
  
/** 
 * 将hbm生成ddl 
 * @author qutong
 * 
 */  
public class ExportDB {  
    public static void main(String[] args){  
        //首先声明获取配置文件  
        //默认读取Hibernate.cfg.xml文件  
        Configuration cfg=new Configuration().configure();    
          
        //将读取到的xml文件导出到ddl  
        SchemaExport export=new SchemaExport(cfg);  
        export.create(true, true);  
    }  
} 