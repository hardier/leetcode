package leetcode;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	if (m == 0 || n == 0) return 0;
    	
    	int[][] res = new int[m][n];
    	
    	for (int i = 0; i < m; i ++)
    		for (int j = 0; j < n; j ++)
    			res[i][j] = 0;
    	
    	if (obstacleGrid[0][0] == 1) return 0;
    	else res[0][0] = 1;
    	
    	for (int i = 0; i < m; i ++) {
    		for (int j = 0; j < n; j ++) {
    			if (obstacleGrid[i][j] == 0) {
    				if (i > 0) res[i][j] += res[i - 1][j];
    				if (j > 0) res[i][j] += res[i][j - 1];
    			}
    			else {
    				res[i][j] = 0;
    			}
    		}
    	}
    	
    	return res[m-1][n-1];
    }
    
    
    public static void main(String[] args) {
    	int[][] a = {{0}};//{{0,0,0},{0,1,0},{0,0,0}};
    	UniquePathsII s = new UniquePathsII();
    	System.out.println(s.uniquePathsWithObstacles(a));
    }
}
