package leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
   
    	if (n == 0) return;
    	
    	for (int j = 0; j < n/2; j ++) {
    		for (int i = j; i < n - j - 1; i ++) {
    			int tmp = matrix[j][i];
    			matrix[j][i] = matrix[n - i - 1][j];
    			matrix[n - i - 1][j] = matrix[n - j - 1][n - i - 1];
    			matrix[n - j - 1][n - i - 1] = matrix[i][n - j - 1];
    			matrix[i][n - j - 1] = tmp;
    		}
    	}
    	
    }
    
    public static void main(String[] args) {
    	int[][] a = {{1, 2, 3, 4},
    				 {5, 6, 7, 8},
    				 {9, 10, 11, 12},
    				 {13, 14, 15, 16}};
    	
    	RotateImage s = new RotateImage();
    	
    	s.rotate(a);
    	int n = a.length;
    	for (int i = 0; i < n; i ++){
    		for (int j = 0; j < n; j ++)
    			System.out.print(a[i][j]+" ");
    			System.out.println();
    	}
    }
}

