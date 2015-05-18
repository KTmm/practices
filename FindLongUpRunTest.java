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
    
   
    
    @Test
    public void test1(){
    	StockPrices sp1 = new StockPrices(prices1);
    	assertEquals(0, sp1.findLongestUpRunPeriod());
    	assertEquals(0, sp1.getPriceGain(), 0.001);
    }
    
    @Test
    public void test2(){
    	StockPrices sp2 = new StockPrices(prices2);
    	assertEquals(1, sp2.findLongestUpRunPeriod());
    	assertEquals(0, sp2.getPriceGain(), 0.001);
    }
    
    @Test
    public void test3(){
    	StockPrices sp3 = new StockPrices(prices3);
    	assertEquals(2, sp3.findLongestUpRunPeriod());
    	assertEquals(0.0, sp3.getPriceGain(), 0.001);
    }

    @Test
    public void test4(){
    	StockPrices sp4 = new StockPrices(prices4);
    	assertEquals(3, sp4.findLongestUpRunPeriod());
    	assertEquals(2.00, sp4.getPriceGain(), 0.001);
    }
	

}
