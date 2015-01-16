package leetcode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        build(root);    
    }

    public TreeNode build(TreeNode root) {
    	if (root == null) return null;
    	
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	
    	if (left != null) {
    		root.right = root.left;
    		root.left = null;

    		left = build(left);
    		left.right = right;
    	}
    	
    	if (right != null) {
    		right = build(right);
    		return right;
    	}

    	if (left != null)
    		return left;
    	
    	return root;    	
    }

    
    public TreeNode build1(TreeNode root) {
    	if (root == null) return null;
    	
    	TreeNode left = build(root.left);
    	if (left != null) {
    		left.right = root.right;
    	}
    	
    	TreeNode right = build(root.right);
    	if (root.left != null)
    		root.right = root.left;

    	if (right == null) return root;
    	else return right;
    }
}
