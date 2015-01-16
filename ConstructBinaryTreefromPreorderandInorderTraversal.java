package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    	for (int i = 0; i < inorder.length; i ++)
    		inorderMap.put(inorder[i], i);
       	return build(inorderMap, preorder, inorder.length, 0, 0);
    }
    
    public TreeNode build(Map<Integer, Integer> inorderMap, int[] preorder, int len, int start_inorder, int start_preorder) {

    	if (len <= 0) return null;

    	TreeNode now = new TreeNode(0);
    	
    	now.val = preorder[start_preorder];

    	int pos = inorderMap.get(now.val);

    	now.left = build(inorderMap, preorder, pos - start_inorder, start_inorder, start_preorder + 1);
    	now.right = build(inorderMap, preorder, start_inorder + len - pos - 1, pos + 1, start_preorder + pos - start_inorder + 1);

    	return now;
    }

    public static void main(String[] args) {
    	int[] a = {1, 2};
    	int[] b = {2, 1};
    	
    	ConstructBinaryTreefromPreorderandInorderTraversal s = new ConstructBinaryTreefromPreorderandInorderTraversal();
    	s.buildTree(a,  b);
    }
    
}
