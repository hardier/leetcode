package leetcode;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
    	int slow = 0, fast = 1;
    	int duplicate = 0;
    	
    	if (A.length == 0) return 0;
    	
    	for (fast = 1; fast < A.length; fast ++) {
    		if (A[fast] == A[fast - 1]) {
    			duplicate ++;
    			if (duplicate == 1) {
    				A[++slow] = A[fast];
    			}
    		}
    		else {
    			duplicate = 0;
    			A[++slow] = A[fast];
    		}
    	}
    	return ++slow;
    }
    
    public static void main(String[] args) {
    	int A[] = {1,1,2,3,4,5,5,5,6};
    	
    	RemoveDuplicatesFromSortedArrayII s = new RemoveDuplicatesFromSortedArrayII();
    	
    	int val = s.removeDuplicates(A);
    	
//    	System.out.println(s);
    	for (int i = 0; i < val; i ++) {
    		System.out.println(A[i]);
    	}
    }
}
