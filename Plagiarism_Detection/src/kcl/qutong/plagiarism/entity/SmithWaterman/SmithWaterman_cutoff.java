package kcl.qutong.plagiarism.entity.SmithWaterman;

import java.util.ArrayList;
import java.util.List;

/**
 * this is revise version of smith waterman algorithm
 * 
 * @author qutong
 * 
 */
public class SmithWaterman_cutoff extends BasicSmithWaterman {
	private int score; // represent the "goodness of fit"
	private int m;// length of string X
	private int n;// length of string Y
	private int h;// hits
	private int d;// delete of insert
	private int r;// replace
	private int v;// threshold
	String[] X;
	String[] Y;
	List<String> preX = new ArrayList<String>();
	List<String> preY = new ArrayList<String>();
	int[][] s;// score matrix
	int[][] M;// matrix store largest value value before this point except
				// itself.
	point max = new point();
	cell origil = new cell();
	cell Mij = new cell();
	List<cell> candidateSet = new ArrayList<cell>();
	cell[] backTrace;
	SmithWaterman_overlap swo = new SmithWaterman_overlap();

	public String[] result(String[] srcArray, String[] trgArray, int threshold) {
		cell start;
		cell end;
		String old_pairs = "";
		String pairs = "";
		calScoreMatrix(srcArray, trgArray, threshold);
		System.out.println("enter smithwaterman");
		for (int n = 0; n < candidateSet.size()/2; n++) {
			start = candidateSet.get(2 * n);
			end = candidateSet.get(2 * n + 1);
			System.out.println(old_pairs);
			old_pairs = old_pairs + "[" + start.getX() + "," + end.getX() + "]&["
					+ start.getY() + "," + end.getY() + "]#";
		}
		String[] mix = new String[4];
			
		// delete useless overlap
		candidateSet=swo.removeSameOrigil(candidateSet,s);// overlap is allowed,but we need to find pairs with same origil
		System.out.println("after remove");
		for (int n = 0; n < candidateSet.size()/2; n++) {
			start = candidateSet.get(2 * n);
			end = candidateSet.get(2 * n + 1);
			System.out.println(pairs);
			pairs = pairs + "[" + start.getX() + "," + end.getX() + "]&["
					+ start.getY() + "," + end.getY() + "]#";
		}
		mix[0] = String.valueOf(max.getValue());
		mix[1] = pairs;
		mix[2] = "src";
		mix[3] = "trg";
		return mix;
	}

	public void calScoreMatrix(String[] srcArray, String[] trgArray,
			int threshold) {
		// public void calScoreMatrix(char[] srcArray, char[] trgArray) {
		m = srcArray.length;
		n = trgArray.length;
		v = threshold = 3;// need to be changed
		preX.add("0");
		preY.add("0");
		h = d = r = 1;
		max.setValue(0);
		System.out.println("m: " + m + " n: " + n);
		// make the first column is zero
		s = new int[m + 1][n + 1];
		M = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			preX.add(srcArray[i]);
			s[i][0] = 0;
			M[i][0] = 0;
		}
		// make the first row is zero
		for (int j = 0; j < n; j++) {
			preY.add(trgArray[j]);
			s[0][j] = 0;
			M[0][j] = 0;
		}

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
					// calculate Mij
					if (s[i][j] == 0) {
						M[i][j] = 0;
					} else {
						M[i][j] = Math.max(s[i - 1][j - 1], M[i - 1][j - 1]);
					}
				} else {

					s[i][j] = Math.max(
							0,
							Math.max(
									s[i - 1][j] - d,
									Math.max(s[i][j - 1] - d, s[i - 1][j - 1]
											- r)));
					// calculate Mij
					if (s[i][j] == 0) {
						M[i][j] = 0;
					} else {
						M[i][j] = Math
								.max(M[i - 1][j - 1], Math.max(M[i][j - 1],
										Math.max(M[i - 1][j], Math.max(
												s[i - 1][j], Math.max(
														s[i][j - 1],
														s[i - 1][j - 1])))));
					}

				}
				// set up candidate set. s will be set zero if its' Mij-Sij>v
				// M will be choosen when Mij<Sij and Sij>v
				if (M[i][j] - s[i][j] >= v) {
					// System.out.println("M"+i+","+j+" is: "+M[i][j]+" S"+i+","+j+"is: "+s[i][j]);
					// traceback(s, i, j);
					s[i][j] = 0;// this should after traceback here, coz
					M[i][j] = 0;
				} else if (s[i][j] >= v && M[i][j] < s[i][j]) {
					System.out.println("M" + i + "," + j + " is: " + M[i][j]
							+ " S" + i + "," + j + "is: " + s[i][j]);
					traceback(s, i, j);// if a state isn't pre-dominated and
										// larger than v
				}
			}
		}
	}

	/**
	 * this method will traceback from current state
	 * 
	 * @param score
	 * @param i
	 * @param j
	 */
	public void traceback(int[][] score, int i, int j) {
		Mij = new cell();
		origil = new cell();
		Mij.setX(i);
		Mij.setY(j);
		Mij.setValue(s[i][j]);
		while (s[i][j] != 0) {
			if (X[i].equalsIgnoreCase(Y[j])) {
				// if (X[i]==Y[j]) {
				i--;
				j--;
			} else if (s[i][j] == s[i][j - 1] - 1) {
				j--;
			} else {
				i--;
			}
			origil.setX(i + 1);
			origil.setY(j + 1);
			// state with largest value in the path trace back
			if (Mij.getValue() <= s[i][j]) {
				System.out.println("Mij is: " + Mij.getValue() + "Sij is"
						+ s[i][j]);
				Mij.setValue(s[i][j]);
				Mij.setX(i);
				Mij.setY(j);
			} else {

			}
		}
		// 2n will be the position of similarity start and 2n+1 is end
		// System.out.println("similiari pair start with state ("+origil.getX()+","+origil.getY()+")  and end at("+Mij.getX()+","+Mij.getY()+") with ");
		// System.out.println("similiari pair are ("+origil.getX()+","+Mij.getX()+") in X and ("+origil.getY()+","+Mij.getY()+") in Y");
		candidateSet.add(origil);
		candidateSet.add(Mij);
	}

}