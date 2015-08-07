package kcl.qutong.plagiarism.action;


import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		Map<String, Object> map = ActionContext.getContext().getSession();
		String username = (String) map.get("username");
		System.out.println("The user'name is ---------- " + username);
		return SUCCESS;
	}
}