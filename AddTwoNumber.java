package leetcode;

import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(ArrayList<Integer> a) {
    	if (a.size() == 1) {
    		val = a.get(0);
    		next = null;
    	}
    	else {
    		val = a.get(0);
    		a.remove(0);
    		next = new ListNode(a);
    	}
    }
}

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int carry = 0;
    	ListNode head = new ListNode(0);
    	ListNode now = head;
    	
    	while (l1!=null || l2!=null) {

    		ListNode tmp = new ListNode(carry);
    		tmp.val += (get_value(l1) + get_value(l2));
    		l1 = get_next(l1);
    		l2 = get_next(l2);
    		
			carry = tmp.val / 10;
			tmp.val %= 10;
    		
			now.next = tmp;
 			now = now.next;
    	}
    	
    	if (carry!=0) {
    		ListNode tmp = new ListNode(carry);
    		now.next = tmp;
    	}
    	
    	return head.next;
    }

    public int get_value(ListNode l) {
    	if (l == null) return 0;
    	else return l.val;
    }
    
    public ListNode get_next(ListNode l) {
    	if (l == null) return null;
    	else return l.next;
    }
    
	public static void main (String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(1);
			a.add(2);
			a.add(3);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
			b.add(9);
			b.add(8);
			b.add(9);
		
		ListNode l1 = new ListNode(a);
		ListNode l2 = new ListNode(b);

		AddTwoNumber s = new AddTwoNumber();

		ListNode l3 = s.addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
		

	}

}
