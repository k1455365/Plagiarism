package kcl.qutong.plagiarism.entity.SmithWaterman;

import java.util.ArrayList;
import java.util.List;

public class SmithWaterman_overlap {
	List<cell> candidateSet = new ArrayList<cell>();
	String[] X;// row in score matrix
	String[] Y;// column in score matrix
	int[][] s;// score matrix
	int[][] M;// matrix store largest value value before this point except
				// itself.
	int[][] overlap;// size as score matrix and use 0 mark may cause overlap
					// parts and 1 present avaliable are
	int v = 3;// threshold
	List<String> preX = new ArrayList<String>();
	List<String> preY = new ArrayList<String>();
	cell origil = new cell();
	cell Mij = new cell();

	public void initialMatrix(String[] srcArray, String[] trgArray) {
		int m = srcArray.length;
		int n = trgArray.length;
		preX.add("0");//
		preY.add("0");// cause the first may use value of parents
		// System.out.println("m: " + m + " n: " + n);
		// make the first column is zero
		s = new int[m + 1][n + 1];
		M = new int[m + 1][n + 1];
		overlap = new int[m + 1][n + 1];
		// initial s and M makes them first row and column is zero
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
		// initial overlap makes it with all 1
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				overlap[i][j] = 1;
			}
		}

		X = preX.toArray(new String[1]);//
		Y = preY.toArray(new String[1]);// transfer them into String Array
		System.out
				.println("************************************finish initial************************************");
	}

	public boolean judgeOverlap(cell a, cell b, cell c, cell d) {
		boolean flag = true;
		// while candiadte set not empty{
		// choose largest
		// compare delete overlap
		// }
		return flag;
	}

	/**
	 * calculate score matrix and M in the same time. it will be called many
	 * times
	 */
	public void calScoreMatrix() {
		System.out
				.println("************************************calculating score matrix************************************");
		int m = X.length - 1;
		int n = Y.length - 1;
		int h, d, r;
		h = d = r = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (overlap[i][j] != 0) {// is not zero mean this state is
											// avaliable to calculate
					// System.out.println("i=" + i + " j=" + j);
					if (X[i].equalsIgnoreCase(Y[j])) {
						// if (X[i-1]==Y[j-1]) {
						s[i][j] = s[i - 1][j - 1] + h;
						// calculate Mij
						if (s[i][j] == 0) {
							M[i][j] = 0;
						} else {
							M[i][j] = Math
									.max(s[i - 1][j - 1], M[i - 1][j - 1]);
						}
					} else {

						s[i][j] = Math.max(
								0,
								Math.max(s[i - 1][j] - d, Math.max(s[i][j - 1]
										- d, s[i - 1][j - 1] - r)));
						// calculate Mij
						if (s[i][j] == 0) {
							M[i][j] = 0;
						} else {
							M[i][j] = Math.max(M[i - 1][j - 1], Math.max(
									M[i][j - 1], Math.max(M[i - 1][j], Math
											.max(s[i - 1][j], Math.max(
													s[i][j - 1],
													s[i - 1][j - 1])))));
						}

					}
					// set up candidate set. s will be set zero if its'
					// Mij-Sij>v
					// M will be choosen when Mij<Sij and Sij>v
					if (M[i][j] - s[i][j] >= v) {
						System.out.println("M" + i + "," + j + " is: "
								+ M[i][j] + " S" + i + "," + j + "is: "
								+ s[i][j]);
						// traceback(s, i, j);
						s[i][j] = 0;// this should after traceback here, coz
						M[i][j] = 0;
					} else if (s[i][j] >= v && M[i][j] < s[i][j]) {
						System.out.println("M" + i + "," + j + " is: "
								+ M[i][j] + " S" + i + "," + j + "is: "
								+ s[i][j]);
						traceback(s, i, j);// if a state isn't pre-dominated and
											// larger than v
					}
				} else {
					continue;
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
		System.out
				.println("************************************Trace Back************************************");

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
		candidateSet.add(origil);// first is origil of this alighment 2n
		candidateSet.add(Mij);// second is end of this alighment 2n+1
	}

	/**
	 * read in candidate list of all potential alighments and remove ones have
	 * same origil left the largest score
	 * 
	 * @param oldSet
	 * @param scoreMatrix
	 * @return
	 */
	public List<cell> removeSameOrigil(List<cell> oldSet, int[][] scoreMatrix) {
		int[][] s = scoreMatrix;
		System.out.println("enter remove: " + oldSet.size());
		cell start;
		cell end;
		cell next_start;
		cell next_end;
		int candidateSize = 0;
		System.out.println("previous size is: " + candidateSize);
		while (oldSet.size() - candidateSize != 0) {
			candidateSize = oldSet.size();
			System.out.println("size now is: " + oldSet.size());
			for (int n = 0; n < oldSet.size() / 2 - 1; n++) {// should minus 1
																// here,
																// consider
																// remove isuue
				System.out.println("enter remove for: " + n);
				start = oldSet.get(2 * n);
				end = oldSet.get(2 * n + 1);
				next_start = oldSet.get(2 * (n + 1));
				next_end = oldSet.get(2 * (n + 1) + 1);
				if (start.getX() == next_start.getX()
						&& start.getY() == next_start.getY()) {
					// if
					// (end.getX()<=next_end.getX()&&end.getY()<=next_end.getY()){
					if (s[next_end.getX()][next_end.getY()] > s[end.getX()][end
							.getY()]) {
						System.out.println("S " + next_end.getX() + ","
								+ next_end.getY() + ">S" + end.getX() + ","
								+ end.getY());
						oldSet.remove(2 * n);
						oldSet.remove(2 * n);
					} else {
						oldSet.remove(2 * (n + 1));
						oldSet.remove(2 * (n + 1));
					}
					// }
				} else {
					System.out.println("S " + next_end.getX() + ","
							+ next_end.getY() + "different origil with S"
							+ end.getX() + "," + end.getY());
				}
			}
		}
		return oldSet;
	}

	/**
	 * calculate final score
	 * 
	 * @param sMatrix
	 *            score matrix
	 * @param a
	 *            final candidate set without same origil and overlaps
	 * @return result in string type
	 */
	public String calScore(int[][] sMatrix, List<cell> a) {
		int scoreInt = 0;
		for (int n = 0; n < a.size() / 2; n++) {
			cell end = a.get(2 * n + 1);
			scoreInt = scoreInt + sMatrix[end.getX()][end.getY()];
		}
		return String.valueOf(scoreInt);
	}

	/**
	 * remove overlap portion from candidate set, we cant decide which
	 * combination is best, hence we just choose the larger one from two overlap
	 * protins; once one portion's origil is larger than others end, they dont
	 * have overlap
	 * 
	 * @param oldSet
	 * @param scoreMatrix
	 * @param overlapo
	 * @return
	 */
	public List<cell> removeOverlap(List<cell> oldSet, int[][] scoreMatrix,
			int[][] overlapo) {
		int candidateSize = 0;
		cell start;
		cell end;
		cell next_start;
		cell next_end;
		System.out.println("remove overlap method previous size is: "
				+ candidateSize);
		while (candidateSet.size() - candidateSize != 0) {
			candidateSize = candidateSet.size();
			System.out.println("size now is: " + candidateSet.size());
			for (int n = 0; n < candidateSet.size() / 2 - 1; n++) {// should
																	// minus 1
																	// here,
																	// consider
																	// remove
																	// isuue
				System.out.println("enter remove for: " + n);
				start = candidateSet.get(2 * n);
				end = candidateSet.get(2 * n + 1);
				next_start = candidateSet.get(2 * (n + 1));
				next_end = candidateSet.get(2 * (n + 1) + 1);
				if ((next_start.getX() > end.getX() && next_start.getY() > end
						.getY())
						|| (start.getX() > next_end.getX() && start.getY() > next_end
								.getY())) {
					System.out.println("S " + next_end.getX() + ","
							+ next_end.getY() + "is no overlap with "
							+ end.getX() + "," + end.getY());
					// if
					// (end.getX()<=next_end.getX()&&end.getY()<=next_end.getY()){

					// }
				} else {
					System.out.println("S " + next_end.getX() + ","
							+ next_end.getY() + "is overlap with "
							+ end.getX() + "," + end.getY());
					if (s[next_end.getX()][next_end.getY()] > s[end.getX()][end
							.getY()]) {
						System.out.println("S " + next_end.getX() + ","
								+ next_end.getY() + ">S" + end.getX() + ","
								+ end.getY());
						markOverlap(start, end);
						candidateSet.remove(2 * n);
						candidateSet.remove(2 * n);
					} else {
						markOverlap(next_start, next_end);
						candidateSet.remove(2 * (n + 1));
						candidateSet.remove(2 * (n + 1));
					}
				}
			}
		}
		return candidateSet;
	}

	public void markOverlap(cell start, cell end) {
		for (int i = start.getX(); i <= end.getX(); i++) {
			for (int j = start.getY(); j <= end.getY(); j++) {
				overlap[i][j] = 1;
			}
		}
	}

	/**
	 * organize result as required format
	 * 
	 * @param srcArray
	 * @param trgArray
	 * @param threshold
	 * @return
	 */

	public String[] result(String[] srcArray, String[] trgArray, int threshold) {
		String[] mix = null ;
		cell start;
		cell end;
		String pairs = "";
		initialMatrix(srcArray, trgArray);
//		calScoreMatrix();
//		candidateSet = removeSameOrigil(candidateSet, s);
//		candidateSet = removeOverlap(candidateSet, s, overlap);
		int candidateSize = 100;
		System.out.println("previous size is: " + candidateSize);
		while (candidateSet.size() - candidateSize != 0) {// while candidate set
															// is not change
															// present all the
															// matrix has been
															// processed
			//candidateSize = candidateSet.size();
			calScoreMatrix();
			candidateSet = removeSameOrigil(candidateSet, s);
			candidateSet = removeOverlap(candidateSet, s, overlap);// not really
																	// use
																	// insert
																	// params
			candidateSize = candidateSet.size();
		}
		System.out.println("after remove");
		for (int n = 0; n < candidateSet.size() / 2; n++) {
			start = candidateSet.get(2 * n);
			end = candidateSet.get(2 * n + 1);
			System.out.println(pairs);
			pairs = pairs + "[" + start.getX() + "," + end.getX() + "]&["
					+ start.getY() + "," + end.getY() + "]#";
		}

		System.out.println("final result is : " + pairs);
		System.out.println("final score is : " + calScore(s, candidateSet));
		
		mix[0] = calScore(s, candidateSet);
		mix[1] = pairs;
		mix[2] = "src";
		mix[3] = "trg";
		return mix;
	}
}
