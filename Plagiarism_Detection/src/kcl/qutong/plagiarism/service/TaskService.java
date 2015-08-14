package kcl.qutong.plagiarism.service;

import kcl.qutong.plagiarism.dao.pojo.Task;

public interface TaskService {
	public void addTask(Task taskBean);
	public void updateUser(Task taskBean);
}
