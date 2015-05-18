import static org.junit.Assert.*;

import org.junit.Test;


public class FindLongUpRunTest {
    int[] prices1 = new int[]{1};
    int[] prices2 = new int[]{1,1};
    int[] prices3 = new int[]{1,2,3};
    int[] prices4 = new int[]{1,1,2,4,5};
    int[] prices5 = new int[]{3,1,2,5,8,2,3,4,9,10,13,2,3,4,7,1};
    
	@Test
	public void test() {
		assertEquals(0.00, FindLongestRunup.findLongestUpRun(prices1), 0.001);
		assertEquals(0.00, FindLongestRunup.findLongestUpRun(prices2), 0.001);
		assertEquals(2.00, FindLongestRunup.findLongestUpRun(prices3), 0.001);
		assertEquals(4.00, FindLongestRunup.findLongestUpRun(prices4), 0.001);
		assertEquals(5.50, FindLongestRunup.findLongestUpRun(prices5), 0.001);
	}

	

}
