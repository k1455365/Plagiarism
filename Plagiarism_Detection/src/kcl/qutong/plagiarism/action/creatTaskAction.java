package kcl.qutong.plagiarism.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import kcl.qutong.plagiarism.dao.pojo.Task;
import kcl.qutong.plagiarism.dao.pojo.User;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWatermanArray;
import kcl.qutong.plagiarism.service.TaskService;
import kcl.qutong.plagiarism.service.UserService;
import kcl.qutong.plagiarism.util.SaveUploadFile;
import kcl.qutong.plagiarism.util.compareManager;
import kcl.qutong.plagiarism.util.contentReader;
import kcl.qutong.plagiarism.util.taskContentProcess;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This action used to make response to creattask and this is the core class
 * it resturn corresponding value depend on diff task
 * @author qutong
 * 
 */
public class creatTaskAction extends ActionSupport {
	private TaskService taskService;
	private UserService userService;
	private Task taskBean;
	private String username;
	private String taskname;
	private File fst;
	private String fstFileName;
	private String fstContentType;
	private File sec;
	private String secFileName;
	private String secContentType;
	private String srcdir;
	private String trgdir;
	private Timestamp tasktime;
	private int taskway;// identify java or text type or token
	private User u;
	private int algorithm;
	private int tokensize;
	private int threshold;
	private int hits;
	private int indel;
	private int insert;
	// compare needed
	private contentReader cr;
	// result set
	private String srccontent;
	private String trgcontent;
	private String srcfile;
	private String trgfile;
	private String Textresult;
	private String textsim;
	String[] mixResult;
	String AlignmentA;
	String AlignmentB;

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

	public Task getTaskBean() {
		return taskBean;
	}

	public void setTaskBean(Task taskBean) {
		this.taskBean = taskBean;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public File getFst() {
		return fst;
	}

	public void setFst(File fst) {
		this.fst = fst;
	}

	public String getFstFileName() {
		return fstFileName;
	}

	public void setFstFileName(String fstFileName) {
		this.fstFileName = fstFileName;
	}

	public String getFstContentType() {
		return fstContentType;
	}

	public void setFstContentType(String fstContentType) {
		this.fstContentType = fstContentType;
	}

	public File getSec() {
		return sec;
	}

	public void setSec(File sec) {
		this.sec = sec;
	}

	public String getSecFileName() {
		return secFileName;
	}

	public void setSecFileName(String secFileName) {
		this.secFileName = secFileName;
	}

	public String getSecContentType() {
		return secContentType;
	}

	public void setSecContentType(String secContentType) {
		this.secContentType = secContentType;
	}

	public Timestamp getTasktime() {
		return tasktime;
	}

	public void setTasktime(Timestamp tasktime) {
		this.tasktime = tasktime;
	}

	public int getTaskway() {
		return taskway;
	}

	public void setTaskway(int taskway) {
		this.taskway = taskway;
	}

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

	public String getTextresult() {
		return Textresult;
	}

	public void setTextresult(String textresult) {
		Textresult = textresult;
	}

	public void setTrgfile(String trgfile) {
		this.trgfile = trgfile;
	}

	public String getTextsim() {
		return textsim;
	}

	public void setTextsim(String textsim) {
		this.textsim = textsim;
	}

	// getter setter for result

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

	public String getAlignmentA() {
		return AlignmentA;
	}

	public void setAlignmentA(String AlignmentA) {
		this.AlignmentA = AlignmentA;
	}

	public String getAlignmentB() {
		return AlignmentB;
	}

	public void setAlignmentB(String AlignmentB) {
		this.AlignmentB = AlignmentB;
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

	public contentReader getCr() {
		return cr;
	}

	public void setCr(contentReader cr) {
		this.cr = cr;
	}

	public String execute() throws Exception {
		srcdir = SaveUploadFile.savefile(fst, fstFileName);
		trgdir = SaveUploadFile.savefile(sec, secFileName);
		/*-------------------------- read files based on the type of files, java or text---------------------------------*/
		cr = new contentReader();
		String Content1 = cr.readerManage(taskway, fst, srcdir);
		System.out
				.println("-------------------------content of first file is: \n"
						+ Content1);
		String Content2 = cr.readerManage(taskway, sec, trgdir);
		System.out
				.println("-------------------------content of second file is: \n"
						+ Content2);
		/*-------------------------- compare contents based on thier tyoe and result mix result---------------------------------*/
		// return result include largest value, similarity, result,
		compareManager cm = new compareManager();
		long startTime=System.currentTimeMillis();
		mixResult = cm.compareTool(Content1, Content2, taskway, algorithm,threshold,hits,indel,insert);
		long endTime=System.currentTimeMillis();
		System.out.println("*************************Runtime : "+(endTime-startTime)+"ms*************************");   
		// store task into database with taskname files directory and result
		taskBean = new Task();
		taskBean.setTaskname(taskname);
		taskBean.setScore(mixResult[0]);
		taskBean.setResult(mixResult[1]);
		taskBean.setSrcdir(srcdir);
		taskBean.setTrgdir(trgdir);
		taskBean.setAlgorithm(taskContentProcess.judgeAlgorithm(algorithm));
		taskBean.setThreshold(threshold);
		taskBean.setHits(hits);
		taskBean.setIndel(indel);
		taskBean.setReplacement(insert);
		taskBean.setTaskway(taskContentProcess.judgeTaskWay(taskway));
		taskBean.setTokensize(taskContentProcess.judgeTokenSize(tokensize));
		taskBean.setTasktime(new Timestamp(System.currentTimeMillis()));
		taskBean.setCreator(username);
		taskService.addTask(taskBean);
		System.out
				.println("-------------------------end-----------------------------");
		setSrccontent(Content1);//without process currect version hence using the original content directly
		setTrgcontent(Content2);
		setSrcfile(srcdir);
		setTrgfile(trgdir);
		setTextsim(mixResult[0]);//score between two pages
		setTextresult(mixResult[1]);//similiar pairs
		// token task special value
		setAlignmentA(mixResult[2]);
		setAlignmentB(mixResult[3]);
		// return result to corresponding pages
		if (taskway == 1) {
			return "text";
		} else if (taskway == 2) {
			return "code";
		} else if (taskway == 3) {
			return "token";
		} else {
			return ERROR;
		}

	}

}
