package kcl.qutong.plagiarism.dao.pojo;

import java.sql.Timestamp;
/**
 * eneity class of task
 * @author qutong
 *
 */
public class Task {
	private int id;
	private String taskname;
	private String algorithm;
	private int threshold;
	private int hits;
	private int indel;
	private int replacement;
	private String tokensize;
	private String taskway;
	private String score;
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
	public int getReplacement() {
		return replacement;
	}
	public void setReplacement(int replacement) {
		this.replacement = replacement;
	}

}
