package leetcode;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	int tail = A.length - 1;
    	int head = 0;

    	while (head < tail) {
    		while (A[head] != elem && head < tail) head++;
    		while (A[tail] == elem && head < tail) tail--;
    		
    		if (head < tail) {
    			A[head] = A[tail];
    			head ++;
    			tail --;
    		}
    	}
    	
    	if (tail >= 0 && A[tail] == elem) tail--;
    	
    	return tail + 1;
    }

    public static void main(String[] args) {
    	int A[] = {};//{1, 3, 5, 7, 3, 6, 5, 8, 3, 2, 5, 4, 3};
    	
    	RemoveElement s = new RemoveElement();
    	int new_val = s.removeElement(A,  3);
    	System.out.println(new_val);
    	for (int i = 0; i < A.length; i ++) {
    		System.out.println(A[i]);
    	}
    	
    }
}
