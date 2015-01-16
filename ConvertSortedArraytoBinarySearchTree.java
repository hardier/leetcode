package leetcode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
    	int l = 0;
    	int r = num.length - 1;
    	
    	return build(num, l, r);
    	
    }
    
    private TreeNode build(int[] num, int l, int r) {
    	if (l > r) return null;
    	int m = (l + r) / 2;
    	
    	TreeNode root = new TreeNode(num[m]);
    	root.left = build(num, l, m-1);
    	root.right = build(num, m+1, r);
    	
    	return root;
    }
}
