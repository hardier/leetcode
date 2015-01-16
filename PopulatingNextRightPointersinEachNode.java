package leetcode;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}


public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
    	if (root == null) return;
    	root.next = null;
    	build(root);
    }

    public void build(TreeLinkNode root) {
    	if (root == null) return;
    	if (root.left != null) {
    		root.left.next = root.right;
    		if (root.next != null)
    			root.right.next = root.next.left;
        	build(root.left);
        	build(root.right);
    	}
    }
}
