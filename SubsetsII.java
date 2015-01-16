package leetcode;

import java.util.*;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> now = new ArrayList<Integer>();

        int n = num.length;
        Arrays.sort(num);
        for (int i = 0; i <= n; i ++) {
        	helper(n, i, 0, 0, now, res, num);
        	
        }
        
        return res;
    }
    
    public void helper(int n, int k, int start, int step, ArrayList<Integer> now, ArrayList<ArrayList<Integer>> res, int[] s) {
    	if (start > n) return;
    	
    	if (step == k) {
    		res.add(new ArrayList<Integer>(now));
    	}
    	
    	for (int i = start; i < n; i ++) {
    		if ((i > start) && (s[i] == s[i-1])) continue;
    		now.add(s[i]);
    		helper(n, k, i + 1, step + 1, now, res, s);
    		now.remove(now.size() - 1);
    	}
    	
    }
    
    public static void main(String[] args) {
    	SubsetsII s = new SubsetsII();
    	
    	int[] a = {1,1,2};
    	
    	ArrayList<ArrayList<Integer>> ans = s.subsetsWithDup(a);
    	
    	for (ArrayList<Integer> c : ans) {
    		System.out.println(c);
    	}
    }
}
