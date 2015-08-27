package kcl.qutong.plagiarism.entity.SmithWaterman;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmithWaterman_cutoffTest {

	@Test
	public void test() {
				//   1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
		String a1 = "a b c x d e f g h i y m z j l u k p q s j t u v";
		String b =  "a b c d e f g h i j k l m n o p q r s j t u v";
		
//		String a1 = "a b c d e f g h x y z a b c";
//		String b =  "x y a b c d b c e f";
		String[] seqA = a1.split(" ");
		String[] seqB = b.split(" ");
		SmithWaterman_cutoff swc=new SmithWaterman_cutoff();
		String[] a=swc.result(seqA, seqB,5);
		System.out.println("pairs:"+a[1]);
	}

}
