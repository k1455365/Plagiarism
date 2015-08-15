package kcl.qutong.plagiarism.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import kcl.qutong.plagiarism.dao.TaskDAO;
import kcl.qutong.plagiarism.dao.pojo.Task;

public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO{

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(task);
		System.out.println("save user successfully store "+task.getTaskname()+"into database");
	}

}
