package kcl.qutong.plagiarism.util;

import kcl.qutong.plagiarism.entity.SmithWaterman.BasicSmithWaterman;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWatermanArray;

public class compareManager {
	String[] mixResult;
	SmithWatermanArray swa = new SmithWatermanArray();
	BasicSmithWaterman bsw = new BasicSmithWaterman();

	public String[] compareTool(String srcContent, String trgContent,
			int taskway, int algorithm) {
		// String[]
		// mixResult={"similarity","details","src content after process","trg content after process"};
		// String[]
		// mixResult={"11","[1,3]&[3,6]#[4,9]&[6,8]","src content after process","trg content after process"};
		switch (taskway) {
		case 1: {

			System.out
					.println("enter text compare using basic smith waterman algorithm");
			mixResult = bsw.result(srcContent, trgContent);
			break;
		}
		case 2: {
			System.out
					.println("enter code compare using basic smith waterman algorithm");
			break;
		}
		case 3: {
			System.out
					.println("enter token compare using basic smith waterman algorithm");
			mixResult = swa.result(srcContent, trgContent);
			break;
		}
		}
		return mixResult;
	}
}
