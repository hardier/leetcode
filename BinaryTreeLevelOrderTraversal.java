package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> st = new ArrayList<TreeNode>();
        
        if (root == null) return res;
        st.add(root);
        int start = 0;
        int end = 0;
        int tot = 1;

        while (tot > 0) {
        	tot = 0;
        	ArrayList<Integer> s = new ArrayList<Integer>();
        	for (int i = start; i <= end; i ++) {
        		TreeNode tmp = st.get(i);
        		s.add(tmp.val);
        		if (tmp.left != null) {
        			tot++;
        			st.add(tmp.left);
        		}
        		if (tmp.right != null) {
        			tot++;
        			st.add(tmp.right);
        		}
        	}
    		start = end + 1;
    		end = start + tot - 1;
        	
        	res.add(s);
        }
        
        return res;
    }
}
