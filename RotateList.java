package leetcode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
    	ListNode now = head;
    	ListNode prev = new ListNode(0);
    	
    	prev.next = head;
    	if (head == null) return null;
    	int len = 1;
    	
    	while (now.next != null){
    		len ++;
    		now = now.next;
    	}

    	if (n==0) return prev.next;
    	
    	now.next = head;
    	n = n % len;
       	now = head;
       	ListNode tmp = now;
   		n = len - n;
   		for (int i = 0; i < n; i ++) {
   			tmp = now;
   			now = now.next;
   		}
    		
   		tmp.next = null;
   		prev.next = now;
    	
    	return prev.next;
    }

    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	ListNode e = new ListNode(5);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	
    	RotateList s = new RotateList();
    	
    	ListNode ans = s.rotateRight(a,  0);
    	
    	while (ans != null) {
    		System.out.println(ans.val);
    		ans = ans.next;
    	}
    }
    
}
