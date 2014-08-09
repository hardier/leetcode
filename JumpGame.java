package leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
        int max = 0;
        int now_max = 0;
        int now_start = 0;
        
        while (max < A.length - 1) {
        	max = 0;
        	for (int i = now_start; i <= now_max; i ++) {
        		int tmp = A[i] + i;
        		if (tmp > now_max) {
        			if (tmp > max) max = tmp;
        		}
        	}
        	if (max == 0) return false;
        	now_start = now_max + 1;
        	now_max = max;
        	
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	int[] a = {0, 1, 2,3};//{3,2,1,4,0,2,1,0, 0};
    	
    	JumpGame s = new JumpGame();
    	
    	System.out.println(s.canJump(a));
    }
}
