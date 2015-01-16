package leetcode;

public class LongestPalindromicString {
    public String longestPalindrome(String s) {
        String res = null;
        int max = 0;
                
        for (int i = 0; i < s.length(); i ++) {
        	//1
        	int j = 0;
        	while ((i - j >= 0) && (i + j < s.length()) && (s.charAt(i-j) == s.charAt(i+j))) {
        		j ++;
        	}
        	j--;
        	if (j * 2 + 1 > max) {
        		max = j * 2 + 1;
        		res = s.substring(i - j, i + j + 1);
        	}

        	//2
        	j = 0;
        	while ((i - j >= 0) && (i + j + 1 < s.length()) && (s.charAt(i-j) == s.charAt(i+j+1))) {
        		j ++;
        	}
        	j --;
        	if ((j + 1) * 2 > max) {
        		max = (j + 1) * 2;
        		res = s.substring(i - j, i + j + 2);
        	}
        	
        }

        return res;
    }

    public static void main(String args[]) {
    	String st = "aabbaacabafq";
    	
    	LongestPalindromicString s = new LongestPalindromicString();
    	
    	System.out.println(s.longestPalindrome(st));
    }

}
