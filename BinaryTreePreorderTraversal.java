package leetcode;

import java.util.*;

public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {

    	ArrayList<Integer> res = new ArrayList<Integer>();

    	if (root == null) return res;
    	
    	Stack<TreeNode> nodes = new Stack<TreeNode>();
    	
    	nodes.push(root);

    	res.add(root.val);
    	TreeNode now = root.left;

    	while (!nodes.empty()) {
    		if (now == null) {
    			now = nodes.pop().right;
    			if (now != null) {
    				res.add(now.val);
    				nodes.push(now);
    				now = now.left;
    			}
    		}
    		else {
    			nodes.push(now);
    			res.add(now.val);
    			now = now.left;    			
    		}
    	}
    	return res;
    }
}
