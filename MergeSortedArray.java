package leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
    	int p = n + m - 1;
    	int p_A = m - 1;
    	int p_B = n - 1;
    	
    	while (p_B >= 0) {
    		if (p_A < 0){
    			A[p] = B[p_B--];
    		}
    		else if (A[p_A] > B[p_B])
    			A[p] = A[p_A--];
    		else
    			A[p] = B[p_B--];
    		p--;
    	}
    }

    
	public static void main (String[] args) {
		int A[] = {1, 3, 5, 6, 8, 0, 0, 0, 0, 0};
		int B[] = {2, 4, 7, 8, 9};
		
		MergeSortedArray s = new MergeSortedArray();
		
		s.merge(A,  0,  B,  5);
		
		for (int i = 0; i < A.length; i ++) {
			System.out.println(A[i]);
		}
	}

}