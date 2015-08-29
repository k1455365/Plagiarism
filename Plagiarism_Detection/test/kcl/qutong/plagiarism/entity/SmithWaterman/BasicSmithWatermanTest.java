package kcl.qutong.plagiarism.entity.SmithWaterman;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * test class for smithwaterman
 * @author qutong
 *
 */
public class BasicSmithWatermanTest {

	@Test
	public void test() {
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
