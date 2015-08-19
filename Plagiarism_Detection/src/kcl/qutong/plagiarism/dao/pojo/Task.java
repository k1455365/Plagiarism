package kcl.qutong.plagiarism.dao.pojo;

import java.sql.Timestamp;

public class Task {
	private int id;
	private String taskname;
	private String algorithm;
	private String tokensize;
	private String taskway;
	private String result;
	private String srcdir;
	private String trgdir;
	private String creator;
	private Timestamp tasktime;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTaskway() {
		return taskway;
	}
	public void setTaskway(String taskway) {
		this.taskway = taskway;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getTokensize() {
		return tokensize;
	}
	public void setTokensize(String tokensize) {
		this.tokensize = tokensize;
	}

}
