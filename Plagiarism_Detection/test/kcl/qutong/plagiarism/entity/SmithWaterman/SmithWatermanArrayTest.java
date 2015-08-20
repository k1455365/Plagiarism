package kcl.qutong.plagiarism.entity.SmithWaterman;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmithWatermanArrayTest {

	@Test
	public void test() {  
	    	String a="abcxdefghiymzjlukpqsjtuv";
	    	String b="abcdefghijklmnopqrsjtuv";
//	            char[] seqB = { 'A', 'B', 'C', 'B', 'A', 'D', 'B', 'C', 'A' };
//	            char[] seqB = { 'A', 'B', 'B', 'D', 'B', 'D', 'A' };
	            char[] seqA =a.toCharArray();
	            char[] seqB =b.toCharArray();
	            SmithWatermanArray sw = new SmithWatermanArray();
	            sw.init(seqA, seqB);            
	            sw.process();
	            sw.backtrack();
	            
	            sw.printMatrix();
	            sw.printScoreAndAlignments();
	}

}
