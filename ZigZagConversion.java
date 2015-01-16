package leetcode;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	String res = "";
    	if (nRows == 1) return s;

    	int n = s.length();
//    	System.out.println(n);
    	
    	//line 0
    	int pos = 0;
    	while (pos < n) {
    		res += s.charAt(pos);
    		pos += 2 * (nRows - 1);
    	}

//    	System.out.println(res);
    	
    	//line 1 ~ n-1
    	for (int row = 1; row < nRows - 1; row ++) {
    		pos = row;
			while (pos < n) {
    			res += s.charAt(pos);
    			pos += (2 * (nRows-1) - (2 * row));
    			if (pos < n) {
    				res += s.charAt(pos);
    				pos += (2 * row);
    			}
    		}
    	}
    	
    	//last line
    	pos = nRows - 1;
    	while (pos < n) {
    		res += s.charAt(pos);
    		pos += 2 * (nRows - 1);
    	}

    	return res;
    }

    public static void main(String args[]) {
    	String st = "01234";
    	ZigZagConversion s = new ZigZagConversion();
    	
    	System.out.println(st);
    	System.out.println(s.convert(st, 4));
    }

}
