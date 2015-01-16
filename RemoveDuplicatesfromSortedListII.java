package leetcode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return head;

    	ListNode front = new ListNode(0);
    	front.next = head;
    	boolean same = false;
    	
    	ListNode last = front;
    	ListNode now = head.next;
    	int val = head.val;
    	
    	while (now != null) {
    		if (now.val == val) {
    			last.next = now.next;
    			same = true;
    		}
    		else {
    			if (!same) {
    				last = last.next;
    			}
    			else {
    				same = false;
    			}
    			val = now.val;
    		}
    		now = now.next;
    	}
    	
    	return front.next;
    }
    
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(4);
    	ListNode g = new ListNode(5);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = f;
    	f.next = g;
    	
    	RemoveDuplicatesfromSortedListII s = new RemoveDuplicatesfromSortedListII();
    	
    	ListNode res = s.deleteDuplicates(a);
    	
    	while (res != null) {
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
