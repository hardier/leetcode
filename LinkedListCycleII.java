package leetcode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = slow;
    	
    	if (head == null) return null;

    	while (true) {
    		if (fast.next == null || fast.next.next == null)
    			return null;
    		fast = fast.next.next;
    		slow = slow.next;
    		if (slow == fast){
    			break;
    		}
    	}

    	slow = head;
    	while (slow != fast) {
    		slow = slow.next;
    		fast = fast.next;
    	}

    	return slow;
    
    }

}
