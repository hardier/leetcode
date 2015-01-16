package leetcode;

public class Candy {
    public int candy(int[] ratings) {
    	int n = ratings.length;
    	int res = 0;

    	int[] candy = new int[n];

    	if (n == 0) return 0;
    	
    	for (int i = 0; i < n; i ++)
    		candy[i] = 1;
    	
    	for (int i = 1; i < n; i ++)
    		if (ratings[i] > ratings[i-1])
    			candy[i] = candy[i-1] + 1;

    	for (int i = n - 2; i >= 0; i --) {
    		if (ratings[i] > ratings[i+1])
    			candy[i] = Math.max(candy[i], candy[i+1] + 1);
    		res += candy[i];
    	}
    	res += candy[n-1];
    	return res;
    }

    
    
    public int candy1(int[] ratings) {
     	int n = ratings.length;
    	int res = 0;

    	int[] candy = new int[n];

    	if (n == 0) return 0;
    	
    	for (int i = 0; i < n; i ++)
    		candy[i] = 1;
    	
    	for (int i = 1; i < n; i ++)
    		if (ratings[i] > ratings[i-1])
    			candy[i] = candy[i-1] + 1;

    	for (int i = n - 2; i >= 0; i --) {
    		if (ratings[i] > ratings[i+1])
    			candy[i] = Math.max(candy[i], candy[i+1] + 1);
    		res += candy[i];
    	}
    	res += candy[n-1];
    	return res;
    }

    
    
    
    
}
