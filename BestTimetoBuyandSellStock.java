package leetcode;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
    	int n = prices.length;
    	if (n == 0) return 0;
    	int res = 0;
    	
    	int[] left_low = new int[n];
    	
    	left_low[0] = prices[0];
    	for (int i = 1; i < n; i ++) {
    		left_low[i] = Math.min(prices[i], left_low[i - 1]);

    		res = Math.max(res,  prices[i] - left_low[i]);
    	}
    	
    	return res;
    }
}
