package leetcode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return head;
    	
    	ListNode now = head.next;
    	ListNode prev = head;
    	int val = head.val;
    	
    	while (now != null) {
    		if (now.val == val) {
    			prev.next = now.next;
    		}
    		else {
    			val = now.val;
    			prev = now;
    		}
    		now = now.next;
    	}
    	
    	return head;
    }
    
    
    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(3);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(4);
    	ListNode g = new ListNode(5);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = f;
    	f.next = g;
    	
    	RemoveDuplicatesfromSortedList s = new RemoveDuplicatesfromSortedList();
    	
    	ListNode res = s.deleteDuplicates(a);
    	
    	while (res != null) {
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
