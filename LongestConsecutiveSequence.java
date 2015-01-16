package leetcode;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
    	int res = 0;

    	HashSet<Integer> arr = new HashSet<Integer>();
    	for (int i:num) arr.add(i);

    	for (int i = 0; i < num.length; i ++) {
    		int now = 0;
    		
    		if (arr.contains(num[i])) {
    			now = 1;
    			if (arr.contains(num[i]-1) == false) {
    				while (arr.contains(num[i] + now)) now ++;
    			}
    		}
    		
    		res = Math.max(now, res);
    	}

    	return res;
    }
}
