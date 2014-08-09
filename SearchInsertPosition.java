package leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
    	int l = 0;
    	int r = A.length - 1;
    	int m;
    	
    	while (l <= r) {
    		m = (l + r) / 2;
    		if (A[m] == target) return m;
    		else if (A[m] < target) l = m + 1;
    		else r = m - 1;
    	}

    	return l;
    	
    }
    
    public static void main(String[] args) {
    	SearchInsertPosition s = new SearchInsertPosition();
    	int[] A = new int[]{1,2, 3, 4, 5};
    	
    	System.out.println(s.searchInsert(A, 2));
    }
}
