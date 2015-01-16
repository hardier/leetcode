package leetcode;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i ++) {
        	a[i] = a[i-1] * 2;
        	for (int j = 1; j < i - 1; j ++) {
        		a[i] += (a[j] * a[i-j-1]);
        	}
        }
        
        return a[n];
    }
    
    
    public static void main(String[] args) {
    	UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
    	System.out.println(s.numTrees(4));
    }
}
