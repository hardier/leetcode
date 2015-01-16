package leetcode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {

    	if (head == null) return null;
    	ListNode sort_head = new ListNode(0);

    	sort_head.next = head;

    	ListNode unsort_head = head.next;
    	head.next = null;
    	
    	while (unsort_head != null) {
    		ListNode tmp = sort_head;
    		
    		while (tmp.next != null && tmp.next.val < unsort_head.val) {
    			tmp = tmp.next;
    		}
    		
    			ListNode t = tmp.next;
    			tmp.next = unsort_head;
    			unsort_head = unsort_head.next;
    			tmp.next.next = t;    		
    		
    	}
    	
    	return sort_head.next;
    }

    public static void main(String[] args) {
    	InsertionSortList s = new InsertionSortList();
    	
    	ListNode a = new ListNode(2);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	
    	a.next = b; b.next = null; c.next = d; d.next = e; e.next = null;
    	
    	ListNode ans = s.insertionSortList(a);

    	while (ans != null) {
    		System.out.println(ans.val);
    		ans = ans.next;
    	}
    }

}
