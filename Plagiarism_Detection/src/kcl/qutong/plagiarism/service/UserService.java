package kcl.qutong.plagiarism.service;

import kcl.qutong.plagiarism.dao.pojo.User;

public interface UserService {
	public void addUser(User userBean);
	public void updateUser(User userBean);
	public User findUser(String username);
}
