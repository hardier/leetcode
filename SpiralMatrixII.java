package leetcode;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][]matrix = new int[n][n];

        int x = 0, y = 0;

        int step = 1;

        while (n > 0) {
        	int i;
        	
        	if (n == 1) {
        		matrix[x][y] = step++;
        		return matrix;
        	}
        	
        	for (i = 0; i < n - 1; i ++) matrix[x][y++] = step++;
        	
        	for (i = 0; i < n - 1; i ++) matrix[x++][y] = step++;;
        	
        	for (i = 0; i < n - 1; i ++) matrix[x][y--] = step++;
        	
        	for (i = 0; i < n - 1; i ++) matrix[x--][y] = step++;
        	
        	x++;
        	y++;
        	n -= 2;
        	
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
    	SpiralMatrixII s = new SpiralMatrixII();
    	int n = 4;
    	
    	int[][] b = s.generateMatrix(n);
    	
    	for (int i = 0; i < n; i ++) {
    		for (int j = 0; j < n; j ++) {
    			System.out.print(b[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}
