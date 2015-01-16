package leetcode;

public class SortColor {
    public void sortColors(int[] A) {
    	int ind_0 = 0, ind_2 = A.length - 1;
    	int i = 0;
    	
    	while (i <= ind_2) {
    		if (A[i] == 1) i++;
    		else if (A[i] == 0) {
    			if (i == ind_0) i ++;
    			else {
    				swap(A, i, ind_0);
    				ind_0 ++;
    			}
    		}
    		else if (A[i] == 2) {
    			swap(A, i, ind_2);
    			ind_2 --;
    		}
    	}
    	
    	
    }
    
    public void swap(int[] A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,0};
    	
    	SortColor s = new SortColor();
    	
    	s.sortColors(a);
    	
    	for (int i = 0; i < a.length; i ++)
    		System.out.print(a[i] + " ");
    }
}
