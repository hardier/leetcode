package leetcode;

import java.util.*;

public class ConstructBinaryTreefromInorderandPostOrderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    	for (int i = 0; i < inorder.length; i ++)
    		inorderMap.put(inorder[i], i);
    	   	return build(inorderMap, inorder, postorder, inorder.length, 0, 0);
    }
    
    public TreeNode build(Map<Integer, Integer> inorderMap, int[] inorder, int[] postorder, int len, int start_inorder, int start_postorder) {

    	if (len <= 0) return null;

    	TreeNode now = new TreeNode(0);
    	
    	now.val = postorder[start_postorder + len - 1];

    	int pos = inorderMap.get(now.val);

    	now.left = build(inorderMap, inorder, postorder, pos - start_inorder, start_inorder, start_postorder);
    	now.right = build(inorderMap, inorder, postorder, start_inorder + len - pos - 1, pos + 1, start_postorder + pos - start_inorder);

    	return now;
    }
    
}
