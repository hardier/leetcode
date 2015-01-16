package leetcode;

import java.util.*;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> now = new ArrayList<Integer>();

        int n = S.length;
        Arrays.sort(S);
        for (int i = 0; i <= n; i ++) {
        	helper(n, i, 0, 0, now, res, S);
        	
        }
        
        return res;
    }
    
    public void helper(int n, int k, int start, int step, ArrayList<Integer> now, ArrayList<ArrayList<Integer>> res, int[] s) {
    	if (start > n) return;
    	
    	if (step == k) {
    		res.add(new ArrayList<Integer>(now));
    	}
    	
    	for (int i = start; i < n; i ++) {
    		now.add(s[i]);
    		helper(n, k, i + 1, step + 1, now, res, s);
    		now.remove(now.size() - 1);
    	}
    	
    }
    
    public static void main(String[] args) {
    	Subsets s = new Subsets();
    	
    	int[] a = {1,2,3};
    	
    	ArrayList<ArrayList<Integer>> ans = s.subsets(a);
    	
    	for (ArrayList<Integer> c : ans) {
    		System.out.println(c);
    	}
    }
}
