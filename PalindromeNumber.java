package leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	int y = 0;
    	int num = x;

    	if (x < 0) return false;
    	while (x > 9) {
    		y = y * 10 + x % 10;
    		x /= 10;
    	}

    	return (num/10 == y);
    }
    
    public static void main(String args[]) {
    	int a = 2147412;
    	PalindromeNumber s = new PalindromeNumber();
    	
    	System.out.println(s.isPalindrome(a));
    	
    }
    
}
