package leetcode;

public class JumpGameII {
    public int jump(int[] A) {
        int max = 0, min = 0;
        int now_max = 0;
        int step = 0;
        
        if (A.length == 1) return 0;
        while (max < A.length - 1) {
        	now_max = 0;
        	for (int i = min; i <= max; i ++) {
        		int tmp = i + A[i];
        		if (tmp > max) {
        			if (tmp > now_max) now_max = tmp;
        		}
        	}
        	min = max + 1;
        	max = now_max;
        	step ++;	
        }
    	return step;
    }
    
    public double pow(double x, int n) {
        double y = x;
        if (n == 0) return 1;
        else if (n >= 0) {
            while (n != 0){
            	y = y * x;
            	n--;
            }
        }
        else {
            while (n != 0) {
            	y = y / x;
            	n ++;
            }
        }
        return y;
    }
    
    public static void main(String[] args) {
    	JumpGameII s = new JumpGameII();
    	int[] A = {1, 1, 1, 2, 0};//{3,2,1,2,5,2,6,2,3,4,2,1,3};
    	System.out.println(s.jump(A));
    }
}
