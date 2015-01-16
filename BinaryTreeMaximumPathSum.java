package leetcode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
    	int[] max = new int[1];
    	
    	find(root, max);
    	
    	return max[0];
    }

    public int find(TreeNode root, int[] max) {
    	int left = 0, right = 0;
    	int res;
    	int max_v = root.val;
    	
    	if (root.left != null) {
    		left = find(root.left, max);
    		max_v = Math.max(max[0], max_v);
    	}
    	
    	if (root.right != null) {
    		right = find(root.right, max);
    		max_v = Math.max(max[0], max_v);
    	}

    	res = Math.max(left, right) + root.val;
    	res = Math.max(res, root.val);
    	
    	max_v = Math.max(max_v, res);
    	max[0] = Math.max(max_v, left + right + root.val);
    	return res;
    }
    
    
}
