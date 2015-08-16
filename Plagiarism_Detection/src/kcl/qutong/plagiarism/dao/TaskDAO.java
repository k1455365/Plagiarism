package kcl.qutong.plagiarism.dao;

import java.util.List;

import kcl.qutong.plagiarism.dao.pojo.Task;

public interface TaskDAO {

	void addTask(Task task);

	public List<Task> findTasksbyUser(String username);

}
