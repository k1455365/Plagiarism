package kcl.qutong.plagiarism.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import kcl.qutong.plagiarism.dao.pojo.Task;
import kcl.qutong.plagiarism.dao.pojo.User;
import kcl.qutong.plagiarism.service.TaskService;
import kcl.qutong.plagiarism.util.SaveUploadFile;
import kcl.qutong.plagiarism.util.contentReader;

/**
 * this class used to show result from task list
 * 
 * @author qutong
 * 
 */
public class showTaskResult {
	TaskService taskService;
	private Task task;
	private int taskid;
	private int way;
	private String srcdir;
	private String trgdir;
	private Timestamp tasktime;
	private String taskway;// identify java or text type or token
	private User u;
	private int algorithm;
	private int tokensize;
	private int threshold;
	private int hits;
	private int indel;
	private int insert;
	private File fst, sec;
	private String srccontent;
	private String trgcontent;
	private String srcfile;
	private String trgfile;
	private String Textresult;
	private String textsim;
	public String getSrccontent() {
		return srccontent;
	}

	public void setSrccontent(String srccontent) {
		this.srccontent = srccontent;
	}

	public String getTrgcontent() {
		return trgcontent;
	}

	public void setTrgcontent(String trgcontent) {
		this.trgcontent = trgcontent;
	}

	public String getSrcfile() {
		return srcfile;
	}

	public void setSrcfile(String srcfile) {
		this.srcfile = srcfile;
	}

	public String getTrgfile() {
		return trgfile;
	}

	public void setTrgfile(String trgfile) {
		this.trgfile = trgfile;
	}

	public String getTextresult() {
		return Textresult;
	}

	public void setTextresult(String textresult) {
		Textresult = textresult;
	}

	public String getTextsim() {
		return textsim;
	}

	public void setTextsim(String textsim) {
		this.textsim = textsim;
	}


	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}



	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public int getWay() {
		return way;
	}

	public void setWay(int way) {
		this.way = way;
	}

	public String getSrcdir() {
		return srcdir;
	}

	public void setSrcdir(String srcdir) {
		this.srcdir = srcdir;
	}

	public String getTrgdir() {
		return trgdir;
	}

	public void setTrgdir(String trgdir) {
		this.trgdir = trgdir;
	}

	public Timestamp getTasktime() {
		return tasktime;
	}

	public void setTasktime(Timestamp tasktime) {
		this.tasktime = tasktime;
	}

	public String getTaskway() {
		return taskway;
	}

	public void setTaskway(String taskway) {
		this.taskway = taskway;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public int getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(int algorithm) {
		this.algorithm = algorithm;
	}

	public int getTokensize() {
		return tokensize;
	}

	public void setTokensize(int tokensize) {
		this.tokensize = tokensize;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getIndel() {
		return indel;
	}

	public void setIndel(int indel) {
		this.indel = indel;
	}

	public int getInsert() {
		return insert;
	}

	public void setInsert(int insert) {
		this.insert = insert;
	}

	public File getFst() {
		return fst;
	}

	public void setFst(File fst) {
		this.fst = fst;
	}

	public File getSec() {
		return sec;
	}

	public void setSec(File sec) {
		this.sec = sec;
	}

	public String execute() throws Exception {
		task = taskService.findTaskbyID(taskid);
		setTask(task);
		taskway = task.getTaskway();
		System.out.println("taskway: "+taskway);
		if (taskway == "text") {
			way = 1;
		} else if (taskway == "java") {
			way = 2;
		} else {
			way = 3;
		}
		// get file information
		srcdir = task.getSrcdir();
		trgdir = task.getTrgdir();
		fst = new File(srcdir);
		sec = new File(trgdir);
		/*-------------------------- read files based on the type of files, java or text---------------------------------*/
		contentReader cr = new contentReader();
		String Content1 = cr.readerManage(way, fst, srcdir);
//		System.out
//				.println("-------------------------content of first file is: \n"
//						+ Content1);
		String Content2 = cr.readerManage(way, sec, trgdir);
//		System.out
//				.println("-------------------------content of second file is: \n"
//						+ Content2);
		setSrccontent(Content1);// without process currect version hence using
								// the original content directly
		setTrgcontent(Content2);
		setSrcfile(srcdir);
		setTrgfile(trgdir);
		setTextsim("33");// score between two pages
		setTextresult(task.getResult());// similiar pairs
		// return result to corresponding pages
		if (taskway.equalsIgnoreCase("text")) {
			return "text";
		} else if (taskway.equalsIgnoreCase("code")) {
			return "code";
		} else if (taskway.equalsIgnoreCase("token")) {
			return "token";
		} else {
			return "error";
		}
	}
}
