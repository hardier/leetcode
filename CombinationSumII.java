package leetcode;

import java.util.*;

public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	if (candidates.length == 0) return res;
    	Arrays.sort(candidates);
    	
    	helper1(candidates, 0, target, new ArrayList<Integer>(), res);
    	
    	return res;
    }

	public void helper1(int[] candidates, int start, int target, ArrayList<Integer>item, ArrayList<ArrayList<Integer>> res) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if (target < 0 || start >= candidates.length) return;
		
		//find consecutive same number
		int now = start;
		now ++;
		while (now < candidates.length && candidates[now] == candidates[start]) {
			now ++;
		}
		
		helper1(candidates, now, target, item, res);

		for (int i = 0; i < now - start; i ++) {
			target -= candidates[start];
			item.add(candidates[start]);
			helper1(candidates, now, target, item, res);
		}

		for (int i = 0; i < now - start; i ++) {
			target += candidates[start];
			item.remove(item.size() - 1);
		}

	}
	
	public void helper(int[] candidates, int start, int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
    	if (target < 0) return;
    	if (target == 0) {
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	
    	for (int i = start; i < candidates.length; i ++) {
    		if ((i < candidates.length - 1) && (candidates[i] == candidates[i + 1])) continue;
    		item.add(candidates[i]);
    		helper(candidates, i + 1, target - candidates[i], item, res);
    		item.remove(item.size() - 1);
    	}
    }

    public static void main(String[] args) {
    	int[] A = {1, 1, 1, 2};
    	
    	CombinationSumII s = new CombinationSumII();

    	ArrayList<ArrayList<Integer>> a = s.combinationSum2(A,  3);
    	    	
    	for (ArrayList<Integer> c : a) {
    		System.out.println(c);
    	}
    	
    }
}
