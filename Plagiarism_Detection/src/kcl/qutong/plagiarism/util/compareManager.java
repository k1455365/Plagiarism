package kcl.qutong.plagiarism.util;

import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWatermanArray;

public class compareManager {
	SmithWatermanArray swa =new SmithWatermanArray();
public  String[] compareTool(String srcContent, String trgContent, int taskway){
//	String[] mixResult={"similarity","details","src content after process","trg content after process"};
	//String[] mixResult={"11","[1,3]&[3,6]#[4,9]&[6,8]","src content after process","trg content after process"};
	String[] mixResult=swa.result(srcContent, trgContent);
	return mixResult;
}
}
