package leetcode;

import java.util.*;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        
        int[] val = new int[n];        
        for (int i = 0; i < n; i ++)
        	val[i] = triangle.get(n-1).get(i);

        for (int i = n-2; i >= 0; i --) {
        
        	for (int j = 0; j <= i; j ++) {
        		val[j] = Math.min(val[j],  val[j + 1]) + triangle.get(i).get(j);
        	}
        
        }
        
        return val[0];
    }
}
