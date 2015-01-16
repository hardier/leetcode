package leetcode;

import java.util.*;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        int head_pos = 0, tail_pos = 0;
        int l = 0, r = intervals.size() - 1, m;
        
        //1. find head_pos, last entry with .end < newInterval.start
        while (l <= r) {
        	m = (l + r) / 2;
        	if (intervals.get(m).end < newInterval.start) l = m + 1;
        	else if (intervals.get(m).end >= newInterval.start) r = m - 1;
        }
        
        head_pos = l;
        //2. find tail_pos, first entry with .start > newInterval.end
        l = head_pos; r = intervals.size() - 1;
        while (l <= r) {
        	m = (l + r) / 2;
        	if (intervals.get(m).start <= newInterval.end) l = m + 1;
        	else if (intervals.get(m).start > newInterval.end) r = m - 1;
        }
        
        tail_pos = l;
        
        //3. merge
        for (int i = 0; i < head_pos; i ++) {
        	res.add(intervals.get(i));
        }
        
        if (head_pos == tail_pos) {
        	res.add(new Interval(newInterval.start, newInterval.end));
        }
        else {
        	if (newInterval.start > intervals.get(head_pos).start) newInterval.start = intervals.get(head_pos).start;
        	if (newInterval.end < intervals.get(tail_pos - 1).end) newInterval.end = intervals.get(tail_pos - 1).end;
        	res.add(new Interval(newInterval.start, newInterval.end));
        }
        
        for (int i = tail_pos; i < intervals.size(); i ++) {
        	res.add(intervals.get(i));
        }
        return res;
    }
    
	 public static void main(String[] args) {
		 Interval a = new Interval(1, 3);
		 Interval b = new Interval(7, 9);
		 Interval c = new Interval(11, 15);
		 Interval d = new Interval(9, 19);

		 ArrayList<Interval> n = new ArrayList<Interval>();
		 n.add(a);
		 n.add(b);
		 n.add(c);
		 
		 InsertInterval s = new InsertInterval();
		 
		 ArrayList<Interval> m = s.insert(n, d);
		 
		 for (int i = 0; i < m.size(); i ++) {
			 System.out.println(m.get(i).start + " " + m.get(i).end);
		 }
		 
	 }

}
