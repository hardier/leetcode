package leetcode;

public class ConvertSortedListtoBinarySearchTree {
	static ListNode lhead;
	public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode now = head;
        int n = 0;
        while (now.next != null) {
        	now = now.next;
        	n ++;
        }
    
        lhead = head;
//        return build(head, 0, n);
        return build(0, n);
    }

    public TreeNode build(int l, int r) {
    	if (lhead == null || l > r) return null;
    	
    	TreeNode root = new TreeNode(lhead.val);
    	int m = (l + r) / 2;
    	root.left = build(l, m - 1);
    	root.val = lhead.val;
    	lhead = lhead.next;
    	root.right = build(m + 1, r);
    	
    	return root;
    }

    public TreeNode build1(ListNode head, int l, int r) {
    	if (head == null || l > r) return null;
    	
    	TreeNode root = new TreeNode(head.val);
    	System.out.println(head.val);
    	int m = (l + r) / 2;
    	head = head.next;
    	root.left = build1(head, l, m - 1);
    	root.right = build1(head, m + 1, r);
    	
    	return root;
    }

    public static void main(String[] args) {
    	ConvertSortedListtoBinarySearchTree s = new ConvertSortedListtoBinarySearchTree();
    	
    	ListNode a0 = new ListNode(0);
    	ListNode a1 = new ListNode(1);
    	ListNode a2 = new ListNode(2);
    	ListNode a3 = new ListNode(3);
    	ListNode a4 = new ListNode(4);
    	
    	a0.next = a1;
    	a1.next = a2;
    	a2.next = a3;
    	a3.next = a4;
    	
    	s.sortedListToBST(a2);
    }
}
