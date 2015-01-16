package leetcode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);

        return MergeSortList(slow, fast);
    }

    public ListNode MergeSortList(ListNode slow, ListNode fast) {
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	
    	while (slow != null && fast != null) {
    		if (slow.val < fast.val) {
    			cur.next = slow;
    			slow = slow.next;
    		}
    		else {
    			cur.next = fast;
    			fast = fast.next;
    		}
    		cur = cur.next;
    	}
    	if (slow != null)
    		cur.next = slow;
    	else if (fast != null)
    		cur.next = fast;
    	
    	return head.next;
    }
    
	
    public static void main(String[] args) {

    	SortList s = new SortList();

    	ListNode a = new ListNode(0);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(1);
    	ListNode d = new ListNode(2);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(5);

    	a.next = b; b.next = c; c.next = null; d.next = null; e.next = null; f.next = null;

    	ListNode now = s.sortList(a);
    	
    	while (now != null) {
    		System.out.println(now.val);
    		now = now.next;
    	}

    }
}
