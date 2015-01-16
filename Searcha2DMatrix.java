package leetcode;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;

        if (m==0) return false;
        int n = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[m-1][n-1])
        	return false;
        
        //1. row addr
        int l = 0, r = m - 1;
        int mid;
        int now;
        
        while (l <= r) {
        	mid = (l + r) / 2;
        	if (matrix[mid][n-1] == target) return true;
        	else if (matrix[mid][n-1] < target) l = mid + 1;
        	else if (matrix[mid][n-1] > target) r = mid - 1;
        }
        now = l;
        
        l = 0;
        r = n - 1;
        while (l <= r) {
        	mid = (l + r) / 2;
        	if (matrix[now][mid] == target) return true;
        	else if (matrix[now][mid] < target) l = mid + 1;
        	else if (matrix[now][mid] > target) r = mid - 1;
        }
        
        return false;
    }
    
    
    public static void main(String[] args) {
    	int a[][] = {};//{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	
    	Searcha2DMatrix s = new Searcha2DMatrix();
    	
    	System.out.println(s.searchMatrix(a,  0));
    }
}
