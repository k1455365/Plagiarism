package kcl.qutong.plagiarism.util;
/**
 * parse content from request
 * @author qutong
 *
 */
public class taskContentProcess {
public static String judgeTaskWay(int taskway){
	String result="text";
	switch (taskway) {
	case 1:
		result="text";
		break;
	case 2:
		result="java";
		break;
	case 3:
		result="character";
		break;
	}
	return result;
}
public static String judgeAlgorithm(int algorithm){
	String result="Basic Smith-Waterman";
	switch (algorithm) {
	case 1:
		result="Basic Smith-Waterman";
		break;
	case 2:
		result="Smith-Waterman with cut-off";
		break;
	case 3:
		result="Smith-Waterman without verlap";
		break;
	}
	return result;
}
public static String judgeTokenSize(int tokenSize){
	String result="word";
	switch (tokenSize) {
	case 1:
		result="word";
		break;
	case 2:
		result="line";
		break;
	}
	return result;
}
}
