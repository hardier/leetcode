package leetcode;

public class SearchInASortedArray {
    public int search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        int m = 0;
        
        while (l <= r) {
        	m = (l + r) / 2;
        	
        	if (A[m] == target) return m;
        	else if (A[m] < target) {
        		if (A[l] <= target && A[l] > A[m]) r = m - 1;
        		else l = m + 1;
        	}
        	else { //A[m] > target
        		if (A[l] > target && A[l] <= A[m]) l = m + 1;
        		else r = m - 1;
        	}
        }

        return -1;
    }
    
    public static void main(String[] args) {
    	int[] A = new int[]{3,5,6,7,1,2};
    	
    	SearchInASortedArray s = new SearchInASortedArray();
    	
    	System.out.println(s.search(A, 1));
    }
}
