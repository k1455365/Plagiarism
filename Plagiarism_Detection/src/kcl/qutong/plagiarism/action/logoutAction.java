package kcl.qutong.plagiarism.action;

import org.apache.struts2.ServletActionContext;
/**
 * can't stop logout simply jump to a new start page,
 * it should stop the session
 * @author qutong
 *
 */
public class logoutAction {
	public String execute() throws Exception
	{

		ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
}
