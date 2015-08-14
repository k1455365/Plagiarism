package kcl.qutong.plagiarism.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import kcl.qutong.plagiarism.dao.UserDAO;
import kcl.qutong.plagiarism.dao.pojo.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{
	public void addUser(User user) {
		// TODO Auto-generated method stub	
		getHibernateTemplate().save(user);
		System.out.println("save user successfully store "+user.getUsername()+"into database");
	}

	@Override
	public User findUserByName(final  String name) {
		// TODO Auto-generated method stub
		User ub = (User)getHibernateTemplate().execute(
				new HibernateCallback() {public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				org.hibernate.Query query = session.createQuery("from User u where u.username= '"+name+"'");
				return query.list().get(0);
			}
		});
		return ub;
	}
}
