package leetcode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> st = new ArrayList<TreeNode>();
        
        if (root == null) return res;
        st.add(root);
        int start = 0;
        int end = 0;
        int tot = 1;
        int step = 0;
        
        while (tot > 0) {
        	tot = 0;
        	ArrayList<Integer> s = new ArrayList<Integer>();
            for (int i = start; i <= end; i ++) {
            	TreeNode tmp = st.get(i);
            	if (tmp.left != null) {
            		tot++;
            		st.add(tmp.left);
            	}
            	if (tmp.right != null) {
            		tot++;
            		st.add(tmp.right);
            	}
            }

            if (step % 2 == 1) {
            	for (int i = start; i <= end; i ++)
            		s.add(st.get(i).val);
            }
            else {
            	for (int i = end; i >= start; i --)
            		s.add(st.get(i).val);            	
            }
            start = end + 1;
    		end = start + tot - 1;
        	
        	res.add(s);
        	step ++;
        }
        
        return res;
        
    }
}


