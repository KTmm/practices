
public class StockPrices {
	int longestPeriod;
	double priceGain;
	int[] pricesOfAPeriod;
    
	public StockPrices(int[] prices){
		pricesOfAPeriod = prices;
	}
	
	/**@return the longest up-run period in an int array*/	
	public int findLongestUpRunPeriod(){
		int start = 0;
		int end = 0;
		longestPeriod = 0;
		priceGain = 0;
		if (pricesOfAPeriod.length <= 1){
			longestPeriod = pricesOfAPeriod.length;
			priceGain = 0.0;
		}
		
		while (start < pricesOfAPeriod.length - 1 && end < pricesOfAPeriod.length - 1){
			end = findContinousUp(start, pricesOfAPeriod);
			int period = end - start + 1;
			updateLongestPeriod(period, start, end);
			start = end + 1;
		}
		return longestPeriod;
	}
	
	/**This method finds the last element of a up-run sequence in an array for a given start index
	 * @return the index of the last element of a up-run sequence in this array*/
	public int findContinousUp(int start, int[] nums){
		while(start + 1 < nums.length && nums[start] <= nums[start + 1]){
			start++;
			}
		return start;
	}
	
	public void updateLongestPeriod(int period, int start, int end){
		if (period > longestPeriod){
			longestPeriod = period;
			priceGain = (pricesOfAPeriod[end] - pricesOfAPeriod[start])/(double)pricesOfAPeriod[start]; 
		}
	}
	
	public double getPriceGain(){
		return priceGain;
	}
}
