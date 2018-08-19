package com.strings;

public class LongestCommPrefix {
	
	
	//complexity is O(s) in worst case if all the strings in the array are same
	public String LCP(String[] input) {
		if(input == null || input.length ==0) {
			return "";
		}
		
		String LongestCommonPrefix = input[0];
		int length = input.length;
		
		for(int i=1;i<length;i++) {
			int j=0;
			String nextString = input[i];
			
			int currentLength = nextString.length();
			int lcpLength = LongestCommonPrefix.length();
			while( j < lcpLength && j < currentLength && nextString.charAt(j) == LongestCommonPrefix.charAt(j) ) {
				j++;
			}
			if(j==0)
				return "No LCP Found";
			
			LongestCommonPrefix = nextString.substring(0, j);
			
		}
		
		return LongestCommonPrefix;
	}

	public static void main(String[] args) {
		LongestCommPrefix lcp = new LongestCommPrefix();
		
		String[] input = {"aaab","aab","abaa","bcaa"};
		
		System.out.println(lcp.LCP(input));

	}

}
