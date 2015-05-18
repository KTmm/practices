import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FindLongUpRunTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        
	int[] prices1 = new int[]{};
	int[] prices2 = new int[]{1};
	int[] prices3 = new int[]{1,1};
    int[] prices4 = new int[]{1,2,3};
    int[] prices5 = new int[]{1,1,2,4,5,2,3};
    int[] prices6 = new int[]{3,1,2,5,8,2,3,4,9,10,13,2,3,4,7};
    int[] prices7 = new int[]{0,1,2,3,4,5,1,2,3,1,5,6,7,8,9,9,9,9,9,9};
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void test(){
    	FindLongestRunup.findLongestUpRun(prices1);
    	assertEquals("Longest Up-Run period is 0 days, and the percentage of gain is 0.0%", outContent.toString());
    }
    
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

	

}
