package leetcode;

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        if (n <= 1) return 0;        
        int res = 0;

        int left_min = prices[0];
        int[] best_to_left = new int[n];
        
        for (int i = 1; i < n; i ++) {
        	best_to_left[i] = Math.max(best_to_left[i-1], prices[i] - left_min);
        	left_min = Math.min(prices[i], left_min);
        }

        int right_max = prices[n-1];
        for (int i = n-1; i >= 0; i --) {
        	res = Math.max(res,  best_to_left[i] + right_max - prices[i]);
        	right_max = Math.max(right_max, prices[i]);
        }
        
        return res;
    }
}
