package kcl.qutong.plagiarism.service;

import kcl.qutong.plagiarism.dao.UserDAO;
import kcl.qutong.plagiarism.dao.pojo.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;


	public UserDAO getUserDAO() {
		return userDAO;
	}



	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public void addUser(User userBean) {
		// TODO Auto-generated method stub
		userDAO.addUser(userBean);
	}



	@Override
	public void updateUser(User userBean) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return userDAO.findUserByName(username);
	}

}
