package com.strings;

public class KMP {

	public static void main(String[] args) {
	       String txt = "ABABDABACDABABCABAB";
	        String pat = "ABABCABAB";
	        new KMP().kmp_match(txt,pat);

	}

	public void kmp_match(String text,String pattern) {
		if(text==null || pattern ==null) {
			System.out.println("Invalid input");
			return;
		}
		
		int text_Length = text.length();
		int pattern_Length = pattern.length();
		
		
		int[] lps = new int[pattern_Length];
		
		int j=0;
		
		computeLPSArray(pattern,pattern_Length,lps);
		
		for(int i:lps) {
			System.out.print(i);
		}
		
		int i=0;
		
		while(i<text_Length) {
			if(pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			
			if(j==pattern_Length) {
				System.out.println("pattern found at location"+(i-j));
				
				//to find next match for the same string
				j = lps[j-1];
			}
			else if (i<text_Length && pattern.charAt(j) !=text.charAt(i)) {
				if(j!=0)
					j=lps[j-1];
				else
					i=i+1;
			}
		}
		
		
	}

	private void computeLPSArray(String pattern, int pattern_Length, int[] lps) {
		int len = 0;
		
		int i = 1;
		
		lps[0] = 0;
		
		while(i<pattern_Length) {
			
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len != 0) {
					len = lps[len-1];
				}else {
					lps[i] =len;
					i++;
				}
			}
		}
		
	}
}
