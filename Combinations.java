package leetcode;

import java.util.*;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	if (n < k) return null;
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> now = new ArrayList<Integer>();
        
        helper(0, 0, now, res, n, k);
        
        return res;
    }
    
    public void helper(int start, int step, ArrayList<Integer> now, ArrayList<ArrayList<Integer>> res, int n, int k) {
    	if (start > n)
    		return;
    	
    	if (step == k) {
    		res.add(new ArrayList<Integer>(now));
    		return;
    	}
    	
    	for (int i = start; i < n; i ++) { 
    		now.add(i+1);
    		helper(i + 1, step + 1, now, res, n, k);
    		now.remove(now.size() - 1);
    	}  
    }
    
    
    public static void main(String[] args) {
    	Combinations s = new Combinations();
    	
    	ArrayList<ArrayList<Integer>> a = s.combine(4, 2);

    	
    	for (ArrayList<Integer> t : a) {
    		System.out.println(t);
    	}
    }
}
