package leetcode;

import java.util.*;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
    	int max = 0;
    	Stack<Entry> res = new Stack<Entry>();
    	
    	for (int i = 0; i < height.length; i ++) {
    		if (res.empty() || height[i] > res.peek().height) {
    			res.push(new Entry(height[i], 1));
    		}
    		else if (res.peek().height > height[i]) {
    			int size = 0;
    			while (!res.empty() && res.peek().height >= height[i]) {
    				Entry now = res.pop();
    				size += now.width;
    				max = Math.max(max, now.height * size);
    			}    			
    			res.push(new Entry(height[i], size + 1));
    		}
    		else {
    			Entry now = res.pop();
    			now.width++;
    			res.push(now);
    		}
    	}
    	
    	int size = 0;
    	while (!res.empty()) {
    		Entry now = res.pop();
    		size += now.width;
			max = Math.max(max, now.height * size);
    	}
    	return max;
    }
    
    class Entry {
    	int height;
    	int width;
    	
    	Entry (int h, int w) {
    		height = h;
    		width = w;
    	}
    }
    
	public int largestRectangleArea1(int[] height) {
    	int max = 0;
    	
    	if (height.length == 0) return 0;
    	
    	ArrayList<Integer> stack = new ArrayList<Integer>();
    	ArrayList<Integer> width = new ArrayList<Integer>();
    	
    	stack.add(height[0]);
    	width.add(1);
    	
    	for (int i = 1; i < height.length; i ++) {
    		if (height[i] > stack.get(stack.size() - 1)) {
    			stack.add(height[i]);
    			width.add(1);
    		}
    		else if (height[i] < stack.get(stack.size() - 1)) {
    			int w = 0;
    			int now;
    			while (!stack.isEmpty() && stack.get(stack.size() - 1) > height[i]) {
    				now = stack.remove(stack.size() - 1);
    				w += width.remove(width.size() - 1);
    				if (now * w > max) max = now * w;
    			}

   				stack.add(height[i]);
   				width.add(w + 1);
    		}
    		else {
    			int size = width.remove(width.size() - 1) + 1;
    			width.add(size);
    		}
    	}

		int w = 0;
		int now;
		while (!stack.isEmpty() && stack.get(stack.size() - 1) > 0) {
			now = stack.remove(stack.size() - 1);
			w += width.remove(width.size() - 1);
			if (now * w > max) max = now * w;
		}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	int[] a = {1,2,3,2,2,1,1};
    	
    	LargestRectangleinHistogram s = new LargestRectangleinHistogram();
    	
    	System.out.println(s.largestRectangleArea(a));
    }
}
