package leetcode;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
    	if (A==null) return false;
    	int l = 0, r = A.length - 1;
 
        while (l <= r) {
        	int m = (l + r) / 2;
        	
        	if (A[m] == target) return true;
        	else if (A[l] < A[m]) {
        		if (A[l] <= target && target < A[m])
        			r = m - 1;
        		else
        			l = m + 1;
        	}
        	else if (A[l] > A[m]) {
        		if (A[m] < target && target <= A[r])
        			l = m + 1;
        		else 
        			r = m - 1;
        	}
        	else {
        		l ++;
        	}
        }
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	SearchinRotatedSortedArrayII s = new SearchinRotatedSortedArrayII();
    	
    	int[] a = {5, 1, 3};
    	
    	System.out.println(s.search(a, 3));
    }
}
