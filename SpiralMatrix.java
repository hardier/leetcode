package leetcode;

import java.util.*;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0;
        
        while (m > 0 && n > 0) {
        	int i;
        	
        	if (m == 1) {
        		for (i = 0; i < n; i ++) res.add(matrix[x][y++]);
        		return res;
        	}
        	else if (n == 1) {
        		for (i = 0; i < m; i ++) res.add(matrix[x++][y]);
        		return res;
        	}
        	
        	for (i = 0; i < n - 1; i ++) res.add(matrix[x][y++]);
        	
        	for (i = 0; i < m - 1; i ++) res.add(matrix[x++][y]);
        	
        	for (i = 0; i < n - 1; i ++) res.add(matrix[x][y--]);
        	
        	for (i = 0; i < m - 1; i ++) res.add(matrix[x--][y]);
        	
        	x++; y++; m-=2; n-=2;
        	
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	SpiralMatrix s = new SpiralMatrix();
    	
    	int[][] a = {{1,2,3,4,5,6}, {4,5,6,7,8,9}};//{{1,2,3,4, 5, 6, 7},{9, 10, 11, 12, 13, 14, 15}};
    	
    	ArrayList<Integer> b = s.spiralOrder(a);
    	
    	System.out.println(b);
    }
}
