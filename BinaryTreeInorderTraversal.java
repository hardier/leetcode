package leetcode;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	TreeNode now = root;
    	TreeNode pre;
    	while (now != null) {
    		if (now.left == null) {
    			res.add(now.val);
    			now = now.right;
    		}
    		else {
    			pre = now.left;
    			while (pre.right != null && pre.right != now) {
    				pre = pre.right;
    			}
    			
    			if (pre.right == null) {
    				pre.right = now;
    				now = now.left;
    			}
    			else { //recover
    				pre.right = null;
        			res.add(now.val);
    				now = now.right;
    			}
    		}
    		
    	}
    	
    	return res;
    }
	
	public ArrayList<Integer> inorderTraversal1(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> q = new Stack<TreeNode>();
    	TreeNode now = root;

    	while (now!=null || !q.isEmpty()) {
        	while (now != null) {
        		q.push(now);
        		now = now.left;
        	}
        	
        	now = q.pop();
        	res.add(now.val);
        	now = now.right;    	
    	}
    	
    	
    	return res;
    }

	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	traverse(root, res);
    	
    	return res;
    }
        
    public void traverse(TreeNode root, ArrayList<Integer> res) {
    	if (root == null) return;
    	traverse(root.left, res);
    	res.add(root.val);
    	traverse(root.right, res);
    }
}
