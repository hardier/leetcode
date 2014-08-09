package leetcode;

public class NextPermutation {
    public void nextPermutation(int[] num) {
    	int tail = num.length - 2;
        
        if (tail < 0) return;
        
        while (tail >= 0 && num[tail] >= num[tail + 1]) {
        	tail--;        	
        }
        
        if (tail < 0) {
        	reverseOrder(num, 0, num.length - 1);
        }
        else {
        	int l = tail + 1;
        	int r = num.length - 1;
        	int m = (l + r) >> 1;
        	
            while (l < r) {
            	if (num[m] > num[tail]) l = m + 1;
            	else r = m;
            	m = (l + r) >> 1;
            }
            
            if (l == num.length-1 && num[l] > num[tail]){
            	
            }
            else l --;

            int tmp = num[l];
        	num[l] = num[tail];
        	num[tail] = tmp;
        	reverseOrder(num, tail + 1, num.length - 1);
        }/*
        else {
        	int now = tail + 1;
        	while (now < num.length && num[now] > num[tail]) {
        		now++;
        	}
        	now--;
        	int tmp = num[now];
        	num[now] = num[tail];
        	num[tail] = tmp;
        	reverseOrder(num, tail + 1, num.length - 1);
        }*/
    }
    
    public void reverseOrder(int[] a, int l, int r) {
    	int tmp;
    	
    	while (l < r) {
    		tmp = a[l];
    		a[l++] = a[r];
    		a[r--] = tmp;
    	}
    }
    
    public static void main(String[] args) {
    	int A[] = {3, 1, 2};
    	
    	NextPermutation s = new NextPermutation();
    	s.nextPermutation(A);
    	
    	for (int i = 0; i < A.length; i ++)
    		System.out.println(A[i]);
    }
}
