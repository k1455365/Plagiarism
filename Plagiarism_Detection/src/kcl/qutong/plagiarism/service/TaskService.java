package kcl.qutong.plagiarism.service;

import java.util.List;

import kcl.qutong.plagiarism.dao.pojo.Task;
/**
 * interface class for TaskService
 * @author qutong
 *
 */
public interface TaskService {
	public void addTask(Task taskBean);
	public void updateTask(Task taskBean);
	public List<Task> findTasksbyUser(String username);
	public Task findTaskbyID(int id);
}
