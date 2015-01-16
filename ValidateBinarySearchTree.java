package leetcode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
    	return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isValid(TreeNode root, int min, int max) {
    	if (root == null)
    		return true;
    	
    	return (root.val > min &&
    			root.val < max &&
    			isValid(root.left, min, root.val) &&
    			isValid(root.right, root.val, max));
    }
}
