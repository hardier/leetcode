package leetcode;

import java.util.*;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	if (candidates.length == 0) return res;
    	Arrays.sort(candidates);
    	
    	helper(candidates, 0, target, new ArrayList<Integer>(), res);
    	
    	return res;
    }

    public void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
    	if (target < 0) return;
    	if (target == 0) {
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	
    	for (int i = start; i < candidates.length; i ++) {
    		if (i > 0 && candidates[i] == candidates[i-1]) continue;
    		item.add(candidates[i]);
    		helper(candidates, i, target - candidates[i], item, res);
    		item.remove(item.size() - 1);
    	}
    }

    public static void main(String[] args) {
    	int[] A = {5, 3, 8, 1, 2};
    	
    	CombinationSum s = new CombinationSum();

    	ArrayList<ArrayList<Integer>> a = s.combinationSum(A,  9);
    	    	
    	for (ArrayList<Integer> c : a) {
    		System.out.println(c);
    	}
    	
    }
}
