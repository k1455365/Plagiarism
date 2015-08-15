package kcl.qutong.plagiarism.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
/**
 * this class used to save user files in server side upload document
 * @author qutong
 *
 */
public class SaveUploadFile {
public static boolean savefile(File file,String filename) throws IOException{
	String realpath = ServletActionContext.getServletContext().getRealPath(
			"/upload");
	// /Users/qutong/Desktop/Postgraduate/Final_project/project/.metadata/.me_tcat/webapps/Plagiarism_Detection/upload
	System.out.println("realpath: " + realpath);
	if (file != null) {
		File savefile = new File(new File(realpath), filename);
		if (!savefile.getParentFile().exists())
			savefile.getParentFile().mkdirs();
		FileUtils.copyFile(file, savefile);
		return true;
	}
	else{
		System.out.println("file is empty");
		return false;
	}
}
}
