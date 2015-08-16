package kcl.qutong.plagiarism.service;

import java.util.List;

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
		taskDAO.addTask(taskBean);
	}

	@Override
	public void updateTask(Task taskBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Task> findTasksbyUser(String username) {
		// TODO Auto-generated method stub
		List<Task> list =taskDAO.findTasksbyUser(username);
		return list;
	}

}
