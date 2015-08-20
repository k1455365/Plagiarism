package kcl.qutong.plagiarism.util;

import kcl.qutong.plagiarism.entity.SmithWaterman.BasicSmithWaterman;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWatermanArray;

public class compareManager {
	String[] mixResult;
	SmithWatermanArray swa = new SmithWatermanArray();
	BasicSmithWaterman bsw =new BasicSmithWaterman();
	public String[] compareTool(String srcContent, String trgContent,
			int taskway) {
		// String[]
		// mixResult={"similarity","details","src content after process","trg content after process"};
		// String[]
		// mixResult={"11","[1,3]&[3,6]#[4,9]&[6,8]","src content after process","trg content after process"};

		if (taskway == 3) {
			mixResult = swa.result(srcContent, trgContent);
		} else {
			System.out.println("enter text compare");
			mixResult = bsw.result(srcContent, trgContent);
		}

		return mixResult;
	}
}
