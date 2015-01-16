package leetcode;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;

        int[][] r = new int[m][n];
        int[][] d = new int[m][n];
        
        for (int i = 0; i < m; i ++) {
        	r[i][n-1] = (matrix[i][n-1] == '0') ? 0 : 1;
        	for (int j = n-2; j >=0; j --) {
        		if (matrix[i][j] == '1') {
					r[i][j] = r[i][j + 1] + 1;
        		}
				else {
					r[i][j] = 0;
				}
        	}
        }

		for (int j = 0; j < n; j ++) {
			d[m-1][j] = (matrix[m-1][j] == '0') ? 0 : 1;
			for (int i = m-2; i >=0; i--) {
        		if (matrix[i][j] == '1') {
					d[i][j] = d[i+1][j] + 1;
        		}
				else {
					d[i][j] = 0;
				}
			}
		}

		int max = 0;
		
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				//find max rec start with (i, j)
				if (r[i][j] > 0 && (m-i)*(n-j) > max) {
					int max_height = m;
					for (int k = 0; k < r[i][j]; k ++) {
						if (d[i][j+k] < max_height)
							max_height = d[i][j+k];
						if ((k + 1) * max_height > max)
							max = (k + 1) * max_height;
					}
				}
			}
		}
		
    	return max;
    }
    
    public static void main(String[] args) {
    	char[][] a = {{'0','0','1','0'},
    				  {'0','1','1','1'},
    				  {'1','0','1','1'},
    				  {'0','1','1','1'}};
    	
    	MaximalRectangle s = new MaximalRectangle();
    	
    	System.out.println(s.maximalRectangle(a));
    }
}
