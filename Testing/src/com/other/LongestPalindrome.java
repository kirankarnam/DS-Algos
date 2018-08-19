package com.other;

public class LongestPalindrome {
	
          	  
	//babad
	public String longestPal(String s) {
		if(s == null) return null;
		
		int start = 0;int end=0;
		
		int length = s.length();
		String longest = s.substring(0,1);
		for(int i=0;i<length;i++) {
			String temp = expandAroundCenter(s,i,i);
			
			if(temp.length() > longest.length()) {
				longest = temp;
			}
			temp = expandAroundCenter(s,i,i+1);
			
			if(temp.length() > longest.length()) {
				longest = temp;
			}
			
			
			/*int len = Math.max(len1, len2);
			
			//if len is greater than end-start change start and end based on length
			if(len > end -start) {
				System.out.println("end is"+end);
				System.out.println("start is"+start);
				System.out.println("len is "+len);
				start = i - (len-1)/2;
				end = i+len/2;
				System.out.println("start is -->"+start);
				System.out.println("end is --> "+end);
			}*/
		}
		
		return longest;
	}

	private String expandAroundCenter(String s, int left, int right) {
		int L = left;
		int R = right;
		
		//decrement L and increment R and check for palindrome till the length of the string
		while(L >=0 && R <= s.length()-1 && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		
		//length of palindrome when expanded around center
		return s.substring(L+1, R);
	}

	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		
		System.out.println(lp.longestPal("babad"));
		
		//System.out.println(lp.longestPal("cbbd"));

	}

}
