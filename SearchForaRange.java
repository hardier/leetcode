package leetcode;

public class SearchForaRange {
    public int[] searchRange(int[] A, int target) {
    	int[] B = new int[]{-1, -1};
    	
    	//1. find left, if not find return
    	int l = 0;
    	int r = A.length - 1;
    	int m;
    	
    	while (l <= r) {
    		m = (l + r) / 2;
    		if (A[m] < target) l = m + 1;
    		else if (A[m] > target) r = m - 1;
    		else {
    			//search left boundary
    			l = 0; r = m;
    			while (l <= r) {
    				m = (l + r) / 2;
    				if (A[m] < target) l = m + 1;
    				else r = m - 1;
    			}
    			B[0] = l;
    			
    			//search right boundary
    			l = m; r = A.length - 1;
    			while (l <= r) {
    				m = (l + r) / 2;
    				if (A[m] > target) r = m - 1;
    				else l = m + 1;
    			}
    			B[1] = r;

    			return B;
    		}
    	}
    	
    	
    	return B;
    }
    
    public static void main(String[] args) {
    	int A[] = {1,2,2,2,3,3,5,6};
    	
    	SearchForaRange s = new SearchForaRange();
    	
    	int B[];
    	
    	B = s.searchRange(A, 5);
    	
    	System.out.println(B[0]);
    	System.out.println(B[1]);
    }
}
