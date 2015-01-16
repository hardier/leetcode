package leetcode;

public class ReorderList {
    public void reorderList(ListNode head) {
    	int n = 0;
    	ListNode now = head;
    	
    	while (now != null) {
    		n++;
    		now = now.next;
    	}

    	if (n < 3) return;

    	now = head;
    	for (int i = 0; i < (n-1)/2; i ++)
    		now = now.next;

    	ListNode first_tail = now;
       	now = now.next;
       	first_tail.next = null;
       	
       	ListNode last = null;
    	while (now != null) {
    		ListNode tmp = now.next;
    		now.next = last;
    		last = now;
    		now = tmp;
    	}

    	
    	now = head;

    	while (last != null) {
    		ListNode tmp1 = now.next;
    		ListNode tmp2 = last.next;

    		now.next = last;
    		last.next = tmp1;
    		last = tmp2;
    		now = tmp1;
    		
    	}
    }

    public static void main(String[] args) {
    	ReorderList s = new ReorderList();
    	
    	ListNode a = new ListNode(0);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(3);
    	ListNode e = new ListNode(4);
    	ListNode f = new ListNode(5);

    	a.next = b; b.next = c; c.next = d; d.next = e; e.next = null; f.next = null;

    	s.reorderList(a);
    	
    	while (a != null) {
    		System.out.println(a.val);
    		a = a.next;
    	}
    }
    
}
