package leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {    	
    	return helper(1, n);
    }
    
    public ArrayList<TreeNode> helper(int start, int end) {
    	ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    	if (start > end) {
    		result.add(null);
    		return result;
    	}

    	for (int root = start; root <= end; root ++) {
        	ArrayList<TreeNode> left = helper(start, root - 1);
        	ArrayList<TreeNode> right = helper(root + 1, end);
        	for (int i = 0; i < left.size(); i ++) {
        		for (int j = 0; j < right.size(); j ++) {
        			TreeNode r = new TreeNode(root);
        			r.left = left.get(i);
        			r.right = right.get(j);
        			result.add(r);
        		}
        	}
    	}
    	
    	return result;
    }
    
}
