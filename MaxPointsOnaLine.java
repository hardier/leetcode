package leetcode;

import java.util.*;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnaLine {
    public int maxPoints(Point[] points) {
    	int max = 0;
    	HashMap<Double, Integer> map=new HashMap<Double, Integer>();

    	for (int i = 0; i < points.length; i ++) {
    		int sum = 0;
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1);
    		for (int j = i + 1; j < points.length; j ++) {
    			if (equal(points[i], points[j]) == 1) {
    				sum ++;
    			}
    			else {
    				double key = (points[i].x == points[j].x) ? Integer.MAX_VALUE : 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
    				if (map.containsKey(key)) {
    					map.put(key, map.get(key) + 1);
    				}
    				else {
    					map.put(key, 2);
    				}
    			}
    		}
    		for (int temp: map.values()) {
    			if (temp + sum > max)
    				max = temp + sum;
    		}
    	}
    	return max;
    }

    int equal(Point a, Point b) {
    	if (a.x == b.x && a.y == b.y) return 1;
    	else return 0;
    }
    
}
