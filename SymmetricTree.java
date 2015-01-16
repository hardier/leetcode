package leetcode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	else return TreeSymmetric(root.left, root.right);
    	
    }

    public boolean TreeSymmetric(TreeNode a, TreeNode b) {
    	if (a == null && b == null) return true;
    	if (a == null || b == null) return false;

    	return (a.val == b.val && TreeSymmetric(a.left, b.right) && TreeSymmetric(a.right, b.left));
    }
}
