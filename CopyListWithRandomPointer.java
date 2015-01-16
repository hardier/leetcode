package leetcode;

import java.util.*;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null)
    		return null;

    	Hashtable<RandomListNode, RandomListNode> map = new Hashtable<RandomListNode, RandomListNode>();
    	
    	RandomListNode origin_now = head;
    	RandomListNode new_now = new RandomListNode(head.label);
    	map.put(head, new_now);
    	while (origin_now.next != null) {
    		RandomListNode tmp = new RandomListNode(origin_now.next.label);
        	new_now.next = tmp;
        	new_now = tmp;
        	origin_now = origin_now.next;
        	map.put(origin_now, new_now);
    	}

    	origin_now = head;
    	new_now = map.get(origin_now);
    	
    	while (origin_now != null) {
    		new_now = map.get(origin_now);
    		if (origin_now.random == null)
    			new_now.random = null;
    		else 
    			new_now.random = map.get(origin_now.random);
    		
    		origin_now = origin_now.next;
    	}

    	return map.get(head);
    }

    public static void main(String args[]) {
    	CopyListWithRandomPointer s = new CopyListWithRandomPointer();
    	
    	RandomListNode a = new RandomListNode(0);
    	RandomListNode b = new RandomListNode(1);
    	RandomListNode c = new RandomListNode(2);
    	RandomListNode d = new RandomListNode(3);
    	RandomListNode e = new RandomListNode(4);

    	a.next = b; b.next = c; c.next = d; d.next = e; e.next = null;
    	a.random = c; b.random = b; c.random = d; d.random = a; e.random = null;
    	
    	RandomListNode ans = s.copyRandomList(a);
    
    	while (ans != null) {
    		System.out.println(ans + " " + ans.next + " " + ans.random + " " + ans.label);
    		ans = ans.next;
    	}
    }
}
