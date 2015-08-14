package kcl.qutong.plagiarism.service;

import kcl.qutong.plagiarism.dao.TaskDAO;
import kcl.qutong.plagiarism.dao.pojo.Task;

public class TaskServiceImpl implements TaskService {
	private TaskDAO taskDAO;

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public void addTask(Task taskBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(Task taskBean) {
		// TODO Auto-generated method stub

	}

}
