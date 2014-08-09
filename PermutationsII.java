package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	boolean visit[] = new boolean[num.length];
    	ArrayList<Integer> perm = new ArrayList<Integer>();
    	for (int i = 0; i < num.length; i ++) visit[i] = false;
    	helper(res, 0, perm, num, visit);
    	
    	return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, int step, ArrayList<Integer> perm, int[] num, boolean[] visit) {
    	if (step == num.length) {
    		res.add(new ArrayList<Integer>(perm));
    		return;
    	}
    	
    	for (int i = 0; i < num.length; i ++) {
    		if (visit[i] == false) {
                if (i > 0 && (num[i] == num[i-1]) && visit[i - 1] == false) continue;
	    			visit[i] = true;
	    			perm.add(num[i]);
	    			helper(res, step + 1, perm, num, visit);
	    			perm.remove(step);
	    			visit[i] = false;
    		}
    	}
    }

    public static void main(String[] args) {
    	int[] a = {1, 1, 0, 1};
    	
    	PermutationsII s = new PermutationsII();
    	
    	ArrayList<ArrayList<Integer>> b = s.permuteUnique(a);
    	
    	for (ArrayList<Integer> c : b) {
    		System.out.println(c);
    	}
    }

}
