package kcl.qutong.plagiarism.dao;

import kcl.qutong.plagiarism.dao.pojo.User;


public interface UserDAO {
	public void addUser(User userBean);
	public User findUserByName(String name);
}
