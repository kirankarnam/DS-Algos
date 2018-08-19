package com.strings;

import java.util.HashSet;

public class LongestSubstringNoRepeat {
	
	public int LongestSubstring(String s) {
		if(s==null) return 0;
		int length = s.length();
		if(length ==0) return 0;
		int maxLength = 0;
		
		HashSet<Character> set =  new HashSet<>();
		
		int i=0;
		int j=0;
		
		while(j<length) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				maxLength = Math.max(maxLength, j-i);
			}else {
				set.remove(s.charAt(i));
				i++;
				
			}
		}
		return maxLength;
	}
	
	public static void main(String args[]) {
		LongestSubstringNoRepeat lsnr = new LongestSubstringNoRepeat();
		
		System.out.println("longest substring of pwwkew is  -->"+lsnr.LongestSubstring("pwwkew")); 
		System.out.println("longest substring of bbbbb is  -->"+lsnr.LongestSubstring("bbbbb")); 
		System.out.println("longest substring of abcabcbb is  -->"+lsnr.LongestSubstring("abcabcbb")); 
	}

}
