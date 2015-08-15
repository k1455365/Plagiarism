package kcl.qutong.plagiarism.action;

import java.io.File;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import kcl.qutong.plagiarism.dao.pojo.User;
import kcl.qutong.plagiarism.service.TaskService;
import kcl.qutong.plagiarism.service.UserService;
import kcl.qutong.plagiarism.util.SaveUploadFile;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author qutong
 * 
 */
public class creatTaskAction extends ActionSupport {
	private TaskService taskService;
	private UserService userService;
	private String username;
	private String taskname;
	private File fst;
	private String fstFileName;
	private String fstContentType;
	private File sec;
	private String secFileName;
	private String secContentType;
	private String srcdir;

	public String getSrcdir() {
		return srcdir;
	}

	public void setSrcdir(String srcdir) {
		this.srcdir = srcdir;
	}

	public String getTrgdir() {
		return trgdir;
	}

	public void setTrgdir(String trgdir) {
		this.trgdir = trgdir;
	}

	private String trgdir;
	private Timestamp tasktime;
	private User u;

	private int taskway;// identify java or text type

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public File getFst() {
		return fst;
	}

	public void setFst(File fst) {
		this.fst = fst;
	}

	public String getFstFileName() {
		return fstFileName;
	}

	public void setFstFileName(String fstFileName) {
		this.fstFileName = fstFileName;
	}

	public String getFstContentType() {
		return fstContentType;
	}

	public void setFstContentType(String fstContentType) {
		this.fstContentType = fstContentType;
	}

	public File getSec() {
		return sec;
	}

	public void setSec(File sec) {
		this.sec = sec;
	}

	public String getSecFileName() {
		return secFileName;
	}

	public void setSecFileName(String secFileName) {
		this.secFileName = secFileName;
	}

	public String getSecContentType() {
		return secContentType;
	}

	public void setSecContentType(String secContentType) {
		this.secContentType = secContentType;
	}

	public Timestamp getTasktime() {
		return tasktime;
	}

	public void setTasktime(Timestamp tasktime) {
		this.tasktime = tasktime;
	}

	public int getTaskway() {
		return taskway;
	}

	public void setTaskway(int taskway) {
		this.taskway = taskway;
	}

	public String execute() throws Exception {
		// HttpServletRequest req = ServletActionContext.getRequest();
		// HttpSession session=req.getSession();
		// //taskname=(String)session.getAttribute("taskname");
		// String
		// requsername=(String)session.getAttribute("username");//获取登录用户名作为创建者
		// System.out.println("current session is: "+ActionContext.getContext().getSession()+"username is:"+requsername);
		//
		/*------------------------------------get task info--------------------------------------------*/
		System.out.println("开始执行 cretask execute()");
		System.out.println("The user'name is ---------- " + username);
		System.out.println("The task'name is ---------- " + taskname);
		System.out.println("The task's type is ---------- " + taskway);

		// String realpath =
		// ServletActionContext.getServletContext().getRealPath(
		// "/upload");
		// //
		// /Users/qutong/Desktop/Postgraduate/Final_project/project/.metadata/.me_tcat/webapps/Plagiarism_Detection/upload
		// System.out.println("realpath: " + realpath);
		if (SaveUploadFile.savefile(fst, fstFileName)) {
			System.out.println("successfullu upload file: " + fstFileName
					+ "this is a " + fstContentType + " file.");
		}
		else{
			System.out.println("first upload fail");
		}
		//upload second file
		if (SaveUploadFile.savefile(sec, secFileName)) {
			System.out.println("successfullu upload file: " + secFileName
					+ "this is a " + secContentType + " file.");
		}
		else{
			System.out.println("second upload fail");
		}
		// store files in server and get its local path
		// preprocess file based on the type of files, java or text

		// store task into database with taskname files directory and result
		// return result include largest value, similarity, result,
		// matrix...

		return "success";
	}
}
