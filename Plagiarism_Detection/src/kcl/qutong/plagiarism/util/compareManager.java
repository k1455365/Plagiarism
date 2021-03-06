package kcl.qutong.plagiarism.util;

import kcl.qutong.plagiarism.entity.SmithWaterman.BasicSmithWaterman;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWatermanArray;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWaterman_cutoff;
import kcl.qutong.plagiarism.entity.SmithWaterman.SmithWaterman_overlap;
/**
 * assign task to corresponding algorithm 
 * @author qutong
 *
 */
public class compareManager {
	String[] mixResult;
	SmithWatermanArray swa = new SmithWatermanArray();
	BasicSmithWaterman bsw = new BasicSmithWaterman();
	SmithWaterman_cutoff swc = new SmithWaterman_cutoff();
	SmithWaterman_overlap swo=new SmithWaterman_overlap();

	public String[] compareTool(String srcContent, String trgContent,
			int taskway, int algorithm,int threshold,int hits,int indel,int replacement) {
		System.out.println(hits+","+indel+","+replacement);
		switch (algorithm) {
		case 1: {
			switch (taskway) {
			case 1: {

				System.out
						.println("enter text compare using basic smith waterman algorithm");
				String[] srcArray = srcContent.split(" ");
				String[] trgArray = trgContent.split(" ");
				mixResult = bsw.result(srcArray, trgArray);
				break;
			}
			case 2: {
				System.out
						.println("enter code compare using basic smith waterman algorithm");
				String[] srcArray = srcContent.split("\n");
				String[] trgArray = trgContent.split("\n");
				mixResult = bsw.result(srcArray, trgArray);
				break;
			}
			case 3: {
				System.out
						.println("enter token compare using basic smith waterman algorithm");
				mixResult = swa.result(srcContent, trgContent);
				break;
			}
			}
			break;
		}
		// smith waterman cutoff algorithm
		case 2: {
			switch (taskway) {
			case 1: {

				System.out
						.println("enter text compare using smith waterman cutoff algorithm");
				String[] srcArray = srcContent.split(" ");
				String[] trgArray = trgContent.split(" ");
				mixResult = swc.result(srcArray, trgArray,threshold,hits,indel,replacement);
				break;
			}
			case 2: {
				System.out
						.println("enter code compare using smith waterman cutoff algorithm");
				String[] srcArray = srcContent.split("\n");
				String[] trgArray = trgContent.split("\n");
				mixResult = swc.result(srcArray, trgArray,threshold,hits,indel,replacement);
				break;
			}
			case 3: {
				System.out
						.println("enter token compare using basic smith waterman algorithm");
				mixResult = swa.result(srcContent, trgContent);
				break;
			}
			}
			break;
		}
		// smith waterman without overlap
		case 3: {
			switch (taskway) {
			case 1: {

				System.out
						.println("enter text compare using smith waterman without overlap algorithm");
				String[] srcArray = srcContent.split(" ");
				String[] trgArray = trgContent.split(" ");
				mixResult = swo.result(srcArray, trgArray,threshold,hits,indel,replacement);
				break;
			}
			case 2: {
				System.out
						.println("enter code compare using  smith waterman without overlap algorithm");
				String[] srcArray = srcContent.split("\n");
				String[] trgArray = trgContent.split("\n");
				mixResult = swo.result(srcArray, trgArray,threshold,hits,indel,replacement);
				break;
			}
			case 3: {
				System.out
						.println("enter token compare using smith waterman without overlap algorithm");
				mixResult = swa.result(srcContent, trgContent);
				break;
			}
			}
			break;
		}
		}

		return mixResult;
	}
}
