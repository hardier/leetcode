package leetcode;

public class SetMaxZeroes {
    public void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean row0_clear = false, col0_clear = false;
    	
    	for (int i = 0; i < n; i ++) {
    		if (matrix[0][i] == 0) {
    			row0_clear = true;
    			break;
    		}
    	}

    	for (int i = 0; i < m; i ++) {
    		if (matrix[i][0] == 0) {
    			col0_clear = true;
    			break;
    		}
    	}
    	
    	for (int i = 1; i < m; i ++) 
    		for (int j = 1; j < n; j ++)
    			if (matrix[i][j] == 0) {
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}

    	for (int i = 1; i < n; i ++)
    		if (matrix[0][i] == 0)
    			for (int j = 1; j < m; j ++)
    				matrix[j][i] = 0;
    
    	for (int i = 1; i < m; i ++)
    		if (matrix[i][0] == 0)
    			for (int j = 1; j < n; j ++)
    				matrix[i][j] = 0;

    	if (row0_clear)
    		for (int i = 0; i < n; i ++)
    			matrix[0][i] = 0;
    	
    	if (col0_clear)
    		for (int i = 0; i < m; i ++)
    			matrix[i][0] = 0;
    }
    
    public static void main(String[] args) {
    	SetMaxZeroes s = new SetMaxZeroes();
    	
    	int[][] a = {{0,1,1,1, 5}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 2}};
    	
    	s.setZeroes(a);
    	
    	for (int i = 0; i < a.length; i ++) {
    		for (int j = 0; j < a[0].length; j ++)
    			System.out.print(a[i][j] + " ");
    		System.out.println();
    	}
    }
}
