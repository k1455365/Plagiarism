package kcl.qutong.plagiarism.action;

import java.sql.Timestamp;
import kcl.qutong.plagiarism.dao.pojo.User;
import kcl.qutong.plagiarism.service.TaskService;
import kcl.qutong.plagiarism.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author qutong
 *
 */
public class creatTaskAction extends ActionSupport{
	private TaskService taskService;
	private UserService userService;
	private String username;
	private String taskname;
//	private File fstFile;
//	private File secFile;
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
	
	private int taskway;//identify java or text type
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

//	public File getFstFile() {
//		return fstFile;
//	}
//	public void setFstFile(File fstFile) {
//		this.fstFile = fstFile;
//	}
//	public File getSecFile() {
//		return secFile;
//	}
//	public void setSecFile(File secFile) {
//		this.secFile = secFile;
//	}
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
//		HttpServletRequest req = ServletActionContext.getRequest();
//		HttpSession session=req.getSession();
//		//taskname=(String)session.getAttribute("taskname");
//		String requsername=(String)session.getAttribute("username");//获取登录用户名作为创建者
//		System.out.println("current session is: "+ActionContext.getContext().getSession()+"username is:"+requsername);
//		
/*------------------------------------get task info--------------------------------------------*/
		System.out.println("开始执行 cretask execute()");
		System.out.println("The user'name is ---------- " + username);
		System.out.println("The task'name is ---------- " + taskname);
		System.out.println("The task's type is ---------- " + taskway);
		System.out.println("The 1st file directory is ---------- " + srcdir);
		System.out.println("The 2nd file directory is ---------- " + trgdir);
		
		
		//store files in server and get its local path
		//preprocess file based on the type of files, java or text
		
		//store task into database with taskname files directory and result
		//return result include largest value, similarity, result, matrix...
		return "success";
		
	}

}
