package kcl.qutong.plagiarism.action;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.apache.struts2.ServletActionContext;
//import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionInvocation;
//import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import kcl.qutong.plagiarism.dao.pojo.Task;
import kcl.qutong.plagiarism.service.TaskService;
import kcl.qutong.plagiarism.service.UserService;
/**
 * return task related information to pages
 * @author qutong
 *
 */
public class showTaskAction extends ActionSupport{
	private TaskService taskService;
	private UserService userService;
	private String username;
	private List<Task> tasklist;
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
	public List<Task> getTasklist() {
		return tasklist;
	}
	public void setTasklist(List<Task> tasklist) {
		this.tasklist = tasklist;
	}
	public String execute() throws Exception {

		tasklist=taskService.findTasksbyUser(username);
		setTasklist(tasklist);
		System.out.println("user is: "+username+" he's tasks are: "+tasklist);
		return SUCCESS;
		
	}
}
