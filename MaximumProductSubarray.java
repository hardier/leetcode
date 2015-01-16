package leetcode;

public class MaximumProductSubarray {
    
    public int maxProduct1(int[] A) {

    	if(A.length == 1)
            return A[0];

    	int max_local = A[0];
        int min_local = A[0];
        int global = A[0];
        for(int i=1;i<A.length;i++)
        {
            int max_copy = max_local;
            max_local = Math.max(Math.max(A[i]*max_local, A[i]), A[i]*min_local);
            min_local = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }
    
    public int maxProduct(int[] A) {
    	int max = A[0];
    	int l_max = A[0];
    	int l_min = A[0];
    	
    	for (int i = 1; i < A.length; i ++) {
    		int tmp = l_max;
    		l_max = Math.max((Math.max(A[i], l_max * A[i])), l_min * A[i]);
    		l_min = Math.min((Math.min(A[i], l_min * A[i])), tmp * A[i]);
    		max = Math.max(max, l_max);
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,-1,3,5,0,-3,2,-5,1,2,3,-2,4,3, 0, 2};

    	MaximumProductSubarray s = new MaximumProductSubarray();
    	
    	System.out.println(s.maxProduct(a));
    }
}
