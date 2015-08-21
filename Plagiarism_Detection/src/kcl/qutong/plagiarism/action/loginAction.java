package kcl.qutong.plagiarism.action;

import kcl.qutong.plagiarism.service.UserService;
import kcl.qutong.plagiarism.util.MD5;
import com.opensymphony.xwork2.ActionSupport;
/**
 * This method make response to login request
 * @author qutong
 *
 */
public class loginAction extends ActionSupport {
	private UserService userService;
	private String username;
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("start execute()");
		System.out.println("The user'name is ---------- " + username);
		System.out.println("The user'passwd is ---------- " + password);
		if (username.equals("") || password.equals("")) {
			System.out.println("username or password is empty");
			return ERROR;
		} else {
			String hashpassword=MD5.getPasswordMD5(password);
			String dbpassword=userService.findUser(username).getPassword();
			if (hashpassword.equals(dbpassword)) {
				System.out.println("User " + username + " authority finished");
				return SUCCESS;
			} else {
				return ERROR;
			}
		}
	}
}