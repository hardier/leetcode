package leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
    	int now = 0;
        int tail = A.length - 1;
        int val;
        
        if (tail < 0) return 1;
        while (now <= tail) {        	
        	val = A[now];
        	
        	if (val <= 0 || val > A.length || A[val - 1] == val) now++;
        	else {
        		int tmp = A[now];
        		A[now] = A[val - 1];
        		A[val - 1] = tmp;
        	}
        }

        now = 0;
        while (now <= tail && A[now] == now + 1) now++;
        return now + 1;
    }

    public static void main(String[] args) {
    	FirstMissingPositive s = new FirstMissingPositive();
    	
    	int[] A = {1, 3, 2};
    	System.out.println(s.firstMissingPositive(A));
    }

}
