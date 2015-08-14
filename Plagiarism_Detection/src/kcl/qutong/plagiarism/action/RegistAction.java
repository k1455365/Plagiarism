package kcl.qutong.plagiarism.action;

import com.opensymphony.xwork2.ActionSupport;
import kcl.qutong.plagiarism.service.UserService;
import kcl.qutong.plagiarism.dao.pojo.User;
import kcl.qutong.plagiarism.util.MD5;

/**
 * This class used to execute register
 * 
 * @author qutong
 * 
 */
public class RegistAction extends ActionSupport {
	// private User userBean;
	private UserService userService;
	private String username;
	private String password;
	private User userbean;

	public User getUserbean() {
		return userbean;
	}

	public void setUserbean(User userbean) {
		this.userbean = userbean;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		if (username == null || username.equals("")) {
			return ERROR;
		} else
			System.out.print(username + "   " + password);
		userbean = new User();
		userbean.setPassword(MD5.getPasswordMD5(password));
		userbean.setUsername(username);
		userService.addUser(userbean);
		return SUCCESS;
	}

}
