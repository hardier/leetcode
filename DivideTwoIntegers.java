package leetcode;

public class DivideTwoIntegers {
    /**
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int res = 0;
        int s1 = (divisor > 0) ? 1 : -1;
        int s2 = (dividend > 0) ? 1 : -1;
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE - divisor + 1;
            res = 1;
        }

        while (dividend > 0) {
        	int q = divisor;
        	
        	while ((q << 1) > 0 && dividend > (q << 1)) {
        		q <<= 1;
        	}
        	dividend -= q;
        	res += (q / divisor);
        }
                
        if (dividend < 0) res --;
        
        return res * s1 * s2;
    }

    public static void main(String[] args) {
/*    	
    	int aa = 2147483647;
    	int bb = aa + 1;
    	System.out.println(bb);
    	System.out.println(Math.abs(aa));
    	while (1==1){
    	
    	}
*/    	
    	DivideTwoIntegers s = new DivideTwoIntegers();
    	int res = s.divide(-2147483648, 2);
    	
    	System.out.println(res);
    }
}
