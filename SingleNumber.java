package leetcode;

public class SingleNumber {
    public int singleNumber(int[] A) {
    	int n = A.length;
    	int s = 0;
    	
    	for (int i = 0; i < n; i ++) {
    		s ^= A[i];
    	}
    	
    	return s;
    }

    public static void main(String[] args) {
    	SingleNumber a = new SingleNumber();
    	int[] s = {1,2,3,4,1, 2, 4};
    	
    	System.out.println(a.singleNumber(s));
    }
}
