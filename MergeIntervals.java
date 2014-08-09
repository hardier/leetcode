package leetcode;

import java.util.*;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}


public class MergeIntervals {
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 ArrayList<Interval> res = new ArrayList<Interval>();
				 
		 Collections.sort(intervals, new Comparator<Interval>() { //**Compile Error here.**

             @Override
             public int compare(Interval n1, Interval n2) {
                 return n1.start - n2.start;
             }
		 });
		 
	     if (intervals.size() == 0) return res;
	     
    	 Interval now = intervals.remove(0);

    	 while (intervals.size() > 0) {
    		 Interval tmp = intervals.remove(0);
    		 
    		 if (now.end >= tmp.start) {
    			 if (tmp.end > now.end) {
    				 now.end = tmp.end;
    			 }
    		 }
    		 else {
    			 res.add(new Interval(now.start, now.end));
    			 now.start = tmp.start;
    			 now.end = tmp.end;
    		 }
    		 
    	 }
    	 
		 res.add(new Interval(now.start, now.end));
	     
	     return res;
	 }	
	 

	 public class CustomComparator implements Comparator<Interval> {
		    @Override
		    public int compare(Interval n1, Interval n2) {
    			 return n1.start - n2.start;
		    }
	 }

	 public static void main(String[] args) {
		 Interval a = new Interval(1, 3);
		 Interval b = new Interval(2, 4);
		 Interval c = new Interval(6, 7);

		 ArrayList<Interval> n = new ArrayList<Interval>();
		 n.add(c);
		 n.add(b);
		 n.add(a);
		 
		 MergeIntervals s = new MergeIntervals();
		 
		 ArrayList<Interval> m = s.merge(n);
		 
		 for (int i = 0; i < m.size(); i ++) {
			 System.out.println(m.get(i).start + " " + m.get(i).end);
		 }
		 
	 }
}
