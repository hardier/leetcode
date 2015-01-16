package leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(0);
        ListNode now = head;

        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		now.next = l1;
        		l1 = l1.next;
        		now = now.next;
        	}
        	else {
        		now.next = l2;
        		l2 = l2.next;
        		now = now.next;
        	}
        }
        
        if (l1 == null) now.next = l2;
        else if (l2 == null) now.next = l1;
        
        return head.next;
    }
    
    public static void main(String[] args) {
    	MergeTwoSortedLists s = new MergeTwoSortedLists();
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(3);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(4);
    	a.next = b;
    	c.next = d;
    	
    	
    	ListNode e = s.mergeTwoLists(a, null);
    	
    	while (e!=null) {
    		System.out.println(e.val);
    		e = e.next;
    	}
    	
    }
}
