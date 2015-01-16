package leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	int s_len = s.length();
    	int p_len = p.length();
    	int now_s = 0, now_p = 0;

    	
    	
    	return true;
    }

    public static void main(String args[]) {
    	String a = "abc";
    	String b = "ababbabcaa";
    	RegularExpressionMatching s = new RegularExpressionMatching();
    	System.out.println(s.isMatch(a, b));
    }
}
