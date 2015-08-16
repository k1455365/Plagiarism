package kcl.qutong.plagiarism.service;

import java.util.List;

import kcl.qutong.plagiarism.dao.pojo.Task;

public interface TaskService {
	public void addTask(Task taskBean);
	public void updateTask(Task taskBean);
	public List<Task> findTasksbyUser(String username);
}
