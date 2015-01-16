package leetcode;

import java.util.*;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        ans.add(0);
        if (n == 0) return ans;

        for (int i = 0; i < n; i ++) {
        	int len = 1 << i;
        	
        	for (int j = 0; j < len; j ++) {
        		int now = ans.get(len - j - 1);
        		ans.add(now + len);
        	}
        	
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
    	GrayCode s = new GrayCode();
    	
    	System.out.println(s.grayCode(3));
    }
}
