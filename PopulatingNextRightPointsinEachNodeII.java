package leetcode;

public class PopulatingNextRightPointsinEachNodeII {
    public void connect(TreeLinkNode root) {
    	if (root == null) return;
    	root.next = null;

    	TreeLinkNode left = root;
    	TreeLinkNode prev = null;

    	while (left != null) {
    		TreeLinkNode new_left = null;
    		TreeLinkNode tmp = null;
    		int cur = 0;

    		while (left != null) {
    			//find next valid branch
    			if (cur == 0) //left
    				tmp = left.left;
    			else {
    				tmp = left.right;
    				left = left.next;
    			}
    			cur = cur ^ 1;
	    		
    			if (tmp != null) {
    				if (new_left == null)
    					new_left = tmp;
    				else 
    					prev.next = tmp;
	    			prev = tmp;
	    			prev.next = null;
    			}
    		}
    		
    		left = new_left;
    	}
    	
    }

}
