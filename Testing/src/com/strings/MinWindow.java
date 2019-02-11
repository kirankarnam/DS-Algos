package com.strings;

public class MinWindow {

	public static void main(String[] args) {
		MinWindow mw = new MinWindow();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(mw.minWindow(s, t));

	}

	/**
	 * needs a map and two pointers left and right 
	 * compare the value and see if its greater than 0 then decrement the counter
	 * check to see if the counter is 0
	 * 		if 0 then compare res length since we have to return the min window
	 * 			if res is greater update the res value and update begin
	 * 			increment left and also increment the counter
	 * 
	 * return the string between res and res+begin
	 * @param s
	 * @param t
	 * @return
	 */
	
	public String minWindow(String s,String t) {
		if(s.isEmpty() || t.isEmpty()|| s ==null || t ==null)
			return "";
		int[] map = new int[256];
		int res = Integer.MAX_VALUE;
		int left=0,right=0,begin=0, counter=t.length();
		
		for(int i=0;i<t.length();i++) {
			map[t.charAt(i)-'A']++;
		}
		int sLength = s.length();
		while(right < sLength) {
			if(map[s.charAt(right++) - 'A']-- > 0)
				counter--;
			while(counter ==0) {
				if(right-left <res) {
					res = right-left;
					begin = left;
				}
				
				if(map[s.charAt(left++) - 'A']++ == 0)
					counter++;
			}
		}
		return res==Integer.MAX_VALUE?"":s.substring(begin, begin+res);
	}
}
