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
        //get configuration file  
        //default read Hibernate.cfg.xml  
        Configuration cfg=new Configuration().configure();    
        //export xml into ddl  
        SchemaExport export=new SchemaExport(cfg);  
        export.create(true, true);  
    }  
} 