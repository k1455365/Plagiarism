package kcl.qutong.plagiarism.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * get file from browser and save it in serverside
 * @author qutong
 *
 */
public class FileUpload extends ActionSupport implements ServletContextAware {   
       
    private static final long serialVersionUID = -5016873153441103539L;   
       
    private File doc;  
    private String fileName;   
    private String contentType;   
    private HttpServletRequest req;   
    private ServletContext context; 
     
 
    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File file) {   
        this.doc = file;   
    }   
       
    public void setDocFileName(String fileName) {   
        this.fileName = fileName;   
    }   
       
    public void setDocContentType(String contentType) {   
        this.contentType = contentType;   
    }   
       
    public void setServletContext(ServletContext context) {   
        this.context = context;   
    } 
    
    //新建任务时的文件上传
    public String tFileUpload()throws Exception{
    	req = ServletActionContext.getRequest();
    	String targetDirectory = context.getRealPath("/upload/"+req.getSession().getId());
    	
    	try
		{
    		if(!(new File(targetDirectory).isDirectory()))
    		{
    			new File(targetDirectory).mkdir();
    		}
		}
		catch(SecurityException e)
		{
		        e.printStackTrace();
		}
    	File target = new File(targetDirectory,fileName);
           
        FileUtils.copyFile(doc, target);     
        return SUCCESS;  
    }
   
    //根据fileName判断上传的是压缩文件还是单个文件,false--单个文件 true--压缩文件
    public static boolean isWarOrFile(String fileName){
    	boolean rtv = false;
    	
    	String extename=fileName.replaceAll(".*\\.", "");
    	if(extename.equals("rar") || extename.equals("zip")){
    		rtv = true;
    	}
		return rtv;
    }
    
  //获取当前样本库的文件路径
	public static String getAttachPath(String path, String fileName){
		if (fileName != null && !path.equals("")) {
			try {
				return (getPath(path)+"\\"+changeFileName(fileName))+"\\";
			}catch (Exception e) {
			}
		}
		return null;
	}
	
	public static String getCurrUsername() {
		return (String)ActionContext.getContext().getSession().get("username");
	}
	
	private static String changeFileName(String fileName) {
		return System.currentTimeMillis()+getCurrUsername();
	}
	
	//获取服务器真实路径
	public static String getPath(String path) throws Exception {
		return ServletActionContext.getServletContext().getRealPath(path);
	}
    
    public static ArrayList<String>  refreshFileList(String strPath) { 
        File dir = new File(strPath); 
        File[] files = dir.listFiles(); 
        ArrayList<String> filelist = new ArrayList<String>(); 

        if (files == null) 
            return filelist; 
        for (int i = 0; i < files.length; i++) { 
            if (files[i].isDirectory()) { 
            	filelist.addAll(refreshFileList(files[i].getAbsolutePath())); 
            } else { 
                String strFileName = files[i].getAbsolutePath().toLowerCase();
//                System.out.println("---"+strFileName);
                filelist.add(files[i].getAbsolutePath());                    
            } 
        }
        return filelist;
    }
    
//  //添加样本库时把文件拷贝到服务器对应目录
//    public static void slFileUpload(boolean warOrFile, String strpath, String fileName, File doc) throws Exception{
//		saveFile(strpath, fileName, doc);
//		
//		if(warOrFile == true){
//			String extename=fileName.replaceAll(".*\\.", "");
//        	if(extename.equals("rar")){
//        		UnrarFile unrarfile=new UnrarFile();
//    			try {
//    				unrarfile.unRARFile(strpath+fileName, strpath);
//    			} catch (IOException e) {
//    				System.out.println("出现异常....");
//    				e.printStackTrace();
//    			}
//        	}
//        	else if(extename.equals("zip")){
//        		UnzipFile UnzipFile = new UnzipFile();  
//    			UnzipFile.UnZIPFile(strpath+fileName, strpath);
//        	}
//		}
//    }
    
    private static void saveFile(String filePath, String fileName, File doc) {
		if(fileName == null || fileName.equals("")){
			return ;
		}
		if (filePath == null || filePath.equals("")) {
			return;
		}
		try {
			File f = new File(filePath);
			if(!f.exists())
			{
				f.mkdirs();
			}
			
			File target = new File(filePath,fileName);
	           
	        FileUtils.copyFile(doc, target);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

} 

