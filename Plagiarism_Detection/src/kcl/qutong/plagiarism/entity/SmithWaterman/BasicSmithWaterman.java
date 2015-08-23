package kcl.qutong.plagiarism.entity.SmithWaterman;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author qutong
 * 
 */
public class BasicSmithWaterman {
	private int score; // represent the "goodness of fit"
	private int m;// length of string X
	private int n;// length of string Y
	private int h;// hits
	private int d;// delete of insert
	private int r;// replace
	String[] X;
	String[] Y;
	List<String> preX = new ArrayList<String>();
	List<String> preY = new ArrayList<String>();
	int[][] s;// score matrix
	point max = new point();
	point origil = new point();
	cell backPoint = new cell();
	List<cell> path = new ArrayList<cell>();
	cell[] backTrace;

	public String[] result(String[] srcArray, String[] trgArray) {
		System.out.println("enter basic smithwaterman");
		String[] mix = new String[4];
		calScoreMatrix(srcArray, trgArray);
		traceback();
		mix[0] = String.valueOf(max.getValue());
		mix[1] = "[" + origil.getX() + "," + max.getX() + "]&[" + origil.getY()
				+ "," + max.getY() + "]#";
		mix[2] = "src";
		mix[3] = "trg";
		return mix;
	}

	public void calScoreMatrix(String[] srcArray, String[] trgArray) {
		// public void calScoreMatrix(char[] srcArray, char[] trgArray) {
		m = srcArray.length;
		n = trgArray.length;
		preX.add("0");
		preY.add("0");
		h = d = r = 1;
		max.setValue(0);

		// make the first column is zero
		s = new int[m + 1][n + 1];

		for (int i = 0; i < m; i++) {
			preX.add(srcArray[i]);
			s[i][0] = 0;
		}
		// make the first row is zero
		for (int j = 0; j < n; j++) {
			preY.add(trgArray[j]);
			s[0][j] = 0;
		}

//		for (int i = 0; i < m + 1; i++) {
//			s[i][0] = 0;
//		}
//		// make the first row is zero
//		for (int j = 0; j < n + 1; j++) {
//			s[0][j] = 0;
//		}
		X = preX.toArray(new String[1]);
		Y = preY.toArray(new String[1]);
		// start from 1 is because previous work hence the result could be
		// negative
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// System.out.println("i=" + i + " j=" + j);
				if (X[i].equalsIgnoreCase(Y[j])) {
					// if (X[i-1]==Y[j-1]) {
					s[i][j] = s[i - 1][j - 1] + h;
				} else {

					s[i][j] = Math.max(
							0,
							Math.max(
									s[i - 1][j] - d,
									Math.max(s[i][j - 1] - d, s[i - 1][j - 1]
											- r)));
				}
				// judge and store the max value and its position
				if (max.getValue() <= s[i][j]) {
					max.setValue(s[i][j]);
					max.setX(i);
					max.setY(j);
				} else {

				}
			}
		}
	}

	public void traceback() {
		int i = max.getX();
		int j = max.getY();
		while (s[i][j] != 0) {
			backPoint.setX(i);
			backPoint.setY(j);
			path.add(backPoint);
			if (X[i].equalsIgnoreCase(Y[j])) {
				// if (X[i]==Y[j]) {
				i--;
				j--;
			} else if (s[i][j] == s[i][j - 1] - 1) {
				j--;
			} else {
				i--;
			}
			origil.setX(i+1);
			origil.setY(j+1);
		}
	}

}
