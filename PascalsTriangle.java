package leetcode;

import java.util.*;

public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (numRows > 0) {
        	ArrayList<Integer> now = new ArrayList<Integer>();
        	now.add(1);
        	res.add(new ArrayList<Integer>(now));
        }
        for (int i = 1; i < numRows; i ++) {
        	ArrayList<Integer> now = new ArrayList<Integer>();
        	now.add(1);
        	for (int j = 1; j < i; j ++) {
        		now.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
        	}
        	now.add(1);
        	res.add(new ArrayList<Integer>(now));
        }
    	
        return res;
    }

    public static void main(String[] args) {
    	PascalsTriangle s = new PascalsTriangle();
    	System.out.println(s.generate(4));
    }
}
