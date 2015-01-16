package leetcode;

import java.util.*;

public class PathSumII {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> now = new ArrayList<Integer>();

    	build(res, now, root, sum);
    	
    	return res;
    }

    public void build(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> now, TreeNode root, int sum) {
    	if (root == null) return;

    	
		now.add(root.val);
    	if (root.val == sum && root.left == null && root.right == null){
    		res.add(new ArrayList<Integer>(now));
    	}
    	else {
    		build(res, now, root.left, sum - root.val);
    		build(res, now, root.right, sum - root.val);
    	}
		now.remove(now.size() - 1);
    }
    
}
