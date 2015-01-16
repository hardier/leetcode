package leetcode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        if (head == null || m == n) return head;
        
        ListNode prev = res;
        //find head
        for (int i = 1; i < m; i ++) {
        	prev = prev.next;
        }
        
        head = prev.next;
        ListNode now = head;
        ListNode next = now.next;

        for (int j = 0; j < n - m; j ++) {
        	ListNode tmp = next.next;
        	next.next = now;
        	now = next;
        	next = tmp;
        }
        
        prev.next = now;
        head.next = next;
        
        return res.next;
    }
    
    public static void main(String[] args) {
    	ReverseLinkedListII s = new ReverseLinkedListII();
    	
    	ListNode a = new ListNode(0);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(3);
    	ListNode e = new ListNode(4);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	
    	ListNode res = s.reverseBetween(a,  1,  5);

    	while (res!=null) {
    		System.out.println(res.val);
    		res = res.next;
    	}
    }
}
