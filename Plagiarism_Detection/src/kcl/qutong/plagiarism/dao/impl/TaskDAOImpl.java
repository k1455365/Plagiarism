package kcl.qutong.plagiarism.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import kcl.qutong.plagiarism.dao.TaskDAO;
import kcl.qutong.plagiarism.dao.pojo.Task;

public class TaskDAOImpl extends HibernateDaoSupport implements TaskDAO {

	@Override
	public void addTask(Task task) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(task);
		System.out.println("save user successfully store " + task.getTaskname()
				+ "into database");
	}

	public List<Task> findTasksbyUser(final String username) {
		List<Task> list = (List<Task>) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						org.hibernate.Query query = session
								.createQuery("from Task t where t.creator= '"
										+ username + "'");

						return query.list();
					}
				});
		return list;
	}

	public Task findTaskbyID(final int id) {
		Task task = (Task) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						org.hibernate.Query query = session
								.createQuery("from Task t where t.id= '" + id
										+ "'");

						if (query.list().size() != 0) {
							return query.list().get(0);
						}
						return null;
					}
				});
		return task;
	}
}
