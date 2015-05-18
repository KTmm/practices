
public class FindLongestRunup {
	public static void main(String[] args){
		int[] prices1 = new int[]{};
		int[] prices2 = new int[]{1};
		int[] prices3 = new int[]{1,1};
	    int[] prices4 = new int[]{1,2,3};
	    int[] prices5 = new int[]{1,1,2,4,5,2,3};
	    int[] prices6 = new int[]{3,1,2,5,8,2,3,4,9,10,13,2,3,4,7};
	    int[] prices7 = new int[]{0,1,2,3,4,5,1,2,3,1,5,6,7,8,9,9,9,9,9,9};
		findLongestUpRun(prices1);		
		findLongestUpRun(prices2);	
		findLongestUpRun(prices3);	
		findLongestUpRun(prices4);	
		findLongestUpRun(prices5);	
		findLongestUpRun(prices6);
		findLongestUpRun(prices7);	
		
	}
	
	public static void findLongestUpRun(int[] prices){
		int start = 0;
		int end = 0;
		int longestPeriod = 0;
		double gain = 0;
		if (prices.length <= 1){
			longestPeriod = prices.length;
			gain = 0.0;
		}
		while (start < prices.length - 1 && end < prices.length - 1){
			end = findContinousUp(start, prices);
			int period = end - start + 1;
			
			if (period > longestPeriod){
				longestPeriod = period;
				if(prices[start] > 0){
					gain = (prices[end] - prices[start])/(double)prices[start];
				}
			}
			start = end + 1;
		}
		System.out.println("Longest Up-Run period is " + longestPeriod + " days, and the pertage of gain is " + gain * 100 + "%");
	}
	
	/**This method finds the last element of a up-run sequence in an array for a given start index
	 * @return the index of the last element of a up-run sequence in this array*/
	public static int findContinousUp(int start, int[] nums){
		while(start + 1 < nums.length && nums[start] <= nums[start + 1]){
			start++;
			}
		return start;
	}
}
