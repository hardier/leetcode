package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int carry = 1;
    	for (int i = digits.length - 1; i >= 0; i --) {
    		digits[i] = digits[i] + carry;
    		if (digits[i] > 9) {
    			digits[i] -= 10;
    			carry = 1;
    		}
    		else {
    		    carry = 0;
    		}
    	}
    	
    	if (carry == 0) return digits;

    	int[] res = new int[digits.length + 1];
    	res[0] = 1;
    	for (int i = 1; i < res.length; i ++) {
    		res[i] = 0;
    	}
    	return res;
    }
}
