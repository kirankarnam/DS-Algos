package com.other;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	/**
	 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		 List<Interval> result = new LinkedList<>();
		 int i = 0;
		 //add all interval ending before new interval starts
		 
		 while(i<intervals.size() && intervals.get(i).end < newInterval.start)
			 result.add(intervals.get(i++));
		 
		// merge all overlapping intervals to one considering newInterval
		 
		 while(i<intervals.size() && intervals.get(i).start <=newInterval.end) {
			 newInterval = new Interval(
					 Math.min(intervals.get(i).start, newInterval.start),
					 Math.max(intervals.get(i).end, newInterval.end)
					 );
			 i++;
		 }
		 
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
    }
	
	
	
	
	public class Interval {
	    int start;
	     int end;
	    Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	 }
}


