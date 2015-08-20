package kcl.qutong.plagiarism.entity.SmithWaterman;

public class SmithWatermanArray {
	 char[] mSeqA;
	 char[] mSeqB;
	 int[][] mD;
	 int mScore;
	 String mAlignmentSeqA = "";
	 String mAlignmentSeqB = "";

	// public SmithWatermanArray(String a,String b){
	// char[] seqA =a.toCharArray();
	// char[] seqB =b.toCharArray();
	//
	// init(seqA, seqB);
	// process();
	// backtrack();
	// printMatrix();
	// printScoreAndAlignments();
	// result();
	// }
	public  String[] result(String a, String b) {
		String[] mix = new String[4];
		char[] seqA = a.toCharArray();
		char[] seqB = b.toCharArray();

		init(seqA, seqB);
		process();
		backtrack();
		printMatrix();
		printScoreAndAlignments();
		mix[0] = String.valueOf(mScore);
		mix[1] = "tbd";
		mix[2] = mAlignmentSeqA;
		mix[3] = mAlignmentSeqB;
		return mix;
	}

	 void init(char[] seqA, char[] seqB) {
		mSeqA = seqA;
		mSeqB = seqB;
		mD = new int[mSeqA.length + 1][mSeqB.length + 1];
		for (int i = 0; i <= mSeqA.length; i++) {
			mD[i][0] = 0;
		}
		for (int j = 0; j <= mSeqB.length; j++) {
			mD[0][j] = 0;
		}
	}

	 void process() {
		System.out.println("m=" + mSeqA.length);
		System.out.println("n=" + mSeqB.length);
		for (int i = 1; i <= mSeqA.length; i++) {
			for (int j = 1; j <= mSeqB.length; j++) {
				int scoreDiag = mD[i - 1][j - 1] + weight(i, j);
				int scoreLeft = mD[i][j - 1] - 1;
				int scoreUp = mD[i - 1][j] - 1;
				mD[i][j] = Math.max(
						Math.max(Math.max(scoreDiag, scoreLeft), scoreUp), 0);
			}
		}
	}

	 void backtrack() {
		int i = 1;
		int j = 1;
		int max = mD[i][j];

		for (int k = 1; k <= mSeqA.length; k++) {
			for (int l = 1; l <= mSeqB.length; l++) {
				if (mD[k][l] > max) {
					i = k;
					j = l;
					max = mD[k][l];
				}
			}
		}

		mScore = mD[i][j];

		int k = mSeqA.length;
		int l = mSeqB.length;

		while (k > i) {
			mAlignmentSeqB += "-";
			mAlignmentSeqA += mSeqA[k - 1];
			k--;
		}
		while (l > j) {
			mAlignmentSeqA += "-";
			mAlignmentSeqB += mSeqB[l - 1];
			l--;
		}
		System.out.println("i is: " + i + " j is:" + j);
		while (mD[i][j] != 0) {
			if (mD[i][j] == mD[i - 1][j - 1] + weight(i, j)) {
				mAlignmentSeqA += mSeqA[i - 1];
				mAlignmentSeqB += mSeqB[j - 1];
				i--;
				j--;
				continue;
			} else if (mD[i][j] == mD[i][j - 1] - 1) {
				mAlignmentSeqA += "-";
				mAlignmentSeqB += mSeqB[j - 1];
				j--;
				continue;
			} else {
				mAlignmentSeqA += mSeqA[i - 1];
				mAlignmentSeqB += "-";
				i--;
				continue;
			}
		}

		while (i > 0) {
			mAlignmentSeqB += "-";
			mAlignmentSeqA += mSeqA[i - 1];
			i--;
		}
		while (j > 0) {
			mAlignmentSeqA += "-";
			mAlignmentSeqB += mSeqB[j - 1];
			j--;
		}

		mAlignmentSeqA = new StringBuffer(mAlignmentSeqA).reverse().toString();
		mAlignmentSeqB = new StringBuffer(mAlignmentSeqB).reverse().toString();
	}

	private  int weight(int i, int j) {
		if (mSeqA[i - 1] == mSeqB[j - 1]) {
			return 1;
		} else {
			return -1;
		}
	}

	 void printMatrix() {
		System.out.print("D =       ");
		for (int i = 0; i < mSeqB.length; i++) {
			System.out.print(String.format("%4c ", mSeqB[i]));
		}
		System.out.println();
		for (int i = 0; i < mSeqA.length + 1; i++) {
			if (i > 0) {
				System.out.print(String.format("%4c ", mSeqA[i - 1]));
			} else {
				System.out.print("     ");
			}
			for (int j = 0; j < mSeqB.length + 1; j++) {
				System.out.print(String.format("%4d ", mD[i][j]));
			}
			System.out.println();
		}
		System.out.println();
	}

	 void printScoreAndAlignments() {
		System.out.println("Score: " + mScore);
		System.out.println("Sequence A: " + mAlignmentSeqA);
		System.out.println("Sequence B: " + mAlignmentSeqB);
		System.out.println();
	}

}
