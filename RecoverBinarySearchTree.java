package leetcode;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
    public void recoverTree1(TreeNode root) {
    	TreeNode n1 = null;
    	TreeNode n2 = null;
    	TreeNode now = root;
    	TreeNode pre = null, last = null;
    	boolean found = false;
    	
    	if (root == null) return;
    	
    	while (now != null) {
    		if (now.left == null) {
    			if (last != null && last.val > now.val) {
    				if (!found) {
    					n1 = last;
    					n2 = now;
    					found = true;
    				}
    				else {
    					n2 = now;
    				}
    			}
    			last = now;
    			now = now.right;
    		}
    		else {
//    			last = now;
    			pre = now.left;
    			while (pre.right != null && pre.right != now) {
    				pre = pre.right;
    			}
    			
    			if (pre.right == null) {
    				pre.right = now;
    				now = now.left;
    			}
    			else {
        			if (last != null && last.val > now.val) {
        				if (!found) {
        					n1 = last;
        					found = true;
        				}
        				else {
        					n2 = now;
        				}
        			}

    				pre.right = null;
    				last = now;
    				now = now.right;
    			}
    			
    		}
    		
    	}

    	if (n1!=null && n2!=null) {
	    	int tmp = n1.val;
	        n1.val = n2.val;
	        n2.val = tmp;
    	}

    }

    
    public void recoverTree(TreeNode root) {
    	TreeNode now = root;
    	TreeNode pre = null;
    	TreeNode n1 = null;
    	TreeNode n2 = null;
    	TreeNode last = null;
    	boolean find = false;
    	
    	while (now != null) {
    		if (now.left == null) {
    			if (last!=null && last.val > now.val){
    				if (!find) {
    					find = true;
    					n1 = last;
    				}
    				n2 = now;
    			}
    			last = now;
    			now = now.right;
    		}
    		else {
    			pre = now.left;
    			while (pre.right != null && pre.right != now) {
    				pre = pre.right;
    			}
    			
    			if (pre.right == null) {
    				pre.right = now;
    				now = now.left;
    			}
    			else {
    				if (last!= null && last.val > now.val) {
    					if (!find) {
    						find = true;
    						n1 = last;
    					}
   						n2 = now;
    				}
    				last = now;
    				now = now.right;
    				pre.right = null;
    			}
    		}
    	}

    	if (n1!=null && n2!=null) {
    		int val = n1.val;
    		n1.val = n2.val;
    		n2.val = val;
    	}
    }
    
    public ArrayList<Integer> inorderTraversal1(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	TreeNode now = root;
    	TreeNode pre;
    	while (now != null) {
    		if (now.left == null) {
    			res.add(now.val);
    			now = now.right;
    		}
    		else {
    			pre = now.left;
    			while (pre.right != null && pre.right != now) {
    				pre = pre.right;
    			}
    			
    			if (pre.right == null) {
    				pre.right = now;
    				now = now.left;
    			}
    			else { //recover
    				pre.right = null;
        			res.add(now.val);
    				now = now.right;
    			}
    		}
    		
    	}
    	
    	return res;
    }

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	traverse(root, res);
    	
    	return res;
    }
        
    public void traverse(TreeNode root, ArrayList<Integer> res) {
    	if (root == null) return;
    	traverse(root.left, res);
    	res.add(root.val);
    	traverse(root.right, res);
    }

    public static void main(String[] args) {
    	TreeNode a2 = new TreeNode(2);
    	TreeNode a1 = new TreeNode(1);
    	TreeNode a0 = new TreeNode(0);
    	
    	a2.left = a0;
    	a0.left = a1;
    	
    	RecoverBinarySearchTree s = new RecoverBinarySearchTree();
    	ArrayList<Integer> b = s.inorderTraversal(a0);
    	System.out.println(b);

    	System.out.println();
    	s.recoverTree(a0);
    	b = s.inorderTraversal(a0);
    	System.out.println(b);
    	
    }
}
