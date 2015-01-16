package leetcode;

public class SingleNumberII {
    public int singleNumber(int[] A) {
    	int n = A.length;
    	int one = 0, two = 0;
    	
    	for (int i = 0; i < n; i ++) {
    		int new_one = (one ^ A[i]) & (~two);
    		two = (two ^ A[i]) & (one ^ two);
    		one = new_one;
    	}
    	
    	return one;
    }

    public static void main(String[] args) {
    	SingleNumberII a = new SingleNumberII();
    	int[] s = {1,2,3,4,1, 2, 4, 1,2, 4};
    	
    	System.out.println(a.singleNumber(s));
    }

}


