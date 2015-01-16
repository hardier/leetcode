package leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        double ans = 1;
        int i;
        n = n - 1; m = m - 1;
        
        for (i = m + 1; i <= m + n; i ++) ans *= i;
        for (i = 1; i <= n; i ++) ans /= i;
        
        return (int)Math.round(ans);
    }
    
    public static void main(String[] args) {
    	UniquePaths s = new UniquePaths();
    	
    	System.out.println(s.uniquePaths(13, 23));
    }
}
