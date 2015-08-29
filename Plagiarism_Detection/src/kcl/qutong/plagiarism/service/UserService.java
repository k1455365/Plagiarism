package kcl.qutong.plagiarism.service;

import kcl.qutong.plagiarism.dao.pojo.User;
/**
 * interface of userservice
 * @author qutong
 *
 */
public interface UserService {
	public void addUser(User userBean);
	public void updateUser(User userBean);
	public User findUser(String username);
}
