package leetcode;

import java.util.*;

public class BinaryTreePostOrderTraversal {
    public ArrayList<Integer> postOrderTraversal(TreeNode root) {

    	ArrayList<Integer> res = new ArrayList<Integer>();

    	if (root == null) return res;
    	
    	Stack<TreeNode> nodes = new Stack<TreeNode>();
    	Stack<Integer> visit = new Stack<Integer>(); //0: not visit, 1: visited left, 2: visited both

    	nodes.push(root);
    	visit.push(0);

    	TreeNode now = null;

    	while (!nodes.empty()) {
    		now = nodes.peek();
    		Integer v = visit.pop();
    		switch (v) {
    		case 0:
    			visit.push(1);
    			if (now.left != null) {
    				nodes.push(now.left);
    				visit.push(0);
    			}
    			break;
    		case 1:
    			visit.push(2);
    			if (now.right != null) {
    				nodes.push(now.right);
    				visit.push(0);
    			}
    			break;
    		case 2:
    			res.add(nodes.pop().val);
    			break;
    		default:
    			break;
    		}
    	}

    	return res;
    }

}

