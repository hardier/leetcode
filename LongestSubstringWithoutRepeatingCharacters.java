package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	int[] pos = new int[256];
        int now = 0;
        int max = 0;

        for (int i = 0; i < 256; i ++)
        	pos[i] = -1;
        
        for (int i = 0; i < s.length(); i ++) {
        	int c = (int)(s.charAt(i));
        	if (pos[c] < now) {
        		pos[c] = i;
        	}
        	else {
        		max = Math.max(max,  i - now);
        		now = pos[c] + 1;
        		pos[c] = i;
        	}
        }
        
        max = Math.max(max, s.length() - now);
        
        return max;
    }

    public static void main(String args[]) {
    	String st = "a^&";
    	
    	LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
    	
    	System.out.println(s.lengthOfLongestSubstring(st));
    }

}
