package kcl.qutong.plagiarism.action;

import org.apache.struts2.ServletActionContext;

public class logoutAction {
	public String execute() throws Exception
	{

		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
}
