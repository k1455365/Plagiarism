package kcl.qutong.plagiarism.entity.SmithWaterman;

import java.util.ArrayList;
import java.util.List;

public class SmithWaterman_overlap {
	List<cell> candidateSet = new ArrayList<cell>();
	public String[] result(String[] srcArray, String[] trgArray, int threshold) {
		String[] mix=null;
		return mix;
	}
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
			for (int n = 0; n < oldSet.size() / 2-1; n++) {//should minus 1 here, consider remove isuue
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
				}
				else{
					System.out.println("S " + next_end.getX() + ","
							+ next_end.getY() + "different origil with S" + end.getX() + ","
							+ end.getY());
				}
			}
		}
		return oldSet;
	}
}
