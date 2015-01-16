package leetcode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode now_small = small;
        ListNode now_large = large;
        
        while (head != null) {
        	if (head.val < x) {
        		now_small.next = head;
        		now_small = now_small.next;
        	}
        	else {
        		now_large.next = head;
        		now_large = now_large.next;
        	}
        	head = head.next;
        }
        
        now_small.next = large.next;
        now_large.next = null;
        
        return small.next;
    }
	
    public static void main(String[] args) {
    	ListNode a = new ListNode(5);
    	ListNode b = new ListNode(7);
    	ListNode c = new ListNode(2);
    	ListNode d = new ListNode(1);
    	ListNode e = new ListNode(5);
    	ListNode f = new ListNode(6);
    	ListNode g = new ListNode(4);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = f;
    	f.next = g;
    	
    	PartitionList s = new PartitionList();
    	
    	ListNode res = s.partition(a, 100);
    	
    	while (res != null) {
    		System.out.println(res.val);
    		res = res.next;
    	}
    }

}
