package com.arrays;

import java.util.Stack;

public class MaxRectangle {

	public static void main(String[] args) {
		MaxRectangle mr = new MaxRectangle();
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.println(mr.maxArea(hist));

	}
	
	public int maxArea(int[] hist) {
		
		if(hist ==null) return 0;
		
		int max=0;
		int temp;
		int length = hist.length;
		int area;
		
		Stack<Integer> s = new Stack<Integer>();
		int i=0;
		while(i<length) {
			
			if(s.isEmpty() || hist[i] >= hist[s.peek()]) {
				s.push(i++);
			}else {
				temp = s.peek();
				s.pop();
				area = hist[temp] * (s.isEmpty()?i : i-s.peek()-1);
				
				if(area> max) {
					max = area;
				}
			}
		}
		
		while(s.empty() !=false) {
			temp = s.peek();
			s.pop();
			
			area = hist[temp] * (s.isEmpty()? i : i - s.peek() -1);
			
			if(area > max)
				max = area;
		}
		
		return max;
	}

}
