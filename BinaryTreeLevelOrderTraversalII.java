package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	if (root == null) return res;

    	Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	
    	int remain = 1;
    	q.add(root);
    	
    	while (!q.isEmpty()) {
    		ArrayList<Integer> now = new ArrayList<Integer>();
    		for (int i = 0; i < remain; i ++) {
    			TreeNode tmp = q.remove();
    			now.add(tmp.val);
    			if (tmp.left != null) {
    				q.add(tmp.left);  				
    			}
    			if (tmp.right != null) {
    				q.add(tmp.right);
    			}
    		}

    		st.push(now);
    		remain = q.size();
    	}
    	
    	while (!st.isEmpty()) {
    		res.add(st.pop());
    	}
    	
    	return res;
    }

    
    public static void main(String[] args) {
    	BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
    	
    	TreeNode a0 = new TreeNode(0);
    	TreeNode a1 = new TreeNode(1);
    	TreeNode a2 = new TreeNode(2);
    	TreeNode a3 = new TreeNode(3);
    	
    	a0.left = a1;
    	a0.right = a2;
    	a1.right = a3;
    	
    	s.levelOrderBottom(a0);
    }
}
