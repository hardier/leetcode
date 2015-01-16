package leetcode;

import java.util.*;

public class PascalTriangleII {
    public ArrayList<Integer> getRow(int numRows) {
    	ArrayList<Integer> now = new ArrayList<Integer>();

    	for (int i = 0; i <= numRows; i ++) {
    		for (int j = i - 1; j > 0; j --) {
    			now.set(j, now.get(j) + now.get(j - 1));
    		}
    		now.add(1);
    	}
        return now;
    }

    public static void main(String[] args) {
    	PascalTriangleII s = new PascalTriangleII();
    	
    	System.out.println(s.getRow(5));
    }
    
}
