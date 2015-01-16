package leetcode;

public class SumRoottoLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
		int[] res = new int[1];
		int[] now = new int[1];
		
		now[0] = 0;
		res[0] = 0;
		
		build(root, res, now);

    	return res[0];
	
	}

    public void build(TreeNode root, int[] res, int[] now) {
    		if (root != null) {
    			now[0] += root.val;
    			if (root.left == null && root.right == null) {
    				res[0] += now[0];
    			}
    			else {
	    			now[0] *= 10;
	    			build(root.left, res, now);
	    			build(root.right, res, now);
	    			now[0] /= 10;
    			}
    			now[0] -= root.val;
    		}
    }

}
