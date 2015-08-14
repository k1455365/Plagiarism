package kcl.qutong.plagiarism.action;

import kcl.qutong.plagiarism.service.UserService;
import kcl.qutong.plagiarism.util.MD5;
import com.opensymphony.xwork2.ActionSupport;

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
		System.out.println("开始执行execute()");
		// two method get value of parameters in session
		// Map<String, Object> map = ActionContext.getContext().getSession();
		// String username = (String) map.get("username");
		// String passwd = (String) map.get("passwd");
		// second method
		// ActionContext ctx = ActionContext.getContext();
		// String username1 = (String) ctx.getSession().get("username");
		// String passwd1 = (String) ctx.getSession().get("passwd");
		// third one
		System.out.println("The user'name is ---------- " + username);
		System.out.println("The user'passwd is ---------- " + password);
		// System.out.println("The user'name is ---------- " + username1);
		// System.out.println("The user'passwd is ---------- " + passwd1);
		if (username.equals("") || password.equals("")) {// using ==null dosen‘t
															// work here
															// sometime
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