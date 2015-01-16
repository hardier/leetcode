package leetcode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = slow;

    	if (head == null) return false;

    	while (true) {
    		if (fast.next == null || fast.next.next == null)
    			return false;
    		fast = fast.next.next;
    		slow = slow.next;
    		if (slow == fast) return true;
    	}
    	
    }

}
