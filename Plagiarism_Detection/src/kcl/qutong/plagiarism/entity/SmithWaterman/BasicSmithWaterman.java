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
	// char[] X;
	// char[] Y;
	List<String> preX = new ArrayList<String>();
	List<String> preY = new ArrayList<String>();
	int[][] s;// score matrix
	point max = new point();
	cell backPoint = new cell();
	List<cell> path = new ArrayList<cell>();
	cell[] backTrace;

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
		
		for (int i = 0; i < m+1; i++) {
			s[i][0] = 0;
		}
		// make the first row is zero
		for (int j = 0; j < n+1; j++) {
			s[0][j] = 0;
		}
		X = preX.toArray(new String[1]);
		Y = preY.toArray(new String[1]);
		// start from 1 is because previous work hence the result could be
		// negative
		System.out.println("m=" + m);
		System.out.println("n=" + n);
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("i=" + i + " j=" + j);
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
		}
	}

	void printMatrix() {
		System.out.print("D =       ");
		for (int i = 0; i < Y.length; i++) {
			System.out.print(String.format("%4c ", Y[i]));
		}
		System.out.println();
		for (int i = 0; i < X.length + 1; i++) {
			if (i > 0) {
				System.out.print(String.format("%4c ", X[i - 1]));
			} else {
				System.out.print("     ");
			}
			for (int j = 0; j < Y.length + 1; j++) {
				System.out.print(String.format("%4d ", s[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] a) {
		String a1 = "a b c x d e f g h i y m z j l u k p q s j t u v";
		String b = "a b c d e f g h i j k l m n o p q r s j t u v";
		// String a1="abcxdefghiymzjlukpqsjtuv";
		// String b="abcdefghijklmnopqrsjtuv";
		// char[] seqA =a1.toCharArray();
		// char[] seqB =b.toCharArray();
		String[] seqA = a1.split(" ");
		String[] seqB = b.split(" ");
		BasicSmithWaterman aa = new BasicSmithWaterman();
		aa.calScoreMatrix(seqA, seqB);
		aa.traceback();
	}
}
